package com.neo.indent.entity;

import com.neo.indent.util.MakeResponse;

public class ResponseMessage<T> implements MakeResponse {
    private Integer status;
    private String message;
    private T data;

    public ResponseMessage(T data) {
        this.data = data;
    }

    @Override
    public ResponseMessage success() {
        this.status = 200;
        this.message = "OK";
        return this;
    }

    @Override
    public ResponseMessage error(int status, String message) {
        this.status = status;
        this.message = message;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}