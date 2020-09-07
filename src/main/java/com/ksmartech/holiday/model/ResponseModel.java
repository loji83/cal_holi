package com.ksmartech.holiday.model;

public class ResponseModel {
    private String code;
    private String message;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ResponseModel{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
