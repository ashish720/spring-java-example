package com.ashish.spring.boot.web.controller.mapper.iomapper;


import com.ashish.spring.boot.pojo.dto.ErrorDTO;
import com.ashish.spring.boot.pojo.io.EmployeeResponseIO;
import com.ashish.spring.boot.pojo.io.EmployeeStatusIO;
import com.ashish.spring.boot.pojo.io.ErrorIO;
import com.ashish.spring.boot.pojo.io.FileCompareIO;

public interface IOClassMapper<O,I> {

    O mapToJsonObject(I input);

    default EmployeeStatusIO createEmpErrorResponse(String status, ErrorDTO errorDTO){
        EmployeeStatusIO employeeResponseDTO = new EmployeeStatusIO();
        employeeResponseDTO.setStatus(status);
        employeeResponseDTO.setError(new ErrorIO(errorDTO.getCode(),errorDTO.getMessage()));
        return employeeResponseDTO;
    }
    default FileCompareIO createFileErrorResponse(String status, ErrorDTO errorDTO){
        FileCompareIO fileCompareIO = new FileCompareIO();
        fileCompareIO.setStatus(status);
        fileCompareIO.setError(new ErrorIO(errorDTO.getCode(),errorDTO.getMessage()));
        return fileCompareIO;
    }

}
