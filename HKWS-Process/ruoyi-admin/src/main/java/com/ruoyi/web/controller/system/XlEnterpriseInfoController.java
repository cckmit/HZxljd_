package com.ruoyi.web.controller.system;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.XlEnterpriseInfo;
import com.ruoyi.system.service.IXlEnterpriseInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 公共管理--企业信息Controller
 *
 * @author ruoyi
 * @date 2021-05-20
 */
@Api(tags="企业商铺列表")
@Controller
@RequestMapping("/system/enterpriseInfo")
public class XlEnterpriseInfoController extends BaseController
{
    private String prefix = "system/enterpriseInfo";

    @Autowired
    private IXlEnterpriseInfoService xlEnterpriseInfoService;

    @GetMapping("/em")
    public String enterpriseInfoem()
    {
        return "/system/societyManage/enterpriseManage/enterpriseInfo";
    }

    @RequiresPermissions("system:storeInfo:view")
    @GetMapping("/storeInfo")
    public String storeInfo()
    {
        return "system/honey/storeInfo/storeInfo";
    }


    @RequiresPermissions("system:enterpriseInfo:view")
    @GetMapping()
    public String enterpriseInfo()
    {
        return prefix + "/enterpriseInfo";
    }
    /**
     * 查询公共管理--个体工商户列表
     */
    @ApiOperation(value="个体工商户列表", notes="个体工商户列表")
 //   @RequiresPermissions("system:enterpriseInfo:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(XlEnterpriseInfo xlEnterpriseInfo)
    {
        startPage();
        xlEnterpriseInfo.setEnterpriseTypeNum(1);
        List<XlEnterpriseInfo> list = xlEnterpriseInfoService.selectXlEnterpriseInfoList(xlEnterpriseInfo);
        return getDataTable(list);
    }
    /**
     * 查询公共管理--企业列表
     */
    @ApiOperation(value="企业列表", notes="企业列表")
    @PostMapping("/list2")
    @ResponseBody
    public TableDataInfo list2(XlEnterpriseInfo xlEnterpriseInfo)
    {
        startPage();
        xlEnterpriseInfo.setEnterpriseTypeNum(2);
        List<XlEnterpriseInfo> list = xlEnterpriseInfoService.selectXlEnterpriseInfoList(xlEnterpriseInfo);
        return getDataTable(list);
    }
    /**
     * 查询网格管理--单位信息列表
     */
    @RequiresPermissions("system:enterpriseInfo:list")
    @PostMapping("/listEnterpriseManage")
    @ResponseBody
    public TableDataInfo listEM(XlEnterpriseInfo xlEnterpriseInfo)
    {
        startPage();
//        xlEnterpriseInfo.setEnterpriseTypeNum(1);
        List<XlEnterpriseInfo> list = xlEnterpriseInfoService.selectXlEnterpriseInfoList(xlEnterpriseInfo);
        return getDataTable(list);
    }

