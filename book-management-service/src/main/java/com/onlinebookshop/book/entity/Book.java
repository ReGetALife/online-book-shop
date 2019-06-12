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

    @JsonProperty(value = "ISBN")
    public String getISBN() {
        return ISBN;
    }
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    @JsonProperty(value = "title")
    public String gettitle() {
        return title;
    }
    public void settitle(String title) {
        this.title = title;
    }

    @JsonProperty(value = "subtitle")
    public String getsubtitle() {
        return subtitle;
    }
    public void setsubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    @JsonProperty(value = "series")
    public String getseries() {
        return series;
    }
    public void setseries(String series) {
        this.series = series;
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

    @JsonProperty(value = "pubdate")
    public Date getpubdate() {
        return pubdate;
    }
    public void setpubdate(Date pubdate) {
        this.pubdate = pubdate;
    }

    @JsonProperty(value = "edition")
    public String getedition() {
        return edition;
    }
    public void setedition(String edition) {
        this.edition = edition;
    }

    @JsonProperty(value = "impression")
    public String getimpression() {
        return impression;
    }
    public void setimpression(String impression) {
        this.impression = impression;
    }

    @JsonProperty(value = "size")
    public String getsize() {
        return size;
    }
    public void setsize(String size) {
        this.size = size;
    }

    @JsonProperty(value = "pages")
    public String getpages() {
        return pages;
    }
    public void setpages(String pages) {
        this.pages = pages;
    }

    @JsonProperty(value = "words")
    public String getwords() {
        return words;
    }
    public void setwords(String words) {
        this.words = words;
    }

    @JsonProperty(value = "print_date")
    public Date getprint_date() {
        return print_date;
    }
    public void setprint_date(Date print_date) {
        this.print_date = print_date;
    }

    @JsonProperty(value = "pack")
    public String getpack() {
        return pack;
    }
    public void setpack(String pack) {
        this.pack = pack;
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

    @JsonProperty(value = "classification")
    public String getclassification() {
        return classification;
    }
    public void setclassification(String classification) {
        this.classification = classification;
    }

    @JsonProperty(value = "category")
    public String getcategory() {
        return category;
    }
    public void setcategory(String category) {
        this.category = category;
    }

    @JsonProperty(value = "brief")
    public String getbrief() {
        return brief;
    }
    public void setbrief(String brief) {
        this.brief = brief;
    }

    @JsonProperty(value = "writer_brief")
    public String getwriter_brief() {
        return writer_brief;
    }
    public void setwriter_brief(String writer_brief) {
        this.writer_brief = writer_brief;
    }

    @JsonProperty(value = "content")
    public String getcontent() {
        return content;
    }
    public void setcontent(String content) {
        this.content = content;
    }

    @JsonProperty(value = "image")
    public String getimage() { return image; }
    public void setimage(String image) {
        this.image = image;
    }

}
