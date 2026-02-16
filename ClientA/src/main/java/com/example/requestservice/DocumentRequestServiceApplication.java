package com.example.requestservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {
    "com.example.requestservice",
    "com.example.requestservice.controller",
    "com.example.requestservice.service"
})
public class DocumentRequestServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(DocumentRequestServiceApplication.class, args);
    }
}