package com.ashish.spring.boot.service.java8;

import com.ashish.spring.boot.pojo.dto.EmployeeDTO;
import com.ashish.spring.boot.pojo.io.LembdaAddIO;

import java.util.List;

public interface Java8Features {
    int sum(LembdaAddIO lembdaAddIO);
    void iterateUsingStream(List<EmployeeDTO> employeeList);
}
