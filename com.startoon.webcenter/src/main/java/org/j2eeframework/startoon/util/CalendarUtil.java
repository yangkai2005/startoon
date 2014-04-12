package org.j2eeframework.startoon.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarUtil {

	public static void main(String[] args) {
		Date[] range = getDateTimeRange(new Date());
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(fmt.format(range[0]));
		System.out.println(fmt.format(range[1]));
		
	}

	public static long getDayZero() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);

		return calendar.getTimeInMillis();
	}

	public static Date getDayBegin() {
		long millis = getDayZero();
		Date date = new Date(millis);
		return date;
	}

	public static Date getDateEnd() {
		long millis = getDayZero();
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(millis);
		calendar.add(Calendar.DAY_OF_YEAR, 1);
		return calendar.getTime();
	}

	/**
	 * 计算时间范围
	 * @param date
	 * @return
	 */
	public static Date[] getDateTimeRange(Date date) {

		Date[] range = new Date[2];

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int min = calendar.get(Calendar.MINUTE);
		int c = (int) ((1.0 * min / 60) + 0.5);

		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();

		c1.setTime(date);
		c2.setTime(date);

		if (c == 0) {
			c1.set(Calendar.MINUTE, 0);
			c1.set(Calendar.SECOND, 0);
			c1.set(Calendar.MILLISECOND, 0);

			c2.set(Calendar.MINUTE, 30);
			c2.set(Calendar.SECOND, 0);
			c2.set(Calendar.MILLISECOND, 0);

		} else {
			c1.add(Calendar.HOUR_OF_DAY, 1);
			c1.set(Calendar.MINUTE, -30);
			c1.set(Calendar.SECOND, 0);
			c1.set(Calendar.MILLISECOND, 0);

			c2.add(Calendar.HOUR_OF_DAY, 1);
			c2.set(Calendar.MINUTE, 0);
			c2.set(Calendar.SECOND, 0);
			c2.set(Calendar.MILLISECOND, 0);
		}

		range[0] = c1.getTime();
		range[1] = c2.getTime();

		return range;
	}
	
	/**
	 * 判断cdate是否在range[0]~range[1]之间
	 * @param range
	 * @param cdate
	 * @return
	 */
	public static boolean isTimeInRange(Date[] range, Date cdate) {
		
		long sMillis = range[0].getTime(),
			eMillis = range[1].getTime(),
			cMillis = cdate.getTime();
		
		return (cMillis>sMillis && cMillis<=eMillis);
		
	}
}
