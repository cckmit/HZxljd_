package com.ruoyi.web.controller.system.property.info;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.XlVillageModel;
import com.ruoyi.system.domain.property.XlVisitor;
import com.ruoyi.system.service.IXlVillageService;
import com.ruoyi.system.service.property.IXlVisitorService;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@ApiOperation("物业访客记录")
@Controller
@RequestMapping("/system/property/xlvisitor")
public class XlVisitorController extends BaseController
{
    private String prefix = "system/property/xlvisitor";

    @Autowired
    private IXlVisitorService xlVisitorService;

    @Autowired
    private IXlVillageService xlVillageService;

    @RequiresPermissions("system/property:xlvisitor:view")
    @GetMapping()
    public String xlvisitor()
    {
        return prefix + "/xlvisitor";
    }

    /**
     * 查询物业--访客记录列表
     */
   // @RequiresPermissions("system/property:xlvisitor:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(XlVisitor xlVisitor)
    {
        startPage();
        //物业公司用户只能查看自己小区的信息
        Long villageId = ShiroUtils.getSysUser().getDeptId();
        xlVisitor.setVillageId(villageId);
        List<XlVisitor> list = xlVisitorService.selectXlVisitorList(xlVisitor);
        return getDataTable(list);
    }

    /**
     * 新增物业--访客记录
     */
    @GetMapping("/add")
    public String add(ModelMap mmap)
    {
        //小区
        Long villageId = ShiroUtils.getSysUser().getDeptId();
        XlVillageModel xlVillage = xlVillageService.selectXlVillageById(villageId);
        mmap.put("xlVillage",xlVillage);
        return prefix + "/add";
    }

    /**
     * 新增保存物业--访客记录
     */
 //   @RequiresPermissions("system/property:xlvisitor:add")
    @Log(title = "物业--访客记录", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(XlVisitor xlVisitor)
    {
        //小区
        xlVisitor.setVillageId(ShiroUtils.getSysUser().getDeptId());
        return toAjax(xlVisitorService.insertXlVisitor(xlVisitor));
    }
    @Log(title = "物业--访客记录", businessType = BusinessType.INSERT)
    @PostMapping("/addSaveAndroid")
    @ResponseBody
    public AjaxResult addSaveAndroid(XlVisitor xlVisitor)
    {
        //小区
        return toAjax(xlVisitorService.insertXlVisitor(xlVisitor));
    }
    /**
     * 修改物业--访客记录
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        XlVisitor xlVisitor = xlVisitorService.selectXlVisitorById(id);
        //小区
        Long villageId = ShiroUtils.getSysUser().getDeptId();
        XlVillageModel xlVillage = xlVillageService.selectXlVillageById(villageId);
        mmap.put("xlVillage",xlVillage);
        mmap.put("xlVisitor", xlVisitor);
        return prefix + "/edit";
    }

    /**
     * 修改保存物业--访客记录
     */
    @RequiresPermissions("system/property:xlvisitor:edit")
    @Log(title = "物业--访客记录", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(XlVisitor xlVisitor)
    {
        return toAjax(xlVisitorService.updateXlVisitor(xlVisitor));
    }

    /**
     * 删除物业--访客记录
     */
    @RequiresPermissions("system/property:xlvisitor:remove")
    @Log(title = "物业--访客记录", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(xlVisitorService.deleteXlVisitorByIds(ids));
    }

    /**
     * 查询物业--该物业选某天的及历史访客记录列表
     */
    @PostMapping("/listByIds")
    @ResponseBody
    public TableDataInfo listByIds(XlVisitor xlVisitor)
    {
        startPage();
        List<XlVisitor> list = xlVisitorService.selectXlVisitorListById(xlVisitor);
        return getDataTable(list);
    }
    /**
     * 查询当前物业下访客详情
     */
    @ApiOperation(value="查询当前物业下访客详情", notes="查询当前物业下访客详情")
    @PostMapping("/listByproperty")
    @ResponseBody
    public TableDataInfo listByproperty(String propertid, String propertyName, XlVisitor xlVisitor)
    {
        startPage();
        Integer[] villageId=xlVillageService.selectVillageId(propertid,propertyName);
        List<XlVisitor> list = xlVisitorService.selectXlVisitorPropertyList(villageId,xlVisitor);
        return getDataTable(list);
    }

}
