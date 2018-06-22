package com.aek.ebey.repair.request;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.aek.ebey.repair.model.RepRepairBillCheckFlow;
import com.aek.ebey.repair.model.RepRepairBillFile;
import com.aek.ebey.repair.model.RepRepairBillParts;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 维修单据打印详情实体类
 *	
 * @author HongHui
 * @date   2018年1月26日
 */
@ApiModel(value = "RepRepairBillPrintDetailResponse", description = "维修单据维修单打印详情数据")
public class RepRepairBillPrintDetailResponse{

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
	 * 机构名称
	 */
    @ApiModelProperty(value="机构名称")
    private String tenantName;
    
	/**
	 * 单据编号
	 */
    @ApiModelProperty(value="单据编号")
	private String billNo;
    
	/**
	 * 单据申请时间
	 */
    @ApiModelProperty(value="单据申请时间")
    private Date applyTime;
    
    /**
	 * 单据申请人姓名
	 */
    @ApiModelProperty(value="单据申请人姓名")
    private String applyUserName;
    
    /**
	 * 单据申请人所在科室
	 */
    @ApiModelProperty(value="单据申请人所在科室")
    private String applyUserDeptName;

    /**
	 * 单据类型(1=外修费用,2=配件采购)
	 */
    @ApiModelProperty(value="单据类型(1=外修费用,2=配件采购)")
	private Integer type;
    
    /**
	 * 状态(1=审批中，2=审批通过，3=审批未通过，4=已撤销)
	 */
    @ApiModelProperty(value="状态(1=审批中，2=审批通过，3=审批未通过，4=已撤销)")
	private Integer status;
    
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
   	 * 院内编码
   	 */
	@ApiModelProperty(value="院内编码")
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
   	 * 费用金额
   	 */
    @ApiModelProperty(value="费用金额")
    private BigDecimal fee;
    
    /**
     * 配件信息
     */
	@ApiModelProperty(value="配件信息")
	private List<RepRepairBillParts> billParts;
	
    /**
   	 * 外修单位
   	 */
    @ApiModelProperty(value="外修单位")
    private String externalRepairCompany;
    
    /**
   	 * 申请理由
   	 */
    @ApiModelProperty(value="申请理由")
    private String remark;
    
    /**
   	 * 审批时间
   	 */
    @ApiModelProperty(value="审批时间")
    private Date checkTime;
    
	/**
     * 附件信息
     */
	@ApiModelProperty(value="附件信息")
	private List<RepRepairBillFile> billFiles;
	
	/**
	 * 维修单据审批流程
	 */
	private List<RepRepairBillCheckFlow> billFlows;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTenantId() {
		return tenantId;
	}

	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}

	public String getTenantName() {
		return tenantName;
	}

	public void setTenantName(String tenantName) {
		this.tenantName = tenantName;
	}

	public String getBillNo() {
		return billNo;
	}

	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}

	public Date getApplyTime() {
		return applyTime;
	}

	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}

	public String getApplyUserName() {
		return applyUserName;
	}

	public void setApplyUserName(String applyUserName) {
		this.applyUserName = applyUserName;
	}

	public String getApplyUserDeptName() {
		return applyUserDeptName;
	}

	public void setApplyUserDeptName(String applyUserDeptName) {
		this.applyUserDeptName = applyUserDeptName;
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

	public BigDecimal getFee() {
		return fee;
	}

	public void setFee(BigDecimal fee) {
		this.fee = fee;
	}

	public List<RepRepairBillParts> getBillParts() {
		return billParts;
	}

	public void setBillParts(List<RepRepairBillParts> billParts) {
		this.billParts = billParts;
	}

	public String getExternalRepairCompany() {
		return externalRepairCompany;
	}

	public void setExternalRepairCompany(String externalRepairCompany) {
		this.externalRepairCompany = externalRepairCompany;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public List<RepRepairBillFile> getBillFiles() {
		return billFiles;
	}

	public void setBillFiles(List<RepRepairBillFile> billFiles) {
		this.billFiles = billFiles;
	}

	public List<RepRepairBillCheckFlow> getBillFlows() {
		return billFlows;
	}

	public void setBillFlows(List<RepRepairBillCheckFlow> billFlows) {
		this.billFlows = billFlows;
	}

	public Date getCheckTime() {
		return checkTime;
	}

	public void setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
	}
}

