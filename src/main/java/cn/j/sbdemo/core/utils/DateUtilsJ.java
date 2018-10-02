package cn.j.sbdemo.core.utils;

import org.apache.commons.lang3.time.FastDateFormat;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

/**
 * 命名加上后缀避免与三方库类重名
 * @author J
 * @Date 2018/9/27 22:59
 * @Description 自定义的日期处理工具类
 * @Note 若是需要使用时间相关常量,请使用common.lang3中DateUtils里面的
 **/
public class DateUtilsJ {
    /**
     * 时间格式
     */
    public static final String DATE_FORMAT_STR = "yyyy-MM-dd";
    public static final String DATE_FORMAT_STR1 = "yyyy/MM/dd";
    public static final String DATETIME_FORMAT_STR = "yyyy-MM-dd hh:mm:ss";
    public static final String DATETIME_FORMAT_STR1 = "yyyy/MM/dd hh:mm:ss";

    /**
     * 格式化对象
     */
    public static final FastDateFormat DATE_FORMAT = FastDateFormat.getInstance(DATE_FORMAT_STR);
    public static final FastDateFormat DATE_FORMAT1 = FastDateFormat.getInstance(DATE_FORMAT_STR1);
    public static final FastDateFormat DATETIME_FORMAT = FastDateFormat.getInstance(DATETIME_FORMAT_STR);
    public static final FastDateFormat DATETIME_FORMAT1 = FastDateFormat.getInstance(DATETIME_FORMAT_STR1);


    /**
     * 获取指定日期对象
     *
     * @param date yyyy-MM-dd
     */
    public static Date getDate(String date) throws ParseException {
        return getDate(date, "-");
    }

    /**
     * 获取指定日期对象
     *
     * @param split "-" 或者"/"
     */
    public static Date getDate(String date, String split) throws ParseException {
        split = split.trim();
        if ("-".equals(split)) {
            return DATE_FORMAT.parse(date);
        } else if ("/".equals(split)) {
            return DATE_FORMAT1.parse(date);
        } else {
            throw new IllegalArgumentException("不合法的日期分隔符");
        }
    }

    /**
     * 获取指定日期时间对象
     *
     * @param datetime yyyy-MM-dd hh:mm:ss
     */
    public static Date getDateTime(String datetime) throws ParseException {
        return getDateTime(datetime, "-");
    }

    /**
     * 获取指定日期时间对象
     *
     * @param split "-" 或者"/"
     */
    public static Date getDateTime(String datetime, String split) throws ParseException {
        split = split.trim();
        if ("-".equals(split)) {
            return DATETIME_FORMAT.parse(datetime);
        } else if ("/".equals(split)) {
            return DATETIME_FORMAT1.parse(datetime);
        } else {
            throw new IllegalArgumentException("不合法的日期分隔符");
        }
    }

    /**
     * 获取周一
     */
    public static Date getMonday(Date date) {
        Calendar calendar = getCalendar(date);
        //若是周日 则减一天  因为 Calendar 周日为每周第一天
        if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
            calendar.add(Calendar.DATE, -1);
        }
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        return calendar.getTime();
    }

    /**
     * 获取周日
     */
    public static Date getSunday(Date date) {
        Calendar calendar = getCalendar(date);
        //若不是周日 则加6天  因为 Calendar 周日为每周第一天
        if (calendar.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
            calendar.add(Calendar.DATE, 6);
        }
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        return calendar.getTime();
    }

    /**
     * 获取月一号
     */
    public static Date getFirstDayOfMonth(Date date) {
        Calendar calendar = getCalendar(date);
        //设为1号
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        return calendar.getTime();
    }

    /**
     * 获取下个月一号
     */
    public static Date getFirstDayOfNextMonth(Date date) {
        Calendar calendar = getCalendar(date);
        //设为1号
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        //加一个月
        calendar.add(Calendar.MONTH, 1);
        return calendar.getTime();
    }

    /**
     * 获取月最后一号
     */
    public static Date getLastDayOfMonth(Date date) {
        Calendar calendar = getCalendar(date);
        //设为1号
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        //加一个月
        calendar.add(Calendar.MONTH, 1);
        //减一天
        calendar.add(Calendar.DATE, -1);
        return calendar.getTime();
    }

    /**
     * 返回Calendar
     */
    public static Calendar getCalendar() {
        return Calendar.getInstance();
    }

    /**
     * 返回Calendar
     */
    public static Calendar getCalendar(Date date) {
        Calendar calendar = getCalendar();
        calendar.setTime(date);
        return calendar;
    }
}
