package com.dingshicheng23090200150.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
@SpringBootApplication(
    scanBasePackages = {"com.dingshicheng23090200150.cloud"},
    exclude = {
        org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration.class,
        org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration.class
    }
)
@EnableDiscoveryClient //该注解用于向使用consul为注册中心时注册服务
public class Main80
{
    public static void main(String[] args)
    {
        SpringApplication.run(Main80.class,args);
    }
}