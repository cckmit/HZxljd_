package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.Action.HkActionDefinition;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author FanKaibiao
 * @date 2020-12-10-1:05
 */
public interface HkActionDefinitionMapper {

    /**
     * 根据流程唯一标识查询指派人
     * @param hkActionDefinition
     * @return
     */
    List<HkActionDefinition> findDefinitionByChainId(HkActionDefinition hkActionDefinition);

    /**
     * 根据流程唯一标识查询指派人
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
     * 删除上一步添加的用户
     * @param hkActionDefinition
     * @return
     */
    int deleteDefinition(HkActionDefinition hkActionDefinition);

    /**
     * 上一步 删除节点2的人
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


    List<Map<String,Object>> selectDefinitionAndConfigAndSysUser(@Param("actionChainId") String actionChainId, @Param("actionRegion") String actionRegion);

    //批量新增行动链定义
    int insertHkActionDeByList(@Param("list")List<HkActionDefinition> list);

    //根据行动链id批量删除
    int deleteDefinitionByChainIds(String[] array);
}
