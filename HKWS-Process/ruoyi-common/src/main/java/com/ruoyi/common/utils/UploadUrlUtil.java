package com.ruoyi.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

public class UploadUrlUtil {

    public Logger logger = LoggerFactory.getLogger(UploadUrlUtil.class);

    public String getFilePath(String type,String fileUrl,String imgPath,String requestUrl){
        String result = null;
        List<String> stringList = new ArrayList<>();
        if(fileUrl.indexOf("\\|") > 0){
            String[] arr = fileUrl.split("\\|");
            stringList = Arrays.asList(arr);
        }else{
            stringList.add(fileUrl);
        }
        File file = null;
        InputStream inStream = null;
        OutputStream out =null;
        try {
            for(int i=0;i<stringList.size();i++){
                String str = stringList.get(i);
                String fileName = UUID.randomUUID().toString().replaceAll("-","")+".jpg";;
                URL url = new URL(str);
                fileName = type+"/"+DateUtils.dateTime() +"/"+ DateUtils.dateTimes()+"_"+ fileName;
                file = new File(imgPath + File.separator + fileName);
                if (!file.getParentFile().exists())
                {
                    file.getParentFile().mkdirs();
                }
                if (!file.exists())
                {
                    file.createNewFile();
                }
                inStream = url.openStream();
                out = new FileOutputStream(file);
                int bytesRead = 0;
                byte[] buffer = new byte[8192];
                while ((bytesRead = inStream.read(buffer, 0, 8192)) != -1) {
                    out.write(buffer, 0, bytesRead);
                }
                logger.info("文件保存地址 = "+file.getPath());
                String filePath = requestUrl+fileName;
                logger.info("文件访问地址 = "+filePath);
                if(i > 0){
                    result += "|"+filePath;
                }else{
                    result = filePath;
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if (null != out) {
                    out.close();
                }if (null != inStream) {
                    inStream.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        logger.info("路由="+result);
        return result;
    }


    /*public static void main(String[] args) {
        String str = "https://qswspro.oss-cn-hangzhou.aliyuncs.com/qsws/9hd44vwoq500000000.mp4";
        String suffix = str.substring(str.lastIndexOf(".")+1);
        String fileName = str.substring(str.lastIndexOf("/")+1);
        System.out.println(suffix);
        System.out.println(fileName);
    }*/

    public void getFile(String type,String fileUrl){
        List<String> stringList = new ArrayList<>();
        if(fileUrl.indexOf(",") > 0){
            String[] arr = fileUrl.split(",");
            stringList = Arrays.asList(arr);
        }else{
            stringList.add(fileUrl);
        }
        char ch;
        char [] nameArr= new char [ 256 ];
        byte [] buf= new byte [ 1024 ];
        String name= "" ;
        InputStream in = null;
        ByteArrayOutputStream out = null;
        try{
            Map<String,InputStream> param = new HashMap<>();
            for(String str : stringList){
//                in = null;
//                out = null;
                URL url = new URL(str);
                //创建http链接
                HttpURLConnection conn = (HttpURLConnection)url.openConnection();
                //设置超时间为3秒
                conn.setConnectTimeout(3*1000);
                //防止屏蔽程序抓取而返回403错误
                conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
                //得到输入流
                in = conn.getInputStream();
                //第一步：获取文件名，构造文件输出流
                int i= 0 ;
                while ((ch=( char ) in.read())!= '\n' ){
                    nameArr[i++]= ch;
                }
                name= new String(nameArr);
                logger.info( "要下载的文件为：" +name);
                File file = new File("C:\\Users\\sunshine\\Pictures\\test\\002.jpg");
                out= new ByteArrayOutputStream();
                //第二步：将输入流中的其他内容写入到文件
                int len;
                while ((len=in.read(buf))!=- 1 ){
                    out.write(buf, 0 ,len);
                }
                out.toByteArray();
                param.put("aa",in);
            }
            upload(type,param);
        }catch(Exception ex){
            logger.info("获取文件流失败：{}",ex.getMessage());
            ex.printStackTrace();
        }finally {
            //疑问：两个捕获可不可以放到一块呢，怎样处理关闭流时的异常最好呢？
            try {
                out.close();
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public String upload(String type, Map<String,InputStream> files){
        String uploadUrl = "";
        if("1".equals(type)){
            uploadUrl = "http://8.136.103.188:9010/img/";
        }else{
            uploadUrl = "http://8.136.103.188:9010/video/";
        }
        try{
            String BOUNDARY = "---------7d4a6d158c9";
            URL url = new URL(uploadUrl);
                                        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
            conn.setRequestProperty("Charsert", "UTF-8");
            conn.setRequestProperty("Content-Type",
                    "multipart/form-data; boundary=" + BOUNDARY);

            OutputStream out = new DataOutputStream(conn.getOutputStream());
            byte[] end_data = ("\r\n--" + BOUNDARY + "--\r\n").getBytes();// 定义最后数据分隔线
            Iterator iter = files.entrySet().iterator();
            int i=0;
            while (iter.hasNext()) {
                i++;
                Map.Entry entry = (Map.Entry) iter.next();
                String key = (String) entry.getKey();
                InputStream val = (InputStream) entry.getValue();

                StringBuilder sb = new StringBuilder();
                sb.append("--");
                sb.append(BOUNDARY);
                sb.append("\r\n");
                sb.append("Content-Disposition: form-data;name=\"file" + i
                        + "\";filename=\"" + key + "\"\r\n");
                sb.append("Content-Type:application/octet-stream\r\n\r\n");

                byte[] data = sb.toString().getBytes();
                out.write(data);
                DataInputStream in = new DataInputStream(val);
                int bytes = 0;
                byte[] bufferOut = new byte[1024];
                while ((bytes = in.read(bufferOut)) != -1) {
                    out.write(bufferOut, 0, bytes);
                }
                out.write("\r\n".getBytes()); // 多个文件时，二个文件之间加入这个
                in.close();
            }
            out.write(end_data);
            out.flush();
            out.close();

            // 定义BufferedReader输入流来读取URL的响应
            /*BufferedReader reader = new BufferedReader(new InputStreamReader(
                    conn.getInputStream(), "UTF-8"));
            String line = null;
            while ((line = reader.readLine()) != null) {
                logger.info("返回信息 = "+line);
            }*/

        }catch(Exception ex){
            logger.info("文件上传服务器错误：{}",ex.getMessage());
            ex.printStackTrace();
        }


        return null;
    }


}
