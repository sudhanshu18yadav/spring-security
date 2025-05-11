package com.example.demo;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class TypeController {

    // @Autowired
    // TypeRepository typeRepo;

    @GetMapping("/type/")
    public String helloWorld() {
        return "hello world";
    }

    // @PostMapping("/type/save")
    // public Type insert(@RequestParam("name") String name, @RequestParam("desc") String desc) {
    //     return typeRepo.save(new Type().setName(name).setDesc(desc));
    // }

    // @GetMapping("/type/all")
    // public List<Type> getAll() {
    //     return typeRepo.findAll();
    // }
}
