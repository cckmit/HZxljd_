package com.ruoyi.system.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.system.domain.HkAConfiguration;
import com.ruoyi.system.mapper.HkAConfigurationMapper;
import com.ruoyi.system.service.HkAConfigurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HkAConfigurationServiceImpl implements HkAConfigurationService {

    @Autowired(required = false)
    private HkAConfigurationMapper aConfigurationMapper;

    /**
     * 查询事件类型下有没有行动配置
     * @param ids
     * @return
     */
    @Override
    public int countHkAConfiguration(String ids) {
        return aConfigurationMapper.countHkAConfiguration(ids);
    }

    /**
     * 查询行动配置数据
     * @param hkAConfiguration
     * @return
     */
    @Override
    public List<HkAConfiguration> selectRoleList(HkAConfiguration hkAConfiguration) {
        return aConfigurationMapper.selectRoleList(hkAConfiguration);
    }

    /**
     * 判断行动名称是否唯一
     * @param hkAConfiguration
     * @return
     */
    @Override
    public int checkRoleAllowed(HkAConfiguration hkAConfiguration) {
        return aConfigurationMapper.checkRoleAllowed(hkAConfiguration);
    }

    /**
     * 添加行动配置
     * @param hkAConfiguration
     * @return
     */
    @Override
    public int addHKAconfiguration(HkAConfiguration hkAConfiguration) {
        return aConfigurationMapper.addHKAconfiguration(hkAConfiguration);
    }

    /**
     * 查询行动源数据
     * @param uuid
     * @return
     */
    @Override
    public HkAConfiguration findHKAconfiguration(String uuid) {
        return aConfigurationMapper.findHKAconfiguration(uuid);
    }

    /**
     * 回显数据
     * @param id
     * @return
     */
    @Override
    public HkAConfiguration selecAConfiguration(Integer id) {
        return aConfigurationMapper.selecAConfiguration(id);
    }

    /**
     * 修改行动数据
     * @param hkAConfiguration
     * @return
     */
    @Override
    public int editHKAconfiguration(HkAConfiguration hkAConfiguration) {
        return aConfigurationMapper.editHKAconfiguration(hkAConfiguration);
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @Override
    public int deleteHKAconfiguration(String ids) {
        int count=aConfigurationMapper.deleteHKAconfiguration(Convert.toStrArray(ids));
        return count;
    }

    @Override
    public List<HkAConfiguration> findActionConfiguration() {
        return aConfigurationMapper.findActionConfiguration();
    }

    @Override
    public String findKey(String actionName) {
        return aConfigurationMapper.findKey(actionName);
    }

    /**
     * 判断事件类型唯一
     * @param hkAConfiguration
     * @return
     */
    @Override
    public int checkTypeAllowed(HkAConfiguration hkAConfiguration) {
        return aConfigurationMapper.checkTypeAllowed(hkAConfiguration);
    }

    @Override
    public List<HkAConfiguration> findEventTypeName(String eventTypeName) {
        return aConfigurationMapper.findEventTypeName(eventTypeName);
    }

    @Override
    public List<HkAConfiguration> findaConfiguration() {
        return aConfigurationMapper.findaConfiguration();
    }

    @Override
    public List<HkAConfiguration> findActionStandard(HkAConfiguration hkAConfiguration) {
        return aConfigurationMapper.findActionStandard(hkAConfiguration);
    }

    @Override
    public HkAConfiguration findConfigurationName(String actionStandardId) {
        return aConfigurationMapper.findConfigurationName(actionStandardId);
    }
}
