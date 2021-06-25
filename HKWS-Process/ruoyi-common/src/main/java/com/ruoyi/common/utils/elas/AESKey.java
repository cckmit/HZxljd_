package com.ruoyi.common.utils.elas;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public  class AESKey {


    public static void main(String[] args) throws NoSuchAlgorithmException {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(50);
        KeyPair pair = keyGen.generateKeyPair();

        byte[] publicBytes = pair.getPublic().getEncoded();
        byte[] privateBytes = pair.getPrivate().getEncoded();

        Map<String,Object> aes=new HashMap<>();
        aes.put("publicBytes",base64Encode(publicBytes));
        aes.put("privateBytes",base64Encode(privateBytes));
        for (Map.Entry<String,Object> entity: aes.entrySet()
        ) {
            System.out.println("key="+entity.getKey()+",value = "+entity.getValue());
        }
    }

  public static Map AESMap() throws NoSuchAlgorithmException {
      KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
      keyGen.initialize(512);
      KeyPair pair = keyGen.generateKeyPair();
      byte[] publicBytes = pair.getPublic().getEncoded();
      byte[] privateBytes = pair.getPrivate().getEncoded();
      Map<String,Object> aes=new HashMap<>();
      aes.put("publicBytes",base64Encode(publicBytes));
      aes.put("privateBytes",base64Encode(privateBytes));
      return aes;
  }

    static String base64Encode(byte[] bytes) {

        return Base64.getEncoder().encodeToString(bytes);
    }

    public static String getRandomNickname(int length) {
        String val = "";
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            // 输出字母还是数字
            String charOrNum = random.nextInt(2) % 2 == 0 ? "CHAR" : "num";
            // 字符串
            if ("char".equalsIgnoreCase(charOrNum)) {
                // 取得大写字母还是小写字母
                int choice = random.nextInt(2) % 2 == 0 ? 65 : 97;
                val += (char) (choice + random.nextInt(26));
            } else if ("num".equalsIgnoreCase(charOrNum)) { // 数字
                val += String.valueOf(random.nextInt(10));
            }
        }
        return val;
    }
    //计算加减
    public static int nDaysBetweenTwoDate(String firstString,String secondString) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date firstDate=null;
        Date secondDate=null;
        try {
            firstDate = df.parse(firstString);
            secondDate=df.parse(secondString);
        }
        catch(Exception e) {
            // 日期型字符串格式错误
        }

        int nDay=(int)((secondDate.getTime()-firstDate.getTime())/(24*60*60*1000));
        return nDay;
    }

    public static String[] getUUID(int number){
        if(number < 1){
            return null;
        }
        String[] retArray = new String[number];
        for(int i=0;i<number;i++){
            retArray[i] = getUUID();
        }
        return retArray;
    }

    /**
     * 获得一个UUID
     * @return String UUID
     */
    public static String getUUID(){
        String uuid = UUID.randomUUID().toString();
        //去掉“-”符号
        return uuid.replaceAll("", "");
    }

    /** 比较两个时间相差天数 */
    public static float calculateTimeGapDay(String time1, String time2) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
                "yyyy-MM-dd");

        float day = 0;
        Date date1 = null;
        Date date2 = null;

        try {
            date1 = simpleDateFormat.parse(time1);
            date2 = simpleDateFormat.parse(time2);
            long millisecond = date2.getTime() - date1.getTime();
            day = millisecond / (24 * 60 * 60 * 1000);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return (day);
    }


}
