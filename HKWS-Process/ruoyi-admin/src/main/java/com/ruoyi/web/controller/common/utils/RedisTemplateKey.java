package com.ruoyi.web.controller.common.utils;

/**
 * 档案库redis-key存放
 * @author zjf
 */
public class RedisTemplateKey {

    //一事一档 事件总数-每日
    public static String THING_COUNT_KEY_DAY = "thingCountKeyDay";

    //一事一档 事件总数-每周
    public static String THING_COUNT_KEY_WEEK = "thingCountKeyWeek";

    //一事一档 事件总数-每月
    public static String THING_COUNT_KEY_MONTH = "thingCountKeyMonth";


    //一事一档 事件趋势-本日
    public static String THING_EVENT_TREND_BY_DAY = "thingEventTrendDayKey";

    //一事一档 事件趋势-本周
    public static String THING_EVENT_TREND_BY_WEEK = "thingEventTrendWeekKey";

    //一事一档 事件趋势-本月
    public static String THING_EVENT_TREND_BY_MONTH = "thingEventTrendMonthKey";

    //请选择日期范围

    //一事一档 社区检测-本日
    public static String THING_REGION_BY_DAY = "thingRegionDayKey";

    //一事一档 社区检测-本周
    public static String THING_REGION_BY_WEEK = "thingRegionWeekKey";

    //一事一档 社区检测-本月
    public static String THING_REGION_BY_MONTH = "thingRegionMonthKey";

    //一事一档 类型统计-本日
    public static String THING_EVENT_TYPE_COUNT_BY_DAY ="thingEventTypeCountDayKey";

    //一事一档 类型统计-本周
    public static String THING_EVENT_TYPE_COUNT_BY_WEEK ="thingEventTypeCountWeekKey";

    //一事一档 类型统计-本月
    public static String THING_EVENT_TYPE_COUNT_BY_MONTH ="thingEventTypeCountMonthKey";

    //请选择社区

    //一事一档 事件分析-本日
    public static String THING_EVENT_ANALYSIS_BY_DAY ="thingEventAnalysisDayKey";

    //一事一档 事件分析-本周
    public static String THING_EVENT_ANALYSIS_BY_WEEK ="thingEventAnalysisWeekKey";

    //一事一档 事件分析-本月
    public static String THING_EVENT_ANALYSIS_BY_MONTH ="thingEventAnalysisMonthKey";

    //一事一档 赋能流转-本日
    public static String THING_EVENT_CHANGE_BY_DAY ="thingEventChangeDayKey";

    //一事一档 赋能流转-本周
    public static String THING_EVENT_CHANGE_BY_WEEK = "thingEventCountWeekKey";

    //一事一档 赋能流转-本月
    public static String THING_EVENT_CHANGE_BY_MONTH= "thingEventChangeMonthKey";



    //一域一档 社区总数
    public static String REGION_COUNT_DAY ="regionCountKeyDay";

    //一域一档 社区总数
    public static String REGION_COUNT_WEEK ="regionCountKeyWeek";

    //一域一档 社区总数
    public static String REGION_COUNT_MONTH ="regionCountKeyMonth";

    //一域一档 社区平均件数
    public static String REGION_EVENT_AVG_COUNT = "regionEventAvgCountKey";

    //一域一档 社区人数
    public static String REGION_PEOPLE_COUNT = "regionPeopleCountKey";

    //一域一档 社区负荷
    public static String REGION_LOAD_COUNT = "regionLoadCountKey";

    //一域一档 社区总数
    public static String LAST_WEEK_REGION_COUNT ="lastWeekRegionCountKey";

    //一域一档 社区平均件数
    public static String LAST_WEEK_REGION_EVENT_AVG_COUNT = "lastWeekRegionEventAvgCountKey";

    //一域一档 社区人数
    public static String LAST_WEEK_REGION_PEOPLE_COUNT = "lastWeekRegionPeopleCountKey";

    //一域一档 社区负荷
    public static String LAST_WEEK_REGION_LOAD_COUNT = "lastWeekRegionLoadCountKey";

    //一域一档 赋能流转-本日
    public static String REGION_CHANGE_RATE_BY_DAY = "regionChangeRateDayKey";

    //一域一档 赋能流转-本周
    public static String REGION_CHANGE_RATE_BY_WEEK = "regionChangeRateWeekKey";

    //一域一档 赋能流转-本月
    public static String REGION_CHANGE_RATE_BY_MONTH = "regionChangeRateMonthKey";

