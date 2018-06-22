package com.aek.ebey.repair.web.request;

import java.util.List;

import com.aek.ebey.repair.model.RepRepairApply;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "RepRepairApplyResponse", description = "维修申列表")
public class RepRepairApplyResponse {
	@ApiModelProperty(value="本月天数")
	private Integer days;
	@ApiModelProperty(value="维修申请集合")
	private List<RepRepairApply> list;
	public Integer getDays() {
		return days;
	}
	public void setDays(Integer days) {
		this.days = days;
	}
	public List<RepRepairApply> getList() {
		return list;
	}
	public void setList(List<RepRepairApply> list) {
		this.list = list;
	}
	@Override
	public String toString() {
		return "RepRepairApplyResponse [days=" + days + ", list=" + list + "]";
	}
	

}
