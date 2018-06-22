package com.aek.ebey.repair.model;

import com.aek.common.core.base.BaseModel;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 维修单据附件实体类
 *	
 * @author HongHui
 * @date   2018年1月26日
 */
@ApiModel(value = "RepRepairBillFile", description = "维修单据附件信息")
@TableName("rep_repair_bill_file")
public class RepRepairBillFile extends BaseModel {

	private static final long serialVersionUID = -8066275037695170038L;

	/**
	 * 维修单据ID
	 */
    @ApiModelProperty(value="维修单据ID")
	@TableField(value="bill_id")
	private Long billId;
    
	/**
	 * 附件文件名称
	 */
    @ApiModelProperty(value="附件文件名称")
	@TableField(value="name")
	private String name;

    /**
	 * 文件路径地址
	 */
    @ApiModelProperty(value="文件路径地址")
	@TableField(value="url")
	private String url;

	public Long getBillId() {
		return billId;
	}

	public void setBillId(Long billId) {
		this.billId = billId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((billId == null) ? 0 : billId.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((url == null) ? 0 : url.hashCode());
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
		RepRepairBillFile other = (RepRepairBillFile) obj;
		if (billId == null) {
			if (other.billId != null)
				return false;
		} else if (!billId.equals(other.billId))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RepRepairBillFile [billId=" + billId + ", name=" + name + ", url=" + url + "]";
	}

}

