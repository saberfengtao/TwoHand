package com.ft.exceprion;

/**
 * 自定义异常类
 */
public class CustomException extends RuntimeException {
    private int code;
    private String msg;

    public CustomException(){}

    public CustomException(int code, String msg){
        super(msg);
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
