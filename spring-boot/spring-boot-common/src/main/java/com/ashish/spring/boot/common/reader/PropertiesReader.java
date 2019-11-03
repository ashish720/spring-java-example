package com.ashish.spring.boot.common.reader;

import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Component
public class PropertiesReader {

    public Properties getProperties(String filePath) throws IOException {
        if(filePath==null || filePath.isEmpty() || filePath.trim().isEmpty()){
            return null;
        }
        return getProperties(new FileInputStream(filePath));
    }
    public Properties getProperties(InputStream inputStream) throws IOException {
        Properties properties = new Properties();
        properties.load(inputStream);
        return properties;
    }

}
