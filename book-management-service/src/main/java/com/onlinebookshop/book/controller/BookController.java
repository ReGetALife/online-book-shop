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

    //所有书籍
    @RequestMapping(path = "/allBook",method = RequestMethod.GET)
    public ResponseEntity getAllBook()
    {
        List<Book> Books = bookMapper.getAllBook();
        return ResponseEntity.ok(Books);
    }

    //书籍列表
    @RequestMapping(path = "/bookList",method = RequestMethod.GET)
    public ResponseEntity getBookList(@RequestParam(value = "pageNum",required = false)String pageNum, @RequestParam(value = "pageSize",required = false)String pageSize)
    {
        if(pageNum == null)
            pageNum = "1";
        if(pageSize == null)
            pageSize = "10";

        int skip = (Integer.parseInt(pageNum) - 1) * Integer.parseInt(pageSize);
        List<Book> Books = bookMapper.getBookList(skip, Integer.parseInt(pageSize));
        return ResponseEntity.ok(Books);
    }

    //按id查看
    @RequestMapping(path = "/book",method = RequestMethod.GET)
    public ResponseEntity getBook(@RequestParam(value = "book_id",required = false)String book_id)
    {
        if(book_id == null)
            return null;
        else{
            List<Book> Books = bookMapper.getBook(Integer.parseInt(book_id));
            return ResponseEntity.ok(Books);
        }

    }

    //搜索
    @RequestMapping(path = "/search",method = RequestMethod.GET)
    public ResponseEntity searchBook(@RequestParam(value = "key",required = false)String key, @RequestParam(value = "pageNum",required = false)String pageNum, @RequestParam(value = "pageSize",required = false)String pageSize)
    {
        if(key == null)
            key = "%";
        if(pageNum == null)
            pageNum = "1";
        if(pageSize == null)
            pageSize = "10";

        int skip = (Integer.parseInt(pageNum) - 1) * Integer.parseInt(pageSize);
        String complete = "%" + key + "%";
        List<Book> Books = bookMapper.searchBook(complete, skip, Integer.parseInt(pageSize));
        return ResponseEntity.ok(Books);
    }

}
