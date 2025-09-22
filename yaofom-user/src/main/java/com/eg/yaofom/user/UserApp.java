package com.eg.yaofom.user;

import com.eg.yaecm.common.JwtAuthFilter;
import com.eg.yaecm.common.JwtUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@Import(JwtUtil.class)
@SpringBootApplication
public class UserApp {
    public static void main(String[] args) {
        SpringApplication.run(UserApp.class, args);
    }
}