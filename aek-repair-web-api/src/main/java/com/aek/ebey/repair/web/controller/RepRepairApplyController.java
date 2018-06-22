package com.aek.ebey.repair.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aek.common.core.BeanMapper;
import com.aek.common.core.Result;
import com.aek.common.core.base.BaseController;
import com.aek.common.core.exception.ExceptionFactory;
import com.aek.common.core.serurity.WebSecurityUtils;
import com.aek.common.core.serurity.model.AuthUser;
import com.aek.ebey.repair.enums.WeiXinRepairMessageTypeEnum;
import com.aek.ebey.repair.inter.RepairApplyStatus;
import com.aek.ebey.repair.model.RepRepairApply;
import com.aek.ebey.repair.model.RepTurnOrders;
import com.aek.ebey.repair.query.RepRepairApplyQuery;
import com.aek.ebey.repair.query.RepRepairRecordQuery;
import com.aek.ebey.repair.request.ApplyDetailsResponse;
import com.aek.ebey.repair.request.ApplyResponse;
import com.aek.ebey.repair.request.ApplyTotalResponse;
import com.aek.ebey.repair.request.ApplyTurnOrderRequest;
import com.aek.ebey.repair.request.RepairRecordResponse;
import com.aek.ebey.repair.request.WaitResponse;
import com.aek.ebey.repair.request.WeiXinRepairMessageRequest;
import com.aek.ebey.repair.service.RepRepairApplyService;
import com.aek.ebey.repair.service.RepRepairBillService;
import com.aek.ebey.repair.service.RepTurnOrdersService;
import com.aek.ebey.repair.service.ribbon.AuthClientService;
import com.aek.ebey.repair.service.ribbon.DataClientService;
import com.aek.ebey.repair.service.ribbon.QcClientService;
import com.aek.ebey.repair.service.ribbon.UserClientService;
import com.aek.ebey.repair.service.ribbon.UserPermissionService;
import com.aek.ebey.repair.web.request.RepRepairApplyResponse;
import com.aek.ebey.repair.web.utils.DateUtils;
import com.aek.ebey.repair.web.utils.OrderUtils;
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
 * 设备维修申请表  前端控制器
 * </p>
 *
 * @author aek
 * @since 2017-08-30
 */
@RestController
@Api(value = "RepRepairApplyController", description = "维修申请")
@RequestMapping("/newrepair/repRepairApply")
public class RepRepairApplyController extends BaseController {
	
	private static final Logger logger = LoggerFactory.getLogger(RepRepairApplyController.class);
	
	@Autowired
	private RepRepairApplyService repRepairApplyService;
	
	@Autowired
	private RepRepairBillService repRepairBillService;
	
	@Autowired
	private AuthClientService authClientService;
	
	@Autowired
	private RepTurnOrdersService repTurnOrdersService;
	
	@Autowired
	private UserPermissionService userPermissionService;
	
	@Autowired
	private UserClientService userClientService;
	
	@Autowired
	private DataClientService dataClientService;
	
	
	@Autowired
	private QcClientService qcClientService;

	/**
	 * 新建申请单
	 * 
	 * @throws IOException
	 */
	@PreAuthorize("hasAuthority('REP_APPLY_NEW')")
	@PostMapping(value = "/add")
	@ApiOperation(value = "新建申请单")
	@ApiResponse(code = 200, message = "OK", response = Result.class)
	public Result<RepRepairApply> add(@RequestBody RepRepairApply repRepairApply){
		logger.debug("<---------------------------------" + JSON.toJSONString(repRepairApply));
		AuthUser authUser = WebSecurityUtils.getCurrentUser();
		if (repRepairApply != null && repRepairApply.getDeptId() == null) {
			throw ExceptionFactory.create("W_010");
		}
		if (repRepairApplyService.getRepRepairApply(repRepairApply)) {
			throw ExceptionFactory.create("W_012");
		}

		Result<Integer> result = userPermissionService.checkIsRepHelp(repRepairApply.getTakeOrderId(),
				WebSecurityUtils.getCurrentToken());
		logger.info("用户是否具有接单权限返回结果=" + (result != null ? result.getData().toString() : null));
		if (result != null) {
			if (result.getData().intValue() == 3) {
				// 状态
				repRepairApply.setStatus(RepairApplyStatus.WAITTAKE);
				// 设置订单号
				repRepairApply.setApplyNo(OrderUtils.getOrderNum());
				this.repRepairApplyService.save(repRepairApply);
				return response(repRepairApply);
			} else if (result.getData().intValue() == 2) {
				throw ExceptionFactory.create("W_028");
			} else if (result.getData().intValue() == 1) {
				// 没有权限
				throw ExceptionFactory.create("W_029");
			}
		} else {
			throw ExceptionFactory.create("G_007");
		}
		return null;
	
	
	
		
		
	}
	
