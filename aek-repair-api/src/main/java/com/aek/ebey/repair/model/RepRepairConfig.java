package com.aek.ebey.repair.model;

import com.aek.common.core.base.BaseModel;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 维修配置表
 * </p>
 *
 * @author cyl
 * @since 2018-01-26
 */
@TableName("rep_repair_config")
public class RepRepairConfig extends BaseModel {

    private static final long serialVersionUID = 1L;

	/**
	 * 维修工程师id
	 */
	@TableField(value="repair_id")
	private Long repairId;
	/**
	 * 维修工程师姓名
	 */
	@TableField(value="repair_name")
	private String repairName;
	/**
	 * 手机号码
	 */
	private String mobile;
	/**
	 * 所在科室id
	 */
	@TableField(value="dept_id")
	private Long deptId;
	/**
	 * 所在科室名称
	 */
	@TableField(value="dept_name")
	private String deptName;
	/**
	 * 职务ID
	 */
	@TableField(value="job_id")
	private Integer jobId;
	/**
	 * 职务名称
	 */
	@TableField(value="job_name")
	private String jobName;
	/**
	 * 所在机构id
	 */
	@TableField(value="tenant_id")
	private Long tenantId;
	/**
	 * 接单科室id
	 */
	@TableField(value="take_order_dept_id")
	private Long takeOrderDeptId;
	/**
	 * 接单科室名称
	 */
	@TableField(value="take_order_dept_name")
	private String takeOrderDeptName;
	/**
	 * 删除标志
	 */
	@TableField(value="del_flag")
	private Boolean delFlag;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Long getTakeOrderDeptId() {
		return takeOrderDeptId;
	}

	public void setTakeOrderDeptId(Long takeOrderDeptId) {
		this.takeOrderDeptId = takeOrderDeptId;
	}

	public String getTakeOrderDeptName() {
		return takeOrderDeptName;
	}

	public void setTakeOrderDeptName(String takeOrderDeptName) {
		this.takeOrderDeptName = takeOrderDeptName;
	}

	public Boolean isDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Boolean delFlag) {
		this.delFlag = delFlag;
	}

	public Long getTenantId() {
		return tenantId;
	}

	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}

}
