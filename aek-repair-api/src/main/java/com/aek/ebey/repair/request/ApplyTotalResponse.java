package com.aek.ebey.repair.request;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ApplyTotalResponse", description = "维修申统计")
public class ApplyTotalResponse implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 状态，1:待故障判定、2:现场解决、3:待维修、4:以维修待验收、5:验收通过、6:验收不通过;
	 */
    @ApiModelProperty(value="状态，1:待接单、2:维修中、3:待验收、4:已完成")
	private Integer status;
    
    /**
	 * 按状态统计个数
	 */
    @ApiModelProperty(value="按状态统计个数")
	private Integer total;

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		ApplyTotalResponse other = (ApplyTotalResponse) obj;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ApplyTotalResponse [status=" + status + ", total=" + total + "]";
	}
    
    

}
