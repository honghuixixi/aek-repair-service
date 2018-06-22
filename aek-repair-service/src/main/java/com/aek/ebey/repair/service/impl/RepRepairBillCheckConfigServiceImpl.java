package com.aek.ebey.repair.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aek.common.core.Result;
import com.aek.common.core.base.BaseServiceImpl;
import com.aek.common.core.exception.BusinessException;
import com.aek.common.core.exception.ExceptionFactory;
import com.aek.common.core.serurity.WebSecurityUtils;
import com.aek.ebey.repair.mapper.RepRepairApplyMapper;
import com.aek.ebey.repair.mapper.RepRepairBillCheckConfigMapper;
import com.aek.ebey.repair.mapper.RepRepairBillFileMapper;
import com.aek.ebey.repair.mapper.RepRepairBillMapper;
import com.aek.ebey.repair.model.RepRepairBill;
import com.aek.ebey.repair.model.RepRepairBillCheckConfig;
import com.aek.ebey.repair.model.RepRepairBillFile;
import com.aek.ebey.repair.model.RepRepairBillParts;
import com.aek.ebey.repair.service.RepMessageReceiveService;
import com.aek.ebey.repair.service.RepRepairApplyService;
import com.aek.ebey.repair.service.RepRepairBillCheckConfigService;
import com.aek.ebey.repair.service.RepRepairBillFileService;
import com.aek.ebey.repair.service.RepRepairBillPartsService;
import com.aek.ebey.repair.service.RepRepairBillService;
import com.aek.ebey.repair.service.RepRepairCheckService;
import com.aek.ebey.repair.service.ribbon.UserPermissionService;

/**
 * 维修单据申请服务实现类
 *	
 * @author HongHui
 * @date   2018年1月29日
 */
@Service
@Transactional
public class RepRepairBillCheckConfigServiceImpl extends BaseServiceImpl<RepRepairBillCheckConfigMapper, RepRepairBillCheckConfig> implements RepRepairBillCheckConfigService {

	private static final Logger logger = LoggerFactory.getLogger(RepRepairBillCheckConfigServiceImpl.class);
	
	@Autowired
	private RepRepairBillCheckConfigMapper repRepairBillCheckConfigMapper;
	
	@Autowired
	private RepRepairBillCheckConfigService repRepairBillCheckConfigService;
	
	@Autowired
	private UserPermissionService userPermissionService;

	@Override
	public List<RepRepairBillCheckConfig> getRepRepairBillCheckConfig(Long tenantId,BigDecimal fee) {
		return repRepairBillCheckConfigMapper.getRepRepairBillCheckConfig(tenantId,fee);
	}

	@Override
	public List<RepRepairBillCheckConfig> getRepRepairBillCheckConfig(Long tenantId) {
		return repRepairBillCheckConfigMapper.getRepRepairBillCheckConfigByTenantId(tenantId);
	}

	@Override
	public void saveWorkflow(List<RepRepairBillCheckConfig> list) {
		Long tenantId = WebSecurityUtils.getCurrentUser().getTenantId();
		 String token = WebSecurityUtils.getCurrentToken();
		if(list.size()==0){
			repRepairBillCheckConfigMapper.delByTenantId(tenantId);
		}
		if(list.size()>0){	
			repRepairBillCheckConfigMapper.delByTenantId(tenantId);
			for (RepRepairBillCheckConfig repRepairBillCheckConfig : list) {
				Long checkUserId = repRepairBillCheckConfig.getCheckUserId();
				String checkUserName = repRepairBillCheckConfig.getCheckUserName();
				Result<Integer> result = userPermissionService.checkIsRepBill(checkUserId, token);
				if(result != null){
					Integer flag = result.getData();
					switch (flag) {
					case 1:
						throw new BusinessException("208", checkUserName+"无审批权限");
					case 2:
						throw new BusinessException("209", checkUserName+"已停用");
					default:
						break;
					}
				}
				repRepairBillCheckConfig.setTenantId(tenantId);
			}
			repRepairBillCheckConfigService.insertBatch(list);
		}
		
	}

	@Override
	public List<RepRepairBillCheckConfig> getRepRepairBillCheckConfigDetail() {
		Long tenantId = WebSecurityUtils.getCurrentUser().getTenantId();
		return repRepairBillCheckConfigMapper.getRepRepairBillCheckConfigDetail(tenantId);
	}
	
}
