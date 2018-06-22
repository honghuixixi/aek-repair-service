package com.aek.ebey.repair.request;

import java.util.Date;

public class SevenDataResponse {
	/**
	 * 机构ID
	 */
	private Long tenantId;
	/**
	 * 统计月份（如：2018-04）
	 */
	private String countMonth;
	/**
	 * 7天完修率（百分比）
	 */
	private Double servenCompleteRate=100D;
	/**
	 * 申请单总数
	 */
	private Long applyTotalNum=0L;
	/**
	 * 7天完修总数
	 */
	private Long servenCompleteTotalNum=0L;
	/**
	 * 统计时间
	 */
	private Date countTime;
	/**
	 * 更新时间
	 */
	private Date updateTime;
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
	public Double getServenCompleteRate() {
		return servenCompleteRate;
	}
	public void setServenCompleteRate(Double servenCompleteRate) {
		this.servenCompleteRate = servenCompleteRate;
	}
	public Long getApplyTotalNum() {
		return applyTotalNum;
	}
	public void setApplyTotalNum(Long applyTotalNum) {
		this.applyTotalNum = applyTotalNum;
	}
	public Long getServenCompleteTotalNum() {
		return servenCompleteTotalNum;
	}
	public void setServenCompleteTotalNum(Long servenCompleteTotalNum) {
		this.servenCompleteTotalNum = servenCompleteTotalNum;
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
