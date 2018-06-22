package com.aek.ebey.repair.model.vo;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;

public class RepConfigResponseVo {

	@ApiModelProperty(value="维修工程师id")
	private Long repairId;
	@ApiModelProperty(value="所有可用部门")
	private List<TakeOrderDeptVo> allDepts;
	@ApiModelProperty(value="接单科室集合")
	private List<TakeOrderDeptVo> ownDepts;
	
	public Long getRepairId() {
		return repairId;
	}
	public void setRepairId(Long repairId) {
		this.repairId = repairId;
	}
	public List<TakeOrderDeptVo> getAllDepts() {
		return allDepts;
	}
	public void setAllDepts(List<TakeOrderDeptVo> allDepts) {
		this.allDepts = allDepts;
	}
	public List<TakeOrderDeptVo> getOwnDepts() {
		return ownDepts;
	}
	public void setOwnDepts(List<TakeOrderDeptVo> ownDepts) {
		this.ownDepts = ownDepts;
	}
	
	
	
	
	
}
