package com.example.demo;

import org.springframework.web.bind.annotation.RestController;

import jakarta.websocket.server.PathParam;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class ProductController {

    @Autowired
    ProductRepository productRepo;

    @GetMapping("/")
    public String hello() {
        return "hello world";
    }

    @GetMapping("/all-paged")
    public List<Product> getPagedData(@RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "id") String col,
            @RequestParam(defaultValue = "false") boolean asc) {

        Sort sort = asc ? Sort.by(Direction.ASC, col) : Sort.by(Direction.DESC, col);
        Pageable pageable = PageRequest.of(page, size, sort);

        return productRepo.findAll(pageable).toList();
    }

    @GetMapping("/get/all")
    public List<Product> getAllData() {
        return productRepo.findAll();
    }

    @PostMapping("/save/{id}")
    public Product save(@PathVariable int id) {
        Product product = new Product().setName(String.valueOf(id) + "name")
                .setDescription(String.valueOf(id) + "description");
        return productRepo.save(product);
    }

    @GetMapping("/get/{id}")
    public Product getFromId(@PathVariable int id) {
        var product = productRepo.getReferenceById(id);
        return product;
    }

    @PostMapping("/save")
    public Product MultiParamTest(@PathParam(value = "name") String name, @PathParam(value = "desc") String desc) {
        return productRepo.save(new Product().setName(name).setDescription(desc));
    }

    @GetMapping("/get-all-by-name")
    public List<Product> GetllByName(@RequestParam(value = "name") String name) {
        return productRepo.findAllByName(name);
    }
    
    @GetMapping("/greater-than")
    public List<String> GreaterThan() {
        return productRepo.findAllIdGreaterThan50();
    }
    
}