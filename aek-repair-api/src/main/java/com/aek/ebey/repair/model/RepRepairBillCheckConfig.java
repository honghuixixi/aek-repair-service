package com.aek.ebey.repair.model;

import java.math.BigDecimal;

import com.aek.common.core.base.BaseModel;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 维修单据配置实体类
 *	
 * @author HongHui
 * @date   2018年1月26日
 */
@ApiModel(value = "RepRepairBillCheckConfig", description = "维修单据配置信息")
@TableName("rep_repair_bill_check_config")
public class RepRepairBillCheckConfig extends BaseModel {

	private static final long serialVersionUID = 6794169755745843753L;

	/**
	 * 机构ID
	 */
    @ApiModelProperty(value="机构ID")
	@TableField(value="tenant_id")
	private Long tenantId;
    
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
	 * 审核人职务
	 */
    @ApiModelProperty(value="审核人职务")
	@TableField(value="check_user_job")
	private String checkUserJob;
    
    /**
   	 * 费用最小值
   	 */
    @ApiModelProperty(value="费用最小值")
   	@TableField(value="min_fee")
    private BigDecimal minFee;
    
    /**
   	 * 费用最大值
   	 */
    @ApiModelProperty(value="费用最大值")
   	@TableField(value="max_fee")
    private BigDecimal maxFee;
    
    /**
   	 * 层级序号
   	 */
    @ApiModelProperty(value="层级序号")
   	@TableField(value="index")
    private Integer index;
    
    /**
   	 * 层级名称
   	 */
    @ApiModelProperty(value="层级名称")
   	@TableField(value="index_name")
    private String indexName;
    
    /**
   	 * 备注信息
   	 */
    @ApiModelProperty(value="备注信息")
   	@TableField(value="remark")
    private String remark;

	public Long getTenantId() {
		return tenantId;
	}

	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
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

	public String getCheckUserJob() {
		return checkUserJob;
	}

	public void setCheckUserJob(String checkUserJob) {
		this.checkUserJob = checkUserJob;
	}

	public BigDecimal getMinFee() {
		return minFee;
	}

	public void setMinFee(BigDecimal minFee) {
		this.minFee = minFee;
	}

	public BigDecimal getMaxFee() {
		return maxFee;
	}

	public void setMaxFee(BigDecimal maxFee) {
		this.maxFee = maxFee;
	}

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	public String getIndexName() {
		return indexName;
	}

	public void setIndexName(String indexName) {
		this.indexName = indexName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public String getCheckUserName() {
		return checkUserName;
	}

	public void setCheckUserName(String checkUserName) {
		this.checkUserName = checkUserName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((checkUserId == null) ? 0 : checkUserId.hashCode());
		result = prime * result + ((checkUserJob == null) ? 0 : checkUserJob.hashCode());
		result = prime * result + ((checkUserMobile == null) ? 0 : checkUserMobile.hashCode());
		result = prime * result + ((index == null) ? 0 : index.hashCode());
		result = prime * result + ((indexName == null) ? 0 : indexName.hashCode());
		result = prime * result + ((maxFee == null) ? 0 : maxFee.hashCode());
		result = prime * result + ((minFee == null) ? 0 : minFee.hashCode());
		result = prime * result + ((remark == null) ? 0 : remark.hashCode());
		result = prime * result + ((tenantId == null) ? 0 : tenantId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RepRepairBillCheckConfig other = (RepRepairBillCheckConfig) obj;
		if (checkUserId == null) {
			if (other.checkUserId != null)
				return false;
		} else if (!checkUserId.equals(other.checkUserId))
			return false;
		if (checkUserJob == null) {
			if (other.checkUserJob != null)
				return false;
		} else if (!checkUserJob.equals(other.checkUserJob))
			return false;
		if (checkUserMobile == null) {
			if (other.checkUserMobile != null)
				return false;
		} else if (!checkUserMobile.equals(other.checkUserMobile))
			return false;
		if (index == null) {
			if (other.index != null)
				return false;
		} else if (!index.equals(other.index))
			return false;
		if (indexName == null) {
			if (other.indexName != null)
				return false;
		} else if (!indexName.equals(other.indexName))
			return false;
		if (maxFee == null) {
			if (other.maxFee != null)
				return false;
		} else if (!maxFee.equals(other.maxFee))
			return false;
		if (minFee == null) {
			if (other.minFee != null)
				return false;
		} else if (!minFee.equals(other.minFee))
			return false;
		if (remark == null) {
			if (other.remark != null)
				return false;
		} else if (!remark.equals(other.remark))
			return false;
		if (tenantId == null) {
			if (other.tenantId != null)
				return false;
		} else if (!tenantId.equals(other.tenantId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RepRepairBillCheckConfig [tenantId=" + tenantId + ", checkUserId=" + checkUserId + ", checkUserMobile="
				+ checkUserMobile + ", checkUserJob=" + checkUserJob + ", minFee=" + minFee + ", maxFee=" + maxFee
				+ ", index=" + index + ", indexName=" + indexName + ", remark=" + remark + "]";
	}
    
}

