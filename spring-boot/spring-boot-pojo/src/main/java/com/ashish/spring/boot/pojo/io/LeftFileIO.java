package com.ashish.spring.boot.pojo.io;


import java.util.List;

public class LeftFileIO {

    private String fileName;
    private List<String> keyMissingInLeft;

    public LeftFileIO() {
    }

    public LeftFileIO(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public List<String> getKeyMissingInLeft() {
        return keyMissingInLeft;
    }

    public void setKeyMissingInLeft(List<String> keyMissingInLeft) {
        this.keyMissingInLeft = keyMissingInLeft;
    }
}
