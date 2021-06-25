package com.ruoyi.system.service.app;

import com.ruoyi.system.domain.app.hkAdminEvent;
import com.ruoyi.system.domain.app.hkEvent;

import java.util.*;

/**
 * @program: data-ruoyi
 * @description: app-我的档案
 * @author: Yang-Teng-Fei
 * @create: 2020-12-08 19:29
 **/
public interface AppArchivesService {
    /**
     * 获取当前普通用户所有事件类型
     * @param map
     * @return
     */
    public List<hkEvent> queryEventType(Map map);

    /**
     * 获取管理员查看用户待处理所有的事件
     * @param map
     * @return
     */
    public List<hkAdminEvent> AdminEventType(Map map);

    /**获取管理员查看用户已逾期所有的事件
     * hkAdminEvent
     * @param map
     * @return
     */
    public List<hkAdminEvent> AdminOverEvent(Map map);

    /**
     * 获取管理员查看用户已完成所有的事件
     * @param map
     * @return
     */
    public List<hkAdminEvent> AdminCompkleteEvent(Map map);

    /**
     * 获取管理员查看事件已完成所有的事件
     * @param map
     * @return
     */
    public List<hkEvent> appAdminEventType(Map map);

    /**
     *
     * @param hk
     * @return
     */
    public List<hkEvent> allEventType(hkEvent hk);
}
