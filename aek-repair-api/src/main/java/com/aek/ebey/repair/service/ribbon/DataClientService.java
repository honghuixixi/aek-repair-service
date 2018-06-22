package com.aek.ebey.repair.service.ribbon;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aek.common.core.Result;
import com.aek.ebey.repair.model.RepairData;
import com.aek.ebey.repair.model.vo.RepairDataMonthVo;
import com.aek.ebey.repair.request.SevenDataResponse;

/**
 * 远程调用接口value=${feign-data.serviceId}
 *	
 * @author HongHui
 * @date   2017年12月13日
 */
@FeignClient(value="${feign-data.serviceId}",fallback = DataClientHystrix.class)
public interface DataClientService {

	/**
	 * 保存维修概览统计数据
	 * @param request
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/data/repairData/addRepairData")
	public Result<Object> addRepairData(@RequestBody List<RepairData> request);
	
	/**
     * 保存维修月度统计数据
     * @param request
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "/data/repairData/addRepairDataMonth")
    public Result<Object> addRepairDataMonth(@RequestBody List<RepairDataMonthVo> request);
    
    /**
	 * 调用接口，推送数据
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/data/repairServenCompleteRate/addRepairServenCompleteRate")
	Result<Object> pushSevenData(@RequestBody List<SevenDataResponse> request);
	
}