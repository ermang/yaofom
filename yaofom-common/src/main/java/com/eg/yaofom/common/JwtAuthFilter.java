package com.eg.yaofom.common;


import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;


public class JwtAuthFilter extends OncePerRequestFilter {
    private JwtUtil jwtUtil = new JwtUtil();

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = getJwtFromRequest(request);
        if (token != null && jwtUtil.validateToken(token, getUsernameFromToken(token))) {
            String yaecmRole = jwtUtil.extractClaims(token).get("role", String.class);
            SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + yaecmRole);
            Long userId = jwtUtil.extractClaims(token).get("userId", Long.class);

            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(getUsernameFromToken(token), null,
                    Collections.singletonList(authority));
            authentication.setDetails(userId);
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        filterChain.doFilter(request, response);
    }

    private String getJwtFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }

    private String getUsernameFromToken(String token) {
        return jwtUtil.extractUsername(token);
    }
}