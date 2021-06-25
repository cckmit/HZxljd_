package com.ruoyi.system.service.impl.property;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.property.XlPropertyPatrolSign;
import com.ruoyi.system.mapper.property.XlPropertyPatrolSignMapper;
import com.ruoyi.system.service.property.IXlPropertyPatrolSignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 物业-巡更打卡记录Service业务层处理
 *
 * @author ruoyi
 * @date 2021-06-08
 */
@Service
public class XlPropertyPatrolSignServiceImpl implements IXlPropertyPatrolSignService
{
    @Autowired
    private XlPropertyPatrolSignMapper xlPropertyPatrolSignMapper;

    /**
     * 查询物业-巡更打卡记录
     *
     * @param signId 物业-巡更打卡记录ID
     * @return 物业-巡更打卡记录
     */
    @Override
    public XlPropertyPatrolSign selectXlPropertyPatrolSignById(Long signId)
    {
        return xlPropertyPatrolSignMapper.selectXlPropertyPatrolSignById(signId);
    }

    /**
     * 查询物业-巡更打卡记录列表
     *
     * @param xlPropertyPatrolSign 物业-巡更打卡记录
     * @return 物业-巡更打卡记录
     */
    @Override
    public List<XlPropertyPatrolSign> selectXlPropertyPatrolSignList(XlPropertyPatrolSign xlPropertyPatrolSign)
    {
        return xlPropertyPatrolSignMapper.selectXlPropertyPatrolSignList(xlPropertyPatrolSign);
    }

    /**
     * 新增物业-巡更打卡记录
     *
     * @param xlPropertyPatrolSign 物业-巡更打卡记录
     * @return 结果
     */
    @Override
    public int insertXlPropertyPatrolSign(XlPropertyPatrolSign xlPropertyPatrolSign)
    {
        xlPropertyPatrolSign.setCreateTime(DateUtils.getNowDate());
        return xlPropertyPatrolSignMapper.insertXlPropertyPatrolSign(xlPropertyPatrolSign);
    }

    /**
     * 修改物业-巡更打卡记录
     *
     * @param xlPropertyPatrolSign 物业-巡更打卡记录
     * @return 结果
     */
    @Override
    public int updateXlPropertyPatrolSign(XlPropertyPatrolSign xlPropertyPatrolSign)
    {
        xlPropertyPatrolSign.setUpdateTime(DateUtils.getNowDate());
        return xlPropertyPatrolSignMapper.updateXlPropertyPatrolSign(xlPropertyPatrolSign);
    }

    /**
     * 删除物业-巡更打卡记录对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteXlPropertyPatrolSignByIds(String ids)
    {
        return xlPropertyPatrolSignMapper.deleteXlPropertyPatrolSignByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除物业-巡更打卡记录信息
     *
     * @param signId 物业-巡更打卡记录ID
     * @return 结果
     */
    @Override
    public int deleteXlPropertyPatrolSignById(Long signId)
    {
        return xlPropertyPatrolSignMapper.deleteXlPropertyPatrolSignById(signId);
    }

    @Override
    public XlPropertyPatrolSign selectByPatrolProperty(Long patrolPropertyId, String patrolProperty) {
        return xlPropertyPatrolSignMapper.selectByPatrolProperty(patrolPropertyId,patrolProperty);
    }
}
