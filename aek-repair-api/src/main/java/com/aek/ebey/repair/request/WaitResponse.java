package com.aek.ebey.repair.request;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "WaitResponse", description = "WaitResponse")
public class WaitResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 状态，1:待故障判定、2:现场解决、3:待维修、4:以维修待验收、5:验收通过、6:验收不通过;
	 */
    @ApiModelProperty(value="状态，1到8")
	private Integer status;
    
    /**
	 * 按状态统计个数
	 */
    @ApiModelProperty(value="按状态统计个数")
	private Integer total;
    
    @ApiModelProperty(value="url")
    private String url;
    
    @ApiModelProperty(value="参数")
    private String cs;

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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getCs() {
		return cs;
	}

	public void setCs(String cs) {
		this.cs = cs;
	}

	
    
    

}
