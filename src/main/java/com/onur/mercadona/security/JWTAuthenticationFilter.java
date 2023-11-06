package com.onur.mercadona.security;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.ServletRequestPathFilter;

@Component
public class JWTAuthenticationFilter extends ServletRequestPathFilter {
}
