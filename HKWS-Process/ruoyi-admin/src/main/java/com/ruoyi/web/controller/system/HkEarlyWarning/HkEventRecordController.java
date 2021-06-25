package com.ruoyi.web.controller.system.HkEarlyWarning;

import cn.hutool.core.date.BetweenFormatter;
import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.util.StringUtil;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.Action.HkActionProcess;
import com.ruoyi.system.domain.HKrecord;
import com.ruoyi.system.domain.HkEarlyWarning.HkEventInfo;
import com.ruoyi.system.domain.HkEntity.EventAfreshAssignVo;
import com.ruoyi.system.domain.HkEntity.EventProcessRecordDTO;
import com.ruoyi.system.domain.HkEntity.EventSearchVO;
import com.ruoyi.system.domain.HkEntity.UserInfoDto;
import com.ruoyi.system.domain.SysDept;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.domain.app.*;
import com.ruoyi.system.service.HkEarlyWarning.HkEventRecordService;
import com.ruoyi.system.service.HkEarlyWarning.HkEventService;
import com.ruoyi.system.service.ISysDeptService;
import com.ruoyi.system.service.ISysRanksService;
import com.ruoyi.system.service.ISysUserService;
import com.ruoyi.system.service.app.AppEventDetailService;
import com.ruoyi.system.service.app.AppMyWorkService;
import com.ruoyi.system.service.statistics.HkEventStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.management.ObjectName;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author FanKaibiao
 * @date 2020-11-05-16:59
 */
@Controller
@RequestMapping("system/eventRecord")
public class HkEventRecordController extends BaseController {

    private String prefix = "system/eventRecord";

    @Autowired
    private HkEventRecordService hkEventRecordService;

    @Autowired
    private AppMyWorkService appMyWorkService;

    @Autowired
    private AppEventDetailService appEventDetailService;

    @Autowired
    private HkEventStatisticsService statisticsService;

    @Autowired
    private HkEventService hkEventService;

    @Autowired
    private ISysUserService userService;

    @Autowired
    private ISysRanksService ranksService;

    @Autowired
    private ISysDeptService iSysDeptService;

    @GetMapping("")
    public String eventList(){
        return prefix + "/eventRecord";
    }

