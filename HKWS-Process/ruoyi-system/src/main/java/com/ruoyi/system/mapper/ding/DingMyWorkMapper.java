package com.ruoyi.system.mapper.ding;

import java.util.Map;

/**
 * @ProjectName: ruoyi
 * @Package: com.ruoyi.system.mapper.ding
 * @ClassName: DingMyWorkMapper
 * @Author: guohailong
 * @Description:
 * @Date: 2021/3/10 16:27
 * @Version: 1.0
 */
public interface DingMyWorkMapper {
    Integer adminToDoCount(Map<String, Object> searchMap);

    Integer adminOverdueCount(Map<String, Object> searchMap);

    Integer adminCompletedCount(Map<String, Object> searchMap);

    Integer toDoCount(Map<String, Object> searchMap);

    Integer overdueCount(Map<String, Object> searchMap);

    Integer completedCount(Map<String, Object> searchMap);
}
