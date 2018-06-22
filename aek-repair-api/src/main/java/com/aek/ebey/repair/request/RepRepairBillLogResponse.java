package com.aek.ebey.repair.request;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 维修单据操作流程
 *	
 * @author HongHui
 * @date   2018年1月30日
 */
@ApiModel(value = "RepRepairBillLogResponse", description = "维修单据操作流程日志")
public class RepRepairBillLogResponse {
	/**
	 * 操作人
	 */
	@ApiModelProperty(value="操作人")
	private String operator;
	
	/**
	 * 操作状态
	 */
	@ApiModelProperty(value="操作状态(0=提交申请，1=待审核，2=审核通过，3=审核未通过)")
	private Integer operateStatus;
	
	/**
	 * 操作名称
	 */
	@ApiModelProperty(value="操作名称")
	private String operateName;
	/**
	 * 操作时间
	 */
	@ApiModelProperty(value="操作时间")
	private Date operateTime;
	
	/**
	 * 流程ID
	 */
	@ApiModelProperty(value="流程ID")
	private Long checkFlowId;

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public Integer getOperateStatus() {
		return operateStatus;
	}

	public void setOperateStatus(Integer operateStatus) {
		this.operateStatus = operateStatus;
	}

	public String getOperateName() {
		return operateName;
	}

	public void setOperateName(String operateName) {
		this.operateName = operateName;
	}

	public Date getOperateTime() {
		return operateTime;
	}

	public void setOperateTime(Date operateTime) {
		this.operateTime = operateTime;
	}

	public Long getCheckFlowId() {
		return checkFlowId;
	}

	public void setCheckFlowId(Long checkFlowId) {
		this.checkFlowId = checkFlowId;
	}
}
