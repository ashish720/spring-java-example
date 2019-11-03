package com.ashish.spring.boot.service.impl.consumer;

import com.ashish.spring.boot.common.properties.ClientApiData;
import com.ashish.spring.boot.pojo.dto.ApiDTO;
import com.ashish.spring.boot.pojo.dto.ApiDetailDTOs;
import com.ashish.spring.boot.service.consumer.ConsumerApiService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ConsumerApiServiceImpl implements ConsumerApiService {
    @Autowired
    private ClientApiData apiData;

    @Override
    public ApiDetailDTOs fetchAllApiDetails() {
        Map<String, List<String>> apiActions= apiData.fetchAllApiDetails();
        ApiDetailDTOs apiDetailDTOs=new ApiDetailDTOs();
        apiDetailDTOs.setApis(new ArrayList<>());
        apiActions.forEach((k,v)->{
            if(!StringUtils.equalsIgnoreCase(k,"LFN") && !StringUtils.equalsIgnoreCase(k,"RFN")) {
                apiDetailDTOs.getApis().add(createAPIDto(v, k, apiActions));
            }
        });
        return apiDetailDTOs;
    }

    private ApiDTO createAPIDto(List<String> apidetails,String key,Map<String, List<String>> apiActions){
        ApiDTO apiDTO = new ApiDTO();
        apiDTO.setMethod(apidetails.get(0));
        apiDTO.setDescription(apidetails.get(1));
        apiDTO.setOperand(apidetails.get(2));
        apiDTO.setHasRequestPayload(StringUtils.equalsIgnoreCase(apidetails.get(3),"Y")?true:false);
        apiDTO.setHasResponse(StringUtils.equalsIgnoreCase(apidetails.get(4),"Y")?true:false);
        String url=apidetails.get(5);
        if(StringUtils.equalsIgnoreCase(key,"DSR")){
            url=url+"?ids=EMP001";
        }else if(StringUtils.equalsIgnoreCase(key,"DMR")){
            url=url+"?ids=EMP001,EMP002";
        }else if(StringUtils.equalsIgnoreCase(key,"RFC")){
            url=url+"?leftFileName="+apiActions.get("LFN").get(0)+"&rightFileName="+apiActions.get("RFN").get(0);
        }
        apiDTO.setServiceUrl(url);
        return apiDTO;
    }
}
