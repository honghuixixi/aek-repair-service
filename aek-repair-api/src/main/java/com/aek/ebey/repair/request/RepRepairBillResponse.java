package com.aek.ebey.repair.request;

import java.math.BigDecimal;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 维修单据实体类
 *	
 * @author HongHui
 * @date   2018年1月26日
 */
@ApiModel(value = "RepRepairBillResponse", description = "维修单据维修单数据")
public class RepRepairBillResponse{

	/**
	 * 维修单据ID
	 */
	@ApiModelProperty(value="维修单据ID")
	private Long id;
	
	/**
	 * 机构ID
	 */
    @ApiModelProperty(value="机构ID")
	private Long tenantId;
    
	/**
	 * 单据编号
	 */
    @ApiModelProperty(value="单据编号")
	private String billNo;

    /**
	 * 单据类型(1=外修费用,2=配件采购)
	 */
    @ApiModelProperty(value="单据类型(1=外修费用,2=配件采购)")
	private Integer type;
    
    /**
     * 单据类型文本(1=外修费用,2=配件采购)
     */
    @ApiModelProperty(value="单据类型文本(1=外修费用,2=配件采购)")
    private String typeText;
    
    /**
	 * 状态(1=审批中，2=审批通过，3=审批未通过，4=已撤销)
	 */
    @ApiModelProperty(value="状态(1=审批中，2=审批通过，3=审批未通过，4=已撤销)")
	private Integer status;
    
    /**
	 * 状态文本(1=审批中，2=审批通过，3=审批未通过，4=已撤销)
	 */
    @ApiModelProperty(value="状态文本(1=审批中，2=审批通过，3=审批未通过，4=已撤销)")
	private String statusText;
    
    /**
	 * 维修申请单ID
	 */
    @ApiModelProperty(value="维修申请单ID")
	private Long applyId;
    
    /**
   	 * 维修单号
   	 */
    @ApiModelProperty(value="维修单号")
    private String applyNo;
    
    /**
   	 * 维修设备名称
   	 */
    @ApiModelProperty(value="维修设备名称")
    private String assetsName;
    
    /**
   	 * 设备使用科室名称
   	 */
    @ApiModelProperty(value="设备使用科室名称")
    private String assetsDeptName;
    
    /**
   	 * 设备规格型号
   	 */
    @ApiModelProperty(value="设备规格型号")
    private String assetsSpec;
    
    /**
   	 * 设备院内编码
   	 */
    @ApiModelProperty(value="设备院内编码")
    private String serialNum;
    
    /**
   	 * 设备启用日期
   	 */
    @ApiModelProperty(value="设备启用日期")
    private Date startUseDate;
    
    /**
   	 * 维修申请日期
   	 */
    @ApiModelProperty(value="维修申请日期")
    private Date reportRepairDate;
    
    /**
   	 * 外修单位
   	 */
    @ApiModelProperty(value="外修单位")
    private String externalRepairCompany;
    
    /**
   	 * 申请人ID
   	 */
    @ApiModelProperty(value="申请人ID")
    private Long applyUserId;
    
    /**
  	 * 申请人姓名
  	 */
    @ApiModelProperty(value="申请人姓名")
    private String applyUserName;
    
    /**
   	 * 申请时间
   	 */
    @ApiModelProperty(value="申请时间")
    private Date applyTime;
    
    /**
   	 * 费用金额
   	 */
    @ApiModelProperty(value="费用金额")
    private BigDecimal fee;
    
    /**
   	 * 备注信息
   	 */
    @ApiModelProperty(value="备注信息")
    private String remark;
    
    /**
   	 * 审批流程所处序号
   	 */
    @ApiModelProperty(value="审批流程所处序号")
    private Integer currentIndex;
    
    /**
   	 * 当前审批人
   	 */
    @ApiModelProperty(value="当前审批人")
    private String checkUserName;
    
