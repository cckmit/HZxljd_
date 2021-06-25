package com.ruoyi.system.service.impl.ding;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.Action.HkActionProcess;
import com.ruoyi.system.domain.HKrecord;
import com.ruoyi.system.domain.HkEarlyWarning.HkEventInfo;
import com.ruoyi.system.domain.HkEventProcessRecord;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.domain.app.appActionJson;
import com.ruoyi.system.domain.app.appActionNow;
import com.ruoyi.system.domain.app.appField;
import com.ruoyi.system.domain.ding.DingEvent;
import com.ruoyi.system.mapper.*;
import com.ruoyi.system.mapper.ding.DingEventMapper;
import com.ruoyi.system.service.HkEarlyWarning.HkEventService;
import com.ruoyi.system.service.app.AppEventInfoService;
import com.ruoyi.system.service.ding.DingEventService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.ssssssss.magicapi.provider.MagicAPIService;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @ProjectName: ruoyi
 * @Package: com.ruoyi.system.service.impl.ding
 * @ClassName: DingEventServiceImpl
 * @Author: guohailong
 * @Description:
 * @Date: 2021/3/10 17:13
 * @Version: 1.0
 */
@Service
public class DingEventServiceImpl implements DingEventService {

    private Logger logger = LoggerFactory.getLogger(DingEventServiceImpl.class);

    @Resource
    private DingEventMapper dingEventMapper;

    @Autowired
    private appEventDetalisMapper appEventDetalisMapper;

    @Autowired
    private HkEventProcessRecordMapper processRecordMapper;

    @Autowired
    private AppEventInfoService appEventInfoService;

    @Autowired
    private HkActionProcessMapper hkActionProcessMapper;

    @Autowired
    private appEventInfoMapper appEventInfoMapper;

    @Autowired
    private SysUserMapper userMapper;

    @Autowired
    private HkAFieldMapper hkAFieldMapper;

    @Autowired
    private appMyWorkMapper appMyWorkMapper;

    @Autowired
    private HkEventService hkEventService;

    @Override
    public DingEvent getEventInfoByEventId(String eventId) {
        return dingEventMapper.getEventInfoByEventId(eventId);
    }

    @Override
    @Transactional
    public AjaxResult eventSign(Long userId, String eventId) {
        Map<String, Object> param = new HashMap<>();
        param.put("eventId", eventId);
        param.put("userId", userId);
        param.put("isComplete", "0");//未完成
        param.put("returnFlag", "0");//默认值
        // 查询当前行动信息
        HkActionProcess hkActionProcess = appEventInfoService.findHkActionProcessNow(param);
        // 行动id
        String commonlyId = hkActionProcess.getActionStandardId();
        // 签收人名称
        SysUser sysUser = userMapper.selectUserById(userId);
        String userName = sysUser.getUserName();
        // 添加到处理结果表
        appActionJson appActionJson = new appActionJson();
        appActionJson.setActionName("QS0001");
        appActionJson.setCommonlyId(commonlyId);
        appActionJson.setHandlerUserId(userId);
        appActionJson.setHandlerName(userName);
        appActionJson.setNowTime(DateUtils.getTime());
        appActionJson.setEventId(eventId);
        appActionJson.setHandlerContent("已签收");
        String json = JSONObject.toJSONString(appActionJson);
        HKrecord hKrecord = new HKrecord();
        // 添加处理内容
        hKrecord.setRecordId(UUID.randomUUID().toString().trim().replaceAll("-", ""));
        String s3 = Long.toString(appActionJson.getHandlerUserId());
        hKrecord.setHandlerIndexCode(s3);
        hKrecord.setHandlerContent(json);
        hKrecord.setEventId(appActionJson.getEventId());
        hKrecord.setExtendStr3(userName);
        hKrecord.setExtendInt3(Integer.parseInt(hkActionProcess.getHandlerOrder()));
        hKrecord.setProcessStatus("3");
        int count1 = appEventDetalisMapper.addHkrecond(hKrecord);
        if (count1 != 1) {
            logger.error("============添加处理记录失败============");
            throw new RuntimeException("签收失败");
        }
        int count2 = appEventDetalisMapper.updateManagementEvent(param);
        if (count2 != 1) {
            logger.error("============更新事件表状态失败============");
            throw new RuntimeException("签收失败");
        }
        return AjaxResult.success("签收成功");

    }

