package com.aek.ebey.repair.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.aek.common.core.Result;
import com.aek.common.core.base.BaseController;
import com.aek.common.core.serurity.WebSecurityUtils;
import com.aek.common.core.serurity.model.AuthUser;
import com.aek.ebey.repair.model.RepRepairReport;
import com.aek.ebey.repair.request.RepRepairReportDetails;
import com.aek.ebey.repair.request.RepRepairReportResponse;
import com.aek.ebey.repair.service.RepRepairApplyService;
import com.aek.ebey.repair.service.RepRepairReportService;
import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

/**
 * <p>
 * 维修报告  前端控制器
 * </p>
 *
 * @author aek
 * @since 2017-08-30
 */
@RestController
@Api(value = "RepRepairReportController", description = "维修报告")
@RequestMapping("/newrepair/repRepairReport")
public class RepRepairReportController extends BaseController {
	
	@Autowired
	private  RepRepairReportService repRepairReportService;
	
	@Autowired
	private RepRepairApplyService repRepairApplyService;
	

	@PreAuthorize("hasAuthority('REP_APPLY_REPAIR')")
	@PostMapping(value = "/save")
	@ApiOperation(value = "填写维修报告单(status 1,暂存 2,完修)")
	@ApiResponse(code = 200, message = "OK", response = Result.class)
	public Result<Object> save(@RequestBody RepRepairReport data) {
		logger.debug("<---------------------------------"+JSON.toJSONString(data));
		Boolean  bol=repRepairReportService.save(data);
		if(true==bol){
			return response();
		}else{
			return responseMsg("W_002");
		}
	}
	/**
	 * 查询维修中任务数量
	 * @param tenantid
	 * @return
	 */
	@PreAuthorize("hasAuthority('REP_APPLY_REPAIR')")
	@GetMapping(value = "/Repairing/{tenantid}")
	@ApiOperation(value = "查询维修中任务数量")
	@ApiResponse(code = 200, message = "OK", response = Result.class)
	public Result<Integer> Repairing(@PathVariable(value = "tenantid", required = true)String tenantid) {
		AuthUser authUser = WebSecurityUtils.getCurrentUser();
		int ret=repRepairApplyService.selectCountByTenantid(tenantid,authUser,2);
		return response(ret);
	}
	
	/**
	 * 根据申请单id搜索修报告单信息
	 */
	@PreAuthorize("hasAuthority('REP_APPLY_REPORT_VIEW')")
	@GetMapping(value = "/search/{id}")
	@ApiOperation(value = "根据申请单id搜索修报告单信息")
	@ApiResponse(code = 200, message = "OK", response = Result.class)
	public Result<RepRepairReportDetails> search(@PathVariable(value = "id", required = true) Long id){
		logger.debug("<---------------------------------id="+id);
		RepRepairReportDetails repRepairReportDetails=repRepairReportService.search(id);
		return response(repRepairReportDetails);
	}
	
	
	/**
	 * 根据申请单id搜索修报告单信息
	 */
	@PreAuthorize("hasAuthority('REP_APPLY_REPORT_VIEW')")
	@GetMapping(value = "/searchResponse/{id}")
	@ApiOperation(value = "根据申请单id搜索修报告单信息")
	@ApiResponse(code = 200, message = "OK", response = Result.class)
	public Result<RepRepairReportResponse> searchAll(@PathVariable(value = "id", required = true) Long id){
		logger.debug("<---------------------------------id="+id);
		RepRepairReportResponse res=repRepairReportService.searchResponse(id);
		return response(res);
	}

	
}
