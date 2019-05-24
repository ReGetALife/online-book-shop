package com.onlinebookshop.account;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import javax.management.Query;
import java.util.List;

@RestController
public class AccountController {

    @Autowired
    private MongoTemplate mongoTemplate;

    @RequestMapping("/account")
    public List<Account> greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return mongoTemplate.findAll(Account.class);
    }
    @RequestMapping("/addTestAccount")
    public void addTestAccount() {
        Account account=new Account();
        account.setAccountId(1);
        account.setAccountName("lee");
        account.setAvatar("none");
        account.setPassword("asdggjlkjl");
        account.setPhone(10086);
        mongoTemplate.save(account);
    }
}
