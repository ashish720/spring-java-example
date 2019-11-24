package com.ashish.spring.boot.service.impl.java8;

import com.ashish.spring.boot.common.util.StreamUtils;
import com.ashish.spring.boot.pojo.dto.EmployeeDTO;
import com.ashish.spring.boot.pojo.dto.EmployeeResponseDTO;
import com.ashish.spring.boot.pojo.io.LembdaAddIO;
import com.ashish.spring.boot.service.java8.Java8Features;
import com.ashish.spring.boot.service.java8.LembdaExpression;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Java8FeaturesImpl implements Java8Features {

    @Override
    public int sum(LembdaAddIO lembdaAddIO) {
       LembdaExpression add = (int x,int y)->{ return lembdaAddIO.getA()+lembdaAddIO.getB();};
       return add.addInteger(lembdaAddIO.getA(),lembdaAddIO.getB());
    }

    @Override
    public void iterateUsingStream(List<EmployeeDTO> employeeList) {
        if(employeeList==null){
            return;
        }
        StreamUtils.forEachIteration(employeeList);
        StreamUtils.orderForEachIteration(employeeList);
    }

    @Override
    public void streamFilteration(String filterCrtiteria, String filterKey,EmployeeResponseDTO employeeResponseDTO) {
        if(filterCrtiteria==null
                || employeeResponseDTO==null
                || employeeResponseDTO.getEmployees()==null
                || employeeResponseDTO.getEmployees().isEmpty()){
            return;
        }
        StreamUtils.filterStreams(filterCrtiteria,filterKey,employeeResponseDTO);
    }
}
