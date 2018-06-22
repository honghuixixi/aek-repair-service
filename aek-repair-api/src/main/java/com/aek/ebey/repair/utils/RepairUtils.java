package com.aek.ebey.repair.utils;

public class RepairUtils {
	public static String getUrl(Integer i){
		
		String grade="";
	    switch(i){
	    	case 9: grade="quality.menu.applyinfo";break;
	        case 8: grade="main.tre.bsgl.result";break;
	        case 7: grade="main.tre.zkgl.detail";break;
	        case 6: grade="pm.menu.doimplement";break;
	        case 5: grade="pm.menu.implementsuccess";break;
	        case 4: grade="inspection.implement.success";break;
	        case 3: grade="inspection.plan.detail";break;
	        case 2: grade="repair.audit.detail";break;
	        case 1: grade="repair.newweixiu";break;
	    }
		return grade;
		
	}
	

}
