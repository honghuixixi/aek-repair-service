package com.aek.ebey.repair.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aek.common.core.base.BaseServiceImpl;
import com.aek.common.core.base.page.PageHelp;
import com.aek.ebey.repair.mapper.RepairDictionaryMapper;
import com.aek.ebey.repair.mapper.RepairDictypeMapper;
import com.aek.ebey.repair.model.RepairDictionary;
import com.aek.ebey.repair.model.RepairDictype;
import com.aek.ebey.repair.service.RepairDictionaryService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author aek
 * @since 2017-08-30
 */
@Service
@Transactional
public class RepairDictionaryServiceImpl extends BaseServiceImpl<RepairDictionaryMapper, RepairDictionary> implements RepairDictionaryService {
	
	@Autowired
	private RepairDictypeMapper repairDictypeMapper;
	@Override
	public Page<RepairDictype> search(PageHelp<RepairDictype> query) {
		Page<RepairDictype> page = query.getPage();
		Wrapper<RepairDictype> wrapper = new EntityWrapper<RepairDictype>();
		List<RepairDictype> list=	repairDictypeMapper.selectPage(page, wrapper);
		page.setRecords(list);
		return page;
	}
	@Override
	public String getValue(String ketId) {
		
		return repairDictypeMapper.getValue(ketId);
	}
	
}