	/**
	 * 根据申请单id搜索申请单
	 */
	@PreAuthorize("hasAnyAuthority('REP_APPLY_DETAILED_VIEW,REP_APPLY_VIEW,REP_APPLY_TAKE_CHECK_VIEW')")
	@GetMapping(value = "/search/{id}")
	@ApiOperation(value = "根据申请单id搜索申请单")
	@ApiResponse(code = 200, message = "OK", response = Result.class)
	public Result<RepRepairApply> search(@PathVariable(value = "id", required = true) Long id) {
		RepRepairApply repRepairApply = repRepairApplyService.selectById(id);
		AuthUser authUser = WebSecurityUtils.getCurrentUser();
		if(repRepairApply!=null&&authUser!=null){
			repRepairApply.setFlag(repRepairApply.getTakeOrderId().longValue()==authUser.getId().longValue()?true:false);	
		}
		return response(repRepairApply);
	}
	
	/**
	 * 根据申请单id搜索申请单详情
	 */
	@PreAuthorize("hasAnyAuthority('REP_APPLY_DETAILED_VIEW,REP_APPLY_VIEW,REP_APPLY_TAKE_CHECK_VIEW')")
	@GetMapping(value = "/getApplyDetails/{id}")
	@ApiOperation(value = "根据申请单id搜索申请单详情")
	@ApiResponse(code = 200, message = "OK", response = Result.class)
	public Result<ApplyDetailsResponse> getApplyDetails(@PathVariable(value = "id", required = true) Long id) {
		return response(repRepairApplyService.getApplyDetails(id));
	}
	
	/**
	 * 根据时间查询申请单信息
	 */
	@PreAuthorize("hasAuthority('REP_APPLY_VIEW')")
	@GetMapping(value = "/getApplyByTime")
	@ApiOperation(value = "根据时间查询申请单信息")
	@ApiResponse(code = 200, message = "OK", response = Result.class)
	public Result<RepRepairApplyResponse> getApplyByMonth(@RequestParam(value = "year", required = true) String year,
			@RequestParam(value = "month", required = true) String month,	@RequestParam(value = "tenantId", required = true) Long tenantId) {
		logger.debug("year"+year+"------"+"month"+month+"------------------"+"tenantId"+tenantId);
		RepRepairApplyResponse repairApplyResponse = new RepRepairApplyResponse();
		AuthUser authUser = WebSecurityUtils.getCurrentUser();
		Wrapper<RepRepairApply> wrapper = new EntityWrapper<RepRepairApply>();
		if(authUser!=null&&authUser.getDataScope()!=null){
			if(authUser!=null&&authUser.getDataScope()==2){
				wrapper.in("assets_dept_id", authUser.getDeptIds());
			}
			if(authUser!=null&&authUser.getDataScope()==3){
				wrapper.eq("dept_id", authUser.getDeptId());
			}
			
		}else{
			wrapper.eq("dept_id", authUser.getDeptId());
		}
		wrapper.eq("tenant_id", tenantId);
		wrapper.eq("del_flag", 0);
		wrapper.between("report_repair_date", DateUtils.getStartDate(year, month), DateUtils.getEndDate(year, month)).orderBy("report_repair_date", false);
		repairApplyResponse.setList(this.repRepairApplyService.selectList(wrapper));
		repairApplyResponse.setDays(DateUtils.getDays(year, month));
		return response(repairApplyResponse);
	}
	
