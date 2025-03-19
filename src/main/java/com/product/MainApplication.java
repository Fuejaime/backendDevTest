package com.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.product", "com.product.infrastructure.mapper", "com.product.controller.mapper"})

public class MainApplication {


    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
        System.out.println("Hello World");
    }
}
