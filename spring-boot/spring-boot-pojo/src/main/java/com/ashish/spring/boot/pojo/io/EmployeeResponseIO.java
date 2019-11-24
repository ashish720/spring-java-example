package com.ashish.spring.boot.pojo.io;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EmployeeResponseIO extends EmployeeStatusIO {
    private List<EmployeeIO> employees;

    public List<EmployeeIO> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeIO> employees) {
        this.employees = employees;
    }
}
