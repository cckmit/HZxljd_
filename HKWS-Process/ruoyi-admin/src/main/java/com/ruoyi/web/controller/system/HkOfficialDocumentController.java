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
import com.ruoyi.system.domain.HkOfficialDocument;
import com.ruoyi.system.service.IHkOfficialDocumentService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 公文管理Controller
 * 
 * @author ruoyi
 * @date 2021-03-10
 */
@Controller
@RequestMapping("/system/document")
public class HkOfficialDocumentController extends BaseController
{
    private String prefix = "system/document";

    @Autowired
    private IHkOfficialDocumentService hkOfficialDocumentService;

    @RequiresPermissions("system:document:view")
    @GetMapping()
    public String document()
    {
        return prefix + "/document";
    }

    /**
     * 查询公文管理列表
     */
    @RequiresPermissions("system:document:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HkOfficialDocument hkOfficialDocument)
    {
        startPage();
        List<HkOfficialDocument> list = hkOfficialDocumentService.selectHkOfficialDocumentList(hkOfficialDocument);
        return getDataTable(list);
    }

    /**
     * 导出公文管理列表
     */
    @RequiresPermissions("system:document:export")
    @Log(title = "公文管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HkOfficialDocument hkOfficialDocument)
    {
        List<HkOfficialDocument> list = hkOfficialDocumentService.selectHkOfficialDocumentList(hkOfficialDocument);
        ExcelUtil<HkOfficialDocument> util = new ExcelUtil<HkOfficialDocument>(HkOfficialDocument.class);
        return util.exportExcel(list, "document");
    }

    /**
     * 新增公文管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存公文管理
     */
    @RequiresPermissions("system:document:add")
    @Log(title = "公文管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HkOfficialDocument hkOfficialDocument)
    {
        return toAjax(hkOfficialDocumentService.insertHkOfficialDocument(hkOfficialDocument));
    }

    /**
     * 修改公文管理
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        HkOfficialDocument hkOfficialDocument = hkOfficialDocumentService.selectHkOfficialDocumentById(id);
        mmap.put("hkOfficialDocument", hkOfficialDocument);
        return prefix + "/edit";
    }

    /**
     * 修改保存公文管理
     */
    @RequiresPermissions("system:document:edit")
    @Log(title = "公文管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HkOfficialDocument hkOfficialDocument)
    {
        return toAjax(hkOfficialDocumentService.updateHkOfficialDocument(hkOfficialDocument));
    }

    /**
     * 删除公文管理
     */
    @RequiresPermissions("system:document:remove")
    @Log(title = "公文管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hkOfficialDocumentService.deleteHkOfficialDocumentByIds(ids));
    }
}
