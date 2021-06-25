package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.XlRecordDetailMapper;
import com.ruoyi.system.domain.XlRecordDetail;
import com.ruoyi.system.service.IXlRecordDetailService;
import com.ruoyi.common.core.text.Convert;

/**
 * 网格管理-工作记录关联详情Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-06-04
 */
@Service
public class XlRecordDetailServiceImpl implements IXlRecordDetailService 
{
    @Autowired
    private XlRecordDetailMapper xlRecordDetailMapper;

    /**
     * 查询网格管理-工作记录关联详情
     * 
     * @param id 网格管理-工作记录关联详情ID
     * @return 网格管理-工作记录关联详情
     */
    @Override
    public XlRecordDetail selectXlRecordDetailById(Long id)
    {
        return xlRecordDetailMapper.selectXlRecordDetailById(id);
    }

    /**
     * 查询网格管理-工作记录关联详情列表
     * 
     * @param xlRecordDetail 网格管理-工作记录关联详情
     * @return 网格管理-工作记录关联详情
     */
    @Override
    public List<XlRecordDetail> selectXlRecordDetailList(XlRecordDetail xlRecordDetail)
    {
        return xlRecordDetailMapper.selectXlRecordDetailList(xlRecordDetail);
    }

    /**
     * 新增网格管理-工作记录关联详情
     * 
     * @param xlRecordDetail 网格管理-工作记录关联详情
     * @return 结果
     */
    @Override
    public int insertXlRecordDetail(XlRecordDetail xlRecordDetail)
    {
        return xlRecordDetailMapper.insertXlRecordDetail(xlRecordDetail);
    }

    /**
     * 修改网格管理-工作记录关联详情
     * 
     * @param xlRecordDetail 网格管理-工作记录关联详情
     * @return 结果
     */
    @Override
    public int updateXlRecordDetail(XlRecordDetail xlRecordDetail)
    {
        return xlRecordDetailMapper.updateXlRecordDetail(xlRecordDetail);
    }

    /**
     * 删除网格管理-工作记录关联详情对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteXlRecordDetailByIds(String ids)
    {
        return xlRecordDetailMapper.deleteXlRecordDetailByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除网格管理-工作记录关联详情信息
     * 
     * @param id 网格管理-工作记录关联详情ID
     * @return 结果
     */
    @Override
    public int deleteXlRecordDetailById(Long id)
    {
        return xlRecordDetailMapper.deleteXlRecordDetailById(id);
    }
}
