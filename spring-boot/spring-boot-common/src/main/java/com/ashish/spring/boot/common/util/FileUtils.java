package com.ashish.spring.boot.common.util;

import com.ashish.spring.boot.common.constant.BootHttpConstant;
import com.ashish.spring.boot.common.constant.FileConstant;
import com.ashish.spring.boot.common.jsonmapper.util.MapperUtils;
import com.ashish.spring.boot.pojo.dto.FileCompareDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.ResponseEntity;

import java.io.IOException;

public final class FileUtils {

    public static <E> E createErrorResponse(String status, String code, String message, E e) {
        E error = null;
        try {
            error= (E) MapperUtils.jsonToObject(String.format(BootHttpConstant.JSON_FAILED_BODY,status,code,message),e);
        } catch (IOException ioException) {
            return error;
        }
        return error;
    }

    public static <F> F responseBodyToObject(ResponseEntity<String> jsonResponse,F f) {
        if(jsonResponse==null || jsonResponse.getStatusCodeValue()!=200){
            return FileUtils.createErrorResponse(FileConstant.REPO_FILE_COMPARE_API_FAILED, BootHttpConstant.CONNECTION_ERROR_CODE," found error while trying to get produce api. ",f);
        }
        F fileInfo=null;
        try {
            fileInfo=(F) MapperUtils.jsonToObject(jsonResponse.getBody(),f);
        } catch (IOException e) {
            if(e instanceof IOException) {
                fileInfo = FileUtils.createErrorResponse(FileConstant.REPO_FILE_COMPARE_API_FAILED, BootHttpConstant.CONNECTION_ERROR_CODE, " found error while trying to connect produce api. ",f);
            }else if(e.getCause() instanceof JsonProcessingException){
                fileInfo = FileUtils.createErrorResponse(FileConstant.REPO_FILE_COMPARE_API_FAILED, BootHttpConstant.JSON_PARSE_ERROR_CODE, " fetched json parsing issue. ",f);
            }
            return fileInfo;
        }
        return fileInfo;
    }
}
