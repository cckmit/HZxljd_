package com.ruoyi.web.controller.thirdParty.smart;

import com.alibaba.fastjson.JSON;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.system.domain.XlVillageModel;
import com.ruoyi.system.domain.platform.hkManCar.hkAreaEquipment.ResidentialEquipmentParm;
import com.ruoyi.system.domain.platform.hkManCar.hkCarCapture.CarCaptureParm;
import com.ruoyi.system.domain.platform.hkManCar.hkFaceCapture.FaceParm;
import com.ruoyi.system.domain.platform.hkManCar.hkGeneralEquipment.GeneralParm;
import com.ruoyi.system.domain.platform.hkManCar.hkQuarters.QuartersParm;
import com.ruoyi.system.domain.platform.hkManCar.hkResidentialHours.HourParm;
import com.ruoyi.system.domain.platform.hkManCar.hkResidentialUser.ResidentiaUserParm;
import com.ruoyi.system.service.IXlVillageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @author FanKaibiao
 * @date 2021-05-27-16:31
 * 人脸车辆信息--海康推送
 */
@RestController
@RequestMapping("/VIID")
public class SmartCommunityController {
    //小区
    @Autowired
    private IXlVillageService iXlVillageService;

    /**
     * 注册
     * @param param
     * @param request
     * @return
     */
    @PostMapping("/System/Register")
    public ResponseStatusObjectResponse register(@RequestBody RegisterRequest param, HttpServletRequest request){

//        log.info("收到设备:{}注册", JSON.toJSONString(param));

        ResponseStatusObjectResponse res=new ResponseStatusObjectResponse();
        res.setRequestURL(request.getRequestURI());
        res.setStatusCode("0");
        res.setStatusString("success");
        return res;
    }

    /**
     * 保活
     * @param param
     * @param request
     * @return
     */
    @PostMapping("/System/Keepalive")
    public ResponseStatusObjectResponse keepalive(@RequestBody KeepaliveRequest param,HttpServletRequest request){

        String userIdentify = request.getHeader("User-Identify");
        System.out.println("收到保活userIdentify:{}"+userIdentify);
//        log.info("收到保活userIdentify:{}", userIdentify);
//        User-Identify: 33018200000000000001  //采集系统编码，上级提供

//        log.info("收到保活request:{}", JSON.toJSONString(param));
        System.out.println("收到保活request:{}"+JSON.toJSONString(param));
        ResponseStatusObjectResponse res=new ResponseStatusObjectResponse();
        res.setRequestURL(request.getRequestURI());
        res.setStatusCode("0");
        res.setStatusString("success");
        return res;
    }
    //小区信息
    @PostMapping("/Communities")
    public AjaxResult communities(@RequestBody QuartersParm quartersParm){
        XlVillageModel xlVillageModel = new XlVillageModel();
        for(int i=0;i<quartersParm.getCommunityInfoListObject().getCommunityInfoObject().size();i++){
            //小区code
            xlVillageModel.setCode(quartersParm.getCommunityInfoListObject().getCommunityInfoObject().get(i).getCommunityID());
            //小区名称
            xlVillageModel.setName(quartersParm.getCommunityInfoListObject().getCommunityInfoObject().get(i).getCommunityName());
            //小区详细地址
            String communityAddress = quartersParm.getCommunityInfoListObject().getCommunityInfoObject().get(i).getCommunityAddress();
            //小区物业电话
            xlVillageModel.setPropertyName(quartersParm.getCommunityInfoListObject().getCommunityInfoObject().get(i).getPropertyCompanyPhoneNumber());
            xlVillageModel.setCreateTime(new Date());
//            iXlVillageService.insertXlVillage(xlVillageModel);
        }
        System.out.println(quartersParm.getCommunityInfoListObject().getCommunityInfoObject().get(0).getCommunityName());
        return AjaxResult.success();
    }

    //通用设备
    @PostMapping("/APEs")
    public AjaxResult apes(@RequestBody GeneralParm generalParm){
        System.out.println("小区通用设备"+generalParm.getAPEListObject().getAPEObject().get(0).getName());
        return AjaxResult.success();
    }

    //人脸抓拍
    @PostMapping("/Faces")
    public AjaxResult faces(@RequestBody FaceParm faceParm){

        return AjaxResult.success();
    }

    //机动车抓怕
    @PostMapping("/MotorVehicles")
    public AjaxResult motorVehicles(@RequestBody CarCaptureParm carCaptureParm){

        return AjaxResult.success();
    }

    //小区人员
    @PostMapping("/Community/PersonInfos")
    public AjaxResult PersonInfos(@RequestBody ResidentiaUserParm residentiaUserParm){

        System.out.println("小区人员信息"+residentiaUserParm.getPersonInfoListObject().getPersonInfoObject().get(0).getAddress());
        return AjaxResult.success();
    }

    //小区房屋
    @PostMapping("/Community/HouseInfos")
    public AjaxResult HouseInfos(@RequestBody HourParm hourParm){
        System.out.println("小区房屋信息"+hourParm.getHouseInfoListObject().getHouseInfoObject().get(0).getHouseName());
        return AjaxResult.success();
    }

    //小区设备
    @PostMapping("/Community/Devices")
    public AjaxResult Devices(@RequestBody ResidentialEquipmentParm residentialEquipmentParm){
        System.out.println("小区设备信息"+residentialEquipmentParm.getDeviceListObject().getDeviceObject().get(0).getName());
        return AjaxResult.success();
    }

}
