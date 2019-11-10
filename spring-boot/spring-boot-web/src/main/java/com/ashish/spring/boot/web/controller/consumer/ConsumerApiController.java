package com.ashish.spring.boot.web.controller.consumer;

import com.ashish.spring.boot.common.jsonmapper.ObjectToJsonMap;
import com.ashish.spring.boot.common.util.RequestUtils;
import com.ashish.spring.boot.pojo.dto.ApiDetailDTOs;
import com.ashish.spring.boot.pojo.dto.EmployeeResponseDTO;
import com.ashish.spring.boot.pojo.io.ApiDetailIOs;
import com.ashish.spring.boot.pojo.io.EmployeeResponseIO;
import com.ashish.spring.boot.service.consumer.ConsumerApiService;
import com.ashish.spring.boot.service.consumer.EmployeeService;
import com.ashish.spring.boot.service.http.HttpService;
import com.ashish.spring.boot.service.util.EmployeeApiUtils;
import com.ashish.spring.boot.web.controller.constant.BootWebConstant;
import com.ashish.spring.boot.web.controller.mapper.iomapper.IOClassMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ConsumerApiController {

    @Autowired
    private ConsumerApiService consumerApiService;
    @Autowired
    @Qualifier("employeeIdsToStringJson")
    private ObjectToJsonMap objectToJsonMap;
    @Autowired
    @Qualifier("consumerApiMapperImpl")
    private IOClassMapper consumerApiMapper;
    @Autowired
    @Qualifier("employeeMapperImpl")
    private IOClassMapper employeeMapper;
    @Autowired
    @Qualifier("httpResponseServiceImpl")
    private HttpService httpService;
    @Autowired
    private EmployeeService employeeService;

    @GetMapping(BootWebConstant.GET_AVAILABLE_DELETE_APIS)
    public ApiDetailIOs fetchAvailableAPIs(){
        ApiDetailDTOs apiDetailDTOs = consumerApiService.fetchAllApiDetails();
        return (ApiDetailIOs)consumerApiMapper.mapToJsonObject(apiDetailDTOs);
    }
    @GetMapping(value = {BootWebConstant.GET_DELETE_SINGLE_RECORD,BootWebConstant.GET_DELETE_MULTIPLE_RECORD})
    public EmployeeResponseIO invokeDeleteRecords(@RequestParam(value = "ids") String deleteIds){
        EmployeeResponseDTO employeeResponseDTO=null;
        if(deleteIds.split(",").length>1){
            String jsonBody = (String)objectToJsonMap.convertObjectToJson(EmployeeApiUtils.createEmployeeRequest(deleteIds));
            employeeResponseDTO=employeeService.invokeDeleteMultipleRecord(jsonBody, RequestUtils.addJsonMediaInHeader());
        }else{
            employeeResponseDTO=employeeService.invokeDeleteSingleRecord(deleteIds, RequestUtils.addJsonMediaInHeader());
        }
        return (EmployeeResponseIO)employeeMapper.mapToJsonObject(employeeResponseDTO);
    }
}
