package com.aek.ebey.repair.service.ribbon;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import com.aek.common.core.Result;
import com.aek.ebey.repair.model.RepairData;
import com.aek.ebey.repair.model.vo.RepairDataMonthVo;
import com.aek.ebey.repair.request.SevenDataResponse;

/**
 * 断路器
 *	
 * @author HongHui
 * @date   2017年12月13日
 */
@Component
public class DataClientHystrix implements DataClientService{

	private static final Logger logger = LogManager.getLogger(DataClientHystrix.class);

	@Override
	public Result<Object> addRepairData(@RequestBody List<RepairData> request){
	    logger.info("============data service is not connected!==============");
		return null;
	}

    @Override
    public Result<Object> addRepairDataMonth(List<RepairDataMonthVo> request) {
        logger.info("============data service is not connected!==============");
        return null;
    }

	@Override
	public Result<Object> pushSevenData(List<SevenDataResponse> request) {
		logger.info("============data service is not connected!==============");
		return null;
	}
	
	
	
	
}
