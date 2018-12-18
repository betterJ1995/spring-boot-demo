package cn.j.sbdemo.common;

import java.util.Calendar;
import java.util.Date;

/**
 * 扩展的日期工具类
 * <p>
 * created on 2018/11/23.
 *
 * @author J
 **/
public class ExtendDateUtils {
    /**
     * 获取周一
     *
     * @param date
     * @return
     */
    public static Date getMonday(Date date) {
        Calendar calendar = setDate(date);
        //获取周一的时间
        if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
            calendar.add(Calendar.DATE, -1);
        }
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        return calendar.getTime();
    }

    /**
     * 获取周日
     *
     * @param date
     * @return
     */
    public static Date getSunday(Date date) {
        Calendar calendar = setDate(date);
        if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
            calendar.add(Calendar.DATE, 1);
        }
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        return calendar.getTime();
    }

    /**
     * 获取月第一天
     *
     * @param date
     * @return
     */
    public static Date getMonthFirst(Date date) {
        return setMonthFirst(date).getTime();
    }


    /**
     * 获取月最后一天
     *
     * @param date
     * @return
     */
    public static Date getMonthLast(Date date) {
        Calendar calendar = setMonthFirst(date);
        calendar.add(Calendar.MONTH, 1);
        calendar.add(Calendar.DATE, -1);
        return calendar.getTime();
    }


    private static Calendar setMonthFirst(Date date) {
        Calendar calendar = setDate(date);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        return calendar;
    }

    private static Calendar setDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }


/*    public static void main(String[] args) {
        Date date = new Date();
        Date monday = ExtendDateUtils.getMonday(date);
        Date sunday = ExtendDateUtils.getSunday(date);
        Date monthFirst = ExtendDateUtils.getMonthFirst(date);
        Date monthLast = ExtendDateUtils.getMonthLast(date);
        System.out.println(monday);
        System.out.println(sunday);
        System.out.println(monthFirst);
        System.out.println(monthLast);
    }*/
}
