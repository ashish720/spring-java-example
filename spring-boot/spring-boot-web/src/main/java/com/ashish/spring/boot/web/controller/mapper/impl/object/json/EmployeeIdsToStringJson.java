package com.ashish.spring.boot.web.controller.mapper.impl.object.json;

import com.ashish.spring.boot.common.jsonmapper.ObjectToJsonMap;
import com.ashish.spring.boot.common.jsonmapper.util.MapperUtils;
import com.ashish.spring.boot.pojo.io.EmployeeIds;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

@Service
public class EmployeeIdsToStringJson implements ObjectToJsonMap<String, EmployeeIds> {
    @Override
    public String convertObjectToJson(EmployeeIds input) {
        return MapperUtils.objectToJson(input);
    }
}
