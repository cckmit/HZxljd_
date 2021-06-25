package com.ruoyi.web.controller.ding;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.collect.ImmutableMap;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.map.GPSUtils;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.Action.HkActionProcess;
import com.ruoyi.system.domain.HKrecord;
import com.ruoyi.system.domain.HkEarlyWarning.HkEventInfo;
import com.ruoyi.system.domain.HkEntity.EventReportVo;
import com.ruoyi.system.domain.HkEntity.PointDTO;
import com.ruoyi.system.domain.HkEventProcessRecord;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.domain.app.*;
import com.ruoyi.system.domain.ding.DingEvent;
import com.ruoyi.system.mapper.HkActionProcessMapper;
import com.ruoyi.system.service.HKfield.HKfieldService;
import com.ruoyi.system.service.HkEarlyWarning.HkEventService;
import com.ruoyi.system.service.IHkMapService;
import com.ruoyi.system.service.ISysUserService;
import com.ruoyi.system.service.app.AppEventDetailService;
import com.ruoyi.system.service.app.AppEventInfoService;
import com.ruoyi.system.service.ding.DingEventService;
import com.ruoyi.web.annotation.IdentityVerify;
import com.ruoyi.web.annotation.IdentityVerifys;
import com.ruoyi.web.jwt.JWTUtil;
import org.aspectj.weaver.loadtime.Aj;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.ssssssss.magicapi.provider.MagicAPIService;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @ProjectName: ruoyi
 * @Package: com.ruoyi.web.controller.ding
 * @ClassName: DingEventController
 * @Author: guohailong
 * @Description: 浙政钉-事件清单接口
 * @Date: 2021/3/10 17:11
 * @Version: 1.0
 */
@RestController
@RequestMapping("/ding")
public class DingEventController {

    private static final Logger logger = LoggerFactory.getLogger(DingEventController.class);

    @Autowired
    private AppEventDetailService appEventDetailService;

    @Autowired  // 注入MagicAPIService对象
    private MagicAPIService magicAPIService;

    @Autowired
    private ISysUserService iSysUserService;

    @Autowired
    private AppEventInfoService appEventInfoService;

    @Autowired
    private DingEventService dingEventService;

    @Autowired
    private HKfieldService hKfieldService;

    @Autowired
    private HkEventService eventService;

    @Autowired
    private IHkMapService hkMapService;

    /*图片存储地址*/
    @Value("${event-feedback.upload-path}")
    private String uploadPath;

    /*图片访问url前缀*/
    @Value("${event-feedback.url-prefix}")
    private String urlPrefix;


    /**
     * 根据事件状态获取用户待办事件清单
     *
     * @param sourceId
     * @param userId
     * @param eventTitle
     * @param eventAlertStatus
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/event/list")
    @IdentityVerify
    public AjaxResult getEventList(@IdentityVerifys Long userId,
                                   String sourceId,
                                   String eventTitle,
                                   @RequestParam("status") Integer eventAlertStatus,
                                   @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                   @RequestParam(name = "pageSize", required = false, defaultValue = "5") Integer pageSize) {
        /**
         * sourceId取值
         * 1001.智慧城管
         * 1002.应急管理
         * 1003.综合治理
         * 1004.助力清河
         * 1005.平安创建
         * 1006.产业发展
         * 1007.民生服务
         * 1010.青河治
         */

