package com.zlt.utils;

import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;


/**
 * 日期时间工具类 <br> 提供一些常用的日期时间操作方法，所有方法都为静态，不用实例化该类即可使用。 <br> <br>
 * 下为日期格式的简单描述详情请参看java API中java.text.SimpleDateFormat <br> The following
 * pattern letters are defined (all other characters from <code>'A'</code> to
 * <code>'Z'</code> and from <code>'a'</code> to <code>'z'</code> are
 * reserved): <blockquote><table border=0 cellspacing=3 cellpadding=0>
 * <tr bgcolor="#ccccff"> <th align=left>Letter <th align=left>Date or Time
 * Component <th align=left>Presentation <th align=left>Examples <tr> <td><code>G</code>
 * <td>Era designator <td><a href="#text">Text </a> <td><code>AD</code>
 * <tr bgcolor="#eeeeff"> <td><code>y</code> <td>Year <td><a
 * href="#year">Year </a> <td><code>1996</code>;<code>96</code> <tr> <td><code>M</code>
 * <td>Month in year <td><a href="#month">Month </a> <td><code>July</code>;<code>Jul</code>;<code>07</code>
 * <tr bgcolor="#eeeeff"> <td><code>w</code> <td>Week in year <td><a
 * href="#number">Number </a> <td><code>27</code> <tr> <td><code>W</code>
 * <td>Week in month <td><a href="#number">Number </a> <td><code>2</code>
 * <tr bgcolor="#eeeeff"> <td><code>D</code> <td>Day in year <td><a
 * href="#number">Number </a> <td><code>189</code> <tr> <td><code>d</code>
 * <td>Day in month <td><a href="#number">Number </a> <td><code>10</code>
 * <tr bgcolor="#eeeeff"> <td><code>F</code> <td>Day of week in month <td><a
 * href="#number">Number </a> <td><code>2</code> <tr> <td><code>E</code>
 * <td>Day in week <td><a href="#text">Text </a> <td><code>Tuesday</code>;<code>Tue</code>
 * <tr bgcolor="#eeeeff"> <td><code>a</code> <td>Am/pm marker <td><a
 * href="#text">Text </a> <td><code>PM</code> <tr> <td><code>H</code> <td>Hour
 * in day (0-23) <td><a href="#number">Number </a> <td><code>0</code>
 * <tr bgcolor="#eeeeff"> <td><code>k</code> <td>Hour in day (1-24) <td><a
 * href="#number">Number </a> <td><code>24</code> <tr> <td><code>K</code>
 * <td>Hour in am/pm (0-11) <td><a href="#number">Number </a> <td><code>0</code>
 * <tr bgcolor="#eeeeff"> <td><code>h</code> <td>Hour in am/pm (1-12) <td><a
 * href="#number">Number </a> <td><code>12</code> <tr> <td><code>m</code>
 * <td>Minute in hour <td><a href="#number">Number </a> <td><code>30</code>
 * <tr bgcolor="#eeeeff"> <td><code>s</code> <td>Second in minute <td><a
 * href="#number">Number </a> <td><code>55</code> <tr> <td><code>S</code>
 * <td>Millisecond <td><a href="#number">Number </a> <td><code>978</code>
 * <tr bgcolor="#eeeeff"> <td><code>z</code> <td>Time zone <td><a
 * href="#timezone">General time zone </a> <td><code>Pacific Standard Time</code>;<code>PST</code>;<code>GMT-08:00</code>
 * <tr> <td><code>Z</code> <td>Time zone <td><a href="#rfc822timezone">RFC
 * 822 time zone </a> <td><code>-0800</code> </table> </blockquote> <h4>Examples</h4>
 * 
 * The following examples show how date and time patterns are interpreted in the
 * U.S. locale. The given date and time are 2001-07-04 12:08:56 local time in
 * the U.S. Pacific Time time zone. <blockquote><table border=0 cellspacing=3
 * cellpadding=0> <tr bgcolor="#ccccff"> <th align=left>Date and Time Pattern
 * <th align=left>Result <tr> <td><code>"yyyy.MM.dd G 'at' HH:mm:ss z"</code>
 * <td><code>2001.07.04 AD at 12:08:56 PDT</code> <tr bgcolor="#eeeeff"> <td><code>"EEE, MMM d, ''yy"</code>
 * <td><code>Wed, Jul 4, '01</code> <tr> <td><code>"h:mm a"</code> <td><code>12:08 PM</code>
 * <tr bgcolor="#eeeeff"> <td><code>"hh 'o''clock' a, zzzz"</code> <td><code>12 o'clock PM, Pacific Daylight Time</code>
 * <tr> <td><code>"K:mm a, z"</code> <td><code>0:08 PM, PDT</code>
 * <tr bgcolor="#eeeeff"> <td><code>"yyyyy.MMMMM.dd GGG hh:mm aaa"</code>
 * <td><code>02001.July.04 AD 12:08 PM</code> <tr> <td><code>"EEE, d MMM yyyy HH:mm:ss Z"</code>
 * <td><code>Wed, 4 Jul 2001 12:08:56 -0700</code> <tr bgcolor="#eeeeff">
 * <td><code>"yyMMddHHmmssZ"</code> <td><code>010704120856-0700</code>
 * </table> </blockquote>
 * 
 */
