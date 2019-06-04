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

        String token = headers.getFirst(AUTHORIZE_TOKEN);
        String uid = headers.getFirst(AUTHORIZE_UID);
        if (token == null) {
            token = request.getQueryParams().getFirst(AUTHORIZE_TOKEN);
        }
        if (uid == null) {
            uid = request.getQueryParams().getFirst(AUTHORIZE_UID);
        }

        ServerHttpResponse response = exchange.getResponse();
        if (StringUtils.isEmpty(token) || StringUtils.isEmpty(uid)) {
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            return response.setComplete();
        }


        Token authToken = mongoTemplate.findById(uid,Token.class);
        if (authToken == null || !authToken.getToken().equals(token)) {
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            return response.setComplete();
        }

        return chain.filter(exchange);
    }
}
