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
import com.ruoyi.system.domain.XlLease;
import com.ruoyi.system.service.IXlLeaseService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 出租房信息Controller
 * 
 * @author ruoyi
 * @date 2021-05-31
 */
@Controller
@RequestMapping("/system/lease")
public class XlLeaseController extends BaseController
{
    private String prefix = "system/lease";

    @Autowired
    private IXlLeaseService xlLeaseService;

    @RequiresPermissions("system:lease:view")
    @GetMapping()
    public String lease()
    {
        return prefix + "/lease";
    }

    /**
     * 查询出租房信息列表
     */
    @RequiresPermissions("system:lease:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(XlLease xlLease)
    {
        startPage();
        List<XlLease> list = xlLeaseService.selectXlLeaseList(xlLease);
        return getDataTable(list);
    }

    /**
     * 导出出租房信息列表
     */
    @RequiresPermissions("system:lease:export")
    @Log(title = "出租房信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(XlLease xlLease)
    {
        List<XlLease> list = xlLeaseService.selectXlLeaseList(xlLease);
        ExcelUtil<XlLease> util = new ExcelUtil<XlLease>(XlLease.class);
        return util.exportExcel(list, "lease");
    }

    /**
     * 新增出租房信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存出租房信息
     */
    @RequiresPermissions("system:lease:add")
    @Log(title = "出租房信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(XlLease xlLease)
    {
        if(xlLease.getRoomTypeStatus()==1){
            xlLease.setRoomType("商品房");
        }else{xlLease.setRoomType("自建房");}
        if(xlLease.getLeaseTypeStatus()==1){
            xlLease.setLeaseType("出租");
        }else{
            xlLease.setLeaseType("自住");
        }
        return toAjax(xlLeaseService.insertXlLease(xlLease));
    }

    /**
     * 修改出租房信息
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        XlLease xlLease = xlLeaseService.selectXlLeaseById(id);
        mmap.put("xlLease", xlLease);
        return prefix + "/edit";
    }

    /**
     * 修改保存出租房信息
     */
    @RequiresPermissions("system:lease:edit")
    @Log(title = "出租房信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(XlLease xlLease)
    {
        if(xlLease.getRoomTypeStatus()==1){
            xlLease.setRoomType("商品房");
        }else{xlLease.setRoomType("自建房");}
        if(xlLease.getLeaseTypeStatus()==1){
            xlLease.setLeaseType("出租");
        }else{
            xlLease.setLeaseType("自住");
        }
        return toAjax(xlLeaseService.updateXlLease(xlLease));
    }

    /**
     * 删除出租房信息
     */
    @RequiresPermissions("system:lease:remove")
    @Log(title = "出租房信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(xlLeaseService.deleteXlLeaseByIds(ids));
    }

    //导入小区信息
    @Log(title = "网格管理--出租房信息", businessType = BusinessType.IMPORT)
    @RequiresPermissions("system:lease:import")
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<XlLease> util = new ExcelUtil<XlLease>(XlLease.class);
        List<XlLease> xlLeaseList = util.importExcel(file.getInputStream());
        String message = xlLeaseService.importLease(xlLeaseList, updateSupport);
        return AjaxResult.success(message);
    }

    /**
     * 下载模板
     */
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate()
    {
        ExcelUtil<XlLease> util = new ExcelUtil<XlLease>(XlLease.class);
        return util.importTemplateExcel("出租房信息数据");
    }

}
