package com.ruoyi.system.service.app;

import com.ruoyi.system.domain.Action.HkActionProcess;

import java.util.*;

/**
 * @program: data-ruoyi
 * @description: app-我的工作
 * @author: Yang-Teng-Fei
 * @create: 2020-12-08 16:21
 **/
public interface AppMyWorkService {


    /**
     * 统计待处理事件的总数(普通人员)
     * @param map
     * @return
     */
    public int pendingCount(Map map);

    /**
     * 统计已逾期事件的总数(普通人员)
     * @param map
     * @return
     */
    public int overdueCount(Map map);
    /**
     * 统计已完成事件的总数(普通人员)
     * @param map
     * @return
     */
    public int completedCount(Map map);

    /**
     * 统计待处理事件的总数(管理员)
     * @param map
     * @return
     */
    public int adminPendingCount(Map map);
    /**
     * 统计已逾期事件的总数(管理员)
     * @param map
     * @return
     */
    public int adminOverdueCount(Map map);
    /**
     * 统计已完成事件的总数(管理员)
     * @param map
     * @return
     */
    public int adminCompletedCount(Map map);

    /**
     * 添加行动链和事件关联
     * @param hkActionProcess
     */
    void insertProcess(HkActionProcess hkActionProcess);

    /**
     * 根据流程id 查询用户
     * @param hkActionProcess
     * @return
     */
    List<HkActionProcess> findactionChainId(HkActionProcess hkActionProcess);

    /**
     * 修改行动流程表中处理人
     * @param hkActionProcess
     */
    void updateHkActionProcess(HkActionProcess hkActionProcess);

    /**
     * 查询行动流程表
     * @return
     */
    List<HkActionProcess> findHkActionProcess(HkActionProcess hkActionProcess);

    /**
     * 查询用户的id
     * @param hkActionProcess
     * @return
     */
    List<HkActionProcess> findHandLerId(HkActionProcess hkActionProcess);

    /**
     * 查询这个事件行动链的处理人
     * @param hkActionProcess
     * @return
     */
    List<HkActionProcess> findUserName(HkActionProcess hkActionProcess);

    /**
     * 查询确认指派人 和指派时间
     * @param eventId
     * @return
     */
    List<HkActionProcess> findActionChainEventId(String eventId);

    List<HkActionProcess> queryActionProcessByParams(Map<String,Object> params);
}
