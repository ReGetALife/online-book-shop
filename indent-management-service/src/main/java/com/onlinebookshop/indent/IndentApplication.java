package com.onlinebookshop.indent;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.stereotype.Controller;

@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("com.onlinebookshop.indent.mapper")
public class IndentApplication {

    public static void main(String[] args) {
        SpringApplication.run(IndentApplication.class, args);
    }

}