package com.ashish.spring.boot.common.jsonmapper.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

import java.io.IOException;

public class MapperUtils {

    public static String objectToJson(Object input){
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonBody=null;
        try {
            jsonBody=objectMapper.writeValueAsString(input);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonBody;
    }

    public static Object jsonToObject(String json,Object input) throws IOException {
        if(input==null){
            return null;
        }
        ObjectMapper objectMapper = new ObjectMapper();
        Object output=null;
        try {
            output=objectMapper.readValue(json,input.getClass());
        } catch (JsonProcessingException jsonException) {
            throw jsonException;
        } catch (IOException io) {
            throw io;
        }
        return output;
    }
}
