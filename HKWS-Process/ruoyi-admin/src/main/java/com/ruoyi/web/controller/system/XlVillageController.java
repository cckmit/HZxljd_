package com.ruoyi.web.controller.system;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.XlEstateManagement;
import com.ruoyi.system.domain.XlVillageModel;
import com.ruoyi.system.service.IXlEstateManagementService;
import com.ruoyi.system.service.IXlVillageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 小区信息Controller
 *
 * @author ruoyi
 * @date 2021-05-24
 */
@Api(tags="小区物业信息")
@Controller
@RequestMapping("/system/village")
public class XlVillageController extends BaseController
{
    private String prefix = "system/village";

    @Autowired
    private IXlVillageService xlVillageService;
    @Autowired
    private IXlEstateManagementService xlEstateManagementService;

    @RequiresPermissions("system:village:view")
    @GetMapping()
    public String village()
    {
        return prefix + "/village";
    }

    /**
     * 查询小区信息列表,社区网格关系
     */
//    @RequiresPermissions("system:village:listAll")
    @PostMapping("/listAll")
    @ResponseBody
    public TableDataInfo listAll(XlVillageModel xlVillageModel)
    {
        startPage();
        List<XlVillageModel> list = xlVillageService.selectXlVillageLists(xlVillageModel);
        return getDataTable(list);
    }
    /**
     * 查询小区信息列表
     */
    @ApiOperation(value="小区物业信息列表", notes="小区物业信息列表")
//    @RequiresPermissions("system:village:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(XlVillageModel xlVillageModel)
    {
        startPage();
        List<XlVillageModel> list = xlVillageService.selectXlVillageList(xlVillageModel);
        return getDataTable(list);
    }

    /**
     * 导出小区信息列表
     */
    @RequiresPermissions("system:village:export")
    @Log(title = "小区信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(XlVillageModel xlVillageModel)
    {
        List<XlVillageModel> list = xlVillageService.selectXlVillageList(xlVillageModel);
        ExcelUtil<XlVillageModel> util = new ExcelUtil<XlVillageModel>(XlVillageModel.class);
        return util.exportExcel(list, "village");
    }

    /**
     * 新增小区信息
     */
    @GetMapping("/add")
    public String add(ModelMap mmap)
    {
        List<XlEstateManagement> list=xlEstateManagementService.selectXlEstateManagementList(new XlEstateManagement());
        mmap.put("estateList", list);
        return prefix + "/add";
    }

    /**
     * 新增保存小区信息
     */
    @RequiresPermissions("system:village:add")
    @Log(title = "小区信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(XlVillageModel xlVillageModel)
    {
        xlVillageModel.setCreateBy(ShiroUtils.getLoginName());
        return toAjax(xlVillageService.insertXlVillage(xlVillageModel));
    }

    /**
     * 修改小区信息
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        XlVillageModel xlVillageModel = xlVillageService.selectXlVillageById(id);
        List<XlVillageModel>  deptNames=xlVillageService.selectdeptNames();
        List<XlEstateManagement> list=xlEstateManagementService.selectXlEstateManagementList(new XlEstateManagement());
        mmap.put("estateList", list);
        mmap.put("deptNames",deptNames);
        mmap.put("xlVillageModel", xlVillageModel);
        return prefix + "/edit";
    }

    /**
     * 修改保存小区信息
     */
    @RequiresPermissions("system:village:edit")
    @Log(title = "小区信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(XlVillageModel xlVillageModel)
    {
        return toAjax(xlVillageService.updateXlVillage(xlVillageModel));
    }

    /**
     * 删除小区信息
     */
    @RequiresPermissions("system:village:remove")
    @Log(title = "小区信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(xlVillageService.deleteXlVillageByIds(ids));
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id")Long id, ModelMap mmap){
        XlVillageModel xlVillageModel =xlVillageService.selectXlVillageById(id);
        mmap.put("xlVillageModel", xlVillageModel);
        return prefix + "/detail";
    }
    /**
     * 校验小区编号，小区名称
     */
    @PostMapping("/checkVillageCodeUnique")
    @ResponseBody
    public String checkVillageCodeUnique(String xlVillageModelCode)
    {
        return xlVillageService.checkVillageCodeUnique(xlVillageModelCode);
    }
    /**
     * 校验小区编号，小区名称
     */
    @PostMapping("/checkVillageNameUnique")
    @ResponseBody
    public String checkVillageNameUnique(String xlVillageModelName)
    {
        return xlVillageService.checkVillageNameUnique(xlVillageModelName);
    }

    @GetMapping("/openopen")
    @ResponseBody
    public List<XlVillageModel>  openopen()
    {
        List<XlVillageModel>  deptNames=xlVillageService.selectdeptNames();
        return deptNames;
    }

    //导入小区信息
    @Log(title = "公共管理--小区信息", businessType = BusinessType.IMPORT)
    @RequiresPermissions("system:village:import")
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<XlVillageModel> util = new ExcelUtil<XlVillageModel>(XlVillageModel.class);
        List<XlVillageModel> xlVillageList = util.importExcel(file.getInputStream());
        String message = xlVillageService.importVillage(xlVillageList, updateSupport);
        return AjaxResult.success(message);
    }

    /**
     * 下载模板
     */
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate()
    {
        ExcelUtil<XlVillageModel> util = new ExcelUtil<XlVillageModel>(XlVillageModel.class);
        return util.importTemplateExcel("小区信息数据");
    }

    @GetMapping("/listForCar")
    @ResponseBody
    public List<XlVillageModel> listForCar()
    {
        List<XlVillageModel> list = xlVillageService.selectXlVillageList(new XlVillageModel());
        return list;
    }

    /**
     * 根据物业名称查询物业信息包含的小区详情
     */
    @ApiOperation(value="物业信息包含的小区详情", notes="物业信息包含的小区详情")
    @PostMapping("/details/{propertyName}")
    @ResponseBody
    public AjaxResult details(@PathVariable("propertyName") String propertyName)
    {
        return AjaxResult.success(xlVillageService.selectXlVillageByPropertyName(propertyName));
    }
}
