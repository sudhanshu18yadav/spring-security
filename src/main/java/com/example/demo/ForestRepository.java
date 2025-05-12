package com.example.demo;

import org.hibernate.StatelessSession;
import org.hibernate.annotations.processing.Find;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ForestRepository extends JpaRepository<Forest, Integer> {

    @Find
    Forest animal(String animal);
}
