package com.aek.ebey.repair.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aek.common.core.base.BaseServiceImpl;
import com.aek.common.core.exception.BusinessException;
import com.aek.common.core.exception.ExceptionFactory;
import com.aek.common.core.serurity.WebSecurityUtils;
import com.aek.common.core.serurity.model.AuthUser;
import com.aek.ebey.repair.core.BeanMapper;
import com.aek.ebey.repair.enums.RepairBillCheckStatusEnum;
import com.aek.ebey.repair.mapper.RepRepairBillCheckFlowMapper;
import com.aek.ebey.repair.mapper.RepRepairBillMapper;
import com.aek.ebey.repair.model.RepRepairBill;
import com.aek.ebey.repair.model.RepRepairBillCheckConfig;
import com.aek.ebey.repair.model.RepRepairBillCheckFlow;
import com.aek.ebey.repair.model.RepRepairBillFile;
import com.aek.ebey.repair.model.RepRepairBillParts;
import com.aek.ebey.repair.query.RepRepairBillApproveQuery;
import com.aek.ebey.repair.query.RepRepairBillQuery;
import com.aek.ebey.repair.request.RepRepairBillApproveResponse;
import com.aek.ebey.repair.request.RepRepairBillCheckRequest;
import com.aek.ebey.repair.request.RepRepairBillDetailResponse;
import com.aek.ebey.repair.request.RepRepairBillLogResponse;
import com.aek.ebey.repair.request.RepRepairBillPrintDetailResponse;
import com.aek.ebey.repair.request.SendMessage;
import com.aek.ebey.repair.service.RepRepairBillCheckConfigService;
import com.aek.ebey.repair.service.RepRepairBillCheckFlowService;
import com.aek.ebey.repair.service.RepRepairBillFileService;
import com.aek.ebey.repair.service.RepRepairBillPartsService;
import com.aek.ebey.repair.service.RepRepairBillService;
import com.aek.ebey.repair.service.RepRepairMessageService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;

/**
 * 维修单据申请服务实现类
 *	
 * @author HongHui
 * @date   2018年1月29日
 */
@Service
@Transactional
public class RepRepairBillServiceImpl extends BaseServiceImpl<RepRepairBillMapper, RepRepairBill> implements RepRepairBillService {

	private static final Logger logger = LoggerFactory.getLogger(RepRepairBillServiceImpl.class);
	
	@Autowired
	private RepRepairBillMapper repRepairBillMapper;
	
	@Autowired
	private RepRepairBillCheckFlowMapper repRepairBillCheckFlowMapper;
	
	@Autowired
	private RepRepairBillFileService repRepairBillFileService;
	
	@Autowired
	private RepRepairBillPartsService repRepairBillPartsService;
	
	@Autowired
	private RepRepairBillCheckConfigService repRepairBillCheckConfigService;
	
	@Autowired
	private RepRepairBillCheckFlowService repRepairBillCheckFlowService;
	
	@Autowired
	private RepRepairMessageService repRepairMessageService;

