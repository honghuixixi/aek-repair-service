package com.aek.ebey.repair.inter;

public interface RepairMessage {
	
	/** 现场解决 */
	public static final String REPAIREDCONTENT = "【验收提醒】维修申请已鉴定完成，状态变更为已现场解决，查看详情;";
	
	/** 待维修 */
	public static final String WAITREPAIRCONTENT = "【维修提醒】维修申请已鉴定完成，状态变更为待维修，查看详情;";
	
	/** 待故障鉴定*/
	public static final String WAITAPPRAISALCONTENT = "【鉴定提醒】新建维修申请，状态变更为待故障鉴定，查看详情;";
	
	/** 鉴定提醒*/
	public static final String WARNAPPRAISALCONTENT = "【鉴定提醒】鉴定提醒，请尽快去鉴定设备";
	
	/** 维修 提醒*/
	public static final String WARNREPAIRCONTENT = "【维修提醒】维修申请已鉴定完成，状态变更为待维修，查看详情;";
	
	/** 验收未通过*/
	public static final String UNCHECKCONTENT = "【验收未通过】验收未通过，状态变更为验收未通过，查看详情;";
	
	/** 验收通过*/
	public static final String CHECKEDCONTENT = "【已完成】验收通过，状态变更为已完成，查看详情;";
	
	
	/** 已维修待验收*/
	public static final String WAITCHECKCONTENT = "【验收提醒】设备维修完成，状态变更为已维修待验收，查看详情;";
	
	/** 验收提醒*/
	public static final String WARNCHECKCONTENT = "【验收提醒】验收提醒，请尽快去验收设备";
	
	/** 维修完成*/
	public static final String COMPLETE = "维修已完成，查看详情";
	


}
