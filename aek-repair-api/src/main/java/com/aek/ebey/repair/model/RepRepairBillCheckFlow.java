package com.aek.ebey.repair.model;

import java.util.Date;

import com.aek.common.core.base.BaseModel;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 维修单据审核流程表实体类
 *	
 * @author HongHui
 * @date   2018年1月26日
 */
@ApiModel(value = "RepRepairBillCheckFlow", description = "维修单据配置信息")
@TableName("rep_repair_bill_check_flow")
public class RepRepairBillCheckFlow extends BaseModel {

	private static final long serialVersionUID = 18685051877537317L;

	/**
	 * 维修单据ID
	 */
    @ApiModelProperty(value="维修单据ID")
	@TableField(value="bill_id")
	private Long billId;
    
    /**
	 * 审批流程名称
	 */
    @ApiModelProperty(value="审批流程名称")
	@TableField(value="flow_name")
    private String flowName;
    
	/**
	 * 审批人ID
	 */
    @ApiModelProperty(value="审批人ID")
	@TableField(value="check_user_id")
	private Long checkUserId;
    
    /**
	 * 审批人姓名
	 */
    @ApiModelProperty(value="审批人姓名")
	@TableField(value="check_user_name")
	private String checkUserName;

    /**
	 * 审批人手机号
	 */
    @ApiModelProperty(value="审批人手机号")
	@TableField(value="check_user_mobile")
	private Long checkUserMobile;
    
    /**
   	 * 流程序号
   	 */
    @ApiModelProperty(value="流程序号")
   	@TableField(value="index")
    private Integer index;
    
    
    /**
   	 * 审核状态(1=待审核，2=审核通过，3=审核未通过）
   	 */
    @ApiModelProperty(value="审核状态(1=待审核，2=审核通过，3=审核未通过）")
   	@TableField(value="check_status")
    private Integer checkStatus;
    
    /**
   	 * 审核状态(1=待审核，2=审核通过，3=审核未通过）
   	 */
    @ApiModelProperty(value="审核状态文本(1=待审核，2=审核通过，3=审核未通过）")
    @TableField(exist=false)
    private String checkStatusText;
    
    /**
   	 * 审核备注
   	 */
    @ApiModelProperty(value="审核备注")
   	@TableField(value="check_remark")
    private String checkRemark;
    
    /**
   	 * 审核时间
   	 */
    @ApiModelProperty(value="审核时间")
   	@TableField(value="check_time")
    private Date checkTime;

	public Long getBillId() {
		return billId;
	}

	public void setBillId(Long billId) {
		this.billId = billId;
	}

	public Long getCheckUserId() {
		return checkUserId;
	}

	public void setCheckUserId(Long checkUserId) {
		this.checkUserId = checkUserId;
	}

	public Long getCheckUserMobile() {
		return checkUserMobile;
	}

	public void setCheckUserMobile(Long checkUserMobile) {
		this.checkUserMobile = checkUserMobile;
	}

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	public Integer getCheckStatus() {
		return checkStatus;
	}

	public void setCheckStatus(Integer checkStatus) {
		this.checkStatus = checkStatus;
	}

	public String getCheckRemark() {
		return checkRemark;
	}

	public void setCheckRemark(String checkRemark) {
		this.checkRemark = checkRemark;
	}

	public String getCheckStatusText() {
		return checkStatusText;
	}

	public void setCheckStatusText(String checkStatusText) {
		this.checkStatusText = checkStatusText;
	}

	public Date getCheckTime() {
		return checkTime;
	}

	public void setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
	}

	public String getCheckUserName() {
		return checkUserName;
	}

	public void setCheckUserName(String checkUserName) {
		this.checkUserName = checkUserName;
	}

	public String getFlowName() {
		return flowName;
	}

	public void setFlowName(String flowName) {
		this.flowName = flowName;
	}
	
}

