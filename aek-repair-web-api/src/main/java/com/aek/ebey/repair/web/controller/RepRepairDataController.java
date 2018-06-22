package com.aek.ebey.repair.web.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aek.common.core.Result;
import com.aek.common.core.base.BaseController;
import com.aek.common.core.serurity.WebSecurityUtils;
import com.aek.ebey.repair.model.RepairData;
import com.aek.ebey.repair.model.vo.RepLargeScreenDataVo;
import com.aek.ebey.repair.model.vo.RepairDataMonthVo;
import com.aek.ebey.repair.service.RepRepairApplyService;
import com.aek.ebey.repair.service.ribbon.DataClientService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

/**
 * 维修数据统计
 *	
 * @author HongHui
 * @date   2018年4月17日
 */
@RestController
@Api(value = "RepRepairDataController", description = "维修统计")
@RequestMapping("/newrepair/data")
public class RepRepairDataController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(RepRepairDataController.class);
    
    @Autowired
    private RepRepairApplyService repRepairApplyService;
    @Autowired
    private DataClientService dataClientService;  
    
    /**
     * 获取维修大屏统计数据
     * @return
     */
    @GetMapping(value = "/getRepairLargeScreenData")
    @ApiOperation(value = "维修大屏统计数据接口")
    @ApiResponse(code = 200, message = "OK", response = Result.class)
    public Result<RepLargeScreenDataVo> getRepairLargeScreenData(@RequestParam(value = "tenantId", required = true) Long tenantId) {
        logger.debug("=======================获取维修大屏统计数据====================");
        if (null == tenantId) {
            tenantId = WebSecurityUtils.getCurrentUser().getTenantId();
        }
        RepLargeScreenDataVo repLargeScreenDataVo = repRepairApplyService.getLargeScreenData(tenantId);
        return response(repLargeScreenDataVo);
    }
    
    /**
     * 获取维修概览统计数据
     * @return
     */
    @GetMapping(value = "/getRepairData")
    @ApiOperation(value = "获取维修概览统计数据")
    @ApiResponse(code = 200, message = "OK", response = Result.class)
    public Result<List<RepairData>> getRepairData() {
        logger.debug("=======================获取维修概览统计数据====================");
        List<RepairData> data = repRepairApplyService.getRepairData();
      //调用统计服务将数据保存至统计服务
        //Result<Object> result = dataClientService.addRepairData(data);
        return response(data);
    }
    
    /**
     * 获取维修月度统计数据
     * @return
     */
    @GetMapping(value = "/getRepairDataMonth")
    @ApiOperation(value = "获取维修月度统计数据")
    @ApiResponse(code = 200, message = "OK", response = Result.class)
    public Result<List<RepairDataMonthVo>> getRepairDataMonth() {
        logger.debug("=======================获取维修月度统计数据====================");
        List<RepairDataMonthVo> data = repRepairApplyService.getRepairDataMonthByDay();
        //调用统计服务将数据保存至统计服务
        //Result<Object> result = dataClientService.addRepairDataMonth(data);
        return response(data);
    }
    
}
   
















