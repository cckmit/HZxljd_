package com.ruoyi.system.service.impl.HkEarlyWarning;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.Arith;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.http.HttpUtils;
import com.ruoyi.system.domain.*;
import com.ruoyi.system.domain.Action.HkActionProcess;
import com.ruoyi.system.domain.HkEarlyWarning.*;
import com.ruoyi.system.domain.HkEarlyWarning.HkEventInfo;
import com.ruoyi.system.domain.HkEntity.EventBackProcessRecordVo;
import com.ruoyi.system.domain.HkEntity.EventBackVo;
import com.ruoyi.system.domain.HkEntity.EventSearchVO;
import com.ruoyi.system.domain.app.AppActionInfo;
import com.ruoyi.system.domain.app.appField;
import com.ruoyi.system.domain.vo.CameraIndexCodeVo;
import com.ruoyi.system.domain.vo.EventListCountVo;
import com.ruoyi.system.mapper.*;
import com.ruoyi.system.service.HkEarlyWarning.HkEventService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author FanKaibiao
 * @date 2020-11-03-17:36
 */
@Service
public class HkEventServiceImpl implements HkEventService {

    private Logger logger = LoggerFactory.getLogger(HkEventServiceImpl.class);

    @Autowired
    private HkEventMapper hkEventMapper;

    @Autowired
    private HkActionProcessMapper hkActionProcessMapper;

    @Autowired
    private appEventDetalisMapper appEventDetalisMapper;

    @Autowired
    private HkLmanagementInfoMapper hkLmanagementInfoMapper;

    @Autowired
    private HkEventProcessRecordMapper processRecordMapper;

    @Value("${platform.cg.url}")
    private String cgUrl;

    @Value("${platform.zz.url}")
    private String zzUrl;





    @Override
    public int reportEvent(HkEventInfo event) {
        /**
         * 查询重复报警，根据未流转的事件查询最近2小时的重复事件，最新一条展示，之前重复的隐藏
         * 添加重复报警事件的关联字段extendStr3，
         */
        //判断是否重复
        HkEventInfo param2 = new HkEventInfo();
        param2.setComponentId(event.getComponentId());//接入事件的平台编码
        param2.setRegionIndexCode(event.getEventIndexCode());//各平台的事件唯一标识
        param2.setEventTypeName(event.getEventTypeName());//各平台的事件类型
        param2.setEventCreateTime(event.getEventCreateTime());//事件上报当天
        param2.setEventAddress(event.getEventAddress());//事件上报当天
        param2.setReportTime(event.getReportTime());
        param2.setPlateNo(event.getPlateNo());
        String repeatCode = queryEventRepeat(param2);
        if(!StringUtils.isEmpty(repeatCode)){
            event.setExtendStr3(repeatCode);
            int repeatResult = hkEventMapper.updateRepeatCode(repeatCode);
            if(repeatResult == 0){
                logger.info("===============更新重复事件失败=================");
                throw new RuntimeException("事件保存失败");
            }
        }else{
            String uuid = UUID.randomUUID().toString().replaceAll("-","");
            event.setExtendStr3(uuid);
        }
        return hkEventMapper.addHKEventInfo(event);
    }

    @Override
    public PageInfo<EventBackVo> queryEventResult(EventBackVo vo) {
        PageHelper.startPage(vo.getPageNum(),vo.getPageSize());
        List<EventBackVo> list = hkEventMapper.queryEventResult(vo);
        PageInfo<EventBackVo> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }

