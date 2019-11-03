package com.ashish.spring.boot.web.controller.producer;

import com.ashish.spring.boot.pojo.dto.EmployeeDTOs;
import com.ashish.spring.boot.pojo.dto.EmployeeResponseDTO;
import com.ashish.spring.boot.pojo.io.EmployeeResponseIO;
import com.ashish.spring.boot.service.get.GetService;
import com.ashish.spring.boot.web.controller.constant.BootWebConstant;
import com.ashish.spring.boot.web.controller.mapper.iomapper.IOClassMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetProducerController {

    @Autowired
    @Qualifier("getEmployeeServiceImpl")
    private GetService getService;

    @Autowired
    @Qualifier("employeeMapperImpl")
    private IOClassMapper employeeMapper;

    @GetMapping(BootWebConstant.BOOT_CONSUMER_API+"/fetch/user/details")
    public EmployeeResponseIO fetchAllEmployee(){
        EmployeeResponseDTO employeeResponseDTO=(EmployeeResponseDTO)getService.fetchAllRecords();
        employeeResponseDTO.setNoOfRecords(employeeResponseDTO.getEmployees().size());
        return (EmployeeResponseIO) employeeMapper.mapToJsonObject(employeeResponseDTO);
    }
}
