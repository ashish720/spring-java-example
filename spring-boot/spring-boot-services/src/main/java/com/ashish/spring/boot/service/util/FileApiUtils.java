package com.ashish.spring.boot.service.util;

import com.ashish.spring.boot.pojo.dto.FileCompareListDTO;
import com.ashish.spring.boot.pojo.dto.FileListsDTO;
import com.ashish.spring.boot.pojo.io.FileInputIO;

import java.io.File;
import java.util.List;
import java.util.stream.IntStream;

public class FileApiUtils {

    public static FileInputIO createCompareFileInputIO(String leftFileName,String rightFileName){
        FileInputIO fileInputIO = new FileInputIO();
        fileInputIO.setLeftFile(leftFileName);
        fileInputIO.setRightFile(rightFileName);
        return fileInputIO;
    }

    public static void populateLeftFiles(List<File> files,FileListsDTO fileListsDTO){
        if(files==null || files.isEmpty()){
            return;
        }
        files.forEach(file->{
            fileListsDTO.getFiles().add(new FileCompareListDTO(file.getName(),null));
        });
    }
    public static void populateRightFiles(List<File> files, FileListsDTO fileListsDTO){
        if (files==null || files.isEmpty()){
            return;
        }
        if(files.size()>fileListsDTO.getFiles().size()){
            IntStream.range(0,fileListsDTO.getFiles().size()).forEach(index->{
                fileListsDTO.getFiles().get(index).setRightFile(files.get(index).getName());
            });
            IntStream.range(fileListsDTO.getFiles().size(),files.size()).forEach(index->{
                fileListsDTO.getFiles().add(new FileCompareListDTO(null,files.get(index).getName()));
            });
        }else if(files.size()<fileListsDTO.getFiles().size()){
            IntStream.range(0,files.size()).forEach(index->{
                fileListsDTO.getFiles().get(index).setRightFile(files.get(index).getName());
            });
        }else if(files.size()==fileListsDTO.getFiles().size()){
            IntStream.range(0,files.size()).forEach(index->{
                fileListsDTO.getFiles().get(index).setRightFile(files.get(index).getName());
            });
        }

    }
}
