package com.onlinebookshop.book.mapper;

import com.onlinebookshop.book.entity.Book;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BookMapper {
    //查看书籍列表
    @Select("select * from book")
    List<Book> getBookList();

    //按id查看书籍
    @Select("select * from book where book_id=#{book_id}")
    List<Book> getBook(@Param(value = "book_id")int book_id);

    //搜索书籍
    @Select("select * from book where title like #{key}")
    List<Book> searchBook(@Param(value = "key")String key);
}
