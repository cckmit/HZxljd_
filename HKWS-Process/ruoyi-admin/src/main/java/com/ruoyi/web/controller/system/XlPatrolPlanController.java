package com.ruoyi.web.controller.system;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.XlPatrolPlan;
import com.ruoyi.system.service.IXlPatrolPlanService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.context.request.WebRequest;

/**
 * 网格员--巡查计划Controller
 * 
 * @author ruoyi
 * @date 2021-05-22
 */
@Controller
@RequestMapping("/system/plan")
public class XlPatrolPlanController extends BaseController
{
    private String prefix = "system/plan";

    @Autowired
    private IXlPatrolPlanService xlPatrolPlanService;

    @RequiresPermissions("system:plan:view")
    @GetMapping()
    public String plan()
    {
        return prefix + "/plan";
    }

    @GetMapping("/em")//单位管理
    public String planEM()
    {
        return "/system/societyManage/enterpriseManage/plan";
    }

    @GetMapping("/im")//入户走访
    public String planIM()
    {
        return "/system/societyManage/inspectionsManage/plan";
    }

    @GetMapping("/inm")//面上巡查
    public String planInM()
    {
        return "/system/societyManage/interviewManage/plan";
    }

    @GetMapping("/pm")//物业管理
    public String planPM()
    {
        return "/system/societyManage/propertyManage/plan";
    }

    @GetMapping("/lm")//出租房管理
    public String planLM()
    {
        return "/system/societyManage/leaseManage/plan";
    }

    @GetMapping("/om")//其他管理
    public String planOM()
    {
        return "/system/societyManage/otherManage/plan";
    }

    /**
     * 查询网格员--巡查计划列表
     */
    @RequiresPermissions("system:plan:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(XlPatrolPlan xlPatrolPlan)
    {
        startPage();
        List<XlPatrolPlan> list = xlPatrolPlanService.selectXlPatrolPlanList(xlPatrolPlan);
        return getDataTable(list);
    }

    @PostMapping("/listEnterpriseManage")
    @ResponseBody
    public TableDataInfo listEnterpriseManage(XlPatrolPlan xlPatrolPlan)
    {
        xlPatrolPlan.setStatus(1);
        startPage();
        List<XlPatrolPlan> list = xlPatrolPlanService.selectXlPatrolPlanList(xlPatrolPlan);
        return getDataTable(list);
    }

    @PostMapping("/listInspectionsManage")
    @ResponseBody
    public TableDataInfo listInspectionsManage(XlPatrolPlan xlPatrolPlan)
    {
        xlPatrolPlan.setStatus(2);
        startPage();
        List<XlPatrolPlan> list = xlPatrolPlanService.selectXlPatrolPlanList(xlPatrolPlan);
        return getDataTable(list);
    }

    @PostMapping("/listInterviewManage")
    @ResponseBody
    public TableDataInfo listInterviewManage(XlPatrolPlan xlPatrolPlan)
    {
        xlPatrolPlan.setStatus(3);
        startPage();
        List<XlPatrolPlan> list = xlPatrolPlanService.selectXlPatrolPlanList(xlPatrolPlan);
        return getDataTable(list);
    }

    @PostMapping("/listPropertyManage")
    @ResponseBody
    public TableDataInfo listPropertyManage(XlPatrolPlan xlPatrolPlan)
    {
        xlPatrolPlan.setStatus(4);
        startPage();
        List<XlPatrolPlan> list = xlPatrolPlanService.selectXlPatrolPlanList(xlPatrolPlan);
        return getDataTable(list);
    }

    @PostMapping("/listLeaseManage")
    @ResponseBody
    public TableDataInfo listLeaseManage(XlPatrolPlan xlPatrolPlan)
    {
        xlPatrolPlan.setStatus(5);
        startPage();
        List<XlPatrolPlan> list = xlPatrolPlanService.selectXlPatrolPlanList(xlPatrolPlan);
        return getDataTable(list);
    }

    @PostMapping("/listOtherManage")
    @ResponseBody
    public TableDataInfo listOtherManage(XlPatrolPlan xlPatrolPlan)
    {
        xlPatrolPlan.setStatus(6);
        startPage();
        List<XlPatrolPlan> list = xlPatrolPlanService.selectXlPatrolPlanList(xlPatrolPlan);
        return getDataTable(list);
    }

    /**
     * 导出网格员--巡查计划列表
     */
    @RequiresPermissions("system:plan:export")
    @Log(title = "网格员--巡查计划", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(XlPatrolPlan xlPatrolPlan)
    {
        List<XlPatrolPlan> list = xlPatrolPlanService.selectXlPatrolPlanList(xlPatrolPlan);
        ExcelUtil<XlPatrolPlan> util = new ExcelUtil<XlPatrolPlan>(XlPatrolPlan.class);
        return util.exportExcel(list, "plan");
    }

    /**
     * 新增网格员--巡查计划
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    //网格-单位管理新增
    @GetMapping("/addEM")
    public String addEM()
    {
        return "/system/societyManage/enterpriseManage/addPlan";
    }

    //网格-入户巡查新增
    @GetMapping("/addIM")
    public String addIM()
    {
        return "/system/societyManage/inspectionsManage/addPlan";
    }

    //网格-面上巡查新增
    @GetMapping("/addInM")
    public String addInM()
    {
        return "/system/societyManage/interviewManage/addPlan";
    }

    //网格-物业管理新增
    @GetMapping("/addPM")
    public String addPM()
    {
        return "/system/societyManage/propertyManage/addPlan";
    }

    //网格-出租房管理新增
    @GetMapping("/addLM")
    public String addLM()
    {
        return "/system/societyManage/leaseManage/addPlan";
    }

    //网格-其他管理新增
    @GetMapping("/addOM")
    public String addOM()
    {
        return "/system/societyManage/otherManage/addPlan";
    }

    /**
     * 新增保存网格员--巡查计划
     */
    @RequiresPermissions("system:plan:add")
    @Log(title = "网格员--巡查计划", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(XlPatrolPlan xlPatrolPlan)
    {
        return toAjax(xlPatrolPlanService.insertXlPatrolPlan(xlPatrolPlan));
    }

    /**
     * 修改网格员--巡查计划
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        XlPatrolPlan xlPatrolPlan = xlPatrolPlanService.selectXlPatrolPlanById(id);
        mmap.put("xlPatrolPlan", xlPatrolPlan);
        return prefix + "/edit";
    }

    /**
     * 修改保存网格员--巡查计划
     */
    @RequiresPermissions("system:plan:edit")
    @Log(title = "网格员--巡查计划", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(XlPatrolPlan xlPatrolPlan)
    {
        return toAjax(xlPatrolPlanService.updateXlPatrolPlan(xlPatrolPlan));
    }

    /**
     * 删除网格员--巡查计划
     */
    @RequiresPermissions("system:plan:remove")
    @Log(title = "网格员--巡查计划", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(xlPatrolPlanService.deleteXlPatrolPlanByIds(ids));
    }
}
