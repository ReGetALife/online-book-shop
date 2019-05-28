package com.onlinebookshop.account;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.*;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
public class AccountController {

    @Autowired
    private MongoTemplate mongoTemplate;

    //获取所有账户信息
    @RequestMapping(value="/accounts",method=GET)
    @ResponseBody
    public List<Account> allAccount() {
        return mongoTemplate.findAll(Account.class);
    }
    //新建一个账户
    @RequestMapping(value="/accounts",method=POST)
    @ResponseBody
    public ResponseEntity<Account> addAccount(@RequestBody Account account) {
        Account newAccount=null;
        if(mongoTemplate.find(Query.query(Criteria.where("phone").is(account.getPhone())),Account.class).isEmpty()){
            newAccount=new Account();
            newAccount.setAccountId(new ObjectId().toString());
            newAccount.setAccountName(account.getAccountName());
            newAccount.setAvatar(account.getAvatar());
            newAccount.setPassword(DigestUtils.md5DigestAsHex(account.getPassword().getBytes()));
            newAccount.setPhone(account.getPhone());
            return ResponseEntity.ok(mongoTemplate.insert(newAccount));
        }
        else {
            return ResponseEntity.status(409).body(newAccount);
        }
    }
    //查询某个账户
    @RequestMapping(value = "/accounts/{accountId}",method = GET)
    @ResponseBody
    public ResponseEntity<Account> getAccount(@PathVariable String accountId){
        Account newAccount=mongoTemplate.findById(accountId,Account.class);
        if(newAccount==null){
            return ResponseEntity.status(404).body(newAccount);
        }
        else {
            return ResponseEntity.ok(newAccount);
        }
    }
    //修改某个账户
    @RequestMapping(value = "/accounts/{accountId}",method = PUT)
    @ResponseBody
    public ResponseEntity<Account> updateAccount(@RequestBody Account account,@PathVariable String accountId){
        Account updatedAccount = null;
        Account oldAccount = mongoTemplate.findById(accountId,Account.class);
        if(oldAccount==null){
            return ResponseEntity.status(404).body(updatedAccount);
        }
        else if(account.getPhone()!=null&&!account.getPhone().equals(oldAccount.getPhone())){
            //不允许修改手机号
            return ResponseEntity.status(409).body(updatedAccount);
        }
        else{
            account.setAccountId(accountId);
            account.setPassword(DigestUtils.md5DigestAsHex(account.getPassword().getBytes()));
            updatedAccount = mongoTemplate.save(account);
            return ResponseEntity.ok(updatedAccount);
        }
    }
    //登录获取token
    @RequestMapping(value = "/tokens",method = POST)
    @ResponseBody
    public ResponseEntity<Token> createToken(@RequestBody Map<String, String> authInfo){
        Token token=null;
        Account account = mongoTemplate.findOne(Query.query(Criteria.where("phone").is(authInfo.get("phone"))),Account.class);
        if(account==null){
            return ResponseEntity.status(404).body(token);
        }
        if(!account.getPassword().equals(DigestUtils.md5DigestAsHex(authInfo.get("password").getBytes()))){
            return ResponseEntity.status(401).body(token);
        }
        String salt = random(5); //生成几位的盐
        String saltyPassword=salt+authInfo.get("password");
        token=new Token();
        token.setUid(account.getAccountId());
        token.setToken(DigestUtils.md5DigestAsHex(saltyPassword.getBytes()));
        //设置过期时间。mongodb已经通过db.token.createIndex({"expireTime": 1},{"expireAfterSeconds":0});设置了ttl索引。
        Date nowTime=new Date();
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(nowTime);
        calendar.add(Calendar.HOUR,12);//十二小时后过期
        token.setExpireTime(calendar.getTime());

        return ResponseEntity.ok(mongoTemplate.save(token));
    }
    // 盐生成方法
    private String random(Integer mu){
        Random random = new Random();
        String chars = "qazwsxedcrfvtgbyhnujmikolp";
        String returns = "";
        for(int i = 0 ; i < mu ;i ++ ){
            returns += chars.charAt(random.nextInt(chars.length()));
        }
        return returns;
    }
}