package com.ashish.spring.boot.pojo.dto;



public class FileCompareDTO {

    private String status;
    private ErrorDTO error;
    private RightFileDTO rightFile;
    private LeftFileDTO leftFile;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ErrorDTO getError() {
        return error;
    }

    public void setError(ErrorDTO error) {
        this.error = error;
    }

    public RightFileDTO getRightFile() {
        return rightFile;
    }

    public void setRightFile(RightFileDTO rightFile) {
        this.rightFile = rightFile;
    }

    public LeftFileDTO getLeftFile() {
        return leftFile;
    }

    public void setLeftFile(LeftFileDTO leftFile) {
        this.leftFile = leftFile;
    }
}
