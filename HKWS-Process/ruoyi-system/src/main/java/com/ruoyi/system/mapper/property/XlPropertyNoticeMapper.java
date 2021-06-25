package com.ruoyi.system.mapper.property;

import com.ruoyi.system.domain.property.XlPropertyNotice;

import java.util.List;

/**
 * 物业--公告通知Mapper接口
 *
 * @author ruoyi
 * @date 2021-05-26
 */
public interface XlPropertyNoticeMapper
{
    /**
     * 查询物业--公告通知
     *
     * @param id 物业--公告通知ID
     * @return 物业--公告通知
     */
    public XlPropertyNotice selectXlPropertyNoticeById(Long id);

    /**
     * 查询物业--公告通知列表
     *
     * @param xlPropertyNotice 物业--公告通知
     * @return 物业--公告通知集合
     */
    public List<XlPropertyNotice> selectXlPropertyNoticeList(XlPropertyNotice xlPropertyNotice);

    /**
     * 新增物业--公告通知
     *
     * @param xlPropertyNotice 物业--公告通知
     * @return 结果
     */
    public int insertXlPropertyNotice(XlPropertyNotice xlPropertyNotice);

    /**
     * 修改物业--公告通知
     *
     * @param xlPropertyNotice 物业--公告通知
     * @return 结果
     */
    public int updateXlPropertyNotice(XlPropertyNotice xlPropertyNotice);

    /**
     * 删除物业--公告通知
     *
     * @param id 物业--公告通知ID
     * @return 结果
     */
    public int deleteXlPropertyNoticeById(Long id);

    /**
     * 批量删除物业--公告通知
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteXlPropertyNoticeByIds(String[] ids);
}
