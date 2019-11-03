package com.ashish.spring.boot.service.util;

import java.util.HashMap;
import java.util.Map;

public class RequestUtils {

    public static Map<String, String> addHeader(Map<String, String> headerMap) {
        Map<String, String> header = new HashMap<>();
        header.putAll(headerMap);
        return header;
    }

    public static  Map<String, String> addJsonHeader() {
        Map<String, String> jsonHeader = new HashMap<>();
        jsonHeader.put("Content-Type", "application/json");
        return addHeader(jsonHeader);
    }
}
