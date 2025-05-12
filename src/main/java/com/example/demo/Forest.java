package com.example.demo;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Forest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String animal;

    public Integer getId() {
        return this.id;
    }

    public Forest setAnimal(String _animal) {
        this.animal = _animal;
        return this;
    }

    public String getAnimal() {
        return this.animal;
    }
}
