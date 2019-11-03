package com.ashish.spring.boot.pojo.io;


import java.util.List;

public class RightFileIO {

    private String fileName;
    private List<String> keyMissingInRight;

    public RightFileIO() {
    }

    public RightFileIO(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public List<String> getKeyMissingInRight() {
        return keyMissingInRight;
    }

    public void setKeyMissingInRight(List<String> keyMissingInRight) {
        this.keyMissingInRight = keyMissingInRight;
    }
}
