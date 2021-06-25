package com.ruoyi.system.mapper.property;

import com.ruoyi.system.domain.property.XlPointPathRel;

import java.util.List;

/**
 * 物业-巡更点与巡更路线关系Mapper接口
 *
 * @author ruoyi
 * @date 2021-06-03
 */
public interface XlPointPathRelMapper
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
     * 删除物业-巡更点与巡更路线关系
     *
     * @param id 物业-巡更点与巡更路线关系ID
     * @return 结果
     */
    public int deleteXlPointPathRelById(Long id);

    /**
     * 批量删除物业-巡更点与巡更路线关系
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteXlPointPathRelByIds(String[] ids);

    //通过巡更路线id删除巡更关联
    public int deleteXlPointPathRelByPathId(Long pathId);
}
