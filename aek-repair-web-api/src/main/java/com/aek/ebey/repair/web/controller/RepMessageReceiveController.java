package com.aek.ebey.repair.web.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aek.common.core.Result;
import com.aek.common.core.base.BaseController;
import com.aek.common.core.exception.ExceptionFactory;
import com.aek.common.core.serurity.WebSecurityUtils;
import com.aek.common.core.serurity.model.AuthUser;
import com.aek.ebey.repair.inter.MessageStatus;
import com.aek.ebey.repair.model.RepMessageReceive;
import com.aek.ebey.repair.query.RepMessageReceiveQuery;
import com.aek.ebey.repair.request.ApplyTotalResponse;
import com.aek.ebey.repair.request.MessageResponse;
import com.aek.ebey.repair.service.RepMessageReceiveService;
import com.aek.ebey.repair.service.RepRepairApplyService;
import com.aek.ebey.repair.utils.RepairUtils;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

/**
 * <p>
 * 消息接收表  前端控制器
 * </p>
 *
 * @author aek
 * @since 2017-08-30
 */
@RestController
@Api(value = "RepMessageReceiveController", description = "消息管理")
@RequestMapping("/newrepair/repMessageReceive")
public class RepMessageReceiveController extends BaseController {
	
	private static final Logger logger = LoggerFactory.getLogger(RepMessageReceiveController.class);

	@Autowired
	private RepMessageReceiveService repMessageReceiveService;
	
	@Autowired
	private RepRepairApplyService repRepairApplyService;
	
	/**
	 * 查询未读信息数量
	 */
	@PreAuthorize("isAuthenticated()")
	@GetMapping(value = "/find")
	@ApiOperation(value = "查询未读信息数量")
	@ApiResponse(code = 200, message = "OK", response = Result.class)
	public Result<Integer> find() {
		AuthUser authUser = WebSecurityUtils.getCurrentUser();
		if (authUser != null && authUser.getId() != null) {
			Wrapper<RepMessageReceive> wrapper = new EntityWrapper<RepMessageReceive>();
			wrapper.eq("user_id", authUser.getId()).eq("message_status", MessageStatus.UNWATCH).eq("del_flag", 0);;
			return response(repMessageReceiveService.selectCount(wrapper));
		}else{
			return response(0);
		}
	}
	
	/**
	 * 查询未读信息数量
	 */
	@PreAuthorize("isAuthenticated()")
	@GetMapping(value = "/readAll")
	@ApiOperation(value = "读未读信息")
	@ApiResponse(code = 200, message = "OK", response = Result.class)
	public Result<Object> readAll() {
		AuthUser authUser = WebSecurityUtils.getCurrentUser();
		int ret=repMessageReceiveService.readAll(authUser);
		return response(ret);
		
	}

	/**
	 * 查询待办事件
	 */
	@PreAuthorize("isAuthenticated()")
	@GetMapping(value = "/waitDo/{tenantid}")
	@ApiOperation(value = "查询待办事件")
	@ApiResponse(code = 200, message = "OK", response = Result.class)
	public Result<List<ApplyTotalResponse>> total(@PathVariable(value = "tenantid", required = true)String tenantid) {
		List<ApplyTotalResponse> list = repRepairApplyService.selectApplyStatus(tenantid);
		Set<ApplyTotalResponse> set = new HashSet<ApplyTotalResponse>();
		set.addAll(list);
		for (int i = 1; i < 5; i++) {
			ApplyTotalResponse applyTotalResponse = new ApplyTotalResponse();
			applyTotalResponse.setStatus(i);
			applyTotalResponse.setTotal(0);
			set.add(applyTotalResponse);

		}
		List<ApplyTotalResponse> list2 = new ArrayList<>(set);
		return response(list2);
	}

	/**
	 * 查询未读信息
	 */
	@PreAuthorize("isAuthenticated()")
	@GetMapping(value = "/read/{messageid}")
	@ApiOperation(value = "查看未读信息")
	@ApiResponse(code = 200, message = "OK", response = Result.class)
	public Result<Object> read(@PathVariable(value = "messageid", required = true) String messageid) {
		AuthUser authUser = WebSecurityUtils.getCurrentUser();
		if (authUser != null && authUser.getId() != null) {
			Wrapper<RepMessageReceive> wrapper = new EntityWrapper<RepMessageReceive>();
			wrapper.eq("id", messageid).eq("user_id", authUser.getId()).eq("message_status", MessageStatus.UNWATCH).eq("del_flag", 0);
			RepMessageReceive entity = repMessageReceiveService.selectOne(wrapper);
			if(entity!=null){
				entity.setMessageStatus(MessageStatus.WATCHED);
				repMessageReceiveService.update(entity, wrapper);
				return response();
			}
			throw ExceptionFactory.create("G_006");
		}
		throw ExceptionFactory.create("W_001");
	}

	/**
	 * 查询消息列表(分页)
	 */
	@PreAuthorize("isAuthenticated()")
	@GetMapping(value = "/search")
	@ApiOperation(value = "查询消息列表(分页)", httpMethod = "GET", produces = "application/json")
	@ApiImplicitParams({ @ApiImplicitParam(name = "pageNo", value = "起始页 [默认1]", paramType = "query", required = false),
			@ApiImplicitParam(name = "pageSize", value = "分页大小[默认10]", paramType = "query", required = false),
			@ApiImplicitParam(name = "messageStatus", value = "消息状态", paramType = "query", required = false),
			@ApiImplicitParam(name = "orderByField", value = "排序列(message_time)", paramType = "query", required = false),
			@ApiImplicitParam(name = "isAsc", value = "true,false", paramType = "query", required = false)})
	@ApiResponse(code = 200, message = "OK", response = Result.class)
	public Result<Page<MessageResponse>> search(RepMessageReceiveQuery query) {
		logger.debug(JSON.toJSONString(query));
		Page<MessageResponse> page = repMessageReceiveService.search(query);
		List<MessageResponse> list=page.getRecords();
		if(list!=null&&list.size()>0){
			for(MessageResponse messageResponse:list){
				messageResponse.setUrl(RepairUtils.getUrl(messageResponse.getStatus()));
			}
		}
		return response(page);
	}
	

	/**
	 * 查询消息列表小程序(分页)
	 */
	@PreAuthorize("isAuthenticated()")
	@GetMapping(value = "/searchX")
	@ApiOperation(value = "查询消息列表小程序(分页)", httpMethod = "GET", produces = "application/json")
	@ApiImplicitParams({ @ApiImplicitParam(name = "pageNo", value = "起始页 [默认1]", paramType = "query", required = false),
			@ApiImplicitParam(name = "pageSize", value = "分页大小[默认10]", paramType = "query", required = false),
			@ApiImplicitParam(name = "messageStatus", value = "消息状态", paramType = "query", required = false),
			@ApiImplicitParam(name = "orderByField", value = "排序列(message_time)", paramType = "query", required = false),
			@ApiImplicitParam(name = "isAsc", value = "true,false", paramType = "query", required = false)})
	@ApiResponse(code = 200, message = "OK", response = Result.class)
	public Result<Page<MessageResponse>> searchX(RepMessageReceiveQuery query) {
		logger.debug(JSON.toJSONString(query));
		Page<MessageResponse> page = repMessageReceiveService.searchX(query);
		List<MessageResponse> list=page.getRecords();
		if(list!=null&&list.size()>0){
			for(MessageResponse messageResponse:list){
				messageResponse.setUrl(RepairUtils.getUrl(messageResponse.getStatus()));
			}
		}
		return response(page);
	}

	
}
