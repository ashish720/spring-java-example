package com.ashish.spring.boot.pojo.io;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EmployeeStatusIO  {
    private String status;
    private int noOfRecords;
    private ErrorIO error;

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
}