    /*
    *
    * for(EventBackVo dto : list){
            List<EventBackProcessRecordVo> eventBackProcessRecordVos = processRecordMapper.queryProcessRecordList(dto.getEventId());
            for(EventBackProcessRecordVo record : eventBackProcessRecordVos){
                boolean flag = false;
                switch (record.getProcessStatus()){
                    case "1"://重新指派
                        record.setProcessResult("已重新指派");
                        break;
                    case "2"://指派
                        record.setProcessResult("已指派");
                        break;
                    case "3"://签收
                        record.setProcessResult("已签收");
                        break;
                    case "4"://已处置
                        flag = true;
                        break;
                    case "5"://退回
                        flag = true;
                        record.setProcessResult("已退回");
                        break;
                    case "6"://中心处置
                        record.setProcessResult("已中心处置");
                        break;
                    case "7"://忽略
                        record.setProcessResult("已忽略");
                        break;
                    case "8"://异常
                        record.setProcessResult("异常报送");
                        break;
                    default:
                        break;
                }
                //
                if(flag){
                    String handlerContent = record.getProcessResult();
                    AppActionInfo as  =  JSONObject.parseObject(handlerContent, AppActionInfo.class);
                    List<appField> listInfo = JSONObject.parseArray(as.getAppField(), appField.class);
                    for(appField field : listInfo){
                        if("处理意见".equals(field.getFieldType())){
                            String fieldValue = field.getFieldValue();
                            record.setProcessResult(fieldValue);
                            break;
                        }
                    }
                }else{

                }
            }
        }
    *
    *
    *
    * */

    @Override
    public int selectEventRepeat(HkEventInfo eventInfo) {
        return hkEventMapper.selectEventRepeat(eventInfo);
    }

    /**
     * 查询重复事件上报
     * 若重复 返回 已存在的对应事件的重复标识
     * @param event
     * @return
     */
    public String queryEventRepeat(HkEventInfo event) {
        String result = "";
        event.setRepeatTime(DateUtils.getLastRequestTime(1000*60*60*2L));
        if(!StringUtils.isEmpty(event.getPlateNo())){
            HkEventInfo param2 = new HkEventInfo();
            param2.setComponentId(event.getComponentId());//接入事件的平台编码
            param2.setEventCreateTime(event.getEventCreateTime());//事件上报当天
            param2.setEventAddress(event.getEventAddress());//事件上报当天
            param2.setRepeatTime(event.getRepeatTime());
            param2.setPlateNo(event.getPlateNo());
            param2.setEventAlertStatus(event.getEventAlertStatus());
            result = hkEventMapper.queryEventRepeat(param2);
        }else {
            HkEventInfo param2 = new HkEventInfo();
            param2.setComponentId(event.getComponentId());//接入事件的平台编码
            param2.setEventTypeName(event.getEventTypeName());//各平台的事件类型
            param2.setEventCreateTime(event.getEventCreateTime());//事件上报当天
            param2.setEventAddress(event.getEventAddress());//事件上报当天
            param2.setRepeatTime(event.getRepeatTime());
            param2.setEventAlertStatus(event.getEventAlertStatus());
            result = hkEventMapper.queryEventRepeat(param2);
        }
        if(StringUtils.isEmpty(result)){
            HkEventInfo param1 = new HkEventInfo();
            param1.setComponentId(event.getComponentId());//接入事件的平台编码
            param1.setRegionIndexCode(event.getEventIndexCode());//各平台的事件唯一标识
            param1.setEventAlertStatus(event.getEventAlertStatus());
            result = hkEventMapper.queryEventRepeat(param1);
        }
        return result;
    }

    @Override
    public int queryEventCountRepeat(String extendStr3) {
        return hkEventMapper.queryEventCountRepeat(extendStr3);
    }

    @Override
    public HkEventInfo queryEventDetail(Integer id) {
        HkEventInfo eventInfo = hkEventMapper.findEventById(id);
        if(eventInfo != null){
            List<HkLmanagementInfo> hkLmanagements = hkLmanagementInfoMapper.queryLmByEvent((long) id);
            eventInfo.setHkLmanagements(hkLmanagements);
            /**查询事件的处置图片集合**/
            Map<String,Object> param = new HashMap<>();
            param.put("eventId",eventInfo.getEventId());
            param.put("processStatus","4");//查询处置记录
            List<HKrecord> hKrecords = appEventDetalisMapper.selectProcessByParams(param);
            List<Map<String,String>> picList = new ArrayList<>();
            if(hKrecords != null && hKrecords.size() > 0){
                for(HKrecord record : hKrecords){
                    String json = record.getHandlerContent();
                    JSONObject voiceJson = JSON.parseObject(json);
                    String s = voiceJson.getString("appField");
                    List<appField> appFieldList = JSON.parseArray(s, appField.class);
                    for(appField appField : appFieldList){
                        if("图片".equals(appField.getFieldType())){
                            String fieldValue = appField.getFieldValue();
                            String[] split = fieldValue.split("\\|");
                            List<String> stringList = Arrays.asList(split);
                            for(String str : stringList){
                                Map<String,String> subParam = new HashMap<>();
                                subParam.put("type","after");
                                subParam.put("pic",str);
                                picList.add(subParam);
                            }
                        }
                    }
                }
            }
            String eventImage = eventInfo.getEventImage();
            if(!StringUtils.isEmpty(eventImage)){
                String[] split = eventImage.split("\\|");
                List<String> stringList = Arrays.asList(split);
                for(String str : stringList){
                    Map<String,String> subParam = new HashMap<>();
                    subParam.put("type","before");
                    subParam.put("pic",str);
                    picList.add(subParam);
                }
            }
            String videoPath = eventInfo.getExtendStr1();
            if(!StringUtils.isEmpty(videoPath) || "1001".equals(eventInfo.getComponentId())){
                Map<String,String> subParam = new HashMap<>();
                subParam.put("type","before");
                subParam.put("video","1");
                picList.add(subParam);
            }
            eventInfo.setPicList(picList);
        }
        return eventInfo;
    }

