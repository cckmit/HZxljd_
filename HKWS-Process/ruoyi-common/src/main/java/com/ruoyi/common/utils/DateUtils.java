package com.ruoyi.common.utils;

import java.lang.management.ManagementFactory;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import cn.hutool.core.date.BetweenFormatter;
import cn.hutool.core.date.DateUtil;
import org.apache.commons.lang3.time.DateFormatUtils;
import sun.misc.Cleaner;

/**
 * 时间工具类
 *
 * @author ruoyi
 */
public class DateUtils extends org.apache.commons.lang3.time.DateUtils {
    public static String YYYY = "yyyy";

    public static String YYYY_MM = "yyyy-MM";

    public static String YYYY_MM_DD = "yyyy-MM-dd";

    public static String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";

    public static String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

    private static String[] parsePatterns = {
            "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy-MM",
            "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy/MM",
            "yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm", "yyyy.MM"};

    /**
     * 获取当前Date型日期
     *
     * @return Date() 当前日期
     */
    public static Date getNowDate() {
        return new Date();
    }

    /**
     * 获取当前日期, 默认格式为yyyy-MM-dd
     *
     * @return String
     */
    public static String getDate() {
        return dateTimeNow(YYYY_MM_DD);
    }

    public static final String getTime() {
        return dateTimeNow(YYYY_MM_DD_HH_MM_SS);
    }

    public static final String dateTimeNow() {
        return dateTimeNow(YYYYMMDDHHMMSS);
    }

    public static final String dateTimeNow(final String format) {
        return parseDateToStr(format, new Date());
    }

    public static final String dateTime(final Date date) {
        return parseDateToStr(YYYY_MM_DD, date);
    }

    public static final String parseDateToStr(final String format, final Date date) {
        return new SimpleDateFormat(format).format(date);
    }

    public static final Date dateTime(final String format, final String ts) {
        try {
            return new SimpleDateFormat(format).parse(ts);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 日期路径 即年/月/日 如2018/08/08
     */
    public static final String datePath() {
        Date now = new Date();
        return DateFormatUtils.format(now, "yyyy/MM/dd");
    }

    /**
     * 日期路径 即年/月/日 如20180808
     */
    public static final String dateTime() {
        Date now = new Date();
        return DateFormatUtils.format(now, "yyyyMMdd");
    }

    public static final String dateYear() {
        Date now = new Date();
        return DateFormatUtils.format(now, "yyyy");
    }

    /**
     * 日期路径 即年/月/日 如20180808
     */
    public static final String dateTimes() {
        Date now = new Date();
        return DateFormatUtils.format(now, "HHmmss");
    }

    /**
     * 日期型字符串转化为日期 格式
     */
    public static Date parseDate(Object str) {
        if (str == null) {
            return null;
        }
        try {
            return parseDate(str.toString(), parsePatterns);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 获取服务器启动时间
     */
    public static Date getServerStartDate() {
        long time = ManagementFactory.getRuntimeMXBean().getStartTime();
        return new Date(time);
    }

    /**
     * 计算两个时间差
     */
    public static String getDatePoor(Date endDate, Date nowDate) {
        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        long nm = 1000 * 60;
        // long ns = 1000;
        // 获得两个时间的毫秒时间差异
        long diff = endDate.getTime() - nowDate.getTime();
        // 计算差多少天
        long day = diff / nd;
        // 计算差多少小时
        long hour = diff % nd / nh;
        // 计算差多少分钟
        long min = diff % nd % nh / nm;
        // 计算差多少秒//输出结果
        // long sec = diff % nd % nh % nm / ns;
        return day + "天" + hour + "小时" + min + "分钟";
    }

    public static Double getHour(Date endDate, Date startDate){
        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        // 获得两个时间的毫秒时间差异
        long diff = endDate.getTime() - startDate.getTime();
        // 计算差多少天
        long day = diff / nd;
        // 计算差多少小时
        Double hour = Double.valueOf(diff % nd) / nh;
        hour = hour + day * 24;
        return hour;
    }

    public static Double getHourByTimestamp(Long times) {
        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        Double hour = Double.valueOf(times % nd) / nh;
        return hour;
    }


    /**
     * 获取周一日期
     *
     * @return 当前日期
     */
    public static Date getThisWeekMonday() {
        Calendar calendar = Calendar.getInstance();
        //设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        //获得当前日期是一个星期的第几天
        int dayWeek = calendar.get(Calendar.DAY_OF_WEEK);
        if (dayWeek == 1) {
            dayWeek = 8;
        }
        // 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
        calendar.add(Calendar.DATE, calendar.getFirstDayOfWeek() - dayWeek);
        return calendar.getTime();
    }

    public static Date getLastMonthMonday() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        return calendar.getTime();
    }

    /**
     * 获取本月一号
     *
     * @return
     */
    public static Date getThisMonthMonday() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        return calendar.getTime();
    }

    public static Date getLastMonthFirstDay() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);
        cal.set(Calendar.DAY_OF_MONTH,
                cal.getActualMinimum(Calendar.DAY_OF_MONTH));
        return cal.getTime();
    }

