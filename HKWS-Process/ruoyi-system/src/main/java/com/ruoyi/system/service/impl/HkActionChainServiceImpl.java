package com.ruoyi.system.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.system.domain.Action.HkActionChain;
import com.ruoyi.system.domain.HkEarlyWarning.HkEventInfo;
import com.ruoyi.system.mapper.HkActionChainMapper;
import com.ruoyi.system.mapper.HkActionDefinitionMapper;
import com.ruoyi.system.service.HkActionChainService;
import com.ruoyi.system.service.HkEarlyWarning.HkEventService;
import com.ruoyi.system.service.ISysRegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @author FanKaibiao
 * @date 2020-12-10-1:21
 */
@Service
public class HkActionChainServiceImpl implements HkActionChainService {
    @Autowired
    private HkActionChainMapper hkActionChainMapper;

    @Autowired
    private HkActionDefinitionMapper hkActionDefinitionMapper;

    @Autowired
    private HkMapServiceImpl hkMapService;

    @Autowired
    private HkEventService hkEventService;

    @Autowired
    private ISysRegionService iSysRegionService;

    @Override
    public List<HkActionChain> findActionChain(HkActionChain hkActionChain) {
        return hkActionChainMapper.findActionChain(hkActionChain);
    }

    @Override
    public List<HkActionChain> findHkActionChain(HkActionChain hkActionChain) {
        return hkActionChainMapper.findHkActionChain(hkActionChain);
    }

    @Override
    public void insertActionChain(HkActionChain hkActionChain) {
        hkActionChainMapper.insertActionChain(hkActionChain);
    }

    @Override
    public HkActionChain findActionChainByRegionEventType(String regionCode,String eventType) {
        return hkActionChainMapper.findActionChainByRegionEventType(regionCode,eventType);
    }

    @Override
    public List<HkActionChain> queryHkActionChain(HkActionChain hkActionChain) {
        return hkActionChainMapper.queryHkActionChain(hkActionChain);
    }

    @Override
    public int insertHkActionChain(HkActionChain hkActionChain) {
        return hkActionChainMapper.insertHkActionChain(hkActionChain);
    }

    @Override
    @Transactional
    public int deleteHKActionChain(String actionChainId) {
        String [] arrayId = Convert.toStrArray(actionChainId);
        int count=hkActionChainMapper.deleteHKAconfiguration(arrayId);
        int num = hkActionDefinitionMapper.deleteDefinitionByChainIds(arrayId);
        if (count > 0 && num > 0){
            return 1;
        }else {
            throw new RuntimeException("删除行动链失败，请联系管理人员");
        }
    }

    @Override
    public HkActionChain selectHKActionChain(String actionChainId) {
        return hkActionChainMapper.selectHKActionChain(actionChainId);
    }

    @Override
    public int deleteActionChains(HkActionChain hkActionChain) {
        return hkActionChainMapper.deleteActionChains(hkActionChain);
    }

    @Override
    public String selectChainId(HkActionChain hkActionChain) {
        return hkActionChainMapper.selectChainId(hkActionChain);
    }

    @Override
    public HkActionChain findChain(Integer id) {
        return hkActionChainMapper.findChain(id);
    }

    @Override
    public int findChainOnly(HkActionChain hkActionChain) {
        return hkActionChainMapper.findChainOnly(hkActionChain);
    }

    @Override
    public int updateChain(HkActionChain hkActionChain) {
        return hkActionChainMapper.updateChain(hkActionChain);
    }


    /**
     * 根据 经纬度、事件类型查 行动链
     * @param hkEventInfo
     * @return
     */
    @Override
    public HkActionChain setActionIdByComponentAndLongitude(HkEventInfo hkEventInfo) {
        Double[] points = {Double.parseDouble(hkEventInfo.getLongitude()), Double.parseDouble(hkEventInfo.getLatitude())};
        Map<String, Object> stringObjectMap = hkMapService.calculateRegionByLongitudeAndLatitude(points);
        String regionId = String.valueOf(stringObjectMap.get("regionId"));
        String regionName = String.valueOf(stringObjectMap.get("regionName"));
        HkActionChain chain = new HkActionChain();
        chain.setActionStandard(hkEventInfo.getComponentId());
        if(hkEventInfo.getComponentId().equals("1002")){
            regionId = iSysRegionService.selectSysRegionById(new Long(regionId)).getParentId();
            regionName = iSysRegionService.selectSysRegionById(new Long(regionId)).getRegionName();
        }
        chain.setActionRegionCode(regionId);
        chain.setActionRegion(regionName);
        List<HkActionChain> hkActionChainsList = queryHkActionChain(chain);
        if(hkActionChainsList.size() == 0) return null;
        HkActionChain hkActionChain = hkActionChainsList.get(0);
        return hkActionChain;
    }

    @Override
    public HkActionChain selectActionChainByName(String actionName) {
        return hkActionChainMapper.selectActionChainByName(actionName);
    }

}
