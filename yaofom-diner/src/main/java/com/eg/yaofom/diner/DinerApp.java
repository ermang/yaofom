package com.eg.yaofom.diner;

import com.eg.yaofom.common.JwtUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@Import(JwtUtil.class)
@SpringBootApplication
public class DinerApp {
    public static void main(String[] args) {
        SpringApplication.run(DinerApp.class, args);
    }
}