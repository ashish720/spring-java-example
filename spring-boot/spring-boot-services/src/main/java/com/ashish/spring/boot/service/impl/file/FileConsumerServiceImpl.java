package com.ashish.spring.boot.service.impl.file;

import com.ashish.spring.boot.common.constant.FileConstant;
import com.ashish.spring.boot.common.jsonmapper.JsonToObject;
import com.ashish.spring.boot.common.jsonmapper.util.MapperUtils;
import com.ashish.spring.boot.common.properties.ProducerApiData;
import com.ashish.spring.boot.common.util.FileUtils;
import com.ashish.spring.boot.pojo.dto.DuplicateKeyDTO;
import com.ashish.spring.boot.pojo.dto.FileCompareDTO;
import com.ashish.spring.boot.pojo.io.DuplicateKeyFinderIO;
import com.ashish.spring.boot.common.constant.BootHttpConstant;
import com.ashish.spring.boot.service.file.FileConsumerService;
import com.ashish.spring.boot.service.http.HttpService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

@Service
public class FileConsumerServiceImpl implements FileConsumerService {

    @Autowired
    HttpService httpService;

    @Autowired
    private ProducerApiData producerApiData;

    @Override
    public FileCompareDTO fetchFileCompareData(String jsonBody, Map<String, String> headers) {
        ResponseEntity<String> jsonResponse = httpService.invokeRestApi(producerApiData.getRepoFileCompareUrl(),jsonBody,headers, HttpMethod.POST);
        return FileUtils.responseBodyToObject(jsonResponse,new FileCompareDTO());
    }

    @Override
    public DuplicateKeyFinderIO fetchDuplicateKeys(Map<String,String> headers) {
        ResponseEntity<String> jsonResponse = httpService.invokeRestApi(producerApiData.getDuplicateKeyUrl(),null,headers, HttpMethod.GET);
        return FileUtils.responseBodyToObject(jsonResponse,new DuplicateKeyFinderIO());
    }


}
