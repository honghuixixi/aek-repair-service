package com.aek.ebey.repair.service;

import com.aek.ebey.repair.model.RepMessageReceive;
import com.aek.ebey.repair.query.RepMessageReceiveQuery;
import com.aek.ebey.repair.request.MessageResponse;
import com.baomidou.mybatisplus.plugins.Page;
import com.aek.common.core.base.BaseService;
import com.aek.common.core.serurity.model.AuthUser;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author aek
 * @since 2017-08-30
 */
public interface RepMessageReceiveService extends BaseService<RepMessageReceive> {
	
	Page<MessageResponse> search(RepMessageReceiveQuery query);

	int readAll(AuthUser authUser);

	Page<MessageResponse> searchX(RepMessageReceiveQuery query);
	
}
