package com.aek.ebey.repair.core.scheduled;

import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aek.common.core.Result;
import com.aek.common.core.base.BaseController;
import com.aek.ebey.repair.model.RepairData;
import com.aek.ebey.repair.model.vo.RepairDataMonthVo;
import com.aek.ebey.repair.request.SevenDataResponse;
import com.aek.ebey.repair.request.SevenQuery;
import com.aek.ebey.repair.service.RepRepairApplyService;
import com.aek.ebey.repair.service.ribbon.DataClientService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

/**
 * 维修统计数据定时任务
 *	
 * @author HongHui
 * @date   2018年4月17日
 */
@Component
@RestController
@RequestMapping("/newrepair/RepairDataScheduledTask")
@Api(value = "RepairDataScheduledTask", description = "RepairDataScheduledTask")
public class RepairDataScheduledTask extends BaseController{

    private static final Logger logger = LoggerFactory.getLogger(RepairDataScheduledTask.class);
    
    //维修自动验收Lock
    private static final Lock repairCheckLock = new ReentrantLock();
    
    @Autowired
    private RepRepairApplyService repRepairApplyService;
    @Autowired
    private DataClientService dataClientService;
    
    /**
     * 每天凌晨统计维修概览数据
     */
    @Scheduled(cron = "0 0 0 * * ?")
    //@Scheduled(cron="0/50 * *  * * ? ") 
    public void countRepairDataByDay() {
        logger.info("=================获取维修概览数据=================");
        //获取维修概览数据
        List<RepairData> repairData =  repRepairApplyService.getRepairData();
        //调用统计服务将数据保存至统计服务
        dataClientService.addRepairData(repairData);
    }
    
    /**
     * 每天凌晨统计维修月度数据
     */
    @Scheduled(cron = "0 0 0 * * ?")
    //@Scheduled(cron="0/50 * *  * * ? ") 
    public void countRepairDataMonthByDay(){
        logger.info("=================获取维修月度数据=================");
        //获取维修月度数据
        List<RepairDataMonthVo> repairDataMonthList = repRepairApplyService.getRepairDataMonthByDay();
        dataClientService.addRepairDataMonth(repairDataMonthList);
    }
    
    /**
     * 定时统计Apply
     */
    @Scheduled(cron="0 0 1 7 * ?") 
    //@Scheduled(cron="0/50 * *  * * ? ") 
    public void autoCountApply() throws Exception{
        List<SevenDataResponse> list=repRepairApplyService.countApply(new SevenQuery());
        dataClientService.pushSevenData(list);
    }
    
    /**
     * 定时统计PM
     */
	@GetMapping(value = "/historySevenData") 
	@ApiOperation(value = "Qc设备统计")
	@ApiResponse(code = 200, message = "OK", response = Result.class)
    public Result<List<SevenDataResponse>> SevenData(SevenQuery query) throws Exception {
		List<SevenDataResponse> list=repRepairApplyService.countApply(query);
        if(null != list && list.size() > 0) {
        	dataClientService.pushSevenData(list);
        }
        return response(list);
    }
	
    /**
     * 定时验收
     */
    @Scheduled(cron="0/50 * *  * * ? ")  
    public void autoCheck() throws Exception{
        repairCheckLock.lock();
        try {
            repRepairApplyService.autoCheck();
        } finally {
            repairCheckLock.unlock();
        }
    }
    
}
