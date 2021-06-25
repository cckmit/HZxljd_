package com.ruoyi.web.controller.app;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;

import com.ruoyi.system.domain.Action.HkActionProcess;
import com.ruoyi.system.domain.HKrecord;
import com.ruoyi.system.domain.HkEarlyWarning.HkEventInfo;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.domain.app.*;

import com.ruoyi.system.service.ISysUserService;
import com.ruoyi.system.service.app.AppEventDetailService;
import com.ruoyi.system.service.app.AppMyWorkService;
import com.ruoyi.system.service.app.AppEventInfoService;
import com.ruoyi.system.utils.BaseUtlis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: data-ruoyi
 * @description: app-事件详情
 * @author: Yang-Teng-Fei
 * @create: 2020-12-10 18:02
 **/
@Controller
//@RequestMapping("/appEventDetali")
public class AppEventDtalisController extends BaseController {
    @Autowired
    private AppEventDetailService appEventDetailService;
    @Autowired
    private ISysUserService iSysUserService;
    @Autowired
    private AppEventInfoService appEventInfoService;
    @Autowired
    private AppMyWorkService appMyWorkService;

    private String imgUrls = "http://172.45.4.105:8457/cbdm/service/rs/api/v1/event/image?deviceId=";

    String uploadUrl = "D:/Server/apache-tomcat-8.5.63/webapps/img/";

    private String pathImg = "http://localhost:8808/img/";

