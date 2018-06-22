package com.aek.ebey.repair.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ApplyTurnOrderRequest", description = "转单")
public class ApplyTurnOrderRequest {
	
	/**
	 * 关联申请单id
	 */
	@ApiModelProperty(value="关联申请单id")
	private Long applyId;
	
	
	/**
	 * 转单接单人id
	 */
	@ApiModelProperty(value="转单接单人id")
	private Long toId;
	
	
	/**
	 * 转单接单人姓名
	 */
	@ApiModelProperty(value="转单接单人姓名")
	private String toName;


	public Long getApplyId() {
		return applyId;
	}


	public void setApplyId(Long applyId) {
		this.applyId = applyId;
	}


	public Long getToId() {
		return toId;
	}


	public void setToId(Long toId) {
		this.toId = toId;
	}


	public String getToName() {
		return toName;
	}


	public void setToName(String toName) {
		this.toName = toName;
	}
	
}
