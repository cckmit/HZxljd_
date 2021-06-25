package com.ruoyi.web.controller.system;

import java.util.List;

import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.HkEClassification;
import com.ruoyi.system.service.HkEClassificationService;
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
import com.ruoyi.system.domain.XlCheckItems;
import com.ruoyi.system.service.IXlCheckItemsService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 网格员--检查项信息Controller
 * 
 * @author ruoyi
 * @date 2021-05-24
 */
@Controller
@RequestMapping("/system/checkItems")
public class XlCheckItemsController extends BaseController
{
    private String prefix = "system/checkItems";

    @Autowired
    private IXlCheckItemsService xlCheckItemsService;
    @Autowired
    private HkEClassificationService hkEClassificationService;

    @RequiresPermissions("system:checkItems:view")
    @GetMapping()
    public String checkItems()
    {
        return prefix + "/checkItems";
    }

    @GetMapping("/em")//单位管理
    public String checkItemsEM()
    {
        return "/system/societyManage/enterpriseManage/checkItems";
    }

    @GetMapping("/im")//入户走访
    public String checkItemsIM()
    {
        return "/system/societyManage/inspectionsManage/checkItems";
    }

    @GetMapping("/inm")//面上巡查
    public String checkItemsInM()
    {
        return "/system/societyManage/interviewManage/checkItems";
    }

    @GetMapping("/pm")//物业管理
    public String checkItemsPM()
    {
        return "/system/societyManage/propertyManage/checkItems";
    }

    @GetMapping("/lm")//出租房管理
    public String checkItemsLM()
    {
        return "/system/societyManage/leaseManage/checkItems";
    }

    @GetMapping("/om")//其他管理
    public String checkItemsOM()
    {
        return "/system/societyManage/otherManage/checkItems";
    }

