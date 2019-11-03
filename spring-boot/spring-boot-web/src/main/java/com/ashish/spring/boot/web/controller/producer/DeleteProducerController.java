package com.ashish.spring.boot.web.controller.producer;

import com.ashish.spring.boot.pojo.dto.EmployeeDTOs;
import com.ashish.spring.boot.pojo.io.EmployeeIds;
import com.ashish.spring.boot.pojo.dto.EmployeeResponseDTO;
import com.ashish.spring.boot.pojo.io.EmployeeResponseIO;
import com.ashish.spring.boot.service.delete.DeleteService;
import com.ashish.spring.boot.web.controller.constant.BootWebConstant;
import com.ashish.spring.boot.web.controller.mapper.iomapper.IOClassMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DeleteProducerController {

    @Autowired
    @Qualifier("deleteEmployeeServiceImpl")
    private DeleteService deleteService;

    @Autowired
    @Qualifier("employeeMapperImpl")
    private IOClassMapper ioClassMapper;

    @DeleteMapping(BootWebConstant.BOOT_PRODUCER_API+"/delete/single/{id}/record")
    public EmployeeResponseIO deleteSingleRecord(@PathVariable String id){
        EmployeeResponseDTO employeeDTOs = (EmployeeResponseDTO)deleteService.deleteSingleRecordById(id);
        return (EmployeeResponseIO)ioClassMapper.mapToJsonObject(employeeDTOs);
    }

    @DeleteMapping(BootWebConstant.BOOT_PRODUCER_API+"/delete/multiple/records")
    public EmployeeResponseIO deleteMultipleRecord(@RequestBody EmployeeIds ids){
        List<Object> deleteRecordList = new ArrayList<>();
        deleteRecordList.addAll(ids.getIds());
        EmployeeResponseDTO employeeDTOs = (EmployeeResponseDTO)deleteService.deleteListOfRecordById(deleteRecordList);
        return (EmployeeResponseIO)ioClassMapper.mapToJsonObject(employeeDTOs);
    }
}
