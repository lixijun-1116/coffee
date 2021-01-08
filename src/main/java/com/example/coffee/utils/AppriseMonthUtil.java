package com.example.coffee.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AppriseMonthUtil {
	/** 时间格式(yyyy-MM) */
	public final static String DATE_PATTERN = "yyyy-MM";
	/** 时间格式(yyyy-MM-dd) */
	public final static String DATE_DAY_PATTERN = "yyyy-MM-dd";
	/** 时间格式(yyyy-MM-dd HH:mm:ss) */
	public final static String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
	/** 时间格式(yyyy-MM-dd HH:mm:ss.SSS) */
	public final static String DATE_MS_PATTERN = "yyyy-MM-dd HH:mm:ss.SSS";

	/**
	 * 方法名称: convertStringToDate<br>
	 * 描述：字符串转换时间类型(yyyy-MM-dd HH:mm:ss)<br>
	 * 修改日期：2020-10-28<br>
	 * @param str  时间字符串
	 * @return
	 */
	public static Date convertStringToDate(String str) {
		SimpleDateFormat format = new SimpleDateFormat(DATE_TIME_PATTERN);
		Date date;
		try {
			date = format.parse(str);
			return date;
		} catch (java.text.ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 方法名称: convertStringToDate<br>
	 * 描述：字符串转换时间类型<br>
	 * 修改日期：2020-10-28<br>
	 * @param str  时间字符串
	 * @param dateFormat 格式 如  "yyyy-MM-dd"
	 * @return
	 */
	public static Date convertStringToDate(String str, String dateFormat) {
		SimpleDateFormat format = new SimpleDateFormat(dateFormat);
		Date date;
		try {
			date = format.parse(str);
			return date;
		} catch (java.text.ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 方法名称: convertDateToString<br>
	 * 描述：时间类型转换字符串(yyyy-MM-dd HH:mm:ss)<br>
	 * 修改日期：2020-10-28<br>
	 * @param date  时间
	 * @return
	 */
	public static String convertDateToString(Date date){
		SimpleDateFormat format = new SimpleDateFormat(DATE_TIME_PATTERN);
		String dateString = format.format(date);
		return dateString;
	}

	/**
	 * 方法名称: convertDateToString<br>
	 * 描述：时间类型转换字符串<br>
	 * 修改日期：2020-10-28<br>
	 * @param date  时间
	 * @param dateFormat 格式 如  "yyyy-MM-dd"
	 * @return
	 */
	public static String convertDateToString(Date date,String dateFormat){
		SimpleDateFormat format = new SimpleDateFormat(dateFormat);
		String dateString = format.format(date);
		return dateString;
	}

	/**
	 * 计算月份
	 */
	public static Integer calculationMonth(String sDate) {
		return calculationMonth(sDate, DATE_PATTERN);
	}

	/**
	 * 计算月份
	 */
	public static Integer calculationMonth(Date date) {
		String sDate = convertDateToString(date,DATE_PATTERN);
		return calculationMonth(sDate, DATE_PATTERN);
	}
	
	/**
	 * 计算月份
	 */
	private static Integer calculationMonth(String sDate, String pattern) {
		int cycleMonth = 0;
        int year = 0;
        int month = 0;
        Date date = null;
		try {	  
			SimpleDateFormat sdf = new SimpleDateFormat(pattern);
			// 将字符串转日期
			date = sdf.parse(sDate);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		// 年
        year = calendar.get(Calendar.YEAR);
        // 月
        month = calendar.get(Calendar.MONTH) + 1;
        // 计算月数
        cycleMonth = (year - 1) * 12 + month;
		return cycleMonth;
	}
	
	public static String reverseFormat(Integer cycleMonth) {
		int year = cycleMonth / 12;
		int month = cycleMonth % 12;
		if (month != 0) {
			year = year + 1;
		} else {
			month = 12;
		}
		StringBuffer sb = new StringBuffer();
		sb.append(year).append("-");
		sb.append(lpad(String.valueOf(month), 2, "0"));
		return sb.toString();
	}


	/**
	 * 方法名称: dateFormat<br>
	 * 描述：转换特定的时间类型<br>
	 * 修改日期：2020-10-28<br>
	 * @param date  时间
	 * @param dateFormat 格式 如  "yyyy-MM-dd"
	 * @return
	 */
	public static Date dateFormat(Date date,String dateFormat){
		String str = convertDateToString(date, dateFormat);
		Date newDate = convertStringToDate(str, dateFormat);
		return newDate;
	}
	
	
	private static String lpad(String str, int padded_length, String pad_string) {
		StringBuffer buffer = new StringBuffer();
		for (int i = str.length(); i < padded_length; i++) {
			buffer.append(pad_string);
		}
		buffer.append(str);
		return buffer.toString();
	}
	
	public static void main(String[] args) {
		
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		//int year = calendar.get(Calendar.YEAR);
		//System.err.println("年份: "+year);
		//int month = calendar.get(Calendar.MONTH)+1;
		//System.err.println("月份: "+month);
		//int cycMonth = (year-1)*12+month;
		//System.err.println("考核月份: "+cycMonth);
		int i= 24243;
		System.err.println(reverseFormat(i));
		//System.err.println(format("2020-08-12"));
		//String date = "2019-01-01";
		System.err.println(calculationMonth("2020-08-14","yyyy-MM-dd"));
		System.err.println(calculationMonth("2020-08-14"));
		
	}

}
