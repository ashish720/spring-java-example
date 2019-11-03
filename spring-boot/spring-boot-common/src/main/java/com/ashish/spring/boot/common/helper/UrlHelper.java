package com.ashish.spring.boot.common.helper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class UrlHelper {

    public static List<String> fetchAllPlaceholder(String location,String startPrefix,String endSuffix){
        if(location==null){ return Collections.emptyList();}
        List<String> allPlaceHolder=new ArrayList<>();
        String splittedLocation[]=location.split(startPrefix);
        if(splittedLocation!=null && splittedLocation.length>0){
            for(String partialLocation:splittedLocation){
                if(partialLocation.contains(endSuffix)){
                    allPlaceHolder.add(partialLocation.split(endSuffix)[0]);
                }
            }
        }
        return allPlaceHolder;
    }

    public static String prepareUrl(Map<String,String> keyValue,List<String> keyNeedsToCheck,String location,String startPrefix,String endSuffix){
        String url=location;
        for(Map.Entry<String,String> keyValueMapEntry:keyValue.entrySet()){
            String key=keyValueMapEntry.getKey();
            String value=keyValueMapEntry.getValue();
            if(keyNeedsToCheck.contains(key)){
                url=url.replaceAll(startPrefix+key+endSuffix,value);
            }
        }
        return url;
    }
}
