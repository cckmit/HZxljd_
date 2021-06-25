package com.ruoyi.web.controller.system;

import java.util.List;

import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.SysRegion;
import com.ruoyi.system.domain.XlCheckItems;
import com.ruoyi.system.domain.XlPatrolPlan;
import com.ruoyi.system.service.ISysRegionService;
import com.ruoyi.system.service.IXlCheckItemsService;
import com.ruoyi.system.service.IXlPatrolPlanService;
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
import com.ruoyi.system.domain.XlInspectionTeam;
import com.ruoyi.system.service.IXlInspectionTeamService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 网格员--检查组信息Controller
 *
 * @author ruoyi
 * @date 2021-05-22
 */
@Controller
@RequestMapping("/system/inspectionTeam")
public class XlInspectionTeamController extends BaseController {
    private String prefix = "system/inspectionTeam";
    XlCheckItems xlCheckItems = new XlCheckItems();

    @Autowired
    private IXlInspectionTeamService xlInspectionTeamService;
    @Autowired
    private IXlPatrolPlanService xlPatrolService;
    @Autowired
    private IXlCheckItemsService xlCheckItemsService;
    @Autowired
    private ISysRegionService regionService;

    @RequiresPermissions("system:inspectionTeam:view")
    @GetMapping()
    public String inspectionTeam() {
        return prefix + "/inspectionTeam";
    }

    @GetMapping("/em")//单位管理
    public String inspectionTeamEM()
    {
        return "/system/societyManage/enterpriseManage/inspectionTeam";
    }

    @GetMapping("/im")//入户走访
    public String inspectionTeamIM()
    {
        return "/system/societyManage/inspectionsManage/inspectionTeam";
    }

    @GetMapping("/inm")//面上巡查
    public String inspectionTeamInM()
    {
        return "/system/societyManage/interviewManage/inspectionTeam";
    }

    @GetMapping("/pm")//物业管理
    public String inspectionTeamPM()
    {
        return "/system/societyManage/propertyManage/inspectionTeam";
    }

    @GetMapping("/lm")//出租房管理
    public String inspectionTeamLM()
    {
        return "/system/societyManage/leaseManage/inspectionTeam";
    }

    @GetMapping("/om")//其他管理
    public String inspectionTeamOM()
    {
        return "/system/societyManage/otherManage/inspectionTeam";
    }


    /**
     * 查询网格员--检查组信息列表
     */
    @RequiresPermissions("system:inspectionTeam:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(XlInspectionTeam xlInspectionTeam) {
        startPage();
        List<XlInspectionTeam> list = xlInspectionTeamService.selectXlInspectionTeamList(xlInspectionTeam);
        return getDataTable(list);
    }


    @PostMapping("/listEnterpriseManage")
    @ResponseBody
    public TableDataInfo listEnterpriseManage(XlInspectionTeam xlInspectionTeam) {
        xlInspectionTeam.setStatus(1);
        startPage();
        List<XlInspectionTeam> list = xlInspectionTeamService.selectXlInspectionTeamList(xlInspectionTeam);
        return getDataTable(list);
    }

    @PostMapping("/listInspectionManage")
    @ResponseBody
    public TableDataInfo listInspectionsManage(XlInspectionTeam xlInspectionTeam) {
        xlInspectionTeam.setStatus(2);
        startPage();
        List<XlInspectionTeam> list = xlInspectionTeamService.selectXlInspectionTeamList(xlInspectionTeam);
        return getDataTable(list);
    }

    @PostMapping("/listInterviewManage")
    @ResponseBody
    public TableDataInfo listInterviewManage(XlInspectionTeam xlInspectionTeam) {
        xlInspectionTeam.setStatus(3);
        startPage();
        List<XlInspectionTeam> list = xlInspectionTeamService.selectXlInspectionTeamList(xlInspectionTeam);
        return getDataTable(list);
    }

    @PostMapping("/listPropertyManage")
    @ResponseBody
    public TableDataInfo listPropertyManage(XlInspectionTeam xlInspectionTeam) {
        xlInspectionTeam.setStatus(4);
        startPage();
        List<XlInspectionTeam> list = xlInspectionTeamService.selectXlInspectionTeamList(xlInspectionTeam);
        return getDataTable(list);
    }

