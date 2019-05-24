package com.onlinebookshop.indent.util;


import com.onlinebookshop.indent.entity.ResponseMessage;

public interface MakeResponse {
    ResponseMessage success();
    ResponseMessage error(int code, String message);
}