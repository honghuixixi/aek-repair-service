package com.aek.ebey.repair.enums;

/**
 * 维修单据状态枚举类
 *	
 * @author HongHui
 * @date   2017年12月11日
 */
public enum RepairBillStatusEnum {
	
	CHECKING(1,"审批中"),
	CHECKED(2,"审批通过"),
	UNCHECKED(3,"审批未通过"),
	CANCEL(4,"已撤销");
	
	private Integer number;
	private String desc;
	
	private RepairBillStatusEnum(Integer number, String desc) {
		this.number = number;
		this.desc = desc;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
}
