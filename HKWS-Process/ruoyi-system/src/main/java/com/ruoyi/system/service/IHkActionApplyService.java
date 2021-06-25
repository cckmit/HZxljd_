package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.HkActionApply;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2021-01-12
 */
public interface IHkActionApplyService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param acId 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public HkActionApply selectHkActionApplyById(Long acId);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param hkActionApply 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<HkActionApply> selectHkActionApplyList(HkActionApply hkActionApply);

    /**
     * 新增【请填写功能名称】
     * 
     * @param hkActionApply 【请填写功能名称】
     * @return 结果
     */
    public int insertHkActionApply(HkActionApply hkActionApply);

    /**
     * 修改【请填写功能名称】
     * 
     * @param hkActionApply 【请填写功能名称】
     * @return 结果
     */
    public int updateHkActionApply(HkActionApply hkActionApply);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHkActionApplyByIds(String ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param acId 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteHkActionApplyById(Long acId);
}
