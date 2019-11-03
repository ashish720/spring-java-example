package com.ashish.spring.boot.pojo.dto;

import java.util.List;
import java.util.Map;

public class DuplicateKeyDTO {
    Map<String, List<String>> duplicateKeyMap;
    private ErrorDTO error;

    public Map<String, List<String>> getDuplicateKeyMap() {
        return duplicateKeyMap;
    }

    public void setDuplicateKeyMap(Map<String, List<String>> duplicateKeyMap) {
        this.duplicateKeyMap = duplicateKeyMap;
    }

    public ErrorDTO getError() {
        return error;
    }

    public void setError(ErrorDTO error) {
        this.error = error;
    }
}
