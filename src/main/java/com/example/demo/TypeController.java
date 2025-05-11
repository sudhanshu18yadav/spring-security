package com.example.demo;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class TypeController {

    @Autowired
    TypeRepository typeRepo;

    @GetMapping("/type/")
    public String helloWorld() {
        return "hello world";
    }

    @PostMapping("/type/save")
    public Type insert(@RequestParam("name") String name, @RequestParam("description") String desc) {
        return typeRepo.save(new Type().setName(name).setDesc(desc));
    }

    @GetMapping("/type/all")
    public List<Type> getAll() {
        return typeRepo.findAll();
    }

    @GetMapping("/type/all-pro")
    public List<String> allPro(@RequestParam("name") String name) {
        return typeRepo.intoProductTable(name);
    }
}
