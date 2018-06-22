package com.aek.ebey.repair.service.impl;

import com.aek.ebey.repair.model.RepRepairCheck;
import com.aek.ebey.repair.mapper.RepRepairCheckMapper;
import com.aek.ebey.repair.service.RepRepairCheckService;
import com.aek.common.core.base.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 验收详情表 服务实现类
 * </p>
 *
 * @author aek
 * @since 2017-08-30
 */
@Service
@Transactional
public class RepRepairCheckServiceImpl extends BaseServiceImpl<RepRepairCheckMapper, RepRepairCheck> implements RepRepairCheckService {
	
}
