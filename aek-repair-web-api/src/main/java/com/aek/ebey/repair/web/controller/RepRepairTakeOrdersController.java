package com.aek.ebey.repair.web.controller;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.aek.common.core.serurity.WebSecurityUtils;
import com.aek.common.core.serurity.model.AuthUser;
import com.aek.ebey.repair.model.RepRepairTakeOrders;
import com.aek.ebey.repair.service.RepRepairApplyService;
import com.aek.ebey.repair.service.RepRepairTakeOrdersService;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

/**
 * <p>
 * 接单表  前端控制器
 * </p>
 *
 * @author aek
 * @since 2017-08-30
 */
@RestController
@Api(value = "RepRepairTakeOrdersController", description = "维修接单")
@RequestMapping("/newrepair/repRepairTakeOrders")
public class RepRepairTakeOrdersController extends BaseController {
	
	private static final Logger logger = LoggerFactory.getLogger(RepRepairTakeOrdersController.class);

	@Autowired
	private RepRepairApplyService repRepairApplyService;
	
	@Autowired
	private RepRepairTakeOrdersService repRepairTakeOrdersService;
	
	/**
	 * 新建申请单
	 * 
	 * @throws IOException
	 */
	@PreAuthorize("hasAuthority('REP_APPLY_TAKE_NEW')")
	@PostMapping(value = "/taking")
	@ApiOperation(value = "接单")
	@ApiResponse(code = 200, message = "OK", response = Result.class)
	public Result<Object> taking(@RequestBody RepRepairTakeOrders repRepairTakeOrders){
		logger.debug("<---------------------------------"+JSON.toJSONString(repRepairTakeOrders));
		repRepairApplyService.taking(repRepairTakeOrders);
		
		return response();
			
	}
	
	/**
	 * 查询待接单任务数量
	 */
	@PreAuthorize("hasAuthority('REP_APPLY_TAKE_NEW')")
	@GetMapping(value = "/waiTaking/{tenantid}")
	@ApiOperation(value = "查询待接单任务数量")
	@ApiResponse(code = 200, message = "OK", response = Result.class)
	public Result<Integer> find(@PathVariable(value = "tenantid", required = true)String tenantid) {
		AuthUser authUser = WebSecurityUtils.getCurrentUser();
		int ret=repRepairApplyService.selectCountByTenantid(tenantid,authUser,1);
		return response(ret);
		
	}
	
	
	/**
	 * 根据申请单id搜索接单信息
	 */
	@PreAuthorize("hasAuthority('REP_APPLY_TAKE_CHECK_VIEW')")
	@GetMapping(value = "/search/{id}")
	@ApiOperation(value = "根据申请单id搜索接单信息")
	@ApiResponse(code = 200, message = "OK", response = Result.class)
	public Result<RepRepairTakeOrders> search(@PathVariable(value = "id", required = true) Long id) {
		Wrapper<RepRepairTakeOrders> wrapper=new EntityWrapper<RepRepairTakeOrders>();
		wrapper.eq("apply_id", id);
		wrapper.eq("del_flag", 0);
		List<RepRepairTakeOrders> list=repRepairTakeOrdersService.selectList(wrapper);
		if(!CollectionUtils.isEmpty(list)){
			return response(list.get(0));
		}
		return response(null);
	}
	
	
	
}
