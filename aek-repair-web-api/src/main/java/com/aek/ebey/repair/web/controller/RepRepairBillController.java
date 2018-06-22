package com.aek.ebey.repair.web.controller;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aek.common.core.BeanMapper;
import com.aek.common.core.Result;
import com.aek.common.core.base.BaseController;
import com.aek.common.core.exception.ExceptionFactory;
import com.aek.common.core.serurity.WebSecurityUtils;
import com.aek.common.core.serurity.model.AuthUser;
import com.aek.ebey.repair.enums.RepairBillStatusEnum;
import com.aek.ebey.repair.model.RepRepairBill;
import com.aek.ebey.repair.model.RepRepairBillCheckConfig;
import com.aek.ebey.repair.model.RepRepairBillCheckFlow;
import com.aek.ebey.repair.model.RepRepairBillFile;
import com.aek.ebey.repair.model.RepRepairBillParts;
import com.aek.ebey.repair.query.RepRepairBillApplyQuery;
import com.aek.ebey.repair.query.RepRepairBillApproveQuery;
import com.aek.ebey.repair.query.RepRepairBillQuery;
import com.aek.ebey.repair.request.RepRepairBillApplyResponse;
import com.aek.ebey.repair.request.RepRepairBillApproveResponse;
import com.aek.ebey.repair.request.RepRepairBillCheckFlowResponse;
import com.aek.ebey.repair.request.RepRepairBillCheckRequest;
import com.aek.ebey.repair.request.RepRepairBillDetailResponse;
import com.aek.ebey.repair.request.RepRepairBillPrintDetailResponse;
import com.aek.ebey.repair.service.RepRepairApplyService;
import com.aek.ebey.repair.service.RepRepairBillCheckConfigService;
import com.aek.ebey.repair.service.RepRepairBillCheckFlowService;
import com.aek.ebey.repair.service.RepRepairBillService;
import com.aek.ebey.repair.web.request.RepRepairBillRequest;
import com.aek.ebey.repair.web.request.RepRepairWorkflowRequest;
import com.aek.ebey.repair.web.utils.OrderUtils;
import com.aek.ebey.repair.web.validator.group.Add;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.plugins.Page;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

/**
 * 维修单据Controller
 *	
 * @author HongHui
 * @date   2018年1月29日
 */
@RestController
@Api(value = "RepRepairBillController", description = "维修单据申请")
@RequestMapping("/newrepair/bill")
public class RepRepairBillController extends BaseController {
	
	private static final Logger logger = LoggerFactory.getLogger(RepRepairBillController.class);
	
	@Autowired
	private RepRepairApplyService repRepairApplyService;
	
	@Autowired
	private RepRepairBillService repRepairBillService;
	
	@Autowired
	private RepRepairBillCheckFlowService  repRepairBillCheckFlowService;
	
	@Autowired
	private RepRepairBillCheckConfigService repRepairBillCheckConfigService;
	
