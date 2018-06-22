package com.aek.ebey.repair.service.ribbon;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.aek.common.core.Result;


@FeignClient(value="${feign-qc.serviceId}",fallback = QcClientHystrix.class)
public interface QcClientService {

	/**
	 * 查询QC待巡检待办
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/qc/qcPlan/getQcImplementWaitToDo")
	public Result<Integer> getQcImplementWaitToDo(@RequestParam(value = "id", required = true) Long id,
		      @RequestHeader("X-AEK56-Token") String token);
	
	/**
	 * 查询PM待巡检待办
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/pm/pmPlanImplementHelp/getPmImplementWaitToDo")
	public Result<Integer> getPmImplementWaitToDo(@RequestParam(value = "id", required = true) Long id,
		      @RequestHeader("X-AEK56-Token") String token);
	
	
	/**
	 * 查询QC验收待办
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/qc/qcPlanCheck/getQcPlanCheckWaitToDo")
	public Result<Integer> getQcCheckWaitToDo(@RequestParam(value = "id", required = true) Long id,
		      @RequestHeader("X-AEK56-Token") String token);
	
	/**
	 * 查询PM验收待办
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/pm/pmImplement/getPmCheckWaitToDo")
	public Result<Integer> getPmCheckWaitToDo(@RequestParam(value = "id", required = true) Long id,
		      @RequestHeader("X-AEK56-Token") String token);
	
	/**
	 * 查询MD待审核
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/qc/mdReport/count")
	public Result<Integer> getMdWaitToDo(@RequestParam(value = "tenantId", required = true) Long tenantId,
		      @RequestHeader("X-AEK56-Token") String token);
}