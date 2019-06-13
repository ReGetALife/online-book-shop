package com.onlinebookshop.indent.controller;

import com.onlinebookshop.indent.entity.Indent;
import com.onlinebookshop.indent.entity.IndentBook;
import com.onlinebookshop.indent.entity.ShoppingCart;
import com.onlinebookshop.indent.mapper.IndentMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class IndentController {
    @Autowired
    IndentMapper indentMapper;


    //查看个人所有订单
    @RequestMapping(path = "/indents/{account_id}",method = RequestMethod.GET)
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

    //添加购物车
    @RequestMapping(path = "/trolley",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Boolean> setTrolley(@RequestBody ShoppingCart shoppingCart){
        if(indentMapper.insertShopping(shoppingCart))
            return  ResponseEntity.ok(true);
        else return ResponseEntity.ok(false);
    }

    //查看购物车
    @RequestMapping(path = "/trolley/{account_id}",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<Long>> getTrolley(@PathVariable String account_id){
        List<Long> trolley=indentMapper.getShoppingCart(account_id);
        return ResponseEntity.ok(trolley);
    }

    //删除购物车
    @RequestMapping(path = "/trolley",method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<Boolean> deTrolley(@RequestBody ShoppingCart shoppingCart){
        if(indentMapper.deleteShopping(shoppingCart))
            return ResponseEntity.ok(true);
        else return ResponseEntity.ok(false);
    }

    //发起订单
    @RequestMapping(path = "/indent",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Long> setIndent(@RequestBody Indent indent){
        if(indentMapper.insertIndent(indent)){
            List<IndentBook> indentBooks=indent.getindentBooks();
            for(IndentBook indentBook:indentBooks){
                indentMapper.insertInBook(indentBook);
            }
            return ResponseEntity.ok(indentMapper.getIndentId());
        }
        return ResponseEntity.status(404).body(indentMapper.getIndentId());
    }
    //查看
}
