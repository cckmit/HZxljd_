package com.ruoyi.quartz.util;

import java.text.ParseException;
import java.util.Date;

import org.quartz.CronExpression;

/**
 * cron表达式工具类
 * 
 * @author ruoyi
 *
 */
public class CronUtils
{
    /**
     * 返回一个布尔值代表一个给定的Cron表达式的有效性
     *
     * @param cronExpression Cron表达式
     * @return boolean 表达式是否有效
     */
    public static boolean isValid(String cronExpression)
    {
        return CronExpression.isValidExpression(cronExpression);
    }

    /**
     * 返回一个字符串值,表示该消息无效Cron表达式给出有效性
     *
     * @param cronExpression Cron表达式
     * @return String 无效时返回表达式错误描述,如果有效返回null
     */
    public static String getInvalidMessage(String cronExpression)
    {
        try
        {
            new CronExpression(cronExpression);
            return null;
        }
        catch (ParseException pe)
        {
            return pe.getMessage();
        }
    }

    /**
     * 返回下一个执行时间根据给定的Cron表达式
     *
     * @param cronExpression Cron表达式
     * @return Date 下次Cron表达式执行时间
     */
    public static Date getNextExecution(String cronExpression)
    {
        try
        {
            CronExpression cron = new CronExpression(cronExpression);
            return cron.getNextValidTimeAfter(new Date(System.currentTimeMillis()));
        }
        catch (ParseException e)
        {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    /**
     *
     *方法摘要：构建Cron表达式
     *@param rate  频率 0秒；1分；2小时；3日；4月
      @param cycle 周期
     *@return String
     */
    public static String createLoopCronExpression(int rate, int cycle) {
        String cron = "";

        switch (rate) {
            case 0:// 每cycle秒执行一次
                cron = "0/" + cycle + " * * * * ?";
                break;
            case 1:// 每cycle分钟执行一次
                cron = "0 0/" + cycle + " * * * ?";
                break;
            case 2:// 每cycle小时执行一次
                cron = "0 0 0/" + cycle + " * * ?";
                break;
            case 3:// 每cycle天的0点执行一次
                cron = "0 0 0 1/" + cycle + " * ?";
                break;
        }
             return cron;
    }
    /**
     *
     *方法摘要：生成计划的详细描述
     *@param
     *@return String
     */
    public static String createLoopCronDescription(int rate, int cycle) {
        String desc = "";
        switch (rate) {
            case 0:// 每cycle秒执行一次
                desc = "每隔" + cycle + "秒触发一次任务";
                break;
            case 1:// 每cycle秒执行一次
                desc = "每隔" + cycle + "分钟触发一次任务";
                break;
            case 2:// 每cycle秒执行一次
                desc = "每隔" + cycle + "小时触发一次任务";
                break;
            case 3:// 每cycle秒执行一次
                desc = "每隔" + cycle + "天的0点触发一次任务";
                break;

        }
        return desc;
    }
    //参考例子
    public static void main(String[] args) {

        for(int i = 0;i < 10;i++){
            for(int j = 0;j < (10-1-i);j++){
                System.out.print(" ");
            }
            for(int k = 0;k < (2*i+1);k++){
                System.out.print("*");
            }
            System.out.println();
        }


    }
}
