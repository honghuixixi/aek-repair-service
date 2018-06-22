package com.aek.ebey.repair.service;

import java.util.List;

import com.aek.common.core.base.BaseService;
import com.aek.common.core.serurity.model.AuthUser;
import com.aek.ebey.repair.model.RepRepairBillCheckFlow;
import com.aek.ebey.repair.query.RepRepairBillApproveQuery;
import com.aek.ebey.repair.request.RepRepairBillApproveResponse;
import com.baomidou.mybatisplus.plugins.Page;

/**
 * 维修单据审核流程服务接口类
 *	
 * @author HongHui
 * @date   2018年1月29日
 */
public interface RepRepairBillCheckFlowService extends BaseService<RepRepairBillCheckFlow> {
	
	
	/**
	 * 获取维修单据流程
	 * @param billId
	 * @return
	 */
	public List<RepRepairBillCheckFlow> getRepRepairBillCheckFlow(Long billId);

	public List<RepRepairBillApproveResponse> getRepairBillApprovePage(Page<RepRepairBillApproveResponse> page,
			RepRepairBillApproveQuery query, AuthUser authUser);

	public List<RepRepairBillApproveResponse> getRepairBillApprovePage2(Page<RepRepairBillApproveResponse> page,
			RepRepairBillApproveQuery query, AuthUser authUser);

	public int getWaitToDo(Long id);
}
