package com.ruoyi.web.controller.app;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.HkEarlyWarning.HkEventInfo;
import com.ruoyi.system.domain.HkEntity.EventDTO;
import com.ruoyi.system.domain.HkEntity.EventInfoDTO;
import com.ruoyi.system.domain.app.WxHkEventVo;
import com.ruoyi.system.domain.app.appHkevent;
import com.ruoyi.system.service.HkEarlyWarning.HkEventService;
import com.ruoyi.system.service.app.AppEventInfoService;
import com.ruoyi.system.utils.BaseUtlis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: data-ruoyi
 * @description: app-事件概要查询
 * @author: Yang-Teng-Fei
 * @create: 2020-12-10 13:16
 **/
@Controller
//@RequestMapping("/appEventInfo")
public class AppEventInfoController extends BaseController {
    @Autowired
    private AppEventInfoService appEventInfoService;

    @Autowired
    private HkEventService hkEventService;

    /**图片显示地址**/
    @Value("${img.show-url}")
    private String imgUrls;

    @Value("${img.path}")
    private String pathImg;

    /*图片存储地址*/
    @Value("${img.upload-url}")
    private String uploadUrl;

    /**
     *
     * 查询事件概要查询
     * @param eventTypeName
     * @param userId
     * @param eventTitle
     * @param eventAlertStatus
     * @param pageNum
     * @param pageSize
     * @return
     */
    /*@GetMapping("/selectOneHkevent")
    @ResponseBody
    public AjaxResult selectOneHkevent(String eventTypeName,
                                       Long userId,
                                       String eventTitle,
                                       Integer eventAlertStatus,
                                       Integer pageNum ,
                                       Integer pageSize ){
        Map res = new HashMap();
        res.put("userId",userId);
        res.put("eventTypeName",eventTypeName);
        res.put("eventTitle",eventTitle);
        res.put("eventAlertStatus",eventAlertStatus);
        if(userId==null){
            return AjaxResult.error("用户id不能为空");
        }
        if(pageNum==null ||  pageSize==null){
            return AjaxResult.error("分页不能为空");
        }
        if(eventAlertStatus==null){
            eventAlertStatus=3;
        }
        if(eventAlertStatus==9){
            // 查询当前登陆人的已逾期事件
            Page<appHkevent> pages = PageHelper.startPage(pageNum, pageSize);
            List<appHkevent> appHkeventList = appEventInfoService.selectOverduEvent(res);
            if(appHkeventList.size()==0){
                return AjaxResult.success("当前用户暂时没有数据");
            }
            for(appHkevent event : appHkeventList){
                // 获取当前时间
                Date date1 = new Date();
                String nowDayTime = String.valueOf(date1.getTime()/1000);
                // 获取逾期时间
                Date date = event.getTimeOut();
                String timestamp = String.valueOf(date.getTime()/1000);
                Integer time = Integer.valueOf(timestamp);
                Integer times = Integer.valueOf(nowDayTime);
                // 得出逾期时间
                Integer overTime = times-time;
                event.setOverTime(overTime);
                *//*event.setEventImage(UrlReplaceUtil.replaceFileUrl(event.getEventImage()));*//*
            }
            res.put("appHkeventList",appHkeventList);
            res.put("pageTotal",pages.getTotal());
            // 当前页
            res.put("pageNum",pageNum);
            res.put("pageSize",pageSize);
            res.put("page",pages.getPages());
            // 每页显示数
            return AjaxResult.success(res);
        }
        if(eventAlertStatus==3) {
            // 查询当前登陆人的待处理事件
            Page<appHkevent> pages = PageHelper.startPage(pageNum, pageSize);
            List<appHkevent> appHkeventList = appEventInfoService.selectOneHkevent(res);
            if (appHkeventList.size() == 0) {
                return AjaxResult.success("当前用户暂时没有数据");
            }
            for (int i = 0; i <appHkeventList.size() ; i++) {
                // 获取当前时间
                Date date1 = new Date();
                String nowDayTime = String.valueOf(date1.getTime()/1000);
                // 获取待处理时间
                Date date=appHkeventList.get(i).getTimeOut();
                String timestamp = String.valueOf(date.getTime()/1000);
                // 得出待处理时间
                Integer time=Integer.valueOf(timestamp);
                Integer times=Integer.valueOf(nowDayTime);
                Integer overTime=time-times;
                appHkeventList.get(i).setPengTime(overTime);
            }
            res.put("appHkeventList", appHkeventList);
            res.put("pageTotal", pages.getTotal());
            res.put("pageNum", pageNum);
            res.put("pageSize",pageSize);
            res.put("page", pages.getPages());
            return AjaxResult.success(res);
        }
        if(eventAlertStatus==6) {
            // 查询当前登陆人的已完成事件
            Page<appHkevent> pages = PageHelper.startPage(pageNum, pageSize);
            List<appHkevent> appHkeventList = appEventInfoService.selectCompletedEvent(res);
            if (appHkeventList.size() == 0) {
                return AjaxResult.success("当前用户暂时没有数据");
            }
            res.put("appHkeventList", appHkeventList);
            res.put("pageTotal", pages.getTotal());
            res.put("pageNum", pageNum);
            res.put("pageSize",pageSize);
            res.put("page", pages.getPages());
            return AjaxResult.success(res);
        }else {
            return AjaxResult.error("服务器错误，请联系管理员");
        }

    }

    *//**
     * 公众号待处理事件列表
     * @param vo
     * @return
     *//*
    @PostMapping("/selectTwoHkEvent")
    @ResponseBody
    public AjaxResult selectTwoHkEvent(WxHkEventVo vo){
        Map<String,Object> param = new HashMap<>();
        Page<appHkevent> pages = PageHelper.startPage(vo.getPageNum(), vo.getPageSize());
        if(StringUtils.isNull(vo.getUserId())){
            return AjaxResult.error("用户id不能为空");
        }
        List<appHkevent> appHkeventList = appEventInfoService.selectTwoHkEvent(vo);
        for(appHkevent event : appHkeventList){
            // 获取当前时间
            Date date1 = new Date();
            String nowDayTime = String.valueOf(date1.getTime()/1000);
            // 获取逾期时间
            Date date=event.getTimeOut();
            String timestamp = String.valueOf(date.getTime()/1000);
            Integer time=Integer.valueOf(timestamp);
            Integer times=Integer.valueOf(nowDayTime);
            // 得出逾期时间
            Integer overTime=times-time;
            event.setOverTime(overTime);
        }
        param.put("appHkeventList", appHkeventList);
        param.put("pageTotal", pages.getTotal());
        param.put("pageNum", vo.getPageNum());
        param.put("pageSize",vo.getPageSize());
        param.put("page", pages.getPages());
        return AjaxResult.success(param);
    }

    *//**
     * 事件上报
     * @param eventInfo
     * @return
     *//*
    @PostMapping("/addReportEvent1")
    @ResponseBody
    public AjaxResult addReportEvent(@RequestBody EventInfoDTO eventInfo){
        EventDTO eventinfo = eventInfo.getEvent();
        HkEventInfo hkEventInfo = new HkEventInfo();
        hkEventInfo.setRegionIndexCode(eventInfo.getRegionIndexCode());
         String types="";
         String typps="";
        if (eventinfo.getEventTypeName().equals("机动车违停")){
            types="spi";
        }
        if (eventinfo.getEventTypeName().equals("非机动车违停")){
            types="spi";
        }
        if (eventinfo.getEventTypeName().equals("游商摊贩")){
            types="spi";
        }
        if (eventinfo.getEventTypeName().equals("人员聚集")){
            types="spi";
        }
        if (eventinfo.getEventTypeName().equals("出店经营")){
            types="ocos";
        }
        if (eventinfo.getEventTypeName().equals("沿街晾晒")){
            types="ocos";
        }
        if (eventinfo.getEventTypeName().equals("违规宣传物")){
            types="ocos";
        }
        if (eventinfo.getEventTypeName().equals("垃圾堆积")){
            types="ocos";
        }
        if (eventinfo.getEventTypeName().equals("消防通道违规占用")){
            types="spi";
            typps="fireExitOccupy";
        }

        hkEventInfo.setComponentId(types);
        hkEventInfo.setRegionName(eventInfo.getRegionName());
        hkEventInfo.setPlaceName(eventInfo.getPlaceName());
        hkEventInfo.setEventId(UUID.randomUUID().toString().trim().replaceAll("-", ""));
        hkEventInfo.setEventIndexCode(UUID.randomUUID().toString().trim().replaceAll("-", ""));//海康事件唯一标识
        hkEventInfo.setEventTitle(eventinfo.getEventTitle());
        hkEventInfo.setEventAddress(eventinfo.getEventAddress());
        hkEventInfo.setReportTime(eventinfo.getReportTime());
        hkEventInfo.setEventType(typps);
        hkEventInfo.setEventTypeName(eventinfo.getEventTypeName());
        hkEventInfo.setRegionIndexCode(eventInfo.getRegionIndexCode());
        hkEventInfo.setCameraName(eventinfo.getEventAddress());
        //   图片处理
        String fileName =UUID.randomUUID().toString().trim().replaceAll("-", "");
        String base64=eventinfo.getEventImage();
        String type= BaseUtlis.checkImageBase64Format(base64);
        String path=pathImg+fileName+"."+type;
        String url = uploadUrl+fileName+"."+type;
        BaseUtlis.base64StrToImage(base64,url);
        hkEventInfo.setEventImage(path);
        hkEventInfo.setEventThumbnailImage(path);
        //
        hkEventInfo.setStorageId(eventinfo.getStorageId());
        hkEventInfo.setEventAlertStatus(2);
        hkEventInfo.setEventAlertStatusName("研判中");
        hkEventInfo.setReportType(eventinfo.getReportType());
        hkEventInfo.setReportTypeName(eventinfo.getReportTypeName());
        hkEventInfo.setLawEnforcementType(eventinfo.getLawEnforcementType());
        hkEventInfo.setLawEnforcementTypeName(eventinfo.getLawEnforcementTypeName());
        hkEventInfo.setRiskLevel(eventinfo.getRiskLevel());
        hkEventInfo.setCurrentProcessorId(eventinfo.getCurrentProcessorId());
        hkEventInfo.setCurrentProcessorName(eventinfo.getCurrentProcessorName());
        hkEventInfo.setEventUpdateTime(eventinfo.getEventUpdateTime());
        hkEventInfo.setCreateTime(new Date());
        int count=hkEventService.addHKEventInfo(hkEventInfo);
        if(count>0){
            return AjaxResult.success("添加成功");
    }else {
            return AjaxResult.error("添加失败");
        }
    }*/



