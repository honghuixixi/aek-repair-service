package com.aek.ebey.repair.model;
import com.aek.common.core.base.BaseModel;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 维修配件表
 * </p>
 *
 * @author aek
 * @since 2017-06-06
 */
@ApiModel(value = "RepRepairParts", description = "维修配件信息")
@TableName("rep_repair_parts")
public class RepRepairParts extends BaseModel {

    private static final long serialVersionUID = 1L;


	/**
	 * 维修报告ID
	 */
	@ApiModelProperty(value="维修报告ID")
	@TableField(value="report_id")
	private Long reportId;
	/**
	 * 配件id
	 */
	@ApiModelProperty(value="配件id")
	@TableField(value="part_id")
	private Long partId;
	/**
	 * 配件编号
	 */
	@ApiModelProperty(value="配件编号")
	@TableField(value="part_no")
	private String partNo;
	/**
	 * 配件名称
	 */
	@ApiModelProperty(value="配件名称")
	@TableField(value="part_name")
	private String partName;
	/**
	 * 配件生产商
	 */
	@ApiModelProperty(value="配件生产商")
	@TableField(value="part_produce")
	private String partProduce;
	/**
	 * 配件规格
	 */
	@ApiModelProperty(value="配件规格")
	@TableField(value="part_spec")
	private String partSpec;
	/**
	 * 计数单位字典表
	 */
	@ApiModelProperty(value="计数单位字典表")
	@TableField(value="unit_key")
	private String unitKey;
	/**
	 * 使用数量
	 */
	@ApiModelProperty(value="使用数量")
	private Integer num;
	/**
	 * 配件单价
	 */
	@ApiModelProperty(value="配件单价")
	@TableField(value="part_price")
	private Long partPrice;
	/**
	 * 
	 */
	@TableField(value="custom_data")
	private String customData;



	public Long getReportId() {
		return reportId;
	}

	public void setReportId(Long reportId) {
		this.reportId = reportId;
	}

	public Long getPartId() {
		return partId;
	}

	public void setPartId(Long partId) {
		this.partId = partId;
	}

	public String getPartNo() {
		return partNo;
	}

	public void setPartNo(String partNo) {
		this.partNo = partNo;
	}

	public String getPartName() {
		return partName;
	}

	public void setPartName(String partName) {
		this.partName = partName;
	}

	public String getPartProduce() {
		return partProduce;
	}

	public void setPartProduce(String partProduce) {
		this.partProduce = partProduce;
	}

	public String getPartSpec() {
		return partSpec;
	}

	public void setPartSpec(String partSpec) {
		this.partSpec = partSpec;
	}

	public String getUnitKey() {
		return unitKey;
	}

	public void setUnitKey(String unitKey) {
		this.unitKey = unitKey;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Long getPartPrice() {
		return partPrice;
	}

	public void setPartPrice(Long partPrice) {
		this.partPrice = partPrice;
	}

	public String getCustomData() {
		return customData;
	}

	public void setCustomData(String customData) {
		this.customData = customData;
	}

	@Override
	public String toString() {
		return "RepRepairParts [reportId=" + reportId + ", partId=" + partId + ", partNo=" + partNo + ", partName="
				+ partName + ", partProduce=" + partProduce + ", partSpec=" + partSpec + ", unitKey=" + unitKey
				+ ", num=" + num + ", partPrice=" + partPrice + ", customData=" + customData + "]";
	}

}
