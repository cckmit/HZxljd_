package com.ruoyi.system.service.impl.app;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.system.domain.Action.HkActionProcess;
import com.ruoyi.system.domain.HKrecord;
import com.ruoyi.system.domain.HkEarlyWarning.HkEventInfo;
import com.ruoyi.system.domain.HkEntity.EventProcessRecordDTO;
import com.ruoyi.system.domain.HkEntity.EventProcessResultDTO;
import com.ruoyi.system.domain.app.appAction;
import com.ruoyi.system.domain.app.appActionNow;
import com.ruoyi.system.domain.app.appHkevent;
import com.ruoyi.system.mapper.appEventDetalisMapper;
import com.ruoyi.system.service.app.AppEventDetailService;
import com.ruoyi.system.service.ding.DingEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @program: data-ruoyi
 * @description: app-事件详情
 * @author: Yang-Teng-Fei
 * @create: 2020-12-10 17:12
 **/
@Service
public class AppEventDetaliServiceImpl implements AppEventDetailService {
    @Autowired(required = false)
    private appEventDetalisMapper appEventDetalisMapper;

    @Autowired
    private DingEventService dingEventService;

    /**
     * 查询当前事件需要处理的字段
     * @param map
     * @return
     */
    @Override
    public List<appActionNow> appNowEventDetali(Map map) {
        return appEventDetalisMapper.appNowEventDetali(map);
    }

    /**
     * 查询该事件的信息
     * @param map
     * @return
     */
    @Override
    public appHkevent selectOneHkevent(Map map) {
        return appEventDetalisMapper.selectOneHkevent(map);
    }
    /**
     * 提交处理事件结果
     * @param hKrecord
     * @return
     */
    @Override
    public int addHkrecond(HKrecord hKrecord) {
        return appEventDetalisMapper.addHkrecond(hKrecord);
    }
    /**
     * 查询之前的事件需要的字段
     *
     */
    @Override
    public List<appAction> appAfterEventDetali(String eventId) {
        return appEventDetalisMapper.appAfterEventDetali(eventId);
    }
    /**
     * 判断行动连是否走完
     * @param eventId
     * @return
     */
    @Override
    public List<HkActionProcess> selcterCompleteSize(String eventId) {
        return appEventDetalisMapper.selcterCompleteSize(eventId);
    }

    /**
     * 修改当前人状态
     * @param map
     * @return
     */
    @Override
    public int updateHkAction(Map map) {
        return appEventDetalisMapper.updateHkAction(map);
    }
    /**
     * 修改事件表完结状态
     * @param eventId
     * @return
     */
    @Override
    public int updateEventInfo(String eventId) {
        return appEventDetalisMapper.updateEventInfo(eventId);
    }
    /**
     * 修改事件表处置状态
     * @param map
     * @return
     */
    @Override
    public int updateManagementEvent(Map map) {
        return appEventDetalisMapper.updateManagementEvent(map);
    }
    /**
     * 修改事件表 已退回状态
     * @param eventId
     * @return
     */
    @Override
    public int updateReturEvent(String eventId) {
        return appEventDetalisMapper.updateReturEvent(eventId);
    }

    @Override
    public HkEventInfo selectOneEventInfo(String eventId) {
        return appEventDetalisMapper.selectOneEventInfo(eventId);
    }

    @Override
    public List<String> selectProcess(HKrecord hKrecord) {
        return appEventDetalisMapper.selectProcess(hKrecord);
    }

    @Override
    public List<HKrecord> selectPro(HKrecord hKrecord) {
        return appEventDetalisMapper.selectPro(hKrecord);
    }

    @Override
    public Date getEventRecordTime(String eventId1,String processStatus) {
        return appEventDetalisMapper.getEventRecordTime(eventId1,processStatus);
    }

    @Override
    public Date getEventRecordDispatchTime(String eventId1) {
        return appEventDetalisMapper.getEventRecordDispatchTime(eventId1);
    }

    @Override
    public Date getEventRecordHandleTime(String eventId1) {
        return appEventDetalisMapper.getEventRecordHandleTime(eventId1);
    }

    @Override
    public Date findEventEnd(String eventId1) {
        return appEventDetalisMapper.findEventEnd(eventId1);
    }

    @Override
    public List<EventProcessResultDTO> result(String resultid) {
        return appEventDetalisMapper.result(resultid);
    }

    @Override
    public List<HKrecord> selectProcessByParams(Map<String, Object> params) {
        return appEventDetalisMapper.selectProcessByParams(params);
    }

    @Override
    public List<EventProcessRecordDTO> findProcessRecordSign(Map<String, Object> params) {
        return appEventDetalisMapper.findProcessRecordSign(params);
    }

    @Override
    public HkActionProcess queryActionProcessInfo(Map<String, Object> param) {
        return appEventDetalisMapper.queryActionProcessInfo(param);
    }


}
