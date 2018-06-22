package com.aek.ebey.repair.query;

import com.aek.common.core.base.page.PageHelp;
import com.aek.ebey.repair.request.RepairRecordResponse;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "RepRepairRecordQuery", description = "维修记录查询query")
public class RepRepairRecordQuery extends PageHelp<RepairRecordResponse>{
	
	/**
	 * 设备id
	 */
    @ApiModelProperty(value="设备id")
	private String assetsId;
	
	/**
	 * 维修方式（1，自主维修 2，外修 3，现场解决）
	 */
	@ApiModelProperty(value="维修方式（1，自主维修 2，外修 3，现场解决）")
	private Integer modeStatus;
	
	
	/**
	 * 维修申请单号
	 */
    @ApiModelProperty(value="维修申请单号")
	private String applyNo;


	public String getAssetsId() {
		return assetsId;
	}


	public void setAssetsId(String assetsId) {
		this.assetsId = assetsId;
	}


	public Integer getModeStatus() {
		return modeStatus;
	}


	public void setModeStatus(Integer modeStatus) {
		this.modeStatus = modeStatus;
	}


	public String getApplyNo() {
		return applyNo;
	}


	public void setApplyNo(String applyNo) {
		this.applyNo = applyNo;
	}
    
    

}
