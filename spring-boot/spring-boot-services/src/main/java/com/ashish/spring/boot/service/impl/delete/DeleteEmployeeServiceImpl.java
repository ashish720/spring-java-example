package com.ashish.spring.boot.service.impl.delete;

import com.ashish.spring.boot.common.constant.EmployeeConstants;
import com.ashish.spring.boot.dao.impl.delete.EmployeeDataProvider;
import com.ashish.spring.boot.pojo.dto.EmployeeDTO;
import com.ashish.spring.boot.pojo.dto.EmployeeResponseDTO;
import com.ashish.spring.boot.pojo.dto.ErrorDTO;
import com.ashish.spring.boot.common.constant.BootHttpConstant;
import com.ashish.spring.boot.service.delete.DeleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeleteEmployeeServiceImpl implements DeleteService<EmployeeResponseDTO> {

    @Autowired
    private EmployeeDataProvider employeeDataProvider;

    @Override
    public EmployeeResponseDTO deleteListOfRecordById(List<Object> ids) {
        if(ids==null || ids.isEmpty()){
            return createErrorResponse(EmployeeConstants.EMPLOYEE_FAILED,new ErrorDTO(BootHttpConstant.INVALID_INPUT_ERROR_CODE,"not found proper input to delete employee records."));
        }
        EmployeeResponseDTO employeeDTOs = new EmployeeResponseDTO();
        employeeDTOs.setStatus(EmployeeConstants.EMPLOYEE_SUCCESS);
        employeeDTOs.setEmployees(new ArrayList<>());

        ids.forEach(id->{
            employeeDTOs.getEmployees().add(new EmployeeDTO((String)id));
        });
        employeeDTOs.setNoOfRecords(employeeDTOs.getEmployees().size());
        return employeeDataProvider.deleteListedData(EmployeeConstants.JSON_DATA_FILE_NAME,employeeDTOs);
    }

    @Override
    public EmployeeResponseDTO deleteSingleRecordById(Object id) {
        List<Object> ids = new ArrayList<>();
        ids.add(id);
        return deleteListOfRecordById(ids);
    }
}
