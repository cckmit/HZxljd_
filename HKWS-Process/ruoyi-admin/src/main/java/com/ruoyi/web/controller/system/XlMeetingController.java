package com.ruoyi.web.controller.system;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.XlMeeting;
import com.ruoyi.system.service.IXlMeetingService;
import com.ruoyi.system.service.honey.GeneralService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * 街道管理--会议记录Controller
 *
 * @author ruoyi
 * @date 2021-05-19
 */
@Controller
@RequestMapping("/system/meeting")
public class XlMeetingController extends BaseController
{
    private String prefix = "system/meeting";
    private static Logger log= LoggerFactory.getLogger(XlMeetingController.class);


    @Autowired
    private IXlMeetingService xlMeetingService;
    @Autowired
    private GeneralService generalService;

    @RequiresPermissions("system:meeting:view")
    @GetMapping()
    public String meeting()
    {
        return prefix + "/meeting";
    }

    /**
     * 查询街道管理--会议记录列表
     */
    @RequiresPermissions("system:meeting:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(XlMeeting xlMeeting)
    {
        startPage();
        List<XlMeeting> list = xlMeetingService.selectXlMeetingList(xlMeeting);
        return getDataTable(list);
    }


    /**
     * 导出街道管理--会议记录列表
     */
    @RequiresPermissions("system:meeting:export")
    @Log(title = "街道管理--会议记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(XlMeeting xlMeeting)
    {
        List<XlMeeting> list = xlMeetingService.selectXlMeetingList(xlMeeting);
        ExcelUtil<XlMeeting> util = new ExcelUtil<XlMeeting>(XlMeeting.class);
        return util.exportExcel(list, "meeting");
    }

    /**
     * 新增街道管理--会议记录
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存街道管理--会议记录
     */
    @RequiresPermissions("system:meeting:add")
    @Log(title = "街道管理--会议记录", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(XlMeeting xlMeeting)
    {
        return toAjax(xlMeetingService.insertXlMeeting(xlMeeting));
    }

    /**
     * 修改街道管理--会议记录
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        XlMeeting xlMeeting = xlMeetingService.selectXlMeetingById(id);
        mmap.put("xlMeeting", xlMeeting);
        return prefix + "/edit";
    }

    /**
     * 修改保存街道管理--会议记录
     */
    @RequiresPermissions("system:meeting:edit")
    @Log(title = "街道管理--会议记录", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(XlMeeting xlMeeting)
    {

        return toAjax(xlMeetingService.updateXlMeeting(xlMeeting));
    }

    /**
     * 删除街道管理--会议记录
     */
    @RequiresPermissions("system:meeting:remove")
    @Log(title = "街道管理--会议记录", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(xlMeetingService.deleteXlMeetingByIds(ids));
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id")Long id, ModelMap mmap){
        XlMeeting xlMeeting = xlMeetingService.selectXlMeetingById(id);
        mmap.put("xlMeeting", xlMeeting);
        return prefix + "/details";
    }
    @PostMapping("/UpLoadImage")
    @ResponseBody
    public Map<String,Object> uploadImage(HttpServletRequest request, HttpServletResponse response, @RequestParam("file") MultipartFile[] file) throws Exception{
       return generalService.uploadImage(request,response,file);
    }
    /**
     * 删除文件
     * @param   sPath    被删除文件的文件名
     * @return 单个文件删除成功返回true，否则返回false
     */
    @PostMapping("/deleteImage")
    public boolean deleteFile(String sPath) {
        return generalService.deleteFile(sPath);
    }
}
