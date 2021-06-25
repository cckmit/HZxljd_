package com.ruoyi.web.controller.thirdParty.parkingSpace.util;

import com.google.gson.Gson;
import org.apache.http.Consts;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.ByteArrayBody;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.InputStreamBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.lang.reflect.Type;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HttpPost {

    /**
     * @param httpUrl
     * @param params
     * @param headerParams
     * @return
     */
    public static String send(final String httpUrl, final Map<String, String> params, final Map<String, String> headerParams) throws Exception {
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        try {
            httpClient = HttpClients.createDefault();
            RequestBuilder requestBuilder = RequestBuilder.post()
                    .setUri(new URI(httpUrl))
                    .setConfig(Config.getRequestConfig());
            // params
            if (params != null && !params.isEmpty()) {
                List<NameValuePair> formParams = new ArrayList<NameValuePair>();
                for (Map.Entry<String, String> entry : params.entrySet()) {
                    formParams.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
                }
                requestBuilder.setEntity(new UrlEncodedFormEntity(formParams, Consts.UTF_8));
            }
            // headers
            if (headerParams != null) {
                for (Map.Entry<String, String> entry : headerParams.entrySet()) {
                    requestBuilder.addHeader(entry.getKey(), entry.getValue());
                }
            }
            HttpUriRequest httpUriRequest = requestBuilder.build();
            response = httpClient.execute(httpUriRequest);
            return EntityUtils.toString(response.getEntity(), Consts.UTF_8);
        } finally {
            if (response != null) {
                response.close();
            }
            if (httpClient != null) {
                httpClient.close();
            }
        }
    }

    /**
     * @param httpUrl
     * @param params
     * @return
     */
    public static String send(final String httpUrl, final Map<String, String> params) throws Exception {
        return send(httpUrl, params, null);
    }

    /**
     * @param httpUrl
     * @return
     */
    public static String send(final String httpUrl) throws Exception {
        return send(httpUrl, null, null);
    }

    /**
     * @param httpUrl
     * @param params
     * @param headerParams
     * @return
     */
    public static String sendJson(final String httpUrl, final Map<String, String> params, final Map<String, String> headerParams) throws Exception {
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        try {
            httpClient = HttpClients.createDefault();
            RequestBuilder requestBuilder = RequestBuilder.post()
                    .setUri(new URI(httpUrl))
                    .setConfig(Config.getRequestConfig());
            // params
            if (params != null && !params.isEmpty()) {
                requestBuilder.setEntity(new StringEntity(new Gson().toJson(params), ContentType.APPLICATION_JSON));
            }
            // headers
            if (headerParams != null) {
                for (Map.Entry<String, String> entry : headerParams.entrySet()) {
                    requestBuilder.addHeader(entry.getKey(), entry.getValue());
                }
            }
            HttpUriRequest httpUriRequest = requestBuilder.build();
            response = httpClient.execute(httpUriRequest);
            return EntityUtils.toString(response.getEntity(), Consts.UTF_8);
        } finally {
            if (response != null) {
                response.close();
            }
            if (httpClient != null) {
                httpClient.close();
            }
        }
    }

    /**
     * @param httpUrl
     * @param params
     * @return
     */
    public static String sendJson(final String httpUrl, final Map<String, String> params) throws Exception {
        return sendJson(httpUrl, params, null);
    }

    /**
     * @param httpUrl
     * @return
     */
    public static String sendJson(final String httpUrl) throws Exception {
        return sendJson(httpUrl, null, null);
    }


    /**
     * @param httpUrl
     * @param xmlStr
     * @param headerParams
     * @return
     */
    public static String sendXml(final String httpUrl, final String xmlStr, final Map<String, String> headerParams) throws Exception {
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        try {
            httpClient = HttpClients.createDefault();
            RequestBuilder requestBuilder = RequestBuilder.post()
                    .setUri(new URI(httpUrl))
                    .setConfig(Config.getRequestConfig())
                    // .setEntity(new StringEntity(xmlStr, ContentType.create("application/x-www-form-urlencoded", Consts.UTF_8)));
                    .setEntity(new StringEntity(xmlStr, ContentType.create("application/xml", Consts.UTF_8)));
            // headers
            if (headerParams != null) {
                for (Map.Entry<String, String> entry : headerParams.entrySet()) {
                    requestBuilder.addHeader(entry.getKey(), entry.getValue());
                }
            }
            HttpUriRequest httpUriRequest = requestBuilder.build();
            response = httpClient.execute(httpUriRequest);
            return EntityUtils.toString(response.getEntity(), Consts.UTF_8);
        } finally {
            if (response != null) {
                response.close();
            }
            if (httpClient != null) {
                httpClient.close();
            }
        }
    }

    /**
     * @param httpUrl
     * @param xmlStr
     * @return
     */
    public static String sendXml(final String httpUrl, final String xmlStr) throws Exception {
        return sendXml(httpUrl, xmlStr, null);
    }

    /**
     * @param httpUrl
     * @return
     */
    public static String sendXml(final String httpUrl) throws Exception {
        return sendXml(httpUrl, null, null);
    }

    /**
     * @param httpUrl
     * @param params
     * @return
     */
    public static String sendJsonObject(final String httpUrl, final Map<String, Object> params) throws Exception {
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        try {
            httpClient = HttpClients.createDefault();
            RequestBuilder requestBuilder = RequestBuilder.post()
                    .setUri(new URI(httpUrl))
                    .setConfig(Config.getRequestConfig());
            // params
            if (params != null && !params.isEmpty()) {
                requestBuilder.setEntity(new StringEntity(GsonUtil.toJson(params), ContentType.APPLICATION_JSON));
            }
            HttpUriRequest httpUriRequest = requestBuilder.build();
            response = httpClient.execute(httpUriRequest);
            return EntityUtils.toString(response.getEntity(), Consts.UTF_8);
        } finally {
            if (response != null) {
                response.close();
            }
            if (httpClient != null) {
                httpClient.close();
            }
        }
    }

    /**
     * @param httpUrl
     * @param object
     * @return
     */
    public static String sendJsonObject(final String httpUrl, final Object object) throws Exception {
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        try {
            httpClient = HttpClients.createDefault();
            RequestBuilder requestBuilder = RequestBuilder.post()
                    .setUri(new URI(httpUrl))
                    .setConfig(Config.getRequestConfig());
            // params
            if (object != null) {
                requestBuilder.setEntity(new StringEntity(GsonUtil.toJson(object), ContentType.APPLICATION_JSON));
            }
            HttpUriRequest httpUriRequest = requestBuilder.build();
            response = httpClient.execute(httpUriRequest);
            return EntityUtils.toString(response.getEntity(), Consts.UTF_8);
        } finally {
            if (httpClient != null) {
                httpClient.close();
            }
            if (httpClient != null) {
                httpClient.close();
            }
        }
    }

    /**
     * @param httpUrl
     * @param object
     * @param type
     * @param <T>
     * @return
     */
    public static <T> T sendJsonObject(final String httpUrl, final Object object, final Type type) throws Exception {
        return GsonUtil.fromJson(sendJsonObject(httpUrl, object), type);
    }

    /**
     * @param httpUrl
     * @param object
     * @param classOf
     * @param <T>
     * @return
     */
    public static <T> T sendJsonObject(final String httpUrl, final Object object, final Class<T> classOf) throws Exception {
        return GsonUtil.fromJson(sendJsonObject(httpUrl, object), classOf);
    }

    /**
     * 携带图片
     * multipartEntityBuilder.addPart(entry.getKey(), new StringBody(entry.getValue(), ContentType.TEXT_PLAIN));
     * multipartEntityBuilder.addPart("comment", comment);
     *
     * @param httpUrl
     * @param params
     * @param fileParams
     * @return
     */
    public static String sendMultipart(final String httpUrl, final Map<String, String> params, final Map<String, File> fileParams) throws Exception {
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        try {
            httpClient = HttpClients.createDefault();
            RequestBuilder requestBuilder = RequestBuilder.post()
                    .setUri(new URI(httpUrl))
                    .setConfig(Config.getRequestConfig());
            MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder.create();
            // params
            if (params != null && !params.isEmpty()) {
                for (Map.Entry<String, String> entry : params.entrySet()) {
                    multipartEntityBuilder.addPart(entry.getKey(), new StringBody(entry.getValue(),
                            ContentType.create("text/plain", Consts.UTF_8)));
                }
            }
            // inputStreams
            if (fileParams != null) {
                for (Map.Entry<String, File> entry : fileParams.entrySet()) {
                    if (entry.getValue() != null) {
                        multipartEntityBuilder.addPart(entry.getKey(), new FileBody(entry.getValue()));
                    }
                }
            }
            requestBuilder.setEntity(multipartEntityBuilder.build());
            HttpUriRequest httpUriRequest = requestBuilder.build();
            response = httpClient.execute(httpUriRequest);
            return EntityUtils.toString(response.getEntity(), Consts.UTF_8);
        } finally {
            if (response != null) {
                response.close();
            }
            if (httpClient != null) {
                httpClient.close();
            }
        }
    }

    /**
     * 携带图片
     * multipartEntityBuilder.addPart(entry.getKey(), new StringBody(entry.getValue(), ContentType.TEXT_PLAIN));
     * multipartEntityBuilder.addPart("comment", comment);
     *
     * @param httpUrl
     * @param headerParams
     * @param fileParams
     * @return
     */
    public static String sendMultipart1(final String httpUrl, final Map<String, String> headerParams, final Map<String, File> fileParams) throws Exception {
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        try {
            httpClient = HttpClients.createDefault();
            RequestBuilder requestBuilder = RequestBuilder.post()
                    .setUri(new URI(httpUrl))
                    .setConfig(Config.getRequestConfig());
            MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder.create();
            // headers
            if (headerParams != null) {
                for (Map.Entry<String, String> entry : headerParams.entrySet()) {
                    requestBuilder.addHeader(entry.getKey(), entry.getValue());
                }
            }
            // inputStreams
            if (fileParams != null) {
                for (Map.Entry<String, File> entry : fileParams.entrySet()) {
                    if (entry.getValue() != null) {
                        multipartEntityBuilder.addPart(entry.getKey(), new FileBody(entry.getValue()));
                    }
                }
            }
            requestBuilder.setEntity(multipartEntityBuilder.build());
            HttpUriRequest httpUriRequest = requestBuilder.build();
            response = httpClient.execute(httpUriRequest);
            return EntityUtils.toString(response.getEntity(), Consts.UTF_8);
        } finally {
            if (response != null) {
                response.close();
            }
            if (httpClient != null) {
                httpClient.close();
            }
        }
    }

    /**
     * @param httpUrl
     * @param params       普通参数
     * @param inputStreams 数据流参数
     * @return
     */
    public static String sendMultipartByInputStreamBody(
            final String httpUrl, final Map<String, String> params, final Map<String, InputStreamBody> inputStreams) throws Exception {
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        try {
            httpClient = HttpClients.createDefault();
            RequestBuilder requestBuilder = RequestBuilder.post()
                    .setUri(new URI(httpUrl))
                    .setConfig(Config.getRequestConfig());
            MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder.create();
            // params
            if (params != null && !params.isEmpty()) {
                for (Map.Entry<String, String> entry : params.entrySet()) {
                    multipartEntityBuilder.addPart(entry.getKey(), new StringBody(entry.getValue(),
                            ContentType.create("text/plain", Consts.UTF_8)));
                }
            }
            // inputStreams
            if (inputStreams != null && !inputStreams.isEmpty()) {
                for (Map.Entry<String, InputStreamBody> entry : inputStreams.entrySet()) {
                    String fileName = entry.getKey();
                    InputStreamBody inputStreamBody = entry.getValue();
                    multipartEntityBuilder.addPart(fileName, inputStreamBody);
                }
            }
            requestBuilder.setEntity(multipartEntityBuilder.build());
            HttpUriRequest httpUriRequest = requestBuilder.build();
            response = httpClient.execute(httpUriRequest);
            return EntityUtils.toString(response.getEntity(), Consts.UTF_8);
        } finally {
            if (response != null) {
                response.close();
            }
            if (httpClient != null) {
                httpClient.close();
            }
        }
    }

    /**
     * @param httpUrl
     * @param inputStreams 数据流参数
     * @return
     */
    public static String sendMultipartByInputStreamBody(final String httpUrl, final Map<String, InputStreamBody> inputStreams) throws Exception {
        return sendMultipartByInputStreamBody(httpUrl, null, inputStreams);
    }

    /**
     * 上传图片
     *
     * @param httpUrl
     * @param params
     * @param byteArrays
     * @return
     */
    public static String sendMultipartByByteArrayBody(final String httpUrl, final Map<String, String> params, final Map<String, ByteArrayBody> byteArrays) throws Exception {
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        try {
            httpClient = HttpClients.createDefault();
            RequestBuilder requestBuilder = RequestBuilder.post()
                    .setUri(new URI(httpUrl))
                    .setConfig(Config.getRequestConfig());
            MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder.create();
            // params
            if (params != null && !params.isEmpty()) {
                for (Map.Entry<String, String> entry : params.entrySet()) {
                    multipartEntityBuilder.addPart(entry.getKey(), new StringBody(entry.getValue(),
                            ContentType.create("text/plain", Consts.UTF_8)));
                }
            }
            // byteArrays
            if (byteArrays != null && !byteArrays.isEmpty()) {
                for (Map.Entry<String, ByteArrayBody> entry : byteArrays.entrySet()) {
                    String fileName = entry.getKey();
                    ByteArrayBody byteArrayBody = entry.getValue();
                    multipartEntityBuilder.addPart(fileName, byteArrayBody);
                }
            }
            requestBuilder.setEntity(multipartEntityBuilder.build());
            HttpUriRequest httpUriRequest = requestBuilder.build();
            response = httpClient.execute(httpUriRequest);
            return EntityUtils.toString(response.getEntity(), Consts.UTF_8);
        } finally {
            if (response != null) {
                response.close();
            }
            if (httpClient != null) {
                httpClient.close();
            }
        }
    }

    /**
     * 上传图片
     *
     * @param httpUrl
     * @param headerParams
     * @param byteArrays
     * @return
     */
    public static String sendMultipartByByteArrayBody1(final String httpUrl, final Map<String, String> headerParams, final Map<String, ByteArrayBody> byteArrays) throws Exception {
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        try {
            httpClient = HttpClients.createDefault();
            RequestBuilder requestBuilder = RequestBuilder.post()
                    .setUri(new URI(httpUrl))
                    .setConfig(Config.getRequestConfig());
            MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder.create();
            // headers
            if (headerParams != null) {
                for (Map.Entry<String, String> entry : headerParams.entrySet()) {
                    requestBuilder.addHeader(entry.getKey(), entry.getValue());
                }
            }
            // byteArrays
            if (byteArrays != null && !byteArrays.isEmpty()) {
                for (Map.Entry<String, ByteArrayBody> entry : byteArrays.entrySet()) {
                    String fileName = entry.getKey();
                    ByteArrayBody byteArrayBody = entry.getValue();
                    multipartEntityBuilder.addPart(fileName, byteArrayBody);
                }
            }
            requestBuilder.setEntity(multipartEntityBuilder.build());
            HttpUriRequest httpUriRequest = requestBuilder.build();
            response = httpClient.execute(httpUriRequest);
            return EntityUtils.toString(response.getEntity(), Consts.UTF_8);
        } finally {
            if (response != null) {
                response.close();
            }
            if (httpClient != null) {
                httpClient.close();
            }
        }
    }

    /**
     * 上传图片
     *
     * @param httpUrl
     * @param byteArrays
     * @return
     */
    public static String sendMultipartByByteArrayBody(final String httpUrl, final Map<String, ByteArrayBody> byteArrays) throws Exception {
        return sendMultipartByByteArrayBody(httpUrl, null, byteArrays);
    }

    /**
     * @param httpUrl
     * @param params
     * @return
     */
    public static byte[] sendAndReceiveByteArray(final String httpUrl, final Map<String, String> params) throws Exception {
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        try {
            httpClient = HttpClients.createDefault();
            RequestBuilder requestBuilder = RequestBuilder.post()
                    .setUri(new URI(httpUrl))
                    .setConfig(Config.getRequestConfig());
            // params
            if (params != null) {
                for (Map.Entry<String, String> entry : params.entrySet()) {
                    requestBuilder.addParameter(entry.getKey(), entry.getValue());
                }
            }
            HttpUriRequest httpUriRequest = requestBuilder.build();
            response = httpClient.execute(httpUriRequest);
            return EntityUtils.toByteArray(response.getEntity());
        } finally {
            if (response != null) {
                response.close();
            }
            if (httpClient != null) {
                httpClient.close();
            }
        }
    }

    /**
     * @param httpUrl
     * @return
     */
    public static byte[] sendAndReceiveByteArray(final String httpUrl) throws Exception {
        return sendAndReceiveByteArray(httpUrl, null);
    }

//    public static void main(String[] args) throws Exception {
//        // 下载图片
//        Map<String, String> params = new HashMap<String, String>();
//        params.put("file", "00171221102849211001211.jpg");
//        byte[] bytes = HttpGet.sendAndReceiveByteArray("http://192.168.200.151:2080/uc_file-srv/download.do", params);
//        // 上传图片
//        if (bytes != null && bytes.length > 0) {
//            Map<String, ByteArrayBody> params2 = new HashMap<String, ByteArrayBody>();
//            params2.put("file", new ByteArrayBody(bytes, "00171221102849211001212.jpg"));
//            String json = HttpPost.sendMultipartByByteArrayBody("http://192.168.200.151:2080/uc_file-srv/upload.do", null, params2);
//            System.out.println(json);
//        }
//    }

}
