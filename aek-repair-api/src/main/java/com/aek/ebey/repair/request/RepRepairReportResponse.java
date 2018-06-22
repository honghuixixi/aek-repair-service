package com.aek.ebey.repair.request;

import java.util.List;

import com.aek.ebey.repair.model.RepPartsRecord;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "RepRepairReportResponse", description = "维修报告单Response")
public class RepRepairReportResponse {
	
	@ApiModelProperty(value="维修方式")
	private String modeStatusName;
	
	/**
	 * 外修单位
	 */
	@ApiModelProperty(value="外修单位")
	private String outsideCompany;
	/**
	 * 外修电话
	 */
	@ApiModelProperty(value="外修电话")
	private String outsidePhone;
	
	
	/**
	 * 故障现象(自定义单独拼接成串,格式1，2，3，电源问题)
	 */
	@ApiModelProperty(value="故障现象(自定义单独拼接成串,格式1，2，3，电源问题)")
	private List<String> faultPhenomenonList;
	
	/**
	 * 故障原因(自定义单独拼接成串,格式1，2，3，电源问题)
	 */
	@ApiModelProperty(value="故障原因(自定义单独拼接成串,格式1，2，3，电源问题)")
	private List<String> faultReasonList;
	
	/**
	 * 工作内容(自定义单独拼接成串,格式1，2，3，电源问题)
	 */
	@ApiModelProperty(value="工作内容(自定义单独拼接成串,格式1，2，3，电源问题)")
	private List<String> workContentList;
	
	@ApiModelProperty(value="关联配件")
	private List<RepPartsRecord> list;

	public String getModeStatusName() {
		return modeStatusName;
	}

	public void setModeStatusName(String modeStatusName) {
		this.modeStatusName = modeStatusName;
	}

	public String getOutsideCompany() {
		return outsideCompany;
	}

	public void setOutsideCompany(String outsideCompany) {
		this.outsideCompany = outsideCompany;
	}

	public String getOutsidePhone() {
		return outsidePhone;
	}

	public void setOutsidePhone(String outsidePhone) {
		this.outsidePhone = outsidePhone;
	}

	public List<String> getFaultPhenomenonList() {
		return faultPhenomenonList;
	}

	public void setFaultPhenomenonList(List<String> faultPhenomenonList) {
		this.faultPhenomenonList = faultPhenomenonList;
	}

	public List<String> getFaultReasonList() {
		return faultReasonList;
	}

	public void setFaultReasonList(List<String> faultReasonList) {
		this.faultReasonList = faultReasonList;
	}

	public List<String> getWorkContentList() {
		return workContentList;
	}

	public void setWorkContentList(List<String> workContentList) {
		this.workContentList = workContentList;
	}

	public List<RepPartsRecord> getList() {
		return list;
	}

	public void setList(List<RepPartsRecord> list) {
		this.list = list;
	}
	
	

}
