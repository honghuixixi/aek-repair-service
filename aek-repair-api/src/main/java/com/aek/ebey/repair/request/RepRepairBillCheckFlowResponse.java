package com.aek.ebey.repair.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 维修单据流程详情实体类
 *	
 * @author HongHui
 * @date   2018年1月26日
 */
@ApiModel(value = "RepRepairBillCheckFlowResponse", description = "维修单据流程详情数据")
public class RepRepairBillCheckFlowResponse {

	@ApiModelProperty(value="审批结果")
	private String checkResult;
	
	@ApiModelProperty(value="备注")
	private String checkRemark;

	public String getCheckResult() {
		return checkResult;
	}

	public void setCheckResult(String checkResult) {
		this.checkResult = checkResult;
	}

	public String getCheckRemark() {
		return checkRemark;
	}

	public void setCheckRemark(String checkRemark) {
		this.checkRemark = checkRemark;
	}
	
}
