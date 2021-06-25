/**
 * oyt
 */
package com.ruoyi.system.utils;

import java.security.MessageDigest;

/**
 * MD5加密
 * @author Tao.Ouyang (Create on:2018年8月12日)
 * @version 1.0
 * @fileName MD5Util.java
 */
public class MD5Util {

    /**
     * 对字符串md5加密(大写+数字)
     *
     * @param s 传入要加密的字符串
     * @return  MD5加密后的字符串
     */

    public static String getMD5_32(String s) {
        if (s == null || s.equals("")){
            return null;
        }
        char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };

        try {
            byte[] btInput = s.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0 ; i < j ; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static String getMD5(String str){
        if (str == null || str.equals("")){
            return null;
        }
        String t3 = getMD5_32(str.trim()).toLowerCase();
        StringBuffer sb = new StringBuffer(t3);
        return sb.toString();
    }
    public static String getMD5(String str ,int i){
        if (str == null || str.equals("")){
            return null;
        }
        String t3 = null;
        if(i>0){
            t3 = getMD5_32(str.trim().toLowerCase()).toLowerCase();
        }else{
            t3 = getMD5_32(str.trim().toLowerCase()).toLowerCase();
        }
        StringBuffer sb = new StringBuffer(t3);
        return sb.toString();
    }

    public static String getMD6(String str){
        if (str == null || str.equals("")){
            return null;
        }
        String t3 = getMD5_32(str.trim()).toLowerCase();
        String vl = t3.substring(0, 16);
        String vr = t3.substring(16, 32);
        t3 = strreverse(vr+vl);
        StringBuffer sb = new StringBuffer(t3);
        return sb.toString();
    }

    public static String strreverse(String s){
        char[] array = s.toCharArray();
        String reverse = "";
        for (int i = array.length - 1; i >= 0; i--){
            reverse += array[i];
        }
        return reverse;
    }


}
