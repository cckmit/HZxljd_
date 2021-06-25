package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.XlApplyInspectionMapper;
import com.ruoyi.system.domain.XlApplyInspection;
import com.ruoyi.system.service.IXlApplyInspectionService;
import com.ruoyi.common.core.text.Convert;

/**
 * 网格管理-检查组应用Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-06-04
 */
@Service
public class XlApplyInspectionServiceImpl implements IXlApplyInspectionService 
{
    @Autowired
    private XlApplyInspectionMapper xlApplyInspectionMapper;

    /**
     * 查询网格管理-检查组应用
     * 
     * @param id 网格管理-检查组应用ID
     * @return 网格管理-检查组应用
     */
    @Override
    public XlApplyInspection selectXlApplyInspectionById(Long id)
    {
        return xlApplyInspectionMapper.selectXlApplyInspectionById(id);
    }

    /**
     * 查询网格管理-检查组应用列表
     * 
     * @param xlApplyInspection 网格管理-检查组应用
     * @return 网格管理-检查组应用
     */
    @Override
    public List<XlApplyInspection> selectXlApplyInspectionList(XlApplyInspection xlApplyInspection)
    {
        return xlApplyInspectionMapper.selectXlApplyInspectionList(xlApplyInspection);
    }

    /**
     * 新增网格管理-检查组应用
     * 
     * @param xlApplyInspection 网格管理-检查组应用
     * @return 结果
     */
    @Override
    public int insertXlApplyInspection(XlApplyInspection xlApplyInspection)
    {
        return xlApplyInspectionMapper.insertXlApplyInspection(xlApplyInspection);
    }

    /**
     * 修改网格管理-检查组应用
     * 
     * @param xlApplyInspection 网格管理-检查组应用
     * @return 结果
     */
    @Override
    public int updateXlApplyInspection(XlApplyInspection xlApplyInspection)
    {
        return xlApplyInspectionMapper.updateXlApplyInspection(xlApplyInspection);
    }

    /**
     * 删除网格管理-检查组应用对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteXlApplyInspectionByIds(String ids)
    {
        return xlApplyInspectionMapper.deleteXlApplyInspectionByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除网格管理-检查组应用信息
     * 
     * @param id 网格管理-检查组应用ID
     * @return 结果
     */
    @Override
    public int deleteXlApplyInspectionById(Long id)
    {
        return xlApplyInspectionMapper.deleteXlApplyInspectionById(id);
    }
}
