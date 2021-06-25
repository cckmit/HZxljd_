package com.ruoyi.system.service.honey;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @author: Wu
 * @date: 2021-06-21 16:40
 * @description:
 */
public interface GeneralService {
    /**
     * 图片上传
     * @param request
     * @param response
     * @param file
     * @return
     */
    public Map<String,Object> uploadImage(HttpServletRequest request, HttpServletResponse response, @RequestParam("file") MultipartFile[] file);

    /**
     * 图片删除
     * @param sPath
     * @return
     */
    public boolean deleteFile(String sPath);
}
