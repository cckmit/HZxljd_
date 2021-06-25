package com.ruoyi.system.service.ding;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.system.domain.HKrecord;
import com.ruoyi.system.domain.HkEventProcessRecord;
import com.ruoyi.system.domain.app.appActionJson;
import com.ruoyi.system.domain.app.appHkevent;
import com.ruoyi.system.domain.ding.DingEvent;

import java.util.List;
import java.util.Map;

/**
 * @ProjectName: ruoyi
 * @Package: com.ruoyi.system.service.ding
 * @ClassName: DingEventListService
 * @Author: guohailong
 * @Description: 浙政钉-事件列表服务
 * @Date: 2021/3/10 17:13
 * @Version: 1.0
 */
public interface DingEventService {

    DingEvent getEventInfoByEventId(String eventId);


    AjaxResult eventSign(Long userId, String eventId);

    AjaxResult eventReturn(Long userId, appActionJson appActionJson);

    AjaxResult eventCommit();

    AjaxResult eventFeedback(Long userId, appActionJson appActionJson);

    void updateHkActionProcessByEventIdAndUserId(String eventId, String userId,String handlerOrder);

    /**查询事件的操作记录**/
    List<HkEventProcessRecord> queryProcessRecordByParam(Map<String,Object> param);
    /**
     * 修改事件、行动流程、行动记录
     * @param event
     * @param process
     * @param record
     * @return
     */
    Boolean updateEventAndProcess(Map event, List<Map> process, HKrecord record);

}
