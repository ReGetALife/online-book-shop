package com.onlinebookshop.gateway;

import com.mongodb.MongoClient;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;


public class AccountGatewayFilter implements GatewayFilter {
    private static final String AUTHORIZE_TOKEN = "AUTHORIZE_TOKEN";
    private static final String AUTHORIZE_UID = "AUTHORIZE_UID";

    private MongoTemplate mongoTemplate=new MongoTemplate(new MongoClient("139.199.75.41",27017),"account-db");

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        HttpHeaders headers = request.getHeaders();

        //假如是新建账户，则不鉴权
        //System.out.println(request.getMethod().toString()+request.getPath().toString());
        if(request.getMethod() != null && request.getMethod().toString().equals("POST") && request.getPath().toString().equals("/accounts")){
            return chain.filter(exchange);
        }
        //从头部或请求参数获取uid和token
        String token = headers.getFirst(AUTHORIZE_TOKEN);
        String uid = headers.getFirst(AUTHORIZE_UID);
        if (token == null) {
            token = request.getQueryParams().getFirst(AUTHORIZE_TOKEN);
        }
        if (uid == null) {
            uid = request.getQueryParams().getFirst(AUTHORIZE_UID);
        }

        //没有找到uid或token
        ServerHttpResponse response = exchange.getResponse();
        if (StringUtils.isEmpty(token) || StringUtils.isEmpty(uid)) {
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            return response.setComplete();
        }


        //token不匹配
        Token authToken = mongoTemplate.findById(uid,Token.class);
        if (authToken == null || !authToken.getToken().equals(token)) {
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            return response.setComplete();
        }

        //成功鉴权
        return chain.filter(exchange);
    }
}
