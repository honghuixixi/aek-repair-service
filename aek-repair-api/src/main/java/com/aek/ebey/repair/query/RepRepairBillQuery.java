package com.aek.ebey.repair.query;
import com.aek.common.core.base.page.PageHelp;
import com.aek.ebey.repair.model.RepRepairBill;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "RepRepairBillQuery", description = "维修单据维修申请信息查询query")
public class RepRepairBillQuery extends PageHelp<RepRepairBill>{
	/**
	 * 状态
	 */
	@ApiModelProperty(value = "状态(1=审批中，2=审批通过，3=审批未通过，4=已撤销)")
	private Integer status;
	/**
	 * 申请类型(1=我的申请，2=全院申请)
	 */
	@ApiModelProperty(value = "申请类型(1=我的申请，2=全院申请)")
	private Integer applyType;
	/**
	 * 单据类型(1=外修费用,2=配件采购)
	 */
	@ApiModelProperty(value = "单据类型(1=外修费用,2=配件采购)")
	private Integer type;
	
	/**
	 * 机构ID
	 */
    @ApiModelProperty(value="机构ID")
	private Long tenantId;
    
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

	public Integer getApplyType() {
		return applyType;
	}

	public void setApplyType(Integer applyType) {
		this.applyType = applyType;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Long getTenantId() {
		return tenantId;
	}

	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

}
