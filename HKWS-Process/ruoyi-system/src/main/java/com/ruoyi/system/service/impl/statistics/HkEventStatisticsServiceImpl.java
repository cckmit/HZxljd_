package com.ruoyi.system.service.impl.statistics;

import com.ruoyi.common.enums.EventTypeStatus;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.Daping.PercentResult;
import com.ruoyi.system.domain.Daping.ShowEventVo;
import com.ruoyi.system.domain.HkEarlyWarning.*;
import com.ruoyi.system.domain.HkEntity.EventSearchVO;
import com.ruoyi.system.mapper.HkEventMapper;
import com.ruoyi.system.mapper.HkEventProcessRecordMapper;
import com.ruoyi.system.service.statistics.HkEventStatisticsService;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @createBy zhangxinxin
 * 事件统计
 */
@Service
public class HkEventStatisticsServiceImpl implements HkEventStatisticsService {

    private Logger logger = LoggerFactory.getLogger(HkEventStatisticsServiceImpl.class);

    @Autowired
    private HkEventMapper hkEventMapper;

    @Autowired
    private HkEventProcessRecordMapper processRecordMapper;

    @Override
    public int selectEventCount(HkEventInfo hkEventInfo1) {
        return hkEventMapper.selectEventCount(hkEventInfo1);
    }

    @Override
    public int queryTodayEventCounts(Map<String,Object> eventParams) {
        return hkEventMapper.queryTodayEventCounts(eventParams);
    }

    @Override
    public int queryTodayUnprocessedEventCounts(Map<String,Object> eventParams) {
        return hkEventMapper.queryTodayUnprocessedEventCounts(eventParams);
    }

    @Override
    public int queryEventTimeOutCounts(Map<String,Object> timeOutParams) {
        return hkEventMapper.queryEventTimeOutCounts(timeOutParams);
    }

    @Override
    public List<EventTypeCountsVO> queryEventTypeCounts(String eventCreatTime) {
        return hkEventMapper.queryEventTypeCounts(eventCreatTime);
    }

    @Override
    public int queryEventHandlerCount(String eventCreatTime) {
        return hkEventMapper.queryEventHandlerCount(eventCreatTime);
    }

    @Override
    public int queryEventEndCount(String eventCreatTime) {
        return hkEventMapper.queryEventEndCount(eventCreatTime);
    }

    @Override
    public int queryEventExceptionCounts(String eventCreatTime) {
        return hkEventMapper.queryEventExceptionCounts(eventCreatTime);
    }

    @Override
    public int countAllByParams(Map<String,Object> params) {
        return hkEventMapper.countAllByParams(params);
    }

    @Override
    public int queryEventTurnoverRateCounts(Map<String, Object> params) {
        return hkEventMapper.queryEventTurnoverRateCounts(params);
    }

    @Override
    public List<EventTrendVO> queryEventTrends(Map<String, Object> map) {
        return hkEventMapper.queryEventTrends(map);
    }

    @Override
    public List<EventInspectVO> queryEventRegion1(Map<String, Object> map) {
        return hkEventMapper.queryEventRegion(map);
    }

    @Override
    public List<EventInspectVO> queryEventRegion(Map<String, Object> map) {
        List<EventInspectVO> voList1 = new ArrayList<>();
        List<EventInspectVO> voList2 = new ArrayList<>();
        List<EventInspectVO> voList3 = new ArrayList<>();
        /**判断根据什么排序**/
        map.put("sort",map.get("sort"));
        if("count".equals(map.get("sortItem")) || StringUtils.isNull(map.get("sortItem"))){
            map.put("statusArr",new String[]{"1","2","3","4","5","6","7","8","9"});
            voList1 = hkEventMapper.queryEventRegion(map);
            map.put("statusArr",new String[]{"3","4","5","6","7","8","9"});
            voList2 = hkEventMapper.queryEventRegion(map);
            calculateByCompare(voList1, voList2,"1");
            map.put("statusArr",new String[]{"6","7","8","9"});
            voList3 = hkEventMapper.queryEventRegion(map);
            calculateByCompare(voList1, voList3,"2");
        }else if("transfer".equals(map.get("sortItem"))){//流转率排序
            map.put("statusArr",new String[]{"3","4","5","6","7","8","9"});
            voList1 = hkEventMapper.queryEventRegion(map);
            map.put("statusArr",new String[]{"1","2","3","4","5","6","7","8","9"});
            voList2 = hkEventMapper.queryEventRegion(map);
            calculateByCompare(voList1, voList2,"1");
            map.put("statusArr",new String[]{"6","7","8","9"});
            voList3 = hkEventMapper.queryEventRegion(map);
            calculateByCompare(voList1, voList3,"2");
        }else if("governance".equals(map.get("sortItem"))){//共治率排序
            map.put("statusArr",new String[]{"6","7","8","9"});
            voList1 = hkEventMapper.queryEventRegion(map);
            map.put("statusArr",new String[]{"1","2","3","4","5","6","7","8","9"});
            voList2 = hkEventMapper.queryEventRegion(map);
            calculateByCompare(voList1, voList2,"2");
            map.put("statusArr",new String[]{"3","4","5","6","7","8","9"});
            voList3 = hkEventMapper.queryEventRegion(map);
            calculateByCompare(voList1, voList3,"1");
        }
        return voList1;
    }

