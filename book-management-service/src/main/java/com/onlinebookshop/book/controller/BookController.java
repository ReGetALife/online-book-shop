package com.onlinebookshop.book.controller;

import com.onlinebookshop.book.entity.Book;
import com.onlinebookshop.book.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
public class BookController {
    @Autowired
    BookMapper bookMapper;

    //书籍列表
    @RequestMapping(path = "/bookList",method = RequestMethod.GET)
    public ResponseEntity getList()
    {
        List<Book> Books = bookMapper.getBookList();
        return ResponseEntity.ok(Books);
    }

    //按id查看
    @RequestMapping(path = "/book",method = RequestMethod.GET)
    public ResponseEntity getBook(@RequestParam(value = "book_id",required = false)int book_id)
    {
        List<Book> Books = bookMapper.getBook(book_id);
        return ResponseEntity.ok(Books);
    }

    //搜索
    @RequestMapping(path = "/search",method = RequestMethod.GET)
    public ResponseEntity searchBook(@RequestParam(value = "key",required = false)String key)
    {
        String complete = "%" + key + "%";
        List<Book> Books = bookMapper.searchBook(complete);
        return ResponseEntity.ok(Books);
    }

}
