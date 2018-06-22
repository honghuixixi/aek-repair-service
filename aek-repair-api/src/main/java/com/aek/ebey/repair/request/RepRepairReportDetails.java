package com.aek.ebey.repair.request;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.aek.ebey.repair.model.RepPartsRecord;
import com.baomidou.mybatisplus.annotations.TableField;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(value = "RepRepairReportDetails", description = "维修报告单详情")
public class RepRepairReportDetails {
	
	private Long id;
	/**
	 * 关联申请单ID
	 */
	@ApiModelProperty(value="关联申请单id")
	private Long applyId;
	/**
	 * 维修方式（1，自主维修 2，外修 3，现场解决）
	 */
	@ApiModelProperty(value="维修方式（1，自主维修 2，外修 3，现场解决）")
	private Integer modeStatus;
	/**
	 * 外修单位
	 */
	@ApiModelProperty(value="外修单位")
	private String outsideCompany;
	/**
	 * 外修电话
	 */
	@ApiModelProperty(value="外修电话")
	private String outsidePhone;
	/**
	 * 附件
	 */
	@ApiModelProperty(value="附件")
	private String attachment;
	/**
	 * 故障类型(1，故障维修2，预防性维修3，计量检测性维修 4，质保期内维修 5，厂家合同维修 6，第三方合同维修 7，临时叫修)
	 */
	@ApiModelProperty(value="故障类型(1，故障维修2，预防性维修3，计量检测性维修 4，质保期内维修 5，厂家合同维修 6，第三方合同维修 7，临时叫修)")
	private Integer faultType;
	/**
	 * 故障现象(自定义单独拼接成串,格式1，2，3，电源问题)
	 */
	@ApiModelProperty(value="故障现象(自定义单独拼接成串,格式1，2，3，电源问题)")
	private String faultPhenomenon;
	/**
	 * 故障原因(自定义单独拼接成串,格式1，2，3，电源问题)
	 */
	@ApiModelProperty(value="故障原因(自定义单独拼接成串,格式1，2，3，电源问题)")
	private String faultReason;
	/**
	 * 工作内容(自定义单独拼接成串,格式1，2，3，电源问题)
	 */
	@ApiModelProperty(value="工作内容(自定义单独拼接成串,格式1，2，3，电源问题)")
	private String workContent;
	
	/**
	 * 故障现象(自定义单独拼接成串,格式1，2，3，电源问题)
	 */
	@ApiModelProperty(value="故障现象(自定义单独拼接成串,格式1，2，3，电源问题)")
	private List<String> faultPhenomenonList;
	
	/**
	 * 故障原因(自定义单独拼接成串,格式1，2，3，电源问题)
	 */
	@ApiModelProperty(value="故障原因(自定义单独拼接成串,格式1，2，3，电源问题)")
	private List<String> faultReasonList;
	
	/**
	 * 工作内容(自定义单独拼接成串,格式1，2，3，电源问题)
	 */
	@ApiModelProperty(value="工作内容(自定义单独拼接成串,格式1，2，3，电源问题)")
	private List<String> workContentList;
	
	/**
	 * 维修开始日期
	 */
	@ApiModelProperty(value="维修开始日期")
	private Date repairStartDate;
	/**
	 * 维修结束日期
	 */
	@ApiModelProperty(value="维修结束日期")
	private Date repairEndDate;
	/**
	 * 实际开始时间
	 */
	@ApiModelProperty(value="实际开始时间")
	private Date actualStartDate;
	/**
	 * 实际结束时间
	 */
	@ApiModelProperty(value="实际结束时间")
	private Date actualEndDate;
	
	/**
	 * 维修工时
	 */
	@ApiModelProperty(value="维修工时")
	private Float repairHours;
	
	/**
	 * 工程师姓名
	 */
	@ApiModelProperty(value="工程师姓名")
	private String engineerName;
	
	/**
	 * 工程师工号
	 */
	@ApiModelProperty(value="工程师工号")
	private String engineerNum;
	
	
	/**
	 * 叫修时间
	 */
	@ApiModelProperty(value="叫修时间")
	private Date callRepairDate;
	
