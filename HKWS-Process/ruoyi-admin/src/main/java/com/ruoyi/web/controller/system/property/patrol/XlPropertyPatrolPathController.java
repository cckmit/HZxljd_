package com.ruoyi.web.controller.system.property.patrol;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.constant.XianLinConstants;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.property.XlPropertyPatrolPath;
import com.ruoyi.system.domain.property.XlPropertyPatrolPlan;
import com.ruoyi.system.domain.property.XlPropertyPatrolPoint;
import com.ruoyi.system.service.property.IXlPropertyPatrolPathService;
import com.ruoyi.system.service.property.IXlPropertyPatrolPlanService;
import com.ruoyi.system.service.property.IXlPropertyPatrolPointService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 物业-巡更路线Controller
 *
 * @author ruoyi
 * @date 2021-06-02
 */
@Controller
@RequestMapping("/system/property/patrol/path")
public class XlPropertyPatrolPathController extends BaseController {
    private String prefix = "system/property/patrol/path";

    @Autowired
    private IXlPropertyPatrolPathService xlPropertyPatrolPathService;

    @Autowired
    private IXlPropertyPatrolPointService xlPropertyPatrolPointService;

    @Autowired
    private IXlPropertyPatrolPlanService xlPropertyPatrolPlanService;

    @RequiresPermissions("system/property/patrol:path:view")
    @GetMapping()
    public String path() {
        return prefix + "/path";
    }

    /**
     * 查询物业-巡更路线列表
     */
    @RequiresPermissions("system/property/patrol:path:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(XlPropertyPatrolPath xlPropertyPatrolPath) {
        startPage();
        //查询所有路线信息
        xlPropertyPatrolPath.setDelFlag(0); //未删除的
        List<XlPropertyPatrolPath> list =
                xlPropertyPatrolPathService.selectXlPropertyPatrolPathList(xlPropertyPatrolPath);
        //为路线信息添加巡更点
        for (XlPropertyPatrolPath path : list) {
            List<String> pointNames = new ArrayList<>();
            //获取所有关联的巡更点
            XlPropertyPatrolPath patrolPath =
                    xlPropertyPatrolPathService.selectPathAndPointById(path.getPathId());
            List<XlPropertyPatrolPoint> points = patrolPath.getPoints();
            for (XlPropertyPatrolPoint point : points) {
                //筛选未删除的巡更点
                if(isDelete(point)){
                    pointNames.add(point.getPointName());
                }
            }
            //赋值
            path.setPointNames(pointNames);
        }
        return getDataTable(list);
    }

    /**
     * 新增物业-巡更路线
     */
    @GetMapping("/add")
    public String add(ModelMap mmap) {
        //巡更点
        XlPropertyPatrolPoint point = new XlPropertyPatrolPoint();
        //未删除的
        point.setDelFlag(0);
        List<XlPropertyPatrolPoint> xlPropertyPatrolPointList = xlPropertyPatrolPointService.selectXlPropertyPatrolPointList(point);
        mmap.put("xlPropertyPatrolPointList", xlPropertyPatrolPointList);
        return prefix + "/add";
    }

