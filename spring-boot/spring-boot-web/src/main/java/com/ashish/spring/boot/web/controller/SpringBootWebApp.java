package com.ashish.spring.boot.web.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {
        "com.ashish.spring.boot.common",
        "com.ashish.spring.boot.dao",
        "com.ashish.spring.boot.service",
        "com.ashish.spring.boot.web",
        "com.ashish.spring.boot.apigateway.ms"
        })
public class SpringBootWebApp extends SpringBootServletInitializer {

    public static void main(String[] args){
        SpringApplication.run(SpringBootWebApp.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(SpringBootWebApp.class);
    }
}
