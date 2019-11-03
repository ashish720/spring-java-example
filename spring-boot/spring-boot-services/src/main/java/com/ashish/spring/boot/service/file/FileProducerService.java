package com.ashish.spring.boot.service.file;

import com.ashish.spring.boot.pojo.dto.DuplicateKeyDTO;
import com.ashish.spring.boot.pojo.dto.FileCompareDTO;
import com.ashish.spring.boot.pojo.dto.FileListsDTO;
import com.ashish.spring.boot.pojo.io.FileInputIO;

import java.io.File;
import java.util.List;
import java.util.Map;

public interface FileProducerService {

    FileListsDTO fetchAllFiles();
    FileCompareDTO comparePropertyFileFromRepository(FileInputIO fileInputIO);
    List<File> findAllPropertyFileList();
    DuplicateKeyDTO readDuplicateKeys(List<File> files);
}
