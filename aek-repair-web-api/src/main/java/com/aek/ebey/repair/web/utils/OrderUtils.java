package com.aek.ebey.repair.web.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * 订单工具类
 *
 */
public class OrderUtils {
	/**
	 * 
	 * 生成订单号
	 */
	public static String getOrderNum() {

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");

		Date date = new Date();

		String str = simpleDateFormat.format(date);

		Random random = new Random();

		int rannum = (int) (random.nextDouble() * (999999 - 100000 + 1)) + 100000;// 获取6位随机数

		return "WX" + str + rannum;

	}
	/**
	 * 
	 * 生成分类号
	 */
	public static String getPartsNum() {

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");

		Date date = new Date();

		String str = simpleDateFormat.format(date);

		Random random = new Random();

		int rannum = (int) (random.nextDouble() * (999999 - 100000 + 1)) + 100000;// 获取6位随机数

		return "PJ" + str + rannum;

	}
	
	/**
	 * 生成维修单据编号
	 */
	public static String getBillNum() {

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");

		Date date = new Date();

		String str = simpleDateFormat.format(date);

		Random random = new Random();

		int rannum = (int) (random.nextDouble() * (9999 - 1000 + 1)) + 1000;// 获取4位随机数

		return "WXDJ" + str + rannum;

	}

}