	@Override
	public void save(RepRepairBill repRepairBill, List<RepRepairBillParts> billParts,
			List<RepRepairBillFile> billFiles) {
		AuthUser authUser = WebSecurityUtils.getCurrentUser();
		// 保存维修申请单、附件、配件等信息
		repRepairBillMapper.insert(repRepairBill);
		if(null != billFiles && billFiles.size() > 0){
			for (RepRepairBillFile repRepairBillFile : billFiles) {
				repRepairBillFile.setBillId(repRepairBill.getId());
			}
			repRepairBillFileService.insertBatch(billFiles);
		}
		if(null != billParts && billParts.size() > 0){
			for (RepRepairBillParts repRepairBillPart : billParts) {
				repRepairBillPart.setBillId(repRepairBill.getId());
				repRepairBillPart.setCreateTime(new Date());
			}
			repRepairBillPartsService.insertBatch(billParts);
		}
		// 判断机构是否已经配置审批流程
		List<RepRepairBillCheckConfig> repRepairBillCheckConfigListByTenant = repRepairBillCheckConfigService.getRepRepairBillCheckConfig(authUser.getTenantId());
		if(null == repRepairBillCheckConfigListByTenant || (null != repRepairBillCheckConfigListByTenant && repRepairBillCheckConfigListByTenant.size() == 0)){
			throw ExceptionFactory.create("B_005");
		}
		RepRepairBillCheckConfig minConfig = repRepairBillCheckConfigListByTenant.get(0);
		if(repRepairBill.getFee().compareTo(minConfig.getMinFee()) == -1){
			throw new BusinessException("B_009", "金额未达标，申请金额必须不小于"+minConfig.getMinFee());
		}
		// 根据单据费用大小获取当前机构审批流程配置信息,按index正序排序
		List<RepRepairBillCheckConfig> repRepairBillCheckConfigList = repRepairBillCheckConfigService.getRepRepairBillCheckConfig(authUser.getTenantId(),repRepairBill.getFee());
		// 保存当前机构审批流程
		for (RepRepairBillCheckConfig repRepairBillCheckConfig : repRepairBillCheckConfigList) {
			RepRepairBillCheckFlow repRepairBillCheckFlow = new RepRepairBillCheckFlow();
			repRepairBillCheckFlow.setBillId(repRepairBill.getId());
			repRepairBillCheckFlow.setCheckStatus(RepairBillCheckStatusEnum.WAIT_CHECK.getNumber());
			repRepairBillCheckFlow.setCheckUserId(repRepairBillCheckConfig.getCheckUserId());
			repRepairBillCheckFlow.setCheckUserName(repRepairBillCheckConfig.getCheckUserName());
			repRepairBillCheckFlow.setCheckUserMobile(repRepairBillCheckConfig.getCheckUserMobile());
			repRepairBillCheckFlow.setIndex(repRepairBillCheckConfig.getIndex());
			repRepairBillCheckFlow.setFlowName(repRepairBillCheckConfig.getIndexName());
			repRepairBillCheckFlowMapper.insert(repRepairBillCheckFlow);
			
		}
		// 设置当前单据审批流程为排序最前的流程
		RepRepairBillCheckConfig repRepairBillCheckConfig = repRepairBillCheckConfigList.get(0);
		repRepairBill.setCurrentIndex(repRepairBillCheckConfig == null ? null : repRepairBillCheckConfig.getIndex());
		repRepairBill.setTotalIndex(repRepairBillCheckConfigList.size());
		repRepairBillMapper.updateById(repRepairBill);
	}

	@Override
	public Page<RepRepairBill> getRepairBillPage(RepRepairBillQuery query) {
		AuthUser authUser = WebSecurityUtils.getCurrentUser();
		Page<RepRepairBill> page = query.getPage();
		Wrapper<RepRepairBill> wrapper = new EntityWrapper<RepRepairBill>();
		if (query.getTenantId() != null) {
			wrapper.eq("tenant_id", query.getTenantId());
		}

		if (query.getApplyType() != null && query.getApplyType() == 1) {
			wrapper.eq("apply_user_id", authUser.getId());
		}

		if (query.getStatus() != null) {
			wrapper.eq("status", query.getStatus());
		}

		if (query.getType() != null) {
			wrapper.eq("type", query.getType());
		}
		String keyword = StringUtils.trimToNull(query.getKeyword());
		if (keyword != null) {
			if (keyword.startsWith("%") || keyword.startsWith("[") || keyword.startsWith("[]")
					|| keyword.startsWith("_")) {
				wrapper.andNew("assets_name LIKE {0} OR bill_no LIKE {0}", "%[" + keyword + "]%");
			} else {
				wrapper.andNew("assets_name LIKE {0} OR bill_no LIKE {0}", "%" + keyword + "%");
			}
		}
		wrapper.orderBy("status", true).orderBy("apply_time", false);
		return this.selectPage(page, wrapper);
	}
	
