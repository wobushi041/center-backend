package org.wobushi041.centerbackend.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Knife4j OpenAPI3 配置
 */
@Configuration
public class Knife4jConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("用户管理系统接口文档")
                        .version("1.0")
                        .contact(new Contact().name("041"))
                        .description("接口文档"));
    }

    @Bean
    public GroupedOpenApi userApi() {
        return GroupedOpenApi.builder()
                .group("default")
                .packagesToScan("org.wobushi041.centerbackend.controller")
                .build();
    }
}
