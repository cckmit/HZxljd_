package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.Daping.PercentResult;
import com.ruoyi.system.domain.Daping.ShowEventVo;
import com.ruoyi.system.domain.HkEarlyWarning.*;
import com.ruoyi.system.domain.HkEarlyWarning.EventTypeCountsVO;
import com.ruoyi.system.domain.HkEarlyWarning.HkEventInfo;
import com.ruoyi.system.domain.HkEventLmanage;
import com.ruoyi.system.domain.HkEntity.EventBackVo;
import com.ruoyi.system.domain.HkEntity.EventSearchVO;
import com.ruoyi.system.domain.vo.CameraIndexCodeVo;
import com.ruoyi.system.domain.vo.EventListCountVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author FanKaibiao
 * @date 2020-11-03-17:38
 */
public interface HkEventMapper {

    /**
     * 根据id 查询详情
     * @param id
     * @return
     */
    HkEventInfo findEventById(Integer id);

    HkEventInfo findEventByEventId(String eventId);

    /**事件交办到部门**/
    int updateAssignInfo(EventAssignVO vo);

    /**更新事件风险等级**/
    int updateRiskLevelById(@Param("riskLevel") String riskLevel,@Param("eventId") Long eventId);

    /**
     * 确认警情
     * @param
     */
    void updateConfirmDetail(HkEventInfo hkEventInfo);


    /**
     * 忽略警情
     * @param
     */
    int updateEventStatus(HkEventInfo hkEventInfo);


    List<HkEventInfo> searchEventInfo(EventSearchVO vo);

    /**
     * 历史警情
     * @param eventInfo
     * @return
     */
    List<HkEventInfo> findEventHistory(HkEventInfo eventInfo);


    List<HkEventInfo> queryHkEventInfo(HkEventInfo hkEventInfo);

    /**
     * 根据事件类型查询有关数据
     * @param
     * @return
     */
    List<HkEventInfo> findEventTypeName();

    /**
     * 关闭警情
     * @param hkEventInfo
     * @return
     */
    int closeEventStatus(HkEventInfo hkEventInfo);

    /**
     * 修改状态位已读
     * @param hkEventInfo
     */
    void updateEventRead(HkEventInfo hkEventInfo);

    /**
     * 根据id 修改事件的已读未读
     * @param id
     */
    void updateEventReadType(Integer id);


    /**
     * 定时任务添加事件表
     * @param hkEventInfo
     * @return
     */
    public int addHKEventInfo(HkEventInfo hkEventInfo);

    /**
     * 事件结果反馈到各平台
     * @param vo
     * @return
     */
    List<EventBackVo> queryEventResult(EventBackVo vo);

    //查询待处理的总数
    int findPendingCount();
    //查询已完结的总数
    int findEventEndCount();
    //查询处置中的数据
    int findDisposalCount();
    //查询逾期事件的数量
    int findOverdueCount();
    //查询当日城管类事件个数
    int getTodayEventCount();
    //重点违规
    List<KeyViolationsVO> getKeyViolations();
    //城管事件处理未处理的占比
    Map<String, Object> findHKEventCount();
    //查询高发时间段下城管类事件的信息
    List<EventChenAccVO> getIntervalCount(Integer time);
    //查询当天的5个高发时间段
    List<Integer> selectFuryTime();
    //日常模式
    Map<String,String> getTodayHandleProp();
    //查询已完结的数据
    List<HkEventInfo> selectEventInfoAll(HkEventInfo hkEventInfo);
    //工作概要的预警信息
    List<HkEventInfo> queryEventOrder();

    /**
     * 工作概要的消息通知
     * @return
     */
    List<HkEventInfo> queryEventOrderEnd();


    /**
     * 查询重复事件
     * @param hkEventInfo1
     * @return
     */
    int selectEventRepeat(HkEventInfo hkEventInfo1);


    String queryEventRepeat(HkEventInfo eventInfo);

    int queryEventCountRepeat(String extendStr3);

    int updateRepeatCode(String extendStr3);

    /**
     * 根据事件的天数和事件的类别和事件的区域code进行判断 这条事件的数量
     * @param hkEventInfo1
     * @return
     */
    int selectEventCount(HkEventInfo hkEventInfo1);

    /**
     * 一事一档事件数
     * @param params
     * @return
     */
    int countAllByParams(Map<String,Object> params);

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
    List<EventTypeCountsVO> queryEventTypeCounts(@Param("eventCreatTime") String eventCreatTime);

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
     * 一事一档 共治数量
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

    /**一域一档  根据区域查询事件数量**/
    Integer queryEventTransferByRegion(Map<String, Object> params);

    /**总人员的事件数**/
    List<PeopleAnalysisVO> queryEventCountByAllRanks(Map<String, Object> params);
    /**根据条件查询人员的事件数**/
    List<PeopleAnalysisVO> queryEventCountByParam(Map<String, Object> params);

