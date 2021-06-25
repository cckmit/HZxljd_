package com.ruoyi.quartz.service;

import java.util.List;

import com.ruoyi.quartz.domain.HkSourceFieldFilter;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2021-01-22
 */
public interface IHkSourceFieldFilterService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public HkSourceFieldFilter selectHkSourceFieldFilterById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param hkSourceFieldFilter 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<HkSourceFieldFilter> selectHkSourceFieldFilterList(HkSourceFieldFilter hkSourceFieldFilter);

    /**
     * 新增【请填写功能名称】
     * 
     * @param hkSourceFieldFilter 【请填写功能名称】
     * @return 结果
     */
    public int insertHkSourceFieldFilter(HkSourceFieldFilter hkSourceFieldFilter);

    /**
     * 修改【请填写功能名称】
     * 
     * @param hkSourceFieldFilter 【请填写功能名称】
     * @return 结果
     */
    public int updateHkSourceFieldFilter(HkSourceFieldFilter hkSourceFieldFilter);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHkSourceFieldFilterByIds(String ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteHkSourceFieldFilterById(Long id);
}
