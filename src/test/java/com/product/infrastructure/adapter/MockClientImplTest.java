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
        // Inicializa los mocks
        MockitoAnnotations.openMocks(this);

        // Simula que el webClientBuilder devuelve un webClient simulado
        when(webClientBuilder.build()).thenReturn(webClient);

        // Simula la llamada al método get()
        when(webClient.get()).thenReturn(requestHeadersUriSpec);

        // Simula la llamada al método uri()
        when(requestHeadersUriSpec.uri(anyString())).thenReturn(requestBodySpec);

        // Simula la llamada al método retrieve()
        when(requestBodySpec.retrieve()).thenReturn(responseSpec);
    }

    @Test
    void testFindProductDetail() {
        // Datos de entrada y respuesta esperada
        String productId = "12345";
        MockClientResponse mockResponse = new MockClientResponse();
        mockResponse.setId(productId);
        mockResponse.setName("Product Name");

        // Simulamos la respuesta del cuerpo como un Mono
        when(responseSpec.bodyToMono(MockClientResponse.class)).thenReturn(Mono.just(mockResponse));

        // Creamos la instancia de MockClientImpl
        mockClientImpl = new MockClientImpl(webClientBuilder);

        // Llamamos al método que queremos probar
        MockClientResponse response = mockClientImpl.findProductDetail(productId);

        // Verificamos los resultados
        assertNotNull(response);
        assertEquals(productId, response.getId());
        assertEquals("Product Name", response.getName());
    }

    @Test
    void testFindSimilarIds() {
        // Datos de entrada y respuesta esperada
        String productId = "12345";
        List<Integer> similarIds = List.of(1, 2, 3);

        // Simulamos la respuesta del cuerpo como un Mono
        when(responseSpec.bodyToMono(new ParameterizedTypeReference<List<Integer>>() {}))
                .thenReturn(Mono.just(similarIds));

        // Creamos la instancia de MockClientImpl
        mockClientImpl = new MockClientImpl(webClientBuilder);

        // Llamamos al método que queremos probar
        List<Integer> result = mockClientImpl.findSimilarIds(productId);

        // Verificamos los resultados
        assertNotNull(result);
        assertEquals(3, result.size());
        assertTrue(result.contains(1));
        assertTrue(result.contains(2));
        assertTrue(result.contains(3));
    }
}
