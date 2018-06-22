package com.aek.ebey.repair.enums;

/**
 * 维修消息类型
 *	
 * @author HongHui
 * @date   2017年12月11日
 */
public enum WeiXinRepairMessageTypeEnum {
	
	TAKE_ORDER(1,"接单"),
	REPAIR(2,"维修"),
	CHECK(3,"验收");
	
	private Integer type;
	private String name;
	
	private WeiXinRepairMessageTypeEnum(Integer type, String name) {
		this.type = type;
		this.name = name;
	}
	
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
