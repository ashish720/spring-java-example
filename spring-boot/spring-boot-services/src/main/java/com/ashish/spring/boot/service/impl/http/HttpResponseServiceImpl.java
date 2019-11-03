package com.ashish.spring.boot.service.impl.http;

import com.ashish.spring.boot.common.constant.EmployeeConstants;
import com.ashish.spring.boot.common.constant.BootHttpConstant;
import com.ashish.spring.boot.service.http.HttpService;
import org.springframework.http.*;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Map;

@Service
public class HttpResponseServiceImpl implements HttpService<String> {

    @Override
    public ResponseEntity<String> invokeRestApi(String url, String jsonBody, Map<String, String> headerMap, HttpMethod httpMethod) {
        ResponseEntity<String> result=null;
        try {
            RestTemplate restTemplate = new RestTemplate();
            SimpleClientHttpRequestFactory simpleClientHttpRequestFactory = new SimpleClientHttpRequestFactory();
            simpleClientHttpRequestFactory.createRequest(new URI(url), httpMethod);
            restTemplate.setRequestFactory(simpleClientHttpRequestFactory);
            HttpEntity<String> requestEntity = new HttpEntity<String>(populateHeader(headerMap));
            if(jsonBody!=null){
                requestEntity = new HttpEntity<String>(jsonBody,populateHeader(headerMap));
            }
            result = restTemplate.exchange(url, httpMethod, requestEntity, String.class);
        } catch (URISyntaxException e) {
            return errorResponseEntity(EmployeeConstants.EMPLOYEE_FAILED, BootHttpConstant.URI_SYNTAX_ERROR_CODE,"failed due to invalid url pattern :: cause :: "+e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (IOException e) {
            return errorResponseEntity(EmployeeConstants.EMPLOYEE_FAILED,BootHttpConstant.CONN_EXPECTATION_ERROR_CODE,"failed while establish connection :: cause :: "+e.getMessage(),HttpStatus.EXPECTATION_FAILED);
        }catch (RuntimeException e){
            return errorResponseEntity(EmployeeConstants.EMPLOYEE_FAILED,BootHttpConstant.CONN_EXPECTATION_ERROR_CODE,"failed due to unknown reason :: cause :: "+e.getMessage(),HttpStatus.EXPECTATION_FAILED);
        }catch (Exception e){
            return errorResponseEntity(EmployeeConstants.EMPLOYEE_FAILED,BootHttpConstant.URI_SYNTAX_ERROR_CODE,"failed due to unknown reason:: cause :: "+e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if(result==null){
            result=errorResponseEntity(EmployeeConstants.EMPLOYEE_FAILED,BootHttpConstant.NOT_FOUND_ERROR_CODE,"no records found.",HttpStatus.NOT_FOUND);
        }
        return result;
    }

    private MultiValueMap<String, String> populateHeader(Map<String, String> headerMap){
        MultiValueMap<String, String> headerMultiValueMap = new HttpHeaders();
        headerMap.forEach((k,v)->{
            headerMultiValueMap.put(k,Arrays.asList(v.split(",")));
        });
        return headerMultiValueMap;
    }
}
