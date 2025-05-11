package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Type {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;

    public String getName() {
        return this.name;
    }

    public Integer getId() {
        return this.id;
    }

    public Type setName(String _name) {
        this.name = _name;
        return this;
    }

    public Type setDesc(String _desc) {
        this.description = _desc;
        return this;
    }

    public String getDesc() {
        return this.description;
    }
}
