package com.onlinebookshop.indent.controller;

import com.onlinebookshop.indent.entity.Indent;
import com.onlinebookshop.indent.mapper.IndentMapper;
import org.graalvm.compiler.lir.stackslotalloc.StackInterval;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class IndentController {
    @Autowired
    IndentMapper indentMapper;


    //查看个人所有订单
    @RequestMapping(path = "/indent/{account_id}",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<Indent>> getIndividualIndents(@PathVariable String account_id)
    {
        List<Indent> indents = indentMapper.getIndividualIndents(account_id);
        if(indents.isEmpty()){
            return ResponseEntity.status(404).body(indents);
        }
        for(int i=0;i<indents.size();i++){
            indents.get(i).setindentBooks(indentMapper.getIndentBooks(indents.get(i).getindent_id()));
        }
        return ResponseEntity.ok(indents);
    }

    //查看单个订单（根据订单ID）
    @RequestMapping(path = "/indent/{indent_id}",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Indent> getIndent(@PathVariable Long indent_id){
        Indent indent=indentMapper.getIndent(indent_id);
        indent.setindentBooks(indentMapper.getIndentBooks(indent_id));
        return  ResponseEntity.ok(indent);
    }


    //发起订单

}