    /*@GetMapping("/appNowEventDetali")
    @ResponseBody
    public AjaxResult appNowEventDetali(Long userId,String eventId){
        Map res = new HashMap();
        res.put("userId",userId);
        res.put("eventId",eventId);

        if(userId==null){
            return AjaxResult.error("用户不能为空");
        }
        if(eventId==null){
            return AjaxResult.error("事件id不能为空");
        }
        HkActionProcess hkActionProcess=  appEventInfoService.findHkActionProcess(res);
        if(hkActionProcess.getIsComplete() == 1){
            return AjaxResult.success( findHkActionProcess(userId, eventId));
        }else {
            // 获取之前行动信息
            List<appAction> hKrecordList = appEventDetailService.appAfterEventDetali(eventId);
            if (hKrecordList.size() != 0) {
                *//**
                 * 属于第二次返回的结果
                 *//*
                for (int i = 0; i < hKrecordList.size(); i++) {
                    // 拿到反馈处理结果
                    String handler = hKrecordList.get(i).getHandlerContent();
                    JSONObject voiceJson = JSON.parseObject(handler);

                    String actionName = voiceJson.getString("actionName");
                    String commonlyId = voiceJson.getString("commonlyId");
                    String handlerContent = voiceJson.getString("handlerContent");
                    String s = voiceJson.getString("appField");
                    String Id = voiceJson.getString("handlerUserId");
                    String time=voiceJson.getString("nowTime");
                    //JSON转List
                    List<appField> appFieldList = JSON.parseArray(s, appField.class);
                    // 获取处理人
                    SysUser sysUser = iSysUserService.selectUserById(Long.valueOf(Id));
                    hKrecordList.get(i).setHandlerName(sysUser.getUserName());
                    hKrecordList.get(i).setHandlerUserId(sysUser.getUserId());
                    hKrecordList.get(i).setActionName(actionName);
                    hKrecordList.get(i).setCommonlyId(commonlyId);
                    hKrecordList.get(i).setHandlerContent(handlerContent);
                    hKrecordList.get(i).setAppFieldList(appFieldList);
                    hKrecordList.get(i).setNowTime(time);

                    res.put("recordList", hKrecordList);

                }
                // 查询该事件详情
                appHkevent appHkevent = appEventDetailService.selectOneHkevent(res);
                if (appHkevent == null) {
                    return AjaxResult.success("暂无数据");
                } else {
                    Integer eventAlertStatus = appHkevent.getEventAlertStatus();
                    if (eventAlertStatus == 3 || eventAlertStatus == 5 ) {
                        // 获取当前时间
                        Date date1 = new Date();
                        String nowDayTime = String.valueOf(date1.getTime() / 1000);
                        // 获取待处理时间
                        Date date = appHkevent.getTimeOut();
                        String timestamp = String.valueOf(date.getTime() / 1000);
                        // 得出待处理时间
                        Integer time = Integer.valueOf(timestamp);
                        Integer times = Integer.valueOf(nowDayTime);
                        Integer overTime = time - times;
                        appHkevent.setPengTime(overTime);
                    } else if (eventAlertStatus == 9) {
                        // 获取当前时间
                        Date date1 = new Date();
                        String nowDayTime = String.valueOf(date1.getTime() / 1000);
                        // 获取逾期时间
                        Date date = appHkevent.getTimeOut();
                        String timestamp = String.valueOf(date.getTime() / 1000);
                        Integer time = Integer.valueOf(timestamp);
                        Integer times = Integer.valueOf(nowDayTime);
                        // 得出逾期时间
                        Integer overTime = times - time;
                        appHkevent.setOverTime(overTime);
                    }
                }
                res.put("appHkevent", appHkevent);
                // 查询当前行动信息
                List<appActionNow> appActionList = appEventDetailService.appNowEventDetali(res);
                if (appActionList.size() == 0) {
                    return AjaxResult.success("暂无数据");
                } else {
                    for (int i = 0; i < appActionList.size(); i++) {
                        //获取行动链是否共治
                        List<HkActionProcess> processes= appMyWorkService.findActionChainEventId(Long.toString(userId));
                        Integer isGovernance=0;
                        for(int j=0;i<processes.size();j++){
                            isGovernance = processes.get(j).getIsGovernance();
                        }
                        // 获取处理人
                        SysUser sysUser = iSysUserService.selectUserById(userId);
                        appActionList.get(i).setHandlerName(sysUser.getUserName());
                        appActionList.get(i).setHandlerUserId(sysUser.getUserId());
                        appActionList.get(i).setIsGovernance(isGovernance);
                        String actionName = appActionList.get(i).getActionName();
                        String commonlyId = appActionList.get(i).getCommonlyId();
                        String handlerName = appActionList.get(i).getHandlerName();
                        Integer isGovernance1 = appActionList.get(i).getIsGovernance();
                        List<appField> appField = appActionList.get(i).getAppField();
                        res.put("appNowFieldList", appField);
                        res.put("actionName", actionName);
                        res.put("commonlyId", commonlyId);
                        res.put("handlerName", handlerName);
                        res.put("isGovernance1",isGovernance1);
                    }
                }
            }

            else {
                res.put("recordList", hKrecordList);
                // 查询该事件详情
                appHkevent appHkevent = appEventDetailService.selectOneHkevent(res);
                if (appHkevent == null) {
                    return AjaxResult.success("暂无数据");
                } else {
                    Integer eventAlertStatus = appHkevent.getEventAlertStatus();
                    if (eventAlertStatus == 3 || eventAlertStatus == 5 ) {
                        // 获取当前时间
                        Date date1 = new Date();
                        String nowDayTime = String.valueOf(date1.getTime() / 1000);
                        // 获取待处理时间
                        Date date = appHkevent.getTimeOut();
                        String timestamp = String.valueOf(date.getTime() / 1000);
                        // 得出待处理时间
                        Integer time = Integer.valueOf(timestamp);
                        Integer times = Integer.valueOf(nowDayTime);
                        Integer overTime = time - times;
                        appHkevent.setPengTime(overTime);
                    } else if (eventAlertStatus == 9) {
                        // 获取当前时间
                        Date date1 = new Date();
                        String nowDayTime = String.valueOf(date1.getTime() / 1000);
                        // 获取逾期时间
                        Date date = appHkevent.getTimeOut();
                        String timestamp = String.valueOf(date.getTime() / 1000);
                        Integer time = Integer.valueOf(timestamp);
                        Integer times = Integer.valueOf(nowDayTime);
                        // 得出逾期时间
                        Integer overTime = times - time;
                        appHkevent.setOverTime(overTime);
                    }
                }
                res.put("appHkevent", appHkevent);
                // 查询当前行动信息
                List<appActionNow> appActionList = appEventDetailService.appNowEventDetali(res);
                if (appActionList.size() == 0) {
                    return AjaxResult.success("暂无数据");
                } else {
                    for (int i = 0; i < appActionList.size(); i++) {
                        //获取行动链是否共治
                        List<HkActionProcess> processes= appMyWorkService.findActionChainEventId(Long.toString(userId));
                        Integer isGovernance=0;
                        for(int j=0;i<processes.size();j++){
                           isGovernance = processes.get(j).getIsGovernance();
                        }
                        // 获取处理人
                        SysUser sysUser = iSysUserService.selectUserById(userId);
                        appActionList.get(i).setHandlerName(sysUser.getUserName());
                        appActionList.get(i).setHandlerUserId(sysUser.getUserId());
                        appActionList.get(i).setIsGovernance(isGovernance);
                        String actionName = appActionList.get(i).getActionName();
                        String commonlyId = appActionList.get(i).getCommonlyId();
                        String handlerName = appActionList.get(i).getHandlerName();
                        Integer isGovernance1 = appActionList.get(i).getIsGovernance();
                        List<appField> appField = appActionList.get(i).getAppField();
                        res.put("appNowFieldList", appField);
                        res.put("actionName", actionName);
                        res.put("commonlyId", commonlyId);
                        res.put("handlerName", handlerName);
                        res.put("isGovernance1",isGovernance1);
                    }
                }
            }
        }
       return AjaxResult.success(res);
    }

    *//**
     * 分享页面事件详情
     * @param eventId 事件ID
     * @return
     *//*
    @PostMapping("/appEventDetailNoUser")
    @ResponseBody
    public AjaxResult appEventDetailNoUser(String eventId){
        if(StringUtils.isEmpty(eventId)){
            return AjaxResult.error("事件ID不能为空");
        }else{
            Map<String,String> param = new HashMap<>();
            param.put("eventId",eventId);
            appHkevent event = appEventDetailService.selectOneHkevent(param);
            if (event == null) {
                return AjaxResult.success("暂无数据");
            }
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
            return AjaxResult.success(event);
        }
    }


    *//**
     * 签收
     * @param
     * @return
     *//*
    @PostMapping("/SignFor")
    @ResponseBody
    public AjaxResult SignFor(String eventId,Long userId) {
        // 修改当前事件状态
        Map res = new HashMap();
        res.put("eventId", eventId);
        res.put("userId", userId);
        if (userId == null) {
            return AjaxResult.error("用户不能为空");
        }
        if (eventId == null) {
            return AjaxResult.error("事件id不能为空");
        }
        appHkevent appHkevent = appEventDetailService.selectOneHkevent(res);
        if (appHkevent.getEventAlertStatus() == 5 || appHkevent.getEventAlertStatus() == 6) {
            return AjaxResult.error("该事件已被签收");
        } else {
            // 查询当前行动信息
            List<appActionNow> appActionList = appEventDetailService.appNowEventDetali(res);
            for (int i = 0; i < appActionList.size(); i++) {
                // 行动id
                String commonlyId = appActionList.get(i).getCommonlyId();
                // 签收人名称
                SysUser sysUser = iSysUserService.selectUserById(userId);
                String userName = sysUser.getUserName();
                // 获取当前时间
                Date date1 = new Date();
                SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                //格式化为日期/时间字符串
                String cc=sdf.format(date1);

                // 添加到处理结果表
                appActionJson appActionJson = new appActionJson();
                appActionJson.setActionName("QS0001");
                appActionJson.setCommonlyId(commonlyId);
                appActionJson.setHandlerUserId(userId);
                appActionJson.setHandlerName(userName);
                appActionJson.setNowTime(cc);
                appActionJson.setEventId(eventId);
                appActionJson.setHandlerContent("已签收");
                //2、创建jackson的核心对象 ObjectMapper
                ObjectMapper mapper = new ObjectMapper();
                try {
                    String json = mapper.writeValueAsString(appActionJson);
                    HKrecord hKrecord = new HKrecord();
                    // 添加处理内容
                    hKrecord.setRecordId(UUID.randomUUID().toString().trim().replaceAll("-", ""));
                    String s3 = Long.toString(appActionJson.getHandlerUserId());
                    hKrecord.setHandlerIndexCode(s3);
                    hKrecord.setHandlerContent(json);
                    hKrecord.setEventId(appActionJson.getEventId());
                    hKrecord.setProcessStatus("4");
                    int count1 = appEventDetailService.addHkrecond(hKrecord);
                    if (count1 > 0) {
                        int count = appEventDetailService.updateManagementEvent(res);
                        if (count > 0) {
                            return AjaxResult.success("签收成功");
                        } else {
                            return AjaxResult.error("签收失败");
                        }

                    } else {
                        return AjaxResult.error("添加失败");
                    }

                } catch (JsonProcessingException e) {
                    e.printStackTrace();

                }

            }
            return AjaxResult.error("服务器错误");

        }



    }



    *//**
     * 反馈事件内容
     * @return
     *//*
    @PostMapping("/addField")
    @ResponseBody
    public AjaxResult addHkrecond(@RequestBody appActionJson appActionJson) throws IOException {
        List<appField> appFieldList=appActionJson.getAppField();

        for (int i = 0; i <appFieldList.size() ; i++) {
            if(StringUtils.isEmpty(appFieldList.get(i).getFieldValue())){
                return AjaxResult.success(appFieldList.get(i).getFieldName()+"不能为空");
            }
            String fieldType=appFieldList.get(i).getFieldType();
            if(fieldType.equals("图片")){
                String fileName =UUID.randomUUID().toString().trim().replaceAll("-", "");
                logger.info("上传图片名称地址 = "+fileName);
                String base64=  appFieldList.get(i).getFieldValue();
                String[] imgs = null;
                String[] type= new String[4];
                String[] path=new String[4];
                String[] url=new String[4];
                imgs = base64.split(",");
                if(imgs != null){
                    for (int j=0;j<imgs.length;j++){
                        type[j] = BaseUtlis.checkImageBase64Format(imgs[j]);
                        path[j] = pathImg+fileName+"."+type[j];
                        url[j] = uploadUrl+fileName+"."+type[j];
                        BaseUtlis.base64StrToImage(imgs[j],url[j]);
                        appFieldList.get(i).setFieldValue(path[j]);
                    }
                }
            }
        }

        //2、创建jackson的核心对象 ObjectMapper
        ObjectMapper mapper = new ObjectMapper();
        String eventId=appActionJson.getEventId();
        // 判断行动连是否走完
        List<HkActionProcess> hkActionProcessList=appEventDetailService.selcterCompleteSize(eventId);
        if(hkActionProcessList.size()==0){
            return AjaxResult.success("暂无数据");
        }
        if(hkActionProcessList.size()>=2){
            String handlerOrder=hkActionProcessList.get(0).getHandlerOrder();
            Map res = new HashMap();
            res.put("eventId",eventId);
            res.put("handlerOrder",handlerOrder);
            // 修改当前执行人状态
            int count= appEventDetailService.updateHkAction(res);
            if(count>0){
                try {
                    String json = mapper.writeValueAsString(appActionJson);
                    HKrecord hKrecord=new HKrecord();
                    // 添加处理内容
                    hKrecord.setRecordId(UUID.randomUUID().toString().trim().replaceAll("-", ""));
                    String s3 = Long.toString(appActionJson.getHandlerUserId());
                    hKrecord.setHandlerIndexCode(s3);
                    hKrecord.setHandlerContent(json);
                    hKrecord.setHandlerRecordIndexCode(UUID.randomUUID().toString().trim().replaceAll("-", ""));
                    hKrecord.setEventId(appActionJson.getEventId());
                    hKrecord.setProcessStatus("4");
                    int count1= appEventDetailService.addHkrecond(hKrecord);
                    if(count1>0){
                        return AjaxResult.success("添加成功");
                    }else {
                        return AjaxResult.error("添加失败");
                    }

                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                }
            }else {
                return AjaxResult.success("暂无数据");
            }
        }else if(hkActionProcessList.size()<2){
            String handlerOrder=hkActionProcessList.get(0).getHandlerOrder();
            Map res = new HashMap();
            res.put("eventId",eventId);
            res.put("handlerOrder",handlerOrder);
            // 修改当前执行人状态
            int count= appEventDetailService.updateHkAction(res);
            if(count>0){
                // 修改事件表完结状态
               int a= appEventDetailService.updateEventInfo(eventId);
               if(a>0){
                   try {
                       String json = mapper.writeValueAsString(appActionJson);
                       HKrecord hKrecord=new HKrecord();
                       // 添加处理内容
                       hKrecord.setRecordId(UUID.randomUUID().toString().trim().replaceAll("-", ""));
                       String s3 = Long.toString(appActionJson.getHandlerUserId());
                       hKrecord.setHandlerIndexCode(s3);
                       hKrecord.setHandlerContent(json);
                       hKrecord.setEventId(appActionJson.getEventId());
                       hKrecord.setProcessStatus("4");
                       int count1= appEventDetailService.addHkrecond(hKrecord);
                       if(count1>0){
                           return AjaxResult.success("添加成功");
                       }else {
                           return AjaxResult.error("添加失败");
                       }

                   } catch (JsonProcessingException e) {
                       e.printStackTrace();

                   }
               }else {
                   return AjaxResult.error("修改失败");
               }
            }else {
                return AjaxResult.error("修改失败");
            }

        }

        return AjaxResult.error("修改失败");

    }



    *//**
     * 事件退回
     * @param appActionJson
     * @return
     *//*
    @PostMapping("/returnEventInfo")
    @ResponseBody
    public AjaxResult returnEventInfo(@RequestBody appActionJson appActionJson) {
        // 获取事件签收人
        String eventId = appActionJson.getEventId();
        HkEventInfo hkEventInfo = appEventDetailService.selectOneEventInfo(eventId);
        String id=hkEventInfo.getCurrentProcessorId();
        if (id.equals(eventId)) {
            String userId = hkEventInfo.getCurrentProcessorId();
            // 获取当前登陆人
            String handlerUserId = String.valueOf(appActionJson.getHandlerUserId());
            if (handlerUserId.equals(userId)) {
                // 修改事件表状态（退回）
                int returnCount = appEventDetailService.updateReturEvent(appActionJson.getEventId());
                if (returnCount > 0) {
                    Map res = new HashMap();
                    res.put("eventId", eventId);
                    // 查询当前行动信息
                    List<appActionNow> appActionList = appEventDetailService.appNowEventDetali(res);
                    for (int i = 0; i < appActionList.size(); i++) {

                        // 行动id
                        String commonlyId = appActionList.get(i).getCommonlyId();
                        // 签收人名称
                        SysUser sysUser = iSysUserService.selectUserById(Long.valueOf(userId));
                        String userName = sysUser.getUserName();
                        // 获取当前时间
                        Date date1 = new Date();
                        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        //格式化为日期/时间字符串
                        String cc=sdf.format(date1);
                        appActionJson.setActionName("TH0002");
                        appActionJson.setCommonlyId(commonlyId);
                        appActionJson.setHandlerName(userName);
                        appActionJson.setNowTime(cc);
                        //2、创建jackson的核心对象 ObjectMapper
                        ObjectMapper mapper = new ObjectMapper();
                        try {
                            String json = mapper.writeValueAsString(appActionJson);
                            HKrecord hKrecord = new HKrecord();
                            // 添加处理内容
                            hKrecord.setRecordId(UUID.randomUUID().toString().trim().replaceAll("-", ""));
                            String s3 = Long.toString(appActionJson.getHandlerUserId());
                            hKrecord.setHandlerIndexCode(s3);
                            hKrecord.setHandlerContent(json);
                            hKrecord.setEventId(appActionJson.getEventId());
                            hKrecord.setProcessStatus("4");
                            int count1 = appEventDetailService.addHkrecond(hKrecord);
                            if (count1 > 0) {
                                return AjaxResult.success("退回成功");
                            } else {
                                return AjaxResult.error("退回失败");
                            }

                        } catch (JsonProcessingException e) {
                            e.printStackTrace();

                        }
                    }

                }

            } else {
                return AjaxResult.error("退回失败,您不是签收人");
            }
        } else {
            Map res = new HashMap();
            res.put("eventId", eventId);
            // 修改事件表状态（退回）
            int returnCount = appEventDetailService.updateReturEvent(appActionJson.getEventId());
            // 查询当前行动信息
            List<appActionNow> appActionList = appEventDetailService.appNowEventDetali(res);
            for (int i = 0; i < appActionList.size(); i++) {
                // 行动名称
                String actionName = appActionList.get(i).getActionName();
                // 行动id
                String commonlyId = appActionList.get(i).getCommonlyId();
                // 签收人名称
                SysUser sysUser = iSysUserService.selectUserById(appActionJson.getHandlerUserId());
                String userName = sysUser.getUserName();
                // 获取当前时间
                Date date1 = new Date();
                SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                //格式化为日期/时间字符串
                String cc=sdf.format(date1);
                appActionJson.setActionName(actionName);
                appActionJson.setCommonlyId(commonlyId);
                appActionJson.setHandlerName(userName);
                appActionJson.setNowTime(cc);
                //2、创建jackson的核心对象 ObjectMapper
                ObjectMapper mapper = new ObjectMapper();
                try {
                    String json = mapper.writeValueAsString(appActionJson);
                    HKrecord hKrecord = new HKrecord();
                    // 添加处理内容
                    hKrecord.setRecordId(UUID.randomUUID().toString().trim().replaceAll("-", ""));
                    String s3 = Long.toString(appActionJson.getHandlerUserId());
                    hKrecord.setHandlerIndexCode(s3);
                    hKrecord.setHandlerContent(json);
                    hKrecord.setEventId(appActionJson.getEventId());
                    hKrecord.setProcessStatus("4");
                    int count1 = appEventDetailService.addHkrecond(hKrecord);
                    if (count1 > 0) {
                        return AjaxResult.success("退回成功");
                    } else {
                        return AjaxResult.error("退回失败");
                    }

                } catch (JsonProcessingException e) {
                    e.printStackTrace();

                }
            }


        }
        return AjaxResult.error("");
    }

    public AjaxResult findHkActionProcess(Long userId, String eventId){

        Map res=new HashMap();
        res.put("userId",userId);
        res.put("eventId",eventId);
        // 获取之前行动信息
        List<appAction> hKrecordList=appEventDetailService.appAfterEventDetali(eventId);

            for (int i = 0; i <hKrecordList.size() ; i++) {
                // 拿到反馈处理结果
                String handler=hKrecordList.get(i).getHandlerContent();
                JSONObject voiceJson = JSON.parseObject(handler);

                String actionName=voiceJson.getString("actionName");
                String commonlyId=voiceJson.getString("commonlyId");
                String handlerContent=voiceJson.getString("handlerContent");
                String s=voiceJson.getString("appField");
                String Id=voiceJson.getString("handlerUserId");
                //JSON转List
                List<appField> appFieldList = JSON.parseArray(s,appField.class);

                // 获取处理人
                SysUser sysUser=iSysUserService.selectUserById(Long.valueOf(Id));
                hKrecordList.get(i).setHandlerName(sysUser.getUserName());
                hKrecordList.get(i).setHandlerUserId(sysUser.getUserId());
                hKrecordList.get(i).setActionName(actionName);
                hKrecordList.get(i).setCommonlyId(commonlyId);
                hKrecordList.get(i).setHandlerContent(handlerContent);
                hKrecordList.get(i).setAppFieldList(appFieldList);
                res.put("recordList",hKrecordList);

            }
            // 查询该事件详情
            appHkevent appHkevent= appEventDetailService.selectOneHkevent(res);
            if(appHkevent==null){
                return AjaxResult.success("暂无数据");
            }else {
                Integer eventAlertStatus=appHkevent.getEventAlertStatus();
                if (eventAlertStatus == 3 || eventAlertStatus == 5) {
                    // 获取当前时间
                    Date date1 = new Date();
                    String nowDayTime = String.valueOf(date1.getTime() / 1000);
                    // 获取待处理时间
                    Date date = appHkevent.getTimeOut();
                    String timestamp = String.valueOf(date.getTime() / 1000);
                    // 得出待处理时间
                    Integer time = Integer.valueOf(timestamp);
                    Integer times = Integer.valueOf(nowDayTime);
                    Integer overTime = time - times;
                    appHkevent.setPengTime(overTime);
                } else if (eventAlertStatus == 9) {
                    // 获取当前时间
                    Date date1 = new Date();
                    String nowDayTime = String.valueOf(date1.getTime() / 1000);
                    // 获取逾期时间
                    Date date = appHkevent.getTimeOut();
                    String timestamp = String.valueOf(date.getTime() / 1000);
                    Integer time = Integer.valueOf(timestamp);
                    Integer times = Integer.valueOf(nowDayTime);
                    // 得出逾期时间
                    Integer overTime = times - time;
                    appHkevent.setOverTime(overTime);
                }else if(eventAlertStatus == 6) {

                }
            }
            res.put("appHkevent",appHkevent);
        return AjaxResult.success(res);
    }*/


}