    @Override
    @Transactional
    public AjaxResult eventReturn(Long userId, appActionJson appActionJson) {
        String eventId = appActionJson.getEventId();
        Map<String, Object> param = new HashMap();
        param.put("eventId", eventId);
        param.put("userId", userId + "");
        //查询当前用户的未处理的事件流程信息
        HkActionProcess hkActionProcess = appEventDetalisMapper.queryActionProcessInfo(param);
        param.put("actionStandardId", hkActionProcess.getActionStandardId());
        appActionNow appActionNow = hkAFieldMapper.queryFieldByAction(param);
        // 修改事件表状态（退回）
        int count1 = appEventDetalisMapper.updateReturEvent(eventId);
        if (count1 != 1) {
            logger.error("============更新事件表状态失败============");
            throw new RuntimeException("退回失败");
        }
        /**g根据事件id,用户id，事件处置顺序更新当前流程的返回标识为已退回**/
        dingEventMapper.updateHkActionProcessByEventIdAndUserId(eventId, userId + "", hkActionProcess.getHandlerOrder());
        // 行动名称
        String actionName = appActionNow.getActionName();
        // 行动id
        String commonlyId = appActionNow.getCommonlyId();
        SysUser sysUser = userMapper.selectUserById(appActionJson.getHandlerUserId());
        String userName = sysUser.getUserName();
        appActionJson.setActionName(actionName);
        appActionJson.setCommonlyId(commonlyId);
        appActionJson.setHandlerName(userName);
        appActionJson.setNowTime(DateUtils.getTime());
        String json = JSONObject.toJSONString(appActionJson);
        HKrecord hKrecord = new HKrecord();
        // 添加处理内容
        hKrecord.setRecordId(UUID.randomUUID().toString().trim().replaceAll("-", ""));
        String s3 = Long.toString(appActionJson.getHandlerUserId());
        hKrecord.setHandlerIndexCode(s3);
        hKrecord.setHandlerContent(json);
        hKrecord.setEventId(appActionJson.getEventId());
        hKrecord.setProcessStatus("5");
        hKrecord.setExtendStr3(sysUser.getUserName());
        hKrecord.setExtendInt3(Integer.parseInt(hkActionProcess.getHandlerOrder()));
        int count2 = appEventDetalisMapper.addHkrecond(hKrecord);
        if (count2 != 1) {
            logger.error("============添加处理结果记录失败============");
            throw new RuntimeException("退回失败");
        }
        return AjaxResult.success("退回成功");
    }

    @Override
    public AjaxResult eventCommit() {
        return null;
    }

