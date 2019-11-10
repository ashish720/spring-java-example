package com.ashish.spring.boot.common.util;

import com.ashish.spring.boot.pojo.dto.EmployeeDTO;

import java.util.List;

public final class StreamUtils {
    private StreamUtils() {
    }
    public static void forEachIteration(List<EmployeeDTO> employeeDTOS){
        employeeDTOS.stream().forEach(employeeDTO -> {
            System.out.println(" Name :: "+employeeDTO.getName());
        });
    }

    public static void orderForEachIteration(List<EmployeeDTO> employeeDTOS){

        employeeDTOS.stream().forEachOrdered(employeeDTO -> {
            System.out.println(" Name :: "+employeeDTO.getName());
        });
    }
}
