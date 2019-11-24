package com.ashish.spring.boot.common.helper;

import com.ashish.spring.boot.common.enums.EmployeeTypeEnums;
import com.ashish.spring.boot.pojo.dto.EmployeeDTO;
import com.ashish.spring.boot.pojo.dto.EmployeeResponseDTO;

public class StreamFilterHelper {
    public static boolean filterByName(String searchKey, String name){
        return name!=null && name.startsWith(searchKey);
    }
    public static boolean isMatchedByType(String type){
        return EmployeeTypeEnums.enumType(type)!=null;
    }
    public static EmployeeResponseDTO mapToGroupType(EmployeeResponseDTO employeeResponseDTO, EmployeeDTO employeeDTO){
        switch (EmployeeTypeEnums.enumType(employeeDTO.getType())){
            case PERMANENT:
                employeeResponseDTO.getPermanents().add(employeeDTO);
                break;
            case PROVISIONAL:
                employeeResponseDTO.getProvisionals().add(employeeDTO);
                break;
            default:
                break;
        }
        return employeeResponseDTO;
    }

}