    /**
     * 事件详情
     * @param id
     * @return
     */
    @GetMapping("recordDetails")
    @ResponseBody
    public AjaxResult recordDetail(Integer id){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        HkEventInfo eventInfo= hkEventService.queryEventDetail(id);
        if(eventInfo == null){
            return AjaxResult.error("该事件信息不存在");
        }
        String eventId = eventInfo.getEventId();
        Date dispatchTime = appEventDetailService.getEventRecordDispatchTime(eventId);//查询最近调度时间
        if(dispatchTime == null){
            eventInfo.setTodoTime("");
        }else{
            String format = dateFormat.format(dispatchTime);
            eventInfo.setTodoTime(format);
        }
        //查询最近签收时间
        Date recordList= appEventDetailService.getEventRecordTime(eventId,"3");
        if(recordList ==null){
            eventInfo.setSignTime("");
        }else{
            String format = dateFormat.format(recordList);
            eventInfo.setSignTime(format);
        }
        //查询最近处理完结时间
        Date endList= appEventDetailService.getEventRecordHandleTime(eventId);
        if(endList ==null){
            eventInfo.setEndTime("");
        }else{
            String format = dateFormat.format(endList);
            eventInfo.setEndTime(format);
        }
        Date createTime = eventInfo.getCreateTime();
        String procdefType = eventInfo.getProcdefType();
        List<Map<String,Object>> list = new ArrayList<>();
        HkActionProcess process1 = new HkActionProcess();
        process1.setActionChainId(procdefType);
        process1.setEventId(eventId);
        List<HkActionProcess> hkActionProcess= appMyWorkService.findactionChainId(process1);
        int count = hkActionProcess.size();
        eventInfo.setCount(count);
        if(hkActionProcess.size() == 1){
            Date createTime1 = hkActionProcess.get(0).getCreateTime();
            String handlerUserId = hkActionProcess.get(0).getHandlerUserId();
            String handlerOrder = hkActionProcess.get(0).getHandlerOrder();
            SysUser user = userService.selectUserById(Long.parseLong(handlerUserId));
            String userName = user.getUserName();
            eventInfo.setTodoUserName(userName);
            eventInfo.setHandlerOrder(handlerOrder);
            String format = dateFormat.format(createTime1);
            eventInfo.setTodoTime(format);
        }else if (hkActionProcess.size() == 0){
            eventInfo.setTodoUserName("暂无人员数据");
            eventInfo.setTodoTime("暂无人员数据");
        }else{
            for(int i=0;i<hkActionProcess.size();i++){
                Map map = new HashMap<>();
                Date createTime1 = hkActionProcess.get(i).getCreateTime();
                String handlerUserId = hkActionProcess.get(i).getHandlerUserId();
                if(handlerUserId == null) continue;
                String format = dateFormat.format(createTime1);
                SysUser user = userService.selectUserById(Long.parseLong(handlerUserId));
                String userName = user.getUserName();
                map.put("todoUserName",userName);
                map.put("todoTime",format);
                list.add(map);

            }
        }
        eventInfo.setListMap(list);

        /**事件未中心处置的话**/
        if(3 == eventInfo.getEventStatus() && StringUtils.isEmpty(eventInfo.getSignTime())){
            eventInfo.setSignTime(dateFormat.format(eventInfo.getUpdateTime()));
        }

        /**判断状态为退回情况下，查询事件退回前的状态**/
        if(eventInfo.getEventAlertStatus() == 4){
            Map<String,Object> param = new HashMap<>();
            param.put("eventId",eventInfo.getEventId());
            List<HKrecord> hKrecords = appEventDetailService.selectProcessByParams(param);
            if(hKrecords != null && hKrecords.size() > 1){
                HKrecord hKrecord = hKrecords.get(hKrecords.size() - 2);
                eventInfo.setBeforeBackStatus(hKrecord.getProcessStatus());
            }
        }
        Date date = new Date();
        SimpleDateFormat yyyyMMdd = new SimpleDateFormat("HH:mm");
        String date1 = yyyyMMdd.format(date);
        String format = dateFormat.format(createTime);
        eventInfo.setDate(date1);
        eventInfo.setDateNow(format);
        return AjaxResult.success(eventInfo);
    }

