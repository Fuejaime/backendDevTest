package com.product.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.web.reactive.function.client.WebClient;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = AppConfig.class)
class AppConfigTest {

    @Autowired
    private ApplicationContext context;

    @Test
    void webClientBuilderBeanShouldBeCreated() {
        WebClient.Builder webClientBuilder = context.getBean(WebClient.Builder.class);

        assertNotNull(webClientBuilder, "The bean WebClient.Builder should exist");
    }
}
