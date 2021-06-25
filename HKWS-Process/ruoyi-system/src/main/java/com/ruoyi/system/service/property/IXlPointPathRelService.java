package com.ruoyi.system.service.property;

import com.ruoyi.system.domain.property.XlPointPathRel;

import java.util.List;

/**
 * 物业-巡更点与巡更路线关系Service接口
 *
 * @author ruoyi
 * @date 2021-06-03
 */
public interface IXlPointPathRelService
{
    /**
     * 查询物业-巡更点与巡更路线关系
     *
     * @param id 物业-巡更点与巡更路线关系ID
     * @return 物业-巡更点与巡更路线关系
     */
    public XlPointPathRel selectXlPointPathRelById(Long id);

    /**
     * 查询物业-巡更点与巡更路线关系列表
     *
     * @param XlPointPathRel 物业-巡更点与巡更路线关系
     * @return 物业-巡更点与巡更路线关系集合
     */
    public List<XlPointPathRel> selectXlPointPathRelList(XlPointPathRel XlPointPathRel);

    /**
     * 新增物业-巡更点与巡更路线关系
     *
     * @param XlPointPathRel 物业-巡更点与巡更路线关系
     * @return 结果
     */
    public int insertXlPointPathRel(XlPointPathRel XlPointPathRel);

    /**
     * 修改物业-巡更点与巡更路线关系
     *
     * @param XlPointPathRel 物业-巡更点与巡更路线关系
     * @return 结果
     */
    public int updateXlPointPathRel(XlPointPathRel XlPointPathRel);

    /**
     * 批量删除物业-巡更点与巡更路线关系
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteXlPointPathRelByIds(String ids);

    /**
     * 删除物业-巡更点与巡更路线关系信息
     *
     * @param id 物业-巡更点与巡更路线关系ID
     * @return 结果
     */
    public int deleteXlPointPathRelById(Long id);

    /**
     * 通过巡更路线id删除巡更关联
     * @param pathId
     * @return
     */
    public int deleteXlPointPathRelByPathId(Long pathId);
}
