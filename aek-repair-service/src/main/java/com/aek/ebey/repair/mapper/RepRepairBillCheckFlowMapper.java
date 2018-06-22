package com.aek.ebey.repair.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.aek.common.core.base.BaseMapper;
import com.aek.common.core.serurity.model.AuthUser;
import com.aek.ebey.repair.model.RepRepairBillCheckFlow;
import com.aek.ebey.repair.query.RepRepairBillApproveQuery;
import com.aek.ebey.repair.query.RepRepairBillQuery;
import com.aek.ebey.repair.request.RepRepairBillApproveResponse;
import com.aek.ebey.repair.request.RepRepairBillResponse;
import com.baomidou.mybatisplus.plugins.Page;

/**
 * 维修单据审核流程Mapper接口
 *	
 * @author HongHui
 * @date   2018年1月29日
 */
public interface RepRepairBillCheckFlowMapper extends BaseMapper<RepRepairBillCheckFlow>{

	List<RepRepairBillApproveResponse> getRepairBillApprovePage(Page<RepRepairBillApproveResponse> page,
			@Param("q") RepRepairBillApproveQuery query, @Param("user") AuthUser authUser);

	/**
	 * 获取单据申请列表数据
	 * @param page
	 * @param query
	 * @param authUser
	 * @return
	 */
	List<RepRepairBillResponse> getRepairBillPage(Page<RepRepairBillResponse> page,@Param("q") RepRepairBillQuery query, @Param("user") AuthUser authUser);

	List<RepRepairBillApproveResponse> getRepairBillApprovePage2(Page<RepRepairBillApproveResponse> page,
			@Param("q") RepRepairBillApproveQuery query, @Param("user") AuthUser authUser);

	int getWaitToDo(@Param("id")Long id);
	
}
