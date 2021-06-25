package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.HkAuthorizationApi;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2021-01-11
 */
public interface IHkAuthorizationApiService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param aId 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public HkAuthorizationApi selectHkAuthorizationApiById(Long aId);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param hkAuthorizationApi 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<HkAuthorizationApi> selectHkAuthorizationApiList(HkAuthorizationApi hkAuthorizationApi);

    /**
     * 新增【请填写功能名称】
     * 
     * @param hkAuthorizationApi 【请填写功能名称】
     * @return 结果
     */
    public int insertHkAuthorizationApi(HkAuthorizationApi hkAuthorizationApi);

    /**
     * 修改【请填写功能名称】
     * 
     * @param hkAuthorizationApi 【请填写功能名称】
     * @return 结果
     */
    public int updateHkAuthorizationApi(HkAuthorizationApi hkAuthorizationApi);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHkAuthorizationApiByIds(String ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param aId 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteHkAuthorizationApiById(Long aId);
}
