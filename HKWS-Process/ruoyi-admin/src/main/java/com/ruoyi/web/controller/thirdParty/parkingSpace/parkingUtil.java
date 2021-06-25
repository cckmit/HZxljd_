package com.ruoyi.web.controller.thirdParty.parkingSpace;

/**
 * @author FanKaibiao
 * @date 2021-05-19-20:33
 */
public class parkingUtil {
    /**
     * 时间格式化
     */
    public static final String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
    /**
     * 对接系统的唯一标识
     */
    public static final String ACCOUNT = "10016";

    /**
     * 公钥加签
     * 私钥加密
     */
    public static final String PUBLIC_KEY = "LhTF9D5PBqPphUeHKBymEOYahmeutPrV";
    public static final String PRIVATE_KEY = "11rXSiLJehIwjBUX";

    /**
     * 请求地址
     */
    public static final String URL = "http://www.yuhangtingche.com/openapi/v1/xl";

    /**
     * METHOD
     */
    public static final String METHOD_PARKING_RECORD = "005002CCIN01";
    public static final String METHOD_ROAD_RECORD = "005002DCIN01";
}