    public void calculateByCompare(List<EventInspectVO> list1,List<EventInspectVO> list2,String type){
        for(EventInspectVO vo1 : list1){
            for(EventInspectVO vo2 : list2){
                if(vo2.getRegionCode().equals(vo1.getRegionCode())){
                    if(vo1.getEventCount().compareTo(vo2.getEventCount()) > 0){
                        if("1".equals(type)){
                            vo1.setTransferRate(rate(vo2.getEventCount(),vo1.getEventCount())+"");
                        }else{
                            vo1.setGovernanceRate(rate(vo2.getEventCount(),vo1.getEventCount())+"");
                        }
                    }else if(vo1.getEventCount().compareTo(vo2.getEventCount()) < 0){
                        if("1".equals(type)){
                            vo1.setTransferRate(rate(vo1.getEventCount(),vo2.getEventCount())+"");
                        }else{
                            vo1.setGovernanceRate(rate(vo1.getEventCount(),vo2.getEventCount())+"");
                        }
                    }else{
                        if("1".equals(type)){
                            vo1.setTransferRate("0.00");
                        }else{
                            vo1.setGovernanceRate("0.00");
                        }
                    }
                }
            }
        }
    }


    @Override
    public List<EventTypeVO> queryEventType(Map<String, Object> map) {
        return hkEventMapper.queryEventType(map);
    }

    /**根据映射后的自定义分类  分组查询**/
    @Override
    public List<EventTypeVO> queryEventTypePartTwo(Map<String, Object> map) {
        return hkEventMapper.queryEventTypePartTwo(map);
    }

    @Override
    public List<EventAnalysisVO> queryEventAnalysis(Map<String, Object> map) {
        return hkEventMapper.queryEventAnalysis(map);
    }

    /**根据映射后的自定义分类  分组查询**/
    @Override
    public List<EventAnalysisVO> queryEventAnalysisPartTwo(Map<String, Object> map) {
        return hkEventMapper.queryEventAnalysisPartTwo(map);
    }

    @Override
    public List<EventAnalysisVO> eventProcessAnalysis(Map<String, Object> map) {
        List<EventAnalysisVO> eventAnalysisVOS1 = new ArrayList<>();
        List<EventAnalysisVO> eventAnalysisVOS2 = new ArrayList<>();
        map.put("statusArr",new String[]{"1","2","3","4","5","6","7","8","9"});
        List<EventAnalysisVO> eventAnalysisVOS = hkEventMapper.queryEventAnalysisPartTwo(map);
        String sortItem = map.get("sortItem")+"";
        if("transfer".equals(sortItem) || StringUtils.isNull(sortItem)){
            map.put("statusArr",new String[]{"3","4","5","6","7","8","9"});//流转数量
            eventAnalysisVOS1 = hkEventMapper.queryEventAnalysisPartTwo(map);
            calculateByeventProcessAnalysis(eventAnalysisVOS,eventAnalysisVOS1, "1");
            map.put("statusArr",new String[]{"6","7","8","9"});//共治数量
            eventAnalysisVOS2 = hkEventMapper.queryEventAnalysisPartTwo(map);
            calculateByeventProcessAnalysis(eventAnalysisVOS,eventAnalysisVOS2,  "2");
        }else{
            map.put("statusArr",new String[]{"6","7","8","9"});//共治数量
            eventAnalysisVOS1 = hkEventMapper.queryEventAnalysisPartTwo(map);
            calculateByeventProcessAnalysis(eventAnalysisVOS,eventAnalysisVOS1, "2");
            map.put("statusArr",new String[]{"3","4","5","6","7","8","9"});//流转数量
            eventAnalysisVOS2 = hkEventMapper.queryEventAnalysisPartTwo(map);
            calculateByeventProcessAnalysis(eventAnalysisVOS,eventAnalysisVOS2, "1");
        }
        return eventAnalysisVOS;
    }

    public void calculateByeventProcessAnalysis(List<EventAnalysisVO> sourceList,List<EventAnalysisVO> list,String type) {
        for (EventAnalysisVO vo1 : sourceList) {
            for (EventAnalysisVO vo2 : list) {
                if(vo2.getEventAnalysisTypeCode().equals(vo1.getEventAnalysisTypeCode())){
                    EventProcessAnalysisVO vo = new EventProcessAnalysisVO();
                    BeanUtils.copyProperties(vo1,vo);
                    /**由于sourceList为主表，事件数量不会比list小**/
                    if(vo1.getEventAnalysisTypeCount().compareTo(vo2.getEventAnalysisTypeCount()) > 0){
                        if("1".equals(type)){
                            vo1.setTransforRate(rate(vo2.getEventAnalysisTypeCount(),vo1.getEventAnalysisTypeCount())+"");
                        }else{
                            vo1.setGovernanceRate(rate(vo2.getEventAnalysisTypeCount(),vo1.getEventAnalysisTypeCount())+"");
                        }
                    }else{
                        vo1.setTransforRate("0.00");
                        vo1.setGovernanceRate("0.00");
                    }
                }
            }
        }
    }

