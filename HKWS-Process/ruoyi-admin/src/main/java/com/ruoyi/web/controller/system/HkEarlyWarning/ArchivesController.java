package com.ruoyi.web.controller.system.HkEarlyWarning;

import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.*;
import com.ruoyi.system.domain.Daping.PercentResult;
import com.ruoyi.system.domain.HkEarlyWarning.*;
import com.ruoyi.system.service.*;
import com.ruoyi.system.service.HkEarlyWarning.HkEventService;
import com.ruoyi.system.service.statistics.HkEventStatisticsService;
import com.ruoyi.web.config.JWTConfigProperties;
import com.ruoyi.web.controller.common.utils.RedisTemplateKey;
import com.ruoyi.web.controller.common.utils.TimeField;
import com.ruoyi.web.controller.common.utils.TimeUtil;
import org.apache.commons.lang.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @author FanKaibiao
 * @date 2020-12-30-21:27
 */
@Controller
@RequestMapping("system/archives")
public class ArchivesController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(ArchivesController.class);

    @Autowired
    private JWTConfigProperties jwtConfigProperties;

    @Autowired
    private RedisTemplate redisTemplate;

    private String prefix = "system/Archives";

    @Autowired
    private HkEventService hkEventService;

    @Autowired
    private HkEventStatisticsService statisticsService;

    @Autowired
    private ISysDeptService sysDeptService;

    @Autowired
    private ISysRegionService sysRegionService;

    @Autowired
    private ISysPostService postService;

    @Autowired
    private ISysUserService sysUserService;

    @Autowired
    private ISysRanksService sysRanksService;

    @Autowired
    private HkEClassificationService hkEClassificationService;

    @Autowired
    private ISysUserService userService;

    /**
     * 一事一档切换
     * @param vo
     * @return
     */
    @GetMapping("queryThingList")
    @ResponseBody
    public TableDataInfo queryThingList(HkEventFourVo vo){
        if(StringUtils.isNull(vo.getPageNum())){
            throw new RuntimeException("请求页数不能为空");
        }
        if(StringUtils.isNull(vo.getPageSize())){
            throw new RuntimeException("每页行数不能为空");
        }
        startPage();
        List<HkEventThingVo> list = statisticsService.queryThingList(vo);
        return getDataTable(list);
    }

    /**
     * 导出事件统计列表数据
     * @param vo
     * @return
     */
    @PostMapping(value = "thingTableExport")
    @ResponseBody
    public AjaxResult thingTableExport(HkEventFourVo vo){
        vo.setPageNum(null);
        vo.setPageSize(null);
        List<HkEventThingVo> list = statisticsService.queryThingList(vo);
        ExcelUtil<HkEventThingVo> util = new ExcelUtil<HkEventThingVo>(HkEventThingVo.class);
        return util.exportExcel(list, "thingEventData");
    }


    /**
     * 一域一档切换
     * @param vo
     * @return
     */
    @GetMapping("queryFieldList")
    @ResponseBody
    public TableDataInfo queryFieldList(HkEventFourVo vo){
        startPage();
        List<HkEventFieldVo> list = statisticsService.queryFieldList(vo);
        return getDataTable(list);
    }

    /**
     *导出一域一档统计列表
     * @param vo
     * @return
     */
    @PostMapping(value = "fieldTableExport")
    @ResponseBody
    public AjaxResult fieldTableExport(HkEventFourVo vo){
        vo.setPageNum(null);
        vo.setPageSize(null);
        List<HkEventFieldVo> list = statisticsService.queryFieldList(vo);
        ExcelUtil<HkEventFieldVo> util = new ExcelUtil<HkEventFieldVo>(HkEventFieldVo.class);
        return util.exportExcel(list, "fieldEventData");
    }

    /**
     * 一人一档切换
     * @param vo
     * @return
     */
    @GetMapping("queryPersonList")
    @ResponseBody
    public TableDataInfo queryPersonList(HkEventFourVo vo){
        startPage();
        List<HkEventPersonVo> list = statisticsService.queryPersonList(vo);
        return getDataTable(list);
    }

    /**
     * 导出一人一档统计列表
     * @param vo
     * @return
     */
    @PostMapping(value = "personTableExport")
    @ResponseBody
    public AjaxResult personTableExport(HkEventFourVo vo){
        vo.setPageNum(null);
        vo.setPageSize(null);
        List<HkEventPersonVo> list = statisticsService.queryPersonList(vo);
        ExcelUtil<HkEventPersonVo> util = new ExcelUtil<HkEventPersonVo>(HkEventPersonVo.class);
        return util.exportExcel(list, "personEventData");
    }

    /**
     * 一期一档切换
     * @param vo
     * @return
     */
    @GetMapping("queryStageList")
    @ResponseBody
    public TableDataInfo queryDateList(HkEventFourVo vo){
        /*startPage();
        List<HkEventStageVo> list = hkEventService.queryStageList(vo);
        return getDataTable(list);*/
        if(StringUtils.isNull(vo.getPageNum())){
            throw new RuntimeException("请求页数不能为空");
        }
        if(StringUtils.isNull(vo.getPageSize())){
            throw new RuntimeException("每页行数不能为空");
        }
        startPage();
        List<HkEventThingVo> list = statisticsService.queryThingList(vo);
        return getDataTable(list);
    }

    /**
     * 导出一期一档统计列表
     * @param vo
     * @return
     */
    @PostMapping(value = "stageTableExport")
    @ResponseBody
    public AjaxResult stageTableExport(HkEventFourVo vo){
        vo.setPageNum(null);
        vo.setPageSize(null);
        List<HkEventThingVo> list = statisticsService.queryThingList(vo);
        ExcelUtil<HkEventThingVo> util = new ExcelUtil<HkEventThingVo>(HkEventThingVo.class);
        return util.exportExcel(list, "stageEventData");
    }


    //一事一档
    @RequestMapping(value = "Thinglist",method = RequestMethod.GET)
    public String ThingList(ModelMap mmap){
        //登录人
        return prefix + "/Thing";
    }

    //一事一档 事件列表
    @RequestMapping(value = "ThingEventList",method = RequestMethod.GET)
    public String ThingEventList(ModelMap mmap){
        //登录人
        List<HkEClassification> hkEClassifications = hkEClassificationService.queryEventEClassifications();
        mmap.put("eventClass",hkEClassifications);
        return prefix + "/EventThing";
    }

    /**
     * 一事一档 事件总数/完成总数/流转率/共治率
     * @param type
     * @return
     */
    @RequestMapping(value = "eventCount",method = RequestMethod.GET)
    @ResponseBody
    public AjaxResult eventCount(String type){
        /*String eventType ="";
        if("day".equals(type)){
            eventType = RedisTemplateKey.THING_COUNT_KEY_DAY;//事件趋势每日
        }else if("week".equals(type)){
            eventType = RedisTemplateKey.THING_COUNT_KEY_WEEK;//事件趋势每周
        }else{
            eventType = RedisTemplateKey.THING_COUNT_KEY_MONTH;//事件趋势每月
        }
        Map<String,String> map = getEventMaps(eventType);*/

        Map<String,String> map = null;
        if(map == null){
            Date date = new Date();
            map = getThing("1",type,date);//本日、本周、本月
            Map<String,String> lastThing = getThing("2",type,date);//昨日、上周、上月
            String lastWeekThingRate = compareTo(new BigDecimal(map.get("thingCount")),new BigDecimal(lastThing.get("thingCount")));
            String lastWeekCompleteRate = compareTo(new BigDecimal(map.get("completeCount")),new BigDecimal(lastThing.get("completeCount")));
            String lastWeekThingTurnoverRate = compareToRate(new BigDecimal(map.get("turnoverRate")),new BigDecimal(lastThing.get("turnoverRate")));
            String lastWeekThingTreatmentRate = compareToRate(new BigDecimal(map.get("handleRate")),new BigDecimal(lastThing.get("handleRate")));
            map.put("lastWeekThingRate",lastWeekThingRate);//事件比率
            map.put("lastWeekCompleteRate",lastWeekCompleteRate);//完成事件比率
            map.put("lastWeekThingTurnoverRate",lastWeekThingTurnoverRate);//流转率比例
            map.put("lastWeekThingTreatmentRate",lastWeekThingTreatmentRate);//共治率比例
        }
        AjaxResult success = AjaxResult.success(map);
        return success;
    }

    public Map<String,String> getThing(String flag,String type,Date date){
        /**1:预警 2:研判中 3:调度中,4:已退回 5:处置 6:完结 7:已忽略 8:关闭详情 9:系统自动完成,10:重复报警**/
        /**有效事件数 1:预警 2:研判中 3:调度中,4:已退回 5:处置 6:完结 7:已忽略**/
        /**事件总数 1:预警 2:研判中 3:调度中,4:已退回 5:处置 6:完结 7:已忽略 9:系统自动完成**/
        /**已完成事件总数 6:完结 7:已忽略 9:系统自动完成**/
        Map<String,String> thingResult = new HashMap<>();
        Map<String,Object> params1 = packageEventDate(flag,type,date);
        /**事件总数**/
        params1.put("statusArr",new String[]{"1","2","3","4","5","6","7","8","9"});
        Integer thingCount = statisticsService.countAllByParams(params1);//事件总数
        Map<String,Object> params2 = packageEventDate(flag,type,date);
        /**完成总数**/
        params2.put("statusArr",new String[]{"6","7","8","9"});
        Integer thingDoneCount = statisticsService.countAllByParams(params2);
        Map<String,Object> params3 = packageEventDate(flag,type,date);
        /**流转率**/
        params3.put("statusArr",new String[]{"3","4","5","6","7","8","9"});
        Integer turnoverRateCount = statisticsService.countAllByParams(params3);//流转数
        String turnoverRate = divideTo(new BigDecimal(thingCount),new BigDecimal(turnoverRateCount));//流转率
        /**共治率**/
        String handleRate = divideTo(new BigDecimal(thingCount),new BigDecimal(thingDoneCount));//处置率

        thingResult.put("thingCount",String.valueOf(thingCount));
        thingResult.put("completeCount",String.valueOf(thingDoneCount));
        thingResult.put("turnoverRate",turnoverRate);
        thingResult.put("handleRate",handleRate);
        return thingResult;
    }

    /**
     * 增长/下降比例判断
     * @param rate
     * @return
     */
    private String RateCompareTo(BigDecimal rate){
        String rateSub = "";
        if(rate.compareTo(BigDecimal.ZERO) == -1){
            rateSub = "<i class='Down'>同环下降"+ -rate.doubleValue()+"%</i>";
        }else{
            rateSub = "<i class='Up'>同环增长"+rate+"%</i>";
        }
        return rateSub;
    }

    /**
     * 一事一档
     * 事件趋势分析
     * @param type 本日: day 本周 week 本月 month
     * @return
     */
    @RequestMapping(value = "eventTrend",method = RequestMethod.GET)
    @ResponseBody
    public AjaxResult eventTrend(@RequestParam String type) throws ParseException {
        //redis-key
        /*String eventType = "";
        if("day".equals(type)){
            eventType = RedisTemplateKey.THING_EVENT_TREND_BY_DAY;//事件趋势每日
        }else if("week".equals(type)){
            eventType = RedisTemplateKey.THING_EVENT_TREND_BY_WEEK;//事件趋势每周
        }else{
            eventType = RedisTemplateKey.THING_EVENT_TREND_BY_MONTH;//事件趋势每月
        }
        //获取事件趋势数据集 redis
        Map data = getEventMaps(eventType);*/
        Map<String,Object> data = null;
        if(data == null){
            Date date = new Date();
            //查询日期范围Map
            Map<String,Object> params = EventDate(type,date);
            //店外违规事件 //无店外违规事件
            List<Integer> eventTrendCount = new ArrayList<>();

            String nearlyADayBegin      =  (String)params.get("nearlyADayBegin");
            String nearlyADayEnd        =  (String)params.get("nearlyADayEnd");
            String nearlyAWeekBegin     =  (String)params.get("nearlyAWeekBegin");
            String nearlyAWeekEnd       =  (String)params.get("nearlyAWeekEnd");
            String nearlyAMonthBegin    =  (String)params.get("nearlyAMonthBegin");
            String nearlyAMonthEnd      =  (String)params.get("nearlyAMonthEnd");
            String nearlyAYearBegin     =  (String)params.get("nearlyAYearBegin");
            String nearlyAYearEnd       =  (String)params.get("nearlyAYearEnd");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            List<Integer> countList = new ArrayList<>();
            List<String> timeList = new ArrayList<>();
            try{
                if(!StringUtils.isEmpty(nearlyADayBegin) && StringUtils.isEmpty(nearlyADayEnd)){
                    SimpleDateFormat sdf1 = new SimpleDateFormat("HH");
                    params.clear();
                    //天数返回24小时段
                    long time = sdf.parse(nearlyADayBegin).getTime();
                    String beginDateTime = nearlyADayBegin;
                    for(int i = 1; i <= 24; i++){
                        time += 3600000;
                        String endDateTime = sdf.format(new Date(time));
                        String endTime = sdf1.format(new Date(time))+"时";
                        params.put("endDateTime",endDateTime);
                        params.put("beginDateTime",beginDateTime);
                        params.put("statusArr",new String[]{"1","2","3","4","5","6","7","8","9"});
                        Integer thingCount = statisticsService.countAllByParams(params);
                        beginDateTime = endDateTime;
                        countList.add(thingCount);
                        timeList.add(endTime);
                    }
                }
                if(!StringUtils.isEmpty(nearlyAWeekBegin) && StringUtils.isEmpty(nearlyAWeekEnd)){
                    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
                    params.clear();
                    //周返回天数段
                    long time = sdf.parse(nearlyAWeekBegin).getTime();
                    String beginDateTime = nearlyAWeekBegin;
                    for(int i = 1; i <= 7; i++){
                        time += 3600000*24;
                        String endDateTime = sdf.format(new Date(time));
                        String endTime = sdf1.format(new Date(time));
                        params.put("endDateTime",endDateTime);
                        params.put("beginDateTime",beginDateTime);
                        params.put("statusArr",new String[]{"1","2","3","4","5","6","7","8","9"});
                        Integer thingCount = statisticsService.countAllByParams(params);
                        beginDateTime = endDateTime;
                        countList.add(thingCount);
                        timeList.add(endTime);
                    }
                }
                if(!StringUtils.isEmpty(nearlyAMonthBegin) && StringUtils.isEmpty(nearlyAMonthEnd)){
                    long days = DateUtil.betweenDay(DateUtil.offsetMonth(date, -1), date, false);
                    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
                    params.clear();
                    //月返回天数段
                    long time = sdf.parse(nearlyAMonthBegin).getTime();
                    String beginDateTime = nearlyAMonthBegin;
                    for(int i = 1; i <= days; i++){
                        time += 3600000*24;
                        String endDateTime = sdf.format(new Date(time));
                        String endTime = sdf1.format(new Date(time));
                        params.put("endDateTime",endDateTime);
                        params.put("beginDateTime",beginDateTime);
                        params.put("statusArr",new String[]{"1","2","3","4","5","6","7","8","9"});
                        Integer thingCount = statisticsService.countAllByParams(params);
                        beginDateTime = endDateTime;
                        countList.add(thingCount);
                        timeList.add(endTime);
                    }
                }
                if(!StringUtils.isEmpty(nearlyAYearBegin) && StringUtils.isEmpty(nearlyAYearEnd)){
                    params.clear();
                    //年返回月数段
                    String beginDateTime = nearlyAYearBegin;
                    for(int i = 1; i <= 12; i++){
                        String endTime = DateUtil.offsetMonth(sdf.parse(beginDateTime), i).toString().substring(0,10);
                        params.put("endDateTime",DateUtil.offsetMonth(sdf.parse(beginDateTime), i).toString());
                        params.put("beginDateTime",DateUtil.offsetMonth(sdf.parse(beginDateTime), i-1).toString());
                        params.put("statusArr",new String[]{"1","2","3","4","5","6","7","8","9"});
                        Integer thingCount = statisticsService.countAllByParams(params);
                        countList.add(thingCount);
                        timeList.add(endTime);
                    }
                }
            }catch(Exception ex){
                ex.printStackTrace();
            }
            data = new HashMap();
            data.put("eventTrend",eventTrendCount);
            data.put("eventPlaceTypeTrends",countList);
            data.put("eventTrendDate",timeList);
            /*putEvents(eventType, data,type);*/
        }
        AjaxResult success = AjaxResult.success(data);
        return success;
    }


    /**
     * 一事一档-事件趋势-范围选择
     * @param startDate 开始日期
     * @param endDate 结束日期
     * @return
     */
    /*@RequestMapping(value = "eventTrendByDate",method = RequestMethod.GET)
    @ResponseBody
    public AjaxResult eventTrendByDay(@RequestParam String startDate,@RequestParam String endDate) throws ParseException {
        //获取时间段
        Map<String,Object> map = new TimeUtil().getTimeDifference(startDate,endDate);
        Boolean isBetweenZero = (Boolean) map.get("isBetweenZero");//是否为一天时间段
        //街面事件数
        List<Integer> eventPlaceTypeTrendCount = new ArrayList<>();
        //店外事件数
        List<Integer> eventTrendCount = new ArrayList<>();
        //时间段
        List<String> eventTrendDate = new ArrayList<>();
        List<String> times = null;

        Map<String,Object> initTimeParams = new HashMap<>();
        //当天则去12个时段 分类处理
        if(isBetweenZero){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            //街面违规事件
            initTimeParams.put("currentDate",sdf.format(sdf.parse(startDate)));
            List<EventTrendVO> eventPlaceTypeTrends = statisticsService.queryEventTrends(initTimeParams);
            //根据type区分返回前台所需数据格式，例：day：00-02 02-04，两小时为一界限，week：以一天为界限，month：以7天为界限
            List<TimeField> timeFields = new TimeUtil().getTime("day");
            times =  timeFields.stream().map(TimeField::getDate).collect(Collectors.toList());
            eventPlaceTypeTrendCount = DataFormat(eventPlaceTypeTrends,"day",timeFields);
        }else{
            //第一个时间段为事件初始数，后面根据时间区间查询
            times = (List<String>) map.get("timeField");
            String initTimeField =times.get(0);
            initTimeParams.put("currentDate",initTimeField);
            //街面违规事件
            int count = statisticsService.queryEventTrendByDay(initTimeParams);
            eventPlaceTypeTrendCount.add(count);
            eventTrendDate.add(initTimeField);
            if(times.size() > 1){
                Map<String,Object> timeParams = new HashMap<>();
                for(int i =0;i < times.size() -1;i++){
                    String startDateParam =  times.get(i);
                    String endDateParam = times.get(i+1);
                    timeParams.put("startDate",startDateParam);
                    timeParams.put("endDate",endDateParam);
                    count = statisticsService.queryEventTrendByDay(timeParams);
                    eventPlaceTypeTrendCount.add(count);
                    eventTrendDate.add(endDateParam);
                }
            }
        }

        //response
        Map data = new HashMap();
        data.put("eventTrend",eventTrendCount);
        data.put("eventPlaceTypeTrends",eventPlaceTypeTrendCount);
        data.put("eventTrendDate",times);
        AjaxResult success = AjaxResult.success(data);
        return success;
    }*/

    /**
     * 一事一档
     * 事件分布分析
     * @param
     * @return
     */
    @GetMapping(value = "eventRegion")
    @ResponseBody
    public AjaxResult queryEventRegion(HkEventThingParamVO param){
        //redis-key
        String type = param.getType();
        /*String eventType ="";
        if("day".equals(type)){
            eventType = RedisTemplateKey.THING_REGION_BY_DAY;//事件趋势每日
        }else if("week".equals(type)){
            eventType = RedisTemplateKey.THING_REGION_BY_WEEK;//事件趋势每周
        }else{
            eventType = RedisTemplateKey.THING_REGION_BY_MONTH;//事件趋势每月
        }
        //获取社区检测数据集 redis
        Map data = getEventMaps(eventType);*/
        Map<String,Object> data = null;
        if(data == null){
            data = new HashMap();
            Date date = new Date();
            //查询日期范围Map
            Map<String,Object> params = EventDate(type,date);
            params.put("regionCode",param.getRegionCode());
            if(!StringUtils.isEmpty(param.getSort()) && !StringUtils.isEmpty(param.getSortItem())){
                params.put("sort",param.getSort());
                params.put("sortItem",param.getSortItem());
            }
            List<EventInspectVO>  eventInspectVOS = statisticsService.queryEventRegion(params);
            List<Integer> eventCount = eventInspectVOS.stream().map(EventInspectVO::getEventCount).collect(Collectors.toList());//事件数量
            List<String> regionName = eventInspectVOS.stream().map(EventInspectVO::getRegionName).collect(Collectors.toList());//街道名称
            List<String> governanceRate = eventInspectVOS.stream().map(EventInspectVO::getGovernanceRate).collect(Collectors.toList());//共治率
            List<String> transferRate = eventInspectVOS.stream().map(EventInspectVO::getTransferRate).collect(Collectors.toList());//共治率
            data.put("eventCount",eventCount);
            data.put("regionName",regionName);
            data.put("transferRate",transferRate);
            data.put("governanceRate",governanceRate);
            //保存至redis
            /*putEventMaps(eventType, data,type);*/
        }
        AjaxResult success = AjaxResult.success(data);
        return success;
    }


    /**
     * 一事一档-
     * 事件类型统计
     * @param type 本日: day 本周 week 本月 month
     * @param regionCode 社区Code
     * @return
     */
    @GetMapping(value = "eventType")
    @ResponseBody
    public AjaxResult queryEventType(@RequestParam String type,@RequestParam(required = false) String regionCode){
        //redis-key
        /*String eventType ="";
        if("day".equals(type)){
            eventType = RedisTemplateKey.THING_EVENT_TYPE_COUNT_BY_DAY;//事件趋势每日
        }else if("week".equals(type)){
            eventType = RedisTemplateKey.THING_EVENT_TYPE_COUNT_BY_WEEK;//事件趋势每周
        }else{
            eventType = RedisTemplateKey.THING_EVENT_TYPE_COUNT_BY_MONTH;//事件趋势每月
        }
        List<EventTypeVO> typeVOS = getEvents(eventType);//获取前五事件类型数据,其余事件类型列为其他*/
        List<EventTypeVO> typeVOS = new ArrayList<>();
        if(typeVOS ==null || typeVOS.size() < 1){
            Date date = new Date();
            //查询日期范围Map
            Map<String,Object> map = EventDate(type,date);
            map.put("regionId",regionCode);
            List<EventTypeVO> eventTypeVOS = statisticsService.queryEventType(map);
            /**关联查询自定义事件分类与上报平台的事件分类**/
            /*List<EventTypeVO> eventTypeVOS = statisticsService.queryEventTypePartTwo(map);*/
            typeVOS = new ArrayList<>();
            packageEventType(eventTypeVOS,typeVOS);
            //保存至redis
            /*putEvents(eventType,typeVOS,type);*/
        }
        AjaxResult success = AjaxResult.success(typeVOS);
        return success;
    }

    public void packageEventType(List<EventTypeVO> eventTypeVOS,List<EventTypeVO> typeVOS){
        Integer otherValue = 0;
        for (int i =0;i<eventTypeVOS.size();i++) {
            if(i<=4){
                typeVOS.add(eventTypeVOS.get(i));
                continue;
            }
            otherValue = otherValue + eventTypeVOS.get(i).getValue();
        }
        //将其余事件类型数据统计为其他
        EventTypeVO otherTypeVOS = new EventTypeVO();
        otherTypeVOS.setName("其他");
        otherTypeVOS.setValue(otherValue);
        typeVOS.add(otherTypeVOS);
    }

    /**
     * 一事一档
     * 事件类型分析
     * @return
     */
    @GetMapping(value = "regionEventTypeByRegion")
    @ResponseBody
    public AjaxResult regionEventTypeByRegion(@RequestParam String type,@RequestParam(required = false) String regionId){
        Date date = new Date();
        Map<String,Object> params = EventDate(type,date);
        params.put("regionId",regionId);
        List<EventTypeVO> regionEventTypeVOS = statisticsService.queryEventTypeByRegion(params);
        List<EventTypeVO> typeVOS = new ArrayList<>();
        typeVOS = new ArrayList<>();
        packageEventType(regionEventTypeVOS,typeVOS);
        AjaxResult success = AjaxResult.success(regionEventTypeVOS);
        return success;
    }

    /**
     * 一事一档 类型列表
     * @return
     */
    @GetMapping(value = "regionNames")
    @ResponseBody
    public AjaxResult queryRegionNames(){
        //社区名称
        List<SysRegion> sysRegions =  sysRegionService.queryRegionNames();
        return AjaxResult.success(sysRegions);
    }


    /**
     * 一事一档-事件分析
     * 查询事件耗时
     *
     * @param type 本日: day 本周 week 本月 month
     * @return
     */
    @GetMapping(value = "eventAnalysis")
    @ResponseBody
    public AjaxResult queryEventAnalysis(@RequestParam String type){
        //redis-key
        /*String eventType ="";
        if("day".equals(type)){
            eventType = RedisTemplateKey.THING_EVENT_ANALYSIS_BY_DAY;//事件趋势每日
        }else if("week".equals(type)){
            eventType = RedisTemplateKey.THING_EVENT_ANALYSIS_BY_WEEK;//事件趋势每周
        }else{
            eventType = RedisTemplateKey.THING_EVENT_ANALYSIS_BY_MONTH;//事件趋势每月
        }
        Map<String,String> map = getEventMaps(eventType);*/
        Map<String,String> map = null;
        if(map == null){
            map = new HashMap();
            Date date = new Date();
            //查询日期范围Map
            Map<String,Object> params = EventDate(type,date);
            params.put("statusArr",new String[]{"6","7","8","9"});
            List<EventAnalysisVO> eventAnalysisVOS = statisticsService.queryEventAnalysisPartTwo(params);
            for(EventAnalysisVO eventAnalysisVO:eventAnalysisVOS){
                params.put("componentId",eventAnalysisVO.getEventAnalysisTypeCode());
                Long aLong = statisticsService.queryEventSumTime(params);
                aLong = aLong == null?0:aLong;
                map.put(eventAnalysisVO.getEventAnalysisTypeName(),DateUtils.getHourByTime(aLong).toString());
            }
            //.........................切换为映射后的自定义平台事件 分组...........................................
            //List<EventAnalysisVO> eventAnalysisVOS = statisticsService.queryEventAnalysisPart(params);//各事件类型的事件总数
            /*List<EventAnalysisVO> eventTimeInfo = statisticsService.eventActiveTimeByEventType(params);//各事件类型的事件总耗时
            for(EventAnalysisVO vo : eventTimeInfo){
                map.put(vo.getEventAnalysisTypeName(),DateUtils.getHourByTime((long)vo.getEventAnalysisAvgTime()).toString());
            }*/
            //保存至redis
            /*putEventMaps(eventType,map,type);*/
        }
        Map<String,Object> response = new HashMap<>();
        response.put("eventAnalysisTypeNames",map.keySet());
        response.put("eventAnalysisTypeCounts",map.values());
        AjaxResult success = AjaxResult.success(response);
        return success;
    }

    /**
     * 一事一档-事件分析
     * 事件处置分析
     * @param param
     * {
     *       type: 日day 周week 月month 年year
     *       sortItem:排序字段
     *       sort: 排序
     * }
     * @return
     */
    @GetMapping(value = "eventProcessAnalysis")
    @ResponseBody
    public AjaxResult eventProcessAnalysis(HkEventThingParamVO param){
        //redis-key
        String type = param.getType();
        String sort = param.getSort();
        String sortItem = param.getSortItem();
        /*String eventType ="";
        if("day".equals(type)){
            eventType = RedisTemplateKey.THING_EVENT_ANALYSIS_BY_DAY;//事件趋势每日
        }else if("week".equals(type)){
            eventType = RedisTemplateKey.THING_EVENT_ANALYSIS_BY_WEEK;//事件趋势每周
        }else{
            eventType = RedisTemplateKey.THING_EVENT_ANALYSIS_BY_MONTH;//事件趋势每月
        }
        Map<String,String> map = getEventMaps(eventType);*/
        Map<String,String> map = null;
        Map<String,Object> response = new HashMap<>();
        if(map == null){
            map = new HashMap();
            Date date = new Date();
            //查询日期范围Map
            Map<String,Object> params = EventDate(type,date);
            params.put("sort",sort);
            params.put("sortItem",sortItem);
            List<EventAnalysisVO> eventAnalysisVOS = statisticsService.eventProcessAnalysis(params);
            //.........................切换为映射后的自定义平台事件 分组...........................................
            //List<EventAnalysisVO> eventAnalysisVOS = statisticsService.queryEventAnalysisPart(params);//各事件类型的事件总数
            /*List<EventAnalysisVO> eventTimeInfo = statisticsService.eventActiveTimeByEventType(params);//各事件类型的事件总耗时
            for(EventAnalysisVO vo : eventTimeInfo){
                map.put(vo.getEventAnalysisTypeName(),DateUtils.getHourByTime((long)vo.getEventAnalysisAvgTime()).toString());
            }*/

            List<String> governanceRateList = eventAnalysisVOS.stream().map(EventAnalysisVO::getGovernanceRate).collect(Collectors.toList());//共治率
            List<String> transforRateList = eventAnalysisVOS.stream().map(EventAnalysisVO::getTransforRate).collect(Collectors.toList());//流转率
            List<String> eventAnalysisTypeNames = eventAnalysisVOS.stream().map(EventAnalysisVO::getEventAnalysisTypeName).collect(Collectors.toList());//事件类型名称
            response.put("transforRateList",transforRateList);
            response.put("governanceRateList",governanceRateList);
            response.put("eventAnalysisTypeNames",eventAnalysisTypeNames);
            //保存至redis
            /*putEventMaps(eventType,map,type);*/
        }
        return AjaxResult.success(response);
    }

    /**
     * 一事一档-赋能流转
     * @param type 本日: day 本周 week 本月 month
     * @return
     */
    @GetMapping(value = "eventChange")
    @ResponseBody
    public AjaxResult queryEventChange(@RequestParam String type){
        //redis-key
        /*String eventType ="";
        if("day".equals(type)){
            eventType = RedisTemplateKey.THING_EVENT_CHANGE_BY_DAY;//事件趋势每日
        }else if("week".equals(type)){
            eventType = RedisTemplateKey.THING_EVENT_CHANGE_BY_WEEK;//事件趋势每周
        }else{
            eventType = RedisTemplateKey.THING_EVENT_CHANGE_BY_MONTH;//事件趋势每月
        }
        Map map = getEventMaps(eventType);*/
        Map<String,Object> map = null;
        if(map ==null ){
            Date date = new Date();
            /**1:预警 2:研判中 3:调度中,4:已退回 5:处置 6:完结 7:已忽略 8:关闭详情 9:系统自动完成,10:重复报警**/
            Map<String,Object> thingParams = EventDate(type,date);
            thingParams.put("statusArr",new String[]{"1","2","3","4","5","6","7","8","9"});
            Integer thingCount = statisticsService.countAllByParams(thingParams);//事件总数
            /*inAdvanceParams.put("inAdvanceStatus","1,10");*/
            thingParams.put("statusArr",new String[]{"1","2","3","4","5","6","7","8","9"});//预警总数
            int inAdvanceCount =  statisticsService.countAllByParams(thingParams);
            /*judgeParams.put("judgeStatus","1,2,10");*/
            thingParams.put("statusArr",new String[]{"2","3","4","5","6","7","8","9"});//研判
            int judgeCount = statisticsService.countAllByParams(thingParams);
            /*handleParams.put("handleStatus","1,2,3,4,10");*/
            thingParams.put("statusArr",new String[]{"5","6","7","8","9"});//正在处理
            int handleCount = statisticsService.countAllByParams(thingParams);
            /*achieveParams.put("achieveStatus","6,7,9");*/
            thingParams.put("statusArr",new String[]{"6","7","8","9"});//完成
            int achieveCount =  statisticsService.countAllByParams(thingParams);

            map = new HashMap();
            List<EventChangeVO> eventChangeVOS = new ArrayList<>();
            EventChangeVO inAdvanceEventChangeVO = new EventChangeVO();
            inAdvanceEventChangeVO.setName("预警总数");
            inAdvanceEventChangeVO.setValue(Double.valueOf(inAdvanceCount));
            EventChangeVO judgeEventChangeVO = new EventChangeVO();
            judgeEventChangeVO.setName("研判总数");
            judgeEventChangeVO.setValue(Double.valueOf(judgeCount));
            EventChangeVO handleEventChangeVO = new EventChangeVO();
            handleEventChangeVO.setName("签收总数");
            handleEventChangeVO.setValue(Double.valueOf(handleCount));
            EventChangeVO achieveEventChangeVO = new EventChangeVO();
            achieveEventChangeVO.setName("完成总数");
            achieveEventChangeVO.setValue(Double.valueOf(achieveCount));
            eventChangeVOS.add(inAdvanceEventChangeVO);
            eventChangeVOS.add(judgeEventChangeVO);
            eventChangeVOS.add(handleEventChangeVO);
            eventChangeVOS.add(achieveEventChangeVO);
            map.put("eventChangeVOS",eventChangeVOS);
            //保存至redis
            /*putEventMaps(eventType,map,"");*/
        }
        AjaxResult success = AjaxResult.success(map);
        return success;
    }


    /**
     * 一域一档
     * @param mmap
     * @return
     */
    @GetMapping(value = "Fieldlist")
    public String FieldList(ModelMap mmap){
        //登录人
        return prefix + "/Field";
    }

    //一域一档 事件列表
    @GetMapping(value = "FieldEventList")
    public String FieldEventList(ModelMap mmap){
        //登录人
        /*mmap.put("user", ShiroUtils.getLoginName());*/
        List<HkEClassification> hkEClassifications = hkEClassificationService.queryEventEClassifications();
        mmap.put("eventClass",hkEClassifications);
        return prefix + "/EventField";
    }

    /**
     * 一域一档 社区总数
     * @return
     */
    @GetMapping(value = "regionCount")
    @ResponseBody
    public AjaxResult queryRegionCount(String type){

        /*String eventType ="";
        if("day".equals(type)){
            eventType = RedisTemplateKey.REGION_COUNT_DAY;//事件趋势每日
        }else if("week".equals(type)){
            eventType = RedisTemplateKey.REGION_COUNT_WEEK;//事件趋势每周
        }else{
            eventType = RedisTemplateKey.REGION_COUNT_MONTH;//事件趋势每月
        }
        Map<String,String> map = getEventMaps(eventType);*/
        Map<String,String> map = null;
        if(map == null){
            Date date = new Date();
            map = getRegion("1",type,date);
            Map<String,String> lastRegion = getRegion("2",type,date);
            String lastWeekRegionCount = compareTo(new BigDecimal(map.get("regionCount")),new BigDecimal(lastRegion.get("regionCount")));
            String lastWeekRegionEventAvgCount = compareTo(new BigDecimal(map.get("regionEventAvgCount")),new BigDecimal(lastRegion.get("regionEventAvgCount")));
            String lastWeekRegionPeopleCount = compareTo(new BigDecimal(map.get("regionPeopleCount")),new BigDecimal(lastRegion.get("regionPeopleCount")));
            String lastWeekRegionLoad = compareToRate(new BigDecimal(map.get("regionLoad")),new BigDecimal(lastRegion.get("regionLoad")));

            map.put("regionCountRate",lastWeekRegionCount);//社区增长比
            map.put("regionEventAvgCountRate",lastWeekRegionEventAvgCount);//社区平均比
            map.put("regionPeopleCountRate",lastWeekRegionPeopleCount);//社区人数比
            map.put("regionLoadRate",lastWeekRegionLoad);//街道负荷比
        }
        AjaxResult success = AjaxResult.success(map);
        return success;
    }

    public Map<String,String> getRegion(String flag,String type,Date date){
        Map<String,String> thingResult = new HashMap<>();

        //社区总数 不用带时间参数查询
        Map<String,Object> param1 = new HashMap<>();
        param1.put("level",2);
        Integer regionCount = sysRegionService.queryRegionCountByParam(param1);

        Map<String,Object> thingParams = packageEventDate(flag,type,date);
        thingParams.put("statusArr",new String[]{"1","2","3","4","5","6","7","8","9"});
        /*RegionLoadVO regionLoadVO = statisticsService.queryEventHappenRegionInfo(thingParams);
        Integer regionCount = regionLoadVO.getRegionCount();//事件发生的社区数量
        Integer regionPeopleCount = regionLoadVO.getUserCount();//发生事件的社区中的网格人数*/

        Integer eventAllCount = statisticsService.countAllByParams(thingParams);//事件总数
        //社区平均件数 = 事件数/社区总数
        String regionEventAvgCount = divideToAvg(new BigDecimal(regionCount),new BigDecimal(eventAllCount));//社区平均件数

        //街道人数 网格人员数量
        Map<String,Object> param3 = new HashMap<>();
        Integer regionPeopleCount = sysRanksService.querySysRanksCount(param3);
        Integer days = 0;
        try{
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            switch (type){
                case "week":
                    days = 7;
                    break;
                case "month":
                    days = Integer.parseInt(DateUtil.betweenDay(DateUtil.offsetMonth(date,-1),date,false)+"");
                    break;
                case "year":
                    Date parse = sdf.parse(DateUtils.getNearlyYear(date, -1));
                    days = Integer.parseInt(DateUtil.betweenDay(parse,date,false)+"");
                    break;
                default:
                    days = 1;
                    break;
            }
        }catch(Exception ex){
            logger.info("==================日期格式转换错误==================");
            ex.printStackTrace();
        }
        //街道负荷
        String regionLoad = new BigDecimal(eventAllCount).divide(new BigDecimal(regionPeopleCount),2,BigDecimal.ROUND_HALF_UP)
                .divide(new BigDecimal(days),2,BigDecimal.ROUND_HALF_UP).doubleValue()+"";
        thingResult.put("regionCount",String.valueOf(regionCount));
        thingResult.put("regionEventAvgCount",regionEventAvgCount);
        thingResult.put("regionPeopleCount",String.valueOf(regionPeopleCount));
        thingResult.put("regionLoad",regionLoad);
        return thingResult;
    }


    private String compareTo(BigDecimal count,BigDecimal lastCount){
        BigDecimal rate =new BigDecimal(0);
        if(count.compareTo(BigDecimal.ZERO) >0){
            BigDecimal regionCountSubtract = count.subtract(lastCount).setScale(2, BigDecimal.ROUND_HALF_UP);
            rate = regionCountSubtract.divide(count,2, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100));
        }
        return RateCompareTo(rate);
    }

    private String compareToRate(BigDecimal count,BigDecimal lastCount){
        BigDecimal rate =new BigDecimal(0);
        if(count.compareTo(BigDecimal.ZERO) >0){
            rate = count.subtract(lastCount);
        }
        return RateCompareTo(rate);
    }

    private String divideTo(BigDecimal num,BigDecimal num1){
        BigDecimal rate =new BigDecimal(0);
        if(num.compareTo(BigDecimal.ZERO) >0){
            rate = num1.divide(num,2, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100));
        }
        return rate.toString();
    }

    private String divideToAvg(BigDecimal num,BigDecimal num1){
        BigDecimal rate =new BigDecimal(0);
        if(num.compareTo(BigDecimal.ZERO) >0){
            rate = num1.divide(num,2, BigDecimal.ROUND_HALF_UP);
        }
        return rate.toString();
    }


    /**
     * 一域一档 赋能流转
     * @return
     */

    @GetMapping(value = "regionChange")
    @ResponseBody
    public AjaxResult queryRegionChange(@RequestParam String type) {
       /* String eventType ="";
        if("day".equals(type)){
            eventType = RedisTemplateKey.REGION_CHANGE_RATE_BY_DAY;//事件趋势每日
        }else if("week".equals(type)){
            eventType = RedisTemplateKey.REGION_CHANGE_RATE_BY_WEEK;//事件趋势每周
        }else{
            eventType = RedisTemplateKey.REGION_CHANGE_RATE_BY_MONTH;//事件趋势每月
        }
        Map map = getEventMaps(eventType);*/
        Map<String,Object> map = null;
        if(map == null){
            Date date = new Date();
            Map<String,Object> params = EventDate(type,date);
            //将社区 dept_id 存储至redis中，通过逐层寻找，对比齐parent_id 一致，如一致则，取用该dept_name 作为社区名称
            params.put("statusArr",new String[]{"1","2","3","4","5","6","7","8","9"});
            List<RegionChangeVO> eventChanges = sysRegionService.queryRegionChange(params);
            List<Integer> eventChangeCounts = eventChanges.stream().map(RegionChangeVO::getEventChangeCount).collect(Collectors.toList());//流转事件数
            List<String> eventChangeNames = eventChanges.stream().map(RegionChangeVO::getEventChangeName).collect(Collectors.toList());//流转区域名称
            map = new HashMap();
            map.put("eventChangeCounts",eventChangeCounts);
            map.put("eventChangeNames",eventChangeNames);
            //保存至redis
            /*putEvents(eventType,map,"");*/
        }
        AjaxResult success = AjaxResult.success(map);
        return success;
    }


    /**
     * 一域一档 赋能流转-时间范围选择
     * @return
     */
    @GetMapping(value = "regionChangeByDate")
    @ResponseBody
    public AjaxResult queryRegionChangeByDate(@RequestParam(required = true) String startDate,@RequestParam(required = true) String endDate) throws ParseException {
        Map params = new HashMap();
        params.put("startDate",DateFormatUtils.format(DateUtils.parseDate(startDate),"yyyy-MM-dd"));
        params.put("endDate",DateFormatUtils.format(DateUtils.parseDate(endDate),"yyyy-MM-dd"));
        //将社区 dept_id 存储至redis中，通过逐层寻找，对比齐parent_id 一致，如一致则，取用该dept_name 作为社区名称
        params.put("statusArr",new String[]{"1","2","3","4","5","6","7","8","9"});
        List<RegionChangeVO> eventChanges = sysRegionService.queryRegionChange(params);
        List<Integer> eventChangeCounts = eventChanges.stream().map(RegionChangeVO::getEventChangeCount).collect(Collectors.toList());//流转事件数
        List<String> eventChangeNames = eventChanges.stream().map(RegionChangeVO::getEventChangeName).collect(Collectors.toList());//流转区域名称
        Map map = new HashMap();
        map.put("eventChangeCounts",eventChangeCounts);
        map.put("eventChangeNames",eventChangeNames);
        AjaxResult success = AjaxResult.success(map);
        return success;
    }

    /**
     * 一域一档 街道负荷
     * @return
     */
    @GetMapping(value = "regionLoad")
    @ResponseBody
    public AjaxResult queryRegionLoad(@RequestParam String type){
        /*String eventType ="";
        if("day".equals(type)){
            eventType = RedisTemplateKey.REGION_LOAD_BY_DAY;//事件趋势每日
        }else if("week".equals(type)){
            eventType = RedisTemplateKey.REGION_LOAD_BY_WEEK;//事件趋势每周
        }else{
            eventType = RedisTemplateKey.REGION_LOAD_BY_MONTH;//事件趋势每月
        }
        Map map = getEventMaps(eventType);*/
        Map<String,Object> map = null;
        if(map == null){
            Date date = new Date();
            Map<String,Object> params = EventDate(type,date);
            params.put("desc","desc");
            params.put("limit",8);
            params.put("statusArr",new String[]{"1","2","3","4","5","6","7","8","9"});
            List<RegionLoadVO> regionLoadVOS = sysRegionService.queryRegionLoad(params);
            for (RegionLoadVO regionLoadVO : regionLoadVOS) {
                String eventCount = regionLoadVO.getEventCount() == null ? "0" : ( regionLoadVO.getEventCount() + "");
                String userCount = regionLoadVO.getUserCount()== null ? "0" : (regionLoadVO.getUserCount()+"");
                //区域负荷数 事件总数/人员总数
                BigDecimal _userCount = new BigDecimal(userCount);
                BigDecimal _eventCount = new BigDecimal(eventCount);
                regionLoadVO.setRegionLoadCount(Double.valueOf(divideTo(_userCount,_eventCount)));
            }

            List<Double> regionEfficiencyCount = regionLoadVOS.stream().map(RegionLoadVO::getRegionLoadCount).collect(Collectors.toList());//符合率
            List<String> regionEfficiencyName = regionLoadVOS.stream().map(RegionLoadVO::getRegionName).collect(Collectors.toList());//社区名称
            map = new HashMap();
            map.put("regionEfficiencyCount",regionEfficiencyCount);
            map.put("regionEfficiencyName",regionEfficiencyName);
            //保存至redis
            /*putEventMaps(eventType,map,"");*/
        }
        AjaxResult success = AjaxResult.success(map);
        return success;
    }

    /**
     * 一域一档 类型统计
     * @return
     */
    @GetMapping(value = "regionEventType")
    @ResponseBody
    public AjaxResult queryRegionEventType(@RequestParam String type){
        /*String eventType ="";
        if("day".equals(type)){
            eventType = RedisTemplateKey.REGION_EVENT_TYPE_COUNT_BY_DAY;//事件趋势每日
        }else if("week".equals(type)){
            eventType = RedisTemplateKey.REGION_EVENT_TYPE_COUNT_BY_WEEK;//事件趋势每周
        }else{
            eventType = RedisTemplateKey.REGION_EVENT_TYPE_COUNT_BY_MONTH;//事件趋势每月
        }
        List<RegionEventTypeVO> eventTypeVOS = getEvents(eventType);*/
        List<RegionEventTypeVO> eventTypeVOS = new ArrayList<>();
        if(eventTypeVOS == null || eventTypeVOS.size() <1){
            Date date = new Date();
            Map<String,Object> params = EventDate(type,date);
            params.put("desc","desc");
            params.put("statusArr",new String[]{"1","2","3","4","5","6","7","8","9"});
            List<RegionEventTypeVO> regionEventTypeVOS = statisticsService.queryRegionEventType(params);
            eventTypeVOS = new ArrayList<>();
            packageRegion(regionEventTypeVOS,eventTypeVOS);
            //保存至redis
            /*putEvents(eventType,eventTypeVOS,"");*/
        }
        AjaxResult success = AjaxResult.success(eventTypeVOS);
        return success;
    }

    public void packageRegion(List<RegionEventTypeVO> regionEventTypeVOS,List<RegionEventTypeVO> eventTypeVOS){
        Integer otherValue = 0;
        for(int i =0;i<regionEventTypeVOS.size();i++){
            if(i<=4){
                eventTypeVOS.add(regionEventTypeVOS.get(i));
                continue;
            }
            otherValue = otherValue + regionEventTypeVOS.get(i).getValue();
        }
        //将其余事件类型数据统计为其他
        RegionEventTypeVO regionEventTypeVO = new RegionEventTypeVO();
        regionEventTypeVO.setName("其他");
        regionEventTypeVO.setValue(otherValue);
        eventTypeVOS.add(regionEventTypeVO);
    }


    /**
     * 一域一档 类型事件列表
     * @return
     */
    @GetMapping(value = "eventEClassifications")
    @ResponseBody
    public AjaxResult queryEventTypes(){
        List<HkEClassification> hkEClassifications = hkEClassificationService.queryEventEClassifications();
        AjaxResult success = AjaxResult.success(hkEClassifications);
        return success;
    }

    /**
     * 一域一档 类型统计-事件类型
     * @return
     */
    @GetMapping(value = "regionEventTypeByName")
    @ResponseBody
    public AjaxResult queryRegionEventTypeByName(@RequestParam String eventType){
        Map<String,Object> params = new HashMap<>();
        params.put("eventType",eventType);
        params.put("desc","desc");
        params.put("statusArr",new String[]{"1","2","3","4","5","6","7","8","9"});
        List<RegionEventTypeVO> regionEventTypeVOS = statisticsService.queryRegionEventType(params);
        List<RegionEventTypeVO> eventTypeVOS = new ArrayList<>();
        packageRegion(regionEventTypeVOS,eventTypeVOS);
        AjaxResult success = AjaxResult.success(eventTypeVOS);
        return success;
    }


    /**
     * 一域一档 社区效率根据社区查询
     * @return
     */
    @GetMapping(value = "regionEfficiencyByRegionName")
    @ResponseBody
    public AjaxResult regionEfficiencyByRegionName(@RequestParam String type,String regionId){

        //redis-key
        /*String eventType ="";
        if("day".equals(type)){
            eventType = RedisTemplateKey.REGION_EFFICIENCY_COUNT_BY_DAY;//事件趋势每日
        }else if("week".equals(type)){
            eventType = RedisTemplateKey.REGION_EFFICIENCY_COUNT_BY_WEEK;//事件趋势每周
        }else{
            eventType = RedisTemplateKey.REGION_EFFICIENCY_COUNT_BY_MONTH;//事件趋势每月
        }
        Map map = getEventMaps(eventType);*/
        Map<String,Object> map = null;
        if(map ==null ){
            Date date = new Date();
            Map<String,Object> thingParams = EventDate(type,date);
            thingParams.put("regionId",regionId);
            thingParams.put("statusArr",new String[]{"1","2","3","4","5","6","7","8","9"});
            Integer thingCount = statisticsService.queryEventTransferByRegion(thingParams);//事件总数
            thingParams.put("statusArr",new String[]{"1"});//预警
            int inAdvanceCount =  thingCount - statisticsService.queryEventTransferByRegion(thingParams);
            thingParams.put("statusArr",new String[]{"2"});//研判
            int judgeCount = thingCount - statisticsService.queryEventTransferByRegion(thingParams);
            thingParams.put("statusArr",new String[]{"3","4","5"});//正在处理
            int handleCount = thingCount - statisticsService.queryEventTransferByRegion(thingParams);
            thingParams.put("statusArr",new String[]{"6","7","8","9"});//完成
            int achieveCount =  statisticsService.queryEventTransferByRegion(thingParams);

            map = new HashMap();
            List<EventChangeVO> eventChangeVOS = new ArrayList<>();
            EventChangeVO inAdvanceEventChangeVO = new EventChangeVO();
            inAdvanceEventChangeVO.setName("警情数");
            inAdvanceEventChangeVO.setValue(Double.valueOf(inAdvanceCount));
            EventChangeVO judgeEventChangeVO = new EventChangeVO();
            judgeEventChangeVO.setName("判研数");
            judgeEventChangeVO.setValue(Double.valueOf(judgeCount));
            EventChangeVO handleEventChangeVO = new EventChangeVO();
            handleEventChangeVO.setName("处理中");
            handleEventChangeVO.setValue(Double.valueOf(handleCount));
            EventChangeVO achieveEventChangeVO = new EventChangeVO();
            achieveEventChangeVO.setName("已完成");
            achieveEventChangeVO.setValue(Double.valueOf(achieveCount));
            eventChangeVOS.add(inAdvanceEventChangeVO);
            eventChangeVOS.add(judgeEventChangeVO);
            eventChangeVOS.add(handleEventChangeVO);
            eventChangeVOS.add(achieveEventChangeVO);
            map.put("eventChangeVOS",eventChangeVOS);
            //保存至redis
            /*putEventMaps(eventType,map,"");*/
        }
        AjaxResult success = AjaxResult.success(map);
        return success;

    }

    /**
     * 一域一档 事件分析（流转率 处置率）
     * @return
     */
    @GetMapping(value = "regionEventAnalysis")
    @ResponseBody
    public AjaxResult queryRegionEventAnalysis(String type){
        /*String eventType ="";
        if("day".equals(type)){
            eventType = RedisTemplateKey.REGION_EVENT_ANALYSIS_CHANGE_DAY;//事件趋势每日
        }else if("week".equals(type)){
            eventType = RedisTemplateKey.REGION_EVENT_ANALYSIS_CHANGE_WEEK;//事件趋势每周
        }else{
            eventType = RedisTemplateKey.REGION_EVENT_ANALYSIS_CHANGE_MONTH;//事件趋势每月
        }
        Map map = getEventMaps(eventType);*/
        Map<String,Object> map = null;
        if(map ==null ){
            map = new HashMap();
            Date date = new Date();
            //社区下各事件数
            Map<String,Object> thingParams = EventDate(type,date);
            thingParams.put("statusArr",new String[]{"1","2","3","4","5","6","7","8","9"});
            List<RegionEventAnalysisVO> regionEventAnalysisVOS = statisticsService.queryRegionAnalysis(thingParams);
            Map<String,Integer> regionEvent = new HashMap<>();
            for(RegionEventAnalysisVO regionEventAnalysisVO:regionEventAnalysisVOS){
                regionEvent.put(regionEventAnalysisVO.getRegionName(),regionEventAnalysisVO.getEventCount());
            }

            //流转数
            thingParams.put("statusArr",new String[]{"3","4","5","6","7","8","9"});
            List<RegionEventAnalysisVO> changeRegionEventAnalysisVOS = statisticsService.queryRegionAnalysis(thingParams);
            packEventAnalysis(regionEvent,changeRegionEventAnalysisVOS,true);

            //处置数
            thingParams.put("statusArr",new String[]{"6","7","8","9"});
            List<RegionEventAnalysisVO> handleRegionEventAnalysisVOS = statisticsService.queryRegionAnalysis(thingParams);
            packEventAnalysis(regionEvent,handleRegionEventAnalysisVOS,false);

            List<Double> regionEfficiencyCount = changeRegionEventAnalysisVOS.stream().map(RegionEventAnalysisVO::getEventRate).collect(Collectors.toList());//流转率
            List<String> regionEfficiencyName = changeRegionEventAnalysisVOS.stream().map(RegionEventAnalysisVO::getRegionName).collect(Collectors.toList());//社区名称
            List<Double> regionCommonEfficiencyCount = handleRegionEventAnalysisVOS.stream().map(RegionEventAnalysisVO::getEventRate).collect(Collectors.toList());//共治率
            List<String> regionCommonEfficiencyName = handleRegionEventAnalysisVOS.stream().map(RegionEventAnalysisVO::getRegionName).collect(Collectors.toList());
            map.put("regionEfficiencyCount",regionEfficiencyCount);
            map.put("regionEfficiencyName",regionEfficiencyName);
            map.put("regionCommonEfficiencyCount",regionCommonEfficiencyCount);
            map.put("regionCommonEfficiencyName",regionCommonEfficiencyName);
            //保存至redis
            /*putEventMaps(eventType,map,"");*/
        }
        AjaxResult success = AjaxResult.success(map);
        return success;
    }


    public void packEventAnalysis(Map<String,Integer> map,List<RegionEventAnalysisVO> regionEventAnalysisVOS,boolean flag){
        for(RegionEventAnalysisVO regionEventAnalysisVO:regionEventAnalysisVOS){
            Integer deptEventCountSum = map.get(regionEventAnalysisVO.getRegionName());
            Integer deptEventCount = regionEventAnalysisVO.getEventCount();
            if(flag){
                deptEventCount = deptEventCountSum - regionEventAnalysisVO.getEventCount();
            }
            regionEventAnalysisVO.setEventCount(deptEventCount);
            if(deptEventCountSum == null || deptEventCountSum == 0){
                regionEventAnalysisVO.setEventRate(0.00);
                continue;
            }
            regionEventAnalysisVO.setEventRate(new BigDecimal(deptEventCount).divide(new BigDecimal(deptEventCountSum),2,BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal("100")).doubleValue());
        }
    }

    /**
     * 一人一档
     * @param mmap
     * @return
     */
    @GetMapping(value = "Personlist")
    public String PersonList(ModelMap mmap){
        //登录人
        /*mmap.put("user", ShiroUtils.getLoginName());*/
        return prefix + "/Person";
    }

    //一人一档 事件列表
    @GetMapping(value = "PersonEventList")
    public String PersonEventList(ModelMap mmap){
        //登录人
        List<HkEClassification> hkEClassifications = hkEClassificationService.queryEventEClassifications();
        mmap.put("eventClass",hkEClassifications);
        return prefix + "/EventPerson";
    }

    /**
     * 一人一档 人员数，在线率，人均件数，人均时长
     * @return
     */
    @GetMapping(value = "peopleInfo")
    @ResponseBody
    public AjaxResult queryPeopleInfo(@RequestParam String type){
        /*String eventType ="";
        type = "week";
        if("day".equals(type)){
            eventType = RedisTemplateKey.PEOPLE_INFO_KEY_DAY;//事件趋势每日
        }else if("week".equals(type)){
            eventType = RedisTemplateKey.PEOPLE_INFO_KEY_WEEK;//事件趋势每周
        }else{
            eventType = RedisTemplateKey.PEOPLE_INFO_KEY_MONTH;//事件趋势每月
        }
        Map<String,String> map = getEventMaps(eventType);*/
        Map<String,String> map = null;
        if(map == null){
            Date date = new Date();
            map = packagePeople("1",type,date);
            Map<String,String> lastPeopleMap = packagePeople("2",type,date);
            String lastRegionPeopleCount = compareTo(new BigDecimal(map.get("regionPeopleCount")),new BigDecimal(lastPeopleMap.get("regionPeopleCount")));
            String lastWeekSysUsers = compareToRate(new BigDecimal(map.get("accountStatusCount")),new BigDecimal(lastPeopleMap.get("accountStatusCount")));
            String lastWeekEventAvgCountRate = compareToRate(new BigDecimal(map.get("eventAvgCount")),new BigDecimal(lastPeopleMap.get("eventAvgCount")));
            String lastWeekAvgEventTimeRate = compareToRate(new BigDecimal(map.get("avgEventTime")),new BigDecimal(lastPeopleMap.get("avgEventTime")));

            map.put("avgEventTime", DateUtils.subStrDateStringRetainTwo(DateUtil.formatBetween(Long.parseLong(map.get("avgEventTime"))*1000)));
            map.put("regionPeopleCountRate",lastRegionPeopleCount);
            map.put("accountStatusCountRate",lastWeekSysUsers);
            map.put("eventAvgCountRate",lastWeekEventAvgCountRate);
            map.put("avgEventTimeRate",lastWeekAvgEventTimeRate);
            //保存至redis
           /*putEventMaps(eventType,map,"");*/
        }
        AjaxResult success = AjaxResult.success(map);
        return success;
    }

    public Map<String,String> packagePeople(String flag,String type,Date date){
        Map<String,String> peopleParams = new HashMap<>();

        //目前先写用户数 后续在写网格人员数
        /*Map<String,Object> param = new HashMap<>();*/
        /*param.put("postArr",new String[]{"1","2","3"});//查询网格长、网格指导员、专职网格员
        Integer regionPeopleCount = userService.findUserCountByParam(param);*///人员数
        /*Integer regionPeopleCount = sysRanksService.querySysRanksCount(param);*/
        //在线账号查询
        Integer onLineUserCount = queryOnLineUserCount();

        /*Map<String,Object> thingParams = packageEventDate(flag,type);
        thingParams.put("statusArr",new String[]{"6","7","9"});//完成数
        Integer thingCount = statisticsService.countAllByParams(thingParams);*///事件总数
        Map<String,Object> thingParams = packageEventDate(flag,type,date);
        Map<String,Object> params1 = new HashMap<>();
        params1.putAll(thingParams);
        /**可添加筛选条件  筛选符合条件的用户**/
        //params1.put("statusArr",new String[]{"6","7","9"});//完成数
        params1.put("processStatusArr",new String[]{"4","6"});//已处置与中心处置
        /**此处以人的维度 查询人员完成的事件数（若多个人完成同一事件，则按完成事件的人员数计算）**/
        List<PeopleAnalysisVO> peopleAnalysisVOS = statisticsService.queryEventCountByAllRanks(params1);
        Integer eventCount = 0;
        for(PeopleAnalysisVO vo : peopleAnalysisVOS){
            eventCount += vo.getEventCount();
        }
        /**总人数**/
        Integer regionPeopleCount = peopleAnalysisVOS.size();
        String eventAvgCount = divideToAvg(new BigDecimal(regionPeopleCount),new BigDecimal(eventCount));//人均件数
        Map<String,Object> params2 = new HashMap<>();
        params2.putAll(thingParams);
        params2.put("statusArr",new String[]{"6","7","8","9"});//完成数
        //params2.put("processStatusArr",new String[]{"4","6"});//已处置与中心处置
        /**此处计算已完成的事件总数，按事件的维度计算，仅统计状态为完成的事件的 处置耗时**/
        Long aLong = statisticsService.queryProcessTimeByParam(params2);//已完成事件的总耗时
        aLong = aLong == null?0:aLong;
        /*Map<String,Object> avgTimeParams = packageEventDate(flag,type);
        //完成事件总数
        List<HkEventInfo> hkEventInfos = statisticsService.queryEventByAlterStatus(avgTimeParams);
        BigDecimal timeCount = new BigDecimal(0.00);//总时长
        //人均时长 完成时间 - 创建时间 / 总时间数
        for (HkEventInfo hkEventInfo:hkEventInfos) {
            //小时差
            if(hkEventInfo.getUpdateTime() == null){
                continue;
            }
            BigDecimal hour = new BigDecimal(DateUtils.getHour(hkEventInfo.getUpdateTime(),hkEventInfo.getCreateTime())).setScale(2, BigDecimal.ROUND_HALF_UP);
            timeCount = timeCount.add(hour);
        }*/
        Long avgEventTime = 0L;
        if(aLong > 0){
            avgEventTime = new BigDecimal(aLong).divide(new BigDecimal(regionPeopleCount),2, BigDecimal.ROUND_HALF_UP).longValue();//人均时长
        }
        peopleParams.put("regionPeopleCount",String.valueOf(regionPeopleCount));
        peopleParams.put("accountStatusCount",String.valueOf(onLineUserCount));
        peopleParams.put("eventAvgCount",eventAvgCount);
        peopleParams.put("avgEventTime",String.valueOf(avgEventTime));
        return peopleParams;
    }




    /**
     * 一人一档 处置效率 与一事一档 事件趋势共用
     * @return
     */
    @GetMapping(value = "peopleDisposalEfficiency")
    @ResponseBody
    public AjaxResult queryPeopleDisposalEfficiency(@RequestParam String type) throws ParseException {
        /*String eventType ="";
        if("day".equals(type)){
            eventType = RedisTemplateKey.PEOPLE_DISPOSAL_EFFICIENCY_BY_DAY;//事件趋势每日
        }else if("week".equals(type)){
            eventType = RedisTemplateKey.PEOPLE_DISPOSAL_EFFICIENCY_BY_WEEK;//事件趋势每周
        }else{
            eventType = RedisTemplateKey.PEOPLE_DISPOSAL_EFFICIENCY_BY_MONTH;//事件趋势每月
        }
        Map map = getEventMaps(eventType);*/
        Map<String,Object> map = null;
        if(map == null){
            Date date = new Date();
            //查询日期范围Map
            Map<String,Object> params = EventDate(type,date);
            params.put("statusArr",new String[]{"6","7","8","9"});//完成数
            //获取时间段
            List<TimeField> times = new TimeUtil().getTime(type);
            List<String> eventTrendDate =  times.stream().map(TimeField::getDate).collect(Collectors.toList());//街道名称

            //店外违规事件 //无店外违规事件
            List<Integer> eventTrendCount = new ArrayList<>();

            //街面违规事件
            List<EventTrendVO> eventPlaceTypeTrends = statisticsService.queryEventTrends(params);
            //根据type区分返回前台所需数据格式，例：day：00-02 02-04，两小时为一界限，week：以一天为界限，month：以7天为界限
            List<Integer> eventPlaceTypeTrendCount = DataFormat(eventPlaceTypeTrends,type,times);
            //response
            map = new HashMap();
            map.put("eventTrend",eventTrendCount);
            map.put("eventPlaceTypeTrends",eventPlaceTypeTrendCount);
            map.put("eventTrendDate",eventTrendDate);
            //保存至redis
            /*putEvents(eventType, map,type);*/
        }
        AjaxResult success = AjaxResult.success(map);
        return success;
    }

    /**
     * 一人一档 处置分析
     * @return
     */
    @GetMapping(value = "peopleDisposalAnalysis")
    @ResponseBody
    public AjaxResult queryPeopleDisposalAnalysis(@RequestParam String type){
        /*String eventType ="";
        if("day".equals(type)){
            eventType = RedisTemplateKey.PEOPLE_DISPOSAL_ANALYSIS_BY_DAY;//事件趋势每日
        }else if("week".equals(type)){
            eventType = RedisTemplateKey.PEOPLE_DISPOSAL_ANALYSIS_BY_WEEK;//事件趋势每周
        }else{
            eventType = RedisTemplateKey.PEOPLE_DISPOSAL_ANALYSIS_BY_MONTH;//事件趋势每月
        }
        Map map = getEventMaps(eventType);*/
        Map<String,Object> map = null;
        if(map == null){
            Date date = new Date();
            Map<String,Object> params = EventDate(type,date);
            /**可添加筛选条件  筛选符合条件的用户**/
            //params.put("statusArr",new String[]{"6","7","9"});//完成数
            params.put("processStatusArr",new String[]{"4","6"});//已处置与中心处置
            params.put("limit","10");
            List<PeopleAnalysisVO> peopleAnalysisVOS = statisticsService.queryEventCountByAllRanks(params);
            //处置分析
            /*List<PeopleDisposalAnalysisVO>  peopleDisposalAnalysisVOS = sysRanksService.queryPeopleDisposalAnalysis(params);*/
            List<Integer> eventCounts = peopleAnalysisVOS.stream().map(PeopleAnalysisVO::getEventCount).collect(Collectors.toList());//事件数
            List<String>  userNames = peopleAnalysisVOS.stream().map(PeopleAnalysisVO::getUserName).collect(Collectors.toList());//用户昵称
            map = new HashMap();
            map.put("eventCounts",eventCounts);
            map.put("userNames",userNames);
            //保存至redis
            /*putEvents(eventType,map,"");*/
        }
        return AjaxResult.success(map);
    }

    /**
     * 一人一档 效率管理
     * 如何计算？
     * @return
     */
    @GetMapping(value = "peopleEfficiency")
    @ResponseBody
    public AjaxResult queryPeopleEfficiency(@RequestParam(required = true) String type){
        /*String eventType ="";
        if("day".equals(type)){
            eventType = RedisTemplateKey.PEOPLE_EFFICIENCY_COUNT_BY_DAY;//事件趋势每日
        }else if("week".equals(type)){
            eventType = RedisTemplateKey.PEOPLE_EFFICIENCY_COUNT_BY_WEEK;//事件趋势每周
        }else{
            eventType = RedisTemplateKey.PEOPLE_EFFICIENCY_COUNT_BY_MONTH;//事件趋势每月
        }
        List<PeopleDisposalAnalysisVO> peopleEfficiencyVOS = getEvents(eventType);*/
        List<PeopleDisposalAnalysisVO> peopleEfficiencyVOS = new ArrayList<>();
        if(peopleEfficiencyVOS ==null || peopleEfficiencyVOS.size() <1){
            Date date = new Date();
            Map<String,Object> params = EventDate(type,date);
            //各社区工作人员事件数
            /*peopleEfficiencyVOS = sysRanksService.queryPeopleDisposalAnalysis(params);*/
            /*peopleEfficiencyVOS = sysUserService.queryPeopleDisposalAnalysis(params);*/
            peopleEfficiencyVOS = statisticsService.queryPeopleDisposalAnalysis(params);
            //保存至redis
            /*putEvents(eventType,peopleEfficiencyVOS,"");*/
        }
        return AjaxResult.success(peopleEfficiencyVOS);
    }

    /**
     * 一人一档 队伍统计
     * @param type
     * @return
     */
    @GetMapping(value = "peopleType")
    @ResponseBody
    public AjaxResult queryPeopleType(@RequestParam String type){
        /*String eventType ="";
        if("day".equals(type)){
            eventType = RedisTemplateKey.PEOPLE_TYPE_COUNT_BY_DAY;//事件趋势每日
        }else if("week".equals(type)){
            eventType = RedisTemplateKey.PEOPLE_TYPE_COUNT_BY_WEEK;//事件趋势每周
        }else{
            eventType = RedisTemplateKey.PEOPLE_TYPE_COUNT_BY_MONTH;//事件趋势每月
        }
        List<PeopleTypeVO> list = getEvents(eventType);*/
        List<PeopleTypeVO> list = new ArrayList<>();
        if(list == null || list.size() < 1){
            list = new ArrayList<>();
            Map<String,Object> params = new HashMap<>();
            List<SysPost> postList = postService.selectPostList(new SysPost());
            for (SysPost post:postList) {
                params.put("postArr",new Long[]{post.getPostId()});
                Integer count = userService.findUserCountByParam(params);
                PeopleTypeVO peopleTypeVO = new PeopleTypeVO();
                Integer peopleOnLines = queryOnLineUserCount();//在线人数
                peopleTypeVO.setName(post.getPostName());
                peopleTypeVO.setPeopleOnLineCount(peopleOnLines);
                peopleTypeVO.setPeopleOutLineCount(count-peopleOnLines);
                peopleTypeVO.setValue(count);
                list.add(peopleTypeVO);
            }
            //保存至redis
            /*putEvents(eventType,list,"");*/
        }
        AjaxResult success = AjaxResult.success(list);
        return success;
    }

    /**
     * 一人一档 耗时检测
     *  @param station 队伍人员身份类型 岗位（111 网格员，222城管，333共治力量）
     * @return
     */
    @GetMapping(value = "peopleTime")
    @ResponseBody
    public AjaxResult queryPeopleTime(@RequestParam String station){
        /*String eventType = "";
        if("1".equals(station)){
            eventType = RedisTemplateKey.PEOPLE_TIME_COUNT_BY_MAN;
        }else if("3".equals(station)){
            eventType = RedisTemplateKey.PEOPLE_TIME_COUNT_COMMON;
        }else{
            eventType = RedisTemplateKey.PEOPLE_TIME_COUNT_BY_MANGE;
        }
        Map map = getEventMaps(eventType);*/
        Map<String,Object> map = null;
        if(map == null){
            //网格人员事件数
            Map<String,Object> params = new HashMap<>();
            /*params.put("station",station);//岗位 1 网格长 2 网格指导员 3专职网格员
            params.put("accountStatus","0");//账号状态 0：正常 1：停用
            params.put("trendWeekMonday", DateFormatUtils.format(DateUtils.getThisWeekMonday(),DateUtils.YYYY_MM_DD));//周一日期
            *//*List<PeopleTimeVO> peopleTimeVOS = sysRanksService.queryPeopleTime(params);*//*
            List<PeopleTimeVO> peopleTimeVOS = sysUserService.queryPeopleTime(params);*/


            /**可添加筛选条件  筛选符合条件的用户**/
            //params.put("statusArr",new String[]{"6","7","9"});//完成数
            params.put("processStatusArr",new String[]{"4","6"});//已处置与中心处置
            if("111".equals(station)){//网格员
                params.put("postArr",new String[]{"1","2","3"});//网格长，网格指导员，网格员
            }else if("222".equals(station)){//城管
                params.put("postArr",new String[]{"4"});//城管
            }else if("333".equals(station)){//共治力量
                params.put("postArr",new String[]{"5"});//共治力量
            }
//            params.put("limit","10");
            List<PeopleAnalysisVO> peopleAnalysisVOS = statisticsService.queryEventCountByParam(params);
            List<Double> responseTimes = new ArrayList<>();
            List<String> names = new ArrayList<>();
            for(PeopleAnalysisVO vo : peopleAnalysisVOS){
                names.add(vo.getUserName());
                if(vo.getEventCount() > 0){
                    params.put("userId",vo.getUserId());
                    Long aLong = statisticsService.queryProcessTimeByParam(params);//查询人员处置事件的耗时（从事件的指派到事件完结时间）
                    aLong = aLong == null?0:aLong;
                    responseTimes.add(DateUtils.getHourByTime1(aLong/vo.getEventCount()));
                }else{
                    responseTimes.add(0.00);
                }
            }
            map = new HashMap();
            map.put("times",responseTimes);
            map.put("names",names);
            //保存至redis
            /*putEventMaps(eventType,map,"");*/
        }
        //签收事件 / 总事件  共治事件/总事件
        AjaxResult success = AjaxResult.success(map);
        return success;
    }

    /**
     * 一期一档
     * @param mmap
     * @return
     */
    @GetMapping(value = "Stagelist")
    public String StageList(ModelMap mmap){
        //登录人
        return prefix + "/Stage";
    }


    //一期一档 事件列表
    @GetMapping(value = "StageEventList")
    public String StageEventList(ModelMap mmap){
        //登录人
        List<HkEClassification> hkEClassifications = hkEClassificationService.queryEventEClassifications();
        mmap.put("eventClass",hkEClassifications);
        return prefix + "/EventStage";
    }

    /**
     * 一期一档 周期天数
     * @return
     */
    @GetMapping(value = "stageCount")
    @ResponseBody
    public AjaxResult queryStageCount(@RequestParam String type){
        String eventType = "";
        Integer stageCount = 0;//周期数
        Date date = new Date();
        if("day".equals(type)){
            stageCount = 1;
        }else if("week".equals(type)){
            eventType = RedisTemplateKey.STAGE_COUNT_WEEK;//事件趋势每周
            stageCount = 7;
        }else if("month".equals(type)){
            eventType = RedisTemplateKey.STAGE_COUNT_MONTH;//事件趋势每月
            //calendar.setTime(DateUtils.getThisMonthEndDay());
            stageCount = Integer.parseInt(DateUtil.betweenDay(DateUtil.offsetMonth(date,-1),date,false)+"");
        }else{
            stageCount = 365;
            try{
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date parse = sdf.parse(DateUtils.getNearlyYear(date, -1));
                stageCount = Integer.parseInt(DateUtil.betweenDay(parse,date,false)+"");
            }catch(Exception ex){
                logger.info("==================日期格式转换错误==================");
                ex.printStackTrace();
            }
        }
        //获取事件趋势数据集 redis
        /*Map data = getEventMaps(eventType);*/
        Map<String,Object> data = null;
        if(data == null){

            //总人员数
            Map<String,Object> param = new HashMap<>();
            Integer peopleCount = sysRanksService.querySysRanksCount(param);
            //辖区数
            param.put("level",2);
            int stageJurisdictionCount = sysRegionService.queryRegionCountByParam(param);
            Map<String,Object> thingParams = EventDate(type,date);
            thingParams.put("statusArr",new String[]{"1","2","3","4","5","6","7","8","9"});
            Integer thingCount = statisticsService.countAllByParams(thingParams);//事件总数
            //事件数
            Map<String,Object> params = EventDate(type,date);
            params.put("statusArr",new String[]{"1","2","3","4","5","6","7","8","9"});
            int stageEventCount = thingCount - statisticsService.countAllByParams(params);

            //辖区数
            int LastStageJurisdictionCount = 0;

            /**同期事件总数**/
            Map<String,Object> lastThingParams = lastEventDate(type,date);
            lastThingParams.put("statusArr",new String[]{"1","2","3","4","5","6","7","8","9"});
            Integer LastThingCount = statisticsService.countAllByParams(lastThingParams);//事件总数

            //事件数
            int LastStageEventCount = LastThingCount - thingCount;


            data = new HashMap();
            data.put("stageCount",stageCount);
            data.put("peopleCount",peopleCount);
            data.put("stageJurisdictionCount",stageJurisdictionCount);
            data.put("stageEventCount",stageEventCount);
            data.put("peopleCountRate",compareTo( new BigDecimal(peopleCount),new BigDecimal(peopleCount)));
            data.put("stageJurisdictionCountRate",compareTo( new BigDecimal(stageJurisdictionCount),new BigDecimal(LastStageJurisdictionCount)));
            data.put("stageEventCountRate",compareTo( new BigDecimal(stageEventCount),new BigDecimal(LastStageEventCount)));
            //保存至redis
            /*putEvents(eventType, data,type);*/
        }
        AjaxResult success = AjaxResult.success(data);
        return success;
    }

    /**
     * 一期一档 暂时展示
     * @param vo 本日: day 本周 week 本月 month
     * @return
     */
    @RequestMapping(value = "eventRegionStage",method = RequestMethod.GET)
    @ResponseBody
    public AjaxResult eventRegionTest(HkEventThingParamVO vo){
        //redis-key
        String type = vo.getType();
        /*String eventType ="";
        if("day".equals(type)){
            eventType = RedisTemplateKey.THING_REGION_BY_DAY;//事件趋势每日
        }else if("week".equals(type)){
            eventType = RedisTemplateKey.THING_REGION_BY_WEEK;//事件趋势每周
        }else{
            eventType = RedisTemplateKey.THING_REGION_BY_MONTH;//事件趋势每月
        }
        //获取社区检测数据集 redis
        Map data = getEventMaps(eventType);*/
        Map<String,Object> data = null;
        if(data == null){
            data = new HashMap();
            Date date = new Date();
            //查询日期范围Map
            Map<String,Object> params = EventDate(type,date);
            params.put("desc","desc");
            //街面违规事件
            List<EventInspectVO>  eventInspectVOS = statisticsService.queryEventRegion1(params);
            List<Integer> eventRegionCount = eventInspectVOS.stream().map(EventInspectVO::getEventCount).collect(Collectors.toList());//街面违规数量
            List<Integer> eventPlaceTypeRegionCount = new ArrayList<>();
            List<String> regionName = eventInspectVOS.stream().map(EventInspectVO::getRegionName).collect(Collectors.toList());//街道名称
            data.put("eventRegionCount",eventRegionCount);
            data.put("eventPlaceTypeRegionCount",eventPlaceTypeRegionCount);
            data.put("regionName",regionName);
            //保存至redis
            /*putEventMaps(type, data,type);*/
        }
        AjaxResult success = AjaxResult.success(data);
        return success;
    }

    /**
     * 一期一档 区域检测
     * @param type
     * @return
     */
    @GetMapping(value = "stageRegionEfficiency")
    @ResponseBody
    public AjaxResult queryStageRegionEfficiency(String type){
        /*String eventType ="";
        if("day".equals(type)){
            eventType = RedisTemplateKey.STAGE_REGION_EFFICIENCY_COUNT_DAY;//事件趋势每日
        }else if("week".equals(type)){
            eventType = RedisTemplateKey.STAGE_REGION_EFFICIENCY_COUNT_WEEK;//事件趋势每周
        }else{
            eventType = RedisTemplateKey.STAGE_REGION_EFFICIENCY_COUNT_MONTH;//事件趋势每月
        }
        Map map = getEventMaps(eventType);*/
        Map<String,Object> map = null;
        if(map ==null ){
            map = new HashMap();
            Date date = new Date();
            //社区下各事件数
            Map<String,Object> thingParams = EventDate(type,date);
            thingParams.put("statusArr",new String[]{"1","2","3","4","5","6","7","8","9"});
            List<RegionEventAnalysisVO> regionEventAnalysisVOS = statisticsService.queryRegionAnalysis(thingParams);
            System.out.println(JSONObject.toJSONString(regionEventAnalysisVOS));
            Map<String,Integer> regionEvent = new HashMap<>();
            for(RegionEventAnalysisVO regionEventAnalysisVO:regionEventAnalysisVOS){
                regionEvent.put(regionEventAnalysisVO.getRegionName(),regionEventAnalysisVO.getEventCount());
            }

            //违规处置数
            Map<String,Object> handleStatusParams = EventDate(type,date);
            handleStatusParams.put("statusArr",new String[]{"6","7","8","9"});
            List<RegionEventAnalysisVO> handleRegionEventAnalysisVOS = statisticsService.queryRegionAnalysis(handleStatusParams);
            packStageRegionEfficiency(regionEvent,handleRegionEventAnalysisVOS,false);

            List<Integer> regionEfficiencyCount = regionEventAnalysisVOS.stream().map(RegionEventAnalysisVO::getEventCount).collect(Collectors.toList());//流转率
            List<String> regionEfficiencyName = regionEventAnalysisVOS.stream().map(RegionEventAnalysisVO::getRegionName).collect(Collectors.toList());//社区名称
            List<Integer> regionCommonEfficiencyCount = handleRegionEventAnalysisVOS.stream().map(RegionEventAnalysisVO::getEventCount).collect(Collectors.toList());//共治率
            List<String> regionCommonEfficiencyName = handleRegionEventAnalysisVOS.stream().map(RegionEventAnalysisVO::getRegionName).collect(Collectors.toList());
            map.put("regionEfficiencyCount",regionEfficiencyCount);
            map.put("regionEfficiencyName",regionEfficiencyName);
            map.put("regionCommonEfficiencyCount",regionCommonEfficiencyCount);
            map.put("regionCommonEfficiencyName",regionCommonEfficiencyName);
            //保存至redis
            /*putEventMaps(eventType,map,"");*/
        }
        AjaxResult success = AjaxResult.success(map);
        return success;
    }

    public void packStageRegionEfficiency(Map<String,Integer> map,List<RegionEventAnalysisVO> regionEventAnalysisVOS,boolean flag){
        for(RegionEventAnalysisVO regionEventAnalysisVO:regionEventAnalysisVOS){
            Integer deptEventCountSum = map.get(regionEventAnalysisVO.getRegionName());
            Integer deptEventCount = regionEventAnalysisVO.getEventCount();
            if(flag){
                deptEventCount = deptEventCountSum - regionEventAnalysisVO.getEventCount();
            }
            regionEventAnalysisVO.setEventCount(deptEventCount);
        }
    }

    /**
     * 一期一档 社区负荷
     * @return
     */
    @GetMapping(value = "stageRegionLoad")
    @ResponseBody
    public AjaxResult stageRegionLoad(String type){
        /*String eventType ="";
        if("day".equals(type)){
            eventType = RedisTemplateKey.STAGE_ANALYSIS_COUNT_DAY;//事件趋势每日
        }else if("week".equals(type)){
            eventType = RedisTemplateKey.STAGE_ANALYSIS_COUNT_WEEK;//事件趋势每周
        }else{
            eventType = RedisTemplateKey.STAGE_ANALYSIS_COUNT_MONTH;//事件趋势每月
        }
        Map map = getEventMaps(eventType);*/
        Map<String,Object> map = null;
        if(map == null){
            map = new HashMap();
            Date date = new Date();
            //各社区下各事件数
            Map<String,Object> thingParams = EventDate(type,date);
            thingParams.put("statusArr",new String[]{"1","2","3","4","5","6","7","8","9"});
            List<RegionEventAnalysisVO> regionEventAnalysisVOS = statisticsService.queryRegionAnalysis(thingParams);
            Map<String,Integer> regionEvent = new HashMap<>();
            for(RegionEventAnalysisVO regionEventAnalysisVO:regionEventAnalysisVOS){
                regionEvent.put(regionEventAnalysisVO.getRegionName(),regionEventAnalysisVO.getEventCount());
            }
        }
        return AjaxResult.success(map);
    }


    private Map<String,Object> packageEventDate(String flag,String type,Date date){
        if("1".equals(flag)){
            return EventDate(type,date);
        }else{
            return lastEventDate(type,date);
        }
    }

    /**
     * 组装查询日期范围
     * @param type
     * @return
     */
    public Map<String,Object> EventDate(String type,Date date){
        Map<String,Object> map = new HashMap<>();
        if("day".equals(type)){
            //当天日期
            //map.put("currentDate",DateFormatUtils.format(new Date(),"yyyy-MM-dd"));
            //近一天
            map.put("nearlyADayBegin",DateUtil.offsetDay(date, -1).toString());
        }else if("week".equals(type)){
            //本周一
            //map.put("trendWeekMonday",DateFormatUtils.format(DateUtils.getThisWeekMonday(),"yyyy-MM-dd"));
            //近一周
            map.put("nearlyAWeekBegin",DateUtil.offsetWeek(date, -1).toString());
        }else if("month".equals(type)){
            //本月一号
            //map.put("trendMonthMonday",DateFormatUtils.format(DateUtils.getThisMonthMonday(),"yyyy-MM-dd"));
            //近一月
            map.put("nearlyAMonthBegin",DateUtil.offsetMonth(date, -1).toString());
        }else if("year".equals(type)){
            //近一年
            map.put("nearlyAYearBegin",DateUtils.getNearlyYear(date,-1));
        }
        return map;
    }

    /**
     * 查询日期范围
     * @param type
     * @return
     */
    public Map<String,Object> lastEventDate(String type,Date date){
        Map<String,Object> map = new HashMap<>();
        if("day".equals(type)){
            //昨天
            //map.put("currentDate",DateFormatUtils.format(DateUtils.getTwentyFour(),"yyyy-MM-dd"));
            map.put("nearlyADayBegin",DateUtil.offsetDay(date, -2).toString());
            map.put("nearlyADayEnd",DateUtil.offsetDay(date, -1).toString());
        }else if("week".equals(type)){
            //map.put("thisWeekMonday",DateFormatUtils.format(DateUtils.getThisWeekMonday(),DateUtils.YYYY_MM_DD));//本周一
            //map.put("lastWeekDay",DateFormatUtils.format(DateUtils.getLastWeekMonday(),DateUtils.YYYY_MM_DD));//上周一
            map.put("nearlyAWeekBegin",DateUtil.offsetWeek(date, -2).toString());
            map.put("nearlyAWeekEnd",DateUtil.offsetWeek(date, -1).toString());
        }else if("month".equals(type)){
            //map.put("thisMonthFirstDay",DateFormatUtils.format(DateUtils.getThisMonthMonday(),"yyyy-MM-dd"));//本月一号
            //map.put("lastMonthFirstDay",DateFormatUtils.format(DateUtils.getLastMonthFirstDay(),"yyyy-MM-dd"));//上个月一号
            map.put("nearlyAMonthBegin",DateUtil.offsetMonth(date, -2).toString());
            map.put("nearlyAMonthEnd",DateUtil.offsetMonth(date, -1).toString());
        }else{
            //近一年
            map.put("nearlyAYearBegin",DateUtils.getNearlyYear(date,-1));
            map.put("nearlyAYearEnd",DateUtils.getNearlyYear(date,-1));
        }
        return map;
    }



    /**
     * 通过事件KEY 获取事件数量
     * @param thingKey 事件key
     * @return
     */
    private String getEventCounts(String thingKey){
        ValueOperations<String,String> operations = redisTemplate.opsForValue();
        return operations.get(thingKey);
    }

    /**
     * 通过事件key 插入事件数量
     * @param thingKey 事件key
     * @param thingValue 事件value
     * @param hour
     */
    private void putEventCount(String thingKey,String thingValue,int hour){
        ValueOperations<String,String> operations = redisTemplate.opsForValue();
        operations.set(thingKey,thingValue);
        redisTemplate.expire(thingKey,hour, TimeUnit.HOURS);
    }

    /**
     * 通过事件KEY 插入maps类型事件
     * @param thingKey 事件key 事件value
     */
    private Map<String,String> getEventMaps(String thingKey){
        ValueOperations<String,Map<String,String>> operations = redisTemplate.opsForValue();
        return operations.get(thingKey);
    }

    /**
     * 通过事件KEY 插入maps类型事件
     * @param thingKey 事件key 事件value
     * @param thingValue 事件value
     * @param type 通过type来区分是否设置过期时间
     */
    private void putEventMaps(String thingKey,Map<String,String> thingValue,String type){
        ValueOperations<String,Map<String,String>> operations = redisTemplate.opsForValue();
        operations.set(thingKey,thingValue);
        redisTemplate.expire(thingKey,2, TimeUnit.HOURS);
    }

    /**
     * 通过事件KEY 获取事件列表
     * @param thingKey 事件key
     * @return
     */
    private  <T> List<T>  getEvents(String thingKey){
        ValueOperations<String,List<T>> operations = redisTemplate.opsForValue();
        return operations.get(thingKey);
    }

    /**
     * 通过事件KEY 插入事件列表
     * @param thingKey 事件key
     * @param clazz 插入事件List
     * @param type  通过type来区分是否设置过期时间
     * @param <T>
     */
    private  <T> void  putEvents(String thingKey,T clazz,String type){
        ValueOperations<String,T> operations = redisTemplate.opsForValue();
        operations.set(thingKey,clazz);
        //设置redis过期时间为2小时
        if("day".equals(type)){
            redisTemplate.expire(thingKey,2, TimeUnit.HOURS);
        }
    }

    public int queryOnLineUserCount(){
        Set keys = redisTemplate.keys(jwtConfigProperties.getCachePrefix() + "*");
        return keys.size();
    }

    /**
     * 组装前台所需数据格式 例：day：00-02 02-04，两小时为一界限，week：以一天为界限，month：以7天为界限
     * @param eventTrendVOS 数据集
     * @param type 数据类别区分标识
     * @return
     */
    private  List<Integer>  DataFormat(List<EventTrendVO> eventTrendVOS, String type,List<TimeField> timeFields) throws ParseException {
        for(EventTrendVO eventTrendVO : eventTrendVOS){
            for(TimeField timeField:timeFields){
                Integer count = timeField.getCount();
                if(count == null){
                    count = 0;
                    timeField.setCount(count);
                }
                String format = timeField.getFormat();
                Date startDate =  DateUtils.parseDate(timeField.getStartTime(),format);
                Date endDate = DateUtils.parseDate(timeField.getEndTime(),format);
                String DateStr = DateUtils.parseDateToStr(format,eventTrendVO.getCreateTime());
                if(startDate.getTime()<= DateUtils.parseDate(DateStr,format).getTime() && endDate.getTime()>=DateUtils.parseDate(DateStr,format).getTime()){
                    timeField.setCount(++count);
                }
            }
        }
        return timeFields.stream().map(TimeField::getCount).collect(Collectors.toList());//街面违规数量
    }

}