public class TimeUtil {
	/** 西文日期表示 */
	/** 月月日日格式 */
    public static final String MMdd = "MMdd";
    /** 年年月月格式 */
    public static final String YYMM = "yyMM";
	public static final String YYYYMM = "yyyyMM";
	public static final String YYYYMMDD = "yyyyMMdd";
	public static final String YYYY_MM = "yyyy-MM";
	public static final String YYYY_MM_DD = "yyyy-MM-dd";
	
	public static final String DD_MMM_YYYY = "dd MMM yyyy";
	public static final String XX_MMM_YYYY = "'XX' MMM yyyy";
	
	public static final String YYYY_MM_XX = "yyyy-MM-'XX'";

	public static final String YYYY_MM_DD_HM = "yyyy-MM-dd HH:mm";
	public static final String YYYY_MM_DD_HMS = "yyyy-MM-dd HH:mm:ss";

	public static final String YYYY_MM_EN = "MM yyyy";
	public static final String YYYY_MMM_DD_EN = "dd MMM yyyy";
	public static final String YYYY_MM_DD_HM_EN = "yyyy-MM-dd HH:mm";
	public static final String YYYY_MM_DD_HMS_EN = "yyyy-MM-dd HH:mm:ss";

	/** 中文格式年月日表示 */
	public static final String YYYY_MM_CN = "yyyy'年'MM'月'";
	public static final String YYYY_MM_DD_CN = "yyyy'年'MM'月'dd'日'";
	public static final String YYYY_MM_DD_HM_CN = "yyyy'年'MM'月'dd'日'HH'时'mm'分'";
	public static final String YYYY_MM_DD_HMS_CN = "yyyy'年'MM'月'dd'日'HH'时'mm'分'ss'秒'";

	private static final String DATETIME_US = "EEE MMM dd HH:mm:ss zzz yyyy";
	
	public  final static int TIMEZONE_OFFSET = TimeZone.getDefault().getOffset(0);
	
	/**
	 * 格式化输出日期，fmt是按已经设定的好格式。
	 * @param fmt 按SimpleDateFormat提供的格式输出
	 * @param tm
	 * @return 格式化后的串
	 */
	public static String formatDate(String fmt, long tm) {
		SimpleDateFormat sdf = new SimpleDateFormat(fmt, Locale.ENGLISH);
		return sdf.format(new Date(tm));
	}

	/**
	 * 按指定的格式化串格式日期，并输出日期串。
	 * @param format 格式
	 * @param date 日期
	 * @return 格式化后的串
	 */
	public static String formatDate(String format, Date date) {
		if (date == null) {
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.ENGLISH);
		return sdf.format(date);
	}

	/**
	 * 解析一个串按指定的格式，返回时间值。如果失败，返回当前时间.
	 * @param fmt 格式
	 * @param date 日期时间串 如 2001-01-01或"2001-01-01 00:05"
	 * @return
	 */
	public static Date parseDate(String fmt, String date) {
		return parseDate(fmt, date, new Date());
	}

