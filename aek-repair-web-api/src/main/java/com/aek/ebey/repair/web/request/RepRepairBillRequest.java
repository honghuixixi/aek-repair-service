package com.aek.ebey.repair.web.request;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.aek.ebey.repair.model.RepRepairBillFile;
import com.aek.ebey.repair.model.RepRepairBillParts;
import com.aek.ebey.repair.web.validator.group.Add;
import com.baomidou.mybatisplus.annotations.TableField;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "RepRepairBillRequest", description = "维修单据申请Request")
public class RepRepairBillRequest {
	
	/**
	 * 维修申请单ID
	 */
    @ApiModelProperty(value="维修申请单ID")
	@NotNull(groups = { Add.class }, message = "B_001")
	private Long applyId;
    
    /**
   	 * 维修单号
   	 */
    @ApiModelProperty(value="维修单号")
    @NotNull(groups = { Add.class }, message = "B_001")
    private String applyNo;
    
    /**
	 * 单据类型(1=外修费用,2=配件采购)
	 */
    @ApiModelProperty(value="单据类型(1=外修费用,2=配件采购)")
	@TableField(value="type")
	private Integer type;
    
    /**
   	 * 维修设备名称
   	 */
    @ApiModelProperty(value="维修设备名称")
    @NotNull(groups = { Add.class }, message = "B_002")
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
    @NotNull(groups = { Add.class }, message = "B_003")
    private String externalRepairCompany;
    
    /**
   	 * 费用金额
   	 */
    @ApiModelProperty(value="费用金额")
    @NotNull(groups = { Add.class }, message = "B_004")
    private BigDecimal fee;
    
    /**
   	 * 申请理由
   	 */
    @ApiModelProperty(value="申请理由")
    private String remark;
	
    /**
     * 配件信息
     */
	@ApiModelProperty(value="配件信息")
	private List<RepRepairBillParts> billParts;
	
	/**
     * 附件信息
     */
	@ApiModelProperty(value="附件信息")
	private List<RepRepairBillFile> billFiles;

	public Long getApplyId() {
		return applyId;
	}

	public void setApplyId(Long applyId) {
		this.applyId = applyId;
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

	public List<RepRepairBillParts> getBillParts() {
		return billParts;
	}

	public void setBillParts(List<RepRepairBillParts> billParts) {
		this.billParts = billParts;
	}

	public List<RepRepairBillFile> getBillFiles() {
		return billFiles;
	}

	public void setBillFiles(List<RepRepairBillFile> billFiles) {
		this.billFiles = billFiles;
	}
	
	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
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

	@Override
	public String toString() {
		return "RepRepairBillRequest [applyId=" + applyId + ", applyNo=" + applyNo + ", assetsName=" + assetsName
				+ ", assetsDeptName=" + assetsDeptName + ", externalRepairCompany=" + externalRepairCompany + ", fee="
				+ fee + ", remark=" + remark + ", billParts=" + billParts + ", billFiles=" + billFiles + "]";
	}

}
