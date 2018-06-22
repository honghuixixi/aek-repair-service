package com.aek.ebey.repair.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aek.common.core.base.BaseServiceImpl;
import com.aek.ebey.repair.mapper.RepRepairBillPartsMapper;
import com.aek.ebey.repair.model.RepRepairBillParts;
import com.aek.ebey.repair.service.RepRepairBillPartsService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

/**
 * 维修单据申请服务实现类
 *	
 * @author HongHui
 * @date   2018年1月29日
 */
@Service
@Transactional
public class RepRepairBillPartsServiceImpl extends BaseServiceImpl<RepRepairBillPartsMapper, RepRepairBillParts> implements RepRepairBillPartsService {

	private static final Logger logger = LoggerFactory.getLogger(RepRepairBillPartsServiceImpl.class);

	@Autowired
	private RepRepairBillPartsMapper repRepairBillPartsMapper;
	
	@Override
	public List<RepRepairBillParts> getRepRepairBillParts(Long billId) {
		Wrapper<RepRepairBillParts> wrapper=new EntityWrapper<RepRepairBillParts>();
		wrapper.eq("bill_id", billId);
		List<RepRepairBillParts> list=repRepairBillPartsMapper.selectList(wrapper);
		return list;
	}
	
}
