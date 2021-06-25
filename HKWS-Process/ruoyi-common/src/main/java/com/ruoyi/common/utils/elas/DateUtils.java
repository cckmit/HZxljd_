package com.ruoyi.common.utils.elas;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {


    public static String getDateTime() throws ParseException, ParseException {
        Date date=new Date();
        DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time=format.format(date);//time就是bai当du前zhi时dao间专属
        return format.format(date);
    }
}