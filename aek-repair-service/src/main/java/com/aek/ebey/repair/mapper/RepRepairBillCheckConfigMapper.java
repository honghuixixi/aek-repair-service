package com.aek.ebey.repair.mapper;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.aek.common.core.base.BaseMapper;
import com.aek.ebey.repair.model.RepRepairBillCheckConfig;

/**
 * 维修单据配置Mapper接口
 *	
 * @author HongHui
 * @date   2018年1月29日
 */
public interface RepRepairBillCheckConfigMapper extends BaseMapper<RepRepairBillCheckConfig>{

	/**
	 * 获取当前机构维修单据配置信息
	 * @param tenantId
	 * @return
	 */
	public List<RepRepairBillCheckConfig> getRepRepairBillCheckConfig(@Param("tenantId")Long tenantId,@Param("fee")BigDecimal fee);
	
	/**
	 * 获取当前机构维修单据配置信息
	 * @param tenantId
	 * @return
	 */
	public List<RepRepairBillCheckConfig> getRepRepairBillCheckConfigByTenantId(@Param("tenantId")Long tenantId);
	
	/**
	 * 根据机构id删除工作流配置
	 * 
	 * @param tenantId
	 */
	void delByTenantId(@Param("tenantId")Long tenantId);
	
	/**
	 * 获取当前机构维修单据配置信息
	 * @param tenantId
	 * @return
	 */
	List<RepRepairBillCheckConfig> getRepRepairBillCheckConfigDetail(@Param("tenantId")Long tenantId);
}
