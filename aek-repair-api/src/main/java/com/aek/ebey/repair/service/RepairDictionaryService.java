package com.aek.ebey.repair.service;

import com.aek.common.core.base.BaseService;
import com.aek.common.core.base.page.PageHelp;
import com.aek.ebey.repair.model.RepairDictionary;
import com.aek.ebey.repair.model.RepairDictype;
import com.baomidou.mybatisplus.plugins.Page;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author aek
 * @since 2017-08-30
 */
public interface RepairDictionaryService extends BaseService<RepairDictionary> {

	Page<RepairDictype> search(PageHelp<RepairDictype> query);

	String getValue(String ketId);
	
}
