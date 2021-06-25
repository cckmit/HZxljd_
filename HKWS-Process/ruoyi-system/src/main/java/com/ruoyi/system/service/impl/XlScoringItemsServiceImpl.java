package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.XlScoringItemsMapper;
import com.ruoyi.system.domain.XlScoringItems;
import com.ruoyi.system.service.IXlScoringItemsService;
import com.ruoyi.common.core.text.Convert;

/**
 * 网格-考核评分项Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-05-31
 */
@Service
public class XlScoringItemsServiceImpl implements IXlScoringItemsService 
{
    @Autowired
    private XlScoringItemsMapper xlScoringItemsMapper;

    /**
     * 查询网格-考核评分项
     * 
     * @param id 网格-考核评分项ID
     * @return 网格-考核评分项
     */
    @Override
    public XlScoringItems selectXlScoringItemsById(Long id)
    {
        return xlScoringItemsMapper.selectXlScoringItemsById(id);
    }

    /**
     * 查询网格-考核评分项列表
     * 
     * @param xlScoringItems 网格-考核评分项
     * @return 网格-考核评分项
     */
    @Override
    public List<XlScoringItems> selectXlScoringItemsList(XlScoringItems xlScoringItems)
    {
        return xlScoringItemsMapper.selectXlScoringItemsList(xlScoringItems);
    }

    /**
     * 新增网格-考核评分项
     * 
     * @param xlScoringItems 网格-考核评分项
     * @return 结果
     */
    @Override
    public int insertXlScoringItems(XlScoringItems xlScoringItems)
    {
        xlScoringItems.setCreateTime(DateUtils.getNowDate());
        return xlScoringItemsMapper.insertXlScoringItems(xlScoringItems);
    }

    /**
     * 修改网格-考核评分项
     * 
     * @param xlScoringItems 网格-考核评分项
     * @return 结果
     */
    @Override
    public int updateXlScoringItems(XlScoringItems xlScoringItems)
    {
        return xlScoringItemsMapper.updateXlScoringItems(xlScoringItems);
    }

    /**
     * 删除网格-考核评分项对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteXlScoringItemsByIds(String ids)
    {
        return xlScoringItemsMapper.deleteXlScoringItemsByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除网格-考核评分项信息
     * 
     * @param id 网格-考核评分项ID
     * @return 结果
     */
    @Override
    public int deleteXlScoringItemsById(Long id)
    {
        return xlScoringItemsMapper.deleteXlScoringItemsById(id);
    }
}
