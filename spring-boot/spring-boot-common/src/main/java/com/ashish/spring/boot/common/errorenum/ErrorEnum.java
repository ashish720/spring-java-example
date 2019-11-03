package com.ashish.spring.boot.common.errorenum;

public enum ErrorEnum {

    NOT_FOUND("404","records not found"),
    CODE_ERROR("500","error occurred, please try again later"),
    INPUT_NOT_VALID("INPUT_400","bad input");

    private String code;
    private String message;

    ErrorEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage(String customeMessage){
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append(" [ code : ");
        stringBuilder.append(this.code);
        stringBuilder.append(", message : ");
        stringBuilder.append(this.message);
        stringBuilder.append(" :: ");
        stringBuilder.append(customeMessage);
        stringBuilder.append(" ]");
        return stringBuilder.toString();
    }
}
