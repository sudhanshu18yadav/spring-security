package com.example.demo;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class ProductController {

    @GetMapping("/")
    public String hello() {
        return "hello world";
    }

    @GetMapping("/secret")
    public String secret() {
        return "secret hello world";
    }
    
}