    /**
     * 模糊搜索
     * @param searchInfo
     * @return
     */
    @GetMapping("recordSearch")
    @ResponseBody
    public Map recordSearch(EventSearchVO searchInfo){
        /**判断用户所属部门，若为最高级，则查看所有事件，若不是，则查看交办到该部门下的事件**/
        Long deptId = ShiroUtils.getSysUser().getDeptId();
        SysDept sysDept = iSysDeptService.selectDeptById(deptId);
        if(sysDept.getLevel() > 1){
            searchInfo.setAssignDeptId(deptId);
        }
        Map<String,Object> data = new HashMap<>();
        String riskLevel = searchInfo.getRiskLevel();
        riskLevel = riskLevel==null?"":riskLevel;
        /**待处理**/
        int pendingCount = 0;
        int beSignCount = 0;
        int doneCount = 0;
        String alertStatus = searchInfo.getAlertStatus();
        searchInfo.setStatusArr(null);
        switch (alertStatus){
            case "3":
            case "4":
                pendingCount = hkEventRecordService.findCountByParam(searchInfo);
                break;
            case "5":
                beSignCount = hkEventRecordService.findCountByParam(searchInfo);
                break;
            case "6":
                doneCount = hkEventRecordService.findCountByParam(searchInfo);
                break;
            default:
                break;
        }
        if(StringUtils.isEmpty(alertStatus)){
            searchInfo.setAlertStatus(null);
            searchInfo.setStatusArr(new String[]{"3","4"});//待处理
            pendingCount = hkEventRecordService.findCountByParam(searchInfo);
            searchInfo.setStatusArr(new String[]{"5"});//已签收
            beSignCount = hkEventRecordService.findCountByParam(searchInfo);
            searchInfo.setStatusArr(new String[]{"6"});//已完结
            doneCount = hkEventRecordService.findCountByParam(searchInfo);
        }
        int partCount1 = 0;//全部事件数量
        int partCount2 = 0;//重要事件数量
        int partCount3 = 0;//紧急事件数量
        if(StringUtils.isEmpty(alertStatus)){
            searchInfo.setStatusArr(new String[]{"3","4","5","6"});
        }
        switch (riskLevel){
            case "99":
                partCount2 = hkEventRecordService.findCountByParam(searchInfo);
                searchInfo.setRiskLevel("");
                partCount1 = hkEventRecordService.findCountByParam(searchInfo);
                searchInfo.setRiskLevel("999");
                partCount3 = hkEventRecordService.findCountByParam(searchInfo);
                break;
            case "999":
                partCount3 = hkEventRecordService.findCountByParam(searchInfo);
                searchInfo.setRiskLevel("");
                partCount1 = hkEventRecordService.findCountByParam(searchInfo);
                searchInfo.setRiskLevel("99");
                partCount2 = hkEventRecordService.findCountByParam(searchInfo);
                break;
            default:
                partCount1 = hkEventRecordService.findCountByParam(searchInfo);
                searchInfo.setRiskLevel("99");
                partCount2 = hkEventRecordService.findCountByParam(searchInfo);
                searchInfo.setRiskLevel("999");
                partCount3 = hkEventRecordService.findCountByParam(searchInfo);
        }
        searchInfo.setRiskLevel(riskLevel);
        data.put("partCount1",partCount1);//全部事件数量
        data.put("partCount2",partCount2);//重要事件数量
        data.put("partCount3",partCount3);//紧急事件数量

        data.put("pendingCount",pendingCount);
        /**待签收**/
        data.put("beSignCount",beSignCount);
        /**已完结**/
        data.put("doneCount",doneCount);
        startPage();
        List<HkEventInfo> searchVague =hkEventRecordService.findSearchVague(searchInfo);
        for (int i=0;i<searchVague.size();i++){
            //查询当前处理人
            String eventId = searchVague.get(i).getEventId();
            Date timeOut = searchVague.get(i).getTimeOut();
            SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String timeOutEnd = dateFormat1.format(timeOut);
            searchVague.get(i).setTimeOutEnd(timeOutEnd);
            List<HkActionProcess> processes = appMyWorkService.findActionChainEventId(eventId);
            if(searchVague.get(i).getEventAlertStatus() == 6 && searchVague.get(i).getEventStatus() == 3){
                SysUser user = userService.selectUserById(Long.parseLong(searchVague.get(i).getUpdateUser()));
                searchVague.get(i).setExtendStr1(user.getUserName());
            }else{
                for(HkActionProcess process : processes){
                    String handlerUserId = process.getHandlerUserId();
                    if(handlerUserId == null){ continue;}
                    SysUser user = userService.selectUserById(Long.parseLong(handlerUserId));
                    String userName = user.getUserName();
                    searchVague.get(i).setExtendStr1(userName);
                }
            }
            /*Date createTime = serchVague.get(i).getCreateTime();*/
            /**列表右上角展示确认警情时间到距当前的时间**/
            if(processes != null && processes.size() > 0){
                searchVague.get(i).setDate(DateUtils.subStrDateStringRetainOne(DateUtil.formatBetween(new Date(),processes.get(0).getCreateTime()))+"前");
            }
        }
        TableDataInfo dataTable = getDataTable(searchVague);
        data.put("code",0);//code
        data.put("rows",dataTable.getRows());
        data.put("total",dataTable.getTotal());
        return data;
    }

