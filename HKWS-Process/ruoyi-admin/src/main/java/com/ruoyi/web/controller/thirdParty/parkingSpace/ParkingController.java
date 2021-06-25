package com.ruoyi.web.controller.thirdParty.parkingSpace;

import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.system.domain.platform.parkingSpace.parkingParm;
import com.ruoyi.web.controller.thirdParty.parkingSpace.entity.*;
import com.ruoyi.web.controller.thirdParty.parkingSpace.util.AesUtil;
import com.ruoyi.web.controller.thirdParty.parkingSpace.util.GsonUtil;
import com.ruoyi.web.controller.thirdParty.parkingSpace.util.HttpPost;
import com.ruoyi.web.controller.thirdParty.parkingSpace.util.SignUtil;


import java.util.Date;

/**
 * @author FanKaibiao
 * @date 2021-05-19-20:32
 */
public class ParkingController {
    public static void main(String[] args) throws Exception {
        ParkingRequest req = new ParkingRequest();
        Content content=new Content();
        content.setMethod(parkingUtil.METHOD_ROAD_RECORD);
        content.setParams(req);
        try {
            String reponse = sendThirdRequest(GsonUtil.toJson(content));
            System.out.println(reponse);
            parkingParm parseObject = JSONObject.parseObject(reponse, parkingParm.class);
            if (!"000000".equals(parseObject.getCode())) {
                /*log.error("请求列表错误：{}",reponse);
                return R.failed("获取列表失败");*/

            }
//            return R.ok(parseObject.getData());
//            System.out.println(parseObject.getData());
        } catch (Exception e) {
//            log.error("请求列表错误",e);
        }

    }

    public void parking(){
        ParkingRequest req = new ParkingRequest();
        Content content=new Content();
        content.setMethod(parkingUtil.METHOD_PARKING_RECORD);
        content.setParams(req);
        try {
            String reponse = sendThirdRequest(GsonUtil.toJson(content));
            System.out.println(reponse);
            ParkingResponse parseObject = JSONObject.parseObject(reponse, ParkingResponse.class);
            if (!"000000".equals(parseObject.getCode())) {
                System.out.println("获取列表失败");
            }
            System.out.println(parseObject.getData());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void  parkingRoad(){
        ParkingRequest req = new ParkingRequest();
        Content content=new Content();
        content.setMethod(parkingUtil.METHOD_ROAD_RECORD);
        content.setParams(req);
        try {
            String reponse = sendThirdRequest(GsonUtil.toJson(content));
            System.out.println(reponse);
            ParkingResponse parseObject = JSONObject.parseObject(reponse,ParkingResponse.class);
            if (!"000000".equals(parseObject.getCode())) {
                /*log.error("请求列表错误：{}",reponse);
                return R.failed("获取列表失败");*/

            }
//            return R.ok(parseObject.getData());
//            System.out.println(parseObject.getData());
        } catch (Exception e) {
//            log.error("请求列表错误",e);
        }
    }

    private static String sendThirdRequest(String contentString) throws Exception {
        //请求参数组装
        RequestData requestData = new RequestData();
        requestData.setAccount(parkingUtil.ACCOUNT);
        String timestamp = DateUtil.format(new Date(), parkingUtil.YYYYMMDDHHMMSS);
        requestData.setTimestamp(timestamp);
        requestData.setSign(SignUtil.createSign(parkingUtil.ACCOUNT, timestamp, parkingUtil.PUBLIC_KEY));
        requestData.setContent(AesUtil.encryptCBC(contentString, parkingUtil.PRIVATE_KEY));
        //发送请求
        return HttpPost.sendJsonObject(parkingUtil.URL, requestData);
    }
}