    @Override
    public Long queryEventSumTime(Map<String, Object> map) {
        return hkEventMapper.eventActiveTime(map);
    }

    @Override
    public List<EventAnalysisVO> queryEventAnalysisPart(Map<String, Object> map) {
        return hkEventMapper.queryEventAnalysisPart(map);
    }

    @Override
    public List<EventAnalysisVO> eventActiveTimeByEventType(Map<String, Object> map) {
        return hkEventMapper.eventActiveTimeByEventType(map);
    }

    @Override
    public List<EventChangeVO> queryEventChange(Map<String, Object> map) {
        return hkEventMapper.queryEventChange(map);
    }

    @Override
    public Integer queryEventTransferByRegion(Map<String, Object> params) {
        return hkEventMapper.queryEventTransferByRegion(params);
    }

    /**根据日期获取一段日期内事件发生的社区数量，与社区总人数**/
    @Override
    public RegionLoadVO queryEventHappenRegionInfo(Map<String, Object> map) {
        return hkEventMapper.queryEventHappenRegionInfo(map);
    }

    @Override
    public List<RegionEventTypeVO> queryRegionEventType(Map<String, Object> params) {
        return hkEventMapper.queryRegionEventType(params);
    }

    @Override
    public List<RegionEventAnalysisVO> queryRegionAnalysis(Map<String, Object> params) {
        return hkEventMapper.queryRegionAnalysis(params);
    }

    @Override
    public List<HkEventInfo> queryEventByAlterStatus(Map<String, Object> params) {
        return hkEventMapper.queryEventByAlterStatus(params);
    }

    @Override
    public List<PeopleAnalysisVO> queryEventCountByAllRanks(Map<String, Object> params) {
        return hkEventMapper.queryEventCountByAllRanks(params);
    }

    @Override
    public List<PeopleAnalysisVO> queryEventCountByParam(Map<String, Object> params) {
        return hkEventMapper.queryEventCountByParam(params);
    }


    @Override
    public List<PeopleDisposalAnalysisVO> queryPeopleDisposalAnalysis(Map<String, Object> params) {
        return hkEventMapper.queryPeopleDisposalAnalysis(params);
    }

    @Override
    public Long queryProcessTimeByParam(Map<String, Object> params) {
        return hkEventMapper.queryProcessTimeByParam(params);
    }

    @Override
    public int queryEventTrendByDay(Map<String, Object> initTimeParams) {
        return hkEventMapper.queryEventTrendByDay(initTimeParams);
    }

    @Override
    public List<EventTypeVO> queryEventTypeByRegion(Map<String, Object> params) {
        return hkEventMapper.queryEventTypeByRegion(params);
    }

    @Override
    public List<HkEventInfo> getEventByParams(Map<String, Object> params) {
        return hkEventMapper.getEventByParams(params);
    }

    /**
     * 查询事件耗时的同比环比
     * @param params
     * @return
     */
    @Override
    public PercentResult eventActiveTime(Map<String, Object> params) {
        PercentResult result = new PercentResult();//resposne
        Long times = hkEventMapper.eventActiveTime(params);
        times = times == null?0L:times;
        result.setValue(DateUtils.getHourByTimestamp(times).longValue());//事件数
        Map<String,Object> eventCountLastYearParams = DateRecordRate("lastYear");
        params.putAll(eventCountLastYearParams);
        Long eventCountLastYear = hkEventMapper.eventActiveTime(params);//去年事件处理数
        eventCountLastYear = eventCountLastYear == null?0L:eventCountLastYear;
        Map<String,Object> eventCountTheYearParams = DateRecordRate("theYear");
        params.putAll(eventCountTheYearParams);
        Long eventCountTheYear = hkEventMapper.eventActiveTime(params);//今年事件处理数
        eventCountTheYear = eventCountTheYear == null?0L:eventCountTheYear;
        Map<String,Object> eventCountLastMonthParams = DateRecordRate("lastMonth");
        params.putAll(eventCountLastMonthParams);
        Long eventCountLastMonth = hkEventMapper.eventActiveTime(params);//去年事件处理数
        eventCountLastMonth = eventCountLastMonth == null?0L:eventCountLastMonth;
        Map<String,Object> eventCountTheMonthParams = DateRecordRate("theMonth");
        params.putAll(eventCountTheMonthParams);
        Long eventCountTheMonth = hkEventMapper.eventActiveTime(params);//今年事件处理数
        eventCountTheMonth = eventCountTheMonth == null?0L:eventCountTheMonth;
        //同比增长率=（本期数－同期数）÷同期数×100%
        result.setEventRateYear(growthRate(new BigDecimal(DateUtils.getHourByTimestamp(eventCountTheYear).longValue()),
                new BigDecimal(DateUtils.getHourByTimestamp(eventCountLastYear).longValue())));//同比
        //环比增长率=（本期数-上期数）/上期数×100%。
        result.setEventRateMonth(growthRate(new BigDecimal(DateUtils.getHourByTimestamp(eventCountTheMonth).longValue()),
                new BigDecimal(DateUtils.getHourByTimestamp(eventCountLastMonth).longValue())));//环比
        return result;
    }

