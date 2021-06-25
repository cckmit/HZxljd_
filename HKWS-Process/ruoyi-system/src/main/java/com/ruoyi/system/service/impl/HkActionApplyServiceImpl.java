package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.HkActionApplyMapper;
import com.ruoyi.system.domain.HkActionApply;
import com.ruoyi.system.service.IHkActionApplyService;
import com.ruoyi.common.core.text.Convert;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-01-12
 */
@Service
public class HkActionApplyServiceImpl implements IHkActionApplyService 
{
    @Autowired
    private HkActionApplyMapper hkActionApplyMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param acId 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public HkActionApply selectHkActionApplyById(Long acId)
    {
        return hkActionApplyMapper.selectHkActionApplyById(acId);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param hkActionApply 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<HkActionApply> selectHkActionApplyList(HkActionApply hkActionApply)
    {
        return hkActionApplyMapper.selectHkActionApplyList(hkActionApply);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param hkActionApply 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertHkActionApply(HkActionApply hkActionApply)
    {
        return hkActionApplyMapper.insertHkActionApply(hkActionApply);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param hkActionApply 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateHkActionApply(HkActionApply hkActionApply)
    {
        return hkActionApplyMapper.updateHkActionApply(hkActionApply);
    }

    /**
     * 删除【请填写功能名称】对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteHkActionApplyByIds(String ids)
    {
        return hkActionApplyMapper.deleteHkActionApplyByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param acId 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteHkActionApplyById(Long acId)
    {
        return hkActionApplyMapper.deleteHkActionApplyById(acId);
    }
}
