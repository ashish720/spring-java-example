package com.ashish.spring.boot.common.util;

import java.util.HashMap;
import java.util.Map;

public final class RequestUtils {

    private RequestUtils() {
    }

    public static Map<String,String> addJsonMediaInHeader(){
        Map<String,String> headers = new HashMap<>();
        headers.put("Content-Type","application/json");
        return headers;
    }
}