    /**
     * 新增保存物业-巡更路线
     */
    @RequiresPermissions("system/property/patrol:path:add")
    @Log(title = "物业-巡更路线", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(XlPropertyPatrolPath xlPropertyPatrolPath) {
        return toAjax(xlPropertyPatrolPathService.insertXlPropertyPatrolPath(xlPropertyPatrolPath));
    }

    /**
     * 修改物业-巡更路线
     */
    @GetMapping("/edit/{pathId}")
    public String edit(@PathVariable("pathId") Long pathId, ModelMap mmap) {
        XlPropertyPatrolPath xlPropertyPatrolPath =
                xlPropertyPatrolPathService.selectXlPropertyPatrolPathById(pathId);
        //查询该巡更路线关联的巡更点
        XlPropertyPatrolPath path = xlPropertyPatrolPathService.selectPathAndPointById(pathId);
        //取出巡更点
        List<XlPropertyPatrolPoint> points = path.getPoints();
        List<Long> pointIds = new ArrayList<>();
        for(XlPropertyPatrolPoint point: points){
            //巡更点id
            Long pointId = point.getPointId();
            pointIds.add(point.getPointId());
        }
        xlPropertyPatrolPath.setPointIds(pointIds);
        //巡更点
        XlPropertyPatrolPoint point = new XlPropertyPatrolPoint();
        point.setDelFlag(0); //未删除的
        List<XlPropertyPatrolPoint> xlPropertyPatrolPointList =
                xlPropertyPatrolPointService.selectXlPropertyPatrolPointList(point);
        mmap.put("xlPropertyPatrolPointList", xlPropertyPatrolPointList);
        mmap.put("xlPropertyPatrolPath", xlPropertyPatrolPath);
        return prefix + "/edit";
    }

    /**
     * 修改保存物业-巡更路线
     */
    @RequiresPermissions("system/property/patrol:path:edit")
    @Log(title = "物业-巡更路线", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(XlPropertyPatrolPath xlPropertyPatrolPath) {
        return toAjax(xlPropertyPatrolPathService.updateXlPropertyPatrolPath(xlPropertyPatrolPath));
    }

    /**
     * 删除物业-巡更路线
     */
    //@RequiresPermissions("system/property/patrol:path:remove")
    @Log(title = "物业-巡更路线", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(xlPropertyPatrolPathService.deletePathByIds(ids));
    }

    /**
     * 查看巡更路线详情
     *
     * @param eventId
     * @param mmap
     * @return
     */
    @GetMapping("/detail/{pathId}")
    public String detail(@PathVariable("pathId") Long pathId, ModelMap mmap) {
        //巡更路线
        XlPropertyPatrolPath xlPropertyPatrolPath = xlPropertyPatrolPathService.selectPathAndPointById(pathId);
        //所有关联的巡更点
        List<XlPropertyPatrolPoint> points = xlPropertyPatrolPath.getPoints();
        List<String> pointNames = new ArrayList<>();
        for(XlPropertyPatrolPoint point: points){
            //筛选未被删除的巡更点
            if(isDelete(point)) {
                pointNames.add(point.getPointName());
            }
        }
        xlPropertyPatrolPath.setPointNames(pointNames);
        mmap.put("xlPropertyPatrolPath", xlPropertyPatrolPath);
        return prefix + "/detail";
    }

    /**
     * 获取巡更路线信息
     *
     * @param xlPropertyPatrolPath
     * @return
     */
    @ResponseBody
    @PostMapping("/getPath")
    public AjaxResult getPath(XlPropertyPatrolPath xlPropertyPatrolPath) {
        xlPropertyPatrolPath.setDelFlag(0); //未删除的
        List<XlPropertyPatrolPath> xlPropertyPatrolPathList =
                xlPropertyPatrolPathService.selectXlPropertyPatrolPathList(xlPropertyPatrolPath);
        return AjaxResult.success(xlPropertyPatrolPathList);
    }

    /**
     * 查询是否有巡更路线和巡更计划关联
     * @param pathId
     * @return
     */
    @ResponseBody
    @PostMapping("/checkRel")
    public AjaxResult checkRel(XlPropertyPatrolPlan xlPropertyPatrolPlan){
        //查询巡更计划
        List<XlPropertyPatrolPlan> plan =
                xlPropertyPatrolPlanService.selectXlPropertyPatrolPlanList(xlPropertyPatrolPlan);
        if(plan.size() > 0){
            //有巡更计划关联
            return AjaxResult.success(1);
        }else{
            return AjaxResult.success(0);
        }
    }

    /**
     * 校验巡更路线唯一性
     *
     * @param XlPropertyPatrolPath
     * @return
     */
    @ResponseBody
    @RequestMapping("/checkPathNameUnique")
    public String checkPathNameUnique(XlPropertyPatrolPath xlPropertyPatrolPath) {
        xlPropertyPatrolPath.setDelFlag(0); //未删除的
        List<XlPropertyPatrolPath> xlPropertyPatrolPathList = xlPropertyPatrolPathService.selectXlPropertyPatrolPathList(xlPropertyPatrolPath);
        if (xlPropertyPatrolPathList.size() <= 0) {
            //唯一
            return XianLinConstants.DATA_UNIQUE;
        } else {
            if (null != xlPropertyPatrolPath.getPathId()) {//非空判断
                //判断是否是当前编辑的信息
                if (xlPropertyPatrolPath.getPathId().longValue() == xlPropertyPatrolPathList.get(0).getPathId().longValue()) {
                    //唯一
                    return XianLinConstants.DATA_UNIQUE;
                }
            }
            //不唯一
            return XianLinConstants.DATA_NOT_UNIQUE;
        }
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

