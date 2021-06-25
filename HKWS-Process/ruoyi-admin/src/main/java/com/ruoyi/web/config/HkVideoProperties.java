package com.ruoyi.web.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "hk-video")
public class HkVideoProperties {

    private String appKey;

    private String appSecret;

    private String host;
    /**实时视频请求url**/
    private String previewUrl;
    /**预警视频请求url**/
    private String playbackUrl;

    public HkVideoProperties(String appKey, String appSecret, String host, String previewUrl, String playbackUrl) {
        this.appKey = appKey;
        this.appSecret = appSecret;
        this.host = host;
        this.previewUrl = previewUrl;
        this.playbackUrl = playbackUrl;
    }

    public HkVideoProperties() {
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPreviewUrl() {
        return previewUrl;
    }

    public void setPreviewUrl(String previewUrl) {
        this.previewUrl = previewUrl;
    }

    public String getPlaybackUrl() {
        return playbackUrl;
    }

    public void setPlaybackUrl(String playbackUrl) {
        this.playbackUrl = playbackUrl;
    }
}
