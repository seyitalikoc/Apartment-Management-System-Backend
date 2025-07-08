package com.seyitkoc.common.security;

import com.seyitkoc.entity.Auth;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

@Service
public class JwtTokenService {
    private final Set<String> blacklistedTokens = ConcurrentHashMap.newKeySet();

    public String findEmailFromToken(String token) {
        return exportToken(token, Claims::getSubject);
    }

    public <T> T exportToken (String token, Function<Claims, T> claimsResolver) {
        final Claims claims = Jwts.parserBuilder()
                .setSigningKey(getKey()).build().parseClaimsJws(token).getBody();
        return claimsResolver.apply(claims);
    }

    public boolean tokenControl(String token, UserDetails userDetails) {
        String email = findEmailFromToken(token);
        return email.equals(userDetails.getUsername()) && new Date().before(exportToken(token, Claims::getExpiration));
    }

    public String generateToken (UserDetails userDetails) {
        final long expirationTime = 2 * 60 * 60 * 1000; // 2 hours
        Map<String, Object> claims = new HashMap<>();
        claims.put("role", ((Auth) userDetails).getRole().name());

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
                .signWith(getKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public Key getKey(){
        String secretKey = "e9b3f7b877a84d6e945e3c4a1a2c8e37e1c4a0f0d4e3f9a6b2c7d8e9f0a1b2c3";
        byte[] key = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(key);
    }

    public void blacklistToken(String token) {
        blacklistedTokens.add(token);
    }
    public boolean isTokenBlacklisted(String token) {
        return blacklistedTokens.contains(token);
    }

}
