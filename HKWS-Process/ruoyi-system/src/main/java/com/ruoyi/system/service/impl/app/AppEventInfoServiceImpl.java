package com.ruoyi.system.service.impl.app;

import com.ruoyi.system.domain.Action.HkActionProcess;
import com.ruoyi.system.domain.app.WxHkEventVo;
import com.ruoyi.system.domain.app.appHkevent;
import com.ruoyi.system.mapper.HkActionProcessMapper;
import com.ruoyi.system.mapper.appEventInfoMapper;
import com.ruoyi.system.service.app.AppEventInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

/**
 * @program: data-ruoyi
 * @description: app-事件概要查询
 * @author: Yang-Teng-Fei
 * @create: 2020-12-10 13:02
 **/
@Service
public class AppEventInfoServiceImpl implements AppEventInfoService {

    @Autowired
    private appEventInfoMapper appEventInfoMapper;

    @Autowired
    private HkActionProcessMapper hkActionProcessMapper;
    /**
     * 查询事件概要查询
     * @param map
     * @return
     */
    @Override
    public List<appHkevent> selectOneHkevent(Map map) {
        return appEventInfoMapper.selectOneHkevent(map);
    }
    /**
     * 查询已逾期事件概要查询
     * @param map
     * @return
     */
    @Override
    public List<appHkevent> selectOverduEvent(Map map) {
        return appEventInfoMapper.selectOverduEvent(map);
    }

    @Override
    public List<appHkevent> selectTwoHkEvent(WxHkEventVo vo) {
        return appEventInfoMapper.selectTwoHkEvent(vo);
    }

    /**
     * 查询已完成事件概要查询
     * @param map
     * @return
     */
    @Override
    public List<appHkevent> selectCompletedEvent(Map map) {
        return appEventInfoMapper.selectCompletedEvent(map);
    }

    /**
     * 判断登陆人事件处理完成
     * @param map
     * @return
     */
    @Override
    public HkActionProcess findHkActionProcess(Map map) {
        return appEventInfoMapper.findHkActionProcess(map);
    }

    @Override
    public String findHkActionEvent(String eventId) {
        return appEventInfoMapper.findHkActionEvent(eventId);
    }

    @Override
    public HkActionProcess findHkActionProcessNow(Map<String, Object> param) {
        /**查询当前用户同一事件流程中，最新的处理流程（若该事件中该用户拥有多个处理流程）**/
        List<HkActionProcess> list = appEventInfoMapper.findHkActionProcessNow(param);
        HkActionProcess actionProcess = null;
        if(list.size() > 1){
            list.sort(Comparator.comparing(HkActionProcess::getCreateTime).reversed());
            for(HkActionProcess process : list){
                /**获取第一条未完成的流程，若无，则获取最新一条流程信息**/
                if(0 == process.getIsComplete()){
                    actionProcess = process;
                    break;
                }
            }
            if(actionProcess == null){
                actionProcess =  list.get(list.size()-1);
            }
        }else{
            actionProcess = list.get(0);
        }
        return actionProcess;
    }
}
