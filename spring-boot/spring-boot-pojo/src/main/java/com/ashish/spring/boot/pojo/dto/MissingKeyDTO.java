package com.ashish.spring.boot.pojo.dto;

public class MissingKeyDTO {

    private String missingKey;

    public MissingKeyDTO() {
    }

    public MissingKeyDTO(String missingKey) {
        this.missingKey = missingKey;
    }

    public void setMissingKey(String missingKey) {
        this.missingKey = missingKey;
    }

    public String getMissingKey() {
        return missingKey;
    }
}
