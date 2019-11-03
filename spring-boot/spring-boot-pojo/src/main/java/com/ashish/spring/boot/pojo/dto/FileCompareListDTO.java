package com.ashish.spring.boot.pojo.dto;

public class FileCompareListDTO {

    private String leftFile;
    private String rightFile;

    public FileCompareListDTO() {
    }

    public FileCompareListDTO(String leftFile, String rightFile) {
        this.leftFile = leftFile;
        this.rightFile = rightFile;
    }

    public String getLeftFile() {
        return leftFile;
    }

    public void setLeftFile(String leftFile) {
        this.leftFile = leftFile;
    }

    public String getRightFile() {
        return rightFile;
    }

    public void setRightFile(String rightFile) {
        this.rightFile = rightFile;
    }
}
