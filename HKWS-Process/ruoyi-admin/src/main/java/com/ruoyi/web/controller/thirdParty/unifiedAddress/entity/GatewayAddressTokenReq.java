package com.ruoyi.web.controller.thirdParty.unifiedAddress.entity;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import cn.hutool.json.JSONUtil;
import com.ruoyi.common.utils.security.Md5Utils;
import com.ruoyi.web.controller.thirdParty.enterprise.Md5Utilss;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;


/**
* @author xyq
* @date 2020年12月23日
* 类说明:
*/
public class GatewayAddressTokenReq {

	private  String user;
	private  String pwd;
	
    private String secret;
    private String time;

    public  Map<String, Object> getUrlBody() {

        System.out.println(user+""+pwd);
        time = System.currentTimeMillis()+ "";
        String key = time+pwd;
        secret = Md5Utilss.md52(key);
        
        Map<String, Object> m = new HashMap<String, Object>();
		m.put("user", user);
		m.put("secret", secret);
		m.put("time", time);
        return m;
    }
    
    public static void main(String[] args) {
   	 String user = "user";
        String pwd = "123";
        String secret;
        String time;
       StringBuffer sb = new StringBuffer();
       time = System.currentTimeMillis()+"";
       String key = time+pwd;
       secret = Md5Utilss.md52(key);
       sb = sb.append("user=").append(user)
               .append("&").append("time=").append(time)
               .append("&").append("secret=").append(secret);
       System.out.println(sb.toString());
       System.out.println(new Date());
	}

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}