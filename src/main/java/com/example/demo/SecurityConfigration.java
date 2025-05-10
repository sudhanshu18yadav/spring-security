// package com.example.demo;

// import org.springframework.context.annotation.Bean;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.stereotype.Component;

// @Component
// @EnableWebSecurity
// public class SecurityConfigration {

//     @Bean
//     public String secure(HttpSecurity http) throws Exception{
//         System.out.println("it came here--------------");
//         http.authorizeHttpRequests((authorize)-> authorize.anyRequest().authenticated());
//         return "test";
//     }
// }
