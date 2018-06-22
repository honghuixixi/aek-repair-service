package com.aek.ebey.repair.request;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "RepRepairBillCheckRequest", description = "RepRepairBillCheckRequest")
public class RepRepairBillCheckRequest {
    /**
	 * 维修单据ID
	 */
	@ApiModelProperty(value="维修单据ID")
	private Long id;
	
	/**
	 * 状态
	 */
	@ApiModelProperty(value = "状态(2=审批通过，3=审批未通过)")
	private Integer status;
    
    /**
   	 * 审批备注
   	 */
    @ApiModelProperty(value="审批备注")
    private String remark;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
    

}
