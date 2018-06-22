package com.aek.ebey.repair.service.impl;

import com.aek.ebey.repair.model.RepRepairParts;
import com.aek.ebey.repair.mapper.RepRepairPartsMapper;
import com.aek.ebey.repair.service.RepRepairPartsService;
import com.aek.common.core.base.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 维修配件表 服务实现类
 * </p>
 *
 * @author aek
 * @since 2017-06-06
 */
@Service
@Transactional
public class RepRepairPartsServiceImpl extends BaseServiceImpl<RepRepairPartsMapper, RepRepairParts> implements RepRepairPartsService {
	
}
