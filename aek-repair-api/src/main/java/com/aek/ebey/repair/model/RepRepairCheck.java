package com.aek.ebey.repair.model;

import java.util.Date;

import com.aek.common.core.base.BaseModel;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 验收详情表
 * </p>
 *
 * @author aek
 * @since 2017-08-30
 */
@ApiModel(value = "RepRepairCheck", description = "验收详情")
@TableName("rep_repair_check")
public class RepRepairCheck extends BaseModel {

    private static final long serialVersionUID = 1L;

	/**
	 * 关联申请单id
	 */
    @ApiModelProperty(value="关联申请单id")
	@TableField(value="apply_id")
	private Long applyId;
	/**
	 * 验收人ID
	 */
    @ApiModelProperty(value="验收人ID")
	@TableField(value="repair_check_id")
	private Long repairCheckId;
	/**
	 * 验收人姓名
	 */
    @ApiModelProperty(value="验收人姓名")
	@TableField(value="repair_check_name")
	private String repairCheckName;
	/**
	 * 验收时间
	 */
    @ApiModelProperty(value="验收时间")
	@TableField(value="repair_check_time")
	private Date repairCheckTime=new Date();
	/**
	 * 维修态度
	 */
    @ApiModelProperty(value="维修态度")
	@TableField(value="repair_attitude")
	private String repairAttitude;
	/**
	 * 响应速度
	 */
    @ApiModelProperty(value="响应速度")
	@TableField(value="response_speed")
	private String responseSpeed;
	/**
	 * 维修质量
	 */
    @ApiModelProperty(value="维修质量")
	@TableField(value="repair_quality")
	private String repairQuality;
	/**
	 * 评价备注
	 */
    @ApiModelProperty(value="评价备注")
	private String remarks;
	/**
	 * 作废标记，0：启用，1：删除
	 */
    @ApiModelProperty(value="作废标记，0：启用，1：删除")
	@TableField(value="del_flag")
	private Boolean delFlag;



	public Long getApplyId() {
		return applyId;
	}

	public void setApplyId(Long applyId) {
		this.applyId = applyId;
	}

	public Long getRepairCheckId() {
		return repairCheckId;
	}

	public void setRepairCheckId(Long repairCheckId) {
		this.repairCheckId = repairCheckId;
	}

	public String getRepairCheckName() {
		return repairCheckName;
	}

	public void setRepairCheckName(String repairCheckName) {
		this.repairCheckName = repairCheckName;
	}

	public Date getRepairCheckTime() {
		return repairCheckTime;
	}

	public void setRepairCheckTime(Date repairCheckTime) {
		this.repairCheckTime = repairCheckTime;
	}

	public String getRepairAttitude() {
		return repairAttitude;
	}

	public void setRepairAttitude(String repairAttitude) {
		this.repairAttitude = repairAttitude;
	}

	public String getResponseSpeed() {
		return responseSpeed;
	}

	public void setResponseSpeed(String responseSpeed) {
		this.responseSpeed = responseSpeed;
	}

	public String getRepairQuality() {
		return repairQuality;
	}

	public void setRepairQuality(String repairQuality) {
		this.repairQuality = repairQuality;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Boolean isDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Boolean delFlag) {
		this.delFlag = delFlag;
	}

}
