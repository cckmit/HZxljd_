package com.ruoyi.system.service.property;

import com.ruoyi.system.domain.XlEstateManagement;
import com.ruoyi.system.domain.property.XlPropertyAndVillageVo;

import java.util.List;
import java.util.Map;

/**
 * @author FanKaibiao
 * @date 2021-06-11-11:51
 */
public interface XlPropertyAndVillageVoService {
    //查询物业事件
    List<XlPropertyAndVillageVo> queryPropertyEventList(Map<String,Object> thingResult);
    //查询物业总事件
    int queryPropertyEventCount(Map<String, Object> thingResult);
    //查询物业各类事件数量
    Integer countAllByParams(Map<String, Object> params);
    //查询已处理数
    int queryPropertyEndCount();
    //查询各小区发生的事件
    List<XlPropertyAndVillageVo> queryVillageEvent(Map<String, Object> paramsAll);
}
