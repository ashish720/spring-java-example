package com.ashish.spring.boot.dao.impl.data.feeder.employee;

import com.ashish.spring.boot.common.constant.EmployeeConstants;
import com.ashish.spring.boot.dao.data.DataProvider;
import com.ashish.spring.boot.pojo.dto.EmployeeDTO;
import com.ashish.spring.boot.pojo.dto.EmployeeDTOs;
import com.ashish.spring.boot.pojo.dto.EmployeeResponseDTO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class EmployeeFeedProvider implements DataProvider<EmployeeResponseDTO> {

    @Override
    public EmployeeResponseDTO fetchData(String fileName){
        return readFileStream(fileName, new EmployeeResponseDTO());
    }

    @Override
    public EmployeeResponseDTO deleteListedData(String fileName, EmployeeResponseDTO toDeleteEmployees) {
        EmployeeResponseDTO employeeDTOs = readFileStream(fileName,new EmployeeResponseDTO());
        if(employeeDTOs==null || employeeDTOs.getEmployees()==null || employeeDTOs.getEmployees().isEmpty()){
            employeeDTOs.setStatus("NF_400");
            return employeeDTOs;
        }

        EmployeeResponseDTO deletedEmployees=pouplateDeletedEmployees(employeeDTOs);

        employeeDTOs.getEmployees().forEach(item->{
          toDeleteEmployees.getEmployees().forEach(deleteEmployee->{
              if(StringUtils.equalsIgnoreCase(deleteEmployee.getId(),item.getId())){
                  deletedEmployees.getEmployees().remove(item);
              }
          });
        });
        deletedEmployees.setNoOfRecords(deletedEmployees.getEmployees().size());
        return deletedEmployees;
    }

    @Override
    public EmployeeResponseDTO deleteSingleData(String fileName, Object id) {
        EmployeeResponseDTO employeeDTOs = new EmployeeResponseDTO();
        employeeDTOs.setEmployees(new ArrayList<>());
        employeeDTOs.getEmployees().add(new EmployeeDTO((String)id));
        return deleteListedData(fileName,employeeDTOs);
    }

    private EmployeeResponseDTO pouplateDeletedEmployees(EmployeeResponseDTO employeeDTOs){
        EmployeeResponseDTO deletedEmployees=new EmployeeResponseDTO();
        deletedEmployees.setStatus(EmployeeConstants.EMPLOYEE_SUCCESS);
        deletedEmployees.setEmployees(new ArrayList<>());
        employeeDTOs.getEmployees().forEach(item->{
            deletedEmployees.getEmployees().add(item);
        });
        return deletedEmployees;
    }
}
