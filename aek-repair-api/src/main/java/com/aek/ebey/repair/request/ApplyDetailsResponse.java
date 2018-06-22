package com.aek.ebey.repair.request;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ApplyDetailsResponse", description = "维修单详情")
public class ApplyDetailsResponse implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	/**
	 * 报修申请人姓名
	 */
	@ApiModelProperty(value="报修申请人姓名")
	private String reportRepairName;
	
	
	/**
	 * 报修申请时间
	 */
	@ApiModelProperty(value="报修申请时间")
	private Date reportRepairDate;
	
	

	/**
	 * 鉴定人姓名
	 */
	@ApiModelProperty(value="接单人姓名")
	private String takeOrderName;
	
	/**
	 * 鉴定时间
	 */
	@ApiModelProperty(value="接单时间")
	private Date takeOrderTime;
	
	/**
	 * 维修人姓名
	 */
	@ApiModelProperty(value="维修人姓名")
	private String repairName;
	
	/**
	 * 维修时间
	 */
	@ApiModelProperty(value="维修时间")
	private Date repairDate;
	
	/**
	 * 验收人姓名
	 */
	@ApiModelProperty(value="验收人姓名")
	private String repairCheckName;
	
	/**
	 * 验收时间
	 */
	@ApiModelProperty(value="验收时间")
	private Date repairCheckTime;

	public String getReportRepairName() {
		return reportRepairName;
	}

	public void setReportRepairName(String reportRepairName) {
		this.reportRepairName = reportRepairName;
	}

	public Date getReportRepairDate() {
		return reportRepairDate;
	}

	public void setReportRepairDate(Date reportRepairDate) {
		this.reportRepairDate = reportRepairDate;
	}

	

	public String getTakeOrderName() {
		return takeOrderName;
	}

	public void setTakeOrderName(String takeOrderName) {
		this.takeOrderName = takeOrderName;
	}

	public Date getTakeOrderTime() {
		return takeOrderTime;
	}

	public void setTakeOrderTime(Date takeOrderTime) {
		this.takeOrderTime = takeOrderTime;
	}

	public String getRepairName() {
		return repairName;
	}

	public void setRepairName(String repairName) {
		this.repairName = repairName;
	}

	public Date getRepairDate() {
		return repairDate;
	}

	public void setRepairDate(Date repairDate) {
		this.repairDate = repairDate;
	}

	public String getRepairCheckName() {
		return repairCheckName;
	}

	public void setRepairCheckName(String repairCheckName) {
		this.repairCheckName = repairCheckName;
	}


	public Date getRepairCheckTime() {
		return repairCheckTime;
	}

	public void setRepairCheckTime(Date repairCheckTime) {
		this.repairCheckTime = repairCheckTime;
	}

	@Override
	public String toString() {
		return "ApplyDetailsResponse [reportRepairName=" + reportRepairName + ", reportRepairDate=" + reportRepairDate
				+ ", takeOrderName=" + takeOrderName + ", takeOrderTime=" + takeOrderTime + ", repairName=" + repairName
				+ ", repairDate=" + repairDate + ", repairCheckName=" + repairCheckName + ", repairCheckTime="
				+ repairCheckTime + "]";
	}



}
