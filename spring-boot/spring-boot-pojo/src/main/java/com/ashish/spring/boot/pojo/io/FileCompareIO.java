package com.ashish.spring.boot.pojo.io;

import java.util.List;

public class FileCompareIO {

    private String status;
    private ErrorIO error;
    private RightFileIO rightFile;
    private LeftFileIO leftFile;


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ErrorIO getError() {
        return error;
    }

    public void setError(ErrorIO error) {
        this.error = error;
    }

    public RightFileIO getRightFile() {
        return rightFile;
    }

    public void setRightFile(RightFileIO rightFile) {
        this.rightFile = rightFile;
    }

    public LeftFileIO getLeftFile() {
        return leftFile;
    }

    public void setLeftFile(LeftFileIO leftFile) {
        this.leftFile = leftFile;
    }
}
