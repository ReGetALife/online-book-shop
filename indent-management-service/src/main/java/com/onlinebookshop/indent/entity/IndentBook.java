package com.onlinebookshop.indent.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
public class IndentBook {
    private Long indent_id;
    private Long book_id;
    private int amount;
    private float price;

    @JsonProperty(value = "indent_id")
    public Long getindent_id() {
        return indent_id;
    }

    public void setindent_id(Long indent_id) {
        this.indent_id = indent_id;
    }

    @JsonProperty(value = "book_id")
    public Long getbook_id() {
        return book_id;
    }

    public void setbook_id(Long book_id) {
        this.book_id = book_id;
    }

    @JsonProperty(value = "amount")
    public int getamount() {
        return amount;
    }

    public void setamount(int amount) {
        this.amount = amount;
    }

    @JsonProperty(value = "price")
    public float getprice() {
        return price;
    }

    public void setprice(float price) {
        this.price = price;
    }
}
