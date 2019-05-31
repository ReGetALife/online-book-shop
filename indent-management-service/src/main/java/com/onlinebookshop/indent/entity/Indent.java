package com.onlinebookshop.indent.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import java.util.List;

public class Indent {
    private Long indent_id;   //订单ID
    private String account_id; //账户id
    private int state;  //状态
    private Date time_stamp; //时间戳
    private Long transaction_amount; //交易数量
    private List<IndentBook> indentBooks;//订单书籍信息


    @JsonProperty(value = "indent_id")
    public Long getindent_id() {
        return indent_id;
    }

    public void setindent_id(Long indent_id) {
        this.indent_id = indent_id;
    }

    @JsonProperty(value = "account_id")
    public String getaccount_id() {
        return account_id;
    }

    public void setaccount_id(String account_id) {
        this.account_id = account_id;
    }

    @JsonProperty(value = "transaction_amount")
    public Long gettransaction_amount() {
        return transaction_amount;
    }

    public void settransaction_amount(Long transaction_amount) {
        this.transaction_amount = transaction_amount;
    }

    @JsonProperty(value = "state")
    public int getstate() {
        return state;
    }

    public void setstate(int state) {
        this.state = state;
    }

    @JsonProperty(value = "time_stamp")
    public Date gettime_stamp() {
        return time_stamp;
    }

    public void settime_stamp(Date time_stamp) {
        this.time_stamp = time_stamp;
    }

    @JsonProperty(value = "indentBooks")
    public List<IndentBook> getindentBooks() {
        return indentBooks;
    }

    public void setindentBooks(List<IndentBook> indentBooks) {
        this.indentBooks = indentBooks;
    }



}
