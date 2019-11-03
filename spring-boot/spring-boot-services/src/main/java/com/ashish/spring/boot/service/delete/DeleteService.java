package com.ashish.spring.boot.service.delete;

import com.ashish.spring.boot.pojo.dto.EmployeeDTOs;
import com.ashish.spring.boot.pojo.dto.EmployeeResponseDTO;
import com.ashish.spring.boot.pojo.dto.ErrorDTO;
import com.ashish.spring.boot.pojo.io.EmployeeResponseIO;
import com.ashish.spring.boot.pojo.io.ErrorIO;

import java.util.List;

public interface DeleteService<O> {

    O deleteListOfRecordById(List<Object> ids);

    O deleteSingleRecordById(Object id);

    default EmployeeResponseDTO createErrorResponse(String status, ErrorDTO errorDTO){
        EmployeeResponseDTO employeeResponseDTO = new EmployeeResponseDTO();
        employeeResponseDTO.setStatus(status);
        employeeResponseDTO.setError(errorDTO);
        return employeeResponseDTO;
    }
}
