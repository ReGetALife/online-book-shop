package com.neo.indent.controller;

import com.neo.indent.entity.Indent;
import com.neo.indent.entity.ResponseMessage;
import com.neo.indent.mapper.IndentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class IndentController {
    @Autowired
    IndentMapper indentMapper;


    //查看赛事
    @RequestMapping(path = "/indent",method = RequestMethod.GET)
    public ResponseMessage getMatch(@RequestParam(value = "indent_id",required = false)Long indent_id)
    {
        List<Indent> indents = indentMapper.getIndent(indent_id);
        return new ResponseMessage<>(indents).success();
    }

}
