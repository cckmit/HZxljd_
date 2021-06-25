package com.ruoyi.web.controller.common.utils;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.framework.web.domain.server.Sys;
import org.apache.commons.lang3.time.DateFormatUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

/**
 * 时间段落
 */
public class TimeUtil {


    public List<TimeField> getTime(String type) {
        List<TimeField> timeFields;
        if("24hours".equals(type)){
            timeFields = get24hours();
        }else if("hour".equals(type)){
            timeFields = getSixTimeField();
        }else if("fourHour".equals(type)){
            timeFields = getFourTimeField();
        }else if("day".equals(type)){
            timeFields = getTimeField();
        }else if("week".equals(type)){
            timeFields = getWeekDay();
        }else{
            timeFields = getMonthDay();
        }
        return timeFields;
    }
    /**
     * 获取一天所有时间段(间隔1小时)
     */
    private List<TimeField> get24hours(){
        List<TimeField> timeFields = new ArrayList<>();
        timeFields.add(new TimeField("HH:mm:ss","00:00:00","00:59:59","00:00-01:00"));
        timeFields.add(new TimeField("HH:mm:ss","01:00:00","01:59:59","01:00-02:00"));
        timeFields.add(new TimeField("HH:mm:ss","02:00:00","02:59:59","02:00-03:00"));
        timeFields.add(new TimeField("HH:mm:ss","03:00:00","03:59:59","03:00-04:00"));
        timeFields.add(new TimeField("HH:mm:ss","04:00:00","04:59:59","04:00-05:00"));
        timeFields.add(new TimeField("HH:mm:ss","05:00:00","05:59:59","05:00-06:00"));
        timeFields.add(new TimeField("HH:mm:ss","06:00:00","06:59:59","06:00-07:00"));
        timeFields.add(new TimeField("HH:mm:ss","07:00:00","07:59:59","07:00-08:00"));
        timeFields.add(new TimeField("HH:mm:ss","08:00:00","08:59:59","08:00-09:00"));
        timeFields.add(new TimeField("HH:mm:ss","09:00:00","09:59:59","09:00-10:00"));
        timeFields.add(new TimeField("HH:mm:ss","10:00:00","10:59:59","10:00-11:00"));
        timeFields.add(new TimeField("HH:mm:ss","11:00:00","11:59:59","11:00-12:00"));
        timeFields.add(new TimeField("HH:mm:ss","12:00:00","12:59:59","12:00-13:00"));
        timeFields.add(new TimeField("HH:mm:ss","13:00:00","13:59:59","13:00-14:00"));
        timeFields.add(new TimeField("HH:mm:ss","14:00:00","14:59:59","14:00-15:00"));
        timeFields.add(new TimeField("HH:mm:ss","15:00:00","15:59:59","15:00-16:00"));
        timeFields.add(new TimeField("HH:mm:ss","16:00:00","16:59:59","16:00-17:00"));
        timeFields.add(new TimeField("HH:mm:ss","17:00:00","17:59:59","17:00-18:00"));
        timeFields.add(new TimeField("HH:mm:ss","18:00:00","18:59:59","18:00-19:00"));
        timeFields.add(new TimeField("HH:mm:ss","19:00:00","19:59:59","19:00-20:00"));
        timeFields.add(new TimeField("HH:mm:ss","20:00:00","20:59:59","20:00-21:00"));
        timeFields.add(new TimeField("HH:mm:ss","21:00:00","21:59:59","21:00-22:00"));
        timeFields.add(new TimeField("HH:mm:ss","22:00:00","22:59:59","22:00-23:00"));
        timeFields.add(new TimeField("HH:mm:ss","23:00:00","23:59:59","23:00-24:00"));
        return timeFields;
    }

