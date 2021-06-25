package com.ruoyi.system.service;

import com.ruoyi.system.domain.Action.HkActionChain;
import com.ruoyi.system.domain.Action.HkActionDefinition;

import java.util.List;
import java.util.Map;

/**
 * @author FanKaibiao
 * @date 2020-12-10-0:51
 */
public interface HkActionDefinitionService {
    /**
     * 查看这条事件的处理人
     * @param hkActionDefinition
     * @return
     */
    List<HkActionDefinition> findDefinitionByChainId(HkActionDefinition hkActionDefinition);

    /**
     * 查看这条事件的处理人
     * @param hkActionDefinition
     * @return
     */
    List<HkActionDefinition> findDefinitionByHandlerOrder(HkActionDefinition hkActionDefinition);

    /**
     * 添加行动链定义表
     * @param hkActionDefinition
     */
    int insertHkActionDe(HkActionDefinition hkActionDefinition);

    /**
     * 删除上一个添加的用户
     * @param hkActionDefinition
     * @return
     */
    int deleteDefinition(HkActionDefinition hkActionDefinition);

    /**
     * 上一步删除节点2的用户
     * @param hkActionDefinition
     * @return
     */
    int deleteDefinitionTwo(HkActionDefinition hkActionDefinition);

    /**
     * 修改行动链定义表
     * @param hkActionDefinition
     * @return
     */
    int updateDefinition(HkActionDefinition hkActionDefinition);


    //根据行动链id获取处理人和标准动作
    List<Map<String,Object>> selectDefinitionAndConfigAndSysUser(String actionChainId, String actionRegion);

    //新增行动链和行动链定义
    boolean addHkActionChainAndDetailed(HkActionChain hkActionChain, List<HkActionDefinition> definitionList);

    //修改新动链和行动链定义
    boolean updateHkActionChainAndDetailed(HkActionChain hkActionChain, List<HkActionDefinition> definitionList);
}
