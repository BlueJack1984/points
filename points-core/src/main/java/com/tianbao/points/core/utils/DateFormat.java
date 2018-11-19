package com.tianbao.points.core.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateFormat {

	/**
	 * 字符串转日期
	 * 
	 * @param dateStr
	 * @param formatStr
	 * @return
	 */
	public static Date StringToDate(String dateStr, String formatStr) {
		SimpleDateFormat dd = new SimpleDateFormat(formatStr);
		Date date = null;
		try {
			date = dd.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return date;
	}

	public static void main(String[] args) {
		for (int i = -30; i <= 0; i++) {
			System.out.println(DateFormat.get30day(i));
		}
	}
	public static String get30day(int num){
	    long time = System.currentTimeMillis() + (1000L * 60 * 60 * 24 * num);
	    String pattern = "yyyy-MM-dd";
	    Date date = new Date();
	    if (time > 0) {
	        date.setTime(time);
	    }
	    SimpleDateFormat format = new SimpleDateFormat(pattern);
	    return format.format(date);
	}

	/**
	 * 日期转字符串
	 * 
	 * @param date
	 * @param formatStr
	 * @return
	 */
	public static String DateToString(Date date, String formatStr) {
		SimpleDateFormat dd = new SimpleDateFormat(formatStr);
		String currDate = dd.format(date);
		return currDate;
	}

	/**
	 * 获取当月第一天
	 * 
	 * @param date
	 * @param formatStr
	 * @return
	 */
	public static String DateOfMonthFirst() {
		SimpleDateFormat monthformat = new SimpleDateFormat("yyyy-MM-dd");
		// 获取当月第一天：
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, 0);
		c.set(Calendar.DAY_OF_MONTH, 1);// 设置为1号,当前日期既为本月第一天
		String first = monthformat.format(c.getTime());
		return first + " 00:00:00";
	}

	/**
	 * 获取前月的第一天
	 * 
	 * @param date
	 * @param formatStr
	 * @return
	 */
	public static String DateOfLastMonthFirst() {
		SimpleDateFormat monthformat = new SimpleDateFormat("yyyy-MM-dd");
		// 获取前月的第一天
		Calendar cal_1 = Calendar.getInstance();// 获取当前日期
		cal_1.add(Calendar.MONTH, -1);
		cal_1.set(Calendar.DAY_OF_MONTH, 1);// 设置为1号,当前日期既为本月第一天
		String format2 = monthformat.format(cal_1.getTime());
		return format2 + " 00:00:00";
	}

	/**
	 * 获取当月最后一天
	 * 
	 * @param date
	 * @param formatStr
	 * @return
	 */
	public static String DateOfMonthEnd() {
		SimpleDateFormat monthformat = new SimpleDateFormat("yyyy-MM-dd");
		// 获取当月最后一天
		Calendar ca = Calendar.getInstance();
		ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));
		String last = monthformat.format(ca.getTime());
		return last + " 23:59:59";
	}

	/**
	 * 获取前月的最后一天
	 * 
	 * @param date
	 * @param formatStr
	 * @return
	 */
	public static String DateOfLastMonthEnd() {
		SimpleDateFormat monthformat = new SimpleDateFormat("yyyy-MM-dd");
		// 获取前月的最后一天
		Calendar cale = Calendar.getInstance();
		cale.set(Calendar.DAY_OF_MONTH, 0);// 设置为1号,当前日期既为本月第一天
		String format3 = monthformat.format(cale.getTime());
		return format3 + " 23:59:59";
	}

	public static Date beginTimeFormat(Date beginTime) {
		String begin = DateFormat.DateToString(beginTime, "yyyy-MM-dd");
		begin += " 00:00";
		return DateFormat.StringToDate(begin, "yyyy-MM-dd HH:mm");
	}

	public static Date endTimeFormat(Date endTime) {
		String end = DateFormat.DateToString(endTime, "yyyy-MM-dd");
		end += " 23:59";
		return DateFormat.StringToDate(end, "yyyy-MM-dd HH:mm");
	}

	/**
	 * 查询未来第3天日期
	 * 
	 * @return
	 */
	public static Date DateOf3Day() {
		SimpleDateFormat monthformat = new SimpleDateFormat("yyyy-MM-dd");
		// 获取当月最后一天
		Calendar ca = Calendar.getInstance();
		ca.add(Calendar.DAY_OF_MONTH, 1);
		String last = monthformat.format(ca.getTime());
		Date stringToDate = StringToDate(last + " 23:59:59", "yyyy-MM-dd HH:mm:ss");
		return stringToDate;
	}

	/**
	 * 查询未来第7天日期
	 * 
	 * @return
	 */
	public static Date DateOfDay1(Date time, int day) {
		SimpleDateFormat monthformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// 获取当月最后一天
		Calendar ca = Calendar.getInstance();
		ca.setTime(time);
		ca.add(Calendar.DAY_OF_MONTH, day);
		String last = monthformat.format(ca.getTime());
		Date stringToDate = StringToDate(last, "yyyy-MM-dd HH:mm:ss");
		return stringToDate;
	}

	/**
	 * 比较两个日期的大小
	 * 
	 * @return
	 */
	public static int compare_date(Date dt1, Date dt2) {
		try {
			if (dt1.getTime() > dt2.getTime()) {
				return 1;
			} else if (dt1.getTime() < dt2.getTime()) {
				return -1;
			} else {
				return 0;
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return 0;
	}

	/**
	 * 查询未来第7天日期
	 * 
	 * @return
	 */
	public static Date DateOf7Day() {
		SimpleDateFormat monthformat = new SimpleDateFormat("yyyy-MM-dd");
		// 获取当月最后一天
		Calendar ca = Calendar.getInstance();
		ca.add(Calendar.DAY_OF_MONTH, 7);
		String last = monthformat.format(ca.getTime());
		Date stringToDate = StringToDate(last + " 23:59:59", "yyyy-MM-dd HH:mm:ss");
		return stringToDate;
	}

	public static Date mhkDate(int month) {
		Date date = new Date();// 当前日期
		Calendar calendar = Calendar.getInstance();// 日历对象
		calendar.setTime(date);// 设置当前日期
		calendar.add(Calendar.MONTH, month);// 月份减一
		return calendar.getTime();
	}

	// 按天计息 获取未来几天
	public static Date timeDate(int time) {
		Calendar c = Calendar.getInstance();
		// 当前的day_of_month加一就是明天时间
		c.add(Calendar.DAY_OF_MONTH, time);
		return c.getTime();
	}
}
