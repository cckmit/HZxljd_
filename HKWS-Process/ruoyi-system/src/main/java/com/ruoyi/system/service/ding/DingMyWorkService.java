package com.ruoyi.system.service.ding;

import java.util.Map;

/**
 * @ProjectName: ruoyi
 * @Package: com.ruoyi.system.service.ding
 * @ClassName: DingMyWorkService
 * @Author: guohailong
 * @Description: 浙政钉-我的工作服务
 * @Date: 2021/3/10 16:26
 * @Version: 1.0
 */
public interface DingMyWorkService {

    Integer adminToDoCount(Map<String, Object> searchMap);

    Integer adminOverdueCount(Map<String, Object> searchMap);

    Integer adminCompletedCount(Map<String, Object> searchMap);

    Integer toDoCount(Map<String, Object> searchMap);

    Integer overdueCount(Map<String, Object> searchMap);

    Integer completedCount(Map<String, Object> searchMap);
}
