package com.aek.ebey.repair.model;

import java.math.BigDecimal;
import java.util.Date;

import com.aek.common.core.base.BaseModel;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 维修单据配件实体类
 *	
 * @author HongHui
 * @date   2018年1月26日
 */
@ApiModel(value = "RepRepairBillParts", description = "维修单据配件信息")
@TableName("rep_repair_bill_parts")
public class RepRepairBillParts extends BaseModel {

	private static final long serialVersionUID = -4621971544057285353L;

	/**
	 * 维修单据ID
	 */
    @ApiModelProperty(value="维修单据ID")
	@TableField(value="bill_id")
	private Long billId;
    
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
   	@TableField(value="unit")
    private String unit;
    
    /**
   	 * 操作数量
   	 */
    @ApiModelProperty(value="操作数量")
   	@TableField(value="num")
    private Integer num;
    
    /**
   	 * 添加时间
   	 */
    @ApiModelProperty(value="添加时间")
   	@TableField(value="create_time")
    private Date createTime;

	public Long getBillId() {
		return billId;
	}

	public void setBillId(Long billId) {
		this.billId = billId;
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

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((billId == null) ? 0 : billId.hashCode());
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + ((num == null) ? 0 : num.hashCode());
		result = prime * result + ((partName == null) ? 0 : partName.hashCode());
		result = prime * result + ((partPrice == null) ? 0 : partPrice.hashCode());
		result = prime * result + ((partProduce == null) ? 0 : partProduce.hashCode());
		result = prime * result + ((partSpec == null) ? 0 : partSpec.hashCode());
		result = prime * result + ((unit == null) ? 0 : unit.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RepRepairBillParts other = (RepRepairBillParts) obj;
		if (billId == null) {
			if (other.billId != null)
				return false;
		} else if (!billId.equals(other.billId))
			return false;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (num == null) {
			if (other.num != null)
				return false;
		} else if (!num.equals(other.num))
			return false;
		if (partName == null) {
			if (other.partName != null)
				return false;
		} else if (!partName.equals(other.partName))
			return false;
		if (partPrice == null) {
			if (other.partPrice != null)
				return false;
		} else if (!partPrice.equals(other.partPrice))
			return false;
		if (partProduce == null) {
			if (other.partProduce != null)
				return false;
		} else if (!partProduce.equals(other.partProduce))
			return false;
		if (partSpec == null) {
			if (other.partSpec != null)
				return false;
		} else if (!partSpec.equals(other.partSpec))
			return false;
		if (unit == null) {
			if (other.unit != null)
				return false;
		} else if (!unit.equals(other.unit))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RepRepairBillParts [billId=" + billId + ", partName=" + partName + ", partSpec=" + partSpec
				+ ", partProduce=" + partProduce + ", partPrice=" + partPrice + ", unit=" + unit + ", num=" + num
				+ ", createTime=" + createTime + "]";
	}
    
}