    @Override
    public List<ShowEventVo> getNewEvent(Map<String,Object> eventParams) {
        return hkEventMapper.getNewEvent(eventParams);
    }

    @Override
    public List<PercentResult> getDistributionOfMember(Map<String, Object> eventParams) {
        List<PercentResult> list = hkEventMapper.getDistributionOfMember(eventParams);
        /**根据社区名称分组**/
        Map<String, List<PercentResult>> result = list.stream().collect(Collectors.groupingBy(b -> b.getName()));
        return list;
    }

    @Override
    public ShowEventVo getNewEventByYJ(Map<String, Object> eventParams) {
        return hkEventMapper.getNewEventByYJ(eventParams);
    }

    @Override
    public int todayEventTypeCount(String componentId, String eventType,String eventSubStatus,String createTime,String[] statusArr) {
        Map<String,Object> params = new HashMap<>();
        params.put("componentId",componentId);
        params.put("eventType",eventType);
        params.put("eventSubStatus",eventSubStatus);
        params.put("currentDate",createTime);
        if(StringUtils.isEmpty(statusArr)){
            statusArr = null;
        }
        params.put("statusArr",statusArr);
        return hkEventMapper.countAllByParams(params);
    }

    @Override
    public int findPendingVehicleCountByParams(EventSearchVO eventSearchVO) {
        return hkEventMapper.findPendingVehicleCountByParams(eventSearchVO);
    }

    @Override
    public int findCountByParam(EventSearchVO eventSearchVO) {
        return hkEventMapper.findCountByParam(eventSearchVO);
    }

    /**
     * 查询事件的同比环比
     * @param params
     * @return
     */
    @Override
    public PercentResult eventCountAndRate(Map<String,Object> params) {
        PercentResult percentResult = new PercentResult();//resposne
        params.put("statusArr",new String[]{"1","2","3","4","5","6","7","8","9"});
        Integer eventCount = hkEventMapper.countAllByParams(params);//事件处理数
        eventCount = eventCount == null?0:eventCount;
        Map<String,Object> eventCountLastYearParams = DateRecordRate("lastYear");
        params.putAll(eventCountLastYearParams);
        Integer eventCountLastYear = hkEventMapper.countAllByParams(params);//去年事件处理数
        eventCountLastYear = eventCountLastYear == null?0:eventCountLastYear;
        Map<String,Object> eventCountTheYearParams = DateRecordRate("theYear");
        params.putAll(eventCountTheYearParams);
        Integer eventCountTheYear = hkEventMapper.countAllByParams(params);//今年事件处理数
        eventCountTheYear = eventCountTheYear == null?0:eventCountTheYear;
        Map<String,Object> eventCountLastMonthParams = DateRecordRate("lastMonth");
        params.putAll(eventCountLastMonthParams);
        Integer eventCountLastMonth = hkEventMapper.countAllByParams(params);//去年事件处理数
        eventCountLastMonth = eventCountLastMonth == null?0:eventCountLastMonth;
        Map<String,Object> eventCountTheMonthParams = DateRecordRate("theMonth");
        params.putAll(eventCountTheMonthParams);
        Integer eventCountTheMonth = hkEventMapper.countAllByParams(params);//今年事件处理数
        eventCountTheMonth = eventCountTheMonth == null?0:eventCountTheMonth;
        percentResult.setName(params.get("componentId")+"");//上报系统
        percentResult.setValue((long)eventCount);//事件数
        percentResult.setEventRateYear(growthRate(new BigDecimal(eventCountTheYear),new BigDecimal(eventCountLastYear)));//同比
        percentResult.setEventRateMonth(growthRate(new BigDecimal(eventCountTheMonth),new BigDecimal(eventCountLastMonth)));//环比
        return percentResult;
    }

