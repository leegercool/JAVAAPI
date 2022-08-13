package com.example.javaapi.enums;


import com.example.javaapi.dao.IErrorCode;

public enum ResultStatusEnum implements IErrorCode {

    SUCCESS(200,"操作成功"),
    FAILURE(500,"操作失败"),
    VALIDATE_FAILED(404,"参数验证失败"),
    UNAUTHORIZED(401,"未登录或token已过期"),
    FORBIDDEN(403,"没有操作权限");

    private  long code;
    private  String message;


    ResultStatusEnum(long code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public long getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
