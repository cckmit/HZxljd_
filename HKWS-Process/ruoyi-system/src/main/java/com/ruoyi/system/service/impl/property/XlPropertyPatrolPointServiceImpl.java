package com.ruoyi.system.service.impl.property;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.property.XlPointPathRel;
import com.ruoyi.system.domain.property.XlPropertyPatrolPath;
import com.ruoyi.system.domain.property.XlPropertyPatrolPlan;
import com.ruoyi.system.domain.property.XlPropertyPatrolPoint;
import com.ruoyi.system.mapper.property.XlPointPathRelMapper;
import com.ruoyi.system.mapper.property.XlPropertyPatrolPathMapper;
import com.ruoyi.system.mapper.property.XlPropertyPatrolPlanMapper;
import com.ruoyi.system.mapper.property.XlPropertyPatrolPointMapper;
import com.ruoyi.system.service.property.IXlPointPathRelService;
import com.ruoyi.system.service.property.IXlPropertyPatrolPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 物业-巡更点Service业务层处理
 *
 * @author ruoyi
 * @date 2021-05-27
 */
@Service
public class XlPropertyPatrolPointServiceImpl implements IXlPropertyPatrolPointService
{
    @Autowired
    private XlPropertyPatrolPointMapper XlPropertyPatrolPointMapper;

    @Autowired
    private XlPointPathRelMapper xlPointPathRelMapper;

    @Autowired
    private XlPropertyPatrolPathMapper xlPropertyPatrolPathMapper;

    @Autowired
    private XlPropertyPatrolPlanMapper xlPropertyPatrolPlanMapper;

    /**
     * 查询物业-巡更点
     *
     * @param pointId 物业-巡更点ID
     * @return 物业-巡更点
     */
    @Override
    public XlPropertyPatrolPoint selectXlPropertyPatrolPointById(Long pointId)
    {
        return XlPropertyPatrolPointMapper.selectXlPropertyPatrolPointById(pointId);
    }

    /**
     * 查询物业-巡更点列表
     *
     * @param XlPropertyPatrolPoint 物业-巡更点
     * @return 物业-巡更点
     */
    @Override
    public List<XlPropertyPatrolPoint> selectXlPropertyPatrolPointList(XlPropertyPatrolPoint XlPropertyPatrolPoint)
    {
        return XlPropertyPatrolPointMapper.selectXlPropertyPatrolPointList(XlPropertyPatrolPoint);
    }

    /**
     * 新增物业-巡更点
     *
     * @param XlPropertyPatrolPoint 物业-巡更点
     * @return 结果
     */
    @Override
    public int insertXlPropertyPatrolPoint(XlPropertyPatrolPoint XlPropertyPatrolPoint)
    {
        XlPropertyPatrolPoint.setCreateTime(DateUtils.getNowDate());
        return XlPropertyPatrolPointMapper.insertXlPropertyPatrolPoint(XlPropertyPatrolPoint);
    }

    /**
     * 修改物业-巡更点
     *
     * @param XlPropertyPatrolPoint 物业-巡更点
     * @return 结果
     */
    @Override
    public int updateXlPropertyPatrolPoint(XlPropertyPatrolPoint XlPropertyPatrolPoint)
    {
        XlPropertyPatrolPoint.setUpdateTime(DateUtils.getNowDate());
        return XlPropertyPatrolPointMapper.updateXlPropertyPatrolPoint(XlPropertyPatrolPoint);
    }

    /**
     * 删除物业-巡更点对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteXlPropertyPatrolPointByIds(String ids)
    {
        return XlPropertyPatrolPointMapper.deleteXlPropertyPatrolPointByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除物业-巡更点信息
     *
     * @param pointId 物业-巡更点ID
     * @return 结果
     */
    @Override
    public int deleteXlPropertyPatrolPointById(Long pointId)
    {
        return XlPropertyPatrolPointMapper.deleteXlPropertyPatrolPointById(pointId);
    }

    /**
     * 删除巡更点 仅修改删除标识 保留数据 单删
     * @param pointId
     * @return
     */
    @Override
    public int deletePointById(Long pointId) {
        return XlPropertyPatrolPointMapper.deletePointById(pointId);
    }

    /**
     * 删除巡更点 仅修改删除标识 保留数据 批删
     * @param pointIds
     * @return
     */
    @Override
    @Transactional
    public int deletePointByIds(String ids) {
        //删除巡更点
        Integer count = XlPropertyPatrolPointMapper.deletePointByIds(Convert.toStrArray(ids));
        if(count > 0){
            //转换为Long数组
            Long[] pointIds = Convert.toLongArray(ids);
            //查询该巡更点关联的巡更路线
            for(Long pointId: pointIds){
                XlPointPathRel xlPointPathRel = new XlPointPathRel();
                xlPointPathRel.setPointId(pointId);
                List<XlPointPathRel> xlPointPathRelList = xlPointPathRelMapper.selectXlPointPathRelList(xlPointPathRel);
                //判断巡更路线是否还有巡更点
                for(XlPointPathRel rel: xlPointPathRelList){
                    //巡更路线id
                    Long pathId = rel.getPathId();
                    XlPropertyPatrolPath xlPropertyPatrolPath =
                            xlPropertyPatrolPathMapper.selectPathAndPointById(pathId);
                    //获取巡更路线的所有巡更点
                    List<XlPropertyPatrolPoint> points = xlPropertyPatrolPath.getPoints();
                    Integer number = 0; //记录有多少没有被删除的巡更点
                    for(XlPropertyPatrolPoint point: points){
                        if(isDelete(point)){
                            number+=1;
                        }
                    }
                    if(number == 0){
                        //该巡更路线下的所有巡更点都被删除，巡更路线不可用
                        xlPropertyPatrolPath.setPathStatus(1);
                        xlPropertyPatrolPathMapper.updateXlPropertyPatrolPath(xlPropertyPatrolPath);
                    }
                    //该巡更路线关联的巡更计划改为不可执行
                    XlPropertyPatrolPlan xlPropertyPatrolPlan = new XlPropertyPatrolPlan();
                    xlPropertyPatrolPlan.setPathId(pathId);
                    xlPropertyPatrolPlan.setPlanStatus(1); //不可执行
                    xlPropertyPatrolPlanMapper.updatePlanStatusByPathId(xlPropertyPatrolPlan);
                }
            }
        }
        return count;
    }

    /**
     * 判断巡更点是否删除
     * @param pointId
     * @return
     */
    public Boolean isDelete(XlPropertyPatrolPoint point){
        //判断是否删除
        if(point.getDelFlag() == 0){
            //未删除
            return true;
        }
        //已删除
        return false;
    }
}