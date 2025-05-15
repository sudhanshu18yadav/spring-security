package com.example.demo;

import org.hibernate.StatelessSession;
import org.hibernate.annotations.processing.Find;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ForestRepository extends JpaRepository<Forest, Integer> {
    StatelessSession session();

    @Find
    Forest animal(String animal);

    // default void sess(){
    // System.out.println(session().isConnected() + "--"+ session().isOpen());
    // }

}