    @Override
    @Transactional
    public AjaxResult eventFeedback(Long userId, appActionJson appActionJson) {
        String eventId = appActionJson.getEventId();
        String handleStatus = appActionJson.getHandleStatus();
        Map<String, Object> param = new HashMap<>();
        param.put("eventId", eventId);
        param.put("returnFlag", 0);
        param.put("userId", userId + "");
        //查询当前用户的未处理的事件流程信息
        HkActionProcess hkActionProcess = appEventDetalisMapper.queryActionProcessInfo(param);
        param.put("userId", "");
        List<HkActionProcess> processes = appMyWorkMapper.queryActionProcessByParams(param);
        int count = processes.size();
        boolean flag = false;
        String nextUserId = null;
        for (HkActionProcess actionProcess : processes) {
            if (actionProcess.getHandlerUserId().equals(userId + "") && hkActionProcess.getHandlerOrder().equals(count + "")) {
                flag = true;
            } else {
                if (Long.parseLong(actionProcess.getHandlerOrder()) == (Long.parseLong(hkActionProcess.getHandlerOrder()) + 1)) {
                    nextUserId = actionProcess.getHandlerUserId();
                }
            }
        }
        HKrecord hKrecord = new HKrecord();
        // 添加处理内容
        String json = JSONObject.toJSONString(appActionJson);
        hKrecord.setRecordId(UUID.randomUUID().toString().trim().replaceAll("-", ""));
        String s3 = Long.toString(appActionJson.getHandlerUserId());
        SysUser sysUser = userMapper.selectUserById(appActionJson.getHandlerUserId());
        hKrecord.setHandlerIndexCode(s3);
        hKrecord.setHandlerContent(json);
        hKrecord.setEventId(appActionJson.getEventId());
        hKrecord.setProcessStatus("4");
        hKrecord.setExtendStr3(sysUser.getUserName());
        hKrecord.setExtendInt3(Integer.parseInt(hkActionProcess.getHandlerOrder()));
        int count1 = appEventDetalisMapper.addHkrecond(hKrecord);
        if (count1 != 1) {
            logger.error("============添加处理结果记录失败============");
            throw new RuntimeException("数据更新失败");
        }
        param.put("isComplete", "1");
        param.put("handlerOrder", hkActionProcess.getHandlerOrder());
        param.put("handlerUserId", userId + "");//当前用户
        int count2 = dingEventMapper.updateHkActionByParam(param);//更新当前用户为已完结
        if (count2 != 1) {
            logger.error("============更新行动流程状态失败============");
            throw new RuntimeException("数据更新失败");
        }
        if (!flag) {//非最后一级行动流程
            if ("0".equals(handleStatus)) {//已处理
                /**当前状态下，
                 * 新增事件处置记录表process_record表状态为4
                 * 完结事件,
                 * 更新所有action_process表事件下当前行动流程和未处置的行动流程信息为已完成**/
                param.put("handlerUserId", "");
                param.put("otherUserId", userId + "");//非当前用户
                param.put("handlerOrder", hkActionProcess.getHandlerOrder());//非当前用户
                param.put("afterReturnFlag", 3);//未处置已完结
                int count3 = dingEventMapper.updateOtherHkActionProcessByParam(param);//更新其他用户为未处置已完结
                if (count3 != 1) {
                    logger.error("============更新其他行动流程状态失败============");
                    throw new RuntimeException("数据更新失败");
                }
                SysUser user = userMapper.selectUserById(userId);
                HkEventInfo event = hkEventService.findEventByEventId(appActionJson.getEventId());
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                /*JSONObject voiceJson = JSON.parseObject(appActionJson.getHandlerContent());
                String processResult = voiceJson.getString("handlerContent");*/
                String processResult = appActionJson.getHandlerContent();
                Map<String,Object> postParam = new HashMap<>();
                postParam.put("eventId",appActionJson.getEventId());
                postParam.put("eventIndexCode",event.getEventIndexCode());
                postParam.put("handlerUserId",user.getUserId());
                postParam.put("handlerUserName",user.getUserName());
                postParam.put("eventAlertStatus",6);
                postParam.put("processTime",sdf.format(new Date()));
                postParam.put("processResult",processResult);
                hkEventService.feedbackAllStatusEvent(event.getComponentId(),postParam);

                // 修改事件表状态（完结）
                int count4 = appEventDetalisMapper.updateEventInfo(eventId);
                if (count4 != 1) {
                    logger.error("============更新事件状态失败============");
                    throw new RuntimeException("数据更新失败");
                }
            } else if ("1".equals(handleStatus)) {//未处理
                /**当前状态下，
                 * 新增事件处置记录表process_record表状态为4，
                 * 更新当前行动流程action_process信息为已完成
                 * 若当前行动流程为最后一级，完结事件
                 * 若当前行动流程为非最后一级，更新事件为调度中
                 * 事件流转到行动链下一级
                 * 更新
                 * **/
                /**更新事件状态为调度中**/
                try {
                    //为实现事件操作记录留痕时的记录排序
                    Thread.sleep(1000);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                HKrecord hKrecord1 = new HKrecord();
                hKrecord1.setRecordId(UUID.randomUUID().toString().trim().replaceAll("-", ""));
                hKrecord1.setHandlerIndexCode(nextUserId);
                hKrecord1.setEventId(appActionJson.getEventId());
                hKrecord1.setProcessStatus("2");
                hKrecord1.setExtendStr3("系统自动分配");
                hKrecord.setExtendInt3(Integer.parseInt(hkActionProcess.getHandlerOrder()) + 1);
                int count6 = appEventDetalisMapper.addHkrecond(hKrecord1);
                if (count6 != 1) {
                    logger.error("============添加调度记录失败============");
                    throw new RuntimeException("数据更新失败");
                }
                int count5 = appEventDetalisMapper.updateEventDispatch(eventId);
                if (count5 != 1) {
                    logger.error("============更新事件状态失败============");
                    throw new RuntimeException("数据更新失败");
                }
            }
        } else {//最后一级行动流程
            SysUser user = userMapper.selectUserById(userId);
            HkEventInfo event = hkEventService.findEventByEventId(appActionJson.getEventId());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            //JSONObject voiceJson = JSON.parseObject(appActionJson.getHandlerContent());
            //String processResult = voiceJson.getString("handlerContent");
            String processResult = appActionJson.getHandlerContent();
            Map<String,Object> postParam = new HashMap<>();
            postParam.put("eventId",appActionJson.getEventId());
            postParam.put("eventIndexCode",event.getEventIndexCode());
            postParam.put("handlerUserId",user.getUserId());
            postParam.put("handlerUserName",user.getUserName());
            postParam.put("eventAlertStatus",6);
            postParam.put("processTime",sdf.format(new Date()));
            postParam.put("processResult",processResult);
            hkEventService.feedbackAllStatusEvent(event.getComponentId(),postParam);
            // 修改事件表状态（完结）
            int count6 = appEventDetalisMapper.updateEventInfo(eventId);
            if (count6 != 1) {
                logger.error("============更新事件状态失败============");
                throw new RuntimeException("数据更新失败");
            }
        }
        return AjaxResult.success("提交成功");
    }

    @Override
    public void updateHkActionProcessByEventIdAndUserId(String eventId, String userId, String handlerOrder) {
        dingEventMapper.updateHkActionProcessByEventIdAndUserId(eventId, userId, handlerOrder);
    }

    @Override
    public List<HkEventProcessRecord> queryProcessRecordByParam(Map<String, Object> param) {
        return processRecordMapper.queryProcessRecordByParam(param);
    }
    /**
     * 维护3个表的数据
     * @param event     事件信息
     * @param process   事件流程完成信息
     * @param record    事件操作记录
     * @return
     */
    @Override
    @Transactional
    public Boolean updateEventAndProcess(Map event, List<Map> process, HKrecord record) {
        int num1 = appEventInfoMapper.updateHkActionState(event);               //更新事件信息
        int num2 = appEventDetalisMapper.addHkrecond(record);                   //添加事件操作记录
        int num3 = hkActionProcessMapper.updateAppHkActionProcess(process);     //更新事件流程
        if(process.size() == 0) num3++;
        if (!(num1 > 0 && num2 > 0 && num3 > 0)){
            throw new RuntimeException("确认警情异常，请联系管理人员。");
        }
        return true;
    }
}