	/**
	 * 查询申请单列表(分页)
	 */
	@PreAuthorize("hasAuthority('REP_APPLY_VIEW')")
	@GetMapping(value = "/search")
	@ApiOperation(value = "查询申请单列表(分页)", httpMethod = "GET", produces = "application/json")
	@ApiImplicitParams({ @ApiImplicitParam(name = "pageNo", value = "起始页 [默认1]", paramType = "query", required = false),
			@ApiImplicitParam(name = "pageSize", value = "分页大小[默认10]", paramType = "query", required = false),
			@ApiImplicitParam(name = "status", value = "状态", paramType = "query", required = false),
			@ApiImplicitParam(name = "assetsDeptName", value = "所在科室", paramType = "query", required = false),
			@ApiImplicitParam(name = "tenantId", value = "机构ID", paramType = "query", required = false),
			@ApiImplicitParam(name = "orderByField", value = "排序列(不需要则为null)", paramType = "query", required = false),
			@ApiImplicitParam(name = "isAsc", value = "true,false", paramType = "query", required = false),
			@ApiImplicitParam(name = "keyword", value = "关键字(设备名称/编号/院内编码/出场编号)", paramType = "query") })
	@ApiResponse(code = 200, message = "OK", response = Result.class)
	public Result<Page<ApplyResponse>> search(RepRepairApplyQuery query) {
		logger.debug("<---------------------------------"+JSON.toJSONString(query));
		//获取数据权限 角色数据范围: 1=所在机构所有数据,2=所在部门及下级部门数据,3=所在部门数据
		Page<ApplyResponse> page = repRepairApplyService.search(query);
		return response(page);
	}
	
	/**
	 * 查询申请单列表2(分页)
	 */
	// @PreAuthorize("isAuthenticated()")
	@PreAuthorize("hasAuthority('REP_APPLY_VIEW')")
	@GetMapping(value = "/search2")
	@ApiOperation(value = "查询申请单列表大屏(分页)", httpMethod = "GET", produces = "application/json")
	@ApiImplicitParams({ 
	@ApiImplicitParam(name = "pageNo", value = "起始页 [默认1]", paramType = "query", required = false),
	@ApiImplicitParam(name = "statusList", value = "集合状态", paramType = "query", required = false),
	@ApiImplicitParam(name = "pageSize", value = "分页大小[默认10]", paramType = "query", required = false) })
	@ApiResponse(code = 200, message = "OK", response = Result.class)
	public Result<Page<ApplyResponse>> search2(RepRepairApplyQuery query) {
		logger.debug("<---------------------------------"+JSON.toJSONString(query));
		Page<ApplyResponse> page = repRepairApplyService.search(query);
		return response(page);
	}
	
