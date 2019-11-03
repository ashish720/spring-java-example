package com.ashish.spring.boot.common.reader;

import com.ashish.spring.boot.common.jsonmapper.FileInputToJson;
import com.ashish.spring.boot.common.jsonmapper.ObjectToJsonMap;
import com.ashish.spring.boot.common.jsonmapper.util.MapperUtils;
import com.ashish.spring.boot.pojo.io.FileInputIO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@Component
public class JsonFileReader<JObject> {

    private static final String JSON_RESOURCE_FILE_PATH="com/ashish/spring/boot/data/json/";

    public void fileToJObject(String filePath,JObject j){
        InputStream is=this.getClass().getResourceAsStream(JSON_RESOURCE_FILE_PATH+filePath);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
        StringBuilder responseBuilder = new StringBuilder();
        String line = null;
        try {
            line = bufferedReader.readLine();
            while (line != null) {
                responseBuilder.append(line).append("\n");
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            j=(JObject)MapperUtils.jsonToObject(responseBuilder.toString(),j);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