	public Long getTenantId() {
		return tenantId;
	}

	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}

	public String getBillNo() {
		return billNo;
	}

	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getApplyNo() {
		return applyNo;
	}

	public void setApplyNo(String applyNo) {
		this.applyNo = applyNo;
	}

	public String getAssetsName() {
		return assetsName;
	}

	public void setAssetsName(String assetsName) {
		this.assetsName = assetsName;
	}

	public String getAssetsDeptName() {
		return assetsDeptName;
	}

	public void setAssetsDeptName(String assetsDeptName) {
		this.assetsDeptName = assetsDeptName;
	}

	public String getExternalRepairCompany() {
		return externalRepairCompany;
	}

	public void setExternalRepairCompany(String externalRepairCompany) {
		this.externalRepairCompany = externalRepairCompany;
	}

	public Long getApplyUserId() {
		return applyUserId;
	}

	public void setApplyUserId(Long applyUserId) {
		this.applyUserId = applyUserId;
	}

	public Date getApplyTime() {
		return applyTime;
	}

	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}

	public BigDecimal getFee() {
		return fee;
	}

	public void setFee(BigDecimal fee) {
		this.fee = fee;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getCurrentIndex() {
		return currentIndex;
	}

	public void setCurrentIndex(Integer currentIndex) {
		this.currentIndex = currentIndex;
	}

	public Long getApplyId() {
		return applyId;
	}

	public void setApplyId(Long applyId) {
		this.applyId = applyId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTypeText() {
		return typeText;
	}

	public void setTypeText(String typeText) {
		this.typeText = typeText;
	}

	public String getStatusText() {
		return statusText;
	}

	public void setStatusText(String statusText) {
		this.statusText = statusText;
	}
	
	public String getCheckUserName() {
		return checkUserName;
	}

	public void setCheckUserName(String checkUserName) {
		this.checkUserName = checkUserName;
	}
	
	public String getAssetsSpec() {
		return assetsSpec;
	}

	public void setAssetsSpec(String assetsSpec) {
		this.assetsSpec = assetsSpec;
	}

	public String getSerialNum() {
		return serialNum;
	}

	public void setSerialNum(String serialNum) {
		this.serialNum = serialNum;
	}

	public Date getStartUseDate() {
		return startUseDate;
	}

	public void setStartUseDate(Date startUseDate) {
		this.startUseDate = startUseDate;
	}

	public Date getReportRepairDate() {
		return reportRepairDate;
	}

	public void setReportRepairDate(Date reportRepairDate) {
		this.reportRepairDate = reportRepairDate;
	}

	public String getApplyUserName() {
		return applyUserName;
	}

	public void setApplyUserName(String applyUserName) {
		this.applyUserName = applyUserName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((applyId == null) ? 0 : applyId.hashCode());
		result = prime * result + ((applyNo == null) ? 0 : applyNo.hashCode());
		result = prime * result + ((applyTime == null) ? 0 : applyTime.hashCode());
		result = prime * result + ((applyUserId == null) ? 0 : applyUserId.hashCode());
		result = prime * result + ((assetsDeptName == null) ? 0 : assetsDeptName.hashCode());
		result = prime * result + ((assetsName == null) ? 0 : assetsName.hashCode());
		result = prime * result + ((billNo == null) ? 0 : billNo.hashCode());
		result = prime * result + ((currentIndex == null) ? 0 : currentIndex.hashCode());
		result = prime * result + ((externalRepairCompany == null) ? 0 : externalRepairCompany.hashCode());
		result = prime * result + ((fee == null) ? 0 : fee.hashCode());
		result = prime * result + ((remark == null) ? 0 : remark.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((tenantId == null) ? 0 : tenantId.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		RepRepairBillResponse other = (RepRepairBillResponse) obj;
		if (applyId == null) {
			if (other.applyId != null)
				return false;
		} else if (!applyId.equals(other.applyId))
			return false;
		if (applyNo == null) {
			if (other.applyNo != null)
				return false;
		} else if (!applyNo.equals(other.applyNo))
			return false;
		if (applyTime == null) {
			if (other.applyTime != null)
				return false;
		} else if (!applyTime.equals(other.applyTime))
			return false;
		if (applyUserId == null) {
			if (other.applyUserId != null)
				return false;
		} else if (!applyUserId.equals(other.applyUserId))
			return false;
		if (assetsDeptName == null) {
			if (other.assetsDeptName != null)
				return false;
		} else if (!assetsDeptName.equals(other.assetsDeptName))
			return false;
		if (assetsName == null) {
			if (other.assetsName != null)
				return false;
		} else if (!assetsName.equals(other.assetsName))
			return false;
		if (billNo == null) {
			if (other.billNo != null)
				return false;
		} else if (!billNo.equals(other.billNo))
			return false;
		if (currentIndex == null) {
			if (other.currentIndex != null)
				return false;
		} else if (!currentIndex.equals(other.currentIndex))
			return false;
		if (externalRepairCompany == null) {
			if (other.externalRepairCompany != null)
				return false;
		} else if (!externalRepairCompany.equals(other.externalRepairCompany))
			return false;
		if (fee == null) {
			if (other.fee != null)
				return false;
		} else if (!fee.equals(other.fee))
			return false;
		if (remark == null) {
			if (other.remark != null)
				return false;
		} else if (!remark.equals(other.remark))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (tenantId == null) {
			if (other.tenantId != null)
				return false;
		} else if (!tenantId.equals(other.tenantId))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RepRepairBill [tenantId=" + tenantId + ", billNo=" + billNo + ", type=" + type + ", status=" + status
				+ ", applyId=" + applyId + ", applyNo=" + applyNo + ", assetsName=" + assetsName + ", assetsDeptName="
				+ assetsDeptName + ", externalRepairCompany=" + externalRepairCompany + ", applyUserId=" + applyUserId
				+ ", applyTime=" + applyTime + ", fee=" + fee + ", remark=" + remark + ", currentIndex=" + currentIndex
				+ "]";
	}

}