    /**
     * 获取本日所有时间段(间隔2小时)
     */
    private List<TimeField> getTimeField(){
        List<TimeField> timeFields = new ArrayList<>();
        timeFields.add(new TimeField("HH:mm","00:00","02:00","00:00-02:00"));
        timeFields.add(new TimeField("HH:mm","02:00","04:00","02:00-04:00"));
        timeFields.add(new TimeField("HH:mm","04:00","06:00","04:00-06:00"));
        timeFields.add(new TimeField("HH:mm","06:00","08:00","06:00-08:00"));
        timeFields.add(new TimeField("HH:mm","08:00","10:00","08:00-10:00"));
        timeFields.add(new TimeField("HH:mm","10:00","12:00","10:00-12:00"));
        timeFields.add(new TimeField("HH:mm","12:00","14:00","12:00-14:00"));
        timeFields.add(new TimeField("HH:mm","14:00","16:00","14:00-16:00"));
        timeFields.add(new TimeField("HH:mm","16:00","18:00","16:00-18:00"));
        timeFields.add(new TimeField("HH:mm","18:00","20:00","18:00-20:00"));
        timeFields.add(new TimeField("HH:mm","20:00","22:00","20:00-22:00"));
        timeFields.add(new TimeField("HH:mm","22:00","24:00","22:00-24:00"));
        return timeFields;
    }

    /**
     * 获取本日时间段（六小时为分割线）
     */
    private List<TimeField> getSixTimeField(){
        List<TimeField> timeFields = new ArrayList<>();
        timeFields.add(new TimeField("HH:mm","00:00","06:00","06:00"));
        timeFields.add(new TimeField("HH:mm","06:00","12:00","12:00"));
        timeFields.add(new TimeField("HH:mm","12:00","18:00","18:00"));
        timeFields.add(new TimeField("HH:mm","18:00","24:00","00:00"));
        return timeFields;
    }

    /**
     * 获取本日时间段（四小时为分割线）
     */
    private List<TimeField> getFourTimeField(){
        List<TimeField> timeFields = new ArrayList<>();
        timeFields.add(new TimeField("HH:mm","00:00","04:00","04:00"));
        timeFields.add(new TimeField("HH:mm","04:00","08:00","08:00"));
        timeFields.add(new TimeField("HH:mm","08:00","12:00","12:00"));
        timeFields.add(new TimeField("HH:mm","12:00","16:00","16:00"));
        timeFields.add(new TimeField("HH:mm","16:00","20:00","20:00"));
        timeFields.add(new TimeField("HH:mm","20:00","24:00","24:00"));
        return timeFields;
    }

    /**
     * 获取本周所有日期
     * @return
     */
    private List<TimeField> getWeekDay(){
        Calendar calendar = Calendar.getInstance();
        setToFirstDay(calendar);
        List<TimeField> timeFields = new ArrayList<>();
        for (int i = 0;i<7;i++){
            String time = DateFormatUtils.format(calendar.getTime(),"yyyy-MM-dd");
            timeFields.add(new TimeField("yyyy-MM-dd",time,time,time));
            calendar.add(Calendar.DATE,1);
        }
        return timeFields;
    }

    private void setToFirstDay(Calendar calendar){
        calendar.setTime(DateUtils.getThisWeekMonday());
    }

    /**
     * 获取本月所有日期
     */
    private  List<TimeField> getMonthDay() {
        Calendar calendar = Calendar.getInstance();
        //本月最后一天
        setToMonthFirstDay(calendar);
        int maxDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        List<TimeField> timeFields = new ArrayList<>();
        String beginTime = "";//时间段开始日期
        for (int i = 0;i < maxDay ;i++){
            if(StringUtils.isEmpty(beginTime)){
                beginTime = DateFormatUtils.format(calendar.getTime(),"yyyy-MM-dd");
            }
            if(i % 7 == 0 && i > 0 || i == maxDay-1){
                String endTime = DateFormatUtils.format(calendar.getTime(),"yyyy-MM-dd");
                timeFields.add(new TimeField("yyyy-MM-dd",beginTime,endTime,beginTime));
                beginTime = endTime;
            }
            calendar.add(Calendar.DATE,1);
        }
        return timeFields;
    }

