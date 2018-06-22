package com.aek.ebey.repair.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aek.common.core.base.BaseServiceImpl;
import com.aek.common.core.exception.ExceptionFactory;
import com.aek.common.core.serurity.WebSecurityUtils;
import com.aek.common.core.serurity.model.AuthUser;
import com.aek.ebey.repair.inter.Constants;
import com.aek.ebey.repair.mapper.RepPartsRecordMapper;
import com.aek.ebey.repair.model.RepPartsRecord;
import com.aek.ebey.repair.query.RepPartsRecordQuery;
import com.aek.ebey.repair.service.RepPartsRecordService;
import com.aek.ebey.repair.service.RepairDictionaryService;
import com.baomidou.mybatisplus.plugins.Page;

/**
 * <p>
 * 配件操作记录表 服务实现类
 * </p>
 *
 * @author aek
 * @since 2017-08-30
 */
@Service
@Transactional
public class RepPartsRecordServiceImpl extends BaseServiceImpl<RepPartsRecordMapper, RepPartsRecord> implements RepPartsRecordService {
	@Autowired
	private RepPartsRecordMapper repPartsRecordMapper;
	
	@Autowired
	private RepairDictionaryService repairDictionaryService;
	
	@Autowired
	private RedisTemplate<String, String> redisTemplate;

	@Override
	public void add(RepPartsRecord data) {
		AuthUser authUser = WebSecurityUtils.getCurrentUser();
		if (authUser != null) {
			// 设置机构
			data.setTenantId(Long.parseLong(authUser.getTenantId() + ""));
			repPartsRecordMapper.insert(data);
		} else {
			throw ExceptionFactory.create("W_001");
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Page<RepPartsRecord> search(Page<RepPartsRecord> page, RepPartsRecordQuery query) {
		AuthUser authUser = WebSecurityUtils.getCurrentUser();
		List<RepPartsRecord> list = repPartsRecordMapper.search(page, query, authUser);
		if(list!=null&&list.size()>0){
			for(RepPartsRecord repPartsRecord:list){
				HashOperations<String, String, String>  hash= redisTemplate.opsForHash();
				getReportsRecord(hash,repPartsRecord);
			}
		}
		page.setRecords(list);
		return page;
	}
	
	private void getReportsRecord(HashOperations<String, String, String> hash, RepPartsRecord repPartsRecord) {
		if(repPartsRecord.getUnit()!=null){
			if(hash.get(Constants.REPAIR_DICTIONARY, repPartsRecord.getUnit())!=null){
				repPartsRecord.setUnitName(hash.get(Constants.REPAIR_DICTIONARY, repPartsRecord.getUnit()));
			}else{
				  String name= repairDictionaryService.getValue(repPartsRecord.getUnit());
					 if(name!=null){
						 hash.put(Constants.REPAIR_DICTIONARY,repPartsRecord.getUnit(), name);
						 repPartsRecord.setUnitName(name);
					 }
			}
			
		}
	}

}