	/**
	 * 根据状态统计申请单
	 */
	@PreAuthorize("isAuthenticated()")
	@GetMapping(value = "/total/{tenantid}")
	@ApiOperation(value = "根据状态统计申请单")
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
		ApplyTotalResponse applyTotalResponse = new ApplyTotalResponse();
		applyTotalResponse.setStatus(0);
		Integer total=0;
		if(set.size()>0){
			for(ApplyTotalResponse apply :set){
				total+=apply.getTotal();
			}
		}
		applyTotalResponse.setTotal(total);
		set.add(applyTotalResponse);
		List<ApplyTotalResponse> list2 = new ArrayList<>(set);
		return response(list2);
	}
	
	
	/**
	 * 根据状态统计申请单
	 */
	@PreAuthorize("isAuthenticated()")
	@GetMapping(value = "/waitToDo")
	@ApiOperation(value = "根据状态统计申请单")
	@ApiResponse(code = 200, message = "OK", response = Result.class)
	public Result<List<WaitResponse>> waitToDo() {
		List<WaitResponse> set = new ArrayList<WaitResponse>();
		AuthUser authUser = WebSecurityUtils.getCurrentUser();
		Long id=authUser.getId();
		Long tenantId=authUser.getTenantId();
		String token=WebSecurityUtils.getCurrentToken();
		
		//查询待接单任务数量1
		
		Result<Boolean> resultJd=userPermissionService.checkIsRht(id, "REP_APPLY_TAKE_NEW", token);
		if(resultJd!=null){
			if(resultJd.getData()){
				//int status1=repRepairApplyService.selectCountByTenantid(tenantId+"",authUser,1);
				//指定接单人接收消息
				int status1 = repRepairApplyService.statsTakeOrdersByUserId(authUser);
				WaitResponse WaitResponse1=new WaitResponse();
				WaitResponse1.setStatus(1);
				WaitResponse1.setTotal(status1);
				WaitResponse1.setUrl("repair.manage");
				WaitResponse1.setCs("1");
				set.add(WaitResponse1);
			}
		}
		
		
		//查询维修中任务数量2
		
		Result<Boolean> resultWx=userPermissionService.checkIsRht(id, "REP_APPLY_REPAIR", token);
		if(resultWx!=null){
			if(resultWx.getData()){
				//int status2=repRepairApplyService.selectCountByTenantid(tenantId+"",authUser,2);
				//指定维修人接收消息
				int status2=repRepairApplyService.statsWaitRepairByUserId(authUser);
				WaitResponse WaitResponse2=new WaitResponse();
				WaitResponse2.setStatus(2);
				WaitResponse2.setTotal(status2);
				WaitResponse2.setUrl("repair.manage");
				WaitResponse2.setCs("2");
				set.add(WaitResponse2);
			}
		}
		
		//查询待验收任务数量3
		Result<Boolean> resultYs=userPermissionService.checkIsRht(id, "REP_APPLY_CHECK", token);
		if(resultYs!=null){
			if(resultYs.getData()){
				//int status3=repRepairApplyService.selectCountByTenantid(tenantId+"",authUser,3);
				//维修单设备所在科室的人接口消息
				int status3 = repRepairApplyService.statsWaitCheckByUserDeptId(authUser);
				WaitResponse WaitResponse3=new WaitResponse();
				WaitResponse3.setStatus(3);
				WaitResponse3.setTotal(status3);
				WaitResponse3.setUrl("repair.manage");
				WaitResponse3.setCs("3");
				set.add(WaitResponse3);
			}
		}
		
		//单据审批4
		Result<Boolean> resultSp=userPermissionService.checkIsRht(id, "REP_REPAIR_PRICE_CHECK", token);
		if(resultSp!=null){
			if(resultSp.getData()){
				Integer  status4 =repRepairBillService.getWaitToDo(id);
				WaitResponse WaitResponse4=new WaitResponse();
				WaitResponse4.setStatus(4);
				WaitResponse4.setTotal(status4);
				WaitResponse4.setUrl("repair.audit.list");
				WaitResponse4.setCs("");
				set.add(WaitResponse4);
			}
		}
		
		
		//巡检5
		Result<Boolean> resultQc=userPermissionService.checkIsRht(id, "QC_PLAN_IMPLEMENT", token);
		if(resultQc!=null){
			if(resultQc.getData()){
				Result<Integer>  num=qcClientService.getQcImplementWaitToDo(id, token);
				if(num!=null){
					WaitResponse WaitResponse=new WaitResponse();
					WaitResponse.setStatus(5);
					WaitResponse.setTotal(num.getData());
					WaitResponse.setUrl("inspection.implement.list");
					WaitResponse.setCs("1");
					set.add(WaitResponse);
					//PM6
				}else{
					WaitResponse WaitResponse=new WaitResponse();
					WaitResponse.setStatus(5);
					WaitResponse.setTotal(0);
					WaitResponse.setUrl("inspection.implement.list");
					WaitResponse.setCs("1");
					set.add(WaitResponse);
				}
			}
					
		}
		//PM6
		Result<Boolean> resultPm=userPermissionService.checkIsRht(id, "PM_PLAN_IMPLEMENT", token);
		if(resultPm!=null){
			if(resultPm.getData()){
				Result<Integer>  num=qcClientService.getPmImplementWaitToDo(id, token);
				if(num!=null){
					WaitResponse WaitResponse=new WaitResponse();
					WaitResponse.setStatus(6);
					WaitResponse.setTotal(num.getData());
					WaitResponse.setUrl("pm.menu.implement");
					WaitResponse.setCs("");
					set.add(WaitResponse);
					//PM6
				}else{
					WaitResponse WaitResponse=new WaitResponse();
					WaitResponse.setStatus(6);
					WaitResponse.setTotal(0);
					WaitResponse.setUrl("pm.menu.implement");
					WaitResponse.setCs("");
					set.add(WaitResponse);
				}
			}
					
		}
		//转科审核7
		Result<Boolean> resultZk=userPermissionService.checkIsTransfer(id,token );
		if(resultZk!=null){
			if(resultZk.getData()){
				Result<Integer> resultZknum=userClientService.assAssetsTransfer(tenantId, token);
				if(resultZknum!=null){
					WaitResponse WaitResponse=new WaitResponse();
					WaitResponse.setStatus(7);
					WaitResponse.setTotal(resultZknum.getData());
					WaitResponse.setUrl("main.tre.zkgl.list");
					WaitResponse.setCs("1");
					set.add(WaitResponse);
				}else{
					WaitResponse WaitResponse=new WaitResponse();
					WaitResponse.setStatus(7);
					WaitResponse.setTotal(0);
					WaitResponse.setUrl("main.tre.zkgl.list");
					WaitResponse.setCs("1");
					set.add(WaitResponse);
				}
			}
					
		}
		//报损审核8
		Result<Boolean> resultBs=userPermissionService.checkIsDiscard(id,token );
		if(resultBs!=null){
			if(resultBs.getData()){
				Result<Integer> resultBsnum=userClientService.assDiscard(tenantId, token);
				if(resultBsnum!=null){
					WaitResponse WaitResponse=new WaitResponse();
					WaitResponse.setStatus(8);
					WaitResponse.setTotal(resultBsnum.getData());
					WaitResponse.setUrl("main.tre.bsgl.browse");
					WaitResponse.setCs("1");
					set.add(WaitResponse);
				}else{
					WaitResponse WaitResponse=new WaitResponse();
					WaitResponse.setStatus(8);
					WaitResponse.setTotal(0);
					WaitResponse.setUrl("main.tre.bsgl.browse");
					WaitResponse.setCs("1");
					set.add(WaitResponse);
				}
			}
			
		}

		//9 Qc Check
		Result<Boolean> resultQcCheck = userPermissionService.checkIsRht(id, "QC_CHECK_MANAGE", token);
		if (resultQcCheck != null) {
			if (resultQcCheck.getData()) {
				Result<Integer> num = qcClientService.getQcCheckWaitToDo(id, token);
				if (num != null) {
					WaitResponse WaitResponse = new WaitResponse();
					WaitResponse.setStatus(9);
					WaitResponse.setTotal(num.getData());
					WaitResponse.setUrl("inspection.acceptance");
					WaitResponse.setCs("1");
					set.add(WaitResponse);
					// PM6
				} else {
					WaitResponse WaitResponse = new WaitResponse();
					WaitResponse.setStatus(9);
					WaitResponse.setTotal(0);
					WaitResponse.setUrl("inspection.acceptance");
					WaitResponse.setCs("1");
					set.add(WaitResponse);
				}
			}

		}

		//10 PM Check
		Result<Boolean> resultPmCheck = userPermissionService.checkIsRht(id, "PM_CHECK_MANAGE", token);
		if (resultPmCheck != null) {
			if (resultPmCheck.getData()) {
				Result<Integer> num = qcClientService.getPmCheckWaitToDo(id, token);
				if (num != null) {
					WaitResponse WaitResponse = new WaitResponse();
					WaitResponse.setStatus(10);
					WaitResponse.setTotal(num.getData());
					WaitResponse.setUrl("pm.menu.acceptance");
					WaitResponse.setCs("1");
					set.add(WaitResponse);
					// PM6
				} else {
					WaitResponse WaitResponse = new WaitResponse();
					WaitResponse.setStatus(10);
					WaitResponse.setTotal(0);
					WaitResponse.setUrl("pm.menu.acceptance");
					WaitResponse.setCs("1");
					set.add(WaitResponse);
				}
			}

		}
		//MD 11
		Result<Boolean> resultMdCheck = userPermissionService.checkIsRht(id, "MD_CHECK_MANAGE", token);
		if (resultMdCheck != null) {
			if (resultMdCheck.getData()) {
				Result<Integer> num = qcClientService.getMdWaitToDo(tenantId, token);
				if (num != null) {
					WaitResponse WaitResponse = new WaitResponse();
					WaitResponse.setStatus(11);
					WaitResponse.setTotal(num.getData());
					WaitResponse.setUrl("quality.menu.audit");
					WaitResponse.setCs("2");
					set.add(WaitResponse);
					// PM6
				} else {
					WaitResponse WaitResponse = new WaitResponse();
					WaitResponse.setStatus(11);
					WaitResponse.setTotal(0);
					WaitResponse.setUrl("quality.menu.audit");
					WaitResponse.setCs("2");
					set.add(WaitResponse);
				}
			}

		}
		return response(set);
	}
	
	/**
	 * 根据资产ID查询维修记录(分页)
	 */
	@PreAuthorize("isAuthenticated()")
	@GetMapping(value = "/repairRecord")
	@ApiOperation(value = "根据资产ID查询维修记录(分页)", httpMethod = "GET", produces = "application/json")
	@ApiImplicitParams({ 
	@ApiImplicitParam(name = "pageNo", value = "起始页 [默认1]", paramType = "query", required = false),
	@ApiImplicitParam(name = "assetsId", value = "设备ID", paramType = "query", required = true),
	@ApiImplicitParam(name = "applyNo", value = "维修单号", paramType = "query", required = false),
	@ApiImplicitParam(name = "modeStatus", value = "维修方式（1，自主维修 2，外修 3，现场解决）", paramType = "query", required = false),
	@ApiImplicitParam(name = "pageSize", value = "分页大小[默认10]", paramType = "query", required = false) })
	@ApiResponse(code = 200, message = "OK", response = Result.class)
	public Result<Page<RepairRecordResponse>> repairRecord(RepRepairRecordQuery query) {
		logger.debug("<---------------------------------"+JSON.toJSONString(query));
		Page<RepairRecordResponse> page = repRepairApplyService.repairRecord(query);
		return response(page);
	}
	
	/**
	 * 转单
	 */
	@PreAuthorize("isAuthenticated()")
	@PostMapping(value = "/turnOrder")
	@ApiOperation(value = "转单")
	@ApiResponse(code = 200, message = "OK", response = Result.class)
	public Result<Object> turnOrder(@RequestBody ApplyTurnOrderRequest request) {
		if(request!=null){
			repRepairApplyService.turnOrder(request);
			return response();	
		}else{
			throw ExceptionFactory.create("W_014");
		}
	}
	/**
	 * (根据申请单id)转单记录
	 */
	@PreAuthorize("isAuthenticated()")
	@GetMapping(value = "/turnOrderRecord/{id}")
	@ApiOperation(value = "(根据申请单id)转单记录")
	@ApiResponse(code = 200, message = "OK", response = Result.class)
	public Result<List<RepTurnOrders>> turnOrderRecord(@PathVariable(value = "id", required = true)Long id) {
		Wrapper<RepTurnOrders> wrapper=new EntityWrapper<>();
		wrapper.eq("apply_id", id);
		List<RepTurnOrders> list=repTurnOrdersService.selectList(wrapper);
		return response(list);
		
	}
	
	
	@PostMapping(value="/sendWeiXinMessageTest")
	public void sendWeiXinMessageTest(){
		RepRepairApply  repRepairApply = repRepairApplyService.selectById(1);
		//用户接单时，将申请单消息推送给本机构下拥有维修(填写维修报告单)权限的用户
		WeiXinRepairMessageRequest repairMessageBody = BeanMapper.map(repRepairApply, WeiXinRepairMessageRequest.class);
		repairMessageBody.setApplyId(repRepairApply.getId());
		repairMessageBody.setType(WeiXinRepairMessageTypeEnum.CHECK.getType());
		Result<List<Map<String, Object>>> messageResult = authClientService.sendWeiXinRepairMessage(repairMessageBody, WebSecurityUtils.getCurrentToken());
		logger.info("用户接单推送消息接口返回结果="+(messageResult!=null?messageResult.getData().toString():null));
	}

	
}
