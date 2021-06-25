package com.ruoyi.system.service.honey;

import java.util.List;
import com.ruoyi.system.domain.honey.XlAppeal;

/**
 * 网格员--申诉Service接口
 *
 * @author ruoyi
 * @date 2021-05-28
 */
public interface IXlAppealService
{
    /**
     * 查询网格员--申诉
     *
     * @param id 网格员--申诉ID
     * @return 网格员--申诉
     */
    public XlAppeal selectXlAppealById(Long id);

    /**
     * 查询网格员--申诉列表
     *
     * @param xlAppeal 网格员--申诉
     * @return 网格员--申诉集合
     */
    public List<XlAppeal> selectXlAppealList(XlAppeal xlAppeal);

    /**
     * 新增网格员--申诉
     *
     * @param xlAppeal 网格员--申诉
     * @return 结果
     */
    public int insertXlAppeal(XlAppeal xlAppeal);

    /**
     * 修改网格员--申诉
     *
     * @param xlAppeal 网格员--申诉
     * @return 结果
     */
    public int updateXlAppeal(XlAppeal xlAppeal);

    /**
     * 批量删除网格员--申诉
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteXlAppealByIds(String ids);

    /**
     * 删除网格员--申诉信息
     *
     * @param id 网格员--申诉ID
     * @return 结果
     */
    public int deleteXlAppealById(Long id);
}
