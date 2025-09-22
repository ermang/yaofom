package com.eg.yaecm.common;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Component
public class JwtUtil {
    private static final String SECRET = "this-is-a-32-byte-long-secret-key!!!"; // 32+ chars
    private final SecretKey key = Keys.hmacShaKeyFor(SECRET.getBytes(StandardCharsets.UTF_8));

    public JwtUtil() {
    }

    // Generate token
    public String generateToken(String username, YaofomRole yaofomRole, Long userId) {

        //return JwtBuilder.
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .claim("role", yaofomRole.getValue())
                .claim("userId", userId)
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // 1 hour expiration
                .signWith(SignatureAlgorithm.HS256,key)
                .compact();
    }

    // Extract username from token
    public String extractUsername(String token) {
        return extractClaims(token).getSubject();
    }

    // Validate token
    public boolean validateToken(String token, String username) {
        return (username.equals(extractUsername(token)) && !isTokenExpired(token));
    }

    // Check if token is expired
    private boolean isTokenExpired(String token) {
        return extractClaims(token).getExpiration().before(new Date());
    }

    // Extract claims (subject, expiration, etc.)
    public Claims extractClaims(String token) {
        JwtParser parser = Jwts.parser() // Updated for new version
                .setSigningKey(key) // Set the secret key for signing
                .build(); // Build the parser
        return parser.parseClaimsJws(token).getBody(); // Parse the claims
    }
}