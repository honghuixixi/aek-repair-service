package com.aek.ebey.repair.model;

import com.aek.common.core.base.BaseModel;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 
 * </p>
 *
 * @author aek
 * @since 2017-08-30
 */
@ApiModel(value = "RepairDictype", description = "字典类型")
@TableName("repair_dictype")
public class RepairDictype extends BaseModel {

    private static final long serialVersionUID = 1L;

	/**
	 * 类型key
	 */
    @ApiModelProperty(value="类型key")
	@TableField(value="type_key")
	private String typeKey;
	/**
	 * 类型名称
	 */
    @ApiModelProperty(value="类型名称")
	private String name;


	public String getTypeKey() {
		return typeKey;
	}

	public void setTypeKey(String typeKey) {
		this.typeKey = typeKey;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
