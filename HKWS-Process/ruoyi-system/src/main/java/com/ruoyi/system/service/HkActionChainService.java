package com.ruoyi.system.service;

import com.ruoyi.system.domain.Action.HkActionChain;
import com.ruoyi.system.domain.HkEarlyWarning.HkEventInfo;

import java.util.List;

/**
 * @author FanKaibiao
 * @date 2020-12-10-1:17
 */
public interface HkActionChainService {
    /**
     * 根据事件的类型和事件的区域查询行动链
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
     * 根据区域和事件类别查询行动链
     * @param regionCode
     * @param eventType
     * @return
     */
    HkActionChain findActionChainByRegionEventType(String regionCode,String eventType);

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
     * 删除
     * @param actionChainId
     * @return
     */
    int deleteHKActionChain(String actionChainId);

    /**
     * 根据标识查
     * @param actionChainId
     * @return
     */
    HkActionChain selectHKActionChain(String actionChainId);

    /**
     * 上一步时删除上一条信息
     * @param hkActionChain
     * @return
     */
    int deleteActionChains(HkActionChain hkActionChain);

    /**
     * 查询行动链的id
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
     * 修改时判断是否是唯一的
     * @param hkActionChain
     * @return
     */
    int findChainOnly(HkActionChain hkActionChain);


    /**
     * 修改行动链
     * @param hkActionChain
     */
    int updateChain(HkActionChain hkActionChain);

    /**
     * 查询行动链 根据事件类型和事件经纬度查询
     * @param
     * @return
     */
    HkActionChain setActionIdByComponentAndLongitude(HkEventInfo hkEventInfo);


    HkActionChain selectActionChainByName(String actionName);
}
