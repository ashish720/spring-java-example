package com.ashish.spring.boot.common.util;

import com.ashish.spring.boot.common.constant.SpringBootConstant;
import com.ashish.spring.boot.common.helper.StreamFilterHelper;
import com.ashish.spring.boot.pojo.dto.EmployeeDTO;
import com.ashish.spring.boot.pojo.dto.EmployeeResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

public final class StreamUtils {
    private StreamUtils() {
    }
    public static void forEachIteration(List<EmployeeDTO> employeeDTOS){
        employeeDTOS.stream().forEach(employeeDTO -> {
            System.out.println(" Name :: "+employeeDTO.getName());
        });
    }

    /**
     * It will store the element in which ordered it's pushed into the list.
     * @param employeeDTOS
     */
    public static void orderForEachIteration(List<EmployeeDTO> employeeDTOS){

        employeeDTOS.stream().forEachOrdered(employeeDTO -> {
            System.out.println(" Name :: "+employeeDTO.getName());
        });
    }

    /**
     * API will explain the functionality of filter() of stream and as well as collect()
     * @param filterCriteria
     * @param filterCharacter
     * @param employeeResponseDTO
     */
    public static void filterStreams(String filterCriteria,String filterCharacter, EmployeeResponseDTO employeeResponseDTO){
        switch (filterCriteria) {
            case SpringBootConstant.FILTER_BY_NAME:
                List<EmployeeDTO> filteredByNameFirstLetters = employeeResponseDTO.getEmployees().stream().
                    filter(employeeDTO -> StreamFilterHelper.filterByName(filterCharacter, employeeDTO.getName())).
                    collect(Collectors.toList());
                employeeResponseDTO.setEmployees(filteredByNameFirstLetters);
                break;
            case SpringBootConstant.FILTER_BY_GROUP:
                employeeResponseDTO.getEmployees().stream().
                        forEach(employeeDTO -> StreamFilterHelper.mapToGroupType(employeeResponseDTO,employeeDTO));
                break;
        }
    }
}
