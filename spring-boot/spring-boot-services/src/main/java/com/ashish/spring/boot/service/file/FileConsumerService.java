package com.ashish.spring.boot.service.file;

import com.ashish.spring.boot.common.jsonmapper.util.MapperUtils;
import com.ashish.spring.boot.pojo.dto.FileCompareDTO;
import com.ashish.spring.boot.pojo.io.DuplicateKeyFinderIO;
import com.ashish.spring.boot.common.constant.BootHttpConstant;

import java.io.IOException;
import java.util.Map;

public interface FileConsumerService {

    DuplicateKeyFinderIO fetchDuplicateKeys(Map<String,String> headers);

    FileCompareDTO fetchFileCompareData(String jsonBody, Map<String,String> headers);
}
