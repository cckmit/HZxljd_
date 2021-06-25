package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.XlAssessmentItemsMapper;
import com.ruoyi.system.domain.XlAssessmentItems;
import com.ruoyi.system.service.IXlAssessmentItemsService;
import com.ruoyi.common.core.text.Convert;

/**
 * 网格员--考核项Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-06-01
 */
@Service
public class XlAssessmentItemsServiceImpl implements IXlAssessmentItemsService 
{
    @Autowired
    private XlAssessmentItemsMapper xlAssessmentItemsMapper;

    /**
     * 查询网格员--考核项
     * 
     * @param assessmentId 网格员--考核项ID
     * @return 网格员--考核项
     */
    @Override
    public XlAssessmentItems selectXlAssessmentItemsById(Long assessmentId)
    {
        return xlAssessmentItemsMapper.selectXlAssessmentItemsById(assessmentId);
    }

    /**
     * 查询网格员--考核项列表
     * 
     * @param xlAssessmentItems 网格员--考核项
     * @return 网格员--考核项
     */
    @Override
    public List<XlAssessmentItems> selectXlAssessmentItemsList(XlAssessmentItems xlAssessmentItems)
    {
        return xlAssessmentItemsMapper.selectXlAssessmentItemsList(xlAssessmentItems);
    }

    /**
     * 新增网格员--考核项
     * 
     * @param xlAssessmentItems 网格员--考核项
     * @return 结果
     */
    @Override
    public int insertXlAssessmentItems(XlAssessmentItems xlAssessmentItems)
    {
        return xlAssessmentItemsMapper.insertXlAssessmentItems(xlAssessmentItems);
    }

    /**
     * 修改网格员--考核项
     * 
     * @param xlAssessmentItems 网格员--考核项
     * @return 结果
     */
    @Override
    public int updateXlAssessmentItems(XlAssessmentItems xlAssessmentItems)
    {
        return xlAssessmentItemsMapper.updateXlAssessmentItems(xlAssessmentItems);
    }

    /**
     * 删除网格员--考核项对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteXlAssessmentItemsByIds(String ids)
    {
        return xlAssessmentItemsMapper.deleteXlAssessmentItemsByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除网格员--考核项信息
     * 
     * @param assessmentId 网格员--考核项ID
     * @return 结果
     */
    @Override
    public int deleteXlAssessmentItemsById(Long assessmentId)
    {
        return xlAssessmentItemsMapper.deleteXlAssessmentItemsById(assessmentId);
    }
}
