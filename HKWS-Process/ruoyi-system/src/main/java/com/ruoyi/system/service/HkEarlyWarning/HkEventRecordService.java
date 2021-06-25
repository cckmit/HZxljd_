package com.ruoyi.system.service.HkEarlyWarning;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.system.domain.ActProcess.ActHiTaskinst;
import com.ruoyi.system.domain.ActProcess.ActRuTask;
import com.ruoyi.system.domain.Action.HkActionProcess;
import com.ruoyi.system.domain.HkEarlyWarning.HkEventInfo;
import com.ruoyi.system.domain.HkEarlyWarning.HkEventInfoRecord;
import com.ruoyi.system.domain.HkEntity.EventAfreshAssignVo;
import com.ruoyi.system.domain.HkEntity.EventSearchVO;
import com.ruoyi.system.domain.HkEntity.UserInfoDto;
import com.ruoyi.system.domain.SysUser;

import java.util.List;
import java.util.Map;

/**
 * @author FanKaibiao
 * @date 2020-11-05-15:22
 */
public interface HkEventRecordService {
    /**
     * 确认详情  在记录表里添加一条信息
     * @param hkEventInfoRecord
     */
    void insertEventRecord(HkEventInfoRecord hkEventInfoRecord);

    /**
     *  查看记录表 列表
     * @param hkEventInfo
     * @return
     */
    List<HkEventInfo> eventRecordList(HkEventInfo hkEventInfo);

    /**
     * 根据id 查询每条数据的信息
     * @param id
     * @return
     */
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
     * 修改ACT_HI_TASKINST
     * @param actHiTaskinst
     */
    void updateActHiTaskinst(ActHiTaskinst actHiTaskinst);

    /**
     * 修改ACT_RU_TASK
     * @param actRuTask
     */
    void updateActRuTask(ActRuTask actRuTask);

    /**
     * 查询签收人
     * @param hkEventInfo
     * @return
     */
    List<HkEventInfo> findSignName(HkEventInfo hkEventInfo);

    /**
     * 将事件进行处理
     * @param hkEventInfo
     * @return
     */
    int updateEventRemarks(HkEventInfo hkEventInfo);

    /**
     * 重新指派  改为待处理
     */
    void updateEventAlertStatus(HkEventInfo hkEventInfo);


    void afreshAssign(EventAfreshAssignVo vo);

    /**
     * 根据事件id查询事件详情
     * @param eventId
     * @return
     */
    HkEventInfo findEventId(String eventId);

    AjaxResult machineHandling(String eventId,String closeReason,SysUser sysUser,Integer handlerOrder);
    //评价
    void updateEventInfo(HkEventInfo hkEventInfo);
}