    /**
     * 查询事件改派/强制改派选择的用户列表
     *
     * 查询当前区域下的用户，或者非管理员的用户
     * @return
     */
    @GetMapping("queryReAssignUser")
    @ResponseBody
    public TableDataInfo queryuser(String eventId,String searchValue,Integer pageNum,Integer pageSize){
        List<UserInfoDto> list = new ArrayList<>();
        if(StringUtils.isEmpty(eventId)){
            return getDataTable(list);
        }
        Map<String,Object> map = new HashMap<>();
        map.put("eventId",eventId);
        List<HKrecord> hKrecords = appEventDetailService.selectProcessByParams(map);
        Long userId = null;
        if(hKrecords.size() > 0){
            /***获取该事件最新的处置记录***/
            HKrecord hKrecord = hKrecords.get(0);
            SysUser user = userService.selectUserById(Long.parseLong(hKrecord.getHandlerIndexCode()));
            userId = user.getUserId();
        }
        //userService.selectUnallocatedList()
        /*SysUser user = userService.selectUserById(Long.parseLong(handlerUserId));*/
        startPage();
        Map<String,Object> params = new HashMap<>();
        params.put("notUserId",userId);
        params.put("searchValue",searchValue);
        /*list = userService.selectCanBeChoose(params);*/
        list = ranksService.selectCanBeChoose(params);
        return getDataTable(list);
    }

    /**
     *
     * 重新指派人
     * @param vo
     * @return
     */
    @PostMapping("afreshAssign")
    @ResponseBody
    public AjaxResult afreshAssign(EventAfreshAssignVo vo){
        String userName = ShiroUtils.getSysUser().getUserName();
        String eventId = vo.getEventId();
        if(StringUtils.isEmpty(eventId)){
            return AjaxResult.error("事件ID不能为空");
        }
        Map<String,Object> map = new HashMap<>();
        map.put("eventId",eventId);
        List<HKrecord> hKrecords = appEventDetailService.selectProcessByParams(map);
        /**获取最新的事件操作记录**/
        HKrecord hKrecord = hKrecords.get(0);
        if(vo.getAfterHandlerUserId().equals(hKrecord.getHandlerIndexCode())){
            return AjaxResult.error("不能重复指派");
        }
        if("4".equals(hKrecord.getProcessStatus()) || "6".equals(hKrecord.getProcessStatus())){
            return AjaxResult.error("当前状态无法指派");
        }
        vo.setBeforeHandlerUserId(hKrecord.getHandlerIndexCode());
        vo.setOperator(userName);
        vo.setHandlerOrder(hKrecord.getExtendInt3());
        hkEventRecordService.afreshAssign(vo);
        return assignorUser(vo.getEventId());
    }

    /**
     * 查询签收人姓名
     * @param eventId
     * @return
     */
    @GetMapping("signName")
    @ResponseBody
    public AjaxResult signName(String eventId){
        HkEventInfo eventInfo = hkEventRecordService.findEventId(eventId);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if(eventInfo == null){
            return AjaxResult.error("事件信息为空");
        }
        int eventStatus = eventInfo.getEventStatus();
        List<Map<String,Object>> proList = new ArrayList<>();
        if (eventStatus == 3){
            Map<String,Object> result = new HashMap<>();
            String userId = eventInfo.getUpdateUser();
            result.put("userId",userId);
            result.put("userName","中心处置");
            result.put("signTime",eventInfo.getUpdateTime());
            proList.add(result);
        }
        Map<String,Object> param = new HashMap<>();
        param.put("eventId",eventId);
        //获取已签收的事件处理结果
        List<EventProcessRecordDTO> list1 = appEventDetailService.findProcessRecordSign(param);
        for (EventProcessRecordDTO recordDTO : list1){
            Map<String,Object> result = new HashMap<>();
            SysUser user = userService.selectUserById(Long.parseLong(recordDTO.getHandlerIndexCode()));
            String format = dateFormat.format(recordDTO.getCreateTime());
            result.put("userId",recordDTO.getHandlerIndexCode());
            result.put("userName",user.getUserName());
            result.put("signTime",format);
            proList.add(result);
        }
        return AjaxResult.success(proList);
    }

