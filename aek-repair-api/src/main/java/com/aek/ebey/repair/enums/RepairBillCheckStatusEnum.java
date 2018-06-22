package com.aek.ebey.repair.enums;

/**
 * 维修单据审核状态枚举类
 *	
 * @author HongHui
 * @date   2017年12月11日
 */
public enum RepairBillCheckStatusEnum {
	
	WAIT_CHECK(1,"待审批"),
	CHECKED(2,"审批通过"),
	UNCHECKED(3,"审批未通过");
	
	private Integer number;
	private String desc;
	
	private RepairBillCheckStatusEnum(Integer number, String desc) {
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
