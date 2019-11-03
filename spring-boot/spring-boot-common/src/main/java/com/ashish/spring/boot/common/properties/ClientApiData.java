package com.ashish.spring.boot.common.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@PropertySource("classpath:com/ashish/spring/boot/properties/client_api_details.properties")
public class ClientApiData {
    @Value("${delete.single.record}")
    private String deleteSingleRecord;

    @Value("${delete.multiple.record}")
    private String deleteMultipleRecord;

    @Value("${fetch.all.employee}")
    private String fetchAllEmployee;

    @Value("${repo.file.client.compare}")
    private String apiRepoFileCompare;

    @Value("${repo.left.file.name}")
    private String leftFileName;

    @Value("${repo.right.file.name}")
    private String rightFileName;

    @Value("${repo.file.lists}")
    private String fileApis;

    public String getDeleteSingleRecord() {
        return deleteSingleRecord;
    }

    public void setDeleteSingleRecord(String deleteSingleRecord) {
        this.deleteSingleRecord = deleteSingleRecord;
    }

    public String getDeleteMultipleRecord() {
        return deleteMultipleRecord;
    }

    public void setDeleteMultipleRecord(String deleteMultipleRecord) {
        this.deleteMultipleRecord = deleteMultipleRecord;
    }

    public String getApiRepoFileCompare() {
        return apiRepoFileCompare;
    }

    public void setApiRepoFileCompare(String apiRepoFileCompare) {
        this.apiRepoFileCompare = apiRepoFileCompare;
    }

    public String getLeftFileName() {
        return leftFileName;
    }

    public void setLeftFileName(String leftFileName) {
        this.leftFileName = leftFileName;
    }

    public String getRightFileName() {
        return rightFileName;
    }

    public void setRightFileName(String rightFileName) {
        this.rightFileName = rightFileName;
    }

    public String getFileApis() {
        return fileApis;
    }

    public void setFileApis(String fileApis) {
        this.fileApis = fileApis;
    }

    public Map<String,List<String>> fetchAllApiDetails(){
        Map<String,List<String>> apiDetails = new HashMap<>();
        apiDetails.put("DSR", Arrays.asList(this.deleteSingleRecord.split("%")));
        apiDetails.put("DMR", Arrays.asList(this.deleteMultipleRecord.split("%")));
        apiDetails.put("FAE", Arrays.asList(this.fetchAllEmployee.split("%")));
        apiDetails.put("RFC", Arrays.asList(this.apiRepoFileCompare.split("%")));
        apiDetails.put("FAPIS", Arrays.asList(this.fileApis.split("%")));
        apiDetails.put("RFN", Arrays.asList(this.rightFileName));
        apiDetails.put("LFN", Arrays.asList(this.leftFileName));
        return apiDetails;
    }
}
