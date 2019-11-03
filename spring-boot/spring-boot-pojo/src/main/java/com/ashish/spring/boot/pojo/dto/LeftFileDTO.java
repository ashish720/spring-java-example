package com.ashish.spring.boot.pojo.dto;

import java.util.List;

public class LeftFileDTO {

    private String fileName;
    private List<MissingKeyDTO> keyMissingInLeft;

    public LeftFileDTO() {
    }

    public LeftFileDTO(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public List<MissingKeyDTO> getKeyMissingInLeft() {
        return keyMissingInLeft;
    }

    public void setKeyMissingInLeft(List<MissingKeyDTO> keyMissingInLeft) {
        this.keyMissingInLeft = keyMissingInLeft;
    }
}
