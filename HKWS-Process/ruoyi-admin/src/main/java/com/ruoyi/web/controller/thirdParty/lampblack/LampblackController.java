package com.ruoyi.web.controller.thirdParty.lampblack;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author FanKaibiao
 * @date 2021-05-19-14:27
 * 油烟数据每天凌晨更新获取前一天的数据
 */
@Component
public class LampblackController {

    private String youyanToken="";

//    @Scheduled(cron="0 0 1 * * ?")
    public void youyan(){
        Map<String, Object> map = new HashMap<>();
        Calendar instance = Calendar.getInstance();
        instance.setTime(new Date());
        instance.add(instance.DAY_OF_MONTH,-1);
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        String format = dateFormat.format(instance.getTime());
        System.out.println(format);
        map.put("AcquitDate",format);
        map.put("Page",1);
        map.put("PerPage",20);
        if(!youyanToken.equals("")){
            String token=youyanToken;
            String  req= JSON.toJSONString(map);
            String result = HttpRequest.post("http://admin.hzmingrui.cn/admin/queryDataDetectorDaily2")
                    .header("auth", token)
                    .body(req)
                    .execute().body();
            System.out.println(result);

        }else{
            String token=String();
            String  req= JSON.toJSONString(map);
            String result = HttpRequest.post("http://admin.hzmingrui.cn/admin/queryDataDetectorDaily2")
                    .header("auth", token)
                    .body(req)
                    .execute().body();
            System.out.println(result);

        }


    }


    /**
     * 获取油烟数据的token
     * @return
     */
    public String  String(){
        Map<String, Object> map = new HashMap<>();
        map.put("username","18086081029");
        map.put("password","123456");
        map.put("NoCode",true);
        String  req= JSON.toJSONString(map);
        String response = HttpUtil.post("http://admin.hzmingrui.cn/loginAction",req);
        if(response.equals(null)){
            System.out.println("未获得数据");
        }
        JSONObject jsonObject = JSON.parseObject(response);
        String s = JSON.toJSONString(jsonObject);
        String data = jsonObject.getString("Data");
        if(data.equals(null)){
            System.out.println("获取失败");
        }
        JSONObject jsonData = JSON.parseObject(data);
        String token = jsonData.getString("Token");
        youyanToken=token;
        return token;
    }
}


