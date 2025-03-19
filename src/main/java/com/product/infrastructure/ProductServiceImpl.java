package com.product.infrastructure;

import com.product.domain.ProductService;
import com.product.infrastructure.adapter.MockClient;
import com.product.infrastructure.adapter.response.MockClientResponse;
import com.product.infrastructure.entity.ProductDetailEntity;
import com.product.infrastructure.mapper.ProductMapper;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final MockClient mockClient;
    private final ProductMapper productMapper;

    private static final String PRODUCT_SERVICE = "productService"; // Nombre del circuito

    @Override
    @CircuitBreaker(name = PRODUCT_SERVICE, fallbackMethod = "fallbackGetDetailById")
    public ProductDetailEntity getDetailById(String productId) {
        final MockClientResponse mockClientResponse = mockClient.findProductDetail(productId);
        return productMapper.asProductDetail(mockClientResponse);
    }

    @Override
    @CircuitBreaker(name = PRODUCT_SERVICE, fallbackMethod = "fallbackGetSimilarIdListById")
    public List<Integer> getSimilarIdListById(String productId) {
        return mockClient.findSimilarIds(productId);
    }

    public ProductDetailEntity fallbackGetDetailById(String productId, Throwable throwable) {
        log.error("Fallo en la obtención del detalle del producto con ID: {}. Error: {}", productId, throwable.getMessage());
        return new ProductDetailEntity();
    }

    public List<Integer> fallbackGetSimilarIdListById(String productId, Throwable throwable) {
        log.error("Fallo al obtener la lista de ID similares para el producto con ID: {}. Error: {}", productId, throwable.getMessage());
        return List.of();
    }
}
