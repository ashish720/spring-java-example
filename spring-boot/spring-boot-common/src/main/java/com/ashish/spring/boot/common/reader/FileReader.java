package com.ashish.spring.boot.common.reader;

import com.ashish.spring.boot.common.constant.FileConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

@Component
public class FileReader {


    @Autowired
    private PropertiesReader propertiesReader;

    public List<File> fetchPropertiesFileFromBaseDir(){
        String dirPath = FileConstant.PROPERTIES_FILE_DIR+"other";
        Path path =Paths.get(dirPath);
        List<File> files=new ArrayList<>();
        try {
            DirectoryStream<Path> directoryStream=Files.newDirectoryStream(path, filePath->filePath.toString().endsWith(".properties"));
            directoryStream.forEach(file->files.add(file.toFile()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return files;
    }

    public Map<String,List<String>> readDuplicateKey(List<File> files){
        Map<String,Integer> keyCounterMap=new HashMap<>();
        files.stream().forEach(file -> {
            Scanner scan = null;
            try {
                scan = new Scanner(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            while(scan.hasNextLine()) {
                String split[] = scan.nextLine().trim().split("=");
                if(split.length == 2) {
                    if(keyCounterMap.get(file.getName()+"==>"+split[0])==null){
                        keyCounterMap.put(file.getName()+"==>"+split[0],1);
                    }else{
                        keyCounterMap.put(file.getName()+"==>"+split[0],keyCounterMap.get(file.getName()+"==>"+split[0])+1);
                    }
                }
            }
        });
        Map<String,List<String>> keyMap=new HashMap<>();
        keyCounterMap.forEach((key, keyCounter) -> {
            if(keyCounter>1){
                String fileName=key.split("==>")[0];
                String duplicateKey =key.split("==>")[1];
                if(keyMap.get(fileName)==null){
                    keyMap.put(fileName,new ArrayList<>());
                }
                keyMap.get(fileName).add(duplicateKey);
            }
        });
        return keyMap;
    }
}
