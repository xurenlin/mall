package com.xrl.mall.common.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/***
 *@title SwaggerConfig
 *@description
 * Swagger接口文档配置类
 *  地址：/swagger-ui/index.html
 * json地址：/v3/api-docs
 *@author xrl
 *@version 1.0.0
 *@create 2025/3/21 21:34
 **/
@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Mall API 文档")
                        .description("电商平台接口文档")
                        .version("1.0"));
    }

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("public")
                // 指定扫描的包
                .packagesToScan("com.xrl.mall.controller")
                .build();
    }
}
