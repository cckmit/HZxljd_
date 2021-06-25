package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.Action.HkActionChain;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author FanKaibiao
 * @date 2020-12-10-1:22
 */
public interface HkActionChainMapper {
    /**
     * 根据事件的类别和事件的区域进行查询行动链
     * @param hkActionChain
     * @return
     */
    List<HkActionChain> findActionChain(HkActionChain hkActionChain);

    /**
     * 查询行动链列表
     * @param hkActionChain
     * @return
     */
    List<HkActionChain> findHkActionChain(HkActionChain hkActionChain);

    /**
     * 添加行动链
     * @param hkActionChain
     * @return
     */
    void insertActionChain(HkActionChain hkActionChain);

    /**
     * 查询行动链
     * @return
     */
    HkActionChain findActionChainByRegionEventType(@Param("regionCode") String regionCode,@Param("eventType") String eventType);

    /**
     * 查询行动链id
     * @param hkActionChain
     * @return
     */
    List<HkActionChain> queryHkActionChain(HkActionChain hkActionChain);

    /**
     * 添加行动链基本信息
     * @param hkActionChain
     * @return
     */
    int insertHkActionChain(HkActionChain hkActionChain);

    /**
     * 批量删除
     * @param toStrArray
     * @return
     */
    int deleteHKAconfiguration(String[] toStrArray);

    /**
     * 上一步 删除上一次数据
     * @param hkActionChain
     * @return
     */
    int deleteActionChains(HkActionChain hkActionChain);

    /**
     * 查询行动链id
     * @param hkActionChain
     * @return
     */
    String selectChainId(HkActionChain hkActionChain);

    /**
     * 查询行动链信息
     * @param id
     * @return
     */
    HkActionChain findChain(Integer id);

    /**
     * 修改时判断是否唯一
     * @param hkActionChain
     * @return
     */
    int findChainOnly(HkActionChain hkActionChain);

    /**
     * 修改行动链
     * @param hkActionChain
     */
    int updateChain(HkActionChain hkActionChain);

    HkActionChain selectActionChainByName(@Param("actionName") String actionName);

    /**
     * 修改行动链
     *
     * @param hkActionChain
     * @return 结果
     */
    public int updateHkActionChain(HkActionChain hkActionChain);

    HkActionChain selectHKActionChain(String actionChainId);
}
