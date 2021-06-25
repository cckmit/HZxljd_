package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.XlRecordDetail;

/**
 * 网格管理-工作记录关联详情Service接口
 * 
 * @author ruoyi
 * @date 2021-06-04
 */
public interface IXlRecordDetailService 
{
    /**
     * 查询网格管理-工作记录关联详情
     * 
     * @param id 网格管理-工作记录关联详情ID
     * @return 网格管理-工作记录关联详情
     */
    public XlRecordDetail selectXlRecordDetailById(Long id);

    /**
     * 查询网格管理-工作记录关联详情列表
     * 
     * @param xlRecordDetail 网格管理-工作记录关联详情
     * @return 网格管理-工作记录关联详情集合
     */
    public List<XlRecordDetail> selectXlRecordDetailList(XlRecordDetail xlRecordDetail);

    /**
     * 新增网格管理-工作记录关联详情
     * 
     * @param xlRecordDetail 网格管理-工作记录关联详情
     * @return 结果
     */
    public int insertXlRecordDetail(XlRecordDetail xlRecordDetail);

    /**
     * 修改网格管理-工作记录关联详情
     * 
     * @param xlRecordDetail 网格管理-工作记录关联详情
     * @return 结果
     */
    public int updateXlRecordDetail(XlRecordDetail xlRecordDetail);

    /**
     * 批量删除网格管理-工作记录关联详情
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteXlRecordDetailByIds(String ids);

    /**
     * 删除网格管理-工作记录关联详情信息
     * 
     * @param id 网格管理-工作记录关联详情ID
     * @return 结果
     */
    public int deleteXlRecordDetailById(Long id);
}