	/**
	 * 新建维修单据申请选择维修单列表(分页)
	 */
	@GetMapping(value = "/getRepairApplyPage")
	@ApiOperation(value = "新建维修单据申请选择维修单列表(分页)", httpMethod = "GET", produces = "application/json")
	@ApiImplicitParams({ @ApiImplicitParam(name = "pageNo", value = "起始页 [默认1]", paramType = "query", required = false),
			@ApiImplicitParam(name = "pageSize", value = "分页大小[默认10]", paramType = "query", required = false),
			@ApiImplicitParam(name = "assetsDeptName", value = "所在科室", paramType = "query", required = false),
			@ApiImplicitParam(name = "assetsName", value = "设备名称", paramType = "query", required = false),
			@ApiImplicitParam(name = "tenantId", value = "机构ID", paramType = "query", required = false),
			@ApiImplicitParam(name = "keyword", value = "关键字(维修单号)", paramType = "query") })
	@ApiResponse(code = 200, message = "OK", response = Result.class)
	public Result<Page<RepRepairBillApplyResponse>> getApplyPage(RepRepairBillApplyQuery query) {
		logger.debug("======新建维修单据申请选择维修单列表(分页)=====");
		Page<RepRepairBillApplyResponse> page = repRepairApplyService.getRepairApplyPageForBill(query);
		return response(page);
	}
	
	
	/**
	 * 新建维修单据申请
	 */
	@PreAuthorize("hasAuthority('REP_REPAIR_PRICE_APPLY')")
	@PostMapping(value = "/add")
	@ApiOperation(value = "新建维修单据申请")
	@ApiResponse(code = 200, message = "OK", response = Result.class)
	public Result<RepRepairBill> add(@Validated(value = Add.class) @RequestBody RepRepairBillRequest request){
		logger.debug("======新建维修单据申请=====");
		AuthUser authUser = WebSecurityUtils.getCurrentUser();
		RepRepairBill repRepairBill = BeanMapper.map(request, RepRepairBill.class);
		// 状态审核中
		repRepairBill.setStatus(RepairBillStatusEnum.CHECKING.getNumber());
		// 机构ID
		repRepairBill.setTenantId(authUser==null ? null : authUser.getTenantId());
		// 机构名称
		repRepairBill.setTenantName(authUser==null ? null : authUser.getTenantName());
		// 申请人ID
		repRepairBill.setApplyUserId(authUser==null ? null : authUser.getId());
		// 申请人姓名
		repRepairBill.setApplyUserName(authUser==null ? null : authUser.getRealName());
		// 申请人所在科室
		repRepairBill.setApplyUserDeptName(authUser==null ? null : authUser.getDeptName());
		// 单据申请时间
		repRepairBill.setApplyTime(new Date());
		// 设置申请单号
		repRepairBill.setBillNo(OrderUtils.getBillNum());
		// 配件信息
		List<RepRepairBillParts> billParts = request.getBillParts();
		// 附件信息
		List<RepRepairBillFile> billFiles = request.getBillFiles();
		// 保存
		this.repRepairBillService.save(repRepairBill,billParts,billFiles);
		return response(repRepairBill);
	}
	
	/**
	 * 单据申请页面维修单据列表(分页)
	 */
	@GetMapping(value = "/getRepairBillPage")
	@ApiOperation(value = "单据申请页面维修单据列表(分页)", httpMethod = "GET", produces = "application/json")
	@ApiImplicitParams({ @ApiImplicitParam(name = "pageNo", value = "起始页 [默认1]", paramType = "query", required = false),
			@ApiImplicitParam(name = "pageSize", value = "分页大小[默认10]", paramType = "query", required = false),
			@ApiImplicitParam(name = "applyType", value = "申请类型(1=我的申请，2=全院申请)", paramType = "query", required = false),
			@ApiImplicitParam(name = "type", value = "单据类型(1=外修费用,2=配件采购)", paramType = "query", required = false),
			@ApiImplicitParam(name = "status", value = "状态(1=审批中，2=审批通过，3=审批未通过，4=已撤销)", paramType = "query", required = false),
			@ApiImplicitParam(name = "tenantId", value = "机构ID", paramType = "query", required = false),
			@ApiImplicitParam(name = "keyword", value = "关键字(申请单号/设备名称)", paramType = "query") })
	@ApiResponse(code = 200, message = "OK", response = Result.class)
	public Result<Object> getRepairBillPageList(RepRepairBillQuery query) {
		logger.debug("======单据申请页面维修单据列表(分页)=====");
		Page<RepRepairBill> page = repRepairBillService.getRepairBillPage(query);
		List<RepRepairBill> list = page.getRecords();
		for (RepRepairBill repRepairBill : list) {
			repRepairBill.setTypeText(1==repRepairBill.getType()?"外修费用":"配件采购");
			Integer status = repRepairBill.getStatus();
			String statusText = "审批中";
			if(status==1){statusText="审批中";}
			if(status==2){statusText="审批通过";}
			if(status==3){statusText="审批未通过";}
			if(status==4){statusText="已撤销";}
			repRepairBill.setStatusText(statusText);
		}
		return response(page);
	}
	
	/**
	 * 获取维修单据申请详情
	 */
	@GetMapping(value = "/getBillDetails/{id}")
	@ApiOperation(value = "获取维修单据申请详情")
	@ApiResponse(code = 200, message = "OK", response = Result.class)
	public Result<RepRepairBillDetailResponse> getBillDetails(@PathVariable(value = "id", required = true) Long id) {
		logger.debug("======获取维修单据申请详情=====");
		return response(repRepairBillService.getBillDetails(id));
	}
	

