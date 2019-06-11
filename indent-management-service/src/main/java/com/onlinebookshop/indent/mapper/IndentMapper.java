package com.onlinebookshop.indent.mapper;

import com.onlinebookshop.indent.entity.Indent;
import com.onlinebookshop.indent.entity.IndentBook;
import com.onlinebookshop.indent.entity.ShoppingCart;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import java.util.List;

@Mapper
@Repository
public interface IndentMapper {
    //查看个人订单
    @Select("select * from indent where account_id=#{account_id}")
    List<Indent> getIndividualIndents(@Param(value = "account_id")String account_id);

    //查询单个订单
    @Select("select * from indent where indent_id=#{indent_id}")
    Indent getIndent(@Param(value="indent_id")Long indent_id);

    //单个订单书籍
    @Select("select * from indent_book where indent_id=#{indent_id}")
    List<IndentBook> getIndentBooks(@Param(value = "indent_id")Long indent_id);

    //添加购物车
    @Insert("insert into shopping_cart(account_id,book_id) values (#{account_id},#{book_id})")
    Boolean insertShopping(ShoppingCart shoppingcart);

    //查看个人购物车
    @Select("select book_id from shopping_cart where account_id=#{account_id}")
    List<ShoppingCart> getShoppingCart(@Param(value = "account_id")Long account_id);

    //删除购物车中书籍
    @Delete("delete from shopping_cart where account_id=#{account_id} and book_id=#{book_id}")
    Boolean deleteShopping(ShoppingCart shoppingcart);
}
