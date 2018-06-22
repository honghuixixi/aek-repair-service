package com.aek.ebey.repair.service.ribbon;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.aek.common.core.Result;


@Component
public class QcClientHystrix implements QcClientService{

	private static final Logger logger = LogManager.getLogger(QcClientHystrix.class);

	@Override
	public Result<Integer> getQcImplementWaitToDo(Long id, String token) {
		logger.error("getQcImplementWaitToDo-----------------------------------");
		return null;
	}

	@Override
	public Result<Integer> getPmImplementWaitToDo(Long id, String token) {
		logger.error("getPmImplementWaitToDo-----------------------------------");
		return null;
	}

	@Override
	public Result<Integer> getQcCheckWaitToDo(Long id, String token) {
		logger.error("getQcCheckWaitToDo-----------------------------------");
		return null;
	}

	@Override
	public Result<Integer> getPmCheckWaitToDo(Long id, String token) {
		logger.error("getPmCheckWaitToDo-----------------------------------");
		return null;
	}

	@Override
	public Result<Integer> getMdWaitToDo(Long tenantId, String token) {
		logger.error("getMdWaitToDo-----------------------------------");
		return null;
	}
	
	
}
