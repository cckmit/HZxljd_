package com.ruoyi.web.controller.thirdParty.parkingSpace.util;


import org.apache.commons.lang.StringUtils;

/**
 * @author Created by jxl on 2018/11/9.
 */
public class SignUtil {
    /**
     * 签名串校验
     * 2018.9.25  kj  add
     *
     * @param account    账号
     * @param timeStamp  时间戳，yyyyMMddHHmmss
     * @param sign       待校验的签名串
     * @param privateKey 私钥
     * @return false-失败，true-成功
     */
    public static boolean checkSign(final String account, final String timeStamp, final String sign, final String privateKey) {
        //1.参数为空判断
        if (StringUtils.isBlank(account) || StringUtils.isBlank(sign) || StringUtils.isBlank(privateKey)
                || StringUtils.isBlank(timeStamp) || timeStamp.length() != 14) {
            return false;
        }

        //2.待MD5加密的字符串
        String tempStr = account + timeStamp + privateKey;

        //3.MD5签名结果
        String tempSign = VerifyUtil.encodeByMD5(tempStr).toLowerCase();

        return sign.equals(tempSign);
    }

    /**
     * 生成签名串
     * 2018.9.25  kj  add
     *
     * @param account    账号
     * @param timeStamp  时间戳，yyyyMMddHHmmss
     * @param privateKey 私钥
     * @return 成功-签名串，失败-null
     */
    public static String createSign(final String account, final String timeStamp, final String privateKey) {
        //1.参数为空判断
        if (StringUtils.isBlank(account) || StringUtils.isBlank(privateKey) || StringUtils.isBlank(timeStamp) || timeStamp.length() != 14) {
            return null;
        }

        //2.待MD5加密的字符串
        String tempStr = account + timeStamp + privateKey;

        return VerifyUtil.encodeByMD5(tempStr).toLowerCase();
    }
}
