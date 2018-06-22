package com.aek.ebey.repair.web.request;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.aek.ebey.repair.model.vo.RepConfigDeptVo;
import com.aek.ebey.repair.web.validator.group.Add;
import com.aek.ebey.repair.web.validator.group.Edit;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "RepairConfigRequest", description = "维修配置信息")
public class RepairConfigRequest {

	@ApiModelProperty(value="维修工程师id")
	@NotNull(groups = {Add.class,Edit.class}, message = "A_001")
	private Long repairId;
	@ApiModelProperty(value="维修工程师姓名")
	private String repairName;
	@ApiModelProperty(value="手机号码")
	private String mobile;
	@ApiModelProperty(value="所在科室id")
	private Long deptId;
	@ApiModelProperty(value="所在科室名称")
	private String deptName;
	@ApiModelProperty(value="职务ID")
	private Integer jobId;
	@ApiModelProperty(value="职务名称")
	private String jobName;
	@ApiModelProperty(value="接单科室集合")
	private List<RepConfigDeptVo> depts;
	
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
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Long getDeptId() {
		return deptId;
	}
	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public Integer getJobId() {
		return jobId;
	}
	public void setJobId(Integer jobId) {
		this.jobId = jobId;
	}
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public List<RepConfigDeptVo> getDepts() {
		return depts;
	}
	public void setDepts(List<RepConfigDeptVo> depts) {
		this.depts = depts;
	}
	
	
}
