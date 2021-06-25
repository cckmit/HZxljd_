package com.ruoyi.system.service.impl.ding;

import com.ruoyi.system.mapper.ding.DingMyWorkMapper;
import com.ruoyi.system.service.ding.DingMyWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @ProjectName: ruoyi
 * @Package: com.ruoyi.system.service.impl.ding
 * @ClassName: DingMyWorkServiceImpl
 * @Author: guohailong
 * @Description: 浙政钉-我的工作服务
 * @Date: 2021/3/10 16:26
 * @Version: 1.0
 */
@Service
public class DingMyWorkServiceImpl implements DingMyWorkService {

    @Resource
    private DingMyWorkMapper dingMyWorkMapper;

    @Override
    public Integer adminToDoCount(Map<String, Object> searchMap) {
        return dingMyWorkMapper.adminToDoCount(searchMap);
    }

    @Override
    public Integer adminOverdueCount(Map<String, Object> searchMap) {
        return dingMyWorkMapper.adminOverdueCount(searchMap);
    }

    @Override
    public Integer adminCompletedCount(Map<String, Object> searchMap) {
        return dingMyWorkMapper.adminCompletedCount(searchMap);
    }

    @Override
    public Integer toDoCount(Map<String, Object> searchMap) {
        return dingMyWorkMapper.toDoCount(searchMap);
    }

    @Override
    public Integer overdueCount(Map<String, Object> searchMap) {
        return dingMyWorkMapper.overdueCount(searchMap);
    }

    @Override
    public Integer completedCount(Map<String, Object> searchMap) {
        return dingMyWorkMapper.completedCount(searchMap);
    }
}
