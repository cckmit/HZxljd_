package com.ruoyi.web.utils;

import com.alibaba.fastjson.JSONObject;
import com.hikvision.artemis.sdk.ArtemisHttpUtil;
import com.hikvision.artemis.sdk.config.ArtemisConfig;
import com.ruoyi.web.config.HkVideoProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

@Component
public class HkVideoUtils {

    public static void sendSecret(HkVideoProperties properties){
        ArtemisConfig.appKey = properties.getAppKey();
        ArtemisConfig.appSecret = properties.getAppSecret();
        ArtemisConfig.host = properties.getHost();
    }

    public static String getRealTimeVideo(String cameraIndexCode,HkVideoProperties properties){
        sendSecret(properties);
        String url = properties.getPreviewUrl();
        Map<String, String> map = new HashMap();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("cameraIndexCode",cameraIndexCode);
        jsonObject.put("protocol","hls");
        map.put("https://", url);
        String result = ArtemisHttpUtil.doPostStringArtemis(map, jsonObject.toJSONString(), null, null, "application/json");
        System.out.println(result);
        JSONObject resultJson = JSONObject.parseObject(result);
        if("0".equals(resultJson.getString("code"))){
            return resultJson.getJSONObject("data").getString("url");
        }
        return resultJson.getString("msg");
    }

    public static String getPlayBackVideo(String cameraIndexCode,String reportTime,int beginMin,int endMin,HkVideoProperties properties){
        sendSecret(properties);
        String url = properties.getPlaybackUrl();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        Date parse = null;
        try{
            TimeZone tz = TimeZone.getTimeZone("Asia/Shanghai");
            df.setTimeZone(tz);
            parse = sdf.parse(reportTime);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        Date startTime = new Date(parse.getTime() - 1000 * 60 * beginMin);
        Date endTime = new Date(parse.getTime() + 1000 * 60 * endMin);
        Map<String, String> map = new HashMap();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("cameraIndexCode",cameraIndexCode);
        jsonObject.put("protocol","rtmp");
        jsonObject.put("needReturnClipInfo",true);
        jsonObject.put("expand","streamform=ts");
        jsonObject.put("beginTime",df.format(startTime));
        jsonObject.put("endTime",df.format(endTime));
        map.put("https://", url);
        String result = ArtemisHttpUtil.doPostStringArtemis(map, jsonObject.toJSONString(), null, null, "application/json");
        System.out.println(result);
        JSONObject resultJson = JSONObject.parseObject(result);
        if("0".equals(resultJson.getString("code"))){
            return resultJson.getJSONObject("data").getString("url");
        }

        return null;
    }

}
