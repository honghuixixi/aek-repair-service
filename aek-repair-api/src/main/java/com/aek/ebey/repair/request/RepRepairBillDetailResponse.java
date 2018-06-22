package com.aek.ebey.repair.request;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.aek.ebey.repair.model.RepRepairBillFile;
import com.aek.ebey.repair.model.RepRepairBillParts;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 维修单据详情实体类
 *	
 * @author HongHui
 * @date   2018年1月26日
 */
@ApiModel(value = "RepRepairBillDetailResponse", description = "维修单据维修单详情数据")
public class RepRepairBillDetailResponse{

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
     * 当前审核人ID
     */
    @ApiModelProperty(value="当前审核人ID")
    private Long currentCheckUserId;

    /**
	 * 单据类型(1=外修费用,2=配件采购)
	 */
    @ApiModelProperty(value="单据类型(1=外修费用,2=配件采购)")
	private Integer type;
    
    /**
     * 单据类型文本(1=外修费用,2=配件采购)
     */
    /*@ApiModelProperty(value="单据类型文本(1=外修费用,2=配件采购)")
    private String typeText;*/
    
    /**
	 * 状态(1=审批中，2=审批通过，3=审批未通过，4=已撤销)
	 */
    @ApiModelProperty(value="状态(1=审批中，2=审批通过，3=审批未通过，4=已撤销)")
	private Integer status;
    
    /**
	 * 状态文本(1=审批中，2=审批通过，3=审批未通过，4=已撤销)
	 */
    /*@ApiModelProperty(value="状态文本(1=审批中，2=审批通过，3=审批未通过，4=已撤销)")
	private String statusText;*/
    
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
   	 * 申请人ID
   	 */
    @ApiModelProperty(value="申请人ID")
    private Long applyUserId;
    
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
     * 附件信息
     */
	@ApiModelProperty(value="附件信息")
	private List<RepRepairBillFile> billFiles;
	
	/**
	 * 维修单据操作日志
	 */
	private List<RepRepairBillLogResponse> billLogs;

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

	/*public String getTypeText() {
		return typeText;
	}

	public void setTypeText(String typeText) {
		this.typeText = typeText;
	}*/

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	/*public String getStatusText() {
		return statusText;
	}

	public void setStatusText(String statusText) {
		this.statusText = statusText;
	}*/

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

	public List<RepRepairBillLogResponse> getBillLogs() {
		return billLogs;
	}

	public void setBillLogs(List<RepRepairBillLogResponse> billLogs) {
		this.billLogs = billLogs;
	}

	public String getSerialNum() {
		return serialNum;
	}

	public void setSerialNum(String serialNum) {
		this.serialNum = serialNum;
	}

	public Long getCurrentCheckUserId() {
		return currentCheckUserId;
	}

	public void setCurrentCheckUserId(Long currentCheckUserId) {
		this.currentCheckUserId = currentCheckUserId;
	}

	public Long getApplyUserId() {
		return applyUserId;
	}

	public void setApplyUserId(Long applyUserId) {
		this.applyUserId = applyUserId;
	}
	
}

