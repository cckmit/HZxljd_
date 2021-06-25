package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.Action.HkActionProcess;
import com.ruoyi.system.domain.HKrecord;
import com.ruoyi.system.domain.HkEarlyWarning.HkEventInfo;
import com.ruoyi.system.domain.HkEntity.EventProcessRecordDTO;
import com.ruoyi.system.domain.HkEntity.EventProcessResultDTO;
import com.ruoyi.system.domain.app.appAction;
import com.ruoyi.system.domain.app.appActionNow;
import com.ruoyi.system.domain.app.appHkevent;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Primary;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @program: data-ruoyi
 * @description: app-事件详情
 * @author: Yang-Teng-Fei
 * @create: 2020-12-10 17:11
 **/
public interface appEventDetalisMapper {

    /**
     * 查询当前事件需要处理的字段
     */
    public List<appActionNow> appNowEventDetali(Map map);

    /**
     * 查询该事件的信息
     * @param map
     * @return
     */
    public appHkevent selectOneHkevent(Map map);

    /**
     * 提交处理事件结果
     * @param hKrecord
     * @return
     */
    public int addHkrecond(HKrecord hKrecord);

    /**
     * 查询之前的事件需要的字段
     *
     */
    public List<appAction> appAfterEventDetali(String eventId);

    /**
     * 判断行动连是否走完
     * @param eventId
     * @return
     */
    public List<HkActionProcess> selcterCompleteSize(String eventId);

    /**
     * 修改当前人状态
     * @param map
     * @return
     */
    public int updateHkAction(Map map);

    /**
     * 修改事件表完结状态
     * @param eventId
     * @return
     */
    public int updateEventInfo(String eventId );

    /**
     * 修改事件表处置状态
     * @param map
     * @return
     */
    public int updateManagementEvent(Map map );

    /**
     * 修改事件表 已退回状态
     * @param eventId
     * @return
     */
    public int updateReturEvent(String eventId);

    public int updateEventDispatch(String eventId);

    public HkEventInfo selectOneEventInfo(@Param("eventId") String eventId);

    /**
     * 查询结果
     * @param hKrecord
     * @return
     */
    List<String> selectProcess(HKrecord hKrecord);

    /**
     * 查询签收、退回最近时间
     * @param eventId1
     * @return
     */
    Date getEventRecordTime(@Param("eventId") String eventId1, @Param("processStatus") String processStatus);

    /**
     * 查询最近处置时间
     * @param eventId1
     * @return
     */
    Date getEventRecordHandleTime(@Param("eventId") String eventId1);

    /**
     * 查询最近调度时间
     * @param eventId1
     * @return
     */
    Date getEventRecordDispatchTime(@Param("eventId") String eventId1);

    /**
     * 查询完结的时间
     * @param eventId1
     * @return
     */
    Date findEventEnd(String eventId1);

    /**
     * 查询处置结果
     */
    List<EventProcessResultDTO> result(@Param("resultid") String resultid);

    List<HKrecord> selectPro(HKrecord hKrecord);


    List<HKrecord> selectProcessByParams(Map<String,Object> params);

    List<EventProcessRecordDTO> findProcessRecordSign(Map<String,Object> params);

    /**
     * 获取当前用户的未完成的行动流程信息
     * @param param
     * @return
     */
    HkActionProcess queryActionProcessInfo(Map<String,Object> param);
}
