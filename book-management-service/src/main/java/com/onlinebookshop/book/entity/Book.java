package com.onlinebookshop.book.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
public class Book {
    private Long book_id;   //书籍id
    private String title;   //书籍名称
    private double price;   //原价
    private double discount;//折扣
    private String write;   //作者
    private String press;   //出版社
    private String brief;   //简介
    private String cover;   //封面图片路径
    private Date pubdate;   //出版日期

    @JsonProperty(value = "book_id")
    public Long getbook_id() {
        return book_id;
    }
    public void setbook_id(Long book_id) {
        this.book_id = book_id;
    }

    @JsonProperty(value = "title")
    public String gettitle() {
        return title;
    }
    public void settitle(String title) {
        this.title = title;
    }

    @JsonProperty(value = "price")
    public double getprice() {
        return price;
    }
    public void setprice(double price) {
        this.price = price;
    }

    @JsonProperty(value = "discount")
    public double gediscount() {
        return discount;
    }
    public void setdiscount(double discount) {
        this.discount = discount;
    }

    @JsonProperty(value = "write")
    public String getwrite() {
        return write;
    }
    public void setwrite(String write) {
        this.write = write;
    }

    @JsonProperty(value = "press")
    public String getpress() {
        return press;
    }
    public void setpress(String press) {
        this.press = press;
    }

    @JsonProperty(value = "brief")
    public String getbrief() {
        return brief;
    }
    public void setbrief(String brief) {
        this.brief = brief;
    }

    @JsonProperty(value = "cover")
    public String getcover() {
        return cover;
    }
    public void setcover(String cover) {
        this.cover = cover;
    }

    @JsonProperty(value = "pubdate")
    public Date getpubdate() {
        return pubdate;
    }
    public void setpubdate(Date pubdate) {
        this.pubdate = pubdate;
    }

}