    //一域一档 社区负荷-本日
    public static String REGION_LOAD_BY_DAY ="regionLoadDayKey";

    //一域一档 社区负荷-本周
    public static String REGION_LOAD_BY_WEEK ="regionLoadWeekKey";

    //一域一档 社区负荷-本月
    public static String REGION_LOAD_BY_MONTH ="regionLoadMonthKey";

    //一域一档 类型统计-本日
    public static String REGION_EVENT_TYPE_COUNT_BY_DAY = "regionEventTypeCountDayKey";

    //一域一档 类型统计-本周
    public static String REGION_EVENT_TYPE_COUNT_BY_WEEK = "regionEventTypeCountWeekKey";

    //一域一档 类型统计-本月
    public static String REGION_EVENT_TYPE_COUNT_BY_MONTH = "regionEventTypeCountMonthKey";

    //一域一档 社区效率-本日
    public static String REGION_EFFICIENCY_COUNT_BY_DAY ="regionEfficiencyCountDayKey";

    //一域一档 社区效率-本周
    public static String REGION_EFFICIENCY_COUNT_BY_WEEK ="regionEfficiencyCountWeekKey";

    //一域一档 社区效率-本月
    public static String REGION_EFFICIENCY_COUNT_BY_MONTH ="regionEfficiencyCountMonthKey";

    //一域一档 事件分析
    public static String REGION_EVENT_ANALYSIS_CHANGE = "regionEventAnalysisChangeKey";


    //一域一档 事件分析
    public static String REGION_EVENT_ANALYSIS_CHANGE_DAY = "regionEventAnalysisChangeKeyDay";

    //一域一档 事件分析
    public static String REGION_EVENT_ANALYSIS_CHANGE_WEEK = "regionEventAnalysisChangeKeyWeek";

    //一域一档 事件分析
    public static String REGION_EVENT_ANALYSIS_CHANGE_MONTH = "regionEventAnalysisChangeKeyMonth";


    //一域一档 事件分析-共治率
   // public static String REGION_EVENT_ANALYSIS_COMMON = "regionEventAnalysisCommonKey";

    //一人一档 人员数 在线率 人均件数 人均时长
    public static String PEOPLE_INFO_KEY = "peopleInfoKey";



    //一人一档 人员数 在线率 人均件数 人均时长
    public static String PEOPLE_INFO_KEY_DAY = "peopleInfoKeyDay";

    //一人一档 人员数 在线率 人均件数 人均时长
    public static String PEOPLE_INFO_KEY_WEEK = "peopleInfoKeyWeek";

    //一人一档 人员数 在线率 人均件数 人均时长
    public static String PEOPLE_INFO_KEY_MONTH = "peopleInfoKeyMonth";

    //一人一档 处置效率
    public static String PEOPLE_DISPOSAL_EFFICIENCY_BY_DAY ="peopleDisposalEfficiencyByDay";

    public static String PEOPLE_DISPOSAL_EFFICIENCY_BY_WEEK ="peopleDisposalEfficiencyByWeek";

    public static String PEOPLE_DISPOSAL_EFFICIENCY_BY_MONTH ="peopleDisposalEfficiencyByMonth";

    //一人一档 处置分析-本日
    public static String PEOPLE_DISPOSAL_ANALYSIS_BY_DAY = "peopleDisposalAnalysisDayKey";

    //一人一档 处置分析-本周
    public static String PEOPLE_DISPOSAL_ANALYSIS_BY_WEEK = "peopleDisposalAnalysisWWeekKey";

    //一人一档 处置分析-本月
    public static String PEOPLE_DISPOSAL_ANALYSIS_BY_MONTH = "peopleDisposalAnalysisMonthKey";

    //一人一档 效率管理-本日
    public static String PEOPLE_EFFICIENCY_COUNT_BY_DAY = "peopleEfficiencyCountDayKey";

    //一人一档 效率管理-本周
    public static String PEOPLE_EFFICIENCY_COUNT_BY_WEEK = "peopleEfficiencyCountWeekKey";

    //一人一档 效率管理-本月
    public static String PEOPLE_EFFICIENCY_COUNT_BY_MONTH = "peopleEfficiencyCountWeekKey";

    //一人一档 队伍统计-本日
    public static String PEOPLE_TYPE_COUNT_BY_DAY ="peopleTypeCountDayKey";

    //一人一档 队伍统计-本周
    public static String PEOPLE_TYPE_COUNT_BY_WEEK ="peopleTypeCountWeekKey";

