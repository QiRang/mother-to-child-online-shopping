package com.example.mothertochild.util;

//定义一个json对象，用于返回
public class JsonResult {
    // 先默认一个状态码是失败
    private Integer code = 900;
    private String message = " ";
    private Object value = "";

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public JsonResult(Integer code, String success, String message, Object value) {
        this.code = code;
        this.message = message;
        this.value = value;
    }

    public JsonResult(Integer code, String success, String message) {
        this.code = code;
        this.message = message;
    }

    public JsonResult() {
    }
}