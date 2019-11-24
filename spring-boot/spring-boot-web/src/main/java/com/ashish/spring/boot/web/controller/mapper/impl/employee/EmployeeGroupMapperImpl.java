package com.ashish.spring.boot.web.controller.mapper.impl.employee;

import com.ashish.spring.boot.common.constant.EmployeeConstants;
import com.ashish.spring.boot.pojo.dto.EmployeeDTO;
import com.ashish.spring.boot.pojo.dto.EmployeeResponseDTO;
import com.ashish.spring.boot.pojo.io.EmployeeGroupByTypeIO;
import com.ashish.spring.boot.pojo.io.EmployeeIO;
import com.ashish.spring.boot.web.controller.mapper.iomapper.IOClassMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeGroupMapperImpl implements IOClassMapper<EmployeeGroupByTypeIO, EmployeeResponseDTO> {

    @Override
    public EmployeeGroupByTypeIO mapToJsonObject(EmployeeResponseDTO input) {
        if(input==null){
            return (EmployeeGroupByTypeIO) createEmpErrorResponse(EmployeeConstants.EMPLOYEE_FAILED, input.getError());
        }
        EmployeeGroupByTypeIO employeeGroupByTypeIO=new EmployeeGroupByTypeIO();
        employeeGroupByTypeIO.setStatus("SUCCESS");
        employeeGroupByTypeIO.setNoOfRecords(input.getEmployees().size());
        if (input.getProvisionals()!=null){
            input.getProvisionals().stream().forEach(employeeDTO -> populateProvisional(employeeDTO,employeeGroupByTypeIO));
        }
        if (input.getPermanents()!=null){
            input.getPermanents().stream().forEach(employeeDTO -> populatePermanents(employeeDTO,employeeGroupByTypeIO));
        }
        return employeeGroupByTypeIO;
    }
    private EmployeeGroupByTypeIO populateProvisional(EmployeeDTO employeeDTO,EmployeeGroupByTypeIO employeeGroupByTypeIO){
        EmployeeIO employeeIO = populateEmployeeIO(employeeDTO);
        employeeGroupByTypeIO.getProvisionals().add(employeeIO);
        return employeeGroupByTypeIO;
    }
    private EmployeeGroupByTypeIO populatePermanents(EmployeeDTO employeeDTO,EmployeeGroupByTypeIO employeeGroupByTypeIO){
        EmployeeIO employeeIO = populateEmployeeIO(employeeDTO);
        employeeGroupByTypeIO.getPermanents().add(employeeIO);
        return employeeGroupByTypeIO;
    }
    private EmployeeIO populateEmployeeIO(EmployeeDTO employeeDTO) {
        EmployeeIO employeeIO=new EmployeeIO();
        employeeIO.setAddress(employeeDTO.getAddress());
        employeeIO.setComment(employeeDTO.getComment());
        employeeIO.setContact(employeeDTO.getContact());
        employeeIO.setId(employeeDTO.getId());
        employeeIO.setName(employeeDTO.getName());
        employeeIO.setType(employeeDTO.getType());
        return employeeIO;
    }
}
