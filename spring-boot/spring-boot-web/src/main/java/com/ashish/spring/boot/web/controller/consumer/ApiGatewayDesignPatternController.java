package com.ashish.spring.boot.web.controller.consumer;

import com.ashish.spring.boot.apigateway.ms.ApiGatewayMSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
public class ApiGatewayDesignPatternController {

    @Autowired
    private ApiGatewayMSService apiGatewayMSService;
    // TODO :: need to check the implementation
    @GetMapping("/product/{productId}/{orderId}")
    public void fetchOrderedProductDetails(@PathVariable String productId,@PathVariable String orderId){
        apiGatewayMSService.getOrderedProductDetails(Arrays.asList(productId.split(",")), null);
    }

}