    /**
     * 点击调度 查询指派的人
     * @param eventId
     * @return
     */
    @GetMapping("assignorUser")
    @ResponseBody
    public AjaxResult assignorUser(String eventId){
        Map<String,Object> result = new HashMap<>();
        HkEventInfo eventInfo = hkEventRecordService.findEventId(eventId);
        if(eventInfo == null){
            return AjaxResult.error("事件信息为空");
        }
        result.put("eventAlertStatus",eventInfo.getEventAlertStatus());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<Map<String,String>> list = new ArrayList<>();
        /*********2指派  3签收  5退回  4完结*******/
        Map<String,Object> param = new HashMap<>();
        param.put("eventId",eventId);
        param.put("statusArr",new String[]{"2","5","1"});//查询已退回和和分配的信息
        List<HKrecord> hKrecords = appEventDetailService.selectProcessByParams(param);
        if(hKrecords != null && hKrecords.size() > 0 ){
            for(HKrecord record : hKrecords){
                Map<String,String> map = new HashMap<>();
                map.put("todoUserId",record.getHandlerIndexCode());
                SysUser sysUser = userService.selectUserById(Long.parseLong(record.getHandlerIndexCode()));
                map.put("todoUserName",sysUser.getUserName());
                map.put("todoTime",dateFormat.format(record.getCreateTime()));
                map.put("zpUserName",record.getExtendStr3());
                map.put("processStatus",record.getProcessStatus());
                if("5".equals(record.getProcessStatus())){
                    String json = record.getHandlerContent();
                    JSONObject voiceJson = JSON.parseObject(json);
                    String handlerContent = voiceJson.getString("handlerContent");
                    String nowTime = voiceJson.getString("nowTime");
                    map.put("backReason",handlerContent);
                    map.put("todoTime",nowTime);
                }
                list.add(map);
            }
            result.put("list",list);
        }
        return AjaxResult.success(result);
    }

    /**
     * 点击处理中 查看处理人
     * @param eventId
     * @return
     */
    @GetMapping("queryChainHandler")
    @ResponseBody
    public AjaxResult queryChainHandler(String eventId){
        HkActionProcess hkActionProcess = new HkActionProcess();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        hkActionProcess.setEventId(eventId);

        List<Map> list = new ArrayList<>();
        HkEventInfo hkEventInfo = new HkEventInfo();
        hkEventInfo.setEventId(eventId);
        List<HkEventInfo> hkEventInfoList = hkEventService.selectEventInfoAll(hkEventInfo);
        if ("3".equals(hkEventInfoList.get(0).getEventStatus().toString())){ //中心处置
            Map<String,Object> reslutMap = new HashMap<>();
            reslutMap.put("userId",hkEventInfoList.get(0).getUpdateUser());
            reslutMap.put("userName","中心处置");
            reslutMap.put("updateTime",dateFormat.format(hkEventInfoList.get(0).getUpdateTime()));
            list.add(reslutMap);
        }
        Map<String,Object> param = new HashMap<>();
        param.put("eventId",eventId);
        param.put("statusArr",new String[]{"4"});//查询已处置的操作记录
        List<HKrecord> hKrecordList = appEventDetailService.selectProcessByParams(param);
        for (HKrecord hKrecord : hKrecordList){
            Map<String,Object> map = new HashMap<>();
            SysUser sysUser = userService.selectUserById(Long.parseLong(hKrecord.getHandlerIndexCode()));
            String userName = sysUser.getUserName();
            map.put("userId",hKrecord.getHandlerIndexCode());
            map.put("userName",userName);
            map.put("updateTime",dateFormat.format(hKrecord.getCreateTime()));
            list.add(map);
        }
        AjaxResult success = AjaxResult.success(list);
        return success;
    }

