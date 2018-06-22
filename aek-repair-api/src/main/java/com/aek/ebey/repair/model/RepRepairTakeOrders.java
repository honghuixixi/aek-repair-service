package com.aek.ebey.repair.model;

import java.util.Date;

import com.aek.common.core.base.BaseModel;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 接单表
 * </p>
 *
 * @author aek
 * @since 2017-08-30
 */
@ApiModel(value = "RepRepairTakeOrders", description = "维修接单")
@TableName("rep_repair_take_orders")
public class RepRepairTakeOrders extends BaseModel {

    private static final long serialVersionUID = 1L;

	/**
	 * 关联维修单id
	 */
    @ApiModelProperty(value="关联维修单id")
	@TableField(value="apply_id")
	private Long applyId;
	/**
	 * 接单人ID
	 */
    @ApiModelProperty(value="接单人ID")
	@TableField(value="take_order_id")
	private Long takeOrderId;
	/**
	 * 接单人姓名
	 */
    @ApiModelProperty(value="接单人姓名")
	@TableField(value="take_order_name")
	private String takeOrderName;
	/**
	 * 预计维修到达时间
	 */
    @ApiModelProperty(value="预计维修到达时间")
	@TableField(value="predict_reach_date")
	private Date predictReachDate;
	/**
	 * 接单时间
	 */
    @ApiModelProperty(value="接单时间")
	@TableField(value="take_order_time")
	private Date takeOrderTime=new Date();
	/**
	 * 备注
	 */
    @ApiModelProperty(value="备注")
	private String remarks;
	/**
	 * 作废标记，0：启用，1：删除
	 */
    @ApiModelProperty(value="作废标记，0：启用，1：删除")
	@TableField(value="del_flag")
	private Boolean delFlag;
    
    /**
	 * 维修人ID
	 */
	@ApiModelProperty(value="维修人ID")
	@TableField(value="repair_id")
	private Long repairId;
	/**
	 * 维修人名称
	 */
	@ApiModelProperty(value="维修人名称")
	@TableField(value="repair_name")
	private String repairName;


	public Long getApplyId() {
		return applyId;
	}

	public void setApplyId(Long applyId) {
		this.applyId = applyId;
	}

	public Long getTakeOrderId() {
		return takeOrderId;
	}

	public void setTakeOrderId(Long takeOrderId) {
		this.takeOrderId = takeOrderId;
	}

	public String getTakeOrderName() {
		return takeOrderName;
	}

	public void setTakeOrderName(String takeOrderName) {
		this.takeOrderName = takeOrderName;
	}

	public Date getPredictReachDate() {
		return predictReachDate;
	}

	public void setPredictReachDate(Date predictReachDate) {
		this.predictReachDate = predictReachDate;
	}

	public Date getTakeOrderTime() {
		return takeOrderTime;
	}

	public void setTakeOrderTime(Date takeOrderTime) {
		this.takeOrderTime = takeOrderTime;
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

}
