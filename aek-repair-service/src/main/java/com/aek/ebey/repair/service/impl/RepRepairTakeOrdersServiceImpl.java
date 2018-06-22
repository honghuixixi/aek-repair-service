package com.aek.ebey.repair.service.impl;

import com.aek.ebey.repair.model.RepRepairTakeOrders;
import com.aek.ebey.repair.mapper.RepRepairTakeOrdersMapper;
import com.aek.ebey.repair.service.RepRepairTakeOrdersService;
import com.aek.common.core.base.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 接单表 服务实现类
 * </p>
 *
 * @author aek
 * @since 2017-08-30
 */
@Service
@Transactional
public class RepRepairTakeOrdersServiceImpl extends BaseServiceImpl<RepRepairTakeOrdersMapper, RepRepairTakeOrders> implements RepRepairTakeOrdersService {
	
}
