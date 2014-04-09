package org.j2eeframework.commons.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.time.DateUtils;

/**
 * 
 * 关于时间日期的工具类 DateFormatUtils类的使用 DateUtils类的使用
 * 
 */
public class DateUtil {
	/**
	 * ISO8601日期时间格式，包括时分秒（yyyy-MM-dd HH:mm:ss）
	 */
	public static final String ISO_DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";//
	/**
	 * ISO8601日期格式，只有年月日（yyyy-MM-dd）
	 */
	public static final String ISO_DATE_FORMAT = "yyyy-MM-dd";//

	/**
	 * 得到日期字符串 pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"等
	 * <p>
	 * 如果没有指定则默认格式（yyyy-MM-dd）查看{@link DateUtil.ISO_DATE_FORMAT}
	 * 
	 * @param date
	 *            日期
	 * @param pattern
	 *            日期格式串
	 * @return
	 * @author william
	 */
	public static String formatDateByPattern(Date date, String... pattern) {
		String formatDate = null;
		if (pattern != null && pattern.length > 0) {
			formatDate = DateFormatUtils.format(date, pattern[0]);
		} else {
			formatDate = DateFormatUtils.format(date, ISO_DATE_FORMAT);
		}
		return formatDate;
	}

	/**
	 * 得到日期的日期字符串 格式（{@link DateUtil.ISO_DATE_FORMAT}）
	 * 
	 * @param date
	 * @return
	 * @author william
	 */
	public static String formatDate(Date date) {
		return formatDateByPattern(date, ISO_DATE_FORMAT);
	}

	/**
	 * 得到日期的日期时间字符串 格式（{@link DateUtil.ISO_DATE_TIME_FORMAT}）
	 * 
	 * @param date
	 * @return
	 * @author william
	 */
	public static String formatDateTime(Date date) {
		return formatDateByPattern(date, ISO_DATE_TIME_FORMAT);
	}

	/**
	 * 得到日期的时间字符串 格式（"HH:mm:ss"）
	 * 
	 * @param date
	 * @return
	 * @author william
	 */
	public static String formatTime(Date date) {
		return formatDateByPattern(date, "HH:mm:ss");
	}

	/**
	 * 得到日期的星期字符串格式（E）星期几
	 * 
	 * @return
	 * @author william
	 */
	public static String getWeek(Date date) {
		return formatDateByPattern(date, "E");
	}

	/**
	 * 根据日期型字符串转化为日期 类({@link java.util.Date})<br>
	 * 默认使用日期格式串{@link DateUtil.ISO_DATE_FORMAT}
	 * 
	 * @param str
	 *            日期型字符串
	 * @param pattern
	 *            日期格式串
	 * @return
	 * @author william
	 */
	public static Date parseDateByPattern(String str, String... patterns) {
		if (patterns == null || patterns.length < 1) {
			patterns = new String[] { ISO_DATE_FORMAT };
		}
		for (String pattern : patterns) {
			Date d = null;
			try {
				SimpleDateFormat fmt = new SimpleDateFormat();
				fmt.applyPattern(pattern);
				d = fmt.parse(str);
				return d;
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return null;

	}

	/**
	 * 使用默认的日期格式串{@link DateUtil.ISO_DATE_FORMAT}将日期型字符串转化为日期类<br>
	 * 
	 * @param str
	 *            日期型字符串
	 * @return
	 * @throws ParseException
	 * @author william
	 */
	public static Date parseDate(String str) {
		return parseDateByPattern(str, ISO_DATE_FORMAT);
	}

	/**
	 * 使用默认的日期格式串{@link DateUtil.ISO_DATE_TIME_FORMAT}将日期型字符串转化为日期类<br>
	 * 
	 * @param str
	 *            日期型字符串
	 * @return
	 * @author william
	 */
	public static Date parseDateTime(String str) {
		return parseDateByPattern(str, ISO_DATE_TIME_FORMAT);
	}

	/**
	 * 日期天数相加,返回新日期对象，原对象不变
	 * 
	 * @param date
	 * @param d
	 * @return
	 * @author william
	 */
	public static Date addDays(Date date, int d) {
		return DateUtils.addDays(date, d);
	}

	/**
	 * 日期月份相加,返回新日期对象，原对象不变
	 * 
	 * @param date
	 * @param m
	 * @return
	 * @author william
	 */
	public static Date addMonths(Date date, int m) {
		return DateUtils.addMonths(date, m);
	}

	/**
	 * 日期年份相加,返回新日期对象，原对象不变
	 * 
	 * @param date
	 * @param y
	 * @return
	 * @author william
	 */
	public static Date addYears(Date date, int y) {
		return DateUtils.addYears(date, y);
	}

	/**
	 * 日期型字符串增加天数，返回新日期型字符串<br>
	 * 默认使用日期格式串{@link DateUtil.ISO_DATE_FORMAT}
	 * 
	 * @param date
	 * @param d
	 * @return
	 * @author william
	 */
	public static String addDays(String str, int d, String... patterns) {
		Date date = parseDateByPattern(str, patterns);
		date = addDays(date, d);
		return formatDateByPattern(date, patterns);
	}

	/**
	 * 日期型字符串增加月数，返回新日期型字符串<br>
	 * 默认使用日期格式串{@link DateUtil.ISO_DATE_FORMAT}
	 * 
	 * @param str
	 * @param m
	 * @param patterns
	 * @return
	 * @author william
	 */
	public static String addMonths(String str, int m, String... patterns) {
		Date date = parseDateByPattern(str, patterns);
		date = addMonths(date, m);
		return formatDateByPattern(date, patterns);
	}

	/**
	 * 日期型字符串增加年数，返回新日期型字符串<br>
	 * 默认使用日期格式串{@link DateUtil.ISO_DATE_FORMAT}
	 * 
	 * @param str
	 * @param y
	 * @param patterns
	 * @return
	 * @author william
	 */
	public static String addYears(String str, int y, String... patterns) {
		Date date = parseDateByPattern(str, patterns);
		date = addYears(date, y);
		return formatDateByPattern(date, patterns);
	}

}
