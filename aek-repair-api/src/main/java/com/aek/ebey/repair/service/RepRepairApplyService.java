package com.aek.ebey.repair.service;

import java.util.List;

import com.aek.common.core.base.BaseService;
import com.aek.common.core.serurity.model.AuthUser;
import com.aek.ebey.repair.model.RepRepairApply;
import com.aek.ebey.repair.model.RepRepairCheck;
import com.aek.ebey.repair.model.RepRepairTakeOrders;
import com.aek.ebey.repair.model.RepairData;
import com.aek.ebey.repair.model.vo.RepLargeScreenDataVo;
import com.aek.ebey.repair.model.vo.RepRepairApplyVo;
import com.aek.ebey.repair.model.vo.RepairDataMonthVo;
import com.aek.ebey.repair.query.RepRepairApplyQuery;
import com.aek.ebey.repair.query.RepRepairBillApplyQuery;
import com.aek.ebey.repair.query.RepRepairRecordQuery;
import com.aek.ebey.repair.request.ApplyDetailsResponse;
import com.aek.ebey.repair.request.ApplyResponse;
import com.aek.ebey.repair.request.ApplyTotalResponse;
import com.aek.ebey.repair.request.ApplyTurnOrderRequest;
import com.aek.ebey.repair.request.RepRepairBillApplyResponse;
import com.aek.ebey.repair.request.RepairRecordResponse;
import com.aek.ebey.repair.request.SevenDataResponse;
import com.aek.ebey.repair.request.SevenQuery;
import com.baomidou.mybatisplus.plugins.Page;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author aek
 * @since 2017-08-30
 */
public interface RepRepairApplyService extends BaseService<RepRepairApply> {
	
	
	void save(RepRepairApply repRepairApply);

	boolean getRepRepairApply(RepRepairApply repRepairApply);

	Page<ApplyResponse> search(RepRepairApplyQuery query);

	ApplyDetailsResponse getApplyDetails(Long id);
	
	List<ApplyTotalResponse> selectApplyStatus(String tenantid);

	void check(RepRepairCheck data);

	void taking(RepRepairTakeOrders repRepairTakeOrders);

	Page<RepairRecordResponse> repairRecord(RepRepairRecordQuery query);

	int selectCountByTenantid(String tenantid, AuthUser authUser,int status);
	
	int statsTakeOrdersByUserId(AuthUser authUser);
	
	int statsWaitRepairByUserId(AuthUser authUser);
	
	int statsWaitCheckByUserDeptId(AuthUser authUser);

	void turnOrder(ApplyTurnOrderRequest request);
	
	/**
	 * 新建维修单据申请获取维修单列表分页数据
	 * @param query
	 * @return
	 */
	Page<RepRepairBillApplyResponse> getRepairApplyPageForBill(RepRepairBillApplyQuery query);

	void autoCheck();
	
	/**
	 * 获取维修大屏统计数据
	 * @param tenantId
	 * @return
	 */
	public RepLargeScreenDataVo getLargeScreenData(Long tenantId);
	
	/**
	 * 获取维修大屏维修单数据
	 * @param tenantId
	 * @return
	 */
	public List<RepRepairApplyVo> getLargeScreenApplyData(Long tenantId);
	
	/**
	 * 获取维修概览统计数据
	 * @return
	 */
	public List<RepairData> getRepairData();
	
	/**
	 * 获取维修月份数据统计
	 * @return
	 */
	public List<RepairDataMonthVo> getRepairDataMonthByDay();

	List<SevenDataResponse> countApply(SevenQuery query);
	    
}
