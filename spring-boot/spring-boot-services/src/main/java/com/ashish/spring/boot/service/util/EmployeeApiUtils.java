package com.ashish.spring.boot.service.util;

import com.ashish.spring.boot.pojo.io.EmployeeIds;

import java.util.ArrayList;

public class EmployeeApiUtils {

    public static EmployeeIds createEmployeeRequest(String deleteId){
        String[] deleteIds = deleteId.split(",");
        EmployeeIds employeeIds = new EmployeeIds();
        employeeIds.setIds(new ArrayList<>());
        for (String id : deleteIds) {
            employeeIds.getIds().add(id);
        }
        return employeeIds;
    }
}