	@Override
	public RepRepairBillDetailResponse getBillDetails(Long id) {
		// 维修单据
		RepRepairBill repRepairBill = repRepairBillMapper.selectById(id);
		// 维修单据附件
		List<RepRepairBillFile> repRepairBillFileList = repRepairBillFileService.getRepRepairBillFile(repRepairBill.getId());
		// 维修单据配件
		List<RepRepairBillParts> repRepairBillPartsList = repRepairBillPartsService.getRepRepairBillParts(repRepairBill.getId());
		List<RepRepairBillLogResponse> repRepairBillLogList = new ArrayList<RepRepairBillLogResponse>();
		// 申请日志
		RepRepairBillLogResponse applyLog = new RepRepairBillLogResponse();
		applyLog.setOperator(repRepairBill.getApplyUserName());
		applyLog.setOperateName("提交申请");
		applyLog.setOperateStatus(0);
		applyLog.setOperateTime(repRepairBill.getApplyTime());
		repRepairBillLogList.add(applyLog);
		// 单据审批流程
		Long currentCheckUserId = null;
		List<RepRepairBillCheckFlow> repRepairBillCheckFlowList = repRepairBillCheckFlowService.getRepRepairBillCheckFlow(repRepairBill.getId());
		for (RepRepairBillCheckFlow repRepairBillCheckFlow : repRepairBillCheckFlowList) {
			RepRepairBillLogResponse checkFlowLog = new RepRepairBillLogResponse();
			checkFlowLog.setCheckFlowId(repRepairBillCheckFlow.getId());
			checkFlowLog.setOperateStatus(repRepairBillCheckFlow.getCheckStatus());
			Integer checkStatus = repRepairBillCheckFlow.getCheckStatus();
			String operateName = "待审批";
			if(checkStatus==1){operateName="待审批";}
			if(checkStatus==2){operateName="审批通过";}
			if(checkStatus==3){operateName="审批未通过";}
			checkFlowLog.setOperateName(operateName);
			checkFlowLog.setOperateTime(repRepairBillCheckFlow.getCheckTime());
			checkFlowLog.setOperator(repRepairBillCheckFlow.getCheckUserName());
			repRepairBillLogList.add(checkFlowLog);
			if(repRepairBill.getCurrentIndex()==repRepairBillCheckFlow.getIndex()){
				currentCheckUserId = repRepairBillCheckFlow.getCheckUserId();
			}
		}
		RepRepairBillDetailResponse repRepairBillDetailResponse = BeanMapper.map(repRepairBill, RepRepairBillDetailResponse.class);
		repRepairBillDetailResponse.setBillFiles(repRepairBillFileList);
		repRepairBillDetailResponse.setBillLogs(repRepairBillLogList);
		repRepairBillDetailResponse.setBillParts(repRepairBillPartsList);
		repRepairBillDetailResponse.setCurrentCheckUserId(currentCheckUserId);
		return repRepairBillDetailResponse;
	}

	@Override
	public RepRepairBillPrintDetailResponse getBillPrintDetails(Long id) {
		// 维修单据
		RepRepairBill repRepairBill = repRepairBillMapper.selectById(id);
		// 维修单据附件
		List<RepRepairBillFile> repRepairBillFileList = repRepairBillFileService.getRepRepairBillFile(repRepairBill.getId());
		// 维修单据配件
		List<RepRepairBillParts> repRepairBillPartsList = repRepairBillPartsService.getRepRepairBillParts(repRepairBill.getId());
		// 单据审批流程
		List<RepRepairBillCheckFlow> repRepairBillCheckFlowList = repRepairBillCheckFlowService.getRepRepairBillCheckFlow(repRepairBill.getId());
		// 已审批流程
		List<RepRepairBillCheckFlow> repRepairBillCheckFlowCheckedList = new ArrayList<RepRepairBillCheckFlow>();
		for (RepRepairBillCheckFlow repRepairBillCheckFlow : repRepairBillCheckFlowList) {
			Integer checkStatus = repRepairBillCheckFlow.getCheckStatus();
			String checkStatusText = "待审批";
			if(checkStatus==1){checkStatusText="待审批";}
			if(checkStatus==2){checkStatusText="审批通过";}
			if(checkStatus==3){checkStatusText="审批未通过";}
			repRepairBillCheckFlow.setCheckStatusText(checkStatusText);
			if(checkStatus != 1){
				repRepairBillCheckFlowCheckedList.add(repRepairBillCheckFlow);
			}
		}
		RepRepairBillPrintDetailResponse repRepairBillPrintDetailResponse = BeanMapper.map(repRepairBill, RepRepairBillPrintDetailResponse.class);
		repRepairBillPrintDetailResponse.setBillFiles(repRepairBillFileList);
		repRepairBillPrintDetailResponse.setBillFlows(repRepairBillCheckFlowList);
		repRepairBillPrintDetailResponse.setBillParts(repRepairBillPartsList);
		
		//设置审批时间
		if(repRepairBillCheckFlowCheckedList.size() > 0){
			RepRepairBillCheckFlow lastCheckFlow = repRepairBillCheckFlowCheckedList.get(repRepairBillCheckFlowCheckedList.size()-1);
			repRepairBillPrintDetailResponse.setCheckTime(lastCheckFlow==null ? null : lastCheckFlow.getCheckTime());
		}
		return repRepairBillPrintDetailResponse;
	}

