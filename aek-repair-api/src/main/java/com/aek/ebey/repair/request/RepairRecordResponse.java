package com.aek.ebey.repair.request;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(value = "RepairRecordResponse", description = "维修记录响应信息")
public class RepairRecordResponse implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 关联维修单id
	 */
    @ApiModelProperty(value="关联维修单id")
	private Long applyId;
    
    /**
	 * 设备id
	 */
    @ApiModelProperty(value="设备id")
	private String assetsId;
	
	/**
	 * 维修申请单号
	 */
    @ApiModelProperty(value="维修申请单号")
	private String applyNo;

    
	/**
	 * 维修方式（1，自主维修 2，外修 3，现场解决）
	 */
	@ApiModelProperty(value="维修方式（1，自主维修 2，外修 3，现场解决）")
	private Integer modeStatus;
	
	/**
	 * 报修申请时间
	 */
    @ApiModelProperty(value="报修申请时间")
	private Date reportRepairDate;
    
    /**
	 * 申请人姓名
	 */
    @ApiModelProperty(value="申请人姓名")
	private String reportRepairName;
    
    /**
	 * 维修人名称
	 */
	@ApiModelProperty(value="维修人名称")
	private String repairName;
	
	
	/**
	 * 提交报告单时间
	 */
	@ApiModelProperty(value="提交报告单时间(完修时间)")
	private Date repairDate;
	
	/**
	 * 总计
	 */
	@ApiModelProperty(value="总计(维修费用)")
	private BigDecimal totalCost;

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

	public Integer getModeStatus() {
		return modeStatus;
	}

	public void setModeStatus(Integer modeStatus) {
		this.modeStatus = modeStatus;
	}

	public Date getReportRepairDate() {
		return reportRepairDate;
	}

	public void setReportRepairDate(Date reportRepairDate) {
		this.reportRepairDate = reportRepairDate;
	}

	public String getReportRepairName() {
		return reportRepairName;
	}

	public void setReportRepairName(String reportRepairName) {
		this.reportRepairName = reportRepairName;
	}

	public String getRepairName() {
		return repairName;
	}

	public void setRepairName(String repairName) {
		this.repairName = repairName;
	}

	public Date getRepairDate() {
		return repairDate;
	}

	public void setRepairDate(Date repairDate) {
		this.repairDate = repairDate;
	}

	public BigDecimal getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(BigDecimal totalCost) {
		this.totalCost = totalCost;
	}

	public String getAssetsId() {
		return assetsId;
	}

	public void setAssetsId(String assetsId) {
		this.assetsId = assetsId;
	}
	
	
	
}
