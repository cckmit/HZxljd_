package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.XlCheckItems;

/**
 * 网格员--检查项信息Service接口
 * 
 * @author ruoyi
 * @date 2021-05-24
 */
public interface IXlCheckItemsService 
{
    /**
     * 查询网格员--检查项信息
     * 
     * @param checkId 网格员--检查项信息ID
     * @return 网格员--检查项信息
     */
    public XlCheckItems selectXlCheckItemsById(Long checkId);

    /**
     * 查询网格员--检查项信息列表
     * 
     * @param xlCheckItems 网格员--检查项信息
     * @return 网格员--检查项信息集合
     */
    public List<XlCheckItems> selectXlCheckItemsList(XlCheckItems xlCheckItems);

    /**
     * 新增网格员--检查项信息
     * 
     * @param xlCheckItems 网格员--检查项信息
     * @return 结果
     */
    public int insertXlCheckItems(XlCheckItems xlCheckItems);

    /**
     * 修改网格员--检查项信息
     * 
     * @param xlCheckItems 网格员--检查项信息
     * @return 结果
     */
    public int updateXlCheckItems(XlCheckItems xlCheckItems);

    /**
     * 批量删除网格员--检查项信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteXlCheckItemsByIds(String ids);

    /**
     * 删除网格员--检查项信息信息
     * 
     * @param checkId 网格员--检查项信息ID
     * @return 结果
     */
    public int deleteXlCheckItemsById(Long checkId);

    List<XlCheckItems> selectXlCheckedList(Long teamId);
}
