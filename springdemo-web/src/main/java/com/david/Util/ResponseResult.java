package com.david.Util;

import java.io.Serializable;

/**
 * Created by GW on 2019/7/4.
 * 信息返回类
 *
 */
public class ResponseResult<T> implements Serializable{
    private static final long serialVersionUID = 1L;
    private int status;//状态码
    private String message;
    private  T result;
    private boolean success;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }


    public static <T> ResponseResult<T> ok(T data){
        ResponseResult res = new ResponseResult();
        res.setResult(data);
        res.setSuccess(true);
        return res;
    }
    public static <T> ResponseResult<T> ok(T data,int status){
        ResponseResult res = new ResponseResult();
        res.setStatus(status);
        res.setResult(data);
        res.setSuccess(true);
        return res;
    }
    public static <T> ResponseResult<T> ok(){

        return ok((T)null);
    }

    public static <T> ResponseResult<T> fail(String message){
        ResponseResult<T> res = new ResponseResult();
        res.setMessage(message);
        res.setSuccess(false);
        return res;
    }
    public static <T> ResponseResult<T> fail(String message,int status){
        ResponseResult<T> res = new ResponseResult();
        res.setStatus(status);
        res.setMessage(message);
        res.setSuccess(false);
        return res;
    }
    public static <T> ResponseResult<T> fail(){

        return fail("");
    }



}
