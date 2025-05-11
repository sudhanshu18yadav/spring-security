package com.example.demo;

import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableArgumentResolver;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class ProductController {

    @Autowired
    ProductRepository productRepo;

    @GetMapping("/")
    public String hello() {
        return "hello world";
    }

    @GetMapping("/all")
    public List<Product> getPagedData(@RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "id") String col,
            @RequestParam(defaultValue = "true") boolean asc) {

        Sort sort = asc ? Sort.by(Direction.ASC, col) : Sort.by(Direction.DESC, col);
        Pageable pageable = PageRequest.of(page, size, sort);

        return productRepo.findAll(pageable).toList();
    }
}