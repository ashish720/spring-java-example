package com.ashish.spring.boot.web.controller.mapper.impl.file;

import com.ashish.spring.boot.pojo.dto.FileCompareDTO;
import com.ashish.spring.boot.pojo.io.FileCompareIO;
import com.ashish.spring.boot.pojo.io.LeftFileIO;
import com.ashish.spring.boot.pojo.io.RightFileIO;
import com.ashish.spring.boot.common.constant.FileConstant;
import com.ashish.spring.boot.web.controller.mapper.iomapper.IOClassMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class FileMapperImpl implements IOClassMapper<FileCompareIO, FileCompareDTO> {

    @Override
    public FileCompareIO mapToJsonObject(FileCompareDTO input) {
        if(input==null || StringUtils.equalsIgnoreCase(input.getStatus(), FileConstant.REPO_FILE_COMPARE_API_FAILED)){
            return createFileErrorResponse(FileConstant.REPO_FILE_COMPARE_API_FAILED,input.getError());
        }
        FileCompareIO fileCompareIO=new FileCompareIO();
        fileCompareIO.setLeftFile(new LeftFileIO(input.getLeftFile().getFileName()));
        fileCompareIO.getLeftFile().setKeyMissingInLeft(new ArrayList<>());
        input.getLeftFile().getKeyMissingInLeft().forEach(item->{
            fileCompareIO.getLeftFile().getKeyMissingInLeft().add(item.getMissingKey());
        });
        fileCompareIO.setRightFile(new RightFileIO(input.getRightFile().getFileName()));
        fileCompareIO.getRightFile().setKeyMissingInRight(new ArrayList<>());
        input.getRightFile().getKeyMissingInRight().forEach(item->{
            fileCompareIO.getRightFile().getKeyMissingInRight().add(item.getMissingKey());
        });
        fileCompareIO.setStatus(FileConstant.REPO_FILE_COMPARE_API_SUCCESS);
        return fileCompareIO;
    }
}