	/**
	 * 获取维修单据申请详情
	 */
	@GetMapping(value = "/getBillDetails2/{id}")
	@ApiOperation(value = "获取维修单据申请详情")
	@ApiResponse(code = 200, message = "OK", response = Result.class)
	public Result<RepRepairBillDetailResponse> getBillDetails2(@PathVariable(value = "id", required = true) Long id) {
		logger.debug("======获取维修单据申请详情=====");
		return response(repRepairBillService.getBillDetails2(id));
	}
	
	/**
	 * 撤销维修单据申请
	 */
	@PostMapping(value = "/revoke/{id}")
	@ApiOperation(value = "撤销维修单据申请")
	@ApiResponse(code = 200, message = "OK", response = Result.class)
	public Result<Object> revokeBill(@PathVariable(value = "id", required = true) Long id) {
		logger.debug("======撤销维修单据申请=====");
		AuthUser authUser = WebSecurityUtils.getCurrentUser();
		RepRepairBill repRepairBill = repRepairBillService.selectById(id);
		if(!repRepairBill.getApplyUserId().equals(authUser.getId())){
			throw ExceptionFactory.create("B_007");
		}
		if(RepairBillStatusEnum.CANCEL.getNumber().equals(repRepairBill.getStatus())){
			throw ExceptionFactory.create("B_008");
		}
		if(!RepairBillStatusEnum.CHECKING.getNumber().equals(repRepairBill.getStatus())){
			throw ExceptionFactory.create("B_006");
		}
		repRepairBill.setStatus(RepairBillStatusEnum.CANCEL.getNumber());
		repRepairBillService.updateById(repRepairBill);
		return response();
	}
	
	/**
	 * 获取维修单据申请打印内容
	 */
	@GetMapping(value = "/getBillPrintDetails/{id}")
	@ApiOperation(value = "获取维修单据申请打印内容")
	@ApiResponse(code = 200, message = "OK", response = Result.class)
	public Result<RepRepairBillPrintDetailResponse> getBillPrintDetails(@PathVariable(value = "id", required = true) Long id) {
		logger.debug("======获取维修单据申请打印内容=====");
		return response(repRepairBillService.getBillPrintDetails(id));
	}
	
	/**
	 * 获取维修单据流程详情
	 */
	@GetMapping(value = "/getCheckFlowDetails/{id}")
	@ApiOperation(value = "获取维修单据申请打印内容")
	@ApiResponse(code = 200, message = "OK", response = Result.class)
	public Result<RepRepairBillCheckFlowResponse> getRepRepairBillCheckFlowDetail(@PathVariable(value = "id", required = true) Long id){
		logger.debug("======获取维修单据流程详情=====");
		RepRepairBillCheckFlow repRepairBillCheckFlow = repRepairBillCheckFlowService.selectById(id);
		RepRepairBillCheckFlowResponse  repRepairBillCheckFlowResponse = new RepRepairBillCheckFlowResponse();
		repRepairBillCheckFlowResponse.setCheckRemark(repRepairBillCheckFlow.getCheckRemark());
		Integer checkStatus = repRepairBillCheckFlow.getCheckStatus();
		String checkResult = "待审批";
		if(checkStatus==1){checkResult="待审批";}
		if(checkStatus==2){checkResult="审批通过";}
		if(checkStatus==3){checkResult="审批未通过";}
		repRepairBillCheckFlowResponse.setCheckResult(checkResult);
		return response(repRepairBillCheckFlowResponse);
	}
	
