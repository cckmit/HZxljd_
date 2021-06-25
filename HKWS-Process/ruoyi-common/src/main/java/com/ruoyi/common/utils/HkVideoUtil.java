package com.ruoyi.common.utils;

public class HkVideoUtil {



    private String http = "https://192.170.1.70:443/api/video/v1/cameras/previewURLs";
    private String httpMethod = "POST";
    private String accept;
    private String contentMD5;
    private String contentType;
    private String date;
    private String hearder;
    private String ur;
    private String appSecret = "j4jyrStk4KHcWtGg31nZ";


    /*{
        "cameraIndexCode": "748d84750e3a4a5bbad3cd4af9ed5101",
            "streamType": 0,
            "protocol": "rtsp",
            "transmode": 1,
            "expand": "transcode=0",
            "streamform": "ps"
    }*/

//    public String requestParams(String cameraIndexCode){
//        HTTP METHOD + "\n" +
//                Accept + "\n" +     //建议显示设置 Accept Header，部分 Http 客户端当 Accept 为空时会给 Accept
//                设置默认值：*/*，导致签名校验失败。
//         Content-MD5  + "\n" +
//         Content-Type + "\n" +
//         Date + "\n" +
//         Headers +
//         Url
//
//    }
}