    /*@PostMapping("addReportEvent")
    @ResponseBody
    public AjaxResult reportEvent(@RequestBody EventReportVo vo){
        HkEventInfo event = vo.getEvent();
        PointDTO point = vo.getPoint();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        //SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        if(event == null){
            return AjaxResult.error("事件信息不能为空");
        }
        if(vo.getPoint() == null){
            return AjaxResult.error("事件信息不能为空");
        }
        if(StringUtils.isEmpty(event.getEventTitle())){
            return AjaxResult.error("事件标题不能为空");
        }
        if(StringUtils.isEmpty(event.getEventAddress())){
            return AjaxResult.error("事件地址不能为空");
        }
        if(StringUtils.isEmpty(event.getReportTime())){
            return AjaxResult.error("事件上报时间不能为空");
        }
        Date eventCreateTime = DateUtils.parseDate(event.getReportTime());
        event.setEventCreateTime(dateFormat.format(eventCreateTime));
        if(event.getExtendInt1() == null){
            return AjaxResult.error("平台编码不能为空不能为空");
        }
        if(event.getExtendInt1() ==1001){//城管事件
            event.setEventTypeName("城管事件");
        }else if(event.getExtendInt1() ==1002){//应急消防
            event.setEventTypeName("应急消防");
        }else if(event.getExtendInt1() ==1003){//综合治理
            event.setEventTypeName("综合治理");
        }else if(event.getExtendInt1() ==1004){//青山云
            event.setEventTypeName("青山云");
        }
        *//****//*

        *//*if(StringUtils.isEmpty(event.getEventImage())){
            return AjaxResult.error("事件图片地址不能为空");
        }*//*
        if(event.getReportType() == null){
            return AjaxResult.error("事件上报类型不能为空");
        }
        if(StringUtils.isEmpty(event.getReportTypeName())){
            return AjaxResult.error("事件上报类型名称不能为空");
        }
        if("智能上报".equals(event.getReportTypeName())){
            event.setReportType(1);
            if(StringUtils.isEmpty(event.getCameraIndexCode())){
                return AjaxResult.error("设备ID不能为空");
            }
            if(StringUtils.isEmpty(event.getCameraName())){
                return AjaxResult.error("设备地址不能为空");
            }
        }else{
            event.setReportType(2);
        }
        if(StringUtils.isEmpty(event.getRiskLevel())){
            return AjaxResult.error("事件风险等级不能为空");
        }
        if(StringUtils.isEmpty(event.getRegionIndexCode())){
            return AjaxResult.error("事件区域标识不能为空");
        }
        if(StringUtils.isEmpty(event.getRegionName())){
            return AjaxResult.error("事件所属区域不能为空");
        }
        if(event.getEventStatus()==null){
            event.setEventAlertStatus(2);
            event.setEventAlertStatusName("研判中");
        }
        if(StringUtils.isEmpty(event.getEventIndexCode())){
            return AjaxResult.error("事件唯一标识不能为空");
        }
        //判断是否重复
        HkEventInfo param = new HkEventInfo();
        param.setExtendInt1(event.getExtendInt1());//接入事件的平台编码
        param.setExtendStr2(event.getExtendStr2());//各平台的事件类型
        param.setRegionIndexCode(event.getEventIndexCode());//各平台的事件唯一标识
        param.setEventCreateTime(event.getEventCreateTime());//事件上报当天
        *//*根据事件的当天时间、事件的类别、事件的区域code、状态是否为2 进行判断，
        如果为查出的数量为0则正常添加，如果查出来的数据不为0 则将这条事件的状态改为10(重复报警)*//*
        int eventcount = hkEventService.selectEventRepeat(param);
        if(eventcount > 0){
            event.setEventAlertStatus(10);
            event.setEventAlertStatusName("重复报警");
        }
        if(point != null){
            if(StringUtils.isEmpty(point.getLongitude())){
                event.setLongitude(point.getLongitude());
            }
            if(StringUtils.isEmpty(point.getLatitude())){
                event.setLongitude(point.getLatitude());
            }
        }
        event.setCreateTime(new Date());
        int count = hkEventService.reportEvent(event);
        if(count == 1){
            return AjaxResult.success("上报成功");
        }else{
            return AjaxResult.error("上报失败");
        }
    }*/



}
