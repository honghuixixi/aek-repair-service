package com.aek.ebey.repair.request;
import java.util.Date;
import java.util.List;

import com.aek.ebey.repair.model.RepPartsRecord;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "RepRepairReportRequest", description = "维修报告单")
public class RepRepairReportRequest {
	/**
	 * 关联申请单id
	 */
	
	@ApiModelProperty(value="关联申请单id")
	private Long applyId;
	/**
	 * 关联维修类型字典表
	 */
	@ApiModelProperty(value="关联维修类型字典表")
	private String repairTypeKey;
	/**
	 * 故障现象Ids字典表
	 */
	@ApiModelProperty(value="故障现象Ids字典表")
	private String faultPhenomenonKeys;
	/**
	 * 故障原因ids字典表
	 */
	@ApiModelProperty(value="故障原因ids字典表")
	private String faultReasonKeys;
	/**
	 * 工作内容ids字典表
	 */
	@ApiModelProperty(value="工作内容ids字典表")
	private String workContentKeys;
	/**
	 * 维修结果关联字典表
	 */
	@ApiModelProperty(value="维修结果关联字典表")
	private String repairResultKey;
	/**
	 * 维修开始日期
	 */
	@ApiModelProperty(value="维修开始日期")
	private Date repairPeriodStart;
	/**
	 * 维修结束日期
	 */
	@ApiModelProperty(value="维修结束日期")
	private Date repairPeriodEnd;
	/**
	 * 配件等待开始时间
	 */
	@ApiModelProperty(value="配件等待开始时间")
	private Date partsWaitingStart;
	/**
	 * 配件等待结束时间
	 */
	@ApiModelProperty(value="配件等待结束时间")
	private Date partsWaitingEnd;
	/**
	 * 实际开始时间
	 */
	@ApiModelProperty(value="实际开始时间")
	private Date actualStart;
	/**
	 * 实际结束时间
	 */
	@ApiModelProperty(value="实际结束时间")
	private Date actualEnd;
	/**
	 * 维修费用
	 */
	@ApiModelProperty(value="维修费用")
	private Long repairCost;
	/**
	 * 材料费用
	 */
	@ApiModelProperty(value="材料费用")
	private Long partsCost;
	/**
	 * 总计
	 */
	@ApiModelProperty(value="总计")
	private Long totalCost;
	/**
	 * 维修备注
	 */
	@ApiModelProperty(value="维修备注")
	private String repairComent;
	
	@ApiModelProperty(value="关联配件")
	private List<RepPartsRecord> list;

	public Long getApplyId() {
		return applyId;
	}

	public void setApplyId(Long applyId) {
		this.applyId = applyId;
	}

	public String getRepairTypeKey() {
		return repairTypeKey;
	}

	public void setRepairTypeKey(String repairTypeKey) {
		this.repairTypeKey = repairTypeKey;
	}

	public String getFaultPhenomenonKeys() {
		return faultPhenomenonKeys;
	}

	public void setFaultPhenomenonKeys(String faultPhenomenonKeys) {
		this.faultPhenomenonKeys = faultPhenomenonKeys;
	}

	public String getFaultReasonKeys() {
		return faultReasonKeys;
	}

	public void setFaultReasonKeys(String faultReasonKeys) {
		this.faultReasonKeys = faultReasonKeys;
	}

	public String getWorkContentKeys() {
		return workContentKeys;
	}

	public void setWorkContentKeys(String workContentKeys) {
		this.workContentKeys = workContentKeys;
	}

	public String getRepairResultKey() {
		return repairResultKey;
	}

	public void setRepairResultKey(String repairResultKey) {
		this.repairResultKey = repairResultKey;
	}

	public Date getRepairPeriodStart() {
		return repairPeriodStart;
	}

	public void setRepairPeriodStart(Date repairPeriodStart) {
		this.repairPeriodStart = repairPeriodStart;
	}

	public Date getRepairPeriodEnd() {
		return repairPeriodEnd;
	}

	public void setRepairPeriodEnd(Date repairPeriodEnd) {
		this.repairPeriodEnd = repairPeriodEnd;
	}

	public Date getPartsWaitingStart() {
		return partsWaitingStart;
	}

	public void setPartsWaitingStart(Date partsWaitingStart) {
		this.partsWaitingStart = partsWaitingStart;
	}

	public Date getPartsWaitingEnd() {
		return partsWaitingEnd;
	}

	public void setPartsWaitingEnd(Date partsWaitingEnd) {
		this.partsWaitingEnd = partsWaitingEnd;
	}

	public Date getActualStart() {
		return actualStart;
	}

	public void setActualStart(Date actualStart) {
		this.actualStart = actualStart;
	}

	public Date getActualEnd() {
		return actualEnd;
	}

	public void setActualEnd(Date actualEnd) {
		this.actualEnd = actualEnd;
	}

	public Long getRepairCost() {
		return repairCost;
	}

	public void setRepairCost(Long repairCost) {
		this.repairCost = repairCost;
	}

	public Long getPartsCost() {
		return partsCost;
	}

	public void setPartsCost(Long partsCost) {
		this.partsCost = partsCost;
	}

	public Long getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(Long totalCost) {
		this.totalCost = totalCost;
	}

	public String getRepairComent() {
		return repairComent;
	}

	public void setRepairComent(String repairComent) {
		this.repairComent = repairComent;
	}

	public List<RepPartsRecord> getList() {
		return list;
	}

	public void setList(List<RepPartsRecord> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "RepRepairReportRequest [applyId=" + applyId + ", repairTypeKey=" + repairTypeKey
				+ ", faultPhenomenonKeys=" + faultPhenomenonKeys + ", faultReasonKeys=" + faultReasonKeys
				+ ", workContentKeys=" + workContentKeys + ", repairResultKey=" + repairResultKey
				+ ", repairPeriodStart=" + repairPeriodStart + ", repairPeriodEnd=" + repairPeriodEnd
				+ ", partsWaitingStart=" + partsWaitingStart + ", partsWaitingEnd=" + partsWaitingEnd + ", actualStart="
				+ actualStart + ", actualEnd=" + actualEnd + ", repairCost=" + repairCost + ", partsCost=" + partsCost
				+ ", totalCost=" + totalCost + ", repairComent=" + repairComent + ", list=" + list + "]";
	}

}
