package com.ashish.spring.boot.web.controller.mapper.impl.consumer;

import com.ashish.spring.boot.pojo.dto.ApiDTO;
import com.ashish.spring.boot.pojo.dto.ApiDetailDTOs;
import com.ashish.spring.boot.pojo.io.ApiDetailIOs;
import com.ashish.spring.boot.pojo.io.ApiIO;
import com.ashish.spring.boot.web.controller.mapper.iomapper.IOClassMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ConsumerApiMapperImpl implements IOClassMapper<ApiDetailIOs, ApiDetailDTOs> {
    @Override
    public ApiDetailIOs mapToJsonObject(ApiDetailDTOs input) {
        if(input==null || input.getApis()==null || input.getApis().isEmpty()){
            return null;
        }
        ApiDetailIOs apiDetailIOs=new ApiDetailIOs();
        apiDetailIOs.setApis(new ArrayList<>());
        input.getApis().forEach(apiDto->{
            apiDetailIOs.getApis().add(createApiIO(apiDto));
        });
        return apiDetailIOs;
    }
    
    private ApiIO createApiIO(ApiDTO apiDto){
            ApiIO apiIO=new ApiIO();
            apiIO.setMethod(apiDto.getMethod());
            apiIO.setDescription(apiDto.getDescription());
            apiIO.setOperand(apiDto.getOperand());
            apiIO.setHasRequestPayload(apiDto.isHasRequestPayload());
            apiIO.setHasResponse(apiDto.isHasResponse());
            apiIO.setServiceUrl(apiDto.getServiceUrl().replace("{id}","EMP001"));
        return apiIO;
    }
}
