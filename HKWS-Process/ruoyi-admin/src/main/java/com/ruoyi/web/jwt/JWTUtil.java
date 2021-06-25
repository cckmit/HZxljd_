package com.ruoyi.web.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.ruoyi.web.config.JWTConfigProperties;

import java.util.Date;

/**
 * @ProjectName: ruoyi
 * @Package: com.ruoyi.web.utils
 * @ClassName: JWTUtil
 * @Author: guohailong
 * @Description: JWT工具类
 * @Date: 2021/3/13 3:06
 * @Version: 1.0
 */
public class JWTUtil {

    /**
     * 获得token中的信息无需secret解密也能获得
     *
     * @return token中包含的用户名
     */
    public static String getUserInfo(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("userInfo").asString();
        } catch (JWTDecodeException e) {
            return null;
        }
    }

    /**
     * 生成签名
     *
     * @param userInfo 用户名
     * @return 加密的token
     */
    public static String sign(String userInfo, JWTConfigProperties jwtConfigProperties) {
        //过期时间
        Date date = new Date(System.currentTimeMillis() + (jwtConfigProperties.getExpire() * 1000));
        Algorithm algorithm = Algorithm.HMAC256(jwtConfigProperties.getSecret());
        // 附带username信息
        return JWT.create().withClaim("userInfo", userInfo).withExpiresAt(date).sign(algorithm);
    }
}
