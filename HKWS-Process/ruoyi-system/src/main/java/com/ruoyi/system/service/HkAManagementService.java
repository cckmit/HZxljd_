package com.ruoyi.system.service;

import com.ruoyi.system.domain.HkAConfiguration;
import com.ruoyi.system.domain.HkAManagement;

import java.util.List;

public interface HkAManagementService {
    /**
     * 查询授权管理数据
     * @param hkAManagement
     * @return
     */
    public List<HkAManagement> selectRoleList(HkAManagement hkAManagement);

    /**
     * 添加授权管理数据
     * @param hkAManagement
     * @return
     */
    public int addHkAManagement(HkAManagement hkAManagement);


    int deleteHKAconfiguration(String ids);
}
