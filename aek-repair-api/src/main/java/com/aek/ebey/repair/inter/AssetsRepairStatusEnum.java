package com.aek.ebey.repair.inter;

/**
 *  设备维修状态枚举类
 *	
 * @author HongHui
 * @date   2017年11月3日
 */
public enum AssetsRepairStatusEnum {

	NORMAL(1,"正常"),
	REPAIRING(2,"维修中");
	
	private Integer number;
	private String desc;
	
	private AssetsRepairStatusEnum(Integer number, String desc) {
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