	/**
	 * <b>按指定格式解析时间</b><p>
	 * 
	 * 解析一个串按指定的格式，返回时间值。如果失败，返回为职.
	 * 
	 * @param fmt 格式
	 * @param date 日期时间串 如 2001-01-01或"2001-01-01 00:05"
	 * @return
	 */
	public static Date parseDate(String fmt, String date, Date defDate) {
		assert date != null;
		// 为空的情况下，返回默认值
		if (date == null || date.length() < 0) {
			return defDate;
		}
	
		// 对应未知日期
		if (date.indexOf("XX")>0) {
			fmt = YYYY_MM_XX;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(fmt, Locale.ENGLISH);
		// 2013-01-01 00:00:00.123
		if (date.length() < 11) {
			date = date.replaceAll("\\.|\\/", "-");
		}
		try {
			Date dd = sdf.parse(date);
			if (fmt.equals(YYYY_MM_XX)) {
				dd.setTime(dd.getTime() + 1);
			}
			return dd;
		} catch (ParseException e) {
			if (date.indexOf('年')>0){
				return parseDate(YYYY_MM_DD_CN, date, defDate);
			}
		}
		return defDate;
	}

	/**
	 * 把给定的时间，格式化为中文表示日期串，日期串如：二〇〇二年十月五日
	 * @param t 时间对就的毫秒值
	 * @return 格式化串
	 */
	public static String formatDateYMD_CN(Date date) {
		assert date != null;
		StringBuilder b = new StringBuilder();
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(date.getTime());
		int y = c.get(Calendar.YEAR);
		int m = c.get(Calendar.MONTH);
		int d = c.get(Calendar.DATE);
		b.append(StringUtil.toNumberCN(y));
		b.append('年');
		b.append(smallNumberToCN(m + 1));
		b.append('月');
		b.append(smallNumberToCN(d));
		b.append('日');
		return b.toString();
	}
	

	/**
	 * 把给定的时间，格式化为中文表示日期串，日期串如：二〇〇二年十月五日
	 * @param t 时间对就的毫秒值
	 * @return 格式化串
	 */
	public static String formatDateYM_CN(Date date) {
		StringBuilder b = new StringBuilder();
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(date.getTime());
		int y = c.get(Calendar.YEAR);
		int m = c.get(Calendar.MONTH);
		b.append(StringUtil.toNumberCN(y));
		b.append('年');
		b.append(smallNumberToCN(m + 1));
		b.append('月');
		return b.toString();
	}

	/**
	 * 转化为100以内的值为中文串，中文表示如 10 表示为拾
	 * @param i 数字
	 * @return
	 */
	private static String smallNumberToCN(int i) {
		i = i % 100;
		StringBuilder b = new StringBuilder();
		int N = i / 10;
		if (N == 1) {
			b.append(StringUtil.DIGITS_CN[10]);
		} else if (N > 1) {
			b.append(StringUtil.DIGITS_CN[N]);
			b.append(StringUtil.DIGITS_CN[10]);
		}
		if (i % 10 != 0) {
			b.append(StringUtil.DIGITS_CN[i % 10]);
		}
		return b.toString();
	}

    /**
     * 判断该年份是不是闰年
     * @param year
     * @return
     */
    public static boolean isLeapYear(int year) {
		if ((year % 100 == 0) && (year % 400 == 0) || (year % 100 != 0)
				&& (year % 4 == 0)) {
			return true;
		}
		return false;
	}
   
    /**
	 * 取得两个时间相差的天数
	 * 
	 * @param from
	 * @param to
	 * @return
	 */
	public static int getDateDiff(Date from, Date to) {
		long t1 = from.getTime();
		long t2 = to.getTime();
		long d1 = (t1 + TIMEZONE_OFFSET) / (1000L * 60 * 60 * 24);
		long d2 = (t2 + TIMEZONE_OFFSET) / (1000L * 60 * 60 * 24);
		return (int) (d2 - d1);
	}
	
	public static int getMonthDiff(Date from, Date to) {
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(from);
		int yy1 = cal1.get(Calendar.YEAR);
		int mm1 = cal1.get(Calendar.MONTH);
		
		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(to);
		int yy2 = cal2.get(Calendar.YEAR);
		int mm2 = cal2.get(Calendar.MONTH);
		
		return 12 * (yy2-yy1) + mm2 - mm1;
	}
	
	/**
	 * 计算指定日期增加几年或减少几年对应的日期。
	 * @param date 日期函数
	 * @param n  年数
	 * @return 计算结果日期
	 */
	public static Date addYear(Date date, int n) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.YEAR, n);
		return cal.getTime();
	}
	
	public static Date addMonth(Date date, int n) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, n);
		return cal.getTime();
	}
	
	public static Date addDay(Date date, int n) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, n);
		return cal.getTime();
	}

	public static Date addWeek(Date date, int n) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.WEEK_OF_YEAR, n);
		return cal.getTime();
	}

	/**
	 * Convert an unknown object to Date object. This method is designed 
	 * ONLY for ACTION or BEAN
	 * 
	 * @param obj An unknown object, maybe Long, date, time stamp or string value.
	 * @param defltV default date value
	 * @return date value
	 */
	public static Date toDate(Object obj, Date defltV) {
		return null;
//		// 1. 如果是空的情况
//		if (obj == null) {
//			return defltV;
//		}
//		String param = null;
//		if (obj instanceof Calendar) {
//			return ((Calendar) obj).getTime();
//		}
//		if ((obj instanceof String[]) //
//				&& Array.getLength(obj) >= 1) {
//			// 如果是数组，取第一个
//			param = (String)Array.get(obj, 0);
//			
//		} else if (obj instanceof String) {
//			// 如果是串？
//			param = ((String) obj).trim();
//		} else if (obj instanceof java.util.Date) {
//			// 如果是日期，返回
//			return (Date) obj;
//		} else if (obj instanceof java.sql.Date){
//			return new Date(((java.sql.Date)obj).getTime());
//		} else if (obj instanceof java.sql.Timestamp) {
//			return new Date(((java.sql.Timestamp)obj).getTime());
//		} else if (obj instanceof Long) {
//			// 如果是长型
//			return new Date(((Long) obj).longValue());
//		} else if (obj instanceof Object[]) {
//			Object dataObj = Array.get(obj, 0);
//			param = (dataObj == null) ? null : dataObj.toString().trim();
//		} else {
//			param = obj.toString().trim();
//		}
//
//		if (HttpUtil.isBlank(param) || param.length() < 8) {
//			LOG.debug("无法解析日期["+param+"]");
//			return defltV;
//		}
//		param = param.replaceAll("\\/|\\.|_", "-");
//		SimpleDateFormat fmt = new SimpleDateFormat();
//		if (param.charAt(4) == '-') {
//			if (param.length()<=10){
//				try {
//					fmt.applyPattern(YYYY_MM_DD);
//					return fmt.parse(param);
//				} catch (Exception e) {
//					//NOP
//				}
//			} else if (param.length()>=14 && param.length()<20){
//				// 2012-01-01 01:02:03
//				fmt.applyPattern(YYYY_MM_DD_HMS);
//				try {
//					return fmt.parse(param);
//				} catch (Exception e) {
//					//NOP
//				}
//			}
//		}
//		if (param.length() > 25) {
//			fmt = new SimpleDateFormat(DATETIME_US,Locale.US);
//			try {
//				return fmt.parse(param);
//			} catch (Exception e) {
//			}
//		}
//		if (param.charAt(4) == '年') {
//			fmt.applyPattern(YYYY_MM_DD);
//			return parseDate(YYYY_MM_DD_CN, param, defltV);
//		}
//		
//		if (StringUtil.isNumeric(param)) {
//			if (param.length() == 8) {
//				return parseDate(YYYYMMDD, param, defltV);
//			}
//
//			Date d = new Date(StringUtil.toLong(param, -1));
//			return d.getTime() == -1 ? d : defltV;
//		}
//		return defltV;
//	}
//	final static String weekCn[] = {"","星期日","星期一","星期二","星期三","星期四","星期五","星期六"};
//	public static String getWeekDayCn(Date date){
//		if (date==null)
//			throw new IllegalArgumentException("日期不能这空！");
//		Calendar cal = Calendar.getInstance();
//		int dw = cal.get(Calendar.DAY_OF_WEEK);
//		return weekCn[dw];
	}
}
