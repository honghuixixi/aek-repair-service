package com.aek.ebey.repair.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aek.common.core.base.BaseServiceImpl;
import com.aek.common.core.exception.ExceptionFactory;
import com.aek.common.core.serurity.WebSecurityUtils;
import com.aek.common.core.serurity.model.AuthUser;
import com.aek.ebey.repair.inter.MessageStatus;
import com.aek.ebey.repair.mapper.RepMessageReceiveMapper;
import com.aek.ebey.repair.model.RepMessageReceive;
import com.aek.ebey.repair.query.RepMessageReceiveQuery;
import com.aek.ebey.repair.request.MessageResponse;
import com.aek.ebey.repair.service.RepMessageReceiveService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;

/**
 * <p>
 * 消息接收表 服务实现类
 * </p>
 *
 * @author aek
 * @since 2017-08-30
 */
@Service
@Transactional
public class RepMessageReceiveServiceImpl extends BaseServiceImpl<RepMessageReceiveMapper, RepMessageReceive> implements RepMessageReceiveService {
	@Autowired
	private RepMessageReceiveMapper repMessageReceiveMapper;

	@Override
	@Transactional(readOnly = true)
	public Page<MessageResponse> search(RepMessageReceiveQuery query) {
		Page<MessageResponse> page = query.getPage();
		AuthUser authUser = WebSecurityUtils.getCurrentUser();
		List<MessageResponse> list = repMessageReceiveMapper.selectMyPage(page,query, authUser);
		page.setRecords(list);
		return page;
		
		
	}

	@Override
	public int readAll(AuthUser authUser) {
		if (authUser != null && authUser.getId() != null) {
			return repMessageReceiveMapper.updateByStatus(authUser.getId());
		}else{
			throw ExceptionFactory.create("G_006");
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Page<MessageResponse> searchX(RepMessageReceiveQuery query) {
		Page<MessageResponse> page = query.getPage();
		AuthUser authUser = WebSecurityUtils.getCurrentUser();
		List<MessageResponse> list = repMessageReceiveMapper.selectMyPageX(page,query, authUser);
		page.setRecords(list);
		return page;
	}
	
}
