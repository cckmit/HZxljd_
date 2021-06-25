package com.ruoyi.system.service.HkEarlyWarning;

import com.github.pagehelper.PageInfo;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.system.domain.Action.HkActionProcess;
import com.ruoyi.system.domain.Daping.PercentResult;
import com.ruoyi.system.domain.Daping.ShowEventVo;
import com.ruoyi.system.domain.HKrecord;
import com.ruoyi.system.domain.HkEarlyWarning.*;
import com.ruoyi.system.domain.HkEarlyWarning.HkEventInfo;
import com.ruoyi.system.domain.HkEntity.EventBackVo;
import com.ruoyi.system.domain.HkEntity.EventSearchVO;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.domain.vo.CameraIndexCodeVo;
import com.ruoyi.system.domain.vo.EventListCountVo;

import java.util.List;
import java.util.Map;

/**
 * @author FanKaibiao
 * @date 2020-11-03-17:26
 */
public interface HkEventService {

    /**
     * 事件接入
     * @param event
     * @return
     */
    int reportEvent(HkEventInfo event);

    /**
     * 事件结果反馈到各平台
     * @param vo
     * @return
     */
    PageInfo<EventBackVo> queryEventResult(EventBackVo vo);

    /**
     * 查询重复事件
     * @param hkEventInfo1
     * @return
     */
    int selectEventRepeat(HkEventInfo hkEventInfo1);

    /**
     * 查询重复事件
     * @param eventInfo
     * @return
     */
    String queryEventRepeat(HkEventInfo eventInfo);

    /**根据重复标识查询重复报警数**/
    int queryEventCountRepeat(String extendStr3);

    /**
     * 根据id 查询详情
     * @param id
     * @return
     */
    HkEventInfo queryEventDetail(Integer id);

    /**
     * 忽略警情
     * @param
     */
    int updateEventStatus(HkEventInfo hkEventInfo,SysUser user);


    /**
     * 事件列表搜索
     * @param vo
     * @return
     */
    List<HkEventInfo> searchEventInfo(EventSearchVO vo);

    /**
     * 历史警情
     * @param eventInfo
     * @return
     */
    List<HkEventInfo> findEventHistory(HkEventInfo eventInfo);


    List<HkEventInfo> queryHkEventInfo(HkEventInfo hkEventInfo);

    /**
     * 查询事件类型
     * @param
     * @return
     */
    List<HkEventInfo> findEventTypeName();

    HkEventInfo findEventByEventId(String eventId);

    /**事件交办到部门**/
    int updateAssignInfo(EventAssignVO vo);

    /**
     * 关闭警情
     * @param hkEventInfo
     * @return
     */
    int closeEventStatus(HkEventInfo hkEventInfo, SysUser user);

    /**
     * 修改第一次查询的事件已读未读
     * @param hkEventInfo
     */
    void updateEventRead(HkEventInfo hkEventInfo);

    /**
     * 根据id修改事件的已读未读
     * @param id
     */
    void updateEventReadType(Integer id);

    /**
     * 定时任务添加事件表
     * @param hkEventInfo
     * @return
     */
    public int addHKEventInfo(HkEventInfo hkEventInfo);

    //查询待处理的数量
    int findPendingCount();

    //查询当日城管类事件个数
    int getTodayEventCount();
    /**
     * 查询完结的数量
     * @return
     */
    int findEventEndCount();
    //查询处置中的事件
    int findDisposalCount();
    //查询已逾期的事件数量
    int findOverdueCount();
    //城管事件处理未处理的占比
    Map<String, Object> findHKEventCount();
    //查询高发时间段下城管类事件的信息
    List<EventChengguanVO> getIntervalCount();
    //查询当天的5个高发时间段
    List<Integer> selectFuryTime();
    //重点违规
    List<KeyViolationsVO> getKeyViolations();
    //日常模式
    Map<String,String> getTodayHandleProp();
    //查询完成的数据
    List<HkEventInfo> selectEventInfoAll(HkEventInfo hkEventInfo);
    //工作概要预警信息
    List<HkEventInfo> queryEventOrder();
    //工作概要的消息通知
    List<HkEventInfo> queryEventOrderEnd();

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

    /**
     * 修改事件和新增行动流程
     * @param hkEventInfo
     * @param list
     * @return
     */
    public boolean updateEventAndProcess(HkEventInfo hkEventInfo, List<HkActionProcess> list, HKrecord hKrecord,SysUser user);


    AjaxResult addLmanagementByEvent(HkEventLmanageVo vo);

    String feedbackAllStatusEvent(String componentId ,Map<String,Object> params);
    //接入事件时判断数据库是否存在
    int queryEventEventIndexCode(String eventIndexCode);
    //查询违停事件
    List<HkEventInfo> queryIllegaDeail(HkEventInfo hkEventInfo);
    //事件列表
    List<HkEventInfo> selectEventList(HkEventInfo hkEventInfo);
    //事件总量
    int queryEventAllCount(Map<String, Object> thingResult);
    //上个月事件总量
    int queryLastEventAllCount(Map<String, Object> thingResult);
    //平台下发数据
    int queryPlatformEvent(Map<String, Object> thingResult);
    //大屏查询事件列表
    List<HkEventInfo> queryEventInfoAllList(Map<String, Object> thingResult);
    //评价满意数量
    int queryEvaluate(Map<String, Object> thingResult);
    //上报事件
    int eventSource(Map<String, Object> thingResult);
    //事件通知
    List<HkEventInfo> queryEventOne();
    //查询城管事件
    List<HkEventInfo> queryeventChengInfo(Map<String, Object> thingResult);
    //查询网格事件总数
    int queryeventCountAll(Map<String,Object> paramsAll);
    //事件热力图
    List<EventListCountVo> queryLongitude(Map<String, Object> thingResult);
    //查询城管事件
    Integer queryEventCountByList(Map<String, Object> params);
    //查询事件的设备
    List<CameraIndexCodeVo> querycameraIndexCode(Map<String, Object> params);
    //查询事件详情
    List<HkEventInfo> findEventByIdAll(Integer id);
    //修改事件等级
    void updateByIdRiskLevel(Integer id);
}
