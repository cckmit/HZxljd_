package com.ruoyi.web.controller.thirdParty.parkingSpace.util;

import com.google.gson.Gson;

import java.lang.reflect.Type;

public class GsonUtil {

    private static Gson GSON = new Gson();

    public static <T> T fromJson(String json, Type type) {
        return GSON.fromJson(json, type);
    }

    public static <T> T fromJson(String json, Class<T> classOfT) {
        return GSON.fromJson(json, classOfT);
    }

    public static <T> T fromJsonp(String jsonp, Class<T> classOfT) {
        String json = jsonp.substring(jsonp.indexOf("{"), jsonp.lastIndexOf("}") + 1);
        return GSON.fromJson(json, classOfT);
    }

    public static String toJson(Object src) {
        return GSON.toJson(src);
    }

}
