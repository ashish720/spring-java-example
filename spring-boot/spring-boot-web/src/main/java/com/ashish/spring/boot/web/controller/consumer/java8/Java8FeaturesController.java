package com.ashish.spring.boot.web.controller.consumer.java8;

import com.ashish.spring.boot.common.constant.SpringBootConstant;
import com.ashish.spring.boot.common.jsonmapper.ObjectToJsonMap;
import com.ashish.spring.boot.pojo.dto.EmployeeResponseDTO;
import com.ashish.spring.boot.pojo.io.EmployeeGroupByTypeIO;
import com.ashish.spring.boot.pojo.io.EmployeeResponseIO;
import com.ashish.spring.boot.pojo.io.LembdaAddIO;
import com.ashish.spring.boot.service.consumer.EmployeeService;
import com.ashish.spring.boot.service.java8.Java8Features;
import com.ashish.spring.boot.web.controller.constant.BootWebConstant;
import com.ashish.spring.boot.web.controller.mapper.iomapper.IOClassMapper;
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
    @Qualifier("employeeMapperImpl")
    private IOClassMapper employeeMapper;
    @Autowired
    @Qualifier("employeeGroupMapperImpl")
    private IOClassMapper employeeGroupMapper;
    @Autowired
    @Qualifier("employeeIdsToStringJson")
    private ObjectToJsonMap objectToJsonMap;

/*    @GetMapping
    public LembdaAddIO addInteger(@RequestParam int a,@RequestParam int b){
        LembdaAddIO lembdaAddIO = new LembdaAddIO();
        lembdaAddIO.setA(a);
        lembdaAddIO.setB(b);
        lembdaAddIO.setSum(java8Features.sum(lembdaAddIO));
        return lembdaAddIO;
    }*/
    @GetMapping(BootWebConstant.FILTER_EMP_NAME_START_URL)
    public EmployeeResponseIO fetchAllEmployeeByName(@RequestParam String nameStartsWith){
        EmployeeResponseDTO employeeResponseDTO=employeeService.fetchAllEmployees();
        java8Features.streamFilteration(SpringBootConstant.FILTER_BY_NAME,nameStartsWith,employeeResponseDTO);
        return (EmployeeResponseIO)employeeMapper.mapToJsonObject(employeeResponseDTO);
    }

    @GetMapping(BootWebConstant.FILTER_EMP_BY_GROUP_URL)
    public EmployeeGroupByTypeIO fetchAllEmployeeByGroup(){
        EmployeeResponseDTO employeeResponseDTO=employeeService.fetchAllEmployees();
        java8Features.streamFilteration(SpringBootConstant.FILTER_BY_GROUP,null,employeeResponseDTO);
        return (EmployeeGroupByTypeIO) employeeGroupMapper.mapToJsonObject(employeeResponseDTO);
    }
}
