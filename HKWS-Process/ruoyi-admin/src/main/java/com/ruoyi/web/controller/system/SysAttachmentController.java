package com.ruoyi.web.controller.system;

import cn.hutool.core.lang.UUID;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.config.Global;
import com.ruoyi.common.config.ServerConfig;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.SysAttachment;
import com.ruoyi.system.service.ISysAttachmentService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 附件Controller
 *
 * @author ruoyi
 * @date 2021-06-17
 */
@Controller
@RequestMapping("/system/attachment")
public class SysAttachmentController extends BaseController
{
    @Autowired
    private ISysAttachmentService attachmentService;

    @Autowired
    private ServerConfig serverConfig;

    /**
     * 删除附件
     */
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        if(StringUtils.isNotNull(ids)){
            return toAjax(attachmentService.deleteSysAttachmentByIds(ids));
        }
        return toAjax(1);
    }

    //文件上传
    @ResponseBody
    @RequestMapping("/upload")
    public AjaxResult  upload(MultipartFile[] files){
        SysAttachment attachment = new SysAttachment();
        try
        {
            // 上传文件路径
            String filePath = Global.getUploadPath();
            //uuid
            String uuid = UUID.randomUUID().toString().trim().replaceAll("-", "");
            attachment.setFileCode(uuid);
            //上传并返回新文件名称
            for(MultipartFile file:files){
                String fileName = FileUploadUtils.upload(filePath, file);
                String url = serverConfig.getUrl() + fileName;
                //保存文件
                attachment.setAttachmentName(fileName.substring(16,fileName.length())); //截取
                attachment.setAttachmentUrl(url);
                attachmentService.insertSysAttachment(attachment);
            }
            return AjaxResult.success(uuid);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return AjaxResult.error("文件上传失败！");
        }
    }
}
