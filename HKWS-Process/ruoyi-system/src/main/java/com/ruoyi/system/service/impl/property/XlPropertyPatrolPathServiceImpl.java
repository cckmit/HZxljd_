package com.ruoyi.system.service.impl.property;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.property.XlPointPathRel;
import com.ruoyi.system.domain.property.XlPropertyPatrolPath;
import com.ruoyi.system.domain.property.XlPropertyPatrolPlan;
import com.ruoyi.system.mapper.property.XlPointPathRelMapper;
import com.ruoyi.system.mapper.property.XlPropertyPatrolPathMapper;
import com.ruoyi.system.mapper.property.XlPropertyPatrolPlanMapper;
import com.ruoyi.system.service.property.IXlPropertyPatrolPathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * 物业-巡更路线Service业务层处理
 *
 * @author ruoyi
 * @date 2021-05-27
 */
@Service
public class XlPropertyPatrolPathServiceImpl implements IXlPropertyPatrolPathService
{
    @Autowired
    private XlPropertyPatrolPathMapper xlPropertyPatrolPathMapper;

    @Autowired
    private XlPointPathRelMapper xlPointPathRelMapper;

    @Autowired
    private XlPropertyPatrolPlanMapper xlPropertyPatrolPlanMapper;

    /**
     * 查询物业-巡更路线
     *
     * @param pathId 物业-巡更路线ID
     * @return 物业-巡更路线
     */
    @Override
    public XlPropertyPatrolPath selectXlPropertyPatrolPathById(Long pathId)
    {
        return xlPropertyPatrolPathMapper.selectXlPropertyPatrolPathById(pathId);
    }

    /**
     * 查询物业-巡更路线列表
     *
     * @param xlPropertyPatrolPath 物业-巡更路线
     * @return 物业-巡更路线
     */
    @Override
    public List<XlPropertyPatrolPath> selectXlPropertyPatrolPathList(XlPropertyPatrolPath xlPropertyPatrolPath)
    {
        return xlPropertyPatrolPathMapper.selectXlPropertyPatrolPathList(xlPropertyPatrolPath);
    }

    /**
     * 新增物业-巡更路线
     *
     * @param xlPropertyPatrolPath 物业-巡更路线
     * @return 结果
     */
    @Override
    @Transactional
    public int insertXlPropertyPatrolPath(XlPropertyPatrolPath xlPropertyPatrolPath)
    {
        //巡更点id
        List<Long> pointIds = xlPropertyPatrolPath.getPointIds();
        //创建时间
        Date date = DateUtils.getNowDate();
        xlPropertyPatrolPath.setCreateTime(date);
        if(pointIds.size() >0){
            //巡更点数量大于1，巡更路线可用
            xlPropertyPatrolPath.setPathStatus(0);
        }else{
            //巡更点数量为0，巡更路线不可用
            xlPropertyPatrolPath.setPathStatus(1);
        }
        Integer count = xlPropertyPatrolPathMapper.insertXlPropertyPatrolPath(xlPropertyPatrolPath);
        if(count > 0 && pointIds.size() > 0){ //成功添加 有巡更点
            //巡更路线id
            Long pathId = xlPropertyPatrolPath.getPathId();
            //添加巡更点与巡更路线的关联
            XlPointPathRel xlPointPathRel = new XlPointPathRel();
            xlPointPathRel.setPathId(pathId);
            for(Long pointId: pointIds){
                xlPointPathRel.setPointId(pointId);
                //添加
                xlPointPathRelMapper.insertXlPointPathRel(xlPointPathRel);
            }
        }
        return count;
    }

