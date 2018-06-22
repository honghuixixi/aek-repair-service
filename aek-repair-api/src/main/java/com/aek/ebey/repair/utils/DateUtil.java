package com.aek.ebey.repair.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.aek.ebey.repair.request.SevenQuery;

public class DateUtil {
	/**
	 * 
	 * 得到此时减5天的时间
	 */
	public static Date getPre5DayTime() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.DAY_OF_MONTH, -5);// 让日期加1
		return calendar.getTime();
	}

	/**
	 * 获取当前时间前一条时间
	 * @return
	 */
	public static Date getPre1DayTime() {
	    Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_MONTH, -1);// 让日期加1
        return calendar.getTime();
	}
	
	/**
	 * 获取当前时间前一条时间
	 * @return
	 */
	public static Integer getSevenStatus(Date d1,Date d2) {
		long between_days = 0L;
        try {
            Calendar cal = Calendar.getInstance();
            cal.setTime(d1);
            long time1 = cal.getTimeInMillis();
            cal.setTime(d2);
            long time2 = cal.getTimeInMillis();
            between_days=(time2-time1)/(1000*3600*24);
            if(between_days>7){
            	return 2;
            }else{
            	return 1;
            }
            
        }catch (Exception e) {
            e.printStackTrace();
        }
		return null;
	}
	
	public static SevenQuery getTime(){
		SevenQuery sevenQuery=new SevenQuery();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");    
	    String firstday, lastday;    
	    Calendar  cale=Calendar.getInstance(); 
        cale = Calendar.getInstance();    
        cale.add(Calendar.MONTH, -1);    
        cale.set(Calendar.DAY_OF_MONTH, 1);    
        firstday = format.format(cale.getTime());    
        // 获取前月的最后一天    
        cale = Calendar.getInstance();    
        cale.add(Calendar.MONTH, 0);    
        cale.set(Calendar.DAY_OF_MONTH, 1);    
        lastday = format.format(cale.getTime());     
        sevenQuery.setStartDate(firstday);
        sevenQuery.setEndDate(lastday);
		return sevenQuery;
	}
	public static Date getDay(String year) {
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(year);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
}