    @PostMapping("/listLeaseManage")
    @ResponseBody
    public TableDataInfo listLeaseManage(XlInspectionTeam xlInspectionTeam) {
        xlInspectionTeam.setStatus(5);
        startPage();
        List<XlInspectionTeam> list = xlInspectionTeamService.selectXlInspectionTeamList(xlInspectionTeam);
        return getDataTable(list);
    }

    @PostMapping("/listOtherManage")
    @ResponseBody
    public TableDataInfo listOtherManage(XlInspectionTeam xlInspectionTeam) {
        xlInspectionTeam.setStatus(6);
        startPage();
        List<XlInspectionTeam> list = xlInspectionTeamService.selectXlInspectionTeamList(xlInspectionTeam);
        return getDataTable(list);
    }

    /**
     * 导出网格员--检查组信息列表
     */
    @RequiresPermissions("system:inspectionTeam:export")
    @Log(title = "网格员--检查组信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(XlInspectionTeam xlInspectionTeam) {
        List<XlInspectionTeam> list = xlInspectionTeamService.selectXlInspectionTeamList(xlInspectionTeam);
        ExcelUtil<XlInspectionTeam> util = new ExcelUtil<XlInspectionTeam>(XlInspectionTeam.class);
        return util.exportExcel(list, "inspectionTeam");
    }

    //嵌套表格
    @PostMapping("/listChecks")
    @ResponseBody
    public TableDataInfo listChecks() {
        List<XlCheckItems> list = xlCheckItemsService.selectXlCheckItemsList(new XlCheckItems());
        return getDataTable(list);
    }

    //嵌套表格-单位管理分类
    @PostMapping("/listChecksEM")
    @ResponseBody
    public TableDataInfo listChecksEM() {
        xlCheckItems.setStatus(1);
        List<XlCheckItems> list = xlCheckItemsService.selectXlCheckItemsList(xlCheckItems);
        return getDataTable(list);
    }

    //嵌套表格-入户走访分类
    @PostMapping("/listChecksIM")
    @ResponseBody
    public TableDataInfo listChecksIM() {
        xlCheckItems.setStatus(2);
        List<XlCheckItems> list = xlCheckItemsService.selectXlCheckItemsList(xlCheckItems);
        return getDataTable(list);
    }

    //嵌套表格-面上巡查分类
    @PostMapping("/listChecksInM")
    @ResponseBody
    public TableDataInfo listChecksInM() {
        xlCheckItems.setStatus(3);
        List<XlCheckItems> list = xlCheckItemsService.selectXlCheckItemsList(xlCheckItems);
        return getDataTable(list);
    }

    //嵌套表格-物业管理分类
    @PostMapping("/listChecksPM")
    @ResponseBody
    public TableDataInfo listChecksPM() {
        xlCheckItems.setStatus(4);
        List<XlCheckItems> list = xlCheckItemsService.selectXlCheckItemsList(xlCheckItems);
        return getDataTable(list);
    }

    //嵌套表格-出租房管理分类
    @PostMapping("/listChecksLM")
    @ResponseBody
    public TableDataInfo listChecksLM() {
        xlCheckItems.setStatus(5);
        List<XlCheckItems> list = xlCheckItemsService.selectXlCheckItemsList(xlCheckItems);
        return getDataTable(list);
    }

    //嵌套表格-其他管理分类
    @PostMapping("/listChecksOM")
    @ResponseBody
    public TableDataInfo listChecksOM() {
        xlCheckItems.setStatus(6);
        List<XlCheckItems> list = xlCheckItemsService.selectXlCheckItemsList(xlCheckItems);
        return getDataTable(list);
    }

    /**
     * 新增网格员--检查组信息
     */
     @GetMapping("/add")
     public String add(ModelMap mmap) {
         List<XlPatrolPlan> planList = xlPatrolService.selectXlPatrolPlanList(new XlPatrolPlan());
         mmap.put("planList", planList);//检查计划数据
         return prefix + "/add";
     }

