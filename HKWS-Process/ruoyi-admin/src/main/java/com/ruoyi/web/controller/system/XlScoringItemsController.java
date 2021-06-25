package com.ruoyi.web.controller.system;

import java.util.List;

import com.ruoyi.system.domain.SysDept;
import com.ruoyi.system.domain.XlSubdivide;
import com.ruoyi.system.service.ISysDeptService;
import com.ruoyi.system.service.IXlSubdivideService;
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
import com.ruoyi.system.domain.XlScoringItems;
import com.ruoyi.system.service.IXlScoringItemsService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 网格-考核评分项Controller
 *
 * @author ruoyi
 * @date 2021-05-31
 */
@Controller
@RequestMapping("/system/societyManage/assessmentManage/scoringItems")
public class XlScoringItemsController extends BaseController {
    private String prefix = "system/societyManage/assessmentManage/scoringItems";

    @Autowired
    private IXlScoringItemsService xlScoringItemsService;
    @Autowired
    private IXlSubdivideService xlSubdivideService;
    @Autowired
    private ISysDeptService sysDeptService;

    @RequiresPermissions("system:scoringItems:view")
    @GetMapping()
    public String scoringItems() {
        return prefix + "/scoringItems";
    }

    /**
     * 查询网格-考核评分项列表
     */
    @RequiresPermissions("system:scoringItems:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(XlScoringItems xlScoringItems) {
        startPage();
        List<XlScoringItems> list = xlScoringItemsService.selectXlScoringItemsList(xlScoringItems);
        return getDataTable(list);
    }

    /**
     * 导出网格-考核评分项列表
     */
    @RequiresPermissions("system:scoringItems:export")
    @Log(title = "网格-考核评分项", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(XlScoringItems xlScoringItems) {
        List<XlScoringItems> list = xlScoringItemsService.selectXlScoringItemsList(xlScoringItems);
        ExcelUtil<XlScoringItems> util = new ExcelUtil<XlScoringItems>(XlScoringItems.class);
        return util.exportExcel(list, "scoringItems");
    }

    /**
     * 新增网格-考核评分项
     */
    @GetMapping("/add")
    public String add(ModelMap mmap) {
        List<XlSubdivide> list = xlSubdivideService.selectXlSubdivideList(new XlSubdivide());
        List<SysDept> deptList = sysDeptService.selectDeptList(new SysDept());
        mmap.put("list", list);
        mmap.put("deptList", deptList);
        return prefix + "/add";
    }

    //下拉搜索单位列表
    @GetMapping("/deptList")
    @ResponseBody
    public List<SysDept> deptList(){
        List<SysDept> deptList = sysDeptService.selectDeptList(new SysDept());
        return deptList;
    }

    /**
     * 新增保存网格-考核评分项
     */
    @RequiresPermissions("system:scoringItems:add")
    @Log(title = "网格-考核评分项", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(XlScoringItems xlScoringItems) {
        return toAjax(xlScoringItemsService.insertXlScoringItems(xlScoringItems));
    }

    /**
     * 修改网格-考核评分项
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        XlScoringItems xlScoringItems = xlScoringItemsService.selectXlScoringItemsById(id);
        List<XlSubdivide> list = xlSubdivideService.selectXlSubdivideList(new XlSubdivide());
        List<SysDept> deptList = sysDeptService.selectDeptList(new SysDept());
        mmap.put("xlScoringItems", xlScoringItems);
        mmap.put("list", list);
        mmap.put("deptList", deptList);
        return prefix + "/edit";
    }

    /**
     * 修改保存网格-考核评分项
     */
    @RequiresPermissions("system:scoringItems:edit")
    @Log(title = "网格-考核评分项", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(XlScoringItems xlScoringItems) {
        return toAjax(xlScoringItemsService.updateXlScoringItems(xlScoringItems));
    }

    /**
     * 删除网格-考核评分项
     */
    @RequiresPermissions("system:scoringItems:remove")
    @Log(title = "网格-考核评分项", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(xlScoringItemsService.deleteXlScoringItemsByIds(ids));
    }

    /**列表界面初始化细分项数据*/
    @GetMapping("/subdivideList")
    @ResponseBody
    public List<XlSubdivide> list(){
        List<XlSubdivide> list = xlSubdivideService.selectXlSubdivideList(new XlSubdivide());
        return list;
    }
}
