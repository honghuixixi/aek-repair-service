package com.aek.ebey.repair.model;

import java.math.BigDecimal;
import java.util.Date;

import com.aek.common.core.base.BaseModel;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 维修单据实体类
 *	
 * @author HongHui
 * @date   2018年1月26日
 */
@ApiModel(value = "RepRepairBill", description = "维修单据信息")
@TableName("rep_repair_bill")
public class RepRepairBill extends BaseModel {

	private static final long serialVersionUID = -5974521429622544132L;

	/**
	 * 机构ID
	 */
    @ApiModelProperty(value="机构ID")
	@TableField(value="tenant_id")
	private Long tenantId;
    
    /**
	 * 机构名称
	 */
    @ApiModelProperty(value="机构名称")
	@TableField(value="tenant_name")
    private String tenantName;
    
	/**
	 * 单据编号
	 */
    @ApiModelProperty(value="审单据编号")
	@TableField(value="bill_no")
	private String billNo;

    /**
	 * 单据类型(1=外修费用,2=配件采购)
	 */
    @ApiModelProperty(value="单据类型(1=外修费用,2=配件采购)")
	@TableField(value="type")
	private Integer type;
    
    /**
	 * 单据类型文本(1=外修费用,2=配件采购)
	 */
    @ApiModelProperty(value="单据类型文本(1=外修费用,2=配件采购)")
    @TableField(exist=false)
    private String typeText;
    
    /**
	 * 状态(1=审批中，2=审批通过，3=审批未通过，4=已撤销)
	 */
    @ApiModelProperty(value="状态(1=审批中，2=审批通过，3=审批未通过，4=已撤销)")
	@TableField(value="status")
	private Integer status;
    
    /**
	 * 状态文本(1=审批中，2=审批通过，3=审批未通过，4=已撤销)
	 */
    @ApiModelProperty(value="状态文本(1=审批中，2=审批通过，3=审批未通过，4=已撤销)")
    @TableField(exist=false)
    private String statusText;
    
    /**
	 * 维修申请单ID
	 */
    @ApiModelProperty(value="维修申请单ID")
	@TableField(value="apply_id")
	private Long applyId;
    
    /**
   	 * 维修单号
   	 */
    @ApiModelProperty(value="维修单号")
   	@TableField(value="apply_no")
    private String applyNo;
    
    /**
   	 * 维修设备名称
   	 */
    @ApiModelProperty(value="维修设备名称")
   	@TableField(value="assets_name")
    private String assetsName;
    
    /**
   	 * 设备使用科室名称
   	 */
    @ApiModelProperty(value="设备使用科室名称")
   	@TableField(value="assets_dept_name")
    private String assetsDeptName;
    
    /**
   	 * 设备规格型号
   	 */
    @ApiModelProperty(value="设备规格型号")
   	@TableField(value="assets_spec")
    private String assetsSpec;
    
    /**
   	 * 设备院内编码
   	 */
    @ApiModelProperty(value="设备院内编码")
   	@TableField(value="serial_num")
    private String serialNum;
    
    /**
   	 * 设备启用日期
   	 */
    @ApiModelProperty(value="设备启用日期")
   	@TableField(value="start_use_date")
    private Date startUseDate;
    
    /**
   	 * 维修申请日期
   	 */
    @ApiModelProperty(value="维修申请日期")
   	@TableField(value="report_repair_date")
    private Date reportRepairDate;
    
    /**
   	 * 外修单位
   	 */
    @ApiModelProperty(value="外修单位")
   	@TableField(value="external_repair_company")
    private String externalRepairCompany;
    
    /**
   	 * 申请人ID
   	 */
    @ApiModelProperty(value="申请人ID")
   	@TableField(value="apply_user_id")
    private Long applyUserId;
    
    /**
   	 * 申请人姓名
   	 */
    @ApiModelProperty(value="申请人姓名")
   	@TableField(value="apply_user_name")
    private String applyUserName;
    
    /**
   	 * 申请人所在科室
   	 */
    @ApiModelProperty(value="申请人所在科室")
   	@TableField(value="apply_user_dept_name")
    private String applyUserDeptName;
    
    /**
   	 * 申请时间
   	 */
    @ApiModelProperty(value="申请时间")
   	@TableField(value="apply_time")
    private Date applyTime;
    
    /**
   	 * 费用金额
   	 */
    @ApiModelProperty(value="费用金额")
   	@TableField(value="fee")
    private BigDecimal fee;
    
    /**
   	 * 备注信息
   	 */
    @ApiModelProperty(value="备注信息")
   	@TableField(value="remark")
    private String remark;
    
    /**
   	 * 审批流程所处序号
   	 */
    @ApiModelProperty(value="审批流程所处序号")
   	@TableField(value="current_index")
    private Integer currentIndex;
    
    /**
   	 * 审批流程总共的序号
   	 */
    @ApiModelProperty(value="审批流程总共的序号")
   	@TableField(value="total_index")
    private Integer totalIndex;

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

	public String getApplyUserName() {
		return applyUserName;
	}

	public void setApplyUserName(String applyUserName) {
		this.applyUserName = applyUserName;
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

	public String getTenantName() {
		return tenantName;
	}

	public void setTenantName(String tenantName) {
		this.tenantName = tenantName;
	}

	public String getApplyUserDeptName() {
		return applyUserDeptName;
	}

	public void setApplyUserDeptName(String applyUserDeptName) {
		this.applyUserDeptName = applyUserDeptName;
	}

	public Integer getTotalIndex() {
		return totalIndex;
	}

	public void setTotalIndex(Integer totalIndex) {
		this.totalIndex = totalIndex;
	}
	
	

/*	@Override
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
		RepRepairBill other = (RepRepairBill) obj;
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
	}*/

	public String getStatusText() {
		return statusText;
	}

	public void setStatusText(String statusText) {
		this.statusText = statusText;
	}

	public String getTypeText() {
		return typeText;
	}

	public void setTypeText(String typeText) {
		this.typeText = typeText;
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

