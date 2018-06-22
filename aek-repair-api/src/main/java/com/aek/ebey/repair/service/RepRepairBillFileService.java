package com.aek.ebey.repair.service;

import java.util.List;

import com.aek.common.core.base.BaseService;
import com.aek.ebey.repair.model.RepRepairBillFile;

/**
 * 维修单据附件服务接口类
 *	
 * @author HongHui
 * @date   2018年1月29日
 */
public interface RepRepairBillFileService extends BaseService<RepRepairBillFile> {
	
	/**
	 * 获取某个维修单据附件列表
	 * @param billId
	 * @return
	 */
	public List<RepRepairBillFile> getRepRepairBillFile(Long billId);
}
