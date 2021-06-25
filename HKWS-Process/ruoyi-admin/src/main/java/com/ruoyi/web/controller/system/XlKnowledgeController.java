package com.ruoyi.web.controller.system;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.XlKnowledge;
import com.ruoyi.system.service.IXlKnowledgeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 街道管理-知识库Controller
 *
 * @author ruoyi
 * @date 2021-05-19
 */
@Api(tags="知识库列表")
@Controller
@RequestMapping("/system/knowledge")
public class XlKnowledgeController extends BaseController
{
    private String prefix = "system/knowledge";

    @Autowired
    private IXlKnowledgeService xlKnowledgeService;

    @RequiresPermissions("system:knowledge:view")
    @GetMapping()
    public String knowledge()
    {
        return prefix + "/knowledge";
    }

    /**
     * 查询街道管理-知识库列表
     */
    @ApiOperation(value="知识库列表详情", notes="知识库列表详情")
//    @RequiresPermissions("system:knowledge:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(XlKnowledge xlKnowledge)
    {
      //  startPage();
        List<XlKnowledge> list = xlKnowledgeService.selectXlKnowledgeList(xlKnowledge);
        return getDataTable(list);
    }

    /**
     * 导出街道管理-知识库列表
     */
    @RequiresPermissions("system:knowledge:export")
    @Log(title = "街道管理-知识库", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(XlKnowledge xlKnowledge)
    {
        List<XlKnowledge> list = xlKnowledgeService.selectXlKnowledgeList(xlKnowledge);
        ExcelUtil<XlKnowledge> util = new ExcelUtil<XlKnowledge>(XlKnowledge.class);
        return util.exportExcel(list, "knowledge");
    }

    /**
     * 新增街道管理-知识库
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存街道管理-知识库
     */
    @RequiresPermissions("system:knowledge:add")
    @Log(title = "街道管理-知识库", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(XlKnowledge xlKnowledge)
    {
        return toAjax(xlKnowledgeService.insertXlKnowledge(xlKnowledge));
    }

    /**
     * 修改街道管理-知识库
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        XlKnowledge xlKnowledge = xlKnowledgeService.selectXlKnowledgeById(id);
        mmap.put("xlKnowledge", xlKnowledge);
        return prefix + "/edit";
    }

    /**
     * 修改保存街道管理-知识库
     */
    @RequiresPermissions("system:knowledge:edit")
    @Log(title = "街道管理-知识库", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(XlKnowledge xlKnowledge)
    {
        return toAjax(xlKnowledgeService.updateXlKnowledge(xlKnowledge));
    }

    /**
     * 查看街道管理-知识库
     */
    @RequiresPermissions("system:knowledge:detail")
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") Long id, ModelMap mmap)
    {
        XlKnowledge xlKnowledge = xlKnowledgeService.selectXlKnowledgeById(id);
        mmap.put("xlKnowledge", xlKnowledge);
        return prefix + "/detail";
    }

    /**
     * 删除街道管理-知识库
     */
    @RequiresPermissions("system:knowledge:remove")
    @Log(title = "街道管理-知识库", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(xlKnowledgeService.deleteXlKnowledgeByIds(ids));
    }
}
