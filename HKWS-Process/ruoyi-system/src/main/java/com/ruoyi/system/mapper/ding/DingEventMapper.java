package com.ruoyi.system.mapper.ding;

import com.ruoyi.system.domain.app.appHkevent;
import com.ruoyi.system.domain.ding.DingEvent;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @ProjectName: ruoyi
 * @Package: com.ruoyi.system.mapper.ding
 * @ClassName: DingEventMapper
 * @Author: guohailong
 * @Description: 浙政钉事件操作dao
 * @Date: 2021/3/21 22:48
 * @Version: 1.0
 */
public interface DingEventMapper {


    List<appHkevent> queryEventListByUser(Map<String,Object> param);

    DingEvent getEventInfoByEventId(@Param("eventId") String eventId);

    //修改行动流程记录
    void updateHkActionProcessByEventIdAndUserId(@Param("eventId") String eventId, @Param("userId") String userId, @Param("handlerOrder") String handlerOrder);

    int updateHkActionByParam(Map<String,Object> param);

    /**
     * 更新其他用户的actionProcess为未处理已完结
     * @param param
     * @return
     */
    int updateOtherHkActionProcessByParam(Map<String, Object> param);
}
