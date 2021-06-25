package com.ruoyi.web.controller.system;

import java.util.List;

import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.XlAssessmentItems;
import com.ruoyi.system.domain.XlScoringItems;
import com.ruoyi.system.service.IXlAssessmentItemsService;
import com.ruoyi.system.service.IXlScoringItemsService;
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
import com.ruoyi.system.domain.XlSubdivide;
import com.ruoyi.system.service.IXlSubdivideService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 网格员--考核细分项Controller
 *
 * @author ruoyi
 * @date 2021-05-31
 */
@Controller
@RequestMapping("/system/societyManage/assessmentManage/subdivide")
public class XlSubdivideController extends BaseController {
    private String prefix = "system/societyManage/assessmentManage/subdivide";

    @Autowired
    private IXlSubdivideService xlSubdivideService;
    @Autowired
    private IXlAssessmentItemsService assessmentItemsService;
    @Autowired
    private IXlScoringItemsService xlScoringItemsService;

    @RequiresPermissions("system:subdivide:view")
    @GetMapping()
    public String subdivide() {
        return prefix + "/subdivide";
    }

    /**
     * 查询网格员--考核细分项列表
     */
    @RequiresPermissions("system:subdivide:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(XlSubdivide xlSubdivide) {
        startPage();
        List<XlSubdivide> list = xlSubdivideService.selectXlSubdivideList(xlSubdivide);
        return getDataTable(list);
    }

    /**
     * 导出网格员--考核细分项列表
     */
    @RequiresPermissions("system:subdivide:export")
    @Log(title = "网格员--考核细分项", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(XlSubdivide xlSubdivide) {
        List<XlSubdivide> list = xlSubdivideService.selectXlSubdivideList(xlSubdivide);
        ExcelUtil<XlSubdivide> util = new ExcelUtil<XlSubdivide>(XlSubdivide.class);
        return util.exportExcel(list, "subdivide");
    }

    /**
     * 新增网格员--考核细分项
     */
    @GetMapping("/add")
    public String add(ModelMap mmap) {
        List<XlAssessmentItems> list = assessmentItemsService.selectXlAssessmentItemsList(new XlAssessmentItems());
        mmap.put("list", list);
        return prefix + "/add";
    }

    /**
     * 新增保存网格员--考核细分项
     */
    @RequiresPermissions("system:subdivide:add")
    @Log(title = "网格员--考核细分项", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(XlSubdivide xlSubdivide) {
        xlSubdivide.setCreateUser(ShiroUtils.getLoginName());
        return toAjax(xlSubdivideService.insertXlSubdivide(xlSubdivide));
    }

    /**
     * 修改网格员--考核细分项
     */
    @GetMapping("/edit/{subdivideId}")
    public String edit(@PathVariable("subdivideId") Long subdivideId, ModelMap mmap) {
        XlSubdivide xlSubdivide = xlSubdivideService.selectXlSubdivideById(subdivideId);
        List<XlAssessmentItems> list = assessmentItemsService.selectXlAssessmentItemsList(new XlAssessmentItems());
        mmap.put("xlSubdivide", xlSubdivide);
        mmap.put("list", list);
        return prefix + "/edit";
    }

    /**
     * 修改保存网格员--考核细分项
     */
    @RequiresPermissions("system:subdivide:edit")
    @Log(title = "网格员--考核细分项", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(XlSubdivide xlSubdivide) {
        xlSubdivide.setUpdateUser(ShiroUtils.getLoginName());
        return toAjax(xlSubdivideService.updateXlSubdivide(xlSubdivide));
    }

    /**
     * 删除网格员--考核细分项
     */
    @RequiresPermissions("system:subdivide:remove")
    @Log(title = "网格员--考核细分项", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(xlSubdivideService.deleteXlSubdivideByIds(ids));
    }

    /**
     * 查看网格员--考核细分项
     */
    @GetMapping("/detail/{subdivideId}")
    public String detail(@PathVariable("subdivideId") Long subdivideId, ModelMap mmap) {
        XlSubdivide xlSubdivide = xlSubdivideService.selectXlSubdivideById(subdivideId);
        List<String> deptNameList = xlSubdivideService.selectDeptNamesBySubdivideId(subdivideId);
        deptNameList.remove(null);
        if (deptNameList.size()!=0){
            xlSubdivide.setDeptNames(deptNameList.toString());
        }else {
            xlSubdivide.setDeptNames("无");
        }
        XlScoringItems xlScoringItems = new XlScoringItems();
        xlScoringItems.setSubdivideId(subdivideId);
        List<XlScoringItems> xlScoringItemsList = xlScoringItemsService.selectXlScoringItemsList(xlScoringItems);
        mmap.put("xlSubdivide", xlSubdivide);
        mmap.put("xlScoringItemsList",xlScoringItemsList);
        return prefix + "/detail";
    }

    //列表界面初始化检查项数据用于关联查询
    @GetMapping("/assessmentList")
    @ResponseBody
    public List<XlAssessmentItems> list() {
        List<XlAssessmentItems> list = assessmentItemsService.selectXlAssessmentItemsList(new XlAssessmentItems());
        return list;
    }
}
