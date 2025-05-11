package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;

    public Product(){}
    
    public Product (String _name, String _desc){
        this.name = _name;
        this.description = _desc;
    }
    public Product setId(int id) {
        this.id = id;
        return this;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Product setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return name;
    }

    public Product setDescription(String desc) {
        this.description = desc;
        return this;
    }
}
