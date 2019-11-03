package com.ashish.spring.boot.service.http;

import com.ashish.spring.boot.common.constant.EmployeeConstants;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface HttpService<O> {

    ResponseEntity<O> invokeRestApi(String url, String jsonBody, Map<String, String> headerMap, HttpMethod httpMethod);

    default ResponseEntity<String> errorResponseEntity(String status,String code,String message, HttpStatus httpStatus){
        String uriSyntaxJsonException = String.format(EmployeeConstants.JSON_FAILED_BODY,status,code,message);
        return new ResponseEntity<String>(uriSyntaxJsonException, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
