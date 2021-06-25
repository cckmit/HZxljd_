package com.ruoyi.common.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UrlReplaceUtil {

    /**
     * 文件域名替换
     */
    public static String originUrl1;

    public static String targetUrl1;

    public static String originUrl2;

    public static String targetUrl2;

    public static String originUrl3;

    public static String targetUrl3;

    public static String originUrl4;

    public static String targetUrl4;

    public static String originUrl5;

    public static String targetUrl5;

    /****青山云外网图片域名***/
    /*@Value("${replace.origin-url.part1}")
    public void setOriginUrl1(String originUrl1){
        UrlReplaceUtil.originUrl1 = originUrl1;
    }*/

    /****青山云外网图片域名***/
    /*@Value("${replace.target-url.part1}")
    public void setTargetUrl1(String targetUrl1){
        UrlReplaceUtil.targetUrl1 = targetUrl1;
    }*/

    /****应急消防 文件域名***/
    /*@Value("${replace.origin-url.part2}")
    public void setOriginUrl2(String originUrl2){
        UrlReplaceUtil.originUrl2 = originUrl2;
    }*/

    /****应急消防 文件域名***/
    /*@Value("${replace.target-url.part2}")
    public void setTargetUrl2(String targetUrl2){
        UrlReplaceUtil.targetUrl2 = targetUrl2;
    }*/

    /****综合治理 文件域名***/
    @Value("${replace.origin-url.part3}")
    public void setOriginUrl3(String originUrl3){
        UrlReplaceUtil.originUrl3 = originUrl3;
    }

    /****综合治理 文件域名***/
    @Value("${replace.target-url.part3}")
    public void setTargetUrl3(String targetUrl3){
        UrlReplaceUtil.targetUrl3 = targetUrl3;
    }

    /****城管 文件域名***/
    @Value("${replace.origin-url.part4}")
    public void setOriginUrl4(String originUrl4){
        UrlReplaceUtil.originUrl4 = originUrl4;
    }

    /****城管 文件域名***/
    @Value("${replace.target-url.part4}")
    public void setTargetUrl4(String targetUrl4){
        UrlReplaceUtil.targetUrl4 = targetUrl4;
    }

    /****应急 文件域名***/
    @Value("${replace.origin-url.part5}")
    public void setOriginUrl5(String originUrl5){
        UrlReplaceUtil.originUrl5 = originUrl5;
    }

    /****应急 文件域名***/
    @Value("${replace.target-url.part5}")
    public void setTargetUrl5(String targetUrl5){
        UrlReplaceUtil.targetUrl5 = targetUrl5;
    }


    public static String replaceFileUrl(String filePath){
        if(!StringUtils.isEmpty(filePath)){
            /*if(filePath.indexOf(originUrl1) > -1){
                filePath = filePath.replace(originUrl1,targetUrl1);
            }else if(filePath.indexOf(originUrl2) > -1){
                filePath = filePath.replace(originUrl2,targetUrl2);
            }else */
            if(filePath.indexOf(originUrl3) > -1){
                filePath = filePath.replace(originUrl3,targetUrl3);
            }else if(filePath.indexOf(originUrl4) > -1){
                filePath = filePath.replace(originUrl4,targetUrl4);
            }else if(filePath.indexOf(originUrl5) > -1){
                filePath = filePath.replace(originUrl5,targetUrl5);
            }
        }
        return filePath;
    }
}
