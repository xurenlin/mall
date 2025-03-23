package com.xrl.mall.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

/***
 *@title SecurityConfig
 *@description <TODO description class purpose>
 *@author xrl
 *@version 1.0.0
 *@create 2025/3/21 21:49
 **/
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(authorize -> authorize
                        // 放行 Springfox Swagger 相关端点
                        .requestMatchers(
                                "/swagger-ui.html",    // Swagger UI 主页面（旧路径）
                                "/swagger-ui/**",      // Swagger UI 资源
                                "/v3/api-docs/**",     // OpenAPI JSON 文档
                                "/webjars/**"          // WebJars 静态资源
                        ).permitAll()
                        // 其他请求需认证
                        .anyRequest().authenticated()
                )
                .csrf(AbstractHttpConfigurer::disable); // 禁用 CSRF（适用于无状态 API）
        return http.build();
    }
}
