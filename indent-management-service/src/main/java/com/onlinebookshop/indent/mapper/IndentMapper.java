package com.onlinebookshop.indent.mapper;

import com.onlinebookshop.indent.entity.Indent;
import com.onlinebookshop.indent.entity.IndentBook;
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
    @Select("select book_id from indent_book where indent_id=#{indent_id}")
    List<IndentBook> getIndentBooks(@Param(value = "indent_id")Long indent_id);

    //发起订单
    //@Insert("")

}
