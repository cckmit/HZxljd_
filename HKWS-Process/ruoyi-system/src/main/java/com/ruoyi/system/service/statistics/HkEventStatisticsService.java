package com.ruoyi.system.service.statistics;

import com.ruoyi.system.domain.Daping.PercentResult;
import com.ruoyi.system.domain.Daping.ShowEventVo;
import com.ruoyi.system.domain.HkEarlyWarning.*;
import com.ruoyi.system.domain.HkEntity.EventSearchVO;

import java.util.List;
import java.util.Map;

public interface HkEventStatisticsService {


    /**
     * 根据事件的天数和事件的类别和事件的区域code进行判断 这条事件的数量
     * @param hkEventInfo1
     * @return
     */
    int selectEventCount(HkEventInfo hkEventInfo1);

    /**
     * 今日总告警数
     * @param eventParams
     * @return
     */
    int queryTodayEventCounts(Map<String,Object> eventParams);

    /**
     * 未处理告警数
     * @param eventParams
     * @return
     */
    int queryTodayUnprocessedEventCounts(Map<String,Object> eventParams);

    /**
     * 逾期处理数
     * @param timeOutParams
     * @return
     */
    int queryEventTimeOutCounts(Map<String,Object> timeOutParams);

    /**
     * 当日告警事件类型次数统计
     * @param eventCreatTime
     * @return
     */
    List<EventTypeCountsVO> queryEventTypeCounts(String eventCreatTime);

    /**
     * 事情有效流转率-事件签收数
     * @param eventCreatTime
     * @return
     */
    int queryEventHandlerCount(String eventCreatTime);

    /**
     * 事情有效流转率-事件关闭数
     * @param eventCreatTime
     * @return
     */
    int queryEventEndCount(String eventCreatTime);

    /**
     * 事情有效流转率-异常报送数
     * @param eventCreatTime
     * @return
     */
    int queryEventExceptionCounts(String eventCreatTime);

    /**
     * 一事一档事件数
     * @param params
     * @return
     */
    int countAllByParams(Map<String,Object> params);

    /**
     * 一事一档 共治率
     * @param params
     * @return
     */
    int queryEventTurnoverRateCounts(Map<String, Object> params);

    /**
     * 一事一档 事件趋势
     * @param map
     * @return
     */
    List<EventTrendVO> queryEventTrends(Map<String, Object> map);

    /**
     * 一事一档 社区检测
     * @param map
     * @return
     */
    List<EventInspectVO> queryEventRegion(Map<String, Object> map);

    /**
     * 一期一档 暂用
     * @param map
     * @return
     */
    List<EventInspectVO> queryEventRegion1(Map<String, Object> map);

    /**
     * 一事一档 类型统计
     * @param map
     * @return
     */
    List<EventTypeVO> queryEventType(Map<String, Object> map);
    List<EventTypeVO> queryEventTypePartTwo(Map<String, Object> map);

    /**
     * 一事一档 事件分析
     * @param map
     * @return
     */
    List<EventAnalysisVO> queryEventAnalysis(Map<String, Object> map);

    List<EventAnalysisVO> queryEventAnalysisPartTwo(Map<String, Object> map);

    List<EventAnalysisVO> eventProcessAnalysis(Map<String, Object> map);

    Long queryEventSumTime(Map<String, Object> map);



    /**根据关联后的 事件分类 分组查询各类型下的事件数量**/
    List<EventAnalysisVO> queryEventAnalysisPart(Map<String, Object> map);
    /**根据关联后的事件分类 分组查询各类型下的事件总耗时**/
    List<EventAnalysisVO> eventActiveTimeByEventType(Map<String, Object> map);


    /**
     * 一事一档 赋能流转
     * @param map
     * @return
     */
    List<EventChangeVO> queryEventChange(Map<String, Object> map);

    /**一域一档  根据区域查询事件数量**/
    Integer queryEventTransferByRegion(Map<String, Object> params);

