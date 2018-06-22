package com.aek.ebey.repair.query;
import com.aek.common.core.base.page.PageHelp;
import com.aek.ebey.repair.request.RepRepairBillApproveResponse;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "RepRepairBillApproveQuery", description = "审批查询query")
public class RepRepairBillApproveQuery extends PageHelp<RepRepairBillApproveResponse>{
	/**
	 * 状态
	 */
	@ApiModelProperty(value = "状态(1=审批中，2=审批通过，3=审批未通过，4=已撤销)")
	private Integer status;
	/**
	 * 单据类型(1=外修费用,2=配件采购)
	 */
	@ApiModelProperty(value = "单据类型(1=外修费用,2=配件采购)")
	private Integer type;
    
    /**
     * 检索关键字,设备名称/申请单号
     */
    @ApiModelProperty(value = "设备名称/申请单号")
    private String keyword;

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	
}