    /**
     * 应急消防各类型隐患 处理统计
     * @param params
     * @return
     */
    @Override
    public Map<String,Object> getMapBySubStatus(Map<String,Object> params) {
        //发生应急隐患，隐患处置数，隐患处置率
        Map<String,Object> result = new HashMap<>();
        String[] arr = EventTypeStatus.EVENT_TROUBLE_STATUS_CORRE01.desc().split(",");
        for(String str : arr){
            result.put("count"+str,0);
            result.put("processCount"+str,0);
            result.put("processRate"+str,0.00);
        }
        List<PercentResult> list = hkEventMapper.getMapBySubStatus(params);//各类型隐患总数
        Map<String,Object> param2 = new HashMap<>();
        param2.putAll(params);
        param2.put("statusArr",new String[]{"5","6","7","8","9"});
        List<PercentResult> processList = hkEventMapper.getMapBySubStatus(param2);//各类型隐患处理数
        if(list.size() > 0){
            for(PercentResult dto : list){
                result.put("count"+dto.getName(),dto.getValue());
                for(PercentResult processDto : processList){
                    result.put("processCount"+processDto.getName(),processDto.getValue());
                    if(dto.getName().equals(processDto.getName())){
                        result.put("processRate"+dto.getName(),rate(new BigDecimal(processDto.getValue()),new BigDecimal(dto.getValue())));
                    }
                }
            }
        }
        return result;
    }

    /**
     * 综合治理各类型事件统计
     * @param params
     * @return
     */
    @Override
    public Map<String, Object> getMapByEventName(Map<String, Object> params) {
        Map<String,Object> result = new HashMap<>();
        String[] arr = EventTypeStatus.EVENT_PLAT_1003_CODE.desc().split(",");
        Map<String,Object> param1 = new HashMap<>();
        param1.putAll(params);
        param1.put("eventTypeArr",arr);
        result.put("processRate"+EventTypeStatus.EVENT_PLAT_1003_CODE001.code(),0.00);
        result.put("processRate"+EventTypeStatus.EVENT_PLAT_1003_CODE002.code(),0.00);
        result.put("processRate"+EventTypeStatus.EVENT_PLAT_1003_CODE003.code(),0.00);
        result.put("processRate"+EventTypeStatus.EVENT_PLAT_1003_CODE004.code(),0.00);
        List<PercentResult> list = hkEventMapper.getMapByEventName(param1);//各类型事件总数
        Map<String,Object> param2 = new HashMap<>();
        param2.putAll(params);
        param2.put("statusArr",new String[]{"6","7","8","9"});
        List<PercentResult> processList = hkEventMapper.getMapByEventName(param2);//各类型事件总数
        if(list.size() > 0){
            for(PercentResult dto : list){
                for(PercentResult processDto : processList){
                    if(dto.getName().equals(processDto.getName())){
                        result.put("processRate"+dto.getName(),rate(new BigDecimal(processDto.getValue()),new BigDecimal(dto.getValue())));
                    }
                }
            }
        }
        return result;
    }

    /**
     * 综合治理 职能设备上报统计
     * @param params
     * @return
     */
    @Override
    public Map<String, Object> getMapByCameraType(Map<String, Object> params) {
        Map<String,Object> result = new HashMap<>();
        String[] arr = EventTypeStatus.EVENT_CAMERA_TYPE_CODE.desc().split(",");
        for(String str : arr){
            result.put("count"+EventTypeStatus.getDesc(str),0);
            result.put("rate"+EventTypeStatus.getDesc(str),0);
        }
        params.put("cameraTypeCode","9");//设置不为空
        int count = hkEventMapper.countAllByParams(params);
        List<PercentResult> list = hkEventMapper.getMapByCameraType(params);
        list.sort(Comparator.comparing(PercentResult::getValue).reversed());
        for(PercentResult dto : list){
            String name = EventTypeStatus.getDesc(dto.getName());
            result.put("count"+name,dto.getValue());
            result.put("rate"+name,rate(new BigDecimal(dto.getValue()),new BigDecimal(count)));
        }
        return result;
    }

    /**
     * 根据事件类型
     * @param params
     * @return
     */
    @Override
    public Map<String, Object> getMapByEventType(Map<String, Object> params) {
        Map<String,Object> result = new HashMap<>();
        Integer total = hkEventMapper.countAllByParams(params);//今日该平台上报的事件总数
        String[] arr = EventTypeStatus.EVENT_PLAT_1004_CODE.desc().split(",");
        for(String str : arr){
            params.put("eventType",str);
            Integer subTotal = hkEventMapper.countAllByParams(params);//今日
            if(str.equals(EventTypeStatus.EVENT_PLAT_1004_CODE001.code())){
                result.put(EventTypeStatus.EVENT_PLAT_1004_CODE001.desc()+"_rate",rate(new BigDecimal(subTotal),new BigDecimal(total)));
                result.put(EventTypeStatus.EVENT_PLAT_1004_CODE001.desc()+"_count",subTotal);
            }else if (str.equals(EventTypeStatus.EVENT_PLAT_1004_CODE002.code())){
                result.put(EventTypeStatus.EVENT_PLAT_1004_CODE002.desc()+"_rate",rate(new BigDecimal(subTotal),new BigDecimal(total)));
                result.put(EventTypeStatus.EVENT_PLAT_1004_CODE002.desc()+"_count",subTotal);
            }else if (str.equals(EventTypeStatus.EVENT_PLAT_1004_CODE003.code())){
                result.put(EventTypeStatus.EVENT_PLAT_1004_CODE003.desc()+"_rate",rate(new BigDecimal(subTotal),new BigDecimal(total)));
                result.put(EventTypeStatus.EVENT_PLAT_1004_CODE003.desc()+"_count",subTotal);
            }else if (str.equals(EventTypeStatus.EVENT_PLAT_1004_CODE004.code())){
                result.put(EventTypeStatus.EVENT_PLAT_1004_CODE004.desc()+"_rate",rate(new BigDecimal(subTotal),new BigDecimal(total)));
                result.put(EventTypeStatus.EVENT_PLAT_1004_CODE004.desc()+"_count",subTotal);
            }
        }
        return result;
    }

