package com.kdu.smartHome.utility;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

public class JwtTokenGenerator{


    public static String generatJwtToken(String username){

        final String JWT_KEY = "jxgEQeXHuPq8VdbyYFNkANdudQ53YUn4";

        SecretKey key = Keys.hmacShaKeyFor(JWT_KEY.getBytes(StandardCharsets.UTF_8));
        return Jwts.builder().issuer("kdu").subject("JWT Token")
                .claim("username", username)
                .issuedAt(new Date())
                .expiration(new Date((new Date()).getTime() + 846000000))
                .signWith(key).compact();
    }
}
