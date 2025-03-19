package com.product.infrastructure.adapter;

import com.product.infrastructure.adapter.response.MockClientResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MockClientImpl implements MockClient {

    private final WebClient.Builder webClientBuilder;

    private final static String BASE_URL = "http://localhost:3001/product/%s";
    private final static String SIMILAR_ID_URL = BASE_URL.concat("/similarids");

    @Override
    public MockClientResponse findProductDetail(String productId){
        final String url = String.format(BASE_URL, productId);
        return webClientBuilder.build()
                .get()
                .uri(url)
                .retrieve()
                .bodyToMono(MockClientResponse.class)
                .block();
    }

    @Override
    public List<Integer> findSimilarIds(String productId){
        final String url = String.format(SIMILAR_ID_URL, productId);
        return webClientBuilder.build()
                .get()
                .uri(url)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Integer>>() {})
                .block();
    }
}