package com.ruoyi.web.controller.system;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.XlEstateManagement;
import com.ruoyi.system.domain.XlVillageModel;
import com.ruoyi.system.domain.dto.EstateDto;
import com.ruoyi.system.service.IXlEstateManagementService;
import com.ruoyi.system.service.IXlVillageService;
import com.ruoyi.web.pdf.PdfReport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;

/**
 * 街道管理--物业信息Controller
 *
 * @author ruoyi
 * @date 2021-05-20
 */
@Api(tags="物业信息列表")
@Controller
@RequestMapping("/system/estateManagement")
public class XlEstateManagementController extends BaseController
{
    private String prefix = "system/estateManagement";

    @Autowired
    private IXlEstateManagementService xlEstateManagementService;

    @Autowired
    private IXlVillageService xlVillageService;

    @RequiresPermissions("system:estateManagement:view")
    @GetMapping()
    public String estateManagement()
    {
        return prefix + "/estateManagement";
    }

    @RequiresPermissions("system:estateManagements:view")
    @GetMapping("/s")
    public String estateManagements()
    {
        return prefix + "/estateManagements";
    }

    /**
     * 查询街道管理--物业信息列表
     */
    @ApiOperation(value="物业信息列表", notes="物业信息列表")
  //  @RequiresPermissions("system:estateManagement:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(XlEstateManagement xlEstateManagement)
    {
        startPage();
        List<XlEstateManagement> list = xlEstateManagementService.selectXlEstateManagementList(xlEstateManagement);
        return getDataTable(list);
    }

    /**
     * 导出街道管理--物业信息列表
     */
    @RequiresPermissions("system:estateManagement:export")
    @Log(title = "街道管理--物业信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(XlEstateManagement xlEstateManagement)
    {
        List<XlEstateManagement> list = xlEstateManagementService.selectXlEstateManagementList(xlEstateManagement);
        ExcelUtil<XlEstateManagement> util = new ExcelUtil<XlEstateManagement>(XlEstateManagement.class);
        return util.exportExcel(list, "estateManagement");
    }

    /**
     * 新增街道管理--物业信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存街道管理--物业信息
     */
    @RequiresPermissions("system:estateManagement:add")
    @Log(title = "街道管理--物业信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(XlEstateManagement xlEstateManagement)
    {
        return toAjax(xlEstateManagementService.insertXlEstateManagement(xlEstateManagement));
    }

    /**
     * （星级评定）街道管理--物业信息
     */
    @GetMapping("/evaluate/{id}")
    public String evaluate(@PathVariable("id") Long id, ModelMap mmap)
    {
        XlEstateManagement xlEstateManagement = xlEstateManagementService.selectXlEstateManagementById(id);

        mmap.put("xlEstateManagement", xlEstateManagement);
        return prefix + "/evaluate";
    }

    /**
     * 修改街道管理--物业信息
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        XlEstateManagement xlEstateManagement = xlEstateManagementService.selectXlEstateManagementById(id);
        mmap.put("xlEstateManagement", xlEstateManagement);
        return prefix + "/edit";
    }

    /**
     * 修改保存街道管理--物业信息
     */
    @RequiresPermissions("system:estateManagement:edit")
    @Log(title = "街道管理--物业信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(XlEstateManagement xlEstateManagement)
    {
        return toAjax(xlEstateManagementService.updateXlEstateManagement(xlEstateManagement));
    }

    /**
     * 删除街道管理--物业信息
     */
    @RequiresPermissions("system:estateManagement:remove")
    @Log(title = "街道管理--物业信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(xlEstateManagementService.deleteXlEstateManagementByIds(ids));
    }

    @Log(title = "街道管理--物业信息", businessType = BusinessType.IMPORT)
    @RequiresPermissions("system:estateManagement:import")
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<XlEstateManagement> util = new ExcelUtil<XlEstateManagement>(XlEstateManagement.class);
        List<XlEstateManagement> xlEstateManagementList = util.importExcel(file.getInputStream());
        String message = xlEstateManagementService.importXlEstateManagement(xlEstateManagementList, updateSupport);
        return AjaxResult.success(message);
    }
    /**
     * 下载模板
     */
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate()
    {
        ExcelUtil<XlEstateManagement> util = new ExcelUtil<XlEstateManagement>(XlEstateManagement.class);
        return util.importTemplateExcel("小区物业数据");
    }

    /**
     * 导出公共管理/物业--设备信息列表
     */
    @Log(title = "街道管理--物业信息", businessType = BusinessType.EXPORT)
    @GetMapping("/outputpdf")
    @ResponseBody
    public void outputpdf(String ids, HttpServletResponse response,XlEstateManagement xlEstateManagement) throws Exception {
        //文件名称
        String fileName = "物业信息.pdf";
        List<XlEstateManagement> list=null;
        String[]ab=null;
        if (!ids.trim().isEmpty()) {
            ab = ids.split(",");
            list = xlEstateManagementService.selectXlEstateManagementInIds(ab);

        }else {
            list=xlEstateManagementService.selectXlEstateManagementList(xlEstateManagement);
        }
        OutputStream fos = null;
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        response.addHeader("Content-Disposition", "attachment;filename=" + new String(URLEncoder.encode(fileName.trim()).getBytes("UTF-8"),"UTF-8"));
        fos = response.getOutputStream();

        PdfReport pd=new PdfReport();
        pd.outputPdf(list,fos);
        response.getOutputStream().flush();
        response.getOutputStream().close();
        response.flushBuffer();
    }
    /**
     * 统计物业信息
     */
    @PostMapping("/xlEstateCount")
    @ResponseBody
    public AjaxResult xlEstateCount(Integer id){
        return AjaxResult.success(xlEstateManagementService.selectXlEstateManagementCountById(id));

    }

    @GetMapping("/openopen")
    @ResponseBody
    public List<XlVillageModel>  openopen()
    {
        List<XlVillageModel>  names=xlVillageService.selectNames();
        return names;
    }

}