	/**
	 * 到达时间
	 */
	@ApiModelProperty(value="到达时间")
	private Date arrivalDate;
	
	/**
	 * 离开时间
	 */
	@ApiModelProperty(value="离开时间")
	private Date leaveDate;
	/**
	 * 维修结果(1,正常工作 2，基本功能正常 3，需进一步修理 4，需外送修理 5，无法修复 6，其他)
	 */
	@ApiModelProperty(value="维修结果(1,正常工作 2，基本功能正常 3，需进一步修理 4，需外送修理 5，无法修复 6，其他)")
	private Integer repairResult;
	/**
	 * 维修费用
	 */
	@ApiModelProperty(value="维修费用")
	private BigDecimal repairCost;
	/**
	 * 材料费用
	 */
	@ApiModelProperty(value=" 材料费用")
	private BigDecimal partsCost;
	/**
	 * 总计
	 */
	@ApiModelProperty(value="总计")
	private BigDecimal totalCost;
	/**
	 * 发票号码（用，分割）
	 */
	@ApiModelProperty(value="发票号码（用，分割）")
	private String repairInvoice;
	/**
	 * 维修备注
	 */
	@ApiModelProperty(value="维修备注")
	private String remarks;
	/**
	 * 维修人ID
	 */
	@ApiModelProperty(value="维修人ID")
	private Long repairId;
	/**
	 * 维修人名称
	 */
	@ApiModelProperty(value="维修人名称")
	private String repairName;
	/**
	 * 提交报告单时间
	 */
	@ApiModelProperty(value="提交报告单时间")
	private Date repairDate=new Date();
	
	@ApiModelProperty(value="关联配件")
	private List<RepPartsRecord> list;
	
	/**
	 * 是否可以维修
	 */
	@ApiModelProperty(value="是否可以维修")
	private Boolean flag;
	
	/**
	 * 维修状态（1，送修  2，现场维修）
	 */
    @ApiModelProperty(value="维修状态（1，送修  2，现场维修）")
	private Integer reportStatus;
	
	 /**
   	 *送修人
   	 */
    @ApiModelProperty(value="送修人")
   	private String sendPerson;
    
    /**
   	 *送修电话
   	 */
    @ApiModelProperty(value="送修电话")
   	private String sendPhone;
    
    /**
   	 * 附件
   	 */
    @ApiModelProperty(value="附件")
   	private String reportFile;
    
    /**
   	 *故障代码
   	 */
    @ApiModelProperty(value="故障代码")
   	private String troubleCode;
    

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getApplyId() {
		return applyId;
	}

	public void setApplyId(Long applyId) {
		this.applyId = applyId;
	}

	public Integer getModeStatus() {
		return modeStatus;
	}

	public void setModeStatus(Integer modeStatus) {
		this.modeStatus = modeStatus;
	}

	public String getOutsideCompany() {
		return outsideCompany;
	}

	public void setOutsideCompany(String outsideCompany) {
		this.outsideCompany = outsideCompany;
	}

	public String getOutsidePhone() {
		return outsidePhone;
	}

	public void setOutsidePhone(String outsidePhone) {
		this.outsidePhone = outsidePhone;
	}

