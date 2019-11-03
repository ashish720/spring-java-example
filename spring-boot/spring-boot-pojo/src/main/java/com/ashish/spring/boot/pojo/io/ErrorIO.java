package com.ashish.spring.boot.pojo.io;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorIO {
    private String code;
    private String message;

    public ErrorIO() {
    }

    public ErrorIO(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