    //一人一档 队伍统计-本月
    public static String PEOPLE_TYPE_COUNT_BY_MONTH ="peopleTypeCountMonthKey";

    //一人一档 耗时检测-网格长
    public static String PEOPLE_TIME_COUNT_BY_MANGE ="peopleTimeCountMonthKey";

    //一人一档 耗时检测-网格员
    public static String PEOPLE_TIME_COUNT_BY_MAN ="peopleTimeCountManKey";

    //一人一档 耗时检测-共治力量
    public static String PEOPLE_TIME_COUNT_COMMON ="peopleTimeCountCommonKey";

    //一期一档 周期天数-本日
    public static String STAGE_COUNT_DAY = "stageCountDayKey";

    //一期一档 周期天数-本周
    public static String STAGE_COUNT_WEEK = "stageCountWeekKey";

    //一期一档 周期天数-本月
    public static String STAGE_COUNT_MONTH = "stageCountMonthKey";

    //一期一档 辖区数-本日
    public static String STAGE_JURISDICTION_COUNT_DAY = "stageJurisdictionCountDayKey";

    //一期一档 辖区数-本周
    public static String STAGE_JURISDICTION_COUNT_WEEK = "stageJurisdictionCountWeekKey";

    //一期一档 辖区数-本月
    public static String STAGE_JURISDICTION_COUNT_MONTH = "stageJurisdictionCountMonthKey";

    //一期一档 人员数-本日
    public static String STAGE_PEOPLE_COUNT_DAY = "stagePeopleCountDayKey";

    //一期一档 人员数-本周
    public static String STAGE_PEOPLE_COUNT_WEEK = "stagePeopleCountWeekKey";

    //一期一档 人员数-本月
    public static String STAGE_PEOPLE_COUNT_MONTH = "stagePeopleCountMonthKey";

    //一期一档 事件数-本日
    public static String STAGE_EVENT_COUNT_DAY = "stageEventCountDayKey";

    //一期一档 事件数-本周
    public static String STAGE_EVENT_COUNT_WEEK = "stageEventCountWeekKey";

    //一期一档 事件数-本月
    public static String STAGE_EVENT_COUNT_MONTH = "stageEventCountMonthKey";

    //一期一档 区域检测 本日
    public static String STAGE_REGION_EFFICIENCY_COUNT_DAY = "stageRegionEfficiencyCountDayKey";

    //一期一档 区域检测-本周
    public static String STAGE_REGION_EFFICIENCY_COUNT_WEEK = "stageRegionEfficiencyCountWeekKey";

    //一期一档 区域检测-本月
    public static String STAGE_REGION_EFFICIENCY_COUNT_MONTH = "stageRegionEfficiencyCountMonthKey";

    //一期一档 效率管理-本日
    public static String STAGE_ANALYSIS_COUNT_DAY = "stageAnalysisCountDayKey";

    //一期一档 效率管理-本周
    public static String STAGE_ANALYSIS_COUNT_WEEK = "stageAnalysisCountWeekKey";

    //一期一档 效率管理-本月
    public static String STAGE_ANALYSIS_COUNT_MONTH = "stageAnalysisCountMonthKey";

    //一期一档 类型统计-本日
    public static String STAGE_EVENT_TYPE_COUNT_DAY = "stageEventTypeCountDayKey";

    //一期一档 类型统计-本周
    public static String STAGE_EVENT_TYPE_COUNT_WEEK = "stageEventTypeCountWeekKey";

    //一期一档 类型统计-本月
    public static String STAGE_EVENT_TYPE_COUNT_MONTH = "stageEventTypeCountMonthKey";

    //一期一档 赋能流转-本日
    public static String STAGE_CHANGE_COUNT_DAY ="stageChangeCountDayKey";

    //一期一档 赋能流转-本周
    public static String STAGE_CHANGE_COUNT_WEEK ="stageChangeCountWeekKey";

    //一期一档 赋能流转-本月
    public static String STAGE_CHANGE_COUNT_MONTH ="stageChangeCountMonthKey";

    //一期一档 事件分析-本日
    public static String STAGE_EVENT_ANALYSIS_COUNT_DAY ="stageEventAnalysisCountDayKey";

    //一期一档 事件分析-本周
    public static String STAGE_EVENT_ANALYSIS_COUNT_WEEK ="stageEventAnalysisCountWeekKey";

    //一期一档 事件分析-本月
    public static String STAGE_EVENT_ANALYSIS_COUNT_MONTH ="stageEventAnalysisCountMonthKey";

    public static  String TOKEN_KEY="tokey";

}