    /**
     * 查询处理结果
     * @param eventId  事件id
     * @return
     */
    @GetMapping("queryProcessRecord")
    @ResponseBody
    public AjaxResult queryProcessRecord1(String eventId,String type){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Map<String,Object> result = new HashMap<>();
        HkEventInfo eventInfo = hkEventRecordService.findEventId(eventId);
        if(eventInfo == null){
            AjaxResult.error("事件不存在");
        }
        Date createTime = eventInfo.getCreateTime();
        Date updateTime = eventInfo.getUpdateTime();
        result.put("eventTitle",eventInfo.getEventTitle());
        result.put("timeOut",eventInfo.getTimeOut());
        result.put("eventTypeName",eventInfo.getEventTypeName());
        result.put("reportTypeName",eventInfo.getReportTypeName());
        result.put("createTime",eventInfo.getCreateTime());//事件上报事件暂定为事件上报到风控的时间
        result.put("updateTime",eventInfo.getUpdateTime());//事件完成时间
        result.put("regionName",eventInfo.getRegionName());
        result.put("eventAddress",eventInfo.getEventAddress());
        result.put("eventImage",eventInfo.getEventImage());
        result.put("evaluate",eventInfo.getEvaluate());
        result.put("allTime",DateUtils.subStrDateStringRetainTwo(DateUtil.formatBetween(createTime,updateTime)));

        List<Map<String,Object>> list = new ArrayList<>();
        List<HkActionProcess> processes = appMyWorkService.findActionChainEventId(eventId);
        if(processes == null || processes.size() == 0){
            return AjaxResult.error("未找到该事件的行动链信息");
        }
        /**对行动链顺序排列**/
        processes.sort(Comparator.comparing(HkActionProcess::getCreateTime));
        HkActionProcess process = processes.get(0);

        String handlerUserId = process.getHandlerUserId();
        if(!"1".equals(type)){//事件督办时不需要查询
            Date processCreateTime = process.getCreateTime();
            //事件上报到指派的时间
            result.put("firstProcessTime",DateUtils.subStrDateStringRetainTwo(DateUtil.formatBetween(createTime,processCreateTime)));//事件指派耗时 上报事件到第一次指派时间
            //查询最近签收时间
            Date signMaxTime = appEventDetailService.getEventRecordTime(eventId,"3");
            result.put("signTotalTime",signMaxTime == null ? "-" : DateUtils.subStrDateStringRetainTwo(DateUtil.formatBetween(processCreateTime,signMaxTime)));//签收耗时 第一次指派--最后一次签收
            int compare = DateUtil.compare(eventInfo.getTimeOut(), signMaxTime);//签收是否逾期
            result.put("signTimeOut",compare);//是否逾期
            //查询最近处置时间
            Date disposalMaxTime = appEventDetailService.getEventRecordHandleTime(eventId);
            if (signMaxTime == null){
                signMaxTime = processCreateTime; //当没有最近签收时间时，默认等于第一次指派时间
            }
            result.put("disposalTotalTime",DateUtils.subStrDateStringRetainTwo(DateUtil.formatBetween(signMaxTime,disposalMaxTime)));//事件处置耗时 最后一次签收--最后一次提交时间(加上中心处置时间)
            int compare1 = DateUtil.compare(eventInfo.getTimeOut(), disposalMaxTime);//处置是否逾期
            result.put("disposalTimeOut",compare1);//是否逾期
            logger.info("事件总耗时时间:{}",DateUtils.subStrDateStringRetainTwo(DateUtil.formatBetween(createTime, disposalMaxTime)));
        }
        SysUser user = userService.selectUserById(Long.parseLong(handlerUserId));
        String userName = user.getUserName();
        String phone = user.getPhonenumber();
        result.put("phone",phone);
        result.put("userName",userName);
        result.put("processTime",createTime);
        Map<String,Object> param = new HashMap<>();
        param.put("eventId",process.getEventId());
        param.put("statusArr",new String[]{"1","2","3","5","4","6"});
        List<HKrecord> hKrecords = appEventDetailService.selectProcessByParams(param);
        for(HKrecord record : hKrecords){
            Map<String,Object> map = new HashMap<>();
            SysUser user1 = userService.selectUserById(Long.parseLong(record.getHandlerIndexCode()));
            map.put("todoUserId",user1.getUserId());
            map.put("todoUserName",user1.getUserName());
            map.put("processStatus",record.getProcessStatus());
            map.put("processTime",dateFormat.format(record.getCreateTime()));
            /*if ("6".equals(record.getProcessStatus())){ //中心处置
                map.put("todoUserName","中心处置");
                map.put("phone","-");
                map.put("processTime",dateFormat.format(eventInfo.getUpdateTime()));
                map.put("zpUserName",eventInfo.getUpdateUser());//操作人
            }else*/
            if("5".equals(record.getProcessStatus())){//已退回信息
                String json = record.getHandlerContent();
                JSONObject voiceJson = JSON.parseObject(json);
                String handlerContent = voiceJson.getString("handlerContent");
                map.put("backReason",handlerContent);
                String nowTime = voiceJson.getString("nowTime");
                map.put("processTime",nowTime);
            } else {
                map.put("phone",user1.getPhonenumber());
                map.put("processTime",dateFormat.format(record.getCreateTime()));
                map.put("zpUserName",process.getCreateUser());//操作人
                if ("4".equals(record.getProcessStatus())){ //处置
                    for (HkActionProcess dto : processes){
                        if (dto.getHandlerUserId().equals(record.getHandlerIndexCode())){ //获取对应处置人的处置结果
                            AppActionInfo as  =  JSONObject.parseObject(record.getHandlerContent(), AppActionInfo.class);
                            if(!as.getActionName().equals("QS0001")){
                                List<appField> listInfo = JSONObject.parseArray(as.getAppField(), appField.class);
                                map.put("processResult",listInfo);
                                break;
                            }
                        }
                    }
                }
            }
            list.add(map);
        }
        result.put("list",list);
        return AjaxResult.success(result);
    }

