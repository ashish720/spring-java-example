package com.ashish.spring.boot.common.properties;

import com.ashish.spring.boot.pojo.dto.EndPointDTO;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties(prefix = "api.gateway")
public class ApiGateWayProperties {
    private List<EndPointDTO> endpoints;

    public List<EndPointDTO> getEndpoints() {
        return endpoints;
    }

    public void setEndpoints(List<EndPointDTO> endpoints) {
        this.endpoints = endpoints;
    }
}
