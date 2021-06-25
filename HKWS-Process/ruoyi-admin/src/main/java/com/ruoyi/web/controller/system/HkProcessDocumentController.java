package com.ruoyi.web.controller.system;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.json.JSONObject;
import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.HkProcessDocument;
import com.ruoyi.system.service.IHkProcessDocumentService;
import com.ruoyi.web.utils.DocxToPdf;
import com.ruoyi.web.utils.PdfToImage;
import org.apache.commons.io.FilenameUtils;
import org.apache.poi.xwpf.converter.pdf.PdfOptions;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 流程档案Controller
 *
 * @author ruoyi
 * @date 2021-04-20
 */
@Controller
@RequestMapping("/system/process-document")
public class HkProcessDocumentController extends BaseController {
    private String prefix = "system/process-document";

    @Autowired
    private IHkProcessDocumentService hkProcessDocumentService;

    @RequiresPermissions("system:process-document:view")
    @GetMapping()
    public String document() {
        return prefix + "/document";
    }

    /**
     * 查询流程档案列表
     */
    @RequiresPermissions("system:document:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HkProcessDocument hkProcessDocument) {
        startPage();
        List<HkProcessDocument> list = hkProcessDocumentService.selectHkProcessDocumentList(hkProcessDocument);
        return getDataTable(list);
    }

    /**
     * 导出流程档案列表
     */
    @RequiresPermissions("system:document:export")
    @Log(title = "流程档案", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HkProcessDocument hkProcessDocument) {
        List<HkProcessDocument> list = hkProcessDocumentService.selectHkProcessDocumentList(hkProcessDocument);
        ExcelUtil<HkProcessDocument> util = new ExcelUtil<HkProcessDocument>(HkProcessDocument.class);
        return util.exportExcel(list, "document");
    }

    /**
     * 新增流程档案
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存流程档案
     */
    @RequiresPermissions("system:document:add")
    @Log(title = "流程档案", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HkProcessDocument hkProcessDocument) {
        return toAjax(hkProcessDocumentService.insertHkProcessDocument(hkProcessDocument));
    }

    //允许上次的文件后缀
    private static final String[] allowedExtension = {"docx"};
    //流程档案存放路径
    @Value("${process-document.upload-path}")
    private String uploadPath;

    //流程档案访问地址前缀
    @Value("${process-document.url-prefix}")
    private String urlPrefix;


    /**
     * word文档上传
     *
     * @param file
     * @return
     * @throws Exception
     */
    @PostMapping("/upload")
    @ResponseBody
    public AjaxResult upload(@RequestParam("file") MultipartFile file) throws Exception {
        String extension = FilenameUtils.getExtension(file.getOriginalFilename());
        if (!FileUploadUtils.isAllowedExtension(extension, allowedExtension)) {
            return AjaxResult.warn("请上传.docx文件");
        }
        String originalName = file.getOriginalFilename();
        String absoluteName = uploadPath + originalName;
        file.transferTo(new File(absoluteName));
        //转换后pdf文件名字
        String pdfName = originalName.substring(0, originalName.lastIndexOf(".")) + ".pdf";
        String pdfOutPath = uploadPath + pdfName;
        InputStream source = new FileInputStream(absoluteName);
        OutputStream target = new FileOutputStream(pdfOutPath);
        Map<String, String> params = new HashMap<>();
        PdfOptions options = PdfOptions.create();
        //转换成pdf 可预览
        DocxToPdf.wordConverterToPdf(source, target, options, params);
        //pdf转换成图片 可预览
        String imageName = originalName.substring(0, originalName.lastIndexOf(".")) + ".jpg";
        String imageOutPath = uploadPath + imageName;
        PdfToImage.pdfToOneImage(pdfOutPath, imageOutPath);
        //构造返回对象.
        JSONObject obj = new JSONObject();//显示标题
        obj.set("title", originalName.substring(0, originalName.lastIndexOf(".")));
        //原始名称
        obj.set("originalFileName", originalName);
        obj.set("originalFilePath", absoluteName);
        obj.set("fileName", imageName);
        obj.set("filePath", imageOutPath);
        obj.set("url", urlPrefix + imageName);

        return AjaxResult.success(obj);
    }

    /**
     * 修改流程档案
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        HkProcessDocument hkProcessDocument = hkProcessDocumentService.selectHkProcessDocumentById(id);
        mmap.put("hkProcessDocument", hkProcessDocument);
        return prefix + "/edit";
    }

    /**
     * 修改保存流程档案
     */
    @RequiresPermissions("system:document:edit")
    @Log(title = "流程档案", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HkProcessDocument hkProcessDocument) {
        return toAjax(hkProcessDocumentService.updateHkProcessDocument(hkProcessDocument));
    }

    /**
     * 删除流程档案
     */
    @RequiresPermissions("system:document:remove")
    @Log(title = "流程档案", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(hkProcessDocumentService.deleteHkProcessDocumentByIds(ids));
    }
}
