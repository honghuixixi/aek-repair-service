package com.aek.ebey.repair.request;

import com.aek.ebey.repair.model.RepPartsRecord;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(value = "RepPartsRecordResponse", description = "配件操作记录response")
public class RepPartsRecordResponse extends RepPartsRecord{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 分类编码
	 */
    @ApiModelProperty(value="分类编码")
	private String kindCode;
	/**
	 * 分类名称
	 */
    @ApiModelProperty(value="分类名称")
	private String kindName;
	public String getKindCode() {
		return kindCode;
	}
	public void setKindCode(String kindCode) {
		this.kindCode = kindCode;
	}
	public String getKindName() {
		return kindName;
	}
	public void setKindName(String kindName) {
		this.kindName = kindName;
	}
    

}
