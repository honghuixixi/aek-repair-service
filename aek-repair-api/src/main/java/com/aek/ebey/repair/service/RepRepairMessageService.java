package com.aek.ebey.repair.service;

import com.aek.ebey.repair.model.RepRepairMessage;
import com.aek.ebey.repair.request.SendMessage;
import com.aek.common.core.base.BaseService;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author aek
 * @since 2017-08-30
 */
public interface RepRepairMessageService extends BaseService<RepRepairMessage> {

	void save(SendMessage sendMessage);
	
}
