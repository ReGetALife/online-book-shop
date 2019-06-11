package com.onlinebookshop.indent.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ShoppingCart {
    private String account_id; //账户id
    private Long book_id; //书籍ID

    @JsonProperty(value = "book_id")
    public Long getbook_id() {
        return book_id;
    }

    public void setbook_id(Long book_id) {
        this.book_id = book_id;
    }

    @JsonProperty(value = "account_id")
    public String getaccount_id() {
        return account_id;
    }

    public void setaccount_id(String account_id) {
        this.account_id = account_id;
    }
}
