package com.aek.ebey.repair.service;

import java.util.List;

import com.aek.common.core.base.BaseService;
import com.aek.ebey.repair.model.RepRepairBillParts;

/**
 * 维修单据附件服务接口类
 *	
 * @author HongHui
 * @date   2018年1月29日
 */
public interface RepRepairBillPartsService extends BaseService<RepRepairBillParts> {
	
	/**
	 * 获取单据配件信息
	 * @param billId
	 * @return
	 */
	public List<RepRepairBillParts> getRepRepairBillParts(Long billId);
}
