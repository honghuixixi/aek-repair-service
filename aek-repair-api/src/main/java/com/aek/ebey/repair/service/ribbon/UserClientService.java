package com.aek.ebey.repair.service.ribbon;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.aek.common.core.Result;
@FeignClient(value="${feign-assets.serviceId}",fallback = UserClientHystrix.class)
public interface UserClientService {
	/**
	 * 
	 * @param request
	 * @return 根据ID查询设备状态
	 */
    @RequestMapping(method = RequestMethod.GET, value = "/assets/assetsInfo/getAssetsInfoById/{id}")
    Result<Integer> getAssetsInfoById(@PathVariable(value="id", required=true) Long id, @RequestHeader("X-AEK56-Token") String token);
    
    /**
	 * 
	 * @param request
	 * @return
	 * 根据ID更新设备状态
	 */
	@RequestMapping(value = "/assets/restAPI/updateAssetsInfoById/{id}/{status}", method = RequestMethod.GET)
	public Result<Object> updateAssetsInfoById(@PathVariable(value="id", required=true)  Long id,@PathVariable(value="status", required=true)  Integer status,@RequestParam(value="repairId", required=false)  Long repairId, @RequestHeader("X-AEK56-Token") String token);
    
	/**
	 * 
	 * @param request
	 * @return
	 * 根据ID更新设备维修状态
	 */
	@RequestMapping(value = "/assets/restAPI/updateAssetsRepairStatusById/{id}/{repairStatus}", method = RequestMethod.GET)
	public Result<Object> updateAssetsRepairStatusById(@PathVariable(value="id", required=true)  Long id,@PathVariable(value="repairStatus", required=true)  Integer repairStatus,@RequestParam(value="repairId", required=false)  Long repairId, @RequestHeader("X-AEK56-Token") String token);

	/**
	 * 
	 * @param request
	 * @return
	 * 根据ID更新设备维修状态
	 */
	@RequestMapping(value = "/assets/restAPI/updateAssetsRepairStatusByIdNoToken/{id}/{repairStatus}", method = RequestMethod.GET)
	public Result<Object> updateAssetsRepairStatusByIdNoToken(@PathVariable(value="id", required=true)  Long id,@PathVariable(value="repairStatus", required=true)  Integer repairStatus,@RequestParam(value="repairId", required=false)  Long repairId);

	
	/**
	 * 
	 *根据本机构id统计待审核报损单数目
	 * */
    @RequestMapping(method = RequestMethod.GET, value = "/assets/assDiscard/statsWaitAudit")
    Result<Integer> assDiscard(@RequestParam(value="tenantId", required=true) Long tenantId, @RequestHeader("X-AEK56-Token") String token);
    /**
	 * 
	 *根据本机构id统计待审核转科单数目
	 * */
    @RequestMapping(method = RequestMethod.GET, value = "/assets/assAssetsTransfer/statsWaitAudit")
    Result<Integer> assAssetsTransfer(@RequestParam(value="tenantId", required=true) Long tenantId, @RequestHeader("X-AEK56-Token") String token);
}
