package com.ruoyi.system.service.property;

import com.ruoyi.system.domain.property.XlVisitor;

import java.util.List;

/**
 * 物业--访客记录Service接口
 *
 * @author ruoyi
 * @date 2021-05-18
 */
public interface IXlVisitorService
{
    /**
     * 查询物业--访客记录
     *
     * @param id 物业--访客记录ID
     * @return 物业--访客记录
     */
    public XlVisitor selectXlVisitorById(Long id);

    /**
     * 查询物业--访客记录列表
     *
     * @param xlVisitor 物业--访客记录
     * @return 物业--访客记录集合
     */
    public List<XlVisitor> selectXlVisitorList(XlVisitor xlVisitor);

    /**
     * 新增物业--访客记录
     *
     * @param xlVisitor 物业--访客记录
     * @return 结果
     */
    public int insertXlVisitor(XlVisitor xlVisitor);

    /**
     * 修改物业--访客记录
     *
     * @param xlVisitor 物业--访客记录
     * @return 结果
     */
    public int updateXlVisitor(XlVisitor xlVisitor);

    /**
     * 批量删除物业--访客记录
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteXlVisitorByIds(String ids);

    /**
     * 删除物业--访客记录信息
     *
     * @param id 物业--访客记录ID
     * @return 结果
     */
    public int deleteXlVisitorById(Long id);
    /**
     * 根据物业id查询某天或历史访客
     * @param xlVisitor
     * @return
     */
    public List<XlVisitor> selectXlVisitorListById(XlVisitor xlVisitor);

    List<XlVisitor> selectXlVisitorPropertyList(Integer[] villageId, XlVisitor xlVisitor);
}