    /**
     * 忽略警情
     * @param hkEventInfo
     * @return
     */
    @Override
    @Transactional
    public int updateEventStatus(HkEventInfo hkEventInfo, SysUser user) {
        HkEventInfo eventInfo = hkEventMapper.findEventById(hkEventInfo.getId());
        HKrecord hKrecord = new HKrecord();
        // 添加处理内容
        hKrecord.setRecordId(UUID.randomUUID().toString().trim().replaceAll("-", ""));
        hKrecord.setHandlerContent("忽略警情");
        hKrecord.setEventId(eventInfo.getEventId());
        hKrecord.setProcessStatus("7");//指派
        hKrecord.setHandlerIndexCode(user.getUserId()+"");
        hKrecord.setExtendStr3(user.getUserName());
        int count1 = appEventDetalisMapper.addHkrecond(hKrecord);
        if(count1 < 1){
            logger.info("===============添加事件操作记录失败==================");
            throw new RuntimeException("忽略警情失败");
        }
        int count2 = hkEventMapper.updateEventStatus(hkEventInfo);
        if(count2 < 1){
            logger.info("===============更新事件状态失败==================");
            throw new RuntimeException("忽略警情失败");
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Map<String,Object> param = new HashMap<>();
        param.put("eventId",eventInfo.getEventId());
        param.put("eventIndexCode",eventInfo.getEventIndexCode());
        param.put("handlerUserId",user.getUserId());
        param.put("handlerUserName",user.getUserName());
        param.put("eventAlertStatus",7);
        param.put("processTime",sdf.format(new Date()));
        param.put("processResult","忽略警情");
        this.feedbackAllStatusEvent(eventInfo.getComponentId(),param);
        return count2;
    }

    @Override
    public List<HkEventInfo> searchEventInfo(EventSearchVO vo) {
        return hkEventMapper.searchEventInfo(vo);
    }

    @Override
    public List<HkEventInfo> findEventHistory(HkEventInfo eventInfo) {
        return hkEventMapper.findEventHistory(eventInfo);
    }

    @Override
    public List<HkEventInfo> queryHkEventInfo(HkEventInfo hkEventInfo) {
        return hkEventMapper.queryHkEventInfo(hkEventInfo);
    }

    @Override
    public List<HkEventInfo> findEventTypeName() {
        return hkEventMapper.findEventTypeName();
    }

    @Override
    public HkEventInfo findEventByEventId(String eventId) {
        return hkEventMapper.findEventByEventId(eventId);
    }

    @Override
    public int updateAssignInfo(EventAssignVO vo) {
        return hkEventMapper.updateAssignInfo(vo);
    }

    /**
     * 事件异常报送
     * @param hkEventInfo
     * @return
     */
    @Override
    @Transactional
    public int closeEventStatus(HkEventInfo hkEventInfo,SysUser user) {
        HkEventInfo eventInfo = hkEventMapper.findEventById(hkEventInfo.getId());
        HKrecord hKrecord = new HKrecord();
        // 添加处理内容
        hKrecord.setRecordId(UUID.randomUUID().toString().trim().replaceAll("-", ""));
        hKrecord.setHandlerContent("异常报送");
        hKrecord.setEventId(eventInfo.getEventId());
        hKrecord.setProcessStatus("8");//指派
        hKrecord.setHandlerIndexCode(user.getUserId()+"");
        hKrecord.setExtendStr3(user.getUserName());
        int count1 = appEventDetalisMapper.addHkrecond(hKrecord);
        if(count1 < 1){
            logger.info("==============添加异常报送操作记录失败=================");
            throw new RuntimeException("异常报送失败");
        }
        int count2 = hkEventMapper.closeEventStatus(hkEventInfo);
        if(count2 < 1){
            logger.info("==============更新事件状态失败=================");
            throw new RuntimeException("异常报送失败");
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Map<String,Object> param = new HashMap<>();
        param.put("eventId",eventInfo.getEventId());
        param.put("eventIndexCode",eventInfo.getEventIndexCode());
        param.put("handlerUserId",user.getUserId());
        param.put("handlerUserName",user.getUserName());
        param.put("eventAlertStatus",8);
        param.put("processTime",sdf.format(new Date()));
        param.put("processResult","异常报送");
        this.feedbackAllStatusEvent(eventInfo.getComponentId(),param);
        return count2;
    }

    @Override
    public void updateEventRead(HkEventInfo hkEventInfo) {
        hkEventMapper.updateEventRead(hkEventInfo);
    }

    @Override
    public void updateEventReadType(Integer id) {
        hkEventMapper.updateEventReadType(id);
    }

    /**
     * 定时任务添加事件表
     * @param hkEventInfo
     * @return
     */
    @Override
    public int addHKEventInfo(HkEventInfo hkEventInfo) {
        return hkEventMapper.addHKEventInfo(hkEventInfo);
    }

    @Override
    public int findPendingCount() {
        return hkEventMapper.findPendingCount();
    }

    @Override
    public int getTodayEventCount() {
        return hkEventMapper.getTodayEventCount();
    }

    @Override
    public int findEventEndCount() {
        return hkEventMapper.findEventEndCount();
    }

    @Override
    public int findDisposalCount() {
        return hkEventMapper.findDisposalCount();
    }

    @Override
    public int findOverdueCount() {
        return hkEventMapper.findOverdueCount();
    }

    @Override
    public Map<String, Object> findHKEventCount() { return hkEventMapper.findHKEventCount(); }

    @Override
    public List<EventChengguanVO> getIntervalCount() {
        List<Integer> list =  selectFuryTime();
        List<EventChengguanVO> VO = new ArrayList<>();
        list.forEach( time->{
            EventChengguanVO item = new EventChengguanVO();
            List<EventChenAccVO> intervalCount = hkEventMapper.getIntervalCount(time);
            intervalCount.forEach(interval ->{
                Double div = Arith.div(interval.getCount(),interval.getPercentage());
                item.setPercentage(interval.getPercentage());
                interval.setAccounted(div+"%");
            });
            item.setList(intervalCount);
            item.setPeriodTime(time+":00"+"-"+(time+1)+":00");
            VO.add(item);
        });
        return VO;
    }

    @Override
    public List<Integer> selectFuryTime() { return hkEventMapper.selectFuryTime(); }

    @Override
    public List<KeyViolationsVO> getKeyViolations() {
        List<KeyViolationsVO> fiveColorCount = hkEventMapper.getKeyViolations();
        Integer poor = fiveColorCount.get(0).getSum();
        for (int i = 0; i < fiveColorCount.size(); i++) {
            fiveColorCount.get(i).setAccounted(Arith.div(fiveColorCount.get(i).getCount(),fiveColorCount.get(i).getSum())+"%");
            poor -= fiveColorCount.get(i).getCount();
        }
        KeyViolationsVO fiveColorVO = new KeyViolationsVO();
        fiveColorVO.setTitle("其他");
        fiveColorVO.setCount(poor);
        fiveColorVO.setSum(fiveColorCount.get(0).getSum());
        fiveColorVO.setAccounted(Arith.div(fiveColorVO.getCount(),fiveColorVO.getSum())+"%");
        fiveColorCount.add(fiveColorVO);
        return fiveColorCount;
    }

    @Override
    public Map<String, String> getTodayHandleProp() {
        Map<String, String> todayHandleProp = hkEventMapper.getTodayHandleProp();
        String eventend = String.valueOf(todayHandleProp.get("eventend"));
        String sum = String.valueOf(todayHandleProp.get("sum"));
        Double div = Arith.div(Integer.valueOf(eventend), Integer.valueOf(sum));
        todayHandleProp.put("proportion",div+"%");
        return todayHandleProp;
    }

    @Override
    public List<HkEventInfo> selectEventInfoAll(HkEventInfo hkEventInfo) {
        List<HkEventInfo> list=hkEventMapper.selectEventInfoAll(hkEventInfo);
        return list ;
    }
    /**
     * //工作概要的预警信息
     * @return
     */
    @Override
    public List<HkEventInfo> queryEventOrder() {
        return hkEventMapper.queryEventOrder();
    }

    /**
     * //工作概要的消息通知
     * @return
     */
    @Override
    public List<HkEventInfo> queryEventOrderEnd() {
        return hkEventMapper.queryEventOrderEnd();
    }

    @Override
    public void updateExtendStr(HkEventInfo hkEventInfo) {
        hkEventMapper.updateExtendStr(hkEventInfo);
    }

    @Override
    public List<HkEventInfo> findExtendStr(String eventId) {
        return hkEventMapper.findExtendStr(eventId);
    }

    @Override
    @Transactional
    public boolean updateEventAndProcess(HkEventInfo hkEventInfo, List<HkActionProcess> list, HKrecord hKrecord,SysUser user) {
        HkEventInfo event = hkEventMapper.findEventById(hkEventInfo.getId());
        int num1 = hkActionProcessMapper.insertBatchHkActionProcess(list);//批量新增行动流程表
        int num2 = appEventDetalisMapper.addHkrecond(hKrecord);//添加事件操作记录
        int num3 = hkEventMapper.updateHkEventInfo(hkEventInfo);//更新事件
        if (!(num1 > 0 && num2 > 0 && num3 > 0)){
            throw new RuntimeException("确认警情异常，请联系管理人员。");
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Map<String,Object> param = new HashMap<>();
        param.put("eventId",event.getEventId());
        param.put("eventIndexCode",event.getEventIndexCode());
        param.put("handlerUserId",user.getUserId());
        param.put("handlerUserName",user.getUserName());
        param.put("eventAlertStatus",3);
        param.put("processTime",sdf.format(new Date()));
        param.put("processResult","确认警情");
        this.feedbackAllStatusEvent(event.getComponentId(),param);
        return true;
    }

    @Override
    @Transactional
    public AjaxResult addLmanagementByEvent(HkEventLmanageVo vo) {
        List<HkEventLmanage> list = new ArrayList<>();
        List<Map<String, Object>> lmList = vo.getLmList();
        int count = hkEventMapper.updateRiskLevelById(vo.getRiskLevel(), vo.getEventId());
        if(count != 1){
            logger.info("============更新事件风险等级失败===============");
            throw new RuntimeException("标签保存失败");
        }
        /**删除事件标签关联信息**/
        Map<String,Long> param = new HashMap<>();
        param.put("eventId",vo.getEventId());
        hkLmanagementInfoMapper.deleteEventLmanager(param);
        if(lmList != null && lmList.size() > 0){
            for(Map<String,Object> map : lmList){
                HkEventLmanage hel = new HkEventLmanage();
                HkLmanagementInfo  hlm = new HkLmanagementInfo();
                String lmId = map.get("lmId")+"";
                if(!StringUtils.isEmpty(lmId)){
                    hel.setLmId(Long.parseLong(lmId));
                    hel.setEventId(vo.getEventId());
                    /*标签在事件信息中无法修改，只能选中和新增*/
                /*
                hlm.setLmName(map.get("lmName")+"");
                hlm.setLmId((long)map.get("lmId"));
                hkLmanagementMapper.updateHkLmanagement(hlm);
                */
                }else{
                    hlm.setLmName(map.get("lmName")+"");
                    hlm.setCreateBy(vo.getCreateUser());
                    int count1 = hkLmanagementInfoMapper.insertHkLmanagementBackPriKey(hlm);
                    if(count1 != 1){
                        throw new RuntimeException("标签保存失败");
                    }
                    if(hlm.getLmId() == null){
                        logger.info("==========添加标签失败===========");
                        throw new RuntimeException("标签保存失败");
                    }
                    hel.setLmId(hlm.getLmId());
                    hel.setEventId(vo.getEventId());
                }
                list.add(hel);
            }
            /**新增事件标签关联信息**/
            hkLmanagementInfoMapper.insertEventLmanager(list);
        }
        return AjaxResult.success("保存成功");
    }

    @Override
    public String feedbackAllStatusEvent(String componentId ,Map<String,Object> param) {
        String result = null;
        if(!StringUtils.isEmpty(componentId)){
            if("1001".equals(componentId)){
                logger.info("===================》城管事件反馈=》》》》》》》》》》》》》》》》》");
//                result = HttpUtils.doPostJson(cgUrl, JSONObject.toJSONString(param));
            }else if("1002".equals(componentId)){
                logger.info("===================》浙里访事件反馈=》》》》》》》》》》》》》》》》》");
                //result = HttpUtils.doPostJson(zzUrl,JSONObject.toJSONString(param));
            }else if("1003".equals(componentId)){
                logger.info("===================》综治事件反馈=》》》》》》》》》》》》》》》》》");
                //result = HttpUtils.doPostJson(zzUrl,JSONObject.toJSONString(param));
            }
            logger.info("《《传参》》"+JSONObject.toJSONString(param));
        }
        return result;
    }

    @Override
    public int queryEventEventIndexCode(String eventIndexCode) {
        return hkEventMapper.queryEventEventIndexCode(eventIndexCode);
    }

    @Override
    public List<HkEventInfo> queryIllegaDeail(HkEventInfo hkEventInfo) {
        return hkEventMapper.queryIllegaDeail(hkEventInfo);
    }

    @Override
    public List<HkEventInfo> selectEventList(HkEventInfo hkEventInfo) {
        return hkEventMapper.selectEventList(hkEventInfo);
    }

    @Override
    public int queryEventAllCount(Map<String, Object> thingResult) {
        return hkEventMapper.queryEventAllCount(thingResult);
    }

    @Override
    public int queryLastEventAllCount(Map<String, Object> thingResult) {
        return hkEventMapper.queryLastEventAllCount(thingResult);
    }

    @Override
    public int queryPlatformEvent(Map<String, Object> thingResult) {
        return hkEventMapper.queryPlatformEvent(thingResult);
    }

    @Override
    public List<HkEventInfo> queryEventInfoAllList(Map<String, Object> thingResult) {
        return hkEventMapper.queryEventInfoAllList(thingResult);
    }

    @Override
    public int queryEvaluate(Map<String, Object> thingResult) {
        return hkEventMapper.queryEvaluate(thingResult);
    }

    @Override
    public int eventSource(Map<String, Object> thingResult) {
        return hkEventMapper.eventSource(thingResult);
    }

    @Override
    public List<HkEventInfo> queryEventOne() {
        return hkEventMapper.queryEventOne();
    }

    @Override
    public List<HkEventInfo> queryeventChengInfo(Map<String, Object> thingResult) {
        return hkEventMapper.queryeventChengInfo(thingResult);
    }

    @Override
    public int queryeventCountAll(Map<String,Object> paramsAll) {
        return hkEventMapper.queryeventCountAll(paramsAll);
    }

    @Override
    public List<EventListCountVo> queryLongitude(Map<String, Object> thingResult) {
        return hkEventMapper.queryLongitude(thingResult);
    }

    @Override
    public Integer queryEventCountByList(Map<String, Object> params) {
        return hkEventMapper.queryEventCountByList(params);
    }

    @Override
    public List<CameraIndexCodeVo> querycameraIndexCode(Map<String, Object> params) {
        return hkEventMapper.querycameraIndexCode(params);
    }

    @Override
    public List<HkEventInfo> findEventByIdAll(Integer id) {
        return hkEventMapper.findEventByIdAll(id);
    }

    @Override
    public void updateByIdRiskLevel(Integer id) {
        hkEventMapper.updateByIdRiskLevel(id);
    }

}
