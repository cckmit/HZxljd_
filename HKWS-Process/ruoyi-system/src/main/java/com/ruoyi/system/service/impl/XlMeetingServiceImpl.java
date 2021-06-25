package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.XlMeetingMapper;
import com.ruoyi.system.domain.XlMeeting;
import com.ruoyi.system.service.IXlMeetingService;
import com.ruoyi.common.core.text.Convert;

/**
 * 街道管理--会议记录Service业务层处理
 *
 * @author ruoyi
 * @date 2021-05-19
 */
@Service
public class XlMeetingServiceImpl implements IXlMeetingService
{
    @Autowired
    private XlMeetingMapper xlMeetingMapper;

    /**
     * 查询街道管理--会议记录
     *
     * @param id 街道管理--会议记录ID
     * @return 街道管理--会议记录
     */
    @Override
    public XlMeeting selectXlMeetingById(Long id)
    {
        return xlMeetingMapper.selectXlMeetingById(id);
    }

    /**
     * 查询街道管理--会议记录列表
     *
     * @param xlMeeting 街道管理--会议记录
     * @return 街道管理--会议记录
     */
    @Override
    public List<XlMeeting> selectXlMeetingList(XlMeeting xlMeeting)
    {
        return xlMeetingMapper.selectXlMeetingList(xlMeeting);
    }

    /**
     * 新增街道管理--会议记录
     *
     * @param xlMeeting 街道管理--会议记录
     * @return 结果
     */
    @Override
    public int insertXlMeeting(XlMeeting xlMeeting)
    {
        return xlMeetingMapper.insertXlMeeting(xlMeeting);
    }

    /**
     * 修改街道管理--会议记录
     *
     * @param xlMeeting 街道管理--会议记录
     * @return 结果
     */
    @Override
    public int updateXlMeeting(XlMeeting xlMeeting)
    {
        return xlMeetingMapper.updateXlMeeting(xlMeeting);
    }

    /**
     * 删除街道管理--会议记录对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteXlMeetingByIds(String ids)
    {
        return xlMeetingMapper.deleteXlMeetingByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除街道管理--会议记录信息
     *
     * @param id 街道管理--会议记录ID
     * @return 结果
     */
    @Override
    public int deleteXlMeetingById(Long id)
    {
        return xlMeetingMapper.deleteXlMeetingById(id);
    }
}
