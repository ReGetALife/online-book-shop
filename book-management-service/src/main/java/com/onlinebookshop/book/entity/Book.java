package com.onlinebookshop.book.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
public class Book {
    private int book_id;
    private String ISBN;
    private String title;
    private String subtitle;
    private String series;
    private String writer;
    private String press;
    private Date pubdate;
    private String edition;
    private String impression;
    private String size;
    private String pages;
    private String words;
    private Date print_date;
    private String pack;
    private double price;
    private double discount;
    private String classification;
    private String category;
    private String brief;
    private String writer_brief;
    private String content;
    private String image;


    @JsonProperty(value = "book_id")
    public int getbook_id() {
        return book_id;
    }
    public void setbook_id(int book_id) {
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

    @JsonProperty(value = "writer")
    public String getwriter() {
        return writer;
    }
    public void setwriter(String writer) {
        this.writer = writer;
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

    @JsonProperty(value = "image")
    public String getimage() { return image; }
    public void setimage(String image) {
        this.image = image;
    }

    @JsonProperty(value = "pubdate")
    public Date getpubdate() {
        return pubdate;
    }
    public void setpubdate(Date pubdate) {
        this.pubdate = pubdate;
    }

}
