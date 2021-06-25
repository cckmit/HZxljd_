package com.ruoyi.system.service.impl.app;

import com.ruoyi.system.domain.app.hkAdminEvent;
import com.ruoyi.system.domain.app.hkEvent;
import com.ruoyi.system.mapper.appArchivesMapper;
import com.ruoyi.system.service.app.AppArchivesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @program: data-ruoyi
 * @description: app -我的档案
 * @author: Yang-Teng-Fei
 * @create: 2020-12-08 20:06
 **/
@Service
public class AppArchivesServiceImpl implements AppArchivesService {
    @Autowired
    private appArchivesMapper appArchivesMapper;
    /**
     * 获取当前普通用户所有事件类型
     * @param map
     * @return
     */
    @Override
    public List<hkEvent> queryEventType(Map map) {
        return appArchivesMapper.queryEventType(map);
    }

    /**
     * 获取管理员查看用户待处理所有的事件
     * @param map
     * @return
     */
    @Override
    public List<hkAdminEvent> AdminEventType(Map map) {
        return appArchivesMapper.AdminEventType(map);
    }

    /**
     * 获取管理员查看用户已逾期所有的事件
     * @param map
     * @return
     */
    @Override
    public List<hkAdminEvent> AdminOverEvent(Map map) {
        return appArchivesMapper.AdminOverEvent(map);
    }
    /**
     * 获取管理员查看用户已完成所有的事件
     * @param map
     * @return
     */
    @Override
    public List<hkAdminEvent> AdminCompkleteEvent(Map map) {
        return appArchivesMapper.AdminCompkleteEvent(map);
    }
    /**
     * 获取管理员查看事件已完成所有的事件
     * @param map
     * @return
     */
    @Override
    public List<hkEvent> appAdminEventType(Map map) {
        return appArchivesMapper.appAdminEventType(map);
    }

    @Override
    public List<hkEvent> allEventType(hkEvent hk) {
        return appArchivesMapper.allEventType(hk);
    }

}
