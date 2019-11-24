package com.ashish.spring.boot.service.impl.consumer;

import com.ashish.spring.boot.common.constant.EmployeeConstants;
import com.ashish.spring.boot.common.jsonmapper.JsonToObject;
import com.ashish.spring.boot.common.properties.ClientApiData;
import com.ashish.spring.boot.common.properties.ProducerApiData;
import com.ashish.spring.boot.common.util.RequestUtils;
import com.ashish.spring.boot.pojo.dto.EmployeeResponseDTO;
import com.ashish.spring.boot.common.constant.BootHttpConstant;
import com.ashish.spring.boot.service.consumer.EmployeeService;
import com.ashish.spring.boot.service.http.HttpService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService, JsonToObject<EmployeeResponseDTO,String> {

    @Autowired
    private HttpService httpService;
    @Autowired
    private ProducerApiData producerApiData;


    @Override
    public EmployeeResponseDTO invokeDeleteSingleRecord(String ids, Map<String, String> headerMap) {
        ResponseEntity<String> result=httpService.invokeRestApi(producerApiData.getSingleDeleteRecordUrl().replace("{id}",ids),null,headerMap, HttpMethod.DELETE);
        if(result==null || result.getBody()==null || result.getStatusCodeValue()!=200){
            return null;
        }
        return responseBodyToObject(result.getBody());
    }

    @Override
    public EmployeeResponseDTO invokeDeleteMultipleRecord(String jsonBody, Map<String, String> headerMap) {
        ResponseEntity<String> result=httpService.invokeRestApi(producerApiData.getMultipleDeleteRecordUrl(),jsonBody,headerMap, HttpMethod.DELETE);
        return responseBodyToObject(result.getBody());
    }

    @Override
    public EmployeeResponseDTO fetchAllEmployees() {
        ResponseEntity<String> result = httpService.invokeRestApi(producerApiData.getFetchAllEmployeeUrl(),null, RequestUtils.addJsonMediaInHeader(),HttpMethod.GET);
        return responseBodyToObject(result.getBody());
    }

    @Override
    public EmployeeResponseDTO responseBodyToObject(String input) {
        ObjectMapper objectMapper = new ObjectMapper();
        EmployeeResponseDTO employeeResponseDTO=null;
        try{
            employeeResponseDTO=objectMapper.readValue(input, EmployeeResponseDTO.class);
            employeeResponseDTO.setStatus(EmployeeConstants.EMPLOYEE_SUCCESS);
        } catch (JsonParseException e) {
            employeeResponseDTO=createErrorResponse(EmployeeConstants.EMPLOYEE_FAILED, BootHttpConstant.JSON_PARSE_ERROR_CODE,"exception message ::"+e.getMessage()+":: error occurred while parsing data");
            e.printStackTrace();
        } catch (JsonMappingException e) {
            employeeResponseDTO=createErrorResponse(EmployeeConstants.EMPLOYEE_FAILED,BootHttpConstant.JSON_MAPPING_ERROR_CODE,"exception message ::"+e.getMessage()+":: error occurred while parsing data");
            e.printStackTrace();
        } catch (IOException e) {
            employeeResponseDTO=createErrorResponse(EmployeeConstants.EMPLOYEE_FAILED,BootHttpConstant.CONNECTION_ERROR_CODE,"exception message ::"+e.getMessage()+":: error occurred while parsing data");
            e.printStackTrace();
        }
        return employeeResponseDTO;
    }
}