	/**
	 * 待我审批列表(分页)
	 */
	@GetMapping(value = "/waitApprove")
	@ApiOperation(value = "待我审批列表(分页)", httpMethod = "GET", produces = "application/json")
	@ApiImplicitParams({ @ApiImplicitParam(name = "pageNo", value = "起始页 [默认1]", paramType = "query", required = false),
			@ApiImplicitParam(name = "pageSize", value = "分页大小[默认10]", paramType = "query", required = false),
			@ApiImplicitParam(name = "type", value = "单据类型(1=外修费用,2=配件采购)", paramType = "query", required = false),
			@ApiImplicitParam(name = "status", value = "状态(1=审批中)", paramType = "query", required = false),
			@ApiImplicitParam(name = "keyword", value = "关键字(申请单号/设备名称)", paramType = "query") })
	@ApiResponse(code = 200, message = "OK", response = Result.class)
	public Result<Page<RepRepairBillApproveResponse>> getRepairBillApprovePage(RepRepairBillApproveQuery query) {
		logger.debug("======待我审批列表(分页)=====");
		Page<RepRepairBillApproveResponse> page = repRepairBillService.getRepairBillApprovePage(query);
		return response(page);
	}
	
	/**
	 * 查询待巡检待办
	 */
	@GetMapping(value = "/getWaitToDo")
	@ApiOperation(value = "查询巡检计划详情")
	@ApiResponse(code = 200, message = "OK", response = Result.class)
	public Result<Integer> getWaitToDo(Long id) {
		logger.debug("<---------------------getPmImplementWaitToDo------------");
		Integer  i =repRepairBillService.getWaitToDo(id);
		return response(i);
		
	}
	
	/**
	 * 我已批列表(分页)
	 */
	@GetMapping(value = "/approved")
	@ApiOperation(value = " 我已批列表(分页)", httpMethod = "GET", produces = "application/json")
	@ApiImplicitParams({ @ApiImplicitParam(name = "pageNo", value = "起始页 [默认1]", paramType = "query", required = false),
			@ApiImplicitParam(name = "pageSize", value = "分页大小[默认10]", paramType = "query", required = false),
			@ApiImplicitParam(name = "type", value = "单据类型(1=外修费用,2=配件采购)", paramType = "query", required = false),
			@ApiImplicitParam(name = "status", value = "状态(2=审批通过，3=审批未通过。4=以审批)", paramType = "query", required = false),
			@ApiImplicitParam(name = "keyword", value = "关键字(申请单号/设备名称)", paramType = "query") })
	@ApiResponse(code = 200, message = "OK", response = Result.class)
	public Result<Page<RepRepairBillApproveResponse>> approved(RepRepairBillApproveQuery query) {
		logger.debug("====== 我已批列表(分页)=====");
		Page<RepRepairBillApproveResponse> page = repRepairBillService.getRepairBillApprovePage2(query);
		return response(page);
	}
	
	/**
	 * 单据申请审批
	 */
	@PreAuthorize("hasAuthority('REP_REPAIR_PRICE_CHECK')")
	@PostMapping(value = "/check")
	@ApiOperation(value = "单据申请审批")
	@ApiResponse(code = 200, message = "OK", response = Result.class)
	public Result<Object> check(@RequestBody RepRepairBillCheckRequest request) {
		logger.debug("======单据申请审批====="+JSON.toJSONString(request));
		repRepairBillService.selectCheck(request);
		return response();
	}
	
	/**
	 * 工作流配置保存
	 * @param reqList
	 * @return
	 */
	@PreAuthorize("hasAuthority('REP_REPAIR_CONFIG')")
	@PostMapping(value = "/saveWorkflow")
	@ApiOperation(value = "工作流配置保存")
	@ApiResponse(code = 200, message = "OK", response = Result.class)
	public Result<Object> saveWorkflow(@RequestBody List<RepRepairWorkflowRequest> reqList){
		List<RepRepairBillCheckConfig> list = BeanMapper.mapList(reqList, RepRepairBillCheckConfig.class);
		repRepairBillCheckConfigService.saveWorkflow(list);
		return response();	
	}
	
	/**
	 * 工作流配置查询
	 * @return
	 */
	@PreAuthorize("hasAuthority('REP_REPAIR_CONFIG')")
	@GetMapping(value = "/getWorkflow")
	@ApiOperation(value = "工作流配置查询")
	@ApiResponse(code = 200, message = "OK", response = Result.class)
	public Result<List<RepRepairBillCheckConfig>> getWorkflow(){
		return response(repRepairBillCheckConfigService.getRepRepairBillCheckConfigDetail());	
	}
}
