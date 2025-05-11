package com.example.demo;

import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class ProductController {

    @Autowired
    ProductRepository productRepo;

    @GetMapping("/")
    public String hello() {
        return "hello world";
    }

    @GetMapping("/all")
    public List<Product> getAllproduct() {
        return productRepo.findAll();
    }
    
}