    /**
     * 过去一年每月事件上报数与处置数统计
     * @param params
     * @return
     */
    @Override
    public Map<String, Object> getMouthEventCount(Map<String, Object> params) {
        Map<String, Object> result = new HashMap<>();
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String,Object> param1 = new HashMap<>();
        param1.putAll(params);
        param1.put("trendMonthMonday",DateFormatUtils.format(DateUtils.getThisMonthMonday(),"yyyy-MM-dd"));
        int allCount = hkEventMapper.countAllByParams(param1);
        param1.put("statusArr",new String[]{"6","7","8","9"});
        int allDoneCount = hkEventMapper.countAllByParams(param1);
        params.put("statusArr",null);
        LocalDate today = LocalDate.now();
        String endMonths = "";
        for(long i = 0L;i < 12L; i++){
            Map<String, Object> map = new HashMap<>();
            LocalDate localDate = today.minusMonths(i);
            String mouths = localDate.toString().substring(0,7);
            params.put("beginMonths",mouths);
            params.put("endMonths",endMonths);
            endMonths = mouths;
            params.put("statusArr",null);
            int count = hkEventMapper.countAllByParams(params);//
            params.put("statusArr",new String[]{"6","7","8","9"});
            int doneCount = hkEventMapper.countAllByParams(params);//
            map.put("count",count);
            map.put("doneCount",doneCount);
            map.put("month",endMonths);
            list.add(map);
        }
        result.put("allCount",allCount);
        result.put("allDoneCount",allDoneCount);
        result.put("list",list);
        return result;
    }

    /**
     * 当天青山云各类型事件统计
     * @param params
     * @return
     */
    @Override
    public Map<String, Object> getEventDoneInfo(Map<String, Object> params) {
        Map<String, Object> result = new HashMap<>();
        String[] arr = EventTypeStatus.EVENT_PLAT_1004_CODE.desc().split(",");
        for(String str : arr){
            params.put("eventType",str);
            params.put("statusArr",new String[]{"1","2","3","4","5","6","7","8","9"});
            Integer count = hkEventMapper.countAllByParams(params);//今日该类型总事件
            params.put("statusArr",new String[]{"6","7","8","9"});
            Integer doneCount = hkEventMapper.countAllByParams(params);//今日该类型已处理总事件
            if(str.equals(EventTypeStatus.EVENT_PLAT_1004_CODE001.code())){
                result.put(EventTypeStatus.EVENT_PLAT_1004_CODE001.desc(),rate(new BigDecimal(doneCount),new BigDecimal(count)));
            }else if (str.equals(EventTypeStatus.EVENT_PLAT_1004_CODE002.code())){
                result.put(EventTypeStatus.EVENT_PLAT_1004_CODE002.desc(),rate(new BigDecimal(doneCount),new BigDecimal(count)));
            }else if (str.equals(EventTypeStatus.EVENT_PLAT_1004_CODE003.code())){
                result.put(EventTypeStatus.EVENT_PLAT_1004_CODE003.desc(),rate(new BigDecimal(doneCount),new BigDecimal(count)));
            }else if (str.equals(EventTypeStatus.EVENT_PLAT_1004_CODE004.code())){
                result.put(EventTypeStatus.EVENT_PLAT_1004_CODE004.desc(),rate(new BigDecimal(doneCount),new BigDecimal(count)));
            }
        }
        return result;
    }























    /**
     * 一事一档事件列表
     * @param vo
     * @return
     */
    @Override
    public List<HkEventThingVo> queryThingList(HkEventFourVo vo) {
        if(!StringUtils.isEmpty(vo.getDayType())){
            if("1".equals(vo.getDayType())){
                vo.setCurrentDate(DateUtils.getDate());
            }else if("2".equals(vo.getDayType())){
                vo.setTrendMonthMonday(DateFormatUtils.format(DateUtils.getThisWeekMonday(),"yyyy-MM-dd"));
            }else if("3".equals(vo.getDayType())){
                vo.setTrendMonthMonday(DateFormatUtils.format(DateUtils.getThisMonthMonday(),"yyyy-MM-dd"));
            }
        }
        List<HkEventThingVo> list = hkEventMapper.queryThingList(vo);
        String[]statusArr = {"6","7","9"};
        for(HkEventThingVo thing : list){
            if(!"3".equals(thing.getEventStatus()) && !Arrays.asList(statusArr).contains(thing.getEventAlertType())){
                thing.setDoneTime(null);
            }
        }
        return list;
    }

