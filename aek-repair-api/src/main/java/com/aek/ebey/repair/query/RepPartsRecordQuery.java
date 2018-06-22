package com.aek.ebey.repair.query;

import com.aek.common.core.base.page.PageHelp;
import com.aek.ebey.repair.model.RepPartsRecord;
import com.aek.ebey.repair.request.RepPartsRecordResponse;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "RepPartsRecordQuery", description = "操作记录查询query")
public class RepPartsRecordQuery extends PageHelp<RepPartsRecord> {
	/**
	 * 配件名称
	 */
    @ApiModelProperty(value="配件名称")
	private String partName;
    
    /**
	 * 操作类型（1入库 2 出库）
	 */
    @ApiModelProperty(value="操作类型（1入库 2 出库）")
	private String status;

	public String getPartName() {
		return partName;
	}

	public void setPartName(String partName) {
		this.partName = partName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
    
    
}