    /**
     * 查询网格员--检查项信息列表
     */
    @RequiresPermissions("system:checkItems:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(XlCheckItems xlCheckItems)
    {
        startPage();
        List<XlCheckItems> list = xlCheckItemsService.selectXlCheckItemsList(xlCheckItems);
        return getDataTable(list);
    }

    @PostMapping("/listEnterpriseManage")
    @ResponseBody
    public TableDataInfo listEnterpriseManage(XlCheckItems xlCheckItems)
    {
        xlCheckItems.setStatus(1);
        startPage();
        List<XlCheckItems> list = xlCheckItemsService.selectXlCheckItemsList(xlCheckItems);
        return getDataTable(list);
    }

    @PostMapping("/listInspectionsManage")
    @ResponseBody
    public TableDataInfo listInspectionsManage(XlCheckItems xlCheckItems)
    {
        xlCheckItems.setStatus(2);
        startPage();
        List<XlCheckItems> list = xlCheckItemsService.selectXlCheckItemsList(xlCheckItems);
        return getDataTable(list);
    }

    @PostMapping("/listInterviewManage")
    @ResponseBody
    public TableDataInfo listInterviewManage(XlCheckItems xlCheckItems)
    {
        xlCheckItems.setStatus(3);
        startPage();
        List<XlCheckItems> list = xlCheckItemsService.selectXlCheckItemsList(xlCheckItems);
        return getDataTable(list);
    }

    @PostMapping("/listPropertyManage")
    @ResponseBody
    public TableDataInfo listPropertyManage(XlCheckItems xlCheckItems)
    {
        xlCheckItems.setStatus(4);
        startPage();
        List<XlCheckItems> list = xlCheckItemsService.selectXlCheckItemsList(xlCheckItems);
        return getDataTable(list);
    }

    @PostMapping("/listLeaseManage")
    @ResponseBody
    public TableDataInfo listLeaseManage(XlCheckItems xlCheckItems)
    {
        xlCheckItems.setStatus(5);
        startPage();
        List<XlCheckItems> list = xlCheckItemsService.selectXlCheckItemsList(xlCheckItems);
        return getDataTable(list);
    }

    @PostMapping("/listOtherManage")
    @ResponseBody
    public TableDataInfo listOtherManage(XlCheckItems xlCheckItems)
    {
        xlCheckItems.setStatus(6);
        startPage();
        List<XlCheckItems> list = xlCheckItemsService.selectXlCheckItemsList(xlCheckItems);
        return getDataTable(list);
    }

    /**
     * 导出网格员--检查项信息列表
     */
    @RequiresPermissions("system:checkItems:export")
    @Log(title = "网格员--检查项信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(XlCheckItems xlCheckItems)
    {
        List<XlCheckItems> list = xlCheckItemsService.selectXlCheckItemsList(xlCheckItems);
        ExcelUtil<XlCheckItems> util = new ExcelUtil<XlCheckItems>(XlCheckItems.class);
        return util.exportExcel(list, "checkItems");
    }

    /**
     * 新增网格员--检查项信息
     */
    @GetMapping("/add")
    public String add(ModelMap mmap)
    {
        List<HkEClassification> list = hkEClassificationService.findEclass();
        mmap.put("list", list);
        return prefix + "/add";
    }

    //网格-单位管理
    @GetMapping("/addEM")
    public String addEM(ModelMap mmap)
    {
        List<HkEClassification> list = hkEClassificationService.findEclass();
        mmap.put("list", list);
        return "/system/societyManage/enterpriseManage/addCheckItems";
    }

    //网格-入户走访
    @GetMapping("/addIM")
    public String addIM(ModelMap mmap)
    {
        List<HkEClassification> list = hkEClassificationService.findEclass();
        mmap.put("list", list);
        return "/system/societyManage/inspectionsManage/addCheckItems";
    }

    //网格-面上巡查
    @GetMapping("/addInM")
    public String addInM(ModelMap mmap)
    {
        List<HkEClassification> list = hkEClassificationService.findEclass();
        mmap.put("list", list);
        return "/system/societyManage/interviewManage/addCheckItems";
    }

    //网格-物业管理
    @GetMapping("/addPM")
    public String addPM(ModelMap mmap)
    {
        List<HkEClassification> list = hkEClassificationService.findEclass();
        mmap.put("list", list);
        return "/system/societyManage/propertyManage/addCheckItems";
    }

    //网格-出租房管理
    @GetMapping("/addLM")
    public String addLM(ModelMap mmap)
    {
        List<HkEClassification> list = hkEClassificationService.findEclass();
        mmap.put("list", list);
        return "/system/societyManage/leaseManage/addCheckItems";
    }

    //网格-其他管理
    @GetMapping("/addOM")
    public String addOM(ModelMap mmap)
    {
        List<HkEClassification> list = hkEClassificationService.findEclass();
        mmap.put("list", list);
        return "/system/societyManage/otherManage/addCheckItems";
    }

    /**
     * 新增保存网格员--检查项信息
     */
    @RequiresPermissions("system:checkItems:add")
    @Log(title = "网格员--检查项信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(XlCheckItems xlCheckItems)
    {
        xlCheckItems.setCreateUser(ShiroUtils.getLoginName());
        return toAjax(xlCheckItemsService.insertXlCheckItems(xlCheckItems));
    }

    /**
     * 修改网格员--检查项信息
     */
    @GetMapping("/edit/{checkId}")
    public String edit(@PathVariable("checkId") Long checkId, ModelMap mmap)
    {
        XlCheckItems xlCheckItems = xlCheckItemsService.selectXlCheckItemsById(checkId);
        List<HkEClassification> list = hkEClassificationService.findEclass();
        mmap.put("list", list);
        mmap.put("xlCheckItems", xlCheckItems);
        return prefix + "/edit";
    }

    /**
     * 修改保存网格员--检查项信息
     */
    @RequiresPermissions("system:checkItems:edit")
    @Log(title = "网格员--检查项信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(XlCheckItems xlCheckItems)
    {
        xlCheckItems.setUpdateUser(ShiroUtils.getLoginName());
        return toAjax(xlCheckItemsService.updateXlCheckItems(xlCheckItems));
    }

    /**
     * 删除网格员--检查项信息
     */
    @RequiresPermissions("system:checkItems:remove")
    @Log(title = "网格员--检查项信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(xlCheckItemsService.deleteXlCheckItemsByIds(ids));
    }
}
