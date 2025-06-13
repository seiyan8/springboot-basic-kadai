package com.example.springkadaitodo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authorize -> authorize
                .anyRequest().permitAll() // 全リクエストを許可
            )
            .csrf().disable() // フォームのCSRF対策が不要ならオフ
            .formLogin().disable(); // ログイン画面を無効化
        return http.build();
    }
}