    /**根据日期获取一段日期内事件发生的社区数量，与社区总人数**/
    RegionLoadVO queryEventHappenRegionInfo(Map<String, Object> map);
    /**
     * 一域一档 类型统计
     * @param params
     * @return
     */
    List<RegionEventTypeVO> queryRegionEventType(Map<String, Object> params);

    /**
     * 一域一档 事件分析 流转率
     * @param params
     * @return
     */
    List<RegionEventAnalysisVO> queryRegionAnalysis(Map<String, Object> params);

    /**
     * 一人一档 事件完成数
     * @param params
     * @return
     */
    List<HkEventInfo> queryEventByAlterStatus(Map<String, Object> params);


    /**人员的事件数**/
    List<PeopleAnalysisVO> queryEventCountByAllRanks(Map<String, Object> params);
    /**根据条件查询人员的事件数**/
    List<PeopleAnalysisVO> queryEventCountByParam(Map<String, Object> params);

    /**查询用户 完成的事件数**/
    List<PeopleDisposalAnalysisVO> queryPeopleDisposalAnalysis(Map<String, Object> params);

    /** 事件的总处置时长**/
    Long queryProcessTimeByParam(Map<String, Object> params);

    /**
     * 一事一档 事件区间范围选择
     * @param initTimeParams
     * @return
     */
    int queryEventTrendByDay(Map<String, Object> initTimeParams);

    /**
     * 一事一档 类型统计-社区选择
     * @return
     */
    List<EventTypeVO> queryEventTypeByRegion(Map<String, Object> params);

    /******************************************四个一事件列表*******************************************/

    List<HkEventThingVo> queryThingList(HkEventFourVo vo);

    List<HkEventFieldVo> queryFieldList(HkEventFourVo vo);

    List<HkEventPersonVo> queryPersonList(HkEventFourVo vo);

    List<HkEventStageVo> queryStageList(HkEventFourVo vo);

    /******************************************临安大屏数据*********************************************/

    /**
     *当日各事件类型下的事件数量
     * @return
     */
    List<PercentResult> queryCountByEventType(Map<String,Object> params);
    /**
     *当日各事件状态下的事件数量
     * @return
     */
    List<PercentResult> queryCountByAlertStatus(Map<String,Object> params);
    /**
     *当日各处置方式下的事件数量
     * @return
     */
    List<PercentResult> queryCountByLawType(Map<String,Object> params);
    /**
     * 青和力-事件数/同环/同比数
     * @param params
     * @return
     */
    PercentResult eventCountAndRate(Map<String, Object> params);

    List<HkEventInfo> getEventByParams(Map<String, Object> params);

    Map<String,Object> getMapBySubStatus(Map<String,Object> params);

    Map<String,Object> getMapByEventName(Map<String,Object> params);

    Map<String,Object> getMapByCameraType(Map<String,Object> params);

    Map<String,Object> getMapByEventType(Map<String,Object> params);

    Map<String,Object> getMouthEventCount(Map<String,Object> params);

    Map<String,Object> getEventDoneInfo(Map<String,Object> params);

    PercentResult eventActiveTime(Map<String, Object> params);

    /**
     * 获取最新一条事件数据
     * @return
     */
    List<ShowEventVo> getNewEvent(Map<String,Object> eventParams);

    /**
     * 获取网格员、执法力量分布情况
     * @param eventParams
     * @return
     */
    List<PercentResult> getDistributionOfMember(Map<String, Object> eventParams);

    /**
     * 获取最新事件-滚动（当天数据）
     * @param eventParams
     * @return
     */
    ShowEventVo getNewEventByYJ(Map<String, Object> eventParams);

    /**
     * 今日各类事件数
     * @param componentId 区域id
     * @param eventType 事件类型
     * @param createTime 时间
     * @return
     */
    int todayEventTypeCount(String componentId, String eventType,String eventSubType,String createTime,String[] statusArr);

    /**
     * 预警赋能-列表-待处理数
     * @param eventSearchVO
     * @return
     */
    int findPendingVehicleCountByParams(EventSearchVO eventSearchVO);


    int findCountByParam(EventSearchVO eventSearchVO);
    /****************************************************************************************/
}
