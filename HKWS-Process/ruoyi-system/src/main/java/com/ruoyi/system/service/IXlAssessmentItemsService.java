package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.XlAssessmentItems;

/**
 * 网格员--考核项Service接口
 * 
 * @author ruoyi
 * @date 2021-06-01
 */
public interface IXlAssessmentItemsService 
{
    /**
     * 查询网格员--考核项
     * 
     * @param assessmentId 网格员--考核项ID
     * @return 网格员--考核项
     */
    public XlAssessmentItems selectXlAssessmentItemsById(Long assessmentId);

    /**
     * 查询网格员--考核项列表
     * 
     * @param xlAssessmentItems 网格员--考核项
     * @return 网格员--考核项集合
     */
    public List<XlAssessmentItems> selectXlAssessmentItemsList(XlAssessmentItems xlAssessmentItems);

    /**
     * 新增网格员--考核项
     * 
     * @param xlAssessmentItems 网格员--考核项
     * @return 结果
     */
    public int insertXlAssessmentItems(XlAssessmentItems xlAssessmentItems);

    /**
     * 修改网格员--考核项
     * 
     * @param xlAssessmentItems 网格员--考核项
     * @return 结果
     */
    public int updateXlAssessmentItems(XlAssessmentItems xlAssessmentItems);

    /**
     * 批量删除网格员--考核项
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteXlAssessmentItemsByIds(String ids);

    /**
     * 删除网格员--考核项信息
     * 
     * @param assessmentId 网格员--考核项ID
     * @return 结果
     */
    public int deleteXlAssessmentItemsById(Long assessmentId);
}
