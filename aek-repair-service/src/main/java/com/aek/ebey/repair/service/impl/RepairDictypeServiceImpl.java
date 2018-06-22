package com.aek.ebey.repair.service.impl;

import com.aek.ebey.repair.model.RepairDictype;
import com.aek.ebey.repair.mapper.RepairDictypeMapper;
import com.aek.ebey.repair.service.RepairDictypeService;
import com.aek.common.core.base.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
public class RepairDictypeServiceImpl extends BaseServiceImpl<RepairDictypeMapper, RepairDictype> implements RepairDictypeService {
	
}
