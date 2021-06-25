package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.Action.HkActionProcess;
import com.ruoyi.system.domain.app.WxHkEventVo;
import com.ruoyi.system.domain.app.appHkevent;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @program: data-ruoyi
 * @description: app-事件概要查询
 * @author: Yang-Teng-Fei
 * @create: 2020-12-10 12:59
 **/
@Resource
public interface appEventInfoMapper {

    /**
     * 查询事件概要查询
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


    /**
     * 查询未处理事件列表
     * @param vo
     * @return
     */
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

    public List<HkActionProcess> findHkActionProcessNow(Map map);

    public String findHkActionEvent(String eventId);

    public int updateHkActionState(Map map);
}
