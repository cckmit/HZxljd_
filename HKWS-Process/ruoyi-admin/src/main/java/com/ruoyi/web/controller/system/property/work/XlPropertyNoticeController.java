package com.ruoyi.web.controller.system.property.work;

import cn.hutool.core.convert.impl.UUIDConverter;
import cn.hutool.core.lang.UUID;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.config.Global;
import com.ruoyi.common.config.ServerConfig;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.framework.web.domain.server.Sys;
import com.ruoyi.system.domain.SysAttachment;
import com.ruoyi.system.domain.XlVillageModel;
import com.ruoyi.system.domain.property.XlPropertyNotice;
import com.ruoyi.system.service.ISysAttachmentService;
import com.ruoyi.system.service.IXlVillageService;
import com.ruoyi.system.service.property.IXlPropertyNoticeService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 物业--公告通知Controller
 *
 * @author ruoyi
 * @date 2021-05-26
 */
@Controller
@RequestMapping("/system/property/xlpropertynotice")
public class XlPropertyNoticeController extends BaseController
{
    private String prefix = "system/property/xlpropertynotice";

    @Autowired
    private IXlPropertyNoticeService xlPropertyNoticeService;

    @Autowired
    private ISysAttachmentService attachmentService;

    @Autowired
    private IXlVillageService xlVillageService;

    @RequiresPermissions("system/property:xlpropertynotice:view")
    @GetMapping()
    public String xlpropertynotice()
    {
        return prefix + "/xlpropertynotice";
    }

    /**
     * 查询物业--公告通知列表
     */
    @RequiresPermissions("system/property:xlpropertynotice:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(XlPropertyNotice xlPropertyNotice)
    {
        startPage();
        //物业公司用户只能查看自己小区的信息
        Long villageId = ShiroUtils.getSysUser().getDeptId();
        xlPropertyNotice.setVillageId(villageId);
        List<XlPropertyNotice> list = xlPropertyNoticeService.selectXlPropertyNoticeList(xlPropertyNotice);
        return getDataTable(list);
    }

    /**
     * 新增物业--公告通知
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
     * 新增保存物业--公告通知
     */
    @RequiresPermissions("system/property:xlpropertynotice:add")
    @Log(title = "物业--公告通知", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(XlPropertyNotice xlPropertyNotice)
    {
        //小区
        xlPropertyNotice.setVillageId(ShiroUtils.getSysUser().getDeptId());
        xlPropertyNotice.setCreateBy(ShiroUtils.getSysUser().getUserName());
        return toAjax(xlPropertyNoticeService.insertXlPropertyNotice(xlPropertyNotice));
    }

    /**
     * 修改物业--公告通知
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {

        XlPropertyNotice xlPropertyNotice = xlPropertyNoticeService.selectXlPropertyNoticeById(id);
        //附件
        List<SysAttachment> attachments = attachmentService.selectAttachmentByFileCode(xlPropertyNotice.getFileCode());
        //小区
        Long villageId = ShiroUtils.getSysUser().getDeptId();
        XlVillageModel xlVillage = xlVillageService.selectXlVillageById(villageId);
        mmap.put("xlVillage",xlVillage);
        mmap.put("xlPropertyNotice", xlPropertyNotice);
        mmap.put("attachments",attachments);
        return prefix + "/edit";
    }

    /**
     * 修改保存物业--公告通知
     */
    @RequiresPermissions("system/property:xlpropertynotice:edit")
    @Log(title = "物业--公告通知", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(XlPropertyNotice xlPropertyNotice)
    {
        xlPropertyNotice.setCreateBy(ShiroUtils.getSysUser().getUserName());
        return toAjax(xlPropertyNoticeService.updateXlPropertyNotice(xlPropertyNotice));
    }

    /**
     * 删除物业--公告通知
     */
    @RequiresPermissions("system/property:xlpropertynotice:remove")
    @Log(title = "物业--公告通知", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(xlPropertyNoticeService.deleteXlPropertyNoticeByIds(ids));
    }

    /**
     * 查看详情
     * @param id
     * @param mmap
     * @return
     */
    @RequiresPermissions("system/property:xlpropertynotice:detail")
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") Long id, ModelMap mmap)
    {
        //公告详情
        XlPropertyNotice notice = xlPropertyNoticeService.selectXlPropertyNoticeById(id);
        //附件
        List<SysAttachment> attachments = attachmentService.selectAttachmentByFileCode(notice.getFileCode());
        //小区
        Long villageId = ShiroUtils.getSysUser().getDeptId();
        XlVillageModel xlVillage = xlVillageService.selectXlVillageById(villageId);
        mmap.put("xlVillage",xlVillage);
        mmap.put("xlPropertyNotice",notice);
        mmap.put("attachments",attachments);
        return prefix + "/detail";
    }
}
