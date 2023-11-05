package com.onur.mercadona.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

public interface WebSecurityConfigurer<T> {
    void configure(HttpSecurity http) throws Exception;
}
