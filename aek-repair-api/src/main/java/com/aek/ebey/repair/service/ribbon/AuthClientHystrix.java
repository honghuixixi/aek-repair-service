package com.aek.ebey.repair.service.ribbon;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.aek.common.core.Result;
import com.aek.ebey.repair.request.WeiXinRepairMessageRequest;

/**
 * 断路器
 *	
 * @author HongHui
 * @date   2017年12月13日
 */
@Component
public class AuthClientHystrix implements AuthClientService{

	private static final Logger logger = LogManager.getLogger(AuthClientHystrix.class);

	@Override
	public Result<List<Map<String,Object>>> sendWeiXinRepairMessage(WeiXinRepairMessageRequest request,
			String token) {
		logger.error("Auth Server is not connected!");
		logger.info("token = " + token);
		logger.info("tenantId = " + request.getTenantId());
		logger.info("applyId = " + request.getApplyId());
		logger.info("type = " + request.getType());
		logger.info("applyNo = " + request.getApplyNo());
		logger.info("assetsName = " + request.getAssetsName());
		logger.info("assetsNum = " + request.getAssetsNum());
		logger.info("assetsDeptId = " + request.getAssetsDeptId());
		logger.info("assetsDeptName = " + request.getAssetsDeptName());
		logger.info("reportRepairId = " + request.getReportRepairId());
		logger.info("reportRepairName = " + request.getReportRepairName());
		return null;
	}
	
	
}
