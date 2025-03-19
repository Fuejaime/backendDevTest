package com.product.infrastructure.adapter;

import com.product.infrastructure.adapter.response.MockClientResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class MockClientImplTest {

    @Mock
    private WebClient.Builder webClientBuilder;

    @Mock
    private WebClient webClient;

    @Mock
    private WebClient.RequestHeadersUriSpec requestHeadersUriSpec;

    @Mock
    private WebClient.RequestBodySpec requestBodySpec;

    @Mock
    private WebClient.ResponseSpec responseSpec;

    private MockClientImpl mockClientImpl;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        when(webClientBuilder.build()).thenReturn(webClient);
        when(webClient.get()).thenReturn(requestHeadersUriSpec);
        when(requestHeadersUriSpec.uri(anyString())).thenReturn(requestBodySpec);
        when(requestBodySpec.retrieve()).thenReturn(responseSpec);
    }

    @Test
    void testFindProductDetail() {
        String productId = "12345";
        MockClientResponse mockResponse = new MockClientResponse();
        mockResponse.setId(productId);
        mockResponse.setName("Product Name");

        when(responseSpec.bodyToMono(MockClientResponse.class)).thenReturn(Mono.just(mockResponse));

        mockClientImpl = new MockClientImpl(webClientBuilder);

        MockClientResponse response = mockClientImpl.findProductDetail(productId);

        assertNotNull(response);
        assertEquals(productId, response.getId());
        assertEquals("Product Name", response.getName());
    }

    @Test
    void testFindSimilarIds() {
        String productId = "12345";
        List<Integer> similarIds = List.of(1, 2, 3);

        when(responseSpec.bodyToMono(new ParameterizedTypeReference<List<Integer>>() {}))
                .thenReturn(Mono.just(similarIds));

        mockClientImpl = new MockClientImpl(webClientBuilder);

        List<Integer> result = mockClientImpl.findSimilarIds(productId);

        assertNotNull(result);
        assertEquals(3, result.size());
        assertTrue(result.contains(1));
        assertTrue(result.contains(2));
        assertTrue(result.contains(3));
    }
}
