package com.aek.ebey.repair.web.request;

import com.baomidou.mybatisplus.annotations.TableField;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "RepairApplyRequest", description = "维修申请信息")
public class RepairApplyRequest {
	
	@ApiModelProperty(value="关联设备ID")
	private Long assetsId;
	
	/**
	 * 机构ID
	 */
    @ApiModelProperty(value="机构ID")
	private Long tenantId;
	
	@ApiModelProperty(value="使用科室名称")
	private String assetsDeptName;
	
	
	@ApiModelProperty(value="设备名称")
	private String assetsName;
	
	
	@ApiModelProperty(value="资产编号")
	private String assetsNum;
	
	
	@ApiModelProperty(value="故障描述")
	private String faultDesc;
	
	/**
	 * 设备图片路径，多图以，分割
	 */
    @ApiModelProperty(value="设备图片路径，多图以，分割")
	private String assetsImg;
	
	
	
	public String getAssetsImg() {
		return assetsImg;
	}



	public void setAssetsImg(String assetsImg) {
		this.assetsImg = assetsImg;
	}



	@ApiModelProperty(value="紧急程度(1;2;3;4)")
	private Integer urgentLevel;



	public Long getAssetsId() {
		return assetsId;
	}



	public void setAssetsId(Long assetsId) {
		this.assetsId = assetsId;
	}



	public String getAssetsDeptName() {
		return assetsDeptName;
	}



	public void setAssetsDeptName(String assetsDeptName) {
		this.assetsDeptName = assetsDeptName;
	}



	public String getAssetsName() {
		return assetsName;
	}



	public void setAssetsName(String assetsName) {
		this.assetsName = assetsName;
	}



	public String getAssetsNum() {
		return assetsNum;
	}



	public void setAssetsNum(String assetsNum) {
		this.assetsNum = assetsNum;
	}



	public String getFaultDesc() {
		return faultDesc;
	}



	public void setFaultDesc(String faultDesc) {
		this.faultDesc = faultDesc;
	}



	public Integer getUrgentLevel() {
		return urgentLevel;
	}



	public void setUrgentLevel(Integer urgentLevel) {
		this.urgentLevel = urgentLevel;
	}



	public Long getTenantId() {
		return tenantId;
	}



	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}



	@Override
	public String toString() {
		return "RepairApplyRequest [assetsId=" + assetsId + ", tenantId=" + tenantId + ", assetsDeptName="
				+ assetsDeptName + ", assetsName=" + assetsName + ", assetsNum=" + assetsNum + ", faultDesc="
				+ faultDesc + ", assetsImg=" + assetsImg + ", urgentLevel=" + urgentLevel + "]";
	}



	

}