    @GetMapping("/addEM")
    public String addEM(ModelMap mmap) {
        XlPatrolPlan xlPatrolPlan = new XlPatrolPlan();
        xlPatrolPlan.setStatus(1);
        List<XlPatrolPlan> planList = xlPatrolService.selectXlPatrolPlanList(xlPatrolPlan);
        mmap.put("planList", planList);//检查计划数据
        return "/system/societyManage/enterpriseManage/addInspectionTeam";
    }

    @GetMapping("/addIM")
    public String addIM(ModelMap mmap) {
         XlPatrolPlan xlPatrolPlan = new XlPatrolPlan();
         xlPatrolPlan.setStatus(2);
        List<XlPatrolPlan> planList = xlPatrolService.selectXlPatrolPlanList(xlPatrolPlan);
        mmap.put("planList", planList);//检查计划数据
        return "/system/societyManage/inspectionsManage/addInspectionTeam";
    }

    @GetMapping("/addInM")
    public String addInM(ModelMap mmap) {
        XlPatrolPlan xlPatrolPlan = new XlPatrolPlan();
        xlPatrolPlan.setStatus(3);
        List<XlPatrolPlan> planList = xlPatrolService.selectXlPatrolPlanList(xlPatrolPlan);
        mmap.put("planList", planList);//检查计划数据
        return "/system/societyManage/interviewManage/addInspectionTeam";
    }

    @GetMapping("/addPM")
    public String addPM(ModelMap mmap) {
        XlPatrolPlan xlPatrolPlan = new XlPatrolPlan();
        xlPatrolPlan.setStatus(4);
        List<XlPatrolPlan> planList = xlPatrolService.selectXlPatrolPlanList(xlPatrolPlan);
        mmap.put("planList", planList);//检查计划数据
        return "/system/societyManage/propertyManage/addInspectionTeam";
    }

    @GetMapping("/addLM")
    public String addLM(ModelMap mmap) {
        XlPatrolPlan xlPatrolPlan = new XlPatrolPlan();
        xlPatrolPlan.setStatus(5);
        List<XlPatrolPlan> planList = xlPatrolService.selectXlPatrolPlanList(xlPatrolPlan);
        mmap.put("planList", planList);//检查计划数据
        return "/system/societyManage/leaseManage/addInspectionTeam";
    }

    @GetMapping("/addOM")
    public String addOM(ModelMap mmap) {
        XlPatrolPlan xlPatrolPlan = new XlPatrolPlan();
        xlPatrolPlan.setStatus(6);
        List<XlPatrolPlan> planList = xlPatrolService.selectXlPatrolPlanList(xlPatrolPlan);
        mmap.put("planList", planList);//检查计划数据
        return "/system/societyManage/otherManage/addInspectionTeam";
    }

    /**
     * 新增保存网格员--检查组信息
     */
    @RequiresPermissions("system:inspectionTeam:add")
    @Log(title = "网格员--检查组信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(XlInspectionTeam xlInspectionTeam) {
        xlInspectionTeam.setCreateUser(ShiroUtils.getLoginName());
        Long teamId = xlInspectionTeamService.insertXlInspectionTeam(xlInspectionTeam);
        if(!xlInspectionTeam.getChecks().trim().isEmpty()){
            String[] ids = xlInspectionTeam.getChecks().split(",");
            for (String id : ids) {
                xlInspectionTeamService.insertTeamAndCheck(teamId,id);
            }
        }
        if (teamId != 0 && teamId != null) {
            return toAjax(1);//success
        }
        return toAjax(0);//error
    }

