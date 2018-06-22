package com.aek.ebey.repair.request;

import java.util.Date;

import com.aek.ebey.repair.model.RepRepairApply;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(value = "ApplyResponse", description = "维修申请响应信息")
public class ApplyResponse extends RepRepairApply{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 预计维修到达时间
	 */
	 @ApiModelProperty(value="预计到达科室")
	private Date predictReachDate;
	 /**
	 * 报修申请时间
	*/
	@ApiModelProperty(value="报修申请时间")
	private String reportRepairDateStr;
	 
	 

	public String getReportRepairDateStr() {
		return reportRepairDateStr;
	}

	public void setReportRepairDateStr(String reportRepairDateStr) {
		this.reportRepairDateStr = reportRepairDateStr;
	}

	public Date getPredictReachDate() {
		return predictReachDate;
	}

	public void setPredictReachDate(Date predictReachDate) {
		this.predictReachDate = predictReachDate;
	}
	 
	 

}
