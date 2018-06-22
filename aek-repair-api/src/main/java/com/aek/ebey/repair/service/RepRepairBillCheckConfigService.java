package com.aek.ebey.repair.service;

import java.math.BigDecimal;
import java.util.List;

import com.aek.common.core.base.BaseService;
import com.aek.ebey.repair.model.RepRepairBillCheckConfig;

/**
 * 维修单据配置服务接口类
 *	
 * @author HongHui
 * @date   2018年1月29日
 */
public interface RepRepairBillCheckConfigService extends BaseService<RepRepairBillCheckConfig> {
	
	/**
	 * 获取当前机构维修单据配置信息
	 * @param tenantId
	 * @return
	 */
	public List<RepRepairBillCheckConfig> getRepRepairBillCheckConfig(Long tenantId,BigDecimal fee);
	
	/**
	 * 获取当前机构维修单据配置信息
	 * @param tenantId
	 * @return
	 */
	public List<RepRepairBillCheckConfig> getRepRepairBillCheckConfig(Long tenantId);
	
	/**
	 * 获取当前机构维修单据配置详情
	 * @return
	 */
	public List<RepRepairBillCheckConfig> getRepRepairBillCheckConfigDetail();
	
	/**
	 * 工作流配置保存
	 * 
	 * @param list
	 */
	public void saveWorkflow(List<RepRepairBillCheckConfig> list);
}