    /**
     * 一域一档事件列表
     * @param vo
     * @return
     */
    @Override
    public List<HkEventFieldVo> queryFieldList(HkEventFourVo vo) {
        /**查询各社区事件总数量**/
        vo.setStatusArr(new String[]{"1","2","3","4","5","6","7","8","9"});
        List<HkEventFieldVo> result = hkEventMapper.queryRegionByEvent(vo);
        for(HkEventFieldVo field : result){
            Integer allCount = field.getEventCount();
            if(allCount != null && allCount > 0){
                field.setEventCount(allCount);
                vo.setRegionId(field.getRegionCode());
                vo.setStatusArr(new String[]{"3","4","5"});
                Integer doingCount = hkEventMapper.queryEventCountByRegion2(vo);
                field.setDoingCount(doingCount);
                vo.setStatusArr(new String[]{"1","2"});
                Integer judgeCount = hkEventMapper.queryEventCountByRegion2(vo);
                field.setJudgeCount(judgeCount);
                vo.setStatusArr(new String[]{"6","7","8","9"});
                Integer doneCount =  hkEventMapper.queryEventCountByRegion2(vo);
                field.setDoneCount(doneCount);
                //流转率查询 流转率 = (确认警情后)  /事件总数
                vo.setStatusArr(new String[]{"3","4","5","6","7","8","9"});
                Integer transferCount = hkEventMapper.queryEventCountByRegion2(vo);
                double transferRate = rate(transferCount,allCount);
                field.setTransferRate(transferRate+"");
                //共治率
                /*Integer sharedGoverCount =  hkEventMapper.queryEventCountByRegion2(vo);*/
                double sharedGoverRate = rate(doneCount,allCount);
                field.setSharedGoverRate(sharedGoverRate+"");
            }else{
                field.setDoingCount(0);
                field.setJudgeCount(0);
                field.setDoneCount(0);
                field.setTransferRate("0.00");
                field.setSharedGoverRate("0.00");
            }
        }
        return result;
    }

    /**
     * 一人一档事件列表
     * @param vo
     * @return
     */
    @Override
    public List<HkEventPersonVo> queryPersonList(HkEventFourVo vo) {
        /**查询参与过的事件**/
        /**事件状态 1:预警 2:研判中 3:调度中,4:已退回 5:处置 6:完结 7:已忽略 8:关闭详情 9:系统自动完成**/
        vo.setProcessStatusArr(new String[]{"4","6"});
        List<HkEventPersonVo> list = hkEventMapper.queryEventByUser1(vo);
        for(HkEventPersonVo person : list){
            if(person.getEventCount() > 0){
                /**查询正在处置的事件数量**/
                //查询正在处置的事件数量
                //事件状态为3 4 5
                //事件处置记录中的状态 1重新指派 2 指派，3签收，4已处置 5退回,6中心处置，7忽略，8异常报送
                //事件的处置记录最新一条记录为 1,2,3时
                vo.setUserId(person.getUserId());
                /*vo.setStatusArr(new String[]{"3","4","5"});*/
                Map<String,Object> param1 = new HashMap<>();
                param1.put("userId",person.getUserId());
                param1.put("statusArr",new String[]{"3","5"});
                param1.put("processStatusArr",new String[]{"3"});
                int doingCount = hkEventMapper.queryStatusEventCountByUser(param1);//正在处置
                param1.put("processStatusArr",new String[]{"1","2"});
                int noSignCount = hkEventMapper.queryStatusEventCountByUser(param1);//待签收
                person.setNoSignCount(noSignCount);
                person.setDoingCount(doingCount);
                /*List<HkEventPersonVo> subList1 = hkEventMapper.queryEventByUser1(vo);
                if(subList1 != null && subList1.size() > 0){
                    person.setDoingCount(subList1.get(0).getEventCount());//正在处置事件数
                }*/
                Long totalTime = hkEventMapper.queryEventTotalTimeByUser(vo);
                totalTime = totalTime==null?0L:totalTime;
                person.setTotalTime(DateUtils.timeToHour(totalTime));
                long averageTime = totalTime / person.getEventCount();
                person.setAverageTime(DateUtils.timeToHour(averageTime));
            }
        }
        return list;
    }

    /**
     * 一期一档事件列表
     * @param vo
     * @return
     */
    @Override
    public List<HkEventStageVo> queryStageList(HkEventFourVo vo) {

        /**研判中**/
        /*int pendingCount = hkEventMapper.findPendingCount();
         *//**已完结**//*
        int eventEndCount = hkEventMapper.findEventEndCount();
        *//**处理中**//*
        int disposalCount = hkEventMapper.findDisposalCount();*/
        return null;
    }

