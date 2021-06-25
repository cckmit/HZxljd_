package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.HkAuthorizationApiMapper;
import com.ruoyi.system.domain.HkAuthorizationApi;
import com.ruoyi.system.service.IHkAuthorizationApiService;
import com.ruoyi.common.core.text.Convert;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-01-11
 */
@Service
public class HkAuthorizationApiServiceImpl implements IHkAuthorizationApiService 
{
    @Autowired
    private HkAuthorizationApiMapper hkAuthorizationApiMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param aId 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public HkAuthorizationApi selectHkAuthorizationApiById(Long aId)
    {
        return hkAuthorizationApiMapper.selectHkAuthorizationApiById(aId);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param hkAuthorizationApi 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<HkAuthorizationApi> selectHkAuthorizationApiList(HkAuthorizationApi hkAuthorizationApi)
    {
        return hkAuthorizationApiMapper.selectHkAuthorizationApiList(hkAuthorizationApi);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param hkAuthorizationApi 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertHkAuthorizationApi(HkAuthorizationApi hkAuthorizationApi)
    {
        return hkAuthorizationApiMapper.insertHkAuthorizationApi(hkAuthorizationApi);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param hkAuthorizationApi 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateHkAuthorizationApi(HkAuthorizationApi hkAuthorizationApi)
    {
        return hkAuthorizationApiMapper.updateHkAuthorizationApi(hkAuthorizationApi);
    }

    /**
     * 删除【请填写功能名称】对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteHkAuthorizationApiByIds(String ids)
    {
        return hkAuthorizationApiMapper.deleteHkAuthorizationApiByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param aId 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteHkAuthorizationApiById(Long aId)
    {
        return hkAuthorizationApiMapper.deleteHkAuthorizationApiById(aId);
    }
}
