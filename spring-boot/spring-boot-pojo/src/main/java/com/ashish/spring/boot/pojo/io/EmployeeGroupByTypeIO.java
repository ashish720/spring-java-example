package com.ashish.spring.boot.pojo.io;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EmployeeGroupByTypeIO extends EmployeeStatusIO{
    private List<EmployeeIO> permanents;
    private List<EmployeeIO> provisionals;

    public List<EmployeeIO> getPermanents() {
        if(this.permanents==null){
            this.permanents=new ArrayList<>();
        }
        return permanents;
    }
    public List<EmployeeIO> getProvisionals() {
        if(this.provisionals==null){
            this.provisionals=new ArrayList<>();
        }
        return provisionals;
    }
}
