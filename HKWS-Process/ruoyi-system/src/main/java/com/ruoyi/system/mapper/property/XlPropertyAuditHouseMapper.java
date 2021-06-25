package com.ruoyi.system.mapper.property;

import com.ruoyi.system.domain.property.XlPropertyAuditHouse;

import java.util.List;

/**
 * 物业-房屋审核Mapper接口
 *
 * @author ruoyi
 * @date 2021-06-01
 */
public interface XlPropertyAuditHouseMapper
{
    /**
     * 查询物业-房屋审核
     *
     * @param auditId 物业-房屋审核ID
     * @return 物业-房屋审核
     */
    public XlPropertyAuditHouse selectXlPropertyAuditHouseById(Long auditId);

    /**
     * 查询物业-房屋审核列表
     *
     * @param xlPropertyAuditHouse 物业-房屋审核
     * @return 物业-房屋审核集合
     */
    public List<XlPropertyAuditHouse> selectXlPropertyAuditHouseList(XlPropertyAuditHouse xlPropertyAuditHouse);

    /**
     * 新增物业-房屋审核
     *
     * @param xlPropertyAuditHouse 物业-房屋审核
     * @return 结果
     */
    public int insertXlPropertyAuditHouse(XlPropertyAuditHouse xlPropertyAuditHouse);

    /**
     * 修改物业-房屋审核
     *
     * @param xlPropertyAuditHouse 物业-房屋审核
     * @return 结果
     */
    public int updateXlPropertyAuditHouse(XlPropertyAuditHouse xlPropertyAuditHouse);

    /**
     * 删除物业-房屋审核
     *
     * @param auditId 物业-房屋审核ID
     * @return 结果
     */
    public int deleteXlPropertyAuditHouseById(Long auditId);

    /**
     * 批量删除物业-房屋审核
     *
     * @param auditIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteXlPropertyAuditHouseByIds(String[] auditIds);
}