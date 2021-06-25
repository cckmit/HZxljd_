package com.ruoyi.system.service;

import com.ruoyi.system.domain.HkAConfiguration;

import java.util.List;

/**
 * 行动配置
 */
public interface HkAConfigurationService {
 /**
  * 查询事件类型下有没有行动配置
  * @param ids
  * @return
  */
 public int countHkAConfiguration(String ids);
    /**
     * 查询行动配置数据
      * @param hkAConfiguration
     * @return
     */
   public List<HkAConfiguration> selectRoleList(HkAConfiguration hkAConfiguration);

    /**
     * 判断行动名称唯一
     * @param hkAConfiguration
     * @return
     */
    public int checkRoleAllowed(HkAConfiguration hkAConfiguration);

    /**
     * 添加行动配置
     * @param hkAConfiguration
     * @return
     */
    public int addHKAconfiguration(HkAConfiguration hkAConfiguration);

    /**
     * 查询数据
     * @param uuid
     * @return
     */
    public HkAConfiguration findHKAconfiguration(String uuid);

    /**
     * 回显数据
     * @param id
     */
   public HkAConfiguration selecAConfiguration(Integer id);

    /**
     * 修改数据
     * @param hkAConfiguration
     * @return
     */
   public int editHKAconfiguration(HkAConfiguration hkAConfiguration);

    /**
     * 批量删除
     * @param ids
     * @return
     */
   public int deleteHKAconfiguration(String ids);


    /**
     * 创建行动链 获取类型
     * @return
     */
    List<HkAConfiguration> findActionConfiguration();

    /**
     * 获取行动编号
     * @param actionName
     * @return
     */
    String findKey(String actionName);

    /**
     * 判断事件类型唯一
     * @param hkAConfiguration
     * @return
     */
    public int checkTypeAllowed(HkAConfiguration hkAConfiguration);

    /**
     * 查询是否有 事件类型
     * @param eventTypeName
     * @return
     */
    List<HkAConfiguration> findEventTypeName(String eventTypeName);

    /**
     * 查询标准动作
     * @return
     */
    List<HkAConfiguration> findaConfiguration();

    /**
     * 查询标准动作信息
     * @param hkAConfiguration
     * @return
     */
    List<HkAConfiguration> findActionStandard(HkAConfiguration hkAConfiguration);
    //查询标准动作名称
    HkAConfiguration findConfigurationName(String actionStandardId);
}
