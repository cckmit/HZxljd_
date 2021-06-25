package com.ruoyi.web.controller.system.property.patrol;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.config.Global;
import com.ruoyi.common.config.ServerConfig;
import com.ruoyi.common.constant.XianLinConstants;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.property.XlPointPathRel;
import com.ruoyi.system.domain.property.XlPropertyPatrolPath;
import com.ruoyi.system.domain.property.XlPropertyPatrolPlan;
import com.ruoyi.system.domain.property.XlPropertyPatrolPoint;
import com.ruoyi.system.service.property.IXlPointPathRelService;
import com.ruoyi.system.service.property.IXlPropertyPatrolPathService;
import com.ruoyi.system.service.property.IXlPropertyPatrolPlanService;
import com.ruoyi.system.service.property.IXlPropertyPatrolPointService;
import org.apache.catalina.webresources.TomcatJarInputStream;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 物业-巡更点Controller
 *
 * @author ruoyi
 * @date 2021-06-02
 */
@Controller
@RequestMapping("/system/property/patrol/point")
public class XlPropertyPatrolPointController extends BaseController
{
    private String prefix = "system/property/patrol/point";

    @Autowired
    private IXlPropertyPatrolPointService xlPropertyPatrolPointService;

    @Autowired
    private IXlPropertyPatrolPathService xlPropertyPatrolPathService;

    @Autowired
    private ServerConfig serverConfig;

    @Autowired
    private IXlPropertyPatrolPlanService xlPropertyPatrolPlanService;

    @Autowired
    private IXlPointPathRelService xlPointPathRelService;

    @RequiresPermissions("system/property/patrol:point:view")
    @GetMapping()
    public String point()
    {
        return prefix + "/point";
    }

    /**
     * 查询物业-巡更点列表
     */
    @RequiresPermissions("system/property/patrol:point:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(XlPropertyPatrolPoint xlPropertyPatrolPoint)
    {
        startPage();
        //未删除的
        xlPropertyPatrolPoint.setDelFlag(0);
        List<XlPropertyPatrolPoint> list = xlPropertyPatrolPointService.selectXlPropertyPatrolPointList(xlPropertyPatrolPoint);
        return getDataTable(list);
    }

    /**
     * 新增物业-巡更点
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存物业-巡更点
     */
    @RequiresPermissions("system/property/patrol:point:add")
    @Log(title = "物业-巡更点", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(XlPropertyPatrolPoint xlPropertyPatrolPoint)
    {
        return toAjax(xlPropertyPatrolPointService.insertXlPropertyPatrolPoint(xlPropertyPatrolPoint));
    }

    /**
     * 修改物业-巡更点
     */
    @GetMapping("/edit/{pointId}")
    public String edit(@PathVariable("pointId") Long pointId, ModelMap mmap)
    {

        XlPropertyPatrolPoint XlPropertyPatrolPoint = xlPropertyPatrolPointService.selectXlPropertyPatrolPointById(pointId);
        mmap.put("xlPropertyPatrolPoint", XlPropertyPatrolPoint);
        return prefix + "/edit";
    }

    /**
     * 修改保存物业-巡更点
     */
    @RequiresPermissions("system/property/patrol:point:edit")
    @Log(title = "物业-巡更点", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(XlPropertyPatrolPoint xlPropertyPatrolPoint)
    {
        return toAjax(xlPropertyPatrolPointService.updateXlPropertyPatrolPoint(xlPropertyPatrolPoint));
    }

    /**
     * 删除物业-巡更点
     */
    //@RequiresPermissions("system/property/patrol:point:remove")
    @Log(title = "物业-巡更点", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(xlPropertyPatrolPointService.deletePointByIds(ids));
    }

    /**
     * 批量查询二维码
     * @param ids
     * @return
     */
    @ResponseBody
    @PostMapping("/batchQuery")
    public AjaxResult batchQuery(String ids){
        //设置返回数据
        List<String> qrCodes = new ArrayList<>();
        //转换为Long数组
        Long[] pointIds = Convert.toLongArray(ids);
        //获取二维码
        for(Long pointId: pointIds){
            XlPropertyPatrolPoint point =
                    xlPropertyPatrolPointService.selectXlPropertyPatrolPointById(pointId);
            qrCodes.add(point.getQrCode());
        }
        //返回
        AjaxResult ajax = AjaxResult.success();
        ajax.put("qrCodes",qrCodes);
        return ajax;
    }


    /**
     * 查看物业-巡更点详情
     */
    @GetMapping( "/detail/{pointId}")
    @RequiresPermissions("system/property:xlpropertypatrolpoint:detail")
    public String detail(@PathVariable("pointId") Long pointId, ModelMap mmap)
    {
        XlPropertyPatrolPoint XlPropertyPatrolPoint = xlPropertyPatrolPointService.selectXlPropertyPatrolPointById(pointId);
        mmap.put("xlPropertyPatrolPoint",XlPropertyPatrolPoint);
        return prefix + "/detail";
    }

    /**
     * 查询巡更点是否有与巡更路线关联
     * @param pointId
     * @return
     */
    @ResponseBody
    @PostMapping("/checkRel")
    public AjaxResult checkRel(XlPointPathRel xlPointPathRel){
        //查询关联信息
        List<XlPointPathRel> xlPointPathRelList =
                xlPointPathRelService.selectXlPointPathRelList(xlPointPathRel);
        if(xlPointPathRelList.size() > 0){
            //有关联
            return AjaxResult.success(1);
        }else{
            //无关联
            return AjaxResult.success(0);
        }
    }

    /**
     * 校验巡更点唯一性
     * @param XlPropertyPatrolPoint
     * @return
     */
    @ResponseBody
    @RequestMapping("/checkPointNameUnique")
    public String checkPointNameUnique(XlPropertyPatrolPoint xlPropertyPatrolPoint){
        //未删除的
        xlPropertyPatrolPoint.setDelFlag(0);
        List<XlPropertyPatrolPoint> xlPropertyPatrolPointList = xlPropertyPatrolPointService.selectXlPropertyPatrolPointList(xlPropertyPatrolPoint);
        if(xlPropertyPatrolPointList.size() <= 0){
            //唯一
            return XianLinConstants.DATA_UNIQUE;
        }else{
            if(null != xlPropertyPatrolPoint.getPointId()){//非空判断
                //判断是否是当前编辑的信息
                if(xlPropertyPatrolPoint.getPointId().longValue() == xlPropertyPatrolPointList.get(0).getPointId().longValue()){
                    //唯一
                    return XianLinConstants.DATA_UNIQUE;
                }
            }
            //不唯一
            return XianLinConstants.DATA_NOT_UNIQUE;
        }
    }
}
