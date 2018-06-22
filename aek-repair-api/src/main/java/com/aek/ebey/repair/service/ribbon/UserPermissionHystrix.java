package com.aek.ebey.repair.service.ribbon;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.aek.common.core.Result;
import com.aek.ebey.repair.model.vo.RepConfigDeptVo;
import com.aek.ebey.repair.model.vo.RepUserVo;

@Component
public class UserPermissionHystrix implements UserPermissionService {
	
	private static final Logger logger = LoggerFactory.getLogger(UserPermissionHystrix.class);

	@Override
	public Result<List<Long>> findByTenantAndCanPermiss(String tenantId, String permissionCode, String token) {
		logger.error("findByTenantAndCanPermiss------------------------------------------------------");
		return null;
	}

	@Override
	public Result<String> findAllSubDeptById(Long deptId, String token) {
		logger.error("findAllSubDeptById------------------------------------------------------");
		return null;
	}

	@Override
	public Result<Integer> checkIsRep(Long id, String token) {
		logger.error("checkIsRep------------------------------------------------------"+id);
		return null;
	}

	@Override
	public Result<List<RepUserVo>> getTakeOrderUserList(String token) {
		logger.error("token------------------------------------------------------"+token);
		return null;
	}

	@Override
	public Result<List<RepConfigDeptVo>> getDeptList(String keyword, String token) {
		return null;
	}

	@Override
	public Result<RepUserVo> getUser(Long id, Long tenantId, String token) {
		return null;
	}

	@Override
	public Result<Integer> checkIsRepHelp(Long id, String token) {
		return null;
	}

	@Override
	public Result<Integer> checkIsRepBill(Long id, String token) {
		return null;
	}

	@Override
	public Result<Boolean> checkIsDiscard(Long id, String token) {
		logger.error("token------------------------------------------------------id="+id+"=token="+token);
		return null;
	}

	@Override
	public Result<Boolean> checkIsTransfer(Long id, String token) {
		logger.error("token------------------------------------------------------id="+id+"=token="+token);
		return null;
	}

	@Override
	public Result<Boolean> checkIsRht(Long id, String rht, String token) {
		logger.error("token------------------------------------------------------id="+id+"=rht="+rht);
		return null;
	}

    @Override
    public Result<List<RepUserVo>> getRepairUserList(String token) {
        logger.error("token------------------------------------------------------=token="+token);
        return null;
    }

	@Override
	public Result<List<RepConfigDeptVo>> getAllDeptList(String keyword, String token) {
		return null;
	}

	
}