	@Override
	public Page<RepRepairBillApproveResponse> getRepairBillApprovePage(RepRepairBillApproveQuery query) {
		AuthUser authUser = WebSecurityUtils.getCurrentUser();
		Page<RepRepairBillApproveResponse> page = query.getPage();
		List<RepRepairBillApproveResponse> list=repRepairBillCheckFlowService.getRepairBillApprovePage(page,query,authUser);
		for (RepRepairBillApproveResponse repRepairBillResponse : list) {
			repRepairBillResponse.setTypeText(repRepairBillResponse.getType()==1?"外修费用":"配件采购");
			Integer status = repRepairBillResponse.getStatus();
			String statusText = "审批中";
			if(status==1){statusText="审批中";}
			if(status==2){statusText="审批通过";}
			if(status==3){statusText="审批未通过";}
			if(status==4){statusText="已撤销";}
			repRepairBillResponse.setStatusText(statusText);
		}
		page.setRecords(list);
		return page;
	}

	@Override
	public void selectCheck(RepRepairBillCheckRequest request) {
		Long id=request.getId();
		AuthUser authUser = WebSecurityUtils.getCurrentUser();
		RepRepairBill repRepairBill=repRepairBillMapper.selectById(id);
		if(repRepairBill!=null){
			if(1==repRepairBill.getStatus().intValue()){
				int index=repRepairBill.getCurrentIndex();
				Wrapper<RepRepairBillCheckFlow> wrapper=new EntityWrapper<>();
				wrapper.eq("bill_id", id).eq("`index`", index).eq("check_user_id", authUser.getId()).eq("check_status", 1);
				RepRepairBillCheckFlow repRepairBillCheckFlow=	repRepairBillCheckFlowService.selectOne(wrapper);
				if(repRepairBillCheckFlow!=null){
					repRepairBillCheckFlow.setCheckStatus(request.getStatus());
					repRepairBillCheckFlow.setCheckRemark(request.getRemark());
					repRepairBillCheckFlow.setCheckTime(new Date());
					repRepairBillCheckFlowService.updateById(repRepairBillCheckFlow);
					//审批不通过
					if(request.getStatus().intValue()==3){
						repRepairBill.setStatus(3);
						SendMessage  message=new SendMessage();
						message.setModuleId(repRepairBill.getId());
						message.setRemarks(repRepairBill.getAssetsDeptName());
						message.setMessageContent("维修单据审批未通过，查看详情");
						message.setStatus(2);
						message.setUserId(repRepairBill.getApplyUserId());
						repRepairMessageService.save(message);
					}else{
						if(repRepairBill.getCurrentIndex().intValue()==repRepairBill.getTotalIndex().intValue()){
							repRepairBill.setStatus(request.getStatus());
							SendMessage  message=new SendMessage();
							message.setModuleId(repRepairBill.getId());
							message.setRemarks(repRepairBill.getAssetsDeptName());
							message.setMessageContent("维修单据审批通过，查看详情");
							message.setStatus(2);
							message.setUserId(repRepairBill.getApplyUserId());
							repRepairMessageService.save(message);
						}else{
							repRepairBill.setCurrentIndex(repRepairBill.getCurrentIndex()+1);
						}
					}
					repRepairBillMapper.updateById(repRepairBill);
				}else{
					throw ExceptionFactory.create("W_027");
				}
			}else if(2==repRepairBill.getStatus().intValue()){
				throw ExceptionFactory.create("W_024");
			}else if(3==repRepairBill.getStatus().intValue()){
				throw ExceptionFactory.create("W_025");
			}else if(4==repRepairBill.getStatus().intValue()){
				throw ExceptionFactory.create("W_026");
			}
		}
		
	}

