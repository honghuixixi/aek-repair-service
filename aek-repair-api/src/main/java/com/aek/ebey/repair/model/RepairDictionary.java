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
@ApiModel(value = "RepairDictionary", description = "字典信息")
@TableName("repair_dictionary")
public class RepairDictionary extends BaseModel {

    private static final long serialVersionUID = 1L;

	/**
	 * 关联类型
	 */
    @ApiModelProperty(value="关联类型")
	@TableField(value="type_key")
	private String typeKey;
	/**
	 * 字典值
	 */
    @ApiModelProperty(value="字典值")
	@TableField(value="key_id")
	private Long keyId;
	/**
	 * 字典名称
	 */
    @ApiModelProperty(value="字典名称")
	private String name;


	public String getTypeKey() {
		return typeKey;
	}

	public void setTypeKey(String typeKey) {
		this.typeKey = typeKey;
	}


	public Long getKeyId() {
		return keyId;
	}

	public void setKeyId(Long keyId) {
		this.keyId = keyId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