    /**
     *   本月最后一天
     * @param calendar
     */
    private void setToMonthFirstDay(Calendar calendar){
        calendar.setTime(DateUtils.getThisMonthMonday());
    }

    /**
     * 获取日期时间差
     * @param startDate 开始日期
     * @param endDate 结束日期
     * @return
     */
    private List<String> getBetweenDate(Date startDate, Date endDate){
        List<String> timeFields = new ArrayList<>();

        Calendar startDateCalendar = Calendar.getInstance();
        startDateCalendar.setTime(startDate);

        Calendar endDateCalendar = Calendar.getInstance();
        endDateCalendar.setTime(endDate);

        int startYear = startDateCalendar.get(Calendar.YEAR);
        int endYear = endDateCalendar.get(Calendar.YEAR);
        int yearBetweenDate = endYear - startYear;
        if(endYear == startYear){
            int startMonth = startDateCalendar.get(Calendar.MONTH);
            int endMonth = endDateCalendar.get(Calendar.MONTH);
            int betweenDate = endMonth - startMonth;
            if(startMonth == endMonth){
                startDateCalendar.setFirstDayOfWeek(Calendar.MONDAY);
                endDateCalendar.setFirstDayOfWeek(Calendar.MONDAY);
                int startWeek = startDateCalendar.get(Calendar.WEEK_OF_MONTH);
                int endWeek = endDateCalendar.get(Calendar.WEEK_OF_MONTH);
                betweenDate = endWeek - startWeek;
                if(startWeek == endWeek){
                    int startDay = startDateCalendar.get(Calendar.DAY_OF_MONTH);
                    int endDay = endDateCalendar.get(Calendar.DAY_OF_MONTH);
                    betweenDate = endDay - startDay;
                    for(int i =0;i< betweenDate ;i++){
                        timeFields.add(DateFormatUtils.format(startDateCalendar.getTime(),"yyyy-MM-dd"));
                        startDateCalendar.add(Calendar.DATE,1);
                    }
                    timeFields.add(DateFormatUtils.format(endDateCalendar.getTime(),"yyyy-MM-dd"));
                }else {
                    return getTimeDifference(startDateCalendar,betweenDate,Calendar.WEEK_OF_YEAR,endDateCalendar);
                }
            }else{
                return getTimeDifference(startDateCalendar,betweenDate,Calendar.MONTH,endDateCalendar);
            }
        }else{
            return getTimeDifference(startDateCalendar,yearBetweenDate,Calendar.YEAR,endDateCalendar);
        }
        return timeFields;
    }

    private List<String> getTimeDifference(Calendar startDateCalendar,int timeDifference,int CalendarDateType,Calendar endDateCalendar){
        List<String> timeField = new ArrayList<>();
        int amount = 0;
        for(int i = 0;i< timeDifference;i++){
            startDateCalendar.add(CalendarDateType,amount);
            amount = amount ==0 ? ++amount : amount;
            timeField.add(DateFormatUtils.format(startDateCalendar.getTime(),"yyyy-MM-dd"));
        }
        timeField.add(DateFormatUtils.format(endDateCalendar.getTime(),"yyyy-MM-dd"));
        return timeField;
    }

    public Map<String,Object> getTimeDifference(String startDate, String endDate) throws ParseException {
        List<String> timeField = new ArrayList<>();
        //设置转换的日期格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //得到相差的天数 betweenDate
        Long betweenDate = (sdf.parse(endDate).getTime() - sdf.parse(startDate).getTime())/(60*60*24*1000);

        Map<String,Object> map = new HashMap<>();
        if(betweenDate == 0){
            //获取当天所有时间段
            map.put("isBetweenZero",true);
        }else{
            //获取两个时间内包含天数
            timeField = getBetweenDate(sdf.parse(startDate),sdf.parse(endDate));
            map.put("isBetweenZero",false);
        }
        map.put("timeField",timeField);
        return map;
    }

}
