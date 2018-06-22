package com.aek.ebey.repair.service;

import java.util.List;

import com.aek.common.core.base.BaseService;
import com.aek.ebey.repair.model.RepRepairBill;
import com.aek.ebey.repair.model.RepRepairBillFile;
import com.aek.ebey.repair.model.RepRepairBillParts;
import com.aek.ebey.repair.query.RepRepairBillApproveQuery;
import com.aek.ebey.repair.query.RepRepairBillQuery;
import com.aek.ebey.repair.request.RepRepairBillApproveResponse;
import com.aek.ebey.repair.request.RepRepairBillCheckRequest;
import com.aek.ebey.repair.request.RepRepairBillDetailResponse;
import com.aek.ebey.repair.request.RepRepairBillPrintDetailResponse;
import com.baomidou.mybatisplus.plugins.Page;

/**
 * 维修单据服务接口类
 *	
 * @author HongHui
 * @date   2018年1月29日
 */
public interface RepRepairBillService extends BaseService<RepRepairBill> {
	
	/**
	 * 新增维修单据申请
	 * @param repRepairBill
	 * @param billParts
	 * @param billFiles
	 */
	public void save(RepRepairBill repRepairBill,List<RepRepairBillParts> billParts,List<RepRepairBillFile> billFiles);
	
	/**
	 * 获取单据申请列表数据
	 * @param query
	 * @return
	 */
	public Page<RepRepairBill> getRepairBillPage(RepRepairBillQuery query);
	
	/**
	 * 获取维修单据详情
	 * @param id
	 * @return
	 */
	public RepRepairBillDetailResponse getBillDetails(Long id);
	
	/**
	 * 获取维修单据打印内容
	 * @param id
	 * @return
	 */
	public RepRepairBillPrintDetailResponse getBillPrintDetails(Long id);

	public Page<RepRepairBillApproveResponse> getRepairBillApprovePage(RepRepairBillApproveQuery query);

	public void selectCheck(RepRepairBillCheckRequest request);

	public Page<RepRepairBillApproveResponse> getRepairBillApprovePage2(RepRepairBillApproveQuery query);

	public RepRepairBillDetailResponse getBillDetails2(Long id);

	public Integer getWaitToDo(Long id);
	
}
