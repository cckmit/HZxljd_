package com.ruoyi.system.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.utils.http.HttpUtils;
import com.ruoyi.system.domain.sms.NormalSmsDto;
import com.ruoyi.system.domain.sms.TemplateSmsDto;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class SmsUtil {

    private static Logger logger = LoggerFactory.getLogger(SmsUtil.class);

    public static String url;

    public static String apId;

    public static String ecName;

    public static String sign;

    public static String secretKey;

    @Value("${sms.url}")
    public void setUrl(String url) {
        SmsUtil.url = url;
    }
    @Value("${sms.apId}")
    public void setApId(String apId) {
        SmsUtil.apId = apId;
    }

    @Value("${sms.ecName}")
    public void setEcName(String ecName) {
        SmsUtil.ecName = ecName;
    }

    @Value("${sms.sign}")
    public void setSign(String sign) {
        SmsUtil.sign = sign;
    }

    @Value("${sms.secretKey}")
    public void setSecretKey(String secretKey) {
        SmsUtil.secretKey = secretKey;
    }

    /**
     * 普通短信
     * @param phone
     * @param content
     * @param addSerial
     * @return
     */
    public static Map<String,Object> normalSend(String phone,String content,String addSerial){
        return sendSms(phone,content,null,null,addSerial,"1");
    }

    /**
     * 模板短信
     * @param phone
     * @param templateId
     * @param param
     * @param addSerial
     * @return
     */
    public static Map<String,Object> templateSend(String phone,String templateId,String param,String addSerial){
        return sendSms(phone,null,templateId,param,addSerial,"2");
    }

    /**
     * @param phone         手机号
     * @param content       短信内容（普通短信）
     * @param templateId    模板ID（模板短信）
     * @param param         模板参数值（模板短信）
     * @param addSerial     扩展码
     * @param type          1普通短信，2模板短信
     * @return
     */
    public static Map<String,Object> sendSms(String phone, String content, String templateId, String param, String addSerial, String type){
        String httpUrl = url;
        StringBuffer sb = new StringBuffer();
        Map<String,Object> result = new HashMap<>();
        String mac = "";
        String reqText = "";
        if("1".equals(type)){//普通短信
            httpUrl = httpUrl+"norsubmit";
            NormalSmsDto normal = new NormalSmsDto();
            normal.setEcName(ecName);
            normal.setApId(apId);
            //template.setSecretKey(secretKey);
            normal.setMobiles(phone);
            normal.setContent(content);
            normal.setSign(sign);
            normal.setAddSerial(addSerial);
            sb.append(ecName)
                    .append(apId)
                    .append(secretKey)
                    .append(phone)
                    .append(content)
                    .append(sign)
                    .append(addSerial);
            mac = DigestUtils.md5Hex(sb.toString()).toLowerCase();
            normal.setMac(mac);
            reqText = JSON.toJSONString(normal);
        }else{//模板短信
            httpUrl = httpUrl+"tmpsubmit";
            TemplateSmsDto template = new TemplateSmsDto();
            template.setEcName(ecName);
            template.setApId(apId);
            //template.setSecretKey(secretKey);
            template.setParams(param);
            template.setMobiles(phone);
            template.setAddSerial(addSerial);
            template.setSign(sign);
            template.setTemplateId(templateId);
            sb.append(ecName)
                    .append(apId)
                    .append(secretKey)
                    .append(templateId)
                    .append(phone)
                    .append(param)
                    .append(sign)
                    .append(addSerial);
            mac = DigestUtils.md5Hex(sb.toString()).toLowerCase();
            template.setMac(mac);
            reqText = JSON.toJSONString(template);
        }
        //加密
        String encode = Base64.encodeBase64String(reqText.getBytes());
        logger.info("短信请求参数 = "+encode);
        String backMsg = HttpUtils.sendPost(httpUrl, encode);
        logger.info("短信返回信息 = "+backMsg);
        JSONObject json = JSONObject.parseObject(backMsg);
        result.put("success",true);
        if(!json.getBoolean("success")){
            result.put("success",false);
            if("IllegalMac".equals(json.getString("rspcod"))){
                result.put("msg","mac校验不通过。");
            }else if("IllegalSignId".equals(json.getString("rspcod"))){
                result.put("msg","无效的签名编码。");
            }else if("InvalidMessage".equals(json.getString("rspcod"))){
                result.put("msg","非法消息，请求数据解析失败。");
            }else if("InvalidUsrOrPwd".equals(json.getString("rspcod"))){
                result.put("msg","非法用户名/密码。");
            }else if("NoSignId".equals(json.getString("rspcod"))){
                result.put("msg","未匹配到对应的签名信息。");
            }else if("TooManyMobiles".equals(json.getString("rspcod"))){
                result.put("msg","手机号数量超限（>5000），应≤5000。");
            }
        }else{
            result.put("msg","成功");
        }
        return result;
    }


}
