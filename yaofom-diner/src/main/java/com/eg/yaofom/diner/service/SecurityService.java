package com.eg.yaofom.diner.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class SecurityService {

    public Authentication getAuthentication() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication;
    }

    public Long getUserId() {
        Long userId = (Long) SecurityContextHolder.getContext().getAuthentication().getDetails();
        return userId;
    }
}
