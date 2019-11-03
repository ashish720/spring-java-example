package com.ashish.spring.boot.pojo.io;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EmployeeResponseIO {
    private String status;
    private int noOfRecords;
    private ErrorIO error;
    private List<EmployeeIO> employees;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getNoOfRecords() {
        return noOfRecords;
    }

    public void setNoOfRecords(int noOfRecords) {
        this.noOfRecords = noOfRecords;
    }

    public ErrorIO getError() {
        return error;
    }

    public void setError(ErrorIO error) {
        this.error = error;
    }

    public List<EmployeeIO> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeIO> employees) {
        this.employees = employees;
    }
}
