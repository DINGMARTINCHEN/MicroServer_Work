package com.dingshicheng23090200150.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;
@SpringBootApplication
@MapperScan("com.dingshicheng23090200150.cloud.mapper") //import tk.mybatis.spring.annotation.MapperScan;
@EnableDiscoveryClient
public class Main8002
{
    public static void main(String[] args)
    {
        SpringApplication.run(Main8002.class,args);
    }
}