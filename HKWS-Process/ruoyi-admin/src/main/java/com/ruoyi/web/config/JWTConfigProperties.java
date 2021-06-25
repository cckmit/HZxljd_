package com.ruoyi.web.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @ProjectName: ruoyi
 * @Package: com.ruoyi.web.config
 * @ClassName: WebConfig
 * @Author: guohailong
 * @Description: jwt配置类
 * @Date: 2021/3/13 2:06
 * @Version: 1.0
 */
@Component
@ConfigurationProperties(prefix = "jwt")
public class JWTConfigProperties {

    private Long expire;

    private String secret;

    private String header;

    private String cachePrefix;

    public JWTConfigProperties(Long expire, String secret, String header, String cachePrefix) {
        this.expire = expire;
        this.secret = secret;
        this.header = header;
        this.cachePrefix = cachePrefix;
    }

    public JWTConfigProperties() {


    }

    public Long getExpire() {
        return expire;
    }

    public void setExpire(Long expire) {
        this.expire = expire;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getCachePrefix() {
        return cachePrefix;
    }

    public void setCachePrefix(String cachePrefix) {
        this.cachePrefix = cachePrefix;
    }
}