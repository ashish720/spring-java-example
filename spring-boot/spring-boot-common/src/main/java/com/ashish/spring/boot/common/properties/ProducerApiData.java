package com.ashish.spring.boot.common.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:com/ashish/spring/boot/properties/producer_api_details.properties")
public class ProducerApiData {

    @Value("${delete.single.endpoint.url}")
    private String singleDeleteRecordUrl;
    @Value("${delete.multiple.endpoint.url}")
    private String multipleDeleteRecordUrl;
    @Value("${repo.file.compare.endpoint.url}")
    private String repoFileCompareUrl;
    @Value("${duplicate.key.collector.url}")
    private String duplicateKeyUrl;

    public String getSingleDeleteRecordUrl() {
        return singleDeleteRecordUrl;
    }

    public void setSingleDeleteRecordUrl(String singleDeleteRecordUrl) {
        this.singleDeleteRecordUrl = singleDeleteRecordUrl;
    }

    public String getMultipleDeleteRecordUrl() {
        return multipleDeleteRecordUrl;
    }

    public void setMultipleDeleteRecordUrl(String multipleDeleteRecordUrl) {
        this.multipleDeleteRecordUrl = multipleDeleteRecordUrl;
    }

    public String getRepoFileCompareUrl() {
        return repoFileCompareUrl;
    }

    public void setRepoFileCompareUrl(String repoFileCompareUrl) {
        this.repoFileCompareUrl = repoFileCompareUrl;
    }

    public String getDuplicateKeyUrl() {
        return duplicateKeyUrl;
    }

    public void setDuplicateKeyUrl(String duplicateKeyUrl) {
        this.duplicateKeyUrl = duplicateKeyUrl;
    }
}