        Map<String, Object> res = new HashMap<>();
        res.put("userId", userId);
        res.put("componentId", sourceId);
        res.put("eventTitle", eventTitle);
        res.put("eventAlertStatus", eventAlertStatus);
        Page<appHkevent> pages = PageHelper.startPage(pageNum, pageSize);
        if (eventAlertStatus == 3) {
            List<appHkevent> appHkeventList = appEventInfoService.selectOneHkevent(res);
            // 查询当前登陆人的待处理事件
            for (int i = 0; i < appHkeventList.size(); i++) {
                // 获取当前时间
                long nowTime = new Date().getTime();
                // 获取超时时间
                long endTime = appHkeventList.get(i).getTimeOut().getTime();
                //剩余时间计算,临时存放在cameraName字段
                appHkeventList.get(i).setCameraName(formatDuring(endTime - nowTime));
            }
            res.put("appHkeventList", appHkeventList);
            res.put("pageTotal", pages.getTotal());
            res.put("pageNum", pageNum);
            res.put("pageSize", pageSize);
            res.put("page", pages.getPages());
            return AjaxResult.success(res);
        } else if (eventAlertStatus == 6) {
            //查询当前登陆人的已完成事件
            List<appHkevent> appHkeventList = appEventInfoService.selectCompletedEvent(res);
            res.put("appHkeventList", appHkeventList);
            res.put("pageTotal", pages.getTotal());
            res.put("pageNum", pageNum);
            res.put("pageSize", pageSize);
            res.put("page", pages.getPages());
            return AjaxResult.success(res);
        } else if (eventAlertStatus == 9) {
            // 查询当前登陆人的已逾期事件
            List<appHkevent> appHkeventList = appEventInfoService.selectOverduEvent(res);
            for (int i = 0; i < appHkeventList.size(); i++) {
                // 获取当前时间
                long nowTime = new Date().getTime();
                // 获取超时时间
                long endTime = appHkeventList.get(i).getTimeOut().getTime();
                //逾期时间
                appHkeventList.get(i).setCameraName(formatDuring(nowTime - endTime));
            }
            res.put("appHkeventList", appHkeventList);
            res.put("pageTotal", pages.getTotal());
            res.put("pageNum", pageNum);
            res.put("pageSize", pageSize);
            res.put("page", pages.getPages());
            return AjaxResult.success(res);
        } else {
            logger.error("事件状态异常:eventAlertStatus[{}]", eventAlertStatus);
            return AjaxResult.error("系统参数异常");
        }

    }

    /**
     * 事件详情
     *
     * @param userId
     * @param eventId
     * @return
     * @by zhangxinxin
     */
    @GetMapping("/event/detail/{userId}/{eventId}")
    @IdentityVerify
    public AjaxResult getEventDetail1(@PathVariable Long userId, @PathVariable String eventId) {
        /**
         *
         * 根据用户id查询所属事件
         * action_process表中需添加用户id,
         *
         */
        /**查询事件详情，事件前几位处置人员的处置信息（签收时间，驳回时间，处置信息）**/
        Map<String, Object> result = new HashMap<>();
        result.put("userId", userId);
        result.put("eventId", eventId);
        /**查询当前人所属的事件流程信息**/
        HkActionProcess hkActionProcess = appEventInfoService.findHkActionProcessNow(result);
        if (hkActionProcess.getIsComplete() == 1) {
            return findHkActionProcess(userId, eventId);
        }
        /**
         * 此处查询该用户操作记录之前的所有记录
         */
        List<HkEventProcessRecord> hkEventProcessRecords = dingEventService.queryProcessRecordByParam(result);
        int count = hkEventProcessRecords.size();
        List<Map<String, Object>> list = new ArrayList<>();
        for (int i = 0; i < hkEventProcessRecords.size(); i++) {
            HkEventProcessRecord record = hkEventProcessRecords.get(i);
            if (count > 1) {
                Map<String, Object> lastRecord = new HashMap<>();
                appAction appAction = null;
                String handlerContent = record.getHandlerContent();
                if ("4".equals(record.getProcessStatus())) {//事件已点击提交
                    appAction = getFieldInfo(handlerContent);
                } else if ("5".equals(record.getProcessStatus())) {//事件退回
                    appAction = getFieldInfo(handlerContent);
                }
                if (appAction != null) {
                    lastRecord.put("status", record.getProcessStatus());
                    lastRecord.put("createTime", record.getCreateTime());
                    lastRecord.put("operationInfo", appAction);
                    list.add(lastRecord);
                }
            }
        }
        result.put("recordList", list);
        Map<String, Object> map = new HashMap<>();
        map.put("actionStandardId", hkActionProcess.getActionStandardId());
        /**当前操作人的处置事件行动信息**/
        appActionNow appActionNow = hKfieldService.queryFieldByAction(map);
        if (appActionNow != null) {
            SysUser sysUser = iSysUserService.selectUserById(userId);
            result.put("appNowFieldList", appActionNow.getAppField());
            result.put("actionName", appActionNow.getActionName());
            result.put("commonlyId", appActionNow.getCommonlyId());
            result.put("handlerName", sysUser.getUserName());
        }
        Map<String, Object> param = new HashMap<>();
        param.put("eventId", eventId);
        /**事件详情**/
        appHkevent appHkevent = appEventDetailService.selectOneHkevent(param);
        Integer eventAlertStatus = appHkevent.getEventAlertStatus();
        if (eventAlertStatus == 3 || eventAlertStatus == 5) {
            long nowTime = new Date().getTime();
            long endTime = appHkevent.getTimeOut().getTime();
            appHkevent.setPengTime((int) (endTime - nowTime) / 1000);
        } else if (eventAlertStatus == 9) {
            long nowTime = new Date().getTime();
            long endTime = appHkevent.getTimeOut().getTime();
            appHkevent.setOverTime((int) (endTime - nowTime) / 1000);
        }
        result.put("appHkevent", appHkevent);
        /**
         * 查询事件的详情
         * 事件之前的签收，退回，操时间，事件的处置结果
         * 事件之前的操作历史
         * 当前事件需要的行动
         */
        return AjaxResult.success(result);
    }


    /**
     * 操作记录转换成JavaBean
     *
     * @param handlerContent
     * @return
     */
    public appAction getFieldInfo(String handlerContent) {
        appAction appAction = new appAction();
        if (!StringUtils.isEmpty(handlerContent)) {
            JSONObject voiceJson = JSON.parseObject(handlerContent);
            String actionName = voiceJson.getString("actionName");
            String commonlyId = voiceJson.getString("commonlyId");
            String subHandlerContent = voiceJson.getString("handlerContent");
            String s = voiceJson.getString("appField");
            String Id = voiceJson.getString("handlerUserId");
            String time = voiceJson.getString("nowTime");
            String handleStatus = voiceJson.getString("handleStatus");
            //JSON转List
            List<appField> appFieldList = JSON.parseArray(s, appField.class);
            // 获取处理人
            SysUser sysUser = iSysUserService.selectUserById(Long.valueOf(Id));
            if (!StringUtils.isEmpty(handleStatus)) {
                appAction.setHandleStatus(Integer.parseInt(handleStatus));
            }
            appAction.setHandlerName(sysUser.getUserName());
            appAction.setHandlerUserId(sysUser.getUserId());
            appAction.setActionName(actionName);
            appAction.setCommonlyId(commonlyId);
            appAction.setHandlerContent(subHandlerContent);
            appAction.setAppFieldList(appFieldList);
            appAction.setNowTime(time);
        }
        return appAction;
    }

    /**
     * 联络员指派
     * @param userId 当前用户
     * @param eventId  事件id
     * @param assignedUserId   指派的用户id
     * @return
     */
    @PostMapping("/event/assigned/{userId}/{eventId}/{assignedUserId}")
    @IdentityVerify
    public AjaxResult assigned(@PathVariable @IdentityVerifys Long userId,@PathVariable String eventId,@PathVariable Long assignedUserId){
        //判断事件状态和处理流程
        /**
         * 1. 修改事件类型
         *  事件处理人、处理人
         */
        Map<String,Object> event = new HashMap<>();
        event.put("eventId",eventId);       //事件id
        event.put("currentUser",assignedUserId);    //处理人id
        /**
         * 2. 修改行动流程信息
         */
        List<Map> processlist = new ArrayList<>();
        String chainId = appEventInfoService.findHkActionEvent(eventId);
        Map<String,Object> process1 = new HashMap<>();
        process1.put("eventId",eventId);     //事件id
        process1.put("chainId",chainId);     //行动链id
        process1.put("handlerOrder","1");    //处理顺序
        process1.put("isComplete",1);        //是否处理完成
        processlist.add(process1);
        Map<String,Object> process2 = new HashMap<>();
        process2.put("eventId",eventId);     //事件id
        process2.put("chainId",chainId);     //行动链id
        process2.put("handlerOrder","2");    //处理顺序
        process2.put("userId",assignedUserId);       //处理人
        processlist.add(process2);
        /**
         * 3. 添加行动记录
         */
        HKrecord hKrecord = new HKrecord();
        hKrecord.setRecordId(UUID.randomUUID().toString().trim().replaceAll("-", ""));
        hKrecord.setHandlerIndexCode(userId.toString());
        hKrecord.setHandlerName("");
        hKrecord.setHandlerContent("");
        hKrecord.setEventId(eventId);
        hKrecord.setProcessStatus("2");//指派
        hKrecord.setExtendStr3(iSysUserService.selectUserById(userId).getUserName());
        hKrecord.setExtendInt3(2);
        return taskStart(event,processlist,hKrecord);
    }

    /**
     * 事件签收
     *
     * @param userId
     * @param eventId
     * @return
     * @by zhangxinxin
     */
    @PutMapping("/event/sign/{userId}/{eventId}")
    @IdentityVerify
    public AjaxResult eventSign1(@PathVariable @IdentityVerifys Long userId, @PathVariable String eventId) {
        Map<String, Object> param = new HashMap();
        param.put("eventId", eventId);
        param.put("userId", userId);
        appHkevent appHkevent = appEventDetailService.selectOneHkevent(param);
        if (appHkevent.getEventAlertStatus() == 5) {
            return AjaxResult.warn("该事件已签收，请勿重复操作");
        }
        if (appHkevent.getEventAlertStatus() != 3) {
            logger.info("=================事件签收失败，当前状态 = " + appHkevent.getEventAlertStatus());
            return AjaxResult.warn("该事件当前状态无法签收");
        }
        return dingEventService.eventSign(userId, eventId);
    }

    /**
     * 事件反馈 (闲林)
     * @param appActionJson
     * @return
     * @throws IOException
     * @by zhangxinxin
     */
    @PostMapping("/event/feedback/{userId}")
    @IdentityVerify
    public AjaxResult eventFeedback(@PathVariable @IdentityVerifys Long userId, @RequestBody appActionJson appActionJson){
        logger.info("事件反馈,userId[{}],反馈信息[{}]", userId, JSON.toJSONString(appActionJson));
        String inspection = inspection(appActionJson);
        if(!inspection.equals("")) return AjaxResult.warn(inspection);
        DingEvent dingEvent = dingEventService.getEventInfoByEventId(appActionJson.getEventId());
        //退回或者完成事件
        if(appActionJson.getHandleStatus().equals("1")){
            //完成事件逻辑
            //最后一个事件处理流程
            Map lastprocess = (Map) magicAPIService.execute("get","/system/process/getEndProcess",
                    ImmutableMap.of("eventId",dingEvent.getEventId(),"chainId",dingEvent.getProcdefType()));
            Map<String,Object> event = new HashMap<>();
            event.put("eventId",appActionJson.getEventId());
            event.put("currentUser",lastprocess.get("handlerUserId"));
            List<Map> processlist = new ArrayList<>();

            Map<String,Object> process1 = new HashMap<>();
            process1.put("eventId",dingEvent.getEventId());     //事件id
            process1.put("chainId",dingEvent.getProcdefType());     //行动链id
            process1.put("handlerOrder",Integer.parseInt(lastprocess.get("handlerOrder").toString())-1);    //最后的处理顺序
            process1.put("isComplete",1);        //是否处理完成
            processlist.add(process1);

            HKrecord hKrecord = new HKrecord();
            hKrecord.setRecordId(UUID.randomUUID().toString().trim().replaceAll("-", ""));
            hKrecord.setHandlerIndexCode(userId.toString());
            hKrecord.setHandlerContent(JSONObject.toJSONString(appActionJson));
            hKrecord.setEventId(dingEvent.getEventId());
            hKrecord.setProcessStatus("5");             //处理中
            hKrecord.setExtendStr3(iSysUserService.selectUserById(userId).getUserName());
            hKrecord.setExtendInt3(Integer.parseInt(lastprocess.get("handlerOrder").toString())-1);
            return taskStart(event,processlist,hKrecord);
        }else if(appActionJson.getHandleStatus().equals("0")){
            //退回的话，退回事件
            if (StringUtils.isEmpty(appActionJson.getHandlerContent()))
                return AjaxResult.warn("退回原因不能为空");
            if (dingEvent.getEventAlertStatus() == 4)
                return AjaxResult.warn("事件已退回，请勿重复操作");
            if (dingEvent.getEventAlertStatus() == 6)
                return AjaxResult.warn("该事件当前状态无法提交");
            this.backAllUnified(userId,appActionJson);
        }
        return new AjaxResult().success();
    }

    /**
     * 领导审批：(闲林)
     * @param userId 用户id
     * @return
     */
    @PostMapping("/event/approval/{userId}")
    @IdentityVerify
    public AjaxResult approval(@PathVariable @IdentityVerifys Long userId,@RequestBody appActionJson appActionJson){
        logger.info("领导审批,userId[{}],反馈信息[{}]", userId, JSON.toJSONString(appActionJson));
        String inspection = inspection(appActionJson);
        if(!inspection.equals("")) return AjaxResult.warn(inspection);
        DingEvent dingEvent = dingEventService.getEventInfoByEventId(appActionJson.getEventId());
        //判断是否审批通过
        if(appActionJson.getHandleStatus().equals("1")){
            //事件归档
            Map<String,Object> event = new HashMap<>();
            event.put("eventId",appActionJson.getEventId());
            event.put("statusCode","6");
            event.put("statusName","完结");
            List<Map> processlist = new ArrayList<>();

            Map lastNumber = (Map) magicAPIService.execute("get","/system/process/getEndProcess",
                    ImmutableMap.of("eventId",dingEvent.getEventId(),"chainId",dingEvent.getProcdefType()));
            Map<String,Object> process1 = new HashMap<>();
            process1.put("eventId",dingEvent.getEventId());
            process1.put("chainId",dingEvent.getProcdefType());
            process1.put("handlerOrder",lastNumber.get("handlerOrder"));    //最后的处理顺序
            process1.put("isComplete",1);                                   //是否处理完成
            processlist.add(process1);

            HKrecord hKrecord = new HKrecord();
            hKrecord.setRecordId(UUID.randomUUID().toString().trim().replaceAll("-", ""));
            hKrecord.setHandlerIndexCode(userId.toString());
            hKrecord.setHandlerContent("");
            hKrecord.setEventId(dingEvent.getEventId());
            hKrecord.setProcessStatus("6");             //归档
            hKrecord.setExtendStr3(iSysUserService.selectUserById(userId).getUserName());
            hKrecord.setExtendInt3(Integer.parseInt(lastNumber.get("handlerOrder").toString()) );
            return taskStart(event,processlist,hKrecord);
        }else if(appActionJson.getHandleStatus().equals("0")){
            //退回事件到上一级
            if (dingEvent.getEventAlertStatus() == 4)
                return AjaxResult.warn("事件已退回，请勿重复操作");
            if (dingEvent.getEventAlertStatus() == 6)
                return AjaxResult.warn("该事件当前状态无法提交");
            this.backAllUnified(userId,appActionJson);
        }
        return AjaxResult.success();
    }

    /**
     * 统一退回接口 (闲林)
     * @param userId
     * @return
     */
    @PostMapping("/event/backAll/{userId}")
    public AjaxResult backAllUnified(@PathVariable @IdentityVerifys Long userId,@RequestBody appActionJson appActionJson){
        Map<String,Object> event = new HashMap<>();                 //事件信息
        List<Map> processlist = new ArrayList<>();                  //流程信息
        HKrecord record = new HKrecord();                         //结果信息
        record.setRecordId(UUID.randomUUID().toString().trim().replaceAll("-", ""));
        record.setHandlerIndexCode(userId.toString());
        record.setHandlerContent("");
        record.setEventId(appActionJson.getEventId());

        //获取当前事件处理进度
        Map record1 = (Map)magicAPIService.execute("get", "/system/record/getLastRecord",
                ImmutableMap.of("eventId", appActionJson.getEventId()));
        String processingSteps = record1.get("extendInt3").toString(); //获取处理步骤

        //查处理结果表获得处理进度。
        if(processingSteps.equals("1")){
            //当为第一步，退回到中心
            event.put("eventId",appActionJson.getEventId());       //事件id
            event.put("statusCode","4");        //修改事件状态
            event.put("statusName","已退回");    //状态汉字
            record.setProcessStatus("5");     //处置事件的状态
        }else{
            //不是第一步，就退回上一步
            //查询上一步的处理人
            Map hkActionProcess = (Map)magicAPIService.execute("get","/system/process/getProcessById",
                    ImmutableMap.of("eventId", appActionJson.getEventId(),"handlerOrder",Integer.valueOf(processingSteps)-1));
            event.put("eventId",appActionJson.getEventId());       //事件id
            event.put("currentUser",hkActionProcess.get("handlerUserId"));    //处理人id
            event.put("statusCode","3");
            event.put("statusName","调度中");
            //修改流程完成情况 把上一步的处理状态改为0
            Map<String,Object> process1 = new HashMap<>();
            process1.put("eventId",appActionJson.getEventId());     //事件id
            process1.put("chainId",hkActionProcess.get("actionChainId"));     //行动链id
            process1.put("handlerOrder",Integer.valueOf(processingSteps)-1);    //处理顺序
            process1.put("isComplete",0);        //是否处理完成
            processlist.add(process1);
            String postId = hkActionProcess.get("postId").toString();
            if(postId.equals("6")){
                //网格员退回到联络员
                record.setProcessStatus("2");//指派
            }else if(postId.equals("3")){
                //领导退回到网格员
                record.setProcessStatus("3");//签收
            }
        }
        record.setExtendStr3(iSysUserService.selectUserById(userId).getUserName());
        record.setExtendInt3(Integer.valueOf(processingSteps)-1);
        return taskStart(event,processlist,record);
    }



    /**
     * 用户事件上报/反馈操作中的图片上传
     *
     * @param userId
     * @param file
     * @return
     * @throws IOException
     */
    @PostMapping("/event/{userId}/imgUpload")
    @IdentityVerify
    public AjaxResult fileUpload(@PathVariable @IdentityVerifys Long userId, @RequestParam MultipartFile file) {
        logger.info("事件图片上传,userId[{}]", userId);
        String originalFilename = file.getOriginalFilename();
        String suffix = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
        //按日期生成层级目录.防止同一文件夹下文件过多.
        /*String directory = getDirectoryByYMD();
        //判断目录是否存在,如不存在.先创建目录
        File fileDirectory = new File(new File(uploadPath), directory);
        if (!fileDirectory.exists()) {
            fileDirectory.mkdirs();
        }*/
        //生成uuid文件名
        String fileName = UUID.randomUUID().toString().trim().replaceAll("-", "") + "." + suffix;

        File uploadFile = new File(uploadPath  + fileName);
        try {
            file.transferTo(uploadFile);
        } catch (Exception e) {
            logger.error("事件图片上传失败", e);
            return AjaxResult.warn("图片上传出错");
        }
        //返回图片url
        String imgUrl = urlPrefix + fileName;
        logger.info("事件图片上传成功,url[{}]", imgUrl);
        return AjaxResult.success(imgUrl);
    }

