package com.koehler.authserver.security;

import lombok.Getter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;

@Getter
@ToString
public class JwtAuthenticationConfig {

    @Value("${com.koehler.security.jwt.url:/login}")
    private String url;

    @Value("${com.koehler.security.jwt.header:Authorization}")
    private String header;

    @Value("${com.koehler.security.jwt.prefix:Bearer}")
    private String prefix;

    @Value("${com.koehler.security.jwt.expiration:#{30000}}")
    private int expiration;

    @Value("${com.koehler.security.jwt.secret}")
    private String secret;
}
