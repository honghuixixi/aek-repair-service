package com.aek.ebey.repair.service.ribbon;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.aek.common.core.Result;
@Component
public class UserClientHystrix implements UserClientService{
	private static final Logger logger = LoggerFactory.getLogger(UserClientHystrix.class);

	@Override
	public Result<Integer> getAssetsInfoById(Long id,String token) {
		logger.error("getAssetsInfoById-----------------------------------"+token);
		return null;
	}

	@Override
	public Result<Object> updateAssetsInfoById(Long id, Integer status,Long appilNo, String token) {
		logger.error("updateAssetsInfoById-----------------------------------"+token);
		return null;
	}

	@Override
	public Result<Object> updateAssetsRepairStatusById(Long id, Integer repairStatus, Long repairId, String token) {
		logger.error("updateAssetsRepairStatusById-----------------------------------"+token);
		return null;
	}

	@Override
	public Result<Object> updateAssetsRepairStatusByIdNoToken(Long id, Integer repairStatus, Long repairId) {
		logger.error("updateAssetsRepairStatusById-----------------------------------");
		return null;
	}

	@Override
	public Result<Integer> assDiscard(Long tenantId, String token) {
		logger.error("assDiscard-----------------------------------");
		return null;
	}

	@Override
	public Result<Integer> assAssetsTransfer(Long tenantId, String token) {
		logger.error("assAssetsTransfer-----------------------------------");
		return null;
	}

	
}
