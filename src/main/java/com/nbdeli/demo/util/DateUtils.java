package com.nbdeli.demo.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class DateUtils {
    /**
     * 详细时间格式
     */
    public static final SimpleDateFormat DEFAULT_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    public static Date getCurtentTime() {
        return new Date();
    }

    public static String date2Str(Date target) {

        return date2Str(target, DATE_FORMAT);
    }

    public static String dateTime2Str(Date target) {

        return date2Str(target, DEFAULT_DATE_FORMAT);
    }

    public static String date2Str(Date target, SimpleDateFormat pattern) {
        if (null == target || null == pattern) {
            return "";
        }
        String targetStr = "";
        try {
            targetStr = pattern.format(target);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return targetStr;
    }

    public static String date2Str(Date target, String pattern) {
        if (null == target) {
            return "";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        String targetStr = "";
        try {
            targetStr = sdf.format(target);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return targetStr;
    }

    public static Date str2Date(String target, String pattern) {
        if (null == target) {
            return new Date();
        }
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        Date date = null;
        try {
            date = sdf.parse(target);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }

    public static String str2DateFormat(String src) {
        if (src == null || "".equals(src)) {
            return "";
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            long seconds = 0;
            seconds = Long.parseLong(src);
            return sdf.format(new Date(seconds));
        } catch (NumberFormatException e) {
            return src;
        }
    }

    public static String str2DateFormat(String src, String pattern) {
        if (src == null || "".equals(src)) {
            return "";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        try {
            long seconds;
            seconds = Long.parseLong(src);
            return sdf.format(new Date(seconds));
        } catch (NumberFormatException e) {
            return src;
        }
    }

    /**
     * 时间加减计算
     *
     * @param date
     * @param offset
     * @return
     * @see [类、类#方法、类#成员]
     */
    public static Date date2Sub(Date date, int field, int offset) {
        Calendar c = Calendar.getInstance();

        c.setTime(date);
        c.add(field, offset);

        return c.getTime();
    }

    /**
     * 相差年数
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public static int yearDiff(Date startDate, Date endDate) {
        Calendar startCal = Calendar.getInstance();
        Calendar endCal = Calendar.getInstance();
        startCal.setTime(startDate);
        endCal.setTime(endDate);

        return endCal.get(Calendar.YEAR) - startCal.get(Calendar.YEAR);
    }

    /**
     * 相差天数
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public static long dayDiff(Date startDate, Date endDate) {
        return (endDate.getTime() - startDate.getTime()) / (24 * 60 * 60 * 1000);
    }

    /**
     * 相差秒数
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public static long secondDiff(Date startDate, Date endDate) {
        return (endDate.getTime() - startDate.getTime()) / (1000);
    }

    public static String dateToString(Date date, String resolution) {
        int formatLen;
        switch (resolution) {
            case "YEAR":
                formatLen = 4;
                break;
            case "MONTH":
                formatLen = 6;
                break;
            case "DAY":
                formatLen = 8;
                break;
            case "HOUR":
                formatLen = 10;
                break;
            case "MINUTE":
                formatLen = 12;
                break;
            case "SECOND":
                formatLen = 14;
                break;
            case "MILLISECOND":
                formatLen = 17;
                break;
            default:
                formatLen = 0;
        }
        SimpleDateFormat format;
        format = new SimpleDateFormat("yyyyMMddHHmmssSSS".substring(0, formatLen), Locale.ROOT);
        return format.format(date);
    }

    public static Date getFirstDateOfMonth(Date date) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        Date theDate = calendar.getTime();
        GregorianCalendar gcLast = (GregorianCalendar) Calendar.getInstance();
        gcLast.setTime(theDate);
        gcLast.set(Calendar.DAY_OF_MONTH, 1);
        String firstDay = df.format(gcLast.getTime());
        return str2Date(firstDay, "yyyy-MM-dd");
    }

    /**
     * 获取当月或上月的第一天零点零分（0是当月，-1是上月）
     */
    public static Date getFirstDateTimeOfMonth(Date date, int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    /**
     * 时间加一天
     */
    public static String getDateAddOne(String date) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date dd;
        try {
            dd = format.parse(date);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(dd);
            calendar.add(Calendar.DAY_OF_MONTH, 1);
            return format.format(calendar.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 根据年月获取该年月的第一天零时
     */
    public static Date getMonthFirstDay(int year,int month) {
        Calendar a = Calendar.getInstance();
        a.set(Calendar.YEAR, year);
        a.set(Calendar.MONTH, month - 1);
        a.set(Calendar.DAY_OF_MONTH, 1);
        a.set(Calendar.HOUR_OF_DAY, 0);
        a.set(Calendar.MINUTE, 0);
        a.set(Calendar.SECOND, 0);
        return a.getTime();
    }

    public static void main(String[] args) throws ParseException {
//        Date date = DateUtils.date2Sub(DateUtils.str2Date("2016-03-02 20:16:21", "yyyy-MM-dd HH:mm:ss"), 12, 10);
//        System.out.println(DateUtils.date2Str(new Date(), "yyyyMMddHHmmss"));
        // Date date1 = new Date();
        // System.out.println(date1);
        // System.out.println(date1.before(date));
        // String start = "2016-06-20 16:42:41";
        // String end = "2017-06-21 00:00:00";
        // SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        // Date startTime = sf.parse(start);
        // Date endTime = sf.parse(end);
        // long days = dayDiff(startTime, endTime);
        // System.out.println(days);
        // String s = DateUtils.str2DateFormat("1468466182000", "yyyy-MM-dd");
        // System.out.println(s);
        System.out.println(getDateAddOne("2018-02-28"));
        System.out.println(getMonthFirstDay(2018,1));
    }

    public static int formatYmdhmsm(Date date) {
        return 0;
    }
}
