package com.aek.ebey.repair.inter;

public interface RepairApplyStatus {
	/** 待接单 */
	public static final Integer WAITTAKE = 1;
	
	/** 已接单 */
/*	public static final Integer TAKEED = 2;*/

	/** 维修中*/
	public static final Integer REPAIRING = 2;

	/** 待验收 */
	public static final Integer WAITCHECK = 3;
	/** 已完成 */
	public static final Integer COMPLETED = 4;
	

}