    /**
     * 修改物业-巡更路线
     *
     * @param xlPropertyPatrolPath 物业-巡更路线
     * @return 结果
     */
    @Override
    @Transactional
    public int updateXlPropertyPatrolPath(XlPropertyPatrolPath xlPropertyPatrolPath)
    {
        xlPropertyPatrolPath.setUpdateTime(DateUtils.getNowDate());
        //修改巡更点与巡更路线的关联
        List<Long> pointIds = xlPropertyPatrolPath.getPointIds(); //巡更点id
        Long pathId = xlPropertyPatrolPath.getPathId(); //巡更路线id
        //删除原关联
        xlPointPathRelMapper.deleteXlPointPathRelByPathId(pathId);
        //新建关联
        XlPointPathRel xlPointPathRel = new XlPointPathRel();
        xlPointPathRel.setPathId(pathId);
        //该巡更路线关联的巡更计划
        XlPropertyPatrolPlan plan = new XlPropertyPatrolPlan();
        plan.setPathId(pathId);
        if(pointIds.size() > 0){ //有巡更点
            for(Long pointId: pointIds){
                xlPointPathRel.setPointId(pointId);
                //添加
                xlPointPathRelMapper.insertXlPointPathRel(xlPointPathRel);
            }
            //巡更点数量大于1，巡更路线可用
            xlPropertyPatrolPath.setPathStatus(0);
            //关联的巡更计划可执行
            plan.setPlanStatus(0);
        }else{
            //巡更点数量为0，巡更路线不可用
            xlPropertyPatrolPath.setPathStatus(1);
            //关联巡更计划不可执行
            plan.setPlanStatus(1);
        }
        //修改巡更计划
        xlPropertyPatrolPlanMapper.updatePlanStatusByPathId(plan);
        return xlPropertyPatrolPathMapper.updateXlPropertyPatrolPath(xlPropertyPatrolPath);
    }

    /**
     * 删除物业-巡更路线对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteXlPropertyPatrolPathByIds(String ids)
    {
        return xlPropertyPatrolPathMapper.deleteXlPropertyPatrolPathByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除物业-巡更路线信息
     *
     * @param pathId 物业-巡更路线ID
     * @return 结果
     */
    @Override
    public int deleteXlPropertyPatrolPathById(Long pathId)
    {
        return xlPropertyPatrolPathMapper.deleteXlPropertyPatrolPathById(pathId);
    }

    /**
     * 查询巡更点与巡更路线的联合信息
     * @param xlPropertyPatrolPath
     * @return
     */
    @Override
    public List<XlPropertyPatrolPath> selectPathAndPointList(XlPropertyPatrolPath xlPropertyPatrolPath) {
        return xlPropertyPatrolPathMapper.selectPathAndPointList(xlPropertyPatrolPath);
    }

    /**
     * 通过巡更路线id查询巡更点与巡更路线的联合信息
     * @param pathId
     * @return
     */
    @Override
    public XlPropertyPatrolPath selectPathAndPointById(Long pathId) {
        return xlPropertyPatrolPathMapper.selectPathAndPointById(pathId);
    }

    /**
     * 删除巡更路线 仅修改巡更路线的删除标识，保留数据 单删
     * @param pathId
     * @return
     */
    @Override
    public int deletePathById(Long pathId) {
        return xlPropertyPatrolPathMapper.deletePathById(pathId);
    }

    /**
     * 删除巡更路线 仅修改巡更路线的删除标识，保留数据 批删
     * @param pathIds
     * @return
     */
    @Override
    @Transactional
    public int deletePathByIds(String ids) {
        Integer count = xlPropertyPatrolPathMapper.deletePathByIds(Convert.toStrArray(ids));
        if(count > 0){
            //巡更路线删除，巡更路线关联的巡更计划不可执行
            Long[] pathIds = Convert.toLongArray(ids);
            for(Long pathId: pathIds){
                //修改巡更计划状态
                XlPropertyPatrolPlan plan = new XlPropertyPatrolPlan();
                plan.setPathId(pathId);
                plan.setPlanStatus(1); //不可执行
                xlPropertyPatrolPlanMapper.updatePlanStatusByPathId(plan);
            }
        }
        return count;
    }
}
