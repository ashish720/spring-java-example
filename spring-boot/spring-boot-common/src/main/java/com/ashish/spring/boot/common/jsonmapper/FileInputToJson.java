package com.ashish.spring.boot.common.jsonmapper;

import com.ashish.spring.boot.common.jsonmapper.ObjectToJsonMap;
import com.ashish.spring.boot.common.jsonmapper.util.MapperUtils;
import com.ashish.spring.boot.pojo.io.FileInputIO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

@Service
public class FileInputToJson implements ObjectToJsonMap<String, FileInputIO> {

    @Override
    public String convertObjectToJson(FileInputIO input) {
        return MapperUtils.objectToJson(input);
    }
}
