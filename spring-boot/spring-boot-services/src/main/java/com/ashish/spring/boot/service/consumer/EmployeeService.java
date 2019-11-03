package com.ashish.spring.boot.service.consumer;

import com.ashish.spring.boot.pojo.dto.EmployeeResponseDTO;
import com.ashish.spring.boot.pojo.dto.ErrorDTO;

import java.util.Map;

public interface EmployeeService {

    EmployeeResponseDTO invokeDeleteSingleRecord(String ids, Map<String, String> headerMap);

    EmployeeResponseDTO invokeDeleteMultipleRecord(String jsonBody, Map<String, String> headerMap);

    default EmployeeResponseDTO createErrorResponse(String status, String code, String message){
        EmployeeResponseDTO employeeResponseDTO = new EmployeeResponseDTO();
        employeeResponseDTO.setStatus(status);
        employeeResponseDTO.setError(new ErrorDTO(code,message));
        return employeeResponseDTO;
    }
}