	@Override
	public Page<RepRepairBillApproveResponse> getRepairBillApprovePage2(RepRepairBillApproveQuery query) {
		AuthUser authUser = WebSecurityUtils.getCurrentUser();
		Page<RepRepairBillApproveResponse> page = query.getPage();
		List<RepRepairBillApproveResponse> list=repRepairBillCheckFlowService.getRepairBillApprovePage2(page,query,authUser);
		for (RepRepairBillApproveResponse repRepairBillResponse : list) {
			repRepairBillResponse.setTypeText(repRepairBillResponse.getType()==1?"外修费用":"配件采购");
			Integer status = repRepairBillResponse.getStatus();
			String statusText = "审批中";
			if(status==1){statusText="审批中";}
			if(status==2){statusText="审批通过";}
			if(status==3){statusText="审批未通过";}
			if(status==4){statusText="已撤销";}
			repRepairBillResponse.setStatusText(statusText);
		}
		page.setRecords(list);
		return page;
	}

	@Override
	public RepRepairBillDetailResponse getBillDetails2(Long id) {
		// 维修单据
				RepRepairBill repRepairBill = repRepairBillMapper.selectById(id);
				if(repRepairBill.getStatus().intValue()!=4){
					// 维修单据附件
					List<RepRepairBillFile> repRepairBillFileList = repRepairBillFileService.getRepRepairBillFile(repRepairBill.getId());
					// 维修单据配件
					List<RepRepairBillParts> repRepairBillPartsList = repRepairBillPartsService.getRepRepairBillParts(repRepairBill.getId());
					List<RepRepairBillLogResponse> repRepairBillLogList = new ArrayList<RepRepairBillLogResponse>();
					// 申请日志
					RepRepairBillLogResponse applyLog = new RepRepairBillLogResponse();
					applyLog.setOperator(repRepairBill.getApplyUserName());
					applyLog.setOperateName("提交申请");
					applyLog.setOperateStatus(0);
					applyLog.setOperateTime(repRepairBill.getApplyTime());
					repRepairBillLogList.add(applyLog);
					// 单据审批流程
					Long currentCheckUserId = null;
					List<RepRepairBillCheckFlow> repRepairBillCheckFlowList = repRepairBillCheckFlowService.getRepRepairBillCheckFlow(repRepairBill.getId());
					for (RepRepairBillCheckFlow repRepairBillCheckFlow : repRepairBillCheckFlowList) {
						RepRepairBillLogResponse checkFlowLog = new RepRepairBillLogResponse();
						checkFlowLog.setCheckFlowId(repRepairBillCheckFlow.getId());
						checkFlowLog.setOperateStatus(repRepairBillCheckFlow.getCheckStatus());
						Integer checkStatus = repRepairBillCheckFlow.getCheckStatus();
						String operateName = "待审批";
						if(checkStatus==1){operateName="待审批";}
						if(checkStatus==2){operateName="审批通过";}
						if(checkStatus==3){operateName="审批未通过";}
						checkFlowLog.setOperateName(operateName);
						checkFlowLog.setOperateTime(repRepairBillCheckFlow.getCheckTime());
						checkFlowLog.setOperator(repRepairBillCheckFlow.getCheckUserName());
						repRepairBillLogList.add(checkFlowLog);
						if(repRepairBill.getCurrentIndex()==repRepairBillCheckFlow.getIndex()){
							currentCheckUserId = repRepairBillCheckFlow.getCheckUserId();
						}
					}
					RepRepairBillDetailResponse repRepairBillDetailResponse = BeanMapper.map(repRepairBill, RepRepairBillDetailResponse.class);
					repRepairBillDetailResponse.setBillFiles(repRepairBillFileList);
					repRepairBillDetailResponse.setBillLogs(repRepairBillLogList);
					repRepairBillDetailResponse.setBillParts(repRepairBillPartsList);
					repRepairBillDetailResponse.setCurrentCheckUserId(currentCheckUserId);
					return repRepairBillDetailResponse;
				}else{
					throw ExceptionFactory.create("W_026");
				}
				
	}

	@Override
	public Integer getWaitToDo(Long id) {
		int i=repRepairBillCheckFlowService.getWaitToDo(id);
		return i;
	}
	
	
}
