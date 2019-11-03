package com.ashish.spring.boot.web.controller.java8;

import com.ashish.spring.boot.pojo.io.LembdaAddIO;
import com.ashish.spring.boot.service.java8.Java8Features;
import com.ashish.spring.boot.service.java8.LembdaExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Java8FeaturesController {

    @Autowired
    private Java8Features java8Features;

    @GetMapping
    public LembdaAddIO addInteger(@RequestParam int a,@RequestParam int b){
        LembdaAddIO lembdaAddIO = new LembdaAddIO();
        lembdaAddIO.setA(a);
        lembdaAddIO.setB(b);
        lembdaAddIO.setSum(java8Features.addInteger(lembdaAddIO.getA(),lembdaAddIO.getB()));
        return lembdaAddIO;
    }
}
