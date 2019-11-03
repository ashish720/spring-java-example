package com.ashish.spring.boot.dao.data;


import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public interface DataProvider<T> {

    T fetchData(String fileName) throws IOException;

    T deleteListedData(String fileName, T t);

    T deleteSingleData(String fileName, Object id);

    default T readFileStream(String fileName, T t){
        T tobj=null;
        try(InputStream is = DataProvider.class.getResourceAsStream(fileName)){
            ObjectMapper objectMapper = new ObjectMapper();
            tobj = (T)objectMapper.readValue(is,t.getClass());
            return tobj;
        }catch (IOException io){
            io.printStackTrace();
            return tobj;
        }
    }
}
