package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.XlCheckItemsMapper;
import com.ruoyi.system.domain.XlCheckItems;
import com.ruoyi.system.service.IXlCheckItemsService;
import com.ruoyi.common.core.text.Convert;

/**
 * 网格员--检查项信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-05-24
 */
@Service
public class XlCheckItemsServiceImpl implements IXlCheckItemsService 
{
    @Autowired
    private XlCheckItemsMapper xlCheckItemsMapper;

    /**
     * 查询网格员--检查项信息
     * 
     * @param checkId 网格员--检查项信息ID
     * @return 网格员--检查项信息
     */
    @Override
    public XlCheckItems selectXlCheckItemsById(Long checkId)
    {
        return xlCheckItemsMapper.selectXlCheckItemsById(checkId);
    }

    /**
     * 查询网格员--检查项信息列表
     * 
     * @param xlCheckItems 网格员--检查项信息
     * @return 网格员--检查项信息
     */
    @Override
    public List<XlCheckItems> selectXlCheckItemsList(XlCheckItems xlCheckItems)
    {
        return xlCheckItemsMapper.selectXlCheckItemsList(xlCheckItems);
    }

    /**
     * 新增网格员--检查项信息
     * 
     * @param xlCheckItems 网格员--检查项信息
     * @return 结果
     */
    @Override
    public int insertXlCheckItems(XlCheckItems xlCheckItems)
    {
        return xlCheckItemsMapper.insertXlCheckItems(xlCheckItems);
    }

    /**
     * 修改网格员--检查项信息
     * 
     * @param xlCheckItems 网格员--检查项信息
     * @return 结果
     */
    @Override
    public int updateXlCheckItems(XlCheckItems xlCheckItems)
    {
        return xlCheckItemsMapper.updateXlCheckItems(xlCheckItems);
    }

    /**
     * 删除网格员--检查项信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteXlCheckItemsByIds(String ids)
    {
        return xlCheckItemsMapper.deleteXlCheckItemsByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除网格员--检查项信息信息
     * 
     * @param checkId 网格员--检查项信息ID
     * @return 结果
     */
    @Override
    public int deleteXlCheckItemsById(Long checkId)
    {
        return xlCheckItemsMapper.deleteXlCheckItemsById(checkId);
    }

    @Override
    public List<XlCheckItems> selectXlCheckedList(Long teamId) {
        return xlCheckItemsMapper.selectXlCheckedList(teamId);
    }
}
