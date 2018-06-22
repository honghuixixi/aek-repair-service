package com.aek.ebey.repair.service.impl;

import com.aek.ebey.repair.model.RepTurnOrders;
import com.aek.ebey.repair.mapper.RepTurnOrdersMapper;
import com.aek.ebey.repair.service.RepTurnOrdersService;
import com.aek.common.core.base.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 转单表 服务实现类
 * </p>
 *
 * @author aek
 * @since 2018-01-11
 */
@Service
@Transactional
public class RepTurnOrdersServiceImpl extends BaseServiceImpl<RepTurnOrdersMapper, RepTurnOrders> implements RepTurnOrdersService {
	
}
