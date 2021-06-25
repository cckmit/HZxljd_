package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.XlApplyInspection;

/**
 * 网格管理-检查组应用Service接口
 * 
 * @author ruoyi
 * @date 2021-06-04
 */
public interface IXlApplyInspectionService 
{
    /**
     * 查询网格管理-检查组应用
     * 
     * @param id 网格管理-检查组应用ID
     * @return 网格管理-检查组应用
     */
    public XlApplyInspection selectXlApplyInspectionById(Long id);

    /**
     * 查询网格管理-检查组应用列表
     * 
     * @param xlApplyInspection 网格管理-检查组应用
     * @return 网格管理-检查组应用集合
     */
    public List<XlApplyInspection> selectXlApplyInspectionList(XlApplyInspection xlApplyInspection);

    /**
     * 新增网格管理-检查组应用
     * 
     * @param xlApplyInspection 网格管理-检查组应用
     * @return 结果
     */
    public int insertXlApplyInspection(XlApplyInspection xlApplyInspection);

    /**
     * 修改网格管理-检查组应用
     * 
     * @param xlApplyInspection 网格管理-检查组应用
     * @return 结果
     */
    public int updateXlApplyInspection(XlApplyInspection xlApplyInspection);

    /**
     * 批量删除网格管理-检查组应用
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteXlApplyInspectionByIds(String ids);

    /**
     * 删除网格管理-检查组应用信息
     * 
     * @param id 网格管理-检查组应用ID
     * @return 结果
     */
    public int deleteXlApplyInspectionById(Long id);
}
