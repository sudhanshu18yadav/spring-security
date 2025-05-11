package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class JournalService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void insertData() {
        System.out.println("DATA INSERTION HAS STARTED----------------------------------");
        jdbcTemplate.execute("DROP TABLE Product IF EXISTS");
        jdbcTemplate.execute("CREATE TABLE Product (id SERIAL, name varchar(255), description varchar(255))");
        jdbcTemplate.execute("Insert into Product values (1, 'pro-1', 'desc-1')");
        jdbcTemplate.execute("Insert into Product values (2, 'pro-19', 'desc-2')");
        jdbcTemplate.execute("Insert into Product values (3, 'pro-12', 'desc-3')");
        jdbcTemplate.execute("Insert into Product values (4, 'pro-112', 'desc-4')");
        jdbcTemplate.execute("Insert into Product values (5, 'pro-1543', 'desc-5')");
        jdbcTemplate.execute("Insert into Product values (6, 'pro-176', 'desc-7')");
        jdbcTemplate.execute("Insert into Product values (7, 'pro-178', 'desc-8')");
        jdbcTemplate.execute("Insert into Product values (8, 'pro-923', 'desc-9')");
        jdbcTemplate.execute("Insert into Product values (9, 'pro-10', 'desc-10')");
        jdbcTemplate.execute("Insert into Product values (10, 'pro-11', 'desc-11')");
        System.out.println("DATA INSERTION HAS ENDED----------------------------------");
    }
}
