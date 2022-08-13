package com.example.javaapi.common;


import com.example.javaapi.dao.IErrorCode;
import com.example.javaapi.enums.ResultStatusEnum;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


public class CommonResult<T> {
    private  long code;
    private String msg;
    private  T data;
    private Iterable<T> dataList;


    public CommonResult() {

    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Iterable<T> getDataList() {
        return dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }

    public CommonResult(long code, String msg, T data, Iterable<T> dataList) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.dataList = dataList;
    }

    public long getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * 封装好的信息
     * @param t
     * @param <T>
     * @return
     */
    public static <T> ResponseEntity success(T t){
        return  new ResponseEntity(new CommonResult<>(ResultStatusEnum.SUCCESS.getCode(),
        ResultStatusEnum.SUCCESS.getMessage(), t,null),HttpStatus.ACCEPTED);
    }

    public static <T> ResponseEntity success(List<T> list){
        return new ResponseEntity(new CommonResult<>(ResultStatusEnum.SUCCESS.getCode(),
                ResultStatusEnum.SUCCESS.getMessage(), null,list),HttpStatus.ACCEPTED);
    }

    /**
     * 重载自定义message
     * @param t
     * @param message
     * @param <T>
     * @return
     */
    public static <T> ResponseEntity success(T t, String message){
        return new ResponseEntity(new CommonResult<>(ResultStatusEnum.SUCCESS.getCode(), message, t,null),HttpStatus.ACCEPTED);
    }

    public static <T> ResponseEntity success(List<T> list, String message){
        return new ResponseEntity(new CommonResult<>(ResultStatusEnum.SUCCESS.getCode(), message, null,list),HttpStatus.ACCEPTED);
    }

    /**
     * 重载自定义code message
     * @param t
     * @param code
     * @param message
     * @param <T>
     * @return
     */
    public static <T> CommonResult success(T t, long code, String message){
        return new CommonResult<>(code, message, t,null);
    }

    public static <T> ResponseEntity failed(String message){
        return new ResponseEntity(new CommonResult<>(ResultStatusEnum.FAILURE.getCode(), message, null,null),HttpStatus.ACCEPTED);
    }

    public static<T> CommonResult failed(IErrorCode resultCode){
        return new CommonResult<>(resultCode.getCode(), resultCode.getMessage(),null,null);
    }

    public static<T> CommonResult failed(IErrorCode resultCode, T data){
        return new CommonResult<>(resultCode.getCode(), resultCode.getMessage(),data,null);
    }

    public static<T> CommonResult failed(){
        return failed(ResultStatusEnum.FAILURE);
    }

    public static<T> CommonResult validateFailed(){
        return failed(ResultStatusEnum.VALIDATE_FAILED);
    }

    public static<T> CommonResult validateFailed(String message){
        return new CommonResult<>(ResultStatusEnum.VALIDATE_FAILED.getCode(), message,null,null);
    }

    public static<T> CommonResult unauthorized(T data){
//        return new CommonResult<>(CommonCode.UNAUTHORIZED.getCode(), CommonCode.UNAUTHORIZED.getMessage(),data);
        return failed(ResultStatusEnum.UNAUTHORIZED, data);
    }

    public static<T> CommonResult forbidden(T data){
//        return new CommonResult<>(CommonCode.FORBIDDEN.getCode(), CommonCode.FORBIDDEN.getMessage(),data);
        return failed(ResultStatusEnum.FORBIDDEN, data);
    }


}
