package com.aek.ebey.repair.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aek.common.core.base.BaseServiceImpl;
import com.aek.common.core.serurity.model.AuthUser;
import com.aek.ebey.repair.mapper.RepRepairBillCheckFlowMapper;
import com.aek.ebey.repair.model.RepRepairBillCheckFlow;
import com.aek.ebey.repair.query.RepRepairBillApproveQuery;
import com.aek.ebey.repair.request.RepRepairBillApproveResponse;
import com.aek.ebey.repair.service.RepRepairBillCheckFlowService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;

/**
 * 维修单据申请服务实现类
 *	
 * @author HongHui
 * @date   2018年1月29日
 */
@Service
@Transactional
public class RepRepairBillCheckFlowServiceImpl extends BaseServiceImpl<RepRepairBillCheckFlowMapper, RepRepairBillCheckFlow> implements RepRepairBillCheckFlowService {

	private static final Logger logger = LoggerFactory.getLogger(RepRepairBillCheckFlowServiceImpl.class);

	@Autowired
	private RepRepairBillCheckFlowMapper repRepairBillCheckFlowMapper;
	
	
	@Override
	public List<RepRepairBillCheckFlow> getRepRepairBillCheckFlow(Long billId) {
		Wrapper<RepRepairBillCheckFlow> wrapper=new EntityWrapper<RepRepairBillCheckFlow>();
		wrapper.eq("bill_id", billId);
		wrapper.orderBy("'index'", true);
		List<RepRepairBillCheckFlow> list = repRepairBillCheckFlowMapper.selectList(wrapper);
		return list;
	}

	@Override
	public List<RepRepairBillApproveResponse> getRepairBillApprovePage(Page<RepRepairBillApproveResponse> page,
			RepRepairBillApproveQuery query, AuthUser authUser) {
		
		return repRepairBillCheckFlowMapper.getRepairBillApprovePage(page,query,authUser);
	}

	@Override
	public List<RepRepairBillApproveResponse> getRepairBillApprovePage2(Page<RepRepairBillApproveResponse> page,
			RepRepairBillApproveQuery query, AuthUser authUser) {
		return repRepairBillCheckFlowMapper.getRepairBillApprovePage2(page,query,authUser);
	}

	@Override
	public int getWaitToDo(Long id) {
		return repRepairBillCheckFlowMapper.getWaitToDo(id);
	}
	
}
