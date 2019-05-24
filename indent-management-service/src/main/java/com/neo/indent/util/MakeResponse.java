package com.neo.indent.util;


import com.neo.indent.entity.ResponseMessage;

public interface MakeResponse {
    ResponseMessage success();
    ResponseMessage error(int code, String message);
}