//    /**
//     * 事件反馈
//     *
//     * @param appActionJson
//     * @return
//     * @throws IOException
//     * @by zhangxinxin
//     */
//    @PostMapping("/event/feedback/{userId}")
//    @IdentityVerify
//    public AjaxResult eventFeedback1(@PathVariable @IdentityVerifys Long userId, @RequestBody appActionJson appActionJson) {
//        logger.info("事件反馈,userId[{}],反馈信息[{}]", userId, JSON.toJSONString(appActionJson));
//        try {
//            String handleStatus = appActionJson.getHandleStatus();
//            if (StringUtils.isEmpty(handleStatus)) {
//                return AjaxResult.warn("事件处置状态不能为空");
//            }
//            String eventId = appActionJson.getEventId();
//            if (StringUtils.isEmpty(eventId)) {
//                return AjaxResult.warn("事件ID不能为空");
//            }
//            DingEvent dingEvent = dingEventService.getEventInfoByEventId(eventId);
//            if (dingEvent == null) {
//                return AjaxResult.warn("事件不存在");
//            }
//            Map<String, Object> param = new HashMap<>();
//            param.put("eventId", eventId);
//            param.put("userId", userId + "");
//            List<HkEventProcessRecord> hkEventProcessRecords = dingEventService.queryProcessRecordByParam(param);
//            HkEventProcessRecord processRecord = new HkEventProcessRecord();
//            if (hkEventProcessRecords != null && hkEventProcessRecords.size() > 1) {
//                processRecord = hkEventProcessRecords.get(hkEventProcessRecords.size() - 1);
//            }
//            if ("2".equals(handleStatus)) {//退回
//                //退回的话，退回事件
//                if (StringUtils.isEmpty(appActionJson.getHandlerContent())) {
//                    return AjaxResult.warn("退回原因不能为空");
//                }
//                if (dingEvent.getEventAlertStatus() == 4) {
//                    return AjaxResult.warn("事件已退回，请勿重复操作");
//                }
//                if (dingEvent.getEventAlertStatus() == 6) {
//                    return AjaxResult.warn("该事件当前状态无法提交");
//                }
//                return dingEventService.eventReturn(userId, appActionJson);
//            } else {
//                if ("0".equals(handleStatus)) {//已处理
//                    if (dingEvent.getEventAlertStatus() == 6) {
//                        return AjaxResult.warn("事件已处理，请勿重复操作");
//                    }
//                } else if ("1".equals(handleStatus)) {//未处理
//                    /**当前状态下，
//                     * 新增事件处置记录表process_record表状态为4，
//                     * 更新当前行动流程action_process信息为已完成
//                     * 若当前行动流程为最后一级，完结事件
//                     * 若当前行动流程为非最后一级，更新事件为调度中
//                     * 事件流转到行动链下一级
//                     * **/
//                    //操作记录表已状态为已处置 且 事件表已更新为调度时，
//                    if ("4".equals(processRecord.getProcessStatus()) && dingEvent.getEventAlertStatus() == 3) {
//                        return AjaxResult.warn("事件已处理，请勿重复操作");
//                    }
//                }
//                if (dingEvent.getEventAlertStatus() != 5) {
//                    return AjaxResult.warn("该事件当前状态无法提交");
//                }
//                return dingEventService.eventFeedback(userId, appActionJson);
//            }
//        } catch (Exception ex) {
//            logger.error(ex.getMessage(), ex);
//            return AjaxResult.error(ex.getMessage());
//        }
//    }
//    /**
//     * 事件退回
//     *
//     * @param appActionJson
//     * @return
//     * @by zhangxinxin
//     */
//    @PostMapping("/event/return/{uid}")
//    @IdentityVerify
//    public AjaxResult eventReturn(@PathVariable @IdentityVerifys Long uid, @RequestBody appActionJson appActionJson) {
//        String eventId = appActionJson.getEventId();
//        if (StringUtils.isEmpty(eventId)) {
//            return AjaxResult.warn("事件ID不能为空");
//        }
//        DingEvent dingEvent = dingEventService.getEventInfoByEventId(eventId);
//        if (dingEvent.getEventAlertStatus() == 4) {
//            return AjaxResult.warn("事件已退回，请勿重复操作");
//        }
//        if (dingEvent.getEventAlertStatus() != 3) {
//            return AjaxResult.warn("该事件当前状态无法退回");
//        }
//        return dingEventService.eventReturn(uid, appActionJson);
//    }

    /**
     * 事件上报
     *
     * @param userId
     * @param vo
     * @return
     */
    @PostMapping("/event/reportEvent/{userId}")
    @IdentityVerify
    public AjaxResult eventReport(@PathVariable @IdentityVerifys Long userId, @RequestBody EventReportVo vo) {
        logger.info("上报事件详细参数[{}]", JSONObject.toJSONString(vo));
        HkEventInfo event = vo.getEvent();
        PointDTO point = vo.getPoint();

        if (com.ruoyi.common.utils.StringUtils.isEmpty(event.getEventTitle())) {
            return AjaxResult.warn("请填写事件简述");
        }
        if (com.ruoyi.common.utils.StringUtils.isEmpty(event.getEventAddress())) {
            return AjaxResult.warn("请手动选择位置信息");
        }
        if (com.ruoyi.common.utils.StringUtils.isEmpty(event.getEventTypeName())) {
            return AjaxResult.warn("请选择上报事件类型");
        }
        //设置参数
        event.setEventId(UUID.randomUUID().toString().replaceAll("-", ""));
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date eventCreateTime = DateUtils.parseDate(event.getReportTime());
        event.setEventCreateTime(dateFormat.format(eventCreateTime));
        event.setReportType(2);
        event.setReportTypeName("人工上报");
        event.setRiskLevel("1");
        event.setEventStatus(5);
        event.setEventAlertStatus(2);
        event.setEventAlertStatusName("研判中");
        event.setCameraName(event.getEventAddress());
        if (event.getExtendInt3() == null) {
            event.setExtendInt3(5);//大屏显示弹窗配置项
        }
        String regionCode = "100";
        String regionName = "闲林街道";

        if (point != null) {
            if (!com.ruoyi.common.utils.StringUtils.isEmpty(point.getLongitude()) && !com.ruoyi.common.utils.StringUtils.isEmpty(point.getLatitude())) {
                //经纬度数组. 纬度-经度
                double[] convertPoint = GPSUtils.gcj02_To_Bd09(Double.parseDouble(point.getLatitude()), Double.parseDouble(point.getLongitude()));
                event.setLongitude(convertPoint[1] + "");
                event.setLatitude(convertPoint[0] + "");

                Double[] points = {convertPoint[1], convertPoint[0]};
                Map<String, Object> map1 = hkMapService.calculateRegionByLongitudeAndLatitude(points);
                regionCode = map1.get("regionId") + "";
                regionName = map1.get("regionName") + "";
            }
        }
        event.setReportPersonId(userId + "");//上报人id
        event.setRegionIndexCode(regionCode);
        event.setRegionName(regionName);
        event.setCreateTime(new Date());
        try {
            int count = eventService.reportEvent(event);
            if (count != 1) {
                return AjaxResult.error("上报失败");
            }
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            return AjaxResult.error("上报失败");
        }
        return AjaxResult.success("事件上报成功");
    }


    /**
     * 上报页面选取事件类型--获取上报事件类型先接口写死.
     *
     * @param userId
     * @return
     */
    @GetMapping("/event/types/{userId}")
    @IdentityVerify
    public AjaxResult getEventTypes(@PathVariable @IdentityVerifys Long userId) {

        String jsonArrStr =
                "[{\"eventTypeCode\":\"62055\",\"eventTypeName\":\"垃圾堆积\"},\n" +
                        "{\"eventTypeCode\":\"62056\",\"eventTypeName\":\"出店经营\"},\n" +
                        "{\"eventTypeCode\":\"62057\",\"eventTypeName\":\"无照经营游商\"},\n" +
                        "{\"eventTypeCode\":\"62040\",\"eventTypeName\":\"机动车违停\"},\n" +
                        "{\"eventTypeCode\":\"62054\",\"eventTypeName\":\"非机动车违停\"},\n" +
                        "{\"eventTypeCode\":\"62059\",\"eventTypeName\":\"违规广告\"},\n" +
                        "{\"eventTypeCode\":\"62061\",\"eventTypeName\":\"沿街晾挂\"},\n" +
                        "{\"eventTypeCode\":\"62053\",\"eventTypeName\":\"人员聚集\"},\n" +
                        "{\"eventTypeCode\":\"62063\",\"eventTypeName\":\"打包垃圾\"},\n" +
                        "{\"eventTypeCode\":\"62062\",\"eventTypeName\":\"垃圾箱垃圾溢出\"},\n" +
                        "{\"eventTypeCode\":\"62060\",\"eventTypeName\":\"垃圾暴露\"}]";
        return AjaxResult.success(JSONArray.parse(jsonArrStr));
    }

    /**
     * 获取行动流程
     *
     * @param userId
     * @param eventId
     * @return
     */
    private AjaxResult findHkActionProcess(Long userId, String eventId) {
        Map<String, Object> result = new HashMap<>();
        result.put("userId", userId);
        result.put("eventId", eventId);
        List<HkEventProcessRecord> hkEventProcessRecords = dingEventService.queryProcessRecordByParam(result);
        int count = hkEventProcessRecords.size();
        List<Map<String, Object>> list = new ArrayList<>();
        for (int i = 0; i < hkEventProcessRecords.size(); i++) {
            HkEventProcessRecord record = hkEventProcessRecords.get(i);
            if (count > 1) {
                Map<String, Object> lastRecord = new HashMap<>();
                appAction appAction = null;
                String handlerContent = record.getHandlerContent();
                if ("4".equals(record.getProcessStatus())) {//事件已点击提交
                    appAction = getFieldInfo(handlerContent);
                } else if ("5".equals(record.getProcessStatus())) {//事件退回
                    appAction = getFieldInfo(handlerContent);
                }
                if (appAction != null) {
                    lastRecord.put("status", record.getProcessStatus());
                    lastRecord.put("createTime", record.getCreateTime());
                    lastRecord.put("operationInfo", appAction);
                    list.add(lastRecord);
                }
            }
        }
        result.put("recordList", list);

        Map<String, Object> param = new HashMap<>();
        param.put("eventId", eventId);
        /**事件详情**/
        appHkevent appHkevent = appEventDetailService.selectOneHkevent(param);
        Integer eventAlertStatus = appHkevent.getEventAlertStatus();
        if (eventAlertStatus == 3 || eventAlertStatus == 5) {
            long nowTime = new Date().getTime();
            long endTime = appHkevent.getTimeOut().getTime();
            appHkevent.setPengTime((int) (endTime - nowTime) / 1000);
        } else if (eventAlertStatus == 9) {
            long nowTime = new Date().getTime();
            long endTime = appHkevent.getTimeOut().getTime();
            appHkevent.setOverTime((int) (endTime - nowTime) / 1000);
        }
        result.put("appHkevent", appHkevent);
        return AjaxResult.success(result);
    }

    /**
     * @param mss 要转换的毫秒数
     * @return 该毫秒数转换为 * days * hours * minutes * seconds 后的格式
     * @author guohailong
     */
    public static String formatDuring(long mss) {
        if (mss < 0) {
            mss = -mss;
        }
        //总天数的商拿到天数
        long days = mss / (1000 * 60 * 60 * 24);
        //总天数的余数拿到小时数
        long hours = (mss % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60);
        //总小时数的余数拿到分钟数
        long minutes = (mss % (1000 * 60 * 60)) / (1000 * 60);
        //总分钟数的余数拿到秒数
        long seconds = (mss % (1000 * 60)) / 1000;
//        System.out.println(days + " 天 " + hours + " 时 " + minutes + " 分 " + seconds + " 秒 ");
        String result;
        if (days > 0) {
            result = days + "天" + hours + "时";
        } else {
            if (hours > 0) {
                result = hours + "时" + minutes + "分";
            } else {
                if (minutes > 0) {
                    result = minutes + "分" + seconds + "秒";
                } else {
                    result = +seconds + "秒";
                }
            }
        }
        return result;
    }

    /**
     * @param begin 时间段的开始
     * @param end   时间段的结束
     * @return 输入的两个Date类型数据之间的时间间格用* days * hours * minutes * seconds的格式展示
     * @author guohailong
     */
    public static String formatDuring(Date begin, Date end) {
        return formatDuring(end.getTime() - begin.getTime());
    }

    /**
     * 开始处理数据
     * @return
     */
    public AjaxResult taskStart(Map<String,Object> event,List<Map> processlist,HKrecord hKrecord){
        try{
            logger.info("<<<<<<<<<<<开始添加行动流程，param:{}", JSON.toJSONString(processlist));
            logger.info("<<<<<<<<<<<开始修改海康事件记录，param:{}", JSON.toJSONString(event));
            dingEventService.updateEventAndProcess(event,processlist,hKrecord);
        }catch (Exception e){
            logger.error("确认警情异常:",e);
            return AjaxResult.error("确认警情异常，请联系管理人员。");
        }

        return AjaxResult.success();
    }

    /**
     * 非空判断
     * @param appActionJson
     * @return
     */
    public String inspection(appActionJson appActionJson){
        if (StringUtils.isEmpty(appActionJson.getHandleStatus())) {
            return "事件处置状态不能为空";
        }
        String eventId = appActionJson.getEventId();
        if (StringUtils.isEmpty(eventId)) {
            return "事件ID不能为空";
        }
        DingEvent dingEvent = dingEventService.getEventInfoByEventId(eventId);
        if (dingEvent == null) {
            return "事件不存在";
        }
        return "";
    }

    /**
     * 目录规则:/yyyy/MM/dd 按年月日生成文件存储路径目录
     * 如果网站访问量很大,上传文件很多时,还可以继续往下分:/yyyy/MM/dd/hh/mm..
     */
    public static String getDirectoryByYMD() {
        StringBuilder path = new StringBuilder();
        // 按系统当前时间计算出存储路径
        Calendar currTime = Calendar.getInstance();
        int year = currTime.get(Calendar.YEAR);
        int month = currTime.get(Calendar.MONTH) + 1;
        int day = currTime.get(Calendar.DAY_OF_MONTH);
        String monthStr = null;
        String dayStr = null;
        if (month < 10) {
            monthStr = "0" + month;
        } else {
            monthStr = "" + month;
        }
        if (day < 10) {
            dayStr = "0" + day;
        } else {
            dayStr = "" + day;
        }
        // 字符串拼接
        path.append(year).append("/").append(monthStr).append("/").append(dayStr).append("/");
        return path.toString();
    }

}
