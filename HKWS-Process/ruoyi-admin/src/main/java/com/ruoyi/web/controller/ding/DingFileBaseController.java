package com.ruoyi.web.controller.ding;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.HkFileBase;
import com.ruoyi.system.service.ding.DingFileBaseService;
import com.ruoyi.web.annotation.IdentityVerify;
import com.ruoyi.web.annotation.IdentityVerifys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

/**
 * @ProjectName: ruoyi
 * @Package: com.ruoyi.web.controller.ding
 * @ClassName: DingFileBaseController
 * @Author: guohailong
 * @Description: 浙政钉-资料库
 * @Date: 2021/3/11 1:02
 * @Version: 1.0
 */
@RestController
@RequestMapping("/ding")
public class DingFileBaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DingFileBaseController.class);

    @Value("${file-base.upload-path}")
    private String fileBaseUploadPath;

    @Value("${file-base.url-prefix}")
    private String fileBaseUrlPrefix;

    @Resource
    private DingFileBaseService dingFileBaseService;

    /**
     * 根据用户id获取个人资料主页.暂时显示最近4个
     *
     * @param userId
     * @return
     */
    @GetMapping("/file/home/{userId}")
    @IdentityVerify
    public AjaxResult getMyFileHome(@PathVariable @IdentityVerifys Long userId) {
        List<HkFileBase> list = dingFileBaseService.getMyFileHomeByUserId(userId);
        return AjaxResult.success(list);
    }


    /**
     * 根据用户id获取个人所有资料
     *
     * @param userId
     * @return
     */
    @GetMapping("/file/list/{userId}")
    @IdentityVerify
    public AjaxResult getMyFileList(@PathVariable @IdentityVerifys Long userId) {
        List<HkFileBase> list = dingFileBaseService.getMyFileListByUserId(userId);
        return AjaxResult.success(list);
    }

    /**
     * 获取所有共享资料列表
     *
     * @param
     * @return
     */
    @GetMapping("/file/share/list")
    @IdentityVerify
    public AjaxResult getFileList(@IdentityVerifys Long userId) {
        List<HkFileBase> list = dingFileBaseService.getShareFileList(userId);
        return AjaxResult.success(list);
    }

    /**
     * 文件上传
     *
     * @param userId
     * @param file
     * @return
     * @throws IOException
     */
    @PostMapping("/{userId}/file/upload")
    @IdentityVerify
    public AjaxResult fileUpload(@PathVariable @IdentityVerifys Long userId, @RequestParam MultipartFile file) throws IOException {
        String originalFilename = file.getOriginalFilename();
        long size = file.getSize();
        String suffix = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
        String fileName = DateUtils.dateTimeNow() + "-" + userId + "." + suffix;
        File uploadFile = new File(fileBaseUploadPath + fileName);
        if (!uploadFile.getParentFile().exists()) {
            uploadFile.getParentFile().mkdir();
        }
        file.transferTo(uploadFile);
        HkFileBase hkFileBase = new HkFileBase();
        hkFileBase.setOriginalName(originalFilename);
        hkFileBase.setFileName(fileName);
        hkFileBase.setRealPath(fileBaseUploadPath + fileName);
        hkFileBase.setUrl(fileBaseUrlPrefix + "/" + fileName);
        hkFileBase.setFileType(suffix);
        hkFileBase.setSize(size);
        hkFileBase.setMd5("");//
        hkFileBase.setUserId(userId);
        hkFileBase.setDelFlag(0);
        hkFileBase.setShareFlag(0);
        hkFileBase.setCreateTime(DateUtils.getNowDate());
        dingFileBaseService.insert(hkFileBase);
        return AjaxResult.success();

    }


    /**
     * 文件共享/取消
     *
     * @param id
     * @return
     */
    @PutMapping("/file/share/{id}")
    public AjaxResult shareFile(@PathVariable Long id) {
        int result = dingFileBaseService.shareFile(id);
        return AjaxResult.success(result);
    }


    /**
     * 文件收藏/取消
     *
     * @param userId
     * @param fileId
     * @return
     */
    @PostMapping("/file/collect")
    @IdentityVerify
    public AjaxResult collectFile(@IdentityVerifys Long userId, Long fileId) {
        int result = dingFileBaseService.collectFile(userId, fileId);
        return AjaxResult.success();
    }


    /**
     * 将文件转换成byte数组
     *
     * @param
     * @return
     */
    public byte[] File2byteArray(File sourceFile) {
        byte[] buffer = null;
        try {
            FileInputStream fis = new FileInputStream(sourceFile);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] b = new byte[1024];
            int n;
            while ((n = fis.read(b)) != -1) {
                bos.write(b, 0, n);
            }
            fis.close();
            bos.close();
            buffer = bos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buffer;
    }

}
