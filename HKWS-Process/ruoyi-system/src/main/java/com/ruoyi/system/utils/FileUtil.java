package com.ruoyi.system.utils;

import com.ruoyi.common.config.Global;
import com.ruoyi.common.config.ServerConfig;
import com.ruoyi.common.utils.file.FileUploadUtils;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

/**
 * Created by wangluming on 2018/5/24.
 */


public class FileUtil {
    private static String PROPERTY_NAME = "application.yml";
    public static Object getCommonYml(Object key){
        Resource resource = new ClassPathResource(PROPERTY_NAME);
        Properties properties = null;
        try {
            YamlPropertiesFactoryBean yamlFactory = new YamlPropertiesFactoryBean();
            yamlFactory.setResources(resource);
            properties =  yamlFactory.getObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return properties.get(key);
    }
    /**
     *
     * @param request
     * @param file 待文件
     * @param isRandomName 是否要基于图片名称重新编排名称
     * @return
     */
    public static String uploadImage(HttpServletRequest request, MultipartFile file, boolean isRandomName) {
        ServerConfig serverConfig =new ServerConfig();
        //上传
        try {
            String[] typeImg={"gif","png","jpg"};

            if(file!=null){
                String origName=file.getOriginalFilename();// 文件原名称
                System.out.println("上传的文件原名称:"+origName);
                // 判断文件类型
                String type=origName.indexOf(".")!=-1?origName.substring(origName.lastIndexOf(".")+1, origName.length()):null;
                if (type!=null) {
                    boolean booIsType=false;
                    for (int i = 0; i < typeImg.length; i++) {
                        if (typeImg[i].equals(type.toLowerCase())) {
                            booIsType=true;
                        }
                    }
                    //类型正确
                    if (booIsType) {
                        // 上传文件路径(存放图片文件的路径)
                        String filePath = Global.getUploadPath();
                        System.out.println("文件上传的路径"+filePath);
//                        String uploadPath=getCommonYml("event-feedback.upload-path").toString();
//                        System.out.println("文件上传的路径"+uploadPath);
//                    String abc=request.getSession().getServletContext().getRealPath("upload/" );
//                        System.out.println("文件上传的路径"+abc);
//                        String tomcat_path = System.getProperty( "user.dir" );
//                        System.out.println("Tomcat服务器所在的路径: "+tomcat_path);
                        //判断是否存在目录
                        File targetFile=new File(filePath,origName);
                        if(!targetFile.exists()){
                            targetFile.getParentFile().mkdirs();//创建目录
                        }

                        //上传
                        //file.transferTo(targetFile);
                        String fileName = FileUploadUtils.upload(filePath, file);
                        System.out.println("上传后的相对路径随机文件名："+fileName);
                        //服务器地址serverConfig.getUrl()
                        String url = serverConfig.getUrl()+fileName;
                        System.out.println(url);
//                        String Path=getCommonYml("event-feedback.url-prefix").toString();
//                        System.out.println(Path);
                        //完整路径
                        System.out.println("完整路径:"+targetFile.getAbsolutePath());
                        return filePath+"-"+url;
                    }
                }
            }
            return null;
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 格式化日期并去掉”-“
     * @param date
     * @return
     */
    public static String formateString(Date date){
        SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd");
        String list[] = dateFormater.format(date).split("-");
        String result = "";
        for (int i=0;i<list.length;i++) {
            result += list[i];
        }
        return result;
    }

}
