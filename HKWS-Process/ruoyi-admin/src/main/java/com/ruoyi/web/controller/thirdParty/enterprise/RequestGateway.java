package com.ruoyi.web.controller.thirdParty.enterprise;

import cn.hutool.core.map.MapUtil;
import com.ruoyi.system.utils.MD5Util;
import org.apache.http.Consts;
import org.apache.http.HeaderIterator;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.net.SocketTimeoutException;
import java.util.*;

/**
 * RequestGateway
 *
 * @author lcl
 * @date: 2021/4/13
 **/
public class RequestGateway {

    public static String request(String url, String appkey, String appSecret,String jsonStrParam) {
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("appKey", appkey);
        map.put("requestTime", System.currentTimeMillis());
        System.out.println("requestTime" + System.currentTimeMillis());
//        String zwcssign = SecureUtil.md5(appkey + appSecret + map.get("requestTime")).toUpperCase();
        String zwcssign = Md5Utilss.md5Encrypt32Upper(appkey + appSecret + map.get("requestTime"));
//        String zwcssign = MD5Util.getMD5(appkey + appSecret + map.get("requestTime"));
        map.put("zwcsSign", zwcssign);
        map.put("param", jsonStrParam);// 需要转为json格式
        System.out.println(map);
        String userResult = doPostRequest(url, null, map, null);
        return userResult;
    }

    public static String doPostRequest(String url, Map<String, String> header, Map<Object, Object> params,
                                       HttpEntity httpEntity) {
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse httpResponse = null;
        String resultStr = "";

        try {
            httpClient = HttpClientBuilder.create().build();
            HttpPost httpPost = new HttpPost(url);
            RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(5000)
                    .setConnectionRequestTimeout(5000).setSocketTimeout(5000).setRedirectsEnabled(true).build();
            httpPost.setConfig(requestConfig);
            if (MapUtil.isNotEmpty(header)) {
                Iterator var9 = header.entrySet().iterator();

                while (var9.hasNext()) {
                    Map.Entry<String, String> stringStringEntry = (Map.Entry) var9.next();
                    httpPost.setHeader((String) stringStringEntry.getKey(), (String) stringStringEntry.getValue());
                }
            }

            if (MapUtil.isNotEmpty(params)) {
                List<NameValuePair> paramList = new ArrayList();
                Iterator var21 = params.entrySet().iterator();

                while (var21.hasNext()) {
                    Map.Entry<Object, Object> stringStringEntry = (Map.Entry) var21.next();
                    if (stringStringEntry.getValue() != null) {
                        paramList.add(new BasicNameValuePair(stringStringEntry.getKey().toString(),
                                stringStringEntry.getValue().toString()));
                    }
                }

                UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(paramList, Consts.UTF_8);
                httpPost.setEntity(urlEncodedFormEntity);
            }

            if (httpEntity != null) {
                httpPost.setEntity(httpEntity);
            }

            httpResponse = httpClient.execute(httpPost);
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            if (statusCode == 200) {
                HttpEntity httpResponseEntity = httpResponse.getEntity();
                resultStr = EntityUtils.toString(httpResponseEntity);
            } else {
                StringBuffer stringBuffer = new StringBuffer();
                HeaderIterator headerIterator = httpResponse.headerIterator();

                while (headerIterator.hasNext()) {
                    stringBuffer.append("\t" + headerIterator.next());
                }
            }
        } catch (SocketTimeoutException var16) {
        } catch (Exception var17) {
            var17.printStackTrace();
        } finally {
            // closeConnection(httpClient, httpResponse);
        }

        return resultStr;
    }
}