    /**
     * 中心处理
     * @return
     */
    @RequestMapping(value = "machineHandling",method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult machineHandling(String eventId,String closeReason){
        if(StringUtils.isNull(eventId)){
            return AjaxResult.error("事件ID不能为空");
        }
        if(StringUtils.isNull(closeReason)){
            return AjaxResult.error("处置原因不能为空");
        }
        SysUser sysUser = ShiroUtils.getSysUser();
        Map<String,Object> map = new HashMap<>();
        map.put("eventId",eventId);
        List<HKrecord> hKrecords = appEventDetailService.selectProcessByParams(map);
        /**获取最新的事件操作记录**/
        HKrecord hKrecord = hKrecords.get(0);
        return hkEventRecordService.machineHandling(eventId,closeReason,sysUser,hKrecord.getExtendInt3());
    }

    /**
     * 评价
     * @param pleased
     * @param id
     * @return
     */
    @RequestMapping("eventEvaluate")
    @ResponseBody
    public AjaxResult eventEvaluate(String pleased,String id){
        HkEventInfo hkEventInfo = new HkEventInfo();
        hkEventInfo.setEvaluate(Integer.parseInt(pleased));
        hkEventInfo.setId(Integer.parseInt(id));
        hkEventRecordService.updateEventInfo(hkEventInfo);
        return AjaxResult.success();
    }

}
