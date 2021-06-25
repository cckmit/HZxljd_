package com.ruoyi.quartz.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.quartz.domain.HkSourceFieldFilter;
import com.ruoyi.quartz.mapper.HkSourceFieldFilterMapper;
import com.ruoyi.quartz.service.IHkSourceFieldFilterService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-01-22
 */
@Service
public class HkSourceFieldFilterServiceImpl implements IHkSourceFieldFilterService 
{
    @Autowired
    private HkSourceFieldFilterMapper hkSourceFieldFilterMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public HkSourceFieldFilter selectHkSourceFieldFilterById(Long id)
    {
        return hkSourceFieldFilterMapper.selectHkSourceFieldFilterById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param hkSourceFieldFilter 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<HkSourceFieldFilter> selectHkSourceFieldFilterList(HkSourceFieldFilter hkSourceFieldFilter)
    {
        return hkSourceFieldFilterMapper.selectHkSourceFieldFilterList(hkSourceFieldFilter);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param hkSourceFieldFilter 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertHkSourceFieldFilter(HkSourceFieldFilter hkSourceFieldFilter)
    {
        return hkSourceFieldFilterMapper.insertHkSourceFieldFilter(hkSourceFieldFilter);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param hkSourceFieldFilter 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateHkSourceFieldFilter(HkSourceFieldFilter hkSourceFieldFilter)
    {
        return hkSourceFieldFilterMapper.updateHkSourceFieldFilter(hkSourceFieldFilter);
    }

    /**
     * 删除【请填写功能名称】对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteHkSourceFieldFilterByIds(String ids)
    {
        return hkSourceFieldFilterMapper.deleteHkSourceFieldFilterByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteHkSourceFieldFilterById(Long id)
    {
        return hkSourceFieldFilterMapper.deleteHkSourceFieldFilterById(id);
    }
}
