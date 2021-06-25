package com.ruoyi.system.service.impl.honey;


import com.ruoyi.common.config.Global;
import com.ruoyi.system.service.honey.GeneralService;
import com.ruoyi.system.utils.FileUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: Wu
 * @date: 2021-06-21 16:42
 * @description:
 */
@Service
public class GeneralServiceImpl implements GeneralService {
    @Override
    public Map<String, Object> uploadImage(HttpServletRequest request, HttpServletResponse response, MultipartFile[] file) {
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        resultMap.put("imgs","");
        String imgs="";
        resultMap.put("status", 400);
        if(file!=null&&file.length>0){
            //组合image名称，“;隔开”
            List<String> fileName =new ArrayList<String>();
            PrintWriter out = null;
            try {
                for (int i = 0; i < file.length; i++) {
                    if (!file[i].isEmpty()) {
                        String path= FileUtil.uploadImage(request, file[i], true);
                        String[] split=path.split("-",2);
                        String comma=",";
                        imgs+=split[1]+comma;
                        //上传文件，随机名称，";"分号隔开
                        fileName.add(split[0]);
                    }
                }
                //上传成功
                if(fileName!=null&&fileName.size()>0){
                    System.out.println("上传成功！");
                    resultMap.put("imgs",imgs);
                    resultMap.put("status", 200);
                    resultMap.put("message", "上传成功！");
                }else {
                    resultMap.put("status", 500);
                    resultMap.put("message", "上传失败！文件格式错误！");
                }
            } catch (Exception e) {
                e.printStackTrace();
                resultMap.put("status", 500);
                resultMap.put("message", "上传异常！");
            }
        }else {
            resultMap.put("status", 500);
            resultMap.put("message", "没有检测到有效文件！");
        }

        return resultMap;
    }

    @Override
    public boolean deleteFile(String sPath) {
        boolean  flag = false;
        String filePath = Global.getUploadPath();
        File file = new File(filePath+"/"+sPath);
        // 路径为文件且不为空则进行删除
        if (file.isFile() && file.exists()) {
            file.delete();
            flag = true;
        }
        return flag;
    }
}
