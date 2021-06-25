package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.XlScoringItems;

/**
 * 网格-考核评分项Service接口
 * 
 * @author ruoyi
 * @date 2021-05-31
 */
public interface IXlScoringItemsService 
{
    /**
     * 查询网格-考核评分项
     * 
     * @param id 网格-考核评分项ID
     * @return 网格-考核评分项
     */
    public XlScoringItems selectXlScoringItemsById(Long id);

    /**
     * 查询网格-考核评分项列表
     * 
     * @param xlScoringItems 网格-考核评分项
     * @return 网格-考核评分项集合
     */
    public List<XlScoringItems> selectXlScoringItemsList(XlScoringItems xlScoringItems);

    /**
     * 新增网格-考核评分项
     * 
     * @param xlScoringItems 网格-考核评分项
     * @return 结果
     */
    public int insertXlScoringItems(XlScoringItems xlScoringItems);

    /**
     * 修改网格-考核评分项
     * 
     * @param xlScoringItems 网格-考核评分项
     * @return 结果
     */
    public int updateXlScoringItems(XlScoringItems xlScoringItems);

    /**
     * 批量删除网格-考核评分项
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteXlScoringItemsByIds(String ids);

    /**
     * 删除网格-考核评分项信息
     * 
     * @param id 网格-考核评分项ID
     * @return 结果
     */
    public int deleteXlScoringItemsById(Long id);
}
