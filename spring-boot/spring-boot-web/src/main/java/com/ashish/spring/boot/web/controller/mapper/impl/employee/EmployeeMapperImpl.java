package com.ashish.spring.boot.web.controller.mapper.impl.employee;

import com.ashish.spring.boot.common.constant.EmployeeConstants;
import com.ashish.spring.boot.pojo.dto.EmployeeDTO;
import com.ashish.spring.boot.pojo.io.EmployeeResponseIO;
import com.ashish.spring.boot.pojo.dto.EmployeeResponseDTO;
import com.ashish.spring.boot.pojo.io.EmployeeIO;
import com.ashish.spring.boot.web.controller.mapper.iomapper.IOClassMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class EmployeeMapperImpl implements IOClassMapper<EmployeeResponseIO, EmployeeResponseDTO> {

    @Override
    public EmployeeResponseIO mapToJsonObject(EmployeeResponseDTO input) {
        if(input==null || input.getEmployees()==null || input.getEmployees().isEmpty()){
            return (EmployeeResponseIO)createEmpErrorResponse(EmployeeConstants.EMPLOYEE_FAILED, input.getError());
        }
        EmployeeResponseIO employeeResponseIO = new EmployeeResponseIO();
        employeeResponseIO.setStatus("SUCCESS");
        employeeResponseIO.setEmployees(new ArrayList<>());
        input.getEmployees().forEach(item->{
            employeeResponseIO.getEmployees().add(createEmployee(item));
        });
        employeeResponseIO.setNoOfRecords(employeeResponseIO.getEmployees().size());
        return employeeResponseIO;
    }

    private EmployeeIO createEmployee(EmployeeDTO employeeDTO){

        EmployeeIO employeeIO=new EmployeeIO();
        employeeIO.setId(employeeDTO.getId());
        employeeIO.setName(employeeDTO.getName());
        employeeIO.setType(employeeDTO.getType());
        employeeIO.setAddress(employeeDTO.getAddress());
        employeeIO.setComment(employeeDTO.getAddress());
        employeeIO.setContact(employeeDTO.getContact());
        return employeeIO;
    }

}
