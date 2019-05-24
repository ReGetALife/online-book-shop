package com.onlinebookshop.indent.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
public class Indent {
    private Long indent_id;   //订单ID
    private Long account_id; //账户id 
    private int state;  //状态
    private Date time_stamp; //时间戳
    private Long transaction_amount; //交易数量


    @JsonProperty(value = "indent_id")
    public Long getindent_id() {
        return indent_id;
    }

    public void setindent_id(Long indent_id) {
        this.indent_id = indent_id;
    }

    @JsonProperty(value = "account_id")
    public Long getaccount_id() {
        return account_id;
    }

    public void setaccount_id(Long account_id) {
        this.account_id = account_id;
    }

    @JsonProperty(value = "account_id")
    public Long gettransaction_amount() {
        return transaction_amount;
    }

    public void settransaction_amount(Long account_id) {
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

    public void settime_stamp(Date sign_time) {
        this.time_stamp = time_stamp;
    }





}
