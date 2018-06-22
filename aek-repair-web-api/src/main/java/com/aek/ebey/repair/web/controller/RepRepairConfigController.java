package com.aek.ebey.repair.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aek.common.core.Result;
import com.aek.common.core.base.BaseController;
import com.aek.ebey.repair.model.vo.RepConfigDeptVo;
import com.aek.ebey.repair.model.vo.RepConfigResponseVo;
import com.aek.ebey.repair.model.vo.RepConfiger;
import com.aek.ebey.repair.model.vo.RepUserVo;
import com.aek.ebey.repair.query.RepairConfigDeptQuery;
import com.aek.ebey.repair.query.RepairConfigQuery;
import com.aek.ebey.repair.service.RepRepairConfigService;
import com.aek.ebey.repair.web.request.RepairConfigRequest;
import com.aek.ebey.repair.web.validator.group.Add;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.plugins.Page;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

/**
 * <p>
 * 维修配置表  前端控制器
 * </p>
 *
 * @author cyl
 * @since 2018-01-26
 */
@RestController
@RequestMapping("/newrepair/repRepairConfig")
public class RepRepairConfigController extends BaseController {
	@Autowired
	RepRepairConfigService repRepairConfigService;
	
	
	/**
	 * 维修配置新增或修改
	 */
	@PreAuthorize("hasAuthority('REP_REPAIR_CONFIG')")
	@PostMapping(value = "/repConfig")
	@ApiOperation(value = "维修配置新增或修改", httpMethod = "POST", produces = "application/json")
	@ApiResponse(code = 200, message = "OK", response = Result.class)
	public Result<Object> repConfig(@Validated(value = Add.class)@RequestBody RepairConfigRequest req) {
		List<RepConfigDeptVo> depts = req.getDepts();
		Long repairId = req.getRepairId();
		repRepairConfigService.repConfig(repairId, depts);
		return response();
	}
	
	/**
	 * 维修配置详情
	 */
	@PreAuthorize("hasAuthority('REP_REPAIR_CONFIG')")
	@GetMapping(value = "/getConfigDetail")
	@ApiOperation(value = "维修配置详情", httpMethod = "GET", produces = "application/json")
	@ApiResponse(code = 200, message = "OK", response = Result.class)
	public Result<RepConfigResponseVo> getConfigDetail(@RequestParam("id")Long id) {
		return response(repRepairConfigService.getConfigDetail(id));
	}
	
	/**
	 * 维修配置列表分页
	 */
	@PreAuthorize("hasAuthority('REP_REPAIR_CONFIG')")
	@GetMapping(value = "/repairConfigPage")
	@ApiOperation(value = "维修配置列表分页", httpMethod = "GET", produces = "application/json")
	@ApiImplicitParams({ @ApiImplicitParam(name = "pageNo", value = "起始页 [默认1]", paramType = "query", required = false),
			@ApiImplicitParam(name = "pageSize", value = "分页大小[默认10]", paramType = "query", required = false)})
	@ApiResponse(code = 200, message = "OK", response = Result.class)
	public Result<Page<RepUserVo>> repairConfigPage(RepairConfigQuery query) {
		logger.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>>"+JSON.toJSONString(query)+">>>>>>>>>>>>>>>>>>>>>>>>>>>>");	
		Page<RepUserVo> page = query.getPage();
		return response(repRepairConfigService.repairConfigPage(page));
	}
	
	/**
	 * 维修配置选取未分配部门
	 */
	@PreAuthorize("hasAuthority('REP_REPAIR_CONFIG')")
	@GetMapping(value = "/selectDept")
	@ApiOperation(value = "维修配置选取未分配部门", httpMethod = "GET", produces = "application/json")
	@ApiImplicitParams({ @ApiImplicitParam(name = "keyword", value = "关键字检索", paramType = "query"),
		@ApiImplicitParam(name = "tenantId", value = "机构ID", paramType = "query", required = true)})
	@ApiResponse(code = 200, message = "OK", response = Result.class)
	public Result<List<RepConfigDeptVo>> selectDept(RepairConfigDeptQuery query) {
		String keyword = query.getKeyword();
		return response(repRepairConfigService.selectDept(keyword));
	}
	
	/**
	 * 维修配置选取推荐配置人员
	 */
	@PreAuthorize("isAuthenticated()")
	@GetMapping(value = "/selectConfiger")
	@ApiOperation(value = "维修配置选取推荐配置人", httpMethod = "GET", produces = "application/json")
	@ApiImplicitParam(name = "deptId", value = "科室id")
	@ApiResponse(code = 200, message = "OK", response = Result.class)
	public Result<RepConfiger> selectConfiger(@RequestParam("deptId")Long deptId) {
		return response(repRepairConfigService.selectConfiger(deptId));
	}
	
	/**
	 * 维修配置选取所有有接单权限和启用的人员
	 */
	@PreAuthorize("isAuthenticated()")
	@GetMapping(value = "/selectUsers")
	@ApiOperation(value = "维修配置选取所有有接单权限和启用的人员", httpMethod = "GET", produces = "application/json")
	@ApiResponse(code = 200, message = "OK", response = Result.class)
	public Result<List<RepConfiger>> selectUsers() {
		return response(repRepairConfigService.selectUsers());
	}
	
}
