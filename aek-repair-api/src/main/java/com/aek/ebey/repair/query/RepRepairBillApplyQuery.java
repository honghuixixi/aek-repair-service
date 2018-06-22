package com.aek.ebey.repair.query;
import com.aek.common.core.base.page.PageHelp;
import com.aek.ebey.repair.request.RepRepairBillApplyResponse;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "RepRepairBillApplyQuery", description = "维修单据维修申请信息查询query")
public class RepRepairBillApplyQuery extends PageHelp<RepRepairBillApplyResponse>{
	/**
	 * 状态
	 */
	@ApiModelProperty(value = "状态，1:待接单、2:维修中、3:待验收、4:已完成")
	private Integer status;
	/**
	 * 使用科室名称
	 */
	@ApiModelProperty(value = "使用科室名称")
	private String assetsDeptName;
	/**
	 * 设备名称
	 */
	@ApiModelProperty(value = "设备名称")
	private String assetsName;
	/**
	 * 资产编号
	 */
	@ApiModelProperty(value = "资产编号")
	private String assetsNum;
	
	/**
	 * 机构ID
	 */
    @ApiModelProperty(value="机构ID")
	private Long tenantId;
    
    /**
     * 检索关键字
     */
    private String keyword;
    
    /**
	 * 状态
	 */
	@ApiModelProperty(value = "集合状态，1:待接单、2:维修中、3:待验收、4:已完成")
	private Integer[] statusList;
	
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
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
	public Long getTenantId() {
		return tenantId;
	}
	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}
	
	public Integer[] getStatusList() {
		return statusList;
	}
	public void setStatusList(Integer[] statusList) {
		this.statusList = statusList;
	}
	@Override
	public String toString() {
		return "RepRepairApplyQuery [status=" + status + ",  assetsDeptName="+ assetsDeptName + ", assetsName=" + assetsName + ", assetsNum=" + assetsNum + ", tenantId=" + tenantId+ "]";
	}
	
	

}
