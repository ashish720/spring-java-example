package com.ashish.spring.boot.dp.apigateway.ms;

import com.ashish.spring.boot.common.properties.ApiGateWayProperties;
import com.ashish.spring.boot.pojo.dto.EndPointDTO;
import com.ashish.spring.boot.pojo.dto.OrderDetailsDTO;

import java.util.*;

public interface ApiGatewayMSService {

    default Map<String,EndPointDTO> fetchMappedEndPointDetails(ApiGateWayProperties apiGateWayProperties){
        Map<String, EndPointDTO> mappedEndpoint=new HashMap<>();
        apiGateWayProperties.getEndpoints().forEach(endpoint -> {
            if(endpoint.getPath().contains("/product/{productId}/information")){
                mappedEndpoint.put("prodInformation",endpoint);
            }else if(endpoint.getPath().contains("product/order/{orderId}")){
                mappedEndpoint.put("prodOrderInformation",endpoint);
            }
        });
        return mappedEndpoint;
    }
    OrderDetailsDTO getOrderedProductDetails(List<String> productInputs, List<String> orderedInputs);
}
