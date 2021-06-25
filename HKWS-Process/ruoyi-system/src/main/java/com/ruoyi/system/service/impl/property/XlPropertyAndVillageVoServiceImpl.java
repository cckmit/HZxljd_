package com.ruoyi.system.service.impl.property;

import com.ruoyi.system.domain.XlEstateManagement;
import com.ruoyi.system.domain.property.XlPropertyAndVillageVo;
import com.ruoyi.system.mapper.XlPropertyAndVillageVoMapper;
import com.ruoyi.system.service.property.XlPropertyAndVillageVoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author FanKaibiao
 * @date 2021-06-11-11:53
 */
@Service
public class XlPropertyAndVillageVoServiceImpl implements XlPropertyAndVillageVoService {

    @Autowired
    private XlPropertyAndVillageVoMapper xlPropertyAndVillageVoMapper;

    @Override
    public List<XlPropertyAndVillageVo> queryPropertyEventList(Map<String,Object> thingResult) {
        return xlPropertyAndVillageVoMapper.queryPropertyEventList(thingResult);
    }

    @Override
    public int queryPropertyEventCount(Map<String, Object> thingResult) {
        return xlPropertyAndVillageVoMapper.queryPropertyEventCount(thingResult);
    }

    @Override
    public Integer countAllByParams(Map<String, Object> params) {
        return xlPropertyAndVillageVoMapper.countAllByParams(params);
    }

    @Override
    public int queryPropertyEndCount() {
        return xlPropertyAndVillageVoMapper.queryPropertyEndCount();
    }

    @Override
    public List<XlPropertyAndVillageVo> queryVillageEvent(Map<String, Object> paramsAll) {
        return xlPropertyAndVillageVoMapper.queryVillageEvent(paramsAll);
    }
}
