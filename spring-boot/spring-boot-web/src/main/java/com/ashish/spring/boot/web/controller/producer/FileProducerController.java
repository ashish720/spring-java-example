package com.ashish.spring.boot.web.controller.producer;

import com.ashish.spring.boot.pojo.dto.DuplicateKeyDTO;
import com.ashish.spring.boot.pojo.dto.FileCompareDTO;
import com.ashish.spring.boot.pojo.dto.FileListsDTO;
import com.ashish.spring.boot.pojo.io.FileInputIO;
import com.ashish.spring.boot.service.file.FileProducerService;
import com.ashish.spring.boot.web.controller.constant.BootWebConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.List;

@RestController
public class FileProducerController {

    @Autowired
    FileProducerService fileProducerService;
    @PostMapping(BootWebConstant.BOOT_PRODUCER_API+"/compare/repo/file")
    public FileCompareDTO compareFileFromRepository(@RequestBody FileInputIO fileInputIO){
        return fileProducerService.comparePropertyFileFromRepository(fileInputIO);
    }

    @GetMapping(BootWebConstant.BOOT_PRODUCER_API+"/repo/file/lists")
    public FileListsDTO fetchAllFileList(){
        return fileProducerService.fetchAllFiles();
    }

    @GetMapping(BootWebConstant.BOOT_PRODUCER_API+"/property/files/duplicate/keys")
    public DuplicateKeyDTO fetchDuplicateFromAllFile(){
        List<File> files = fileProducerService.findAllPropertyFileList();
        return fileProducerService.readDuplicateKeys(files);
    }
}
