package com.aek.ebey.repair.mapper;

import com.aek.ebey.repair.model.RepRepairConfig;
import com.aek.ebey.repair.model.vo.RepConfigDeptVo;
import com.aek.ebey.repair.model.vo.RepConfiger;
import com.aek.ebey.repair.model.vo.RepUserVo;
import com.aek.ebey.repair.model.vo.TakeOrderDeptVo;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.aek.common.core.base.BaseMapper;

/**
 * <p>
 * Mapper接口
 * </p>
 *
 * @author cyl
 * @since 2018-01-26
 */
public interface RepRepairConfigMapper extends BaseMapper<RepRepairConfig> {

	/**
	 * 根据工程师id查询其所有接单科室名称
	 * 
	 * @param repairId
	 * @return
	 */
	String getTakeOrderDeptNames(@Param("repairId")Long repairId,@Param("tenantId")Long tenantId);
	
	List<RepConfigDeptVo> getTakeOrderDeptId(@Param("tenantId")Long tenantId);
	
	List<RepConfigDeptVo> getSelfTakeOrderDepts(@Param("repairId")Long repairId,@Param("tenantId")Long tenantId);
	
	void deletByEnableDelDeptId(@Param("depts")List<RepConfigDeptVo> depts,@Param("tenantId")Long tenantId);
	
	void deletByTenantId(@Param("tenantId")Long tenantId);
	
	void deletByRepairIdList(@Param("repairs")List<RepUserVo> repairs,@Param("tenantId")Long tenantId);
	
	void delByTenantIdRepairId(@Param("repairId")Long repairId,@Param("tenantId")Long tenantId);
	
	void updateDept(@Param("dept")RepConfigDeptVo dept,@Param("tenantId")Long tenantId);
	
	void updateRepConfigUser(@Param("repUser")RepUserVo repUser,@Param("tenantId")Long tenantId);
	
	RepRepairConfig getByTakeOrderDeptId(@Param("deptId")Long deptId,@Param("tenantId")Long tenantId,@Param("repairId")Long repairId);
	
	List<RepRepairConfig> getByRepairId(@Param("repairId")Long repairId);
	
	List<RepUserVo> getRepairGroupById(@Param("tenantId")Long tenantId);
	
	RepConfiger selectConfiger(@Param("deptId")Long deptId);
}