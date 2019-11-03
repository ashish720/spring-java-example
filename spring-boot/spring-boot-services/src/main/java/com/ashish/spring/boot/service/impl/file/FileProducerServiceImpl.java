package com.ashish.spring.boot.service.impl.file;

import com.ashish.spring.boot.common.reader.FileReader;
import com.ashish.spring.boot.common.reader.PropertiesReader;
import com.ashish.spring.boot.pojo.dto.*;
import com.ashish.spring.boot.pojo.io.FileInputIO;
import com.ashish.spring.boot.common.constant.FileConstant;
import com.ashish.spring.boot.service.file.FileProducerService;
import com.ashish.spring.boot.service.http.HttpService;
import com.ashish.spring.boot.service.util.FileApiUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class FileProducerServiceImpl implements FileProducerService
{
    @Autowired
    PropertiesReader propertiesReader;

    @Autowired
    HttpService httpService;
    @Autowired
    private FileReader fileReader;

    @Override
    public FileListsDTO fetchAllFiles() {
        List<File> leftFiles=null;
        List<File> rightFiles=null;
        FileListsDTO fileListsDTO=new FileListsDTO();
        try {
            leftFiles=Files.walk(Paths.get(FileConstant.PROPERTIES_FILE_DIR+"left")).filter(Files::isRegularFile).map(Path::toFile).collect(Collectors.toList());
            rightFiles=Files.walk(Paths.get(FileConstant.PROPERTIES_FILE_DIR+"right")).filter(Files::isRegularFile).map(Path::toFile).collect(Collectors.toList());

            fileListsDTO.setFiles(new ArrayList<>());
            FileApiUtils.populateLeftFiles(leftFiles,fileListsDTO);
            FileApiUtils.populateRightFiles(rightFiles,fileListsDTO);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileListsDTO;
    }

    @Override
    public FileCompareDTO comparePropertyFileFromRepository(FileInputIO fileInputIO) {
        if(fileInputIO==null || ( fileInputIO.getLeftFile()!=null && fileInputIO.getLeftFile().trim().isEmpty() )
                             || ( fileInputIO.getRightFile()!=null && fileInputIO.getRightFile().trim().isEmpty() ) ){
            return null;
        }
        Properties leftProperties = null;
        Properties rightProperties=null;
        try {
            leftProperties = propertiesReader.getProperties(FileConstant.PROPERTIES_FILE_DIR+"left\\"+fileInputIO.getLeftFile()+FileConstant.PROPERTIES_FILE_EXTENSION);
            rightProperties = propertiesReader.getProperties(FileConstant.PROPERTIES_FILE_DIR+"right\\"+fileInputIO.getRightFile()+FileConstant.PROPERTIES_FILE_EXTENSION);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(leftProperties==null && rightProperties==null){
            return null;
        }
        Set<String> leftKeyNames = leftProperties.stringPropertyNames();
        Set<String>  rightKeyNames = rightProperties.stringPropertyNames();
        FileCompareDTO fileCompareDTO = new FileCompareDTO();
        fileCompareDTO.setRightFile(new RightFileDTO(fileInputIO.getRightFile()));
        fileCompareDTO.getRightFile().setKeyMissingInRight(new ArrayList<>());
        long keyMatchCount=0;
        for(String leftKey:leftKeyNames){
            for (String rightKey:rightKeyNames){
                if(StringUtils.equalsIgnoreCase(leftKey,rightKey)){
                    keyMatchCount=keyMatchCount+1;
                    break;
                }
            }
            if(keyMatchCount==0){
                fileCompareDTO.getRightFile().getKeyMissingInRight().add(new MissingKeyDTO(leftKey));
            }
            keyMatchCount=0;
        }
        keyMatchCount=0;
        fileCompareDTO.setLeftFile(new LeftFileDTO(fileInputIO.getLeftFile()));
        fileCompareDTO.getLeftFile().setKeyMissingInLeft(new ArrayList<>());
        for(String rightKey:rightKeyNames){
            for (String leftKey:leftKeyNames){
                if(StringUtils.equalsIgnoreCase(rightKey,leftKey)){
                    keyMatchCount=keyMatchCount+1;
                    break;
                }
            }
            if(keyMatchCount==0){
                fileCompareDTO.getLeftFile().getKeyMissingInLeft().add(new MissingKeyDTO(rightKey));
            }
            keyMatchCount=0;
        }
        return fileCompareDTO;
    }

    @Override
    public List<File> findAllPropertyFileList() {
        return fileReader.fetchPropertiesFileFromBaseDir();
    }

    @Override
    public DuplicateKeyDTO readDuplicateKeys(List<File> files) {
        Map<String,List<String>> duplicateKeyMap = fileReader.readDuplicateKey(files);
        DuplicateKeyDTO duplicateKeyDTO = new DuplicateKeyDTO();
        duplicateKeyDTO.setDuplicateKeyMap(duplicateKeyMap);
        return duplicateKeyDTO;
    }
}