    /**查询用户 完成的事件数**/
    List<PeopleDisposalAnalysisVO> queryPeopleDisposalAnalysis(Map<String, Object> params);

    Long queryProcessTimeByParam(Map<String, Object> params);

    /**
     * 一人一档 事件完成数
     * @param params
     * @return
     */
    List<HkEventInfo> queryEventByAlterStatus(Map<String, Object> params);

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

    /**
     * 将车主信息保存到数据库
     * @param hkEventInfo
     */
    void updateExtendStr(HkEventInfo hkEventInfo);

    /**
     * 查询是否有车主信息
     * @param eventId
     * @return
     */
    List<HkEventInfo> findExtendStr(String eventId);


    /******************************************临安大屏数据*********************************************/

    Integer queryCounts();

    /**
     *当日各事件类型下的事件数量
     * @return
     */
    List<PercentResult> queryCountByEventType(Map<String,Object> params);

    /**
     *当日各事件状态下的事件数量
     * @return
     */
    List<PercentResult> queryCountByAlertStatus(Map<String,Object> eventParams);

    /**
     *当日各处置方式下的事件数量
     * @return
     */
    List<PercentResult> queryCountByLawType(Map<String,Object> param);

    /**
     * 获取最新一条事件记录
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
    /*List<PercentResult> getNewEvents(Map<String, Object> eventParams);*/

    ShowEventVo getNewEventByYJ(Map<String, Object> eventParams);

    /**
     * 查询各平台事件服务时长
     * @param params
     * @return
     */
    Long eventActiveTime(Map<String, Object> params);

    List<HkEventInfo> getEventByParams(Map<String, Object> params);

    List<PercentResult> getMapBySubStatus(Map<String, Object> params);

    List<PercentResult> getMapByEventName(Map<String, Object> params);

    List<PercentResult> getMapByCameraType(Map<String, Object> params);

    /**
     * 预警赋能-列表-待处理数
     * @param eventSearchVO
     * @return
     */
    int findPendingVehicleCountByParams(EventSearchVO eventSearchVO);

    int findCountByParam(EventSearchVO eventSearchVO);

    /**
     * 一事一档事件列表
     * @param vo
     * @return
     */
    List<HkEventThingVo> queryThingList(HkEventFourVo vo);

    /**
     * 一域一档 查询社区 社区发生的事件数量
     * @param vo
     * @return
     */
    List<HkEventFieldVo> queryRegionByEvent(HkEventFourVo vo);

    /**
     *
     * @param vo
     * @return
     */
    Integer queryEventCountByRegion(HkEventFourVo vo);

    /**
     * 查询社区下符合条件的事件数量
     * @param vo
     * @return
     */
    Integer queryEventCountByRegion2(HkEventFourVo vo);

    Integer queryEventCount(HkEventFourVo vo);

    List<HkEventPersonVo> queryEventByUser(HkEventFourVo vo);

    /**
     * 查询用户已处置完的事件总数
     * @param vo
     * @return
     */
    List<HkEventPersonVo> queryEventByUser1(HkEventFourVo vo);

    int queryStatusEventCountByUser(Map<String,Object> param);

    Long queryEventTotalTimeByUser(HkEventFourVo vo);

    int updateHkEventInfo(HkEventInfo hkEventInfo);
    //接入事件时判断数据库是否存在
    int queryEventEventIndexCode(String eventIndexCode);
    //查询最新的一条违停事件
    List<HkEventInfo> queryIllegaDeail(HkEventInfo hkEventInfo);
    //事件列表
    List<HkEventInfo> selectEventList(HkEventInfo hkEventInfo);
    //事件总量
    int queryEventAllCount(Map<String, Object> thingResult);
    //上个月事件总量
    int queryLastEventAllCount(Map<String, Object> thingResult);
    //平台事件
    int queryPlatformEvent(Map<String, Object> thingResult);
    //大屏查询事件列表
    List<HkEventInfo> queryEventInfoAllList(Map<String, Object> thingResult);
    //查看评价满意度
    int queryEvaluate(Map<String, Object> thingResult);
    //上报事件
    int eventSource(Map<String, Object> thingResult);
    //查看最新事件信息
    List<HkEventInfo> queryEventOne();
    //城管事件信息
    List<HkEventInfo> queryeventChengInfo(Map<String, Object> thingResult);

    int queryeventCountAll(Map<String,Object> paramsAll);
    //事件热力图
    List<EventListCountVo> queryLongitude(Map<String, Object> thingResult);
    //查询城管事件总数
    Integer queryEventCountByList(Map<String, Object> params);
    //查询事件的设备
    List<CameraIndexCodeVo> querycameraIndexCode(Map<String, Object> params);
    //查询事件详情
    List<HkEventInfo> findEventByIdAll(Integer id);
    //修改事件等级
    void updateByIdRiskLevel(Integer id);
}
