package com.ruoyi.system.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.CacheUtils;
import com.ruoyi.system.domain.HkAManagement;
import com.ruoyi.system.mapper.HkAManagementMapper;
import com.ruoyi.system.service.HkAManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HkAManagementServiceImpl implements HkAManagementService {

    @Autowired(required = false)
    private HkAManagementMapper aManagementMapper;

    @Override
    public List<HkAManagement> selectRoleList(HkAManagement hkAManagement) {

        return aManagementMapper.selectRoleList(hkAManagement);
    }

    @Override
    public int addHkAManagement(HkAManagement hkAManagement) {
        return aManagementMapper.addHkAManagement(hkAManagement);
    }

    @Override
    public int deleteHKAconfiguration(String ids) {
        int count=aManagementMapper.deleteConfigByIds(Convert.toStrArray(ids));
        return count;
    }
    /**
     * 获取cache name
     *
     * @return 缓存名
     */
    private String getCacheName()
    {
        return Constants.SYS_CONFIG_CACHE;
    }

}
