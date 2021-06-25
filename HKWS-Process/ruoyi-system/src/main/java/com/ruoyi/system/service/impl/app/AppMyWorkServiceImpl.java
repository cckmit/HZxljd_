package com.ruoyi.system.service.impl.app;

import com.ruoyi.system.domain.Action.HkActionProcess;
import com.ruoyi.system.mapper.appMyWorkMapper;
import com.ruoyi.system.service.app.AppMyWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @program: data-ruoyi
 * @description:app-我的工作
 * @author: Yang-Teng-Fei
 * @create: 2020-12-08 16:41
 **/
@Service
public class AppMyWorkServiceImpl implements AppMyWorkService {
    @Autowired
    private appMyWorkMapper appMyWorkMapper;


    /**
     * 统计待处理事件的总数(普通人员)
     * @param map
     * @return
     */
    @Override
    public int pendingCount(Map map) {
        return appMyWorkMapper.pendingCount(map);
    }
    /**
     * 统计已逾期事件的总数(普通人员)
     * @param map
     * @return
     */
    @Override
    public int overdueCount(Map map) {
        return appMyWorkMapper.overdueCount(map);
    }

    /**
     * 统计已完成事件的总数(普通人员)
     * @param map
     * @return
     */
    @Override
    public int completedCount(Map map) {
        return appMyWorkMapper.completedCount(map);
    }
    /**
     * 统计待处理事件的总数(管理员)
     * @param map
     * @return
     */
    @Override
    public int adminPendingCount(Map map) {
        return appMyWorkMapper.adminPendingCount(map);
    }
    /**
     * 统计已逾期事件的总数(管理员)
     * @param map
     * @return
     */
    @Override
    public int adminOverdueCount(Map map) {
        return appMyWorkMapper.adminOverdueCount(map);
    }
    /**
     * 统计已完成事件的总数(管理员)
     * @param map
     * @return
     */
    @Override
    public int adminCompletedCount(Map map) {
        return appMyWorkMapper.adminCompletedCount(map);
    }

    @Override
    public void insertProcess(HkActionProcess hkActionProcess) {
        appMyWorkMapper.insertProcess(hkActionProcess);
    }

    @Override
    public List<HkActionProcess> findactionChainId(HkActionProcess hkActionProcess) {
        return appMyWorkMapper.findactionChainId(hkActionProcess);
    }

    @Override
    public void updateHkActionProcess(HkActionProcess hkActionProcess) {
        appMyWorkMapper.updateHkActionProcess(hkActionProcess);
    }

    @Override
    public List<HkActionProcess> findHkActionProcess(HkActionProcess hkActionProcess) {
        return appMyWorkMapper.findHkActionProcess(hkActionProcess);
    }

    @Override
    public List<HkActionProcess> findHandLerId(HkActionProcess hkActionProcess) {
        return appMyWorkMapper.findHandLerId(hkActionProcess);
    }

    @Override
    public List<HkActionProcess> findUserName(HkActionProcess hkActionProcess) {
        return appMyWorkMapper.findUserName(hkActionProcess);
    }

    @Override
    public List<HkActionProcess> findActionChainEventId(String eventId) {
        return appMyWorkMapper.findActionChainEventId(eventId);
    }

    @Override
    public List<HkActionProcess> queryActionProcessByParams(Map<String, Object> params) {
        return appMyWorkMapper.queryActionProcessByParams(params);
    }


}
