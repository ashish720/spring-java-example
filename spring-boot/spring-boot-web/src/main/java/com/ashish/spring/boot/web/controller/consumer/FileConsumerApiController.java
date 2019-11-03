package com.ashish.spring.boot.web.controller.consumer;

import com.ashish.spring.boot.common.jsonmapper.ObjectToJsonMap;
import com.ashish.spring.boot.pojo.dto.DuplicateKeyDTO;
import com.ashish.spring.boot.pojo.dto.FileCompareDTO;
import com.ashish.spring.boot.pojo.io.DuplicateKeyFinderIO;
import com.ashish.spring.boot.pojo.io.FileCompareIO;
import com.ashish.spring.boot.pojo.io.FileInputIO;
import com.ashish.spring.boot.service.file.FileConsumerService;
import com.ashish.spring.boot.service.file.FileProducerService;
import com.ashish.spring.boot.service.util.RequestUtils;
import com.ashish.spring.boot.web.controller.constant.BootWebConstant;
import com.ashish.spring.boot.web.controller.mapper.iomapper.IOClassMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
public class FileConsumerApiController {

    @Autowired
    @Qualifier("fileInputToJson")
    private ObjectToJsonMap objectToJsonMap;

    @Autowired
    private FileConsumerService fileConsumerService;

    @Autowired
    @Qualifier("fileMapperImpl")
    private IOClassMapper ioClassMapper;

    @GetMapping(BootWebConstant.GET_COMPARE_REPO_FILES)
    public FileCompareIO compareRepoFiles(@RequestParam String leftFileName,@RequestParam String rightFileName){
        FileInputIO fileInputIO =new FileInputIO();
        fileInputIO.setRightFile(rightFileName);
        fileInputIO.setLeftFile(leftFileName);

        String jsonBody = (String)objectToJsonMap.convertObjectToJson(fileInputIO);
        FileCompareDTO fileCompareDTO = fileConsumerService.fetchFileCompareData(jsonBody, RequestUtils.addJsonHeader());
        return (FileCompareIO)ioClassMapper.mapToJsonObject(fileCompareDTO);

    }

    @GetMapping(BootWebConstant.GET_DUPLICATE_KEYS_IN_PROP_FILE)
    public DuplicateKeyFinderIO duplicateKeyFinderInProp(){
        return fileConsumerService.fetchDuplicateKeys(RequestUtils.addJsonHeader());

    }

}
