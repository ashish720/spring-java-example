package com.ashish.spring.boot.pojo.dto;

import java.util.List;

public class ApiDetailDTOs {

    List<ApiDTO> apis;

    public List<ApiDTO> getApis() {
        return apis;
    }

    public void setApis(List<ApiDTO> apis) {
        this.apis = apis;
    }
}