    public double rate(Integer count1,Integer count2){
        if(count2 == null || count2 == 0){
            return 0.00;
        }
        return new BigDecimal(count1).multiply(new BigDecimal("100")).divide(new BigDecimal(count2),2,BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    @Override
    public List<PercentResult> queryCountByEventType(Map<String,Object> params) {
        params.put("statusArr",new String[]{"1","2","3","4","5","6","7","8","9"});
        return hkEventMapper.queryCountByEventType(params);
    }

    /**
     *  大屏接口
     *  今日事件 预警发现-研判调度-处置完成 占比
     * @param eventParams
     * @return
     */
    @Override
    public List<PercentResult> queryCountByAlertStatus(Map<String,Object> eventParams) {
        String[] list = EventTypeStatus.EVENT_STATUS_CODE01.desc().split(",");
        List<PercentResult> result = new ArrayList<>();
        for(String str : list){
            PercentResult dto = new PercentResult();
            dto.setName(str);
            dto.setValue(0L);
            dto.setPercent(0.00);
            result.add(dto);
        }
        eventParams.put("statusArr",new String[]{"2"});
        int yjfxCount = hkEventMapper.countAllByParams(eventParams);//预警发现
        eventParams.put("statusArr",new String[]{"3","4","5"});
        int ypddCount = hkEventMapper.countAllByParams(eventParams);//研判调度
        eventParams.put("statusArr",new String[]{"6","7","8","9"});
        int czwcCount = hkEventMapper.countAllByParams(eventParams);//处置完成
        int total = yjfxCount+ypddCount+czwcCount;
        for(PercentResult dto : result){
            if("2".equals(dto.getName())){
                dto.setValue((long)yjfxCount);
            }else if("3".equals(dto.getName())){
                dto.setValue((long)ypddCount);
            }else if("5".equals(dto.getName())){
                dto.setValue((long)czwcCount);
            }
            Double percent = rate(new BigDecimal(dto.getValue()), new BigDecimal(total));
            dto.setPercent(percent);
        }
        return result;
    }

    @Override
    public List<PercentResult> queryCountByLawType(Map<String,Object> param) {
        return hkEventMapper.queryCountByLawType(param);
    }



    public Double rate(BigDecimal num,BigDecimal mum1){
        if(mum1.compareTo(BigDecimal.ZERO) < 1){
            return 0.00;
        }
        return num.divide(mum1,4,BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 增长率计算，正为同比增长，负为同比下降
     *
     * （本期数－同期数）/同期数×100%
     * （本期数-上期数）/上期数×100%。
     * @param num   本期数
     * @param num1  上期数/同期数
     * @return
     */
    public Double growthRate(BigDecimal num,BigDecimal num1){
        if(num1.compareTo(BigDecimal.ZERO) < 1 && num.compareTo(BigDecimal.ZERO) < 1){
            return 0.00;
        }else if(num.compareTo(BigDecimal.ZERO) < 1){
            return -1.00;
        }else if(num1.compareTo(BigDecimal.ZERO) < 1){
            return 1.00;
        }
        return num.subtract(num1).divide(num1, 4,BigDecimal.ROUND_HALF_UP).doubleValue();
    }


    public  Map<String,Object> DateRecordRate(String type){
        Map<String,Object> params = new HashMap<>();
        String firstDay = "";
        String endDay = "";
        if("lastYear".equals(type)){
            firstDay = DateFormatUtils.format(DateUtils.getLastYearSameMouthBegin(),"yyyy-MM-dd");//去年本月第一天
            endDay = DateFormatUtils.format(DateUtils.getLastYearSameMouthEnd(),"yyyy-MM-dd");//去年本月最后一天
        }else if ("lastMonth".equals(type)){
            firstDay = DateFormatUtils.format(DateUtils.getLastMouthBegin(),"yyyy-MM-dd");//上月第一天
            endDay = DateFormatUtils.format(DateUtils.geLastMouthEnd(),"yyyy-MM-dd");//上月最后一天
        }else if ("theYear".equals(type)){
            firstDay = DateFormatUtils.format(DateUtils.getThisMonthMonday(),"yyyy-MM-dd");//本月第一天
            endDay = DateFormatUtils.format(DateUtils.getThisMonthEndDay(),"yyyy-MM-dd");//本月最后一天
        }else if ("theMonth".equals(type)){
            firstDay = DateFormatUtils.format(DateUtils.getThisMonthMonday(),"yyyy-MM-dd");//本月第一天
            endDay = DateFormatUtils.format(DateUtils.getThisMonthEndDay(),"yyyy-MM-dd");//本月最后一天
        }
        params.put("lastDay",firstDay);
        params.put("theDay",endDay);
        return params;
    }

}
