package com.ashish.spring.boot.pojo.dto;

import java.util.List;

public class RightFileDTO {

    private String fileName;
    private List<MissingKeyDTO> keyMissingInRight;

    public RightFileDTO() {
    }

    public RightFileDTO(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public List<MissingKeyDTO> getKeyMissingInRight() {
        return keyMissingInRight;
    }

    public void setKeyMissingInRight(List<MissingKeyDTO> keyMissingInRight) {
        this.keyMissingInRight = keyMissingInRight;
    }
}
