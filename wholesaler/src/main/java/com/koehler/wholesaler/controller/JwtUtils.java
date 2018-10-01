package com.koehler.wholesaler.controller;

import com.auth0.jwt.JWT;

public class JwtUtils {

    public static String getUserId(String token) {
        if (token == null) {
            return null;
        }

        return JWT.decode(token.replace("Bearer", "")).getClaim("userId").asString();
    }
}
