package com.ruoyi.system.service.impl.property;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.property.XlPropertyNotice;
import com.ruoyi.system.mapper.property.XlPropertyNoticeMapper;
import com.ruoyi.system.service.property.IXlPropertyNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 物业--公告通知Service业务层处理
 *
 * @author ruoyi
 * @date 2021-05-26
 */
@Service
public class XlPropertyNoticeServiceImpl implements IXlPropertyNoticeService
{
    @Autowired
    private XlPropertyNoticeMapper xlPropertyNoticeMapper;

    /**
     * 查询物业--公告通知
     *
     * @param id 物业--公告通知ID
     * @return 物业--公告通知
     */
    @Override
    public XlPropertyNotice selectXlPropertyNoticeById(Long id)
    {
        return xlPropertyNoticeMapper.selectXlPropertyNoticeById(id);
    }

    /**
     * 查询物业--公告通知列表
     *
     * @param xlPropertyNotice 物业--公告通知
     * @return 物业--公告通知
     */
    @Override
    public List<XlPropertyNotice> selectXlPropertyNoticeList(XlPropertyNotice xlPropertyNotice)
    {
        return xlPropertyNoticeMapper.selectXlPropertyNoticeList(xlPropertyNotice);
    }

    /**
     * 新增物业--公告通知
     *
     * @param xlPropertyNotice 物业--公告通知
     * @return 结果
     */
    @Override
    public int insertXlPropertyNotice(XlPropertyNotice xlPropertyNotice)
    {
        xlPropertyNotice.setCreateTime(DateUtils.getNowDate());
        return xlPropertyNoticeMapper.insertXlPropertyNotice(xlPropertyNotice);
    }

    /**
     * 修改物业--公告通知
     *
     * @param xlPropertyNotice 物业--公告通知
     * @return 结果
     */
    @Override
    public int updateXlPropertyNotice(XlPropertyNotice xlPropertyNotice)
    {
        xlPropertyNotice.setUpdateTime(DateUtils.getNowDate());
        return xlPropertyNoticeMapper.updateXlPropertyNotice(xlPropertyNotice);
    }


    /**
     * 删除物业--公告通知对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    @Transactional
    public int deleteXlPropertyNoticeByIds(String ids)
    {
        return xlPropertyNoticeMapper.deleteXlPropertyNoticeByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除物业--公告通知信息
     *
     * @param id 物业--公告通知ID
     * @return 结果
     */
    @Override
    public int deleteXlPropertyNoticeById(Long id)
    {
        return xlPropertyNoticeMapper.deleteXlPropertyNoticeById(id);
    }
}
