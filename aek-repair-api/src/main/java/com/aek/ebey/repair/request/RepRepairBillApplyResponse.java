package com.aek.ebey.repair.request;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "RepRepairBillApplyResponse", description = "维修单据维修单数据")
public class RepRepairBillApplyResponse {
	
	@ApiModelProperty(value="维修单ID")
	private Long id;
	
	@ApiModelProperty(value="机构ID")
	private Long tenantId;
	
	@ApiModelProperty(value="维修单号")
	private String applyNo;
	
	@ApiModelProperty(value="设备ID")
	private Long assetsId;
	
	@ApiModelProperty(value="设备所在部门ID")
	private Long assetsDeptId;
	
	@ApiModelProperty(value="设备名称")
	private String assetsName;
	
	@ApiModelProperty(value="院内编码")
	private String serialNum;
	
	@ApiModelProperty(value="设备所在部门名称")
	private String assetsDeptName;
	
	@ApiModelProperty(value="设备规格型号")
	private String assetsSpec;
	
	@ApiModelProperty(value="设备启用日期")
	private Date startUseDate;
	
	@ApiModelProperty(value="设备启用日期[格式化]")
	private String startUseDateStr;
	
	@ApiModelProperty(value="维修申请日期")
	private Date reportRepairDate;
	
	@ApiModelProperty(value="维修申请日期[格式化]")
	private String reportRepairDateStr;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTenantId() {
		return tenantId;
	}

	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}

	public String getApplyNo() {
		return applyNo;
	}

	public void setApplyNo(String applyNo) {
		this.applyNo = applyNo;
	}

	public Long getAssetsId() {
		return assetsId;
	}

	public void setAssetsId(Long assetsId) {
		this.assetsId = assetsId;
	}

	public Long getAssetsDeptId() {
		return assetsDeptId;
	}

	public void setAssetsDeptId(Long assetsDeptId) {
		this.assetsDeptId = assetsDeptId;
	}

	public String getAssetsDeptName() {
		return assetsDeptName;
	}

	public void setAssetsDeptName(String assetsDeptName) {
		this.assetsDeptName = assetsDeptName;
	}

	public String getAssetsSpec() {
		return assetsSpec;
	}

	public void setAssetsSpec(String assetsSpec) {
		this.assetsSpec = assetsSpec;
	}

	public Date getStartUseDate() {
		return startUseDate;
	}

	public void setStartUseDate(Date startUseDate) {
		this.startUseDate = startUseDate;
	}

	public String getStartUseDateStr() {
		return startUseDateStr;
	}

	public void setStartUseDateStr(String startUseDateStr) {
		this.startUseDateStr = startUseDateStr;
	}

	public Date getReportRepairDate() {
		return reportRepairDate;
	}

	public void setReportRepairDate(Date reportRepairDate) {
		this.reportRepairDate = reportRepairDate;
	}

	public String getReportRepairDateStr() {
		return reportRepairDateStr;
	}

	public void setReportRepairDateStr(String reportRepairDateStr) {
		this.reportRepairDateStr = reportRepairDateStr;
	}

	public String getAssetsName() {
		return assetsName;
	}

	public void setAssetsName(String assetsName) {
		this.assetsName = assetsName;
	}

	public String getSerialNum() {
		return serialNum;
	}

	public void setSerialNum(String serialNum) {
		this.serialNum = serialNum;
	}

}
