package com.ashish.spring.boot.pojo.io;

public class ApiIO {
    private String method;
    private String description;
    private String operand;
    private String serviceUrl;
    private boolean hasRequestPayload;
    private boolean hasResponse;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOperand() {
        return operand;
    }

    public void setOperand(String operand) {
        this.operand = operand;
    }

    public String getServiceUrl() {
        return serviceUrl;
    }

    public void setServiceUrl(String serviceUrl) {
        this.serviceUrl = serviceUrl;
    }

    public boolean isHasRequestPayload() {
        return hasRequestPayload;
    }

    public void setHasRequestPayload(boolean hasRequestPayload) {
        this.hasRequestPayload = hasRequestPayload;
    }

    public boolean isHasResponse() {
        return hasResponse;
    }

    public void setHasResponse(boolean hasResponse) {
        this.hasResponse = hasResponse;
    }
}