	public String getAttachment() {
		return attachment;
	}

	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}

	public Integer getFaultType() {
		return faultType;
	}

	public void setFaultType(Integer faultType) {
		this.faultType = faultType;
	}

	public String getFaultPhenomenon() {
		return faultPhenomenon;
	}

	public void setFaultPhenomenon(String faultPhenomenon) {
		this.faultPhenomenon = faultPhenomenon;
	}

	public String getFaultReason() {
		return faultReason;
	}

	public void setFaultReason(String faultReason) {
		this.faultReason = faultReason;
	}

	public String getWorkContent() {
		return workContent;
	}

	public void setWorkContent(String workContent) {
		this.workContent = workContent;
	}

	public List<String> getFaultPhenomenonList() {
		return faultPhenomenonList;
	}

	public void setFaultPhenomenonList(List<String> faultPhenomenonList) {
		this.faultPhenomenonList = faultPhenomenonList;
	}

	public List<String> getFaultReasonList() {
		return faultReasonList;
	}

	public void setFaultReasonList(List<String> faultReasonList) {
		this.faultReasonList = faultReasonList;
	}

	public List<String> getWorkContentList() {
		return workContentList;
	}

	public void setWorkContentList(List<String> workContentList) {
		this.workContentList = workContentList;
	}

	public Date getRepairStartDate() {
		return repairStartDate;
	}

	public void setRepairStartDate(Date repairStartDate) {
		this.repairStartDate = repairStartDate;
	}

	public Date getRepairEndDate() {
		return repairEndDate;
	}

	public void setRepairEndDate(Date repairEndDate) {
		this.repairEndDate = repairEndDate;
	}

	public Date getActualStartDate() {
		return actualStartDate;
	}

	public void setActualStartDate(Date actualStartDate) {
		this.actualStartDate = actualStartDate;
	}

	public Date getActualEndDate() {
		return actualEndDate;
	}

	public void setActualEndDate(Date actualEndDate) {
		this.actualEndDate = actualEndDate;
	}

	public Integer getRepairResult() {
		return repairResult;
	}

	public void setRepairResult(Integer repairResult) {
		this.repairResult = repairResult;
	}

	public BigDecimal getRepairCost() {
		return repairCost;
	}

	public void setRepairCost(BigDecimal repairCost) {
		this.repairCost = repairCost;
	}

	public BigDecimal getPartsCost() {
		return partsCost;
	}

	public void setPartsCost(BigDecimal partsCost) {
		this.partsCost = partsCost;
	}

	public BigDecimal getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(BigDecimal totalCost) {
		this.totalCost = totalCost;
	}

	public String getRepairInvoice() {
		return repairInvoice;
	}

	public void setRepairInvoice(String repairInvoice) {
		this.repairInvoice = repairInvoice;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Long getRepairId() {
		return repairId;
	}

	public void setRepairId(Long repairId) {
		this.repairId = repairId;
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

	public List<RepPartsRecord> getList() {
		return list;
	}

	public void setList(List<RepPartsRecord> list) {
		this.list = list;
	}

	public Float getRepairHours() {
		return repairHours;
	}

	public void setRepairHours(Float repairHours) {
		this.repairHours = repairHours;
	}

	public Date getCallRepairDate() {
		return callRepairDate;
	}

	public void setCallRepairDate(Date callRepairDate) {
		this.callRepairDate = callRepairDate;
	}

	public Date getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public Date getLeaveDate() {
		return leaveDate;
	}

	public void setLeaveDate(Date leaveDate) {
		this.leaveDate = leaveDate;
	}

	public String getEngineerName() {
		return engineerName;
	}

	public void setEngineerName(String engineerName) {
		this.engineerName = engineerName;
	}

	public String getEngineerNum() {
		return engineerNum;
	}

	public void setEngineerNum(String engineerNum) {
		this.engineerNum = engineerNum;
	}

	public Boolean getFlag() {
		return flag;
	}

	public void setFlag(Boolean flag) {
		this.flag = flag;
	}

	public Integer getReportStatus() {
		return reportStatus;
	}

	public void setReportStatus(Integer reportStatus) {
		this.reportStatus = reportStatus;
	}

	public String getSendPerson() {
		return sendPerson;
	}

	public void setSendPerson(String sendPerson) {
		this.sendPerson = sendPerson;
	}

	public String getSendPhone() {
		return sendPhone;
	}

	public void setSendPhone(String sendPhone) {
		this.sendPhone = sendPhone;
	}

	public String getReportFile() {
		return reportFile;
	}

	public void setReportFile(String reportFile) {
		this.reportFile = reportFile;
	}

	public String getTroubleCode() {
		return troubleCode;
	}

	public void setTroubleCode(String troubleCode) {
		this.troubleCode = troubleCode;
	}
	

}