    /**
     * 获取上周一号
     *
     * @return
     */
    public static Date getLastWeekMonday() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(getThisWeekMonday());
        cal.add(Calendar.DATE, -7);
        return cal.getTime();
    }

    /**
     * 获取本月最后一天
     *
     * @return
     */
    public static Date getThisMonthEndDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        return calendar.getTime();
    }

    /**
     * 获取过去二十四小时对应时间
     *
     * @return
     */
    public static Date getTwentyFour() {
        //近24小时垃圾堆积事件发生数
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) - 1);
        return calendar.getTime();
    }

    /**
     * 获取今年第一天日期
     *
     * @return
     */
    public static Date getFirstDayTheYear() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.getActualMinimum(Calendar.DAY_OF_YEAR);
        calendar.set(Calendar.DAY_OF_YEAR, year);
        return calendar.getTime();
    }

    /**
     * 获取去年本月开始日期
     *
     * @return
     */
    public static Date getLastYearSameMouthBegin() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) - 1);
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH));
        calendar.set(Calendar.DATE, 1);
        return calendar.getTime();
    }

    /**
     * 获取去年本月结束日期
     *
     * @return
     */
    public static Date getLastYearSameMouthEnd() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) - 1);
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH));
        int day = calendar.getActualMaximum(5);
        calendar.set(Calendar.DATE, day);
        return calendar.getTime();
    }

    /**
     * 获取上月第一天
     *
     * @return
     */
    public static Date getLastMouthBegin() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 1);
        calendar.set(Calendar.DATE, 1);
        return calendar.getTime();
    }

    /**
     * 获取上月最后一天
     *
     * @return
     */
    public static Date geLastMouthEnd() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 1);
        int day = calendar.getActualMaximum(5);
        calendar.set(Calendar.DATE, day);
        return calendar.getTime();
    }

    /**
     * 获取去年第一天日期
     *
     * @return
     */
    public static Date getFirstDayLastYear() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) - 1);
        int year = calendar.getActualMinimum(Calendar.DAY_OF_YEAR);
        calendar.set(Calendar.DAY_OF_YEAR, year);
        return calendar.getTime();
    }


    /**
     * 获取过去12个月
     *
     * @return
     */
    public static String getLastTwelveMin() {
        Calendar calendar = Calendar.getInstance();
        Long times = calendar.getTime().getTime();
        Long newTimes = times - 5000L;
//        System.out.println(newTimes);
        SimpleDateFormat sdf = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS);
        return sdf.format(new Date(newTimes));
    }

    /**
     * 获取过去一段时间
     *
     * @return
     */
    public static String getLastRequestTime(Long time) {
        Calendar calendar = Calendar.getInstance();
        Long times = calendar.getTime().getTime();
        Long newTimes = times - time;
        SimpleDateFormat sdf = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS);
        return sdf.format(new Date(newTimes));
    }

    /**
     * 组装查询日期范围
     *
     * @param type
     * @return
     */
    public static Map<String, Object> eventDate(String type) {
        Map<String, Object> map = new HashMap<>();
        if ("day".equals(type)) {
            //当天日期
            map.put("currentDate", DateFormatUtils.format(new Date(), "yyyy-MM-dd"));
        } else if ("week".equals(type)) {
            //本周一
            map.put("trendWeekMonday", DateFormatUtils.format(DateUtils.getThisWeekMonday(), "yyyy-MM-dd"));
        } else if ("month".equals(type)) {
            //本月一号
            map.put("trendMonthMonday", DateFormatUtils.format(DateUtils.getThisMonthMonday(), "yyyy-MM-dd"));
        }
        return map;
    }

    public static String timeToHour(Long time) {
        String date = "";
        if (time < 60) {
            date = time + "秒";
        } else if (time < 3600) {
            double result1 = new BigDecimal(time).divide(new BigDecimal("60"), 2, BigDecimal.ROUND_HALF_UP).doubleValue();
            date = result1 + "分钟";
        } else {
            double result1 = new BigDecimal(time).divide(new BigDecimal("3600"), 2, BigDecimal.ROUND_HALF_UP).doubleValue();
            date = result1 + "小时";
        }
        return date;
    }

    public static Long getHourByTime(Long time) {
        long nd = 24 * 60 * 60;// 一天的秒数
        long nh = 60 * 60;// 一小时的秒数
        long day = 0;
        long hour = 0;
        day = time / nd;// 计算差多少天
        hour = time % nd / nh + day * 24;// 计算差多少小时
        return hour;
    }

    public static Double getHourByTime1(Long time) {
        long nd = 24 * 60 * 60;// 一天的秒数
        long nh = 60 * 60;// 一小时的秒数
        long day = 0;
        double hour = 0;
        day = time / nd;// 计算差多少天
        hour = time % nd / nh + day * 24;// 计算差多少小时
        return hour;
    }

    /**
     * 截取时间差保留两个单位的时间
     **/
    public static String subStrDateStringRetainTwo(String dateTime) {
        if (!StringUtils.isEmpty(dateTime)) {
            if (dateTime.indexOf(BetweenFormatter.Level.DAY.getName()) > 0) {
                String[] split = dateTime.split(BetweenFormatter.Level.HOUR.getName());
                dateTime = split[0] + BetweenFormatter.Level.HOUR.getName();
            } else if (dateTime.indexOf(BetweenFormatter.Level.HOUR.getName()) > 0) {
                String[] split = dateTime.split(BetweenFormatter.Level.MINUTE.getName());
                dateTime = split[0] + BetweenFormatter.Level.MINUTE.getName();
            } else if (dateTime.indexOf(BetweenFormatter.Level.MINUTE.getName()) > 0) {
                String[] split = dateTime.split(BetweenFormatter.Level.SECOND.getName());
                dateTime = split[0] + BetweenFormatter.Level.SECOND.getName();
            }
        }
        return dateTime;
    }

    /**
     * 截取时间差保留一个单位的时间
     **/
    public static String subStrDateStringRetainOne(String dateTime) {
        if (!StringUtils.isEmpty(dateTime)) {
            if (dateTime.indexOf(BetweenFormatter.Level.DAY.getName()) > 0) {
                String[] split = dateTime.split(BetweenFormatter.Level.DAY.getName());
                dateTime = split[0] + BetweenFormatter.Level.DAY.getName();
            } else if (dateTime.indexOf(BetweenFormatter.Level.HOUR.getName()) > 0) {
                String[] split = dateTime.split(BetweenFormatter.Level.HOUR.getName());
                dateTime = split[0] + BetweenFormatter.Level.HOUR.getName();
            } else if (dateTime.indexOf(BetweenFormatter.Level.MINUTE.getName()) > 0) {
                String[] split = dateTime.split(BetweenFormatter.Level.MINUTE.getName());
                dateTime = split[0] + BetweenFormatter.Level.MINUTE.getName();
            } else if (dateTime.indexOf(BetweenFormatter.Level.SECOND.getName()) > 0) {
                String[] split = dateTime.split(BetweenFormatter.Level.SECOND.getName());
                dateTime = split[0] + BetweenFormatter.Level.SECOND.getName();
            }
        }
        return dateTime;
    }


    /**
     * 当前时间
     *
     * @param date   当前时间
     * @param offset 偏移量 负数为往过去推移年份，正数为往未来推移年份
     * @return
     */
    public static String getNearlyYear(Date date, int offset) {
        int year = DateUtil.year(date) + offset;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sdf.format(date);
        StringBuilder sb = new StringBuilder();
        return sb.append(year).append(format.substring(4)).toString();
    }

    public static void main(String[] args) {
        String str = "2021-04-25 21:55:55";
        try {
            /*SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            int compare = DateUtil.compare(new Date(), sdf.parse(str));//签收是否逾期
            System.out.println(compare);*/


            Calendar calendar = Calendar.getInstance();
            /*calendar.setTime(DateUtils.getThisMonthEndDay());*/
            int stageCount = calendar.get(Calendar.DAY_OF_WEEK);
//            int stageCount = calendar.get(Calendar.DAY_OF_MONTH);
            System.out.println(stageCount);
        } catch (Exception ex) {
        }

    }

    //后一天
    public static Date getTomorrow(Date date) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(calendar.DATE, +1);
        date = calendar.getTime();
        return date;
    }

    //获取指定格式的日期类型
    public static Date getFormatDate(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        String sd = sdf.format(date);
        try {
            date = sdf.parse(sd);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    //获取指定类型的字符串类型日期
    public static String getFormatDateString(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        String sd = sdf.format(date);
        return sd;
    }

    //获取指定日期是当月的几号
    public static int getDateDay(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        //获取日
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        return day;
    }

    //获取指定日期的小时
    public static int getDateHours(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        //获取日
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        return hour;
    }

    //判断指定日期是星期几
    public static int getDateWeek(Date date) {
        SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
        String ds = formater.format(date);
        try {
            date = formater.parse(ds);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int dayForWeek = 0;
        if (c.get(Calendar.DAY_OF_WEEK) == 1) {
            dayForWeek = 7;
        } else {
            dayForWeek = c.get(Calendar.DAY_OF_WEEK) - 1;
        }
        return dayForWeek;
    }

    //将对应的数字换成星期
    public static String getWeekName(Integer week) {
        String weekName ="";
        switch (week) {
            case 1:
                weekName = "星期一";
                break;
            case 2:
                weekName = "星期二";
                break;
            case 3:
                weekName = "星期三";
                break;
            case 4:
                weekName = "星期四";
                break;
            case 5:
                weekName = "星期五";
                break;
            case 6:
                weekName = "星期六";
                break;
            case 7:
                weekName = "星期日";
                break;
        }
        return weekName;
    }
}
