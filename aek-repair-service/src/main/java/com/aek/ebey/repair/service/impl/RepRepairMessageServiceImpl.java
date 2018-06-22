package com.aek.ebey.repair.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aek.common.core.base.BaseServiceImpl;
import com.aek.ebey.repair.inter.MessageStatus;
import com.aek.ebey.repair.mapper.RepMessageReceiveMapper;
import com.aek.ebey.repair.mapper.RepRepairMessageMapper;
import com.aek.ebey.repair.model.RepMessageReceive;
import com.aek.ebey.repair.model.RepRepairMessage;
import com.aek.ebey.repair.request.SendMessage;
import com.aek.ebey.repair.service.RepRepairMessageService;

/**
 * <p>
 * 消息表 服务实现类
 * </p>
 *
 * @author aek
 * @since 2017-08-30
 */
@Service
@Transactional
public class RepRepairMessageServiceImpl extends BaseServiceImpl<RepRepairMessageMapper, RepRepairMessage> implements RepRepairMessageService {

	@Autowired
	private RepRepairMessageMapper repRepairMessageMapper;
	
	@Autowired
	private RepMessageReceiveMapper repMessageReceiveMapper;
	
	@Override
	public void save(SendMessage sendMessage) {
		RepRepairMessage repRepairMessage = new RepRepairMessage();
		repRepairMessage.setModuleId(sendMessage.getModuleId());
		repRepairMessage.setMessageContent(sendMessage.getMessageContent());
		repRepairMessage.setRemarks(sendMessage.getRemarks());
		repRepairMessage.setStatus(sendMessage.getStatus());
		repRepairMessageMapper.insert(repRepairMessage);
		RepMessageReceive repMessageReceive = new RepMessageReceive();
		repMessageReceive.setMessageId(repRepairMessage.getId());
		repMessageReceive.setMessageStatus(MessageStatus.UNWATCH);
		repMessageReceive.setUserId(sendMessage.getUserId());
		repMessageReceiveMapper.insert(repMessageReceive);
	}
	
}
