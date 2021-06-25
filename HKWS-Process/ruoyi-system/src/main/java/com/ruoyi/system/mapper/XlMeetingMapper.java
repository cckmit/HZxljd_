package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.XlMeeting;

/**
 * 街道管理--会议记录Mapper接口
 *
 * @author ruoyi
 * @date 2021-05-19
 */
public interface XlMeetingMapper
{
    /**
     * 查询街道管理--会议记录
     *
     * @param id 街道管理--会议记录ID
     * @return 街道管理--会议记录
     */
    public XlMeeting selectXlMeetingById(Long id);

    /**
     * 查询街道管理--会议记录列表
     *
     * @param xlMeeting 街道管理--会议记录
     * @return 街道管理--会议记录集合
     */
    public List<XlMeeting> selectXlMeetingList(XlMeeting xlMeeting);

    /**
     * 新增街道管理--会议记录
     *
     * @param xlMeeting 街道管理--会议记录
     * @return 结果
     */
    public int insertXlMeeting(XlMeeting xlMeeting);

    /**
     * 修改街道管理--会议记录
     *
     * @param xlMeeting 街道管理--会议记录
     * @return 结果
     */
    public int updateXlMeeting(XlMeeting xlMeeting);

    /**
     * 删除街道管理--会议记录
     *
     * @param id 街道管理--会议记录ID
     * @return 结果
     */
    public int deleteXlMeetingById(Long id);

    /**
     * 批量删除街道管理--会议记录
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteXlMeetingByIds(String[] ids);
}
