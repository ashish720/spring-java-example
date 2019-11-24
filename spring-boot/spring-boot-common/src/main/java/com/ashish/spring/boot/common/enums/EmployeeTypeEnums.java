package com.ashish.spring.boot.common.enums;

import com.ashish.spring.boot.pojo.dto.EmployeeDTO;
import com.ashish.spring.boot.pojo.dto.EmployeeResponseDTO;
import org.apache.commons.lang3.StringUtils;

public enum EmployeeTypeEnums {
    PERMANENT("Permanent"),
    PROVISIONAL("Provisional");

    private String type;

    EmployeeTypeEnums(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
    public static EmployeeTypeEnums enumType(String type){
        EmployeeTypeEnums employeeTypeEnums;
        try{
            employeeTypeEnums=EmployeeTypeEnums.valueOf(StringUtils.upperCase(type));
        }catch (IllegalArgumentException iExc){
            employeeTypeEnums=null;
        }
        return employeeTypeEnums;
    }
    public static EmployeeResponseDTO mapToGroup(EmployeeResponseDTO employeeResponseDTO,EmployeeDTO employeeDTO){
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