    /**
     * 导出公共管理--企业信息列表
     */
    @RequiresPermissions("system:enterpriseInfo:export")
    @Log(title = "公共管理--企业信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(XlEnterpriseInfo xlEnterpriseInfo)
    {
        List<XlEnterpriseInfo> list = xlEnterpriseInfoService.selectXlEnterpriseInfoList(xlEnterpriseInfo);
        ExcelUtil<XlEnterpriseInfo> util = new ExcelUtil<XlEnterpriseInfo>(XlEnterpriseInfo.class);
        return util.exportExcel(list, "enterpriseInfo");
    }
    /**
     * 导出商铺数据
     */
    @PostMapping("/exportData")
    @ResponseBody
    public AjaxResult exportSelected(XlEnterpriseInfo xlEnterpriseInfo, String Ids)
    {
        List<XlEnterpriseInfo> list=null;
        String[]ab=null;
        if (Ids!=null) {
            ab = Ids.split(",");
             list = xlEnterpriseInfoService.selectXlEnterpriseInfoInIds(ab);
        }else {
            list=xlEnterpriseInfoService.selectXlEnterpriseInfoList(xlEnterpriseInfo);
        }
        List<XlEnterpriseInfo> xlEnterpriseInfoList = new ArrayList<XlEnterpriseInfo>(Arrays.asList(new XlEnterpriseInfo[list.size()]));
        Collections.copy(xlEnterpriseInfoList, list);

        // 条件过滤
        if (StringUtils.isNotEmpty(Ids))
        {
            xlEnterpriseInfoList.clear();
            for (Long id : Convert.toLongArray(Ids))
            {
                for (XlEnterpriseInfo xlEnterpriseInfo1 : list)
                {
                    if (xlEnterpriseInfo1.getId() == id.intValue())
                    {
                        xlEnterpriseInfoList.add(xlEnterpriseInfo1);
                    }
                }
            }
        }
        ExcelUtil<XlEnterpriseInfo> util = new ExcelUtil<XlEnterpriseInfo>(XlEnterpriseInfo.class);
        return util.exportExcel(xlEnterpriseInfoList, "企业数据");
    }


    /**
     * 新增公共管理--企业信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    @GetMapping("/store/add")
    public String addTwo()
    {
        return "system/honey/storeInfo/add";
    }
    /**
     * 新增保存公共管理--企业信息
     */
    @ApiOperation(value="公共管理--企业商铺信息新增", notes="公共管理--企业商铺信息新增")
 //   @RequiresPermissions("system:enterpriseInfo:add")
    @Log(title = "公共管理--企业信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(XlEnterpriseInfo xlEnterpriseInfo)
    {
        if (xlEnterpriseInfo.getEnterpriseTypeNum()==1)
            xlEnterpriseInfo.setEnterpriseType("个体工商户");
        if (xlEnterpriseInfo.getEnterpriseType() == null || xlEnterpriseInfo.getEnterpriseType() == "")
            xlEnterpriseInfo.setEnterpriseType("有限责任公司");
        return toAjax(xlEnterpriseInfoService.insertXlEnterpriseInfo(xlEnterpriseInfo));
    }

    /**
     * 修改公共管理--企业信息
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        XlEnterpriseInfo xlEnterpriseInfo = xlEnterpriseInfoService.selectXlEnterpriseInfoById(id);
        mmap.put("xlEnterpriseInfo", xlEnterpriseInfo);
        return prefix + "/edit";
    }
    /**
     * 修改公共管理--企业信息
     */
    @GetMapping("/storeInfo/edit/{id}")
    public String editstoreInfo(@PathVariable("id") Long id, ModelMap mmap)
    {
        XlEnterpriseInfo xlEnterpriseInfo = xlEnterpriseInfoService.selectXlEnterpriseInfoById(id);
        mmap.put("xlEnterpriseInfo", xlEnterpriseInfo);
        return "system/honey/storeInfo/edit";
    }
    /**
     * 修改保存公共管理--企业信息
     */
    @RequiresPermissions("system:enterpriseInfo:edit")
    @Log(title = "公共管理--企业信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(XlEnterpriseInfo xlEnterpriseInfo)
    {
        return toAjax(xlEnterpriseInfoService.updateXlEnterpriseInfo(xlEnterpriseInfo));
    }

    /**
     * 公共管理--企业信息详情
     */
    @RequiresPermissions("system:enterpriseInfo:detail")
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") Long id, ModelMap mmap)
    {
        XlEnterpriseInfo xlEnterpriseInfo = xlEnterpriseInfoService.selectXlEnterpriseInfoById(id);
        mmap.put("xlEnterpriseInfo", xlEnterpriseInfo);
        return prefix + "/detail";
    }

    /**
     * 删除公共管理--企业信息
     */
    @RequiresPermissions("system:enterpriseInfo:remove")
    @Log(title = "公共管理--企业信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(xlEnterpriseInfoService.deleteXlEnterpriseInfoByIds(ids));
    }

    /**
     * 校验企业名
     */
    @PostMapping("/checkEnterpriseNameUnique")
    @ResponseBody
    public String checkEnterpriseNameUnique(XlEnterpriseInfo xlEnterpriseInfo)
    {
        return xlEnterpriseInfoService.checkEnterpriseNameUnique(xlEnterpriseInfo.getEnterpriseName());
    }

    @Log(title = "公共管理--企业信息", businessType = BusinessType.IMPORT)
    @RequiresPermissions("system:enterpriseInfo:import")
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<XlEnterpriseInfo> util = new ExcelUtil<XlEnterpriseInfo>(XlEnterpriseInfo.class);
        List<XlEnterpriseInfo> xlEnterpriseInfoList = util.importExcel(file.getInputStream());
        String message = xlEnterpriseInfoService.importEnterpriseInfo(xlEnterpriseInfoList, updateSupport);
        return AjaxResult.success(message);
    }

    /**
     * 下载模板
     */
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate()
    {
        ExcelUtil<XlEnterpriseInfo> util = new ExcelUtil<XlEnterpriseInfo>(XlEnterpriseInfo.class);
        return util.importTemplateExcel("企业单位信息数据");
    }
    @ApiOperation(value="商铺企业列表", notes="商铺企业列表")
    @PostMapping("/listCompany")
    @ResponseBody
    public TableDataInfo listCompany(XlEnterpriseInfo xlEnterpriseInfo)
    {
        startPage();
        List<XlEnterpriseInfo> list = xlEnterpriseInfoService.selectXlEnterpriseInfoList(xlEnterpriseInfo);
        return getDataTable(list);
    }

    @PostMapping("/details/{id}")
    @ResponseBody
    public AjaxResult details(@PathVariable("id") Long id)
    {
        return AjaxResult.success(xlEnterpriseInfoService.selectXlEnterpriseInfoById(id));
    }

}