    /**
     * 修改网格员--检查组信息
     */
    @GetMapping("/edit/{teamId}")
    public String edit(@PathVariable("teamId") Long teamId, ModelMap mmap) {
        XlInspectionTeam xlInspectionTeam = xlInspectionTeamService.selectXlInspectionTeamById(teamId);
        XlPatrolPlan xlPatrolPlan = new XlPatrolPlan();
        xlPatrolPlan.setStatus(xlInspectionTeam.getStatus());
        List<XlPatrolPlan> planList = xlPatrolService.selectXlPatrolPlanList(xlPatrolPlan);
        List<Integer> checkids = xlInspectionTeamService.selectChecksByTeamId(teamId);
        List<XlCheckItems> checkedList = xlCheckItemsService.selectXlCheckedList(teamId);
        String checks = checkids.toString();
        mmap.put("xlInspectionTeam", xlInspectionTeam);
        mmap.put("planList", planList);//检查计划数据
        mmap.put("checks", checks);//检查组关联的检查项数据
        mmap.put("checkedList", checkedList);//检查项数据
        String url = "";
        switch(xlInspectionTeam.getStatus()){
            case 1:
                url = "/system/societyManage/enterpriseManage/editInspectionTeam";
                break;
            case 2 :
                url = "/system/societyManage/inspectionsManage/editInspectionTeam";
                break;
            case 3 :
                url = "/system/societyManage/interviewManage/editInspectionTeam";
                break;
            case 4 :
                url = "/system/societyManage/propertyManage/editInspectionTeam";
                break;
            case 5 :
                url = "/system/societyManage/leaseManage/editInspectionTeam";
                break;
            case 6 :
                url = "/system/societyManage/otherManage/editInspectionTeam";
                break;
            default :
                url = "/system/inspectionTeam/edit";
        }
        return url;
    }

    /**
     * 修改保存网格员--检查组信息
     */
    @RequiresPermissions("system:inspectionTeam:edit")
    @Log(title = "网格员--检查组信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(XlInspectionTeam xlInspectionTeam) {
        xlInspectionTeamService.deleteTeamAndChecksByTeamId(xlInspectionTeam.getTeamId());
        xlInspectionTeam.setUpdateUser(ShiroUtils.getLoginName());
        if(!xlInspectionTeam.getChecks().trim().isEmpty()){
            String[] ids = xlInspectionTeam.getChecks().split(",");
            for (String id : ids) {
                xlInspectionTeamService.insertTeamAndCheck(xlInspectionTeam.getTeamId(),id);
            }
        }
        return toAjax(xlInspectionTeamService.updateXlInspectionTeam(xlInspectionTeam));
    }

    /**
     * 删除网格员--检查组信息
     */
    @RequiresPermissions("system:inspectionTeam:remove")
    @Log(title = "网格员--检查组信息", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(xlInspectionTeamService.deleteXlInspectionTeamByIds(ids));
    }

    //根据检查组id跳转到应用界面
    @GetMapping("/applyEM/{teamId}")
    public String applyEM(@PathVariable("teamId") Long teamId, ModelMap mmap) {
        mmap.put("teamId", teamId);
        return "/system/societyManage/enterpriseManage/applyEnterprise";
    }

    //根据检查组id跳转到应用界面
    @GetMapping("/applyIM/{teamId}")
    public String applyIM(@PathVariable("teamId") Long teamId, ModelMap mmap) {
        mmap.put("teamId", teamId);
        return "/system/societyManage/inspectionsManage/applyPersonnel";
    }

    //根据检查组id跳转到应用界面
    @GetMapping("/applyInM/{teamId}")
    public String applyInM(@PathVariable("teamId") Long teamId, ModelMap mmap) {
        mmap.put("teamId", teamId);
        return "/system/societyManage/interviewManage/applyInterview";
    }

    //根据检查组id跳转到应用界面
    @GetMapping("/applyPM/{teamId}")
    public String applyPM(@PathVariable("teamId") Long teamId, ModelMap mmap) {
        mmap.put("teamId", teamId);
        return "/system/societyManage/propertyManage/applyProperty";
    }

    //根据检查组id跳转到应用界面
    @GetMapping("/applyLM/{teamId}")
    public String applyLM(@PathVariable("teamId") Long teamId, ModelMap mmap) {
        mmap.put("teamId", teamId);
        return "/system/societyManage/leaseManage/applyLease";
    }

    //根据检查组id跳转到应用界面
    @GetMapping("/applyOM/{teamId}")
    public String applyOM(@PathVariable("teamId") Long teamId, ModelMap mmap) {
        mmap.put("teamId", teamId);
        return "/system/societyManage/otherManage/applyOther";
    }
}
