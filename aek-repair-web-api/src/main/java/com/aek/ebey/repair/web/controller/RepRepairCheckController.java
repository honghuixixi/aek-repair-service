package com.aek.ebey.repair.web.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aek.common.core.Result;
import com.aek.common.core.base.BaseController;
import com.aek.common.core.exception.ExceptionFactory;
import com.aek.common.core.serurity.WebSecurityUtils;
import com.aek.common.core.serurity.model.AuthUser;
import com.aek.ebey.repair.inter.AssetsRepairStatusEnum;
import com.aek.ebey.repair.inter.MessageStatus;
import com.aek.ebey.repair.inter.RepairApplyStatus;
import com.aek.ebey.repair.inter.RepairMessage;
import com.aek.ebey.repair.model.RepMessageReceive;
import com.aek.ebey.repair.model.RepRepairApply;
import com.aek.ebey.repair.model.RepRepairCheck;
import com.aek.ebey.repair.model.RepRepairMessage;
import com.aek.ebey.repair.model.RepRepairReport;
import com.aek.ebey.repair.service.RepMessageReceiveService;
import com.aek.ebey.repair.service.RepRepairApplyService;
import com.aek.ebey.repair.service.RepRepairCheckService;
import com.aek.ebey.repair.service.RepRepairMessageService;
import com.aek.ebey.repair.service.RepRepairReportService;
import com.aek.ebey.repair.service.ribbon.UserClientService;
import com.aek.ebey.repair.web.utils.DateUtils;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

/**
 * <p>
 * 验收详情表  前端控制器
 * </p>
 *
 * @author aek
 * @since 2017-08-30
 */
@RestController
@Api(value = "RepRepairCheckController", description = "验收")
@RequestMapping("/newrepair/repRepairCheck")
public class RepRepairCheckController extends BaseController {
	
private static final Logger logger = LoggerFactory.getLogger(RepRepairCheckController.class);

	@Autowired
	private RepRepairApplyService repRepairApplyService;
	
	@Autowired
	private RepRepairCheckService repRepairCheckService;
	
	@Autowired
	private  RepRepairReportService repRepairReportService;
	
	@Autowired
	private UserClientService userClientService;
	
	@Autowired
	private RepRepairMessageService repRepairMessageService;
	
	@Autowired
	private RepMessageReceiveService repMessageReceiveService;
	
	/**
	 *申请单验收
	 */
	@PreAuthorize("hasAuthority('REP_APPLY_CHECK')")
	@PostMapping(value = "/check")
	@ApiOperation(value = "申请单验收")
	@ApiResponse(code = 200, message = "OK", response = Result.class)
	public Result<Object> check(@RequestBody RepRepairCheck data) {
		logger.debug("<---------------------------------" + JSON.toJSONString(data));
		repRepairApplyService.check(data);
		return response();
		

	}
	/**
	 * 查询待验收任务数量
	 * @param tenantid
	 * @return
	 */
	@PreAuthorize("hasAuthority('REP_APPLY_CHECK')")
	@GetMapping(value = "/waitCheck/{tenantid}")
	@ApiOperation(value = "查询待验收任务数量")
	@ApiResponse(code = 200, message = "OK", response = Result.class)
	public Result<Integer> waitCheck(@PathVariable(value = "tenantid", required = true)String tenantid) {
		AuthUser authUser = WebSecurityUtils.getCurrentUser();
		int ret=repRepairApplyService.selectCountByTenantid(tenantid,authUser,3);
		return response(ret);
	}
	
	/**
	 * 查询已完成任务数量
	 * @param tenantid
	 * @return
	 */
	@PreAuthorize("isAuthenticated()")
	@GetMapping(value = "/complete/{tenantid}")
	@ApiOperation(value = "查询已完成任务数量")
	@ApiResponse(code = 200, message = "OK", response = Result.class)
	public Result<Integer> complete(@PathVariable(value = "tenantid", required = true)String tenantid) {
		AuthUser authUser = WebSecurityUtils.getCurrentUser();
		int ret=repRepairApplyService.selectCountByTenantid(tenantid,authUser,4);
		return response(ret);
	}
	
	/**
	 * 根据申请单id搜索验收信息
	 */
	@PreAuthorize("hasAuthority('REP_APPLY_TAKE_CHECK_VIEW')")
	@GetMapping(value = "/search/{id}")
	@ApiOperation(value = "根据申请单id搜索验收信息")
	@ApiResponse(code = 200, message = "OK", response = Result.class)
	public Result<RepRepairCheck> search(@PathVariable(value = "id", required = true) Long id){
		Wrapper<RepRepairCheck> wrapper=new EntityWrapper<RepRepairCheck>();
		wrapper.eq("apply_id", id);
		wrapper.eq("del_flag", 0);
		List<RepRepairCheck> list=repRepairCheckService.selectList(wrapper);
		if(!CollectionUtils.isEmpty(list)){
			return response(list.get(0));
		}
		return response(null);
	}
	
}
