package com.example.htw.berlin.webtech.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        System.out.println(new Application().greetings());
    }

    public String greetings(){
        return "Hello World!";
    }
}
