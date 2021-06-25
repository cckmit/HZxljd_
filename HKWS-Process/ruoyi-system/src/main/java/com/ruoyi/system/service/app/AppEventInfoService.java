package com.ruoyi.system.service.app;

import com.ruoyi.system.domain.Action.HkActionProcess;
import com.ruoyi.system.domain.app.WxHkEventVo;
import com.ruoyi.system.domain.app.appHkevent;
import org.apache.xmlbeans.impl.jam.mutable.MPackage;

import java.util.*;

/**
 * @program: data-ruoyi
 * @description: app-事件概要查询
 * @author: Yang-Teng-Fei
 * @create: 2020-12-10 12:59
 **/
public interface AppEventInfoService {

    /**
     * 查询待处理事件概要查询
     * @param map
     * @return
     */
    public List<appHkevent> selectOneHkevent(Map map);

    /**
     * 查询已逾期事件概要查询
     * @param map
     * @return
     */
    public List<appHkevent> selectOverduEvent(Map map);


    public List<appHkevent> selectTwoHkEvent(WxHkEventVo vo);

    /**
     * 查询已完成事件概要查询
     * @param map
     * @return
     */
    public List<appHkevent> selectCompletedEvent(Map map);

    /**
     * 判断登陆人事件处理完成
     * @param map
     * @return
     */
    public HkActionProcess findHkActionProcess(Map map);

    public String findHkActionEvent(String eventId);
    HkActionProcess findHkActionProcessNow(Map<String,Object> param);
}
