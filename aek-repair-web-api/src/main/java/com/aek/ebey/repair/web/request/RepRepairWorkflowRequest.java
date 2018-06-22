package com.aek.ebey.repair.web.request;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModelProperty;

public class RepRepairWorkflowRequest {

	@ApiModelProperty(value="所属机构ID")
	private Long tenantId;
	@ApiModelProperty(value="层级索引")
	private Integer index;
	@ApiModelProperty(value="层级名称")
	private String indexName;
	@ApiModelProperty(value="区间开始值")
	private BigDecimal minFee;
	@ApiModelProperty(value="区间结束值")
	private BigDecimal maxFee;
	@ApiModelProperty(value="审批人id")
	private Long checkUserId;
	@ApiModelProperty(value="审批人姓名")
	private String checkUserName;
	@ApiModelProperty(value="审批人职务")
	private String checkUserJob;
	@ApiModelProperty(value="备注")
	private String remark;
		
	public Long getTenantId() {
		return tenantId;
	}
	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
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
	public Long getCheckUserId() {
		return checkUserId;
	}
	public void setCheckUserId(Long checkUserId) {
		this.checkUserId = checkUserId;
	}
	public String getCheckUserName() {
		return checkUserName;
	}
	public void setCheckUserName(String checkUserName) {
		this.checkUserName = checkUserName;
	}
	public String getCheckUserJob() {
		return checkUserJob;
	}
	public void setCheckUserJob(String checkUserJob) {
		this.checkUserJob = checkUserJob;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	
	
}
