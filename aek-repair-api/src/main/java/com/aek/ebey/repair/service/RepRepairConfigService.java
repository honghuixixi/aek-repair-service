package com.aek.ebey.repair.service;

import com.aek.ebey.repair.model.RepRepairConfig;
import com.aek.ebey.repair.model.vo.RepConfigDeptVo;
import com.aek.ebey.repair.model.vo.RepConfigResponseVo;
import com.aek.ebey.repair.model.vo.RepConfiger;
import com.aek.ebey.repair.model.vo.RepUserVo;
import com.baomidou.mybatisplus.plugins.Page;

import java.util.List;

import com.aek.common.core.base.BaseService;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author cyl
 * @since 2018-01-26
 */
public interface RepRepairConfigService extends BaseService<RepRepairConfig> {
	
	List<RepConfigDeptVo> selectDept(String keyword);
	
	Page<RepUserVo> repairConfigPage(Page<RepUserVo> page);
		
	void repConfig(Long repairId,List<RepConfigDeptVo> depts);
	
	RepConfigResponseVo getConfigDetail(Long repairId);
	
	RepConfiger selectConfiger(Long deptId);
	
	List<RepConfiger> selectUsers();
}
