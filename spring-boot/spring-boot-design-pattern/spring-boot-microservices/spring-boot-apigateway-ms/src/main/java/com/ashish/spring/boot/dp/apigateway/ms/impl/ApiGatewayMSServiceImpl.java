package com.ashish.spring.boot.dp.apigateway.ms.impl;

import com.ashish.spring.boot.dp.apigateway.ms.ApiGatewayMSService;
import com.ashish.spring.boot.common.helper.UrlHelper;
import com.ashish.spring.boot.common.jsonmapper.JsonToObject;
import com.ashish.spring.boot.common.jsonmapper.util.MapperUtils;
import com.ashish.spring.boot.common.properties.ApiGateWayProperties;
import com.ashish.spring.boot.pojo.dto.EndPointDTO;
import com.ashish.spring.boot.pojo.dto.OrderDetailsDTO;
import com.ashish.spring.boot.service.http.HttpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ApiGatewayMSServiceImpl implements ApiGatewayMSService,JsonToObject<OrderDetailsDTO,String> {

    @Autowired
    private HttpService httpService;
    @Autowired
    private ApiGateWayProperties apiGateWayProperties;

    @Override
    public OrderDetailsDTO getOrderedProductDetails(List<String> productInputs, List<String> orderedInputs) {
        EndPointDTO endPointDTO = fetchMappedEndPointDetails(apiGateWayProperties).get("productInformation");
        if(endPointDTO==null){
            return null;
        }
        List<String> placeHolderListInUrl=UrlHelper.fetchAllPlaceholder(endPointDTO.getLocation(),"{","}");
        if(placeHolderListInUrl.size()==0 || placeHolderListInUrl.size()!= productInputs.size()){
            return null;
        }
        Map<String,String> inputParamMap = new HashMap<>();
        int i=0;
        for(String productId: productInputs){
            inputParamMap.put(placeHolderListInUrl.get(i),productId);
            i++;
        }
        String url=UrlHelper.prepareUrl(inputParamMap,placeHolderListInUrl,endPointDTO.getLocation(),"{","}");
        ResponseEntity<String> response = httpService.invokeRestApi(url,null,null, HttpMethod.GET);
        OrderDetailsDTO orderDetailsDTO =null;
        if(response!=null && response.getBody()!=null && response.getBody().contains("error")){
            orderDetailsDTO = responseBodyToObject(response.getBody());
        }
        return orderDetailsDTO;
    }

    @Override
    public OrderDetailsDTO responseBodyToObject(String input) {
        try {
            return (OrderDetailsDTO)MapperUtils.jsonToObject(input,new OrderDetailsDTO());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
