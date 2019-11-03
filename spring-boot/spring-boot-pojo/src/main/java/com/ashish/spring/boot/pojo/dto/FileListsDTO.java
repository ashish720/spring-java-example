package com.ashish.spring.boot.pojo.dto;

import java.io.File;
import java.util.List;

public class FileListsDTO {

    private List<FileCompareListDTO> files;
    private DuplicateKeyDTO duplicateKeyDTO;

    public List<FileCompareListDTO> getFiles() {
        return files;
    }

    public void setFiles(List<FileCompareListDTO> files) {
        this.files = files;
    }

    public DuplicateKeyDTO getDuplicateKeyDTO() {
        return duplicateKeyDTO;
    }

    public void setDuplicateKeyDTO(DuplicateKeyDTO duplicateKeyDTO) {
        this.duplicateKeyDTO = duplicateKeyDTO;
    }
}
