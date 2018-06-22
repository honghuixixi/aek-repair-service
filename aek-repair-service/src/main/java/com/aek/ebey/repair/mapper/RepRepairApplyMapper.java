package com.aek.ebey.repair.mapper;

import com.aek.ebey.repair.model.RepRepairApply;
import com.aek.ebey.repair.model.vo.RepLargeScreenDataVo;
import com.aek.ebey.repair.model.vo.RepRepairApplyVo;
import com.aek.ebey.repair.model.vo.RepairDataMonthVo;
import com.aek.ebey.repair.model.vo.RepairDataVo;
import com.aek.ebey.repair.query.RepRepairApplyQuery;
import com.aek.ebey.repair.query.RepRepairBillApplyQuery;
import com.aek.ebey.repair.query.RepRepairRecordQuery;
import com.aek.ebey.repair.request.ApplyDetailsResponse;
import com.aek.ebey.repair.request.ApplyResponse;
import com.aek.ebey.repair.request.ApplyTotalResponse;
import com.aek.ebey.repair.request.RepRepairBillApplyResponse;
import com.aek.ebey.repair.request.RepairRecordResponse;
import com.aek.ebey.repair.request.SevenDataResponse;
import com.aek.ebey.repair.request.SevenQuery;
import com.baomidou.mybatisplus.plugins.Page;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.aek.common.core.base.BaseMapper;
import com.aek.common.core.serurity.model.AuthUser;

/**
 * <p>
 * Mapper接口
 * </p>
 *
 * @author aek
 * @since 2017-08-30
 */
public interface RepRepairApplyMapper extends BaseMapper<RepRepairApply> {

	List<ApplyResponse> search(Page<ApplyResponse> page,@Param("q") RepRepairApplyQuery query, @Param("user") AuthUser authUser);
	//List<Assets> getLedgerPage(Page<Assets> page, @Param("q") LedgerPaging query, @Param("user") AuthUser authUser);

	ApplyDetailsResponse getApplyDetails(Long id);
	
	List<ApplyTotalResponse> selectApplyStatus(@Param("tenantid")String tenantid,@Param("user") AuthUser authUser);

	List<RepairRecordResponse> repairRecord(Page<RepairRecordResponse> page,@Param("q") RepRepairRecordQuery query);

	int selectCountByTenantid(@Param("tenantid")String tenantid, @Param("user")AuthUser authUser, @Param("status")int status);
	
	/**
	 * 根据用户id统计待接单数目
	 * 
	 * @param authUser
	 * @return
	 */
	int statsTakeOrdersByUserId(@Param("user")AuthUser authUser);
	
	/**
	 * 根据用户id统计待维修数目
	 * 
	 * @param authUser
	 * @return
	 */
	int statsWaitRepairByUserId(@Param("user")AuthUser authUser);
	
	/**
	 * 根据用户部门ID统计待验证的数目
	 * @param authUser
	 * @return
	 */
	int statsWaitCheckByUserDeptId(@Param("user")AuthUser authUser);
	
	/**
	 * 新建维修单据申请获取维修单列表分页数据
	 * @param page
	 * @param query
	 * @param authUser
	 * @return
	 */
	List<RepRepairBillApplyResponse> getRepairApplyPageForBill(Page<RepRepairBillApplyResponse> page,@Param("q") RepRepairBillApplyQuery query, @Param("user") AuthUser authUser);
	
	/**
	 * 获取维修大屏 统计数据
	 * @param tenantId
	 * @return
	 */
	public RepLargeScreenDataVo getRepLargeScreenData(@Param("tenantId") Long tenantId);
	
	/**
	 * 获取维修大屏 维修单数据
	 * @param tenantId
	 * @return
	 */
	public List<RepRepairApplyVo> getLargeScreenApplyData(@Param("tenantId") Long tenantId);
	
	/**
	 * 获取维修概览统计数据
	 * @return
	 */
	public List<RepairDataVo> getRepairData(@Param("endTime") String endTime);
	
	/**
	 * 获取维修月份统计数据
	 * @return
	 */
	public List<RepairDataMonthVo> getRepairDataMonthByDay(@Param("endTime") String endTime);

	List<SevenDataResponse> selectByQuery(@Param("query") SevenQuery query);

	/*List<SevenDataResponse> selectByQuery2(@Param("query") SevenQuery query);*/
	
}