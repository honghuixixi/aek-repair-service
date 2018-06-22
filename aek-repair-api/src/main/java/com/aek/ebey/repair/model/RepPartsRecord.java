package com.aek.ebey.repair.model;

import java.math.BigDecimal;
import java.util.Date;

import com.aek.common.core.base.BaseModel;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 配件操作记录表
 * </p>
 *
 * @author aek
 * @since 2017-08-30
 */
@TableName("rep_parts_record")
@ApiModel(value = "RepPartsRecord", description = "配件操作记录信息")
public class RepPartsRecord extends BaseModel {

    private static final long serialVersionUID = 1L;
	/**
	 * 维修报告ID
	 */
    @ApiModelProperty(value="维修报告ID")
	@TableField(value="report_id")
	private Long reportId;
	/**
	 * 机构id
	 */
    @ApiModelProperty(value="机构ID")
	@TableField(value="tenant_id")
	private Long tenantId;
	
	/**
	 * 配件名称
	 */
    @ApiModelProperty(value="配件名称")
	@TableField(value="part_name")
	private String partName;
	/**
	 * 规格型号
	 */
    @ApiModelProperty(value="规格型号")
	@TableField(value="part_spec")
	private String partSpec;
	/**
	 * 配件生产商
	 */
    @ApiModelProperty(value="配件生产商")
	@TableField(value="part_produce")
	private String partProduce;
	/**
	 * 配件单价
	 */
    @ApiModelProperty(value="配件单价")
	@TableField(value="part_price")
	private BigDecimal partPrice;
	/**
	 * 计数单位
	 */
    @ApiModelProperty(value="计数单位")
	private String unit;
	
	/**
	 * 计数单位名称
	 */
    @ApiModelProperty(value="计数单位名称")
	@TableField(exist=false)
	private String unitName;
	/**
	 * 操作数量
	 */
    @ApiModelProperty(value="操作数量")
	private Integer num;
	/**
	 * 操作类型（1领用 2 购买）
	 */
    @ApiModelProperty(value="操作类型（1领用 2 购买）")
	private Integer status;
	/**
	 * 操作时间
	 */
    @ApiModelProperty(value="操作时间")
	@TableField(value="operation_time")
	private Date operationTime=new Date();
	/**
	 * 作废标记，0：启用，1：删除
	 */
	@TableField(value="del_flag")
	private Boolean delFlag;


	public Long getReportId() {
		return reportId;
	}

	public void setReportId(Long reportId) {
		this.reportId = reportId;
	}

	public Long getTenantId() {
		return tenantId;
	}

	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}


	public String getPartName() {
		return partName;
	}

	public void setPartName(String partName) {
		this.partName = partName;
	}

	public String getPartSpec() {
		return partSpec;
	}

	public void setPartSpec(String partSpec) {
		this.partSpec = partSpec;
	}

	public String getPartProduce() {
		return partProduce;
	}

	public void setPartProduce(String partProduce) {
		this.partProduce = partProduce;
	}

	public BigDecimal getPartPrice() {
		return partPrice;
	}

	public void setPartPrice(BigDecimal partPrice) {
		this.partPrice = partPrice;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getOperationTime() {
		return operationTime;
	}

	public void setOperationTime(Date operationTime) {
		this.operationTime = operationTime;
	}

	public Boolean isDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Boolean delFlag) {
		this.delFlag = delFlag;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

}
