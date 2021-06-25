package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.XlSubdivide;

/**
 * 网格员--考核细分项Service接口
 * 
 * @author ruoyi
 * @date 2021-05-31
 */
public interface IXlSubdivideService 
{
    /**
     * 查询网格员--考核细分项
     * 
     * @param subdivideId 网格员--考核细分项ID
     * @return 网格员--考核细分项
     */
    public XlSubdivide selectXlSubdivideById(Long subdivideId);

    /**
     * 查询网格员--考核细分项列表
     * 
     * @param xlSubdivide 网格员--考核细分项
     * @return 网格员--考核细分项集合
     */
    public List<XlSubdivide> selectXlSubdivideList(XlSubdivide xlSubdivide);

    /**
     * 新增网格员--考核细分项
     * 
     * @param xlSubdivide 网格员--考核细分项
     * @return 结果
     */
    public int insertXlSubdivide(XlSubdivide xlSubdivide);

    /**
     * 修改网格员--考核细分项
     * 
     * @param xlSubdivide 网格员--考核细分项
     * @return 结果
     */
    public int updateXlSubdivide(XlSubdivide xlSubdivide);

    /**
     * 批量删除网格员--考核细分项
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteXlSubdivideByIds(String ids);

    /**
     * 删除网格员--考核细分项信息
     * 
     * @param subdivideId 网格员--考核细分项ID
     * @return 结果
     */
    public int deleteXlSubdivideById(Long subdivideId);

    //根据考核管理表与细分表关联数据查询所需要的细分表
    public List<XlSubdivide> selectXlSubdivideByAssessmentId(Long assessmentId);

    //查询详情页的单位数据
    public List<String> selectDeptNamesBySubdivideId(Long subdivideId);
}
