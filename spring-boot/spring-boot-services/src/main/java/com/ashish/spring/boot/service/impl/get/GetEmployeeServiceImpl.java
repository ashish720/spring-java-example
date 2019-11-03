package com.ashish.spring.boot.service.impl.get;

import com.ashish.spring.boot.common.constant.EmployeeConstants;
import com.ashish.spring.boot.dao.data.DataProvider;
import com.ashish.spring.boot.dao.impl.delete.EmployeeDataProvider;
import com.ashish.spring.boot.pojo.dto.EmployeeDTOs;
import com.ashish.spring.boot.pojo.dto.EmployeeResponseDTO;
import com.ashish.spring.boot.service.get.GetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class GetEmployeeServiceImpl implements GetService<EmployeeResponseDTO> {

    @Autowired
    @Qualifier("employeeDataProvider")
    private EmployeeDataProvider employeeDataProvider;

    @Override
    public EmployeeResponseDTO fetchAllRecords() {
        return employeeDataProvider.fetchData(EmployeeConstants.JSON_DATA_FILE_NAME);
    }
}
