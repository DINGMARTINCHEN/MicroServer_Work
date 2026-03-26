package com.dingshicheng23090200150.cloud.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Swagger3配置
 */
@Configuration
public class Swagger3Config {

    // 支付微服务接口分组
    @Bean
    public GroupedOpenApi payApi() {
        return GroupedOpenApi.builder()
                .group("支付微服务模块")
                .pathsToMatch("/pay/**")
                .build();
    }

    // 接口文档基本信息
    @Bean
    public OpenAPI docsOpenApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("支付微服务API文档")
                        .description("冯子力-23090200149 - 支付微服务CRUD接口")
                        .version("v1.0"))
                .externalDocs(new ExternalDocumentation()
                        .description("微服务架构实验文档")
                        .url("https://www.atguigu.com/"));
    }
}