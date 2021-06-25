package com.ruoyi.system.mapper;


import com.ruoyi.system.domain.HkAConfiguration;
import com.ruoyi.system.domain.HkAManagement;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface HkAManagementMapper {

    /**
     * 、查询授权管理数据
     * @param hkAManagement
     * @return
     */

    public List<HkAManagement> selectRoleList(HkAManagement hkAManagement);

    /**
     * 添加授权信息
     * @param hkAManagement
     * @return
     */
    public int addHkAManagement(HkAManagement hkAManagement);


    int deleteConfigByIds(String[] ids);
}
