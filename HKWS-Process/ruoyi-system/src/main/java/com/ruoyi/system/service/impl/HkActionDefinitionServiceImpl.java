package com.ruoyi.system.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.system.domain.Action.HkActionChain;
import com.ruoyi.system.domain.Action.HkActionDefinition;
import com.ruoyi.system.mapper.HkActionChainMapper;
import com.ruoyi.system.mapper.HkActionDefinitionMapper;
import com.ruoyi.system.service.HkActionDefinitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @author FanKaibiao
 * @date 2020-12-10-0:59
 */
@Service
public class HkActionDefinitionServiceImpl implements HkActionDefinitionService {

    @Autowired
    private HkActionDefinitionMapper hkActionDefinitionMapper;

    @Autowired
    private HkActionChainMapper hkActionChainMapper;

    @Override
    public List<HkActionDefinition> findDefinitionByChainId(HkActionDefinition hkActionDefinition) {
        return hkActionDefinitionMapper.findDefinitionByChainId(hkActionDefinition);
    }

    @Override
    public List<HkActionDefinition> findDefinitionByHandlerOrder(HkActionDefinition hkActionDefinition) {
        return hkActionDefinitionMapper.findDefinitionByHandlerOrder(hkActionDefinition);
    }

    @Override
    public int insertHkActionDe(HkActionDefinition hkActionDefinition) {
        return hkActionDefinitionMapper.insertHkActionDe(hkActionDefinition);
    }

    @Override
    public int deleteDefinition(HkActionDefinition hkActionDefinition) {
        return hkActionDefinitionMapper.deleteDefinition(hkActionDefinition);
    }

    @Override
    public int deleteDefinitionTwo(HkActionDefinition hkActionDefinition) {
        return hkActionDefinitionMapper.deleteDefinitionTwo(hkActionDefinition);
    }

    @Override
    public int updateDefinition(HkActionDefinition hkActionDefinition) {
        return hkActionDefinitionMapper.updateDefinition(hkActionDefinition);
    }

    /**
     * 根据行动链id获取处理人和标准动作
     * @param actionChainId
     * @param actionRegion
     * @return
     */
    @Override
    public List<Map<String, Object>> selectDefinitionAndConfigAndSysUser(String actionChainId, String actionRegion) {
        return hkActionDefinitionMapper.selectDefinitionAndConfigAndSysUser(actionChainId,actionRegion);
    }

    /**
     * 新增行动链和行动链定义
     * @param hkActionChain
     * @param definitionList
     * @return
     */
    @Override
    @Transactional
    public boolean addHkActionChainAndDetailed(HkActionChain hkActionChain, List<HkActionDefinition> definitionList) {
        int num1 = hkActionChainMapper.insertHkActionChain(hkActionChain);
        int num2 = hkActionDefinitionMapper.insertHkActionDeByList(definitionList);
        if (num1 > 0 && num2 > 0){
            return true;
        }else {
            throw new RuntimeException("新增行动链和行动链定义异常，请联系管理人员。");
        }
    }

    /**
     * 修改行动链和行动链定义
     * @param hkActionChain
     * @param definitionList
     * @return
     */
    @Override
    @Transactional
    public boolean updateHkActionChainAndDetailed(HkActionChain hkActionChain, List<HkActionDefinition> definitionList) {
        //修改行动链定义  --先删除再新增
        int num1 = hkActionDefinitionMapper.deleteDefinitionByChainIds(Convert.toStrArray(hkActionChain.getActionChainId()));
        int num2 = hkActionDefinitionMapper.insertHkActionDeByList(definitionList);
        //修改行动链
        int num3 = hkActionChainMapper.updateHkActionChain(hkActionChain);
        if (num1 > 0 && num2 > 0 && num3 > 0){
            return true;
        }else {
            throw new RuntimeException("修改行动链失败，请联系管理人员");
        }
    }
}
