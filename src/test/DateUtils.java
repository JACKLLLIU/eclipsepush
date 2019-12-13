package test;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class DateUtils {

    private static final Logger logger = LoggerFactory.getLogger(DateUtils.class);

    public static final int SECONDS_IN_DAY = 60 * 60 * 24;
    public static final long MILLIS_IN_DAY = 1000L * SECONDS_IN_DAY;

    private static long toDay(long millis) {
        return (millis + TimeZone.getDefault().getOffset(millis)) / MILLIS_IN_DAY;
    }

    /**
     * 判断两个日期是否同一天
     * 
     * @param ms1
     * @param ms2
     * @return
     */
    public static boolean isSameDay(final long ms1, final long ms2) {
        final long interval = ms1 - ms2;
        return interval < MILLIS_IN_DAY && interval > -1L * MILLIS_IN_DAY && toDay(ms1) == toDay(ms2);
    }

    /**
     * 比较两个日期的大小
     * 
     * @param d1
     * @param d2
     * @return
     */
    public static Integer compart(Date d1, Date d2) {
        if (d1 == null || d2 == null) {
            return null;
        }
        if (d1.getTime() > d2.getTime()) {
            return 1;
        } else if (d1.getTime() == d2.getTime()) {
            return 0;
        } else if (d1.getTime() < d2.getTime()) {
            return -1;
        } else {
            return null;
        }
    }

    /**
     * 获取当月第一天
     */
    public static Date getFirstDayOfMonth() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, 0);
        c.set(Calendar.DAY_OF_MONTH, 1);// 设置为1号,当前日期既为本月第一天
        // 将时分秒,毫秒域清零
        toZeroByCalendar(c);
        return c.getTime();
    }

    /**
     * 获取当月最后一天
     */
    public static Date getLastDayOfMonth() {
        Calendar ca = Calendar.getInstance();
        ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));
        // 将时分秒,毫秒域清零
        toZeroByCalendar(ca);
        return ca.getTime();
    }

    /**
     * 获取当前日期前day天
     * 
     * @param date
     * @param day
     * @return
     */
    public static Date getBeforeDay(Date date, int day) {
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        ca.add(Calendar.DAY_OF_MONTH, -day);
        // 将时分秒,毫秒域清零
        toZeroByCalendar(ca);
        return ca.getTime();
    }

    /**
     * 获取当前日期后day天
     * 
     * @param date
     * @param day
     * @return
     */
    public static Date getAfterDay(Date date, int day) {
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        ca.add(Calendar.DAY_OF_MONTH, day);
        // 将时分秒,毫秒域清零
        toZeroByCalendar(ca);
        return ca.getTime();
    }

    /**
     * 获取前month月的日期(month为负时往后推，month为正时往前推)
     * 
     * @param date
     * @param month
     * @return
     */
    public static Date getBeforeMonth(Date date, int month) {
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        ca.add(Calendar.MONTH, -month);
        // 将时分秒,毫秒域清零
        toZeroByCalendar(ca);
        return ca.getTime();
    }

    /**
     * 获newDtae时间前points个月的每个月的第一天和最后一天
     * 
     * @param
     * @param
     * @return
     */
    public static List<Map<String, String>> getDateList(Date newDtae, Integer points) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        List<Map<String, String>> time = new ArrayList<Map<String, String>>();

        Map<String, String> map = new HashMap<String, String>();
        Date beforeMonth = getBeforeMonth(newDtae, 1);
        for (int i = 0; i < points; i++) {
            String firstDay = sdf.format(getFirstDayOfMonth(beforeMonth));
            String lastDay = sdf.format(getLastDayOfMonth(beforeMonth));
            beforeMonth = getBeforeMonth(beforeMonth, 1);
            map.put("startDate", firstDay);
            map.put("endDate", lastDay);
            time.add(map);
            map = new HashMap<String, String>();
        }

        return time;
    }

    /**
     * 获取当月第一天
     */
    public static Date getFirstDayOfMonth(Date newDate) {
        Calendar c = Calendar.getInstance();
        c.setTime(newDate);
        c.set(Calendar.DAY_OF_MONTH, 1);// 设置为1号,当前日期既为本月第一天
        // 将时分秒,毫秒域清零
        toZeroByCalendar(c);
        return c.getTime();
    }

    /**
     * 获取当月最后一天
     */
    public static Date getLastDayOfMonth(Date newDate) {
        Calendar ca = Calendar.getInstance();
        ca.setTime(newDate);
        ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));
        // 将时分秒,毫秒域清零
        toZeroByCalendar(ca);
        return ca.getTime();
    }

    public static String getNowTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date());
    }

    public static String formatDate(Date d) {
    	if (d != null) {
    		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String date = formatter.format(d);
            return date;
    	}
    	return null;
    }

    public static Date formatDate(String d) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = formatter.parse(d);
        } catch (ParseException e) {
            logger.error(e.getMessage(), e);
        }
        return date;
    }
    
    public static Date formatDateTime(String d) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = formatter.parse(d);
        } catch (ParseException e) {
            logger.error(e.getMessage(), e);
        }
        return date;
    }

    public static Date getNowTimeAndHoursMinutesSecondsToZero() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        // 将时分秒,毫秒域清零
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    /**
     * 获取指定日期的日
     * 
     * @param date
     * @return
     */
    public static int getDay(Date date) {
        Calendar now = Calendar.getInstance();
        now.setTime(date);
        int day = now.get(Calendar.DAY_OF_MONTH);
        return day;
    }


    private static void toZeroByCalendar(Calendar c) {
        // 将时分秒,毫秒域清零
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);

        return;
    }

    public static Date setTimeHMSToZero(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        toZeroByCalendar(calendar);
        return calendar.getTime();
    }

    /**
     * 获取查询时间的points个时间区间
     * 
     * @param startDate
     * @param endDate
     * @return
     */
    public static List<Map<String, String>> getDateList(String startDate, String endDate, Integer points) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        List<Map<String, String>> time = new ArrayList<Map<String, String>>();
        try {
            Long dayTime = sdf.parse(endDate).getTime() - sdf.parse(startDate).getTime();

            int day = (int) (dayTime / (3600 * 24 * 1000)) + 1;
            Map<String, String> map = new HashMap<String, String>();
            for (int i = 0; i < points; i++) {
                map.put("startDate", startDate);
                map.put("endDate", endDate);
                time.add(map);
                map = new HashMap<String, String>();
                endDate = sdf.format(DateUtils.getBeforeDay(sdf.parse(startDate), 1));
                startDate = sdf.format(DateUtils.getBeforeDay(sdf.parse(startDate), day));
            }
        } catch (ParseException e) {
            logger.warn("日期处理异常" + e.getMessage());
        }
        return time;
    }

    /**
     * 两个日期相减获取天数
     * 
     * @param startDate
     * @param endDate
     * @return
     */
    public static int getDateSubtract(Date startDate, Date endDate) {
        return (int) ((endDate.getTime() - startDate.getTime()) / (24 * 3600 * 1000));
    }

    /**
     * 判断传入日期为周几
     * 
     * @param date
     * @param weekEnum
     * @return
     */
    public static boolean checkIsWeekDay(Date date, int weekEnum) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        if (calendar.get(Calendar.DAY_OF_WEEK) == weekEnum) {
            return true;
        }
        return false;
    }

    /**
     * 获取指定日月的天数
     * 
     * @param date
     * @return
     */
    public static int getCurrMonthDayNum(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    /**
     * 日期克隆.
     * 
     * @param date
     *            日期
     * @return 克隆后的日期
     */
    public static Date dateClone(Date date) {
        if (date != null) {
            return (Date) date.clone();
        } else {
            return null;
        }
    }

    /**
     * 获取当前时间10分钟后的时间
     * 
     * @return
     */
    public static String getDateYmdHms10MS() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date now = new Date();
        Date afterDate = new Date(now.getTime() + 600000);
        String date = formatter.format(afterDate);
        return date;
    }

    /**
     * 获取指定格式的日期时间（yyyyMMddHHmmss）
     * 
     * @return
     */
    public static String getDateYmdHms() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        String date = formatter.format(new Date());
        return date;
    }

    /**
     * 获取当前时间10分钟后的时间的指定格式的日期时间（yyyyMMddHHmmss）
     * 
     * @return
     */
    public static String getDateYmdHms10M() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        Date now = new Date();
        Date afterDate = new Date(now.getTime() + 600000);
        String date = formatter.format(afterDate);
        return date;
    }

    /**
     * 获取0点的时刻.
     * 
     * @param date
     *            时间
     * @return 0点时刻
     */
    public static Date getDateInZeroMiliSecond(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 00);
        calendar.set(Calendar.SECOND, 00);
        calendar.set(Calendar.MILLISECOND, 0);

        return calendar.getTime();
    }
    
    /**
	 * 获取指定日期的年
	 * 
	 * @param date
	 * @return
	 */
	public static int getYear(Date date) {
		Calendar ca = Calendar.getInstance();
		ca.setTime(date);
		int year = ca.get(Calendar.YEAR);
		return year;
	}

	/**
	 * 获取指定日期的月
	 * 
	 * @param date
	 * @return
	 */
	public static int getMonth(Date date) {
		Calendar ca = Calendar.getInstance();
		ca.setTime(date);
		int month = ca.get(Calendar.MONTH) + 1;
		return month;
	}

    /**
     * 判断两个日期相差月数.
     *
     * @param sourceDate
     *            开始日期
     * @param compareDate
     *            比较日期
     * @return 相差月数
     */
    public static int disparityMonth(Date sourceDate, Date compareDate) {
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(sourceDate);
        c2.setTime(compareDate);
        return (c2.get(Calendar.MONTH) - c1.get(Calendar.MONTH)) + (c2.get(Calendar.YEAR) - c1.get(Calendar.YEAR)) * 12;
    }
}

