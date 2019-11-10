package com.ashish.spring.boot.web.controller.java8;

import com.ashish.spring.boot.common.jsonmapper.ObjectToJsonMap;
import com.ashish.spring.boot.common.util.RequestUtils;
import com.ashish.spring.boot.pojo.dto.EmployeeResponseDTO;
import com.ashish.spring.boot.pojo.io.EmployeeResponseIO;
import com.ashish.spring.boot.pojo.io.LembdaAddIO;
import com.ashish.spring.boot.service.consumer.EmployeeService;
import com.ashish.spring.boot.service.java8.Java8Features;
import com.ashish.spring.boot.service.util.EmployeeApiUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Java8FeaturesController {

    @Autowired
    private Java8Features java8Features;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    @Qualifier("employeeIdsToStringJson")
    private ObjectToJsonMap objectToJsonMap;

    @GetMapping
    public LembdaAddIO addInteger(@RequestParam int a,@RequestParam int b){
        LembdaAddIO lembdaAddIO = new LembdaAddIO();
        lembdaAddIO.setA(a);
        lembdaAddIO.setB(b);
        lembdaAddIO.setSum(java8Features.sum(lembdaAddIO));
        return lembdaAddIO;
    }
    @GetMapping
    public EmployeeResponseIO fetchEmployeeData(@RequestParam(value = "ids") String ids){
        String jsonBody = (String)objectToJsonMap.convertObjectToJson(EmployeeApiUtils.createEmployeeRequest(ids));
        EmployeeResponseDTO employeeResponseDTO=employeeService.invokeDeleteMultipleRecord(ids, RequestUtils.addJsonMediaInHeader());
        return null;
    }
}
