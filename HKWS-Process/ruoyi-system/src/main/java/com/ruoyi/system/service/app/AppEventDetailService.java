package com.ruoyi.system.service.app;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.system.domain.Action.HkActionProcess;
import com.ruoyi.system.domain.HKrecord;
import com.ruoyi.system.domain.HkEarlyWarning.HkEventInfo;
import com.ruoyi.system.domain.HkEntity.EventProcessRecordDTO;
import com.ruoyi.system.domain.HkEntity.EventProcessResultDTO;
import com.ruoyi.system.domain.app.appAction;
import com.ruoyi.system.domain.app.appActionNow;
import com.ruoyi.system.domain.app.appHkevent;
import org.apache.ibatis.annotations.Param;

import java.util.*;
import java.util.Map;

/**
 * @program: data-ruoyi
 * @description: app-事件详情
 * @author: Yang-Teng-Fei
 * @create: 2020-12-10 17:07
 **/
public interface AppEventDetailService {

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
    public int updateEventInfo(String eventId);

    /**
     * 修改事件表 处置状态
     * @param map
     * @return
     */
    public int updateManagementEvent(Map map);

    /**
     * 修改事件表 已退回状态
     * @param eventId
     * @return
     */
    public int updateReturEvent(String eventId);


    public HkEventInfo selectOneEventInfo(String eventId);

    /**
     * 查询结果
     * @param hKrecord
     * @return
     */
    List<String> selectProcess(HKrecord hKrecord);


    /**
     * 查询结果
     * @param hKrecord
     * @return
     */
    List<HKrecord> selectPro(HKrecord hKrecord);

    /**
     * 查询最近记录时间
     * @param eventId1
     * @return
     */
    Date getEventRecordTime(String eventId1,String processStatus);

    /**
     * 查询最近调度时间
     * @param eventId1
     * @return
     */
    Date getEventRecordDispatchTime(String eventId1);

    /**
     * 查询最近处置时间
     * @param eventId1
     * @return
     */
    Date getEventRecordHandleTime(String eventId1);

    /**
     * 查询处理完成时间
     * @param eventId1
     * @return
     */
   Date findEventEnd(String eventId1);

    /**
     * 查询处置结果
     */
    List<EventProcessResultDTO> result(@Param("resultid") String resultid);

    List<HKrecord> selectProcessByParams(Map<String,Object> params);

    /**
     * 获取已签收事件处理结果
     * @param params
     * @return
     */
    List<EventProcessRecordDTO> findProcessRecordSign(Map<String,Object> params);

    HkActionProcess queryActionProcessInfo(Map<String,Object> param);
}
