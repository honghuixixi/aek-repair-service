package com.aek.ebey.repair.service;

import com.aek.common.core.base.BaseService;
import com.aek.ebey.repair.model.RepPartsRecord;
import com.aek.ebey.repair.query.RepPartsRecordQuery;
import com.baomidou.mybatisplus.plugins.Page;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author aek
 * @since 2017-08-30
 */
public interface RepPartsRecordService extends BaseService<RepPartsRecord> {
	
	void add(RepPartsRecord data);

	Page<RepPartsRecord> search(Page<RepPartsRecord> page, RepPartsRecordQuery query);
	
}
