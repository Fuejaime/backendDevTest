package com.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.product")
public class MainApplication {


    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
        System.out.println("Hello World");
    }
}
