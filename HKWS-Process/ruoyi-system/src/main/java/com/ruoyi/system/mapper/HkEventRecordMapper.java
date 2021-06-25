package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.Action.HkActionProcess;
import com.ruoyi.system.domain.HkEarlyWarning.HkEventInfo;
import com.ruoyi.system.domain.HkEarlyWarning.HkEventInfoRecord;
import com.ruoyi.system.domain.HkEntity.EventSearchVO;

import java.util.List;

/**
 * @author FanKaibiao
 * @date 2020-11-05-15:48
 */
public interface HkEventRecordMapper {


    /**
     * 确认详情 把数据添加到记录表中
     * @param hkEventInfoRecord
     */
    void insertEventRecord(HkEventInfoRecord hkEventInfoRecord);

    /**
     * 查看记录表 李彪
     * @param hkEventInfo
     * @return
     */
    List<HkEventInfo> eventRecordList(HkEventInfo hkEventInfo);

    HkEventInfo recordDetailById(Integer id);

    List<HkEventInfo> findRecordOne();

    /**
     * 模糊
     * @param searchInfo
     * @return
     */
    List<HkEventInfo> findSearchVague(EventSearchVO searchInfo);

    /**
     * 查询事件数量
     * @param searchInfo
     * @return
     */
    Integer findCountByParam(EventSearchVO searchInfo);

    /**
     * 修改流程实例id
     * @param hkEventInfoRecord
     */
    void updateEventRecord(HkEventInfoRecord hkEventInfoRecord);

    /**
     * 查询签收人
     * @param hkEventInfo
     * @return
     */
    List<HkEventInfo> findSignName(HkEventInfo hkEventInfo);

    /**
     * 机器处理
     * @param hkEventInfo
     * @return
     */
    int updateEventRemarks(HkEventInfo hkEventInfo);

    /**
     * 重新指派 将状态改为待处理
     */
    void updateEventAlertStatus(HkEventInfo hkEventInfo);

    /**
     * 查询事件上报的事件
     * @param eventId
     * @return
     */
    HkEventInfo findEventId(String eventId);
    //评价
    void updateEventInfo(HkEventInfo hkEventInfo);
}
