package com.aek.ebey.repair.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aek.common.core.base.BaseServiceImpl;
import com.aek.ebey.repair.mapper.RepRepairBillFileMapper;
import com.aek.ebey.repair.model.RepRepairBillFile;
import com.aek.ebey.repair.service.RepRepairBillFileService;
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
public class RepRepairBillFileServiceImpl extends BaseServiceImpl<RepRepairBillFileMapper, RepRepairBillFile> implements RepRepairBillFileService {

	private static final Logger logger = LoggerFactory.getLogger(RepRepairBillFileServiceImpl.class);

	@Autowired
	private RepRepairBillFileMapper repRepairBillFileMapper;
	
	@Override
	public List<RepRepairBillFile> getRepRepairBillFile(Long billId) {
		Wrapper<RepRepairBillFile> wrapper=new EntityWrapper<RepRepairBillFile>();
		wrapper.eq("bill_id", billId);
		List<RepRepairBillFile> list=repRepairBillFileMapper.selectList(wrapper);
		return list;
	}
	
}
