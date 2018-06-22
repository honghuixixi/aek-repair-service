package com.aek.ebey.repair.model.vo;

import java.util.Date;

/**
 * 维修设备月份完修数与费用统计表
 *
 * @author Honghui
 * @since 2018-04-16
 */
public class RepairDataMonthVo{


	/**
	 * 主键ID
	 */
	private Long id;
	/**
	 * 机构ID
	 */
	private Long tenantId;
	/**
	 * 月份（如：2018-04）
	 */
	private String countMonth;
	/**
	 * 完修总数
	 */
	private Long repairCompleteTotalNum;
	/**
	 * 完修费用
	 */
	private Double repairComplateTotalCapital;
	/**
	 * 统计时间
	 */
	private Date countTime;
	/**
	 * 更新时间
	 */
	private Date updateTime;


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

	public String getCountMonth() {
		return countMonth;
	}

	public void setCountMonth(String countMonth) {
		this.countMonth = countMonth;
	}

	public Long getRepairCompleteTotalNum() {
		return repairCompleteTotalNum;
	}

	public void setRepairCompleteTotalNum(Long repairCompleteTotalNum) {
		this.repairCompleteTotalNum = repairCompleteTotalNum;
	}

	public Double getRepairComplateTotalCapital() {
		return repairComplateTotalCapital;
	}

	public void setRepairComplateTotalCapital(Double repairComplateTotalCapital) {
		this.repairComplateTotalCapital = repairComplateTotalCapital;
	}

	public Date getCountTime() {
		return countTime;
	}

	public void setCountTime(Date countTime) {
		this.countTime = countTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

}
