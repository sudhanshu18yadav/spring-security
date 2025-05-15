package com.example.demo;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.hibernate.StatelessSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class ForestController { 

    @Autowired
    ForestRepository forestRepo;

    @GetMapping("/forest")
    public String helloworld() {
        return "hello from forest";
    }

    @GetMapping("/forest/all")
    public List<Forest> forestTesting() {
        return forestRepo.findAll();
    }

    @GetMapping("/forest/test")
    public Forest testing(@RequestParam("animal") String param) {
        return forestRepo.animal(param);
    }
    
}
