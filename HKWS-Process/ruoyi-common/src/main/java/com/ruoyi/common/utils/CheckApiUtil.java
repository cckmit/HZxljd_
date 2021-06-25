package com.ruoyi.common.utils;

import com.ruoyi.common.config.Global;
import com.ruoyi.common.constant.ShiroConstants;
import com.ruoyi.common.json.JSON;
import com.ruoyi.common.json.JSONObject;
import com.ruoyi.common.utils.http.HttpUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 获取地址类
 * 
 * @author ruoyi
 */
public class CheckApiUtil
{
    public Map<String,Object> checkApi(String[] token){
        Map<String,Object> result = new HashMap<>();
        String header = ServletUtils.getRequest().getHeader(ShiroConstants.HEADER_API_TOKEN_NAME);
        if(StringUtils.isEmpty(header)){
            result.put("success",false);
            result.put("msg","无效请求");
        }else{
            for(String str : token){
                String[] arr = str.split("-");
                if(arr[0].equals(header)){
                    if(arr[1].equals("platone")){
                        result.put("platName","综治平台");
                        result.put("platCode","1003");
                    }else if(arr[1].equals("plattwo")){
                        result.put("platName","城管系统");
                        result.put("platCode","1001");
                    }else if(arr[1].equals("platthree")){
                        result.put("platName","应急消防系统");
                        result.put("platCode","1002");
                    }else if(arr[1].equals("platfour")){
                        result.put("platName","青山云系统");
                        result.put("platCode","1004");
                    }else if(arr[1].equals("platfive")){
                        result.put("platName","新临居");
                        result.put("platCode","1005");
                    }
                    result.put("success",true);
                    return result;
                }else{
                    result.put("success",false);
                    result.put("msg","token错误或已失效！");
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(UUID.randomUUID().toString().replaceAll("-",""));
    }
}
