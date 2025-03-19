package com.product.controller;

import com.product.controller.mapper.SimilarProductsMapper;
import com.product.domain.ProductUseCase;
import com.product.domain.model.ProductDetailDTO;
import com.product.domain.model.SimilarProductDTO;
import com.product.infrastructure.entity.SimilarProducts;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductControllerTest {

    @Mock
    private ProductUseCase productUseCase;

    @Mock
    private SimilarProductsMapper similarProductsMapper;

    @InjectMocks
    private ProductController productController;

    private SimilarProducts similarProducts;
    private SimilarProductDTO similarProductDTO;

    @BeforeEach
    void setUp() {
        similarProducts = SimilarProducts.builder()
                .details(List.of())
                .build();

        similarProductDTO = SimilarProductDTO.builder()
                .details(List.of(
                        ProductDetailDTO.builder()
                                .id("1")
                                .name("Product 1")
                                .price(100)
                                .availability(true)
                                .build(),
                        ProductDetailDTO.builder()
                                .id("2")
                                .name("Product 2")
                                .price(200)
                                .availability(false)
                                .build()
                ))
                .build();
    }

    @Test
    void getProductsById_ReturnsSimilarProductDTO() {
        // Arrange
        String productId = "1";
        when(productUseCase.provideSimilarProducts(productId)).thenReturn(similarProducts);
        when(similarProductsMapper.areSimilarProductsDTO(similarProducts)).thenReturn(similarProductDTO);

        // Act
        ResponseEntity<SimilarProductDTO> response = productController.getProductsById(productId);

        // Assert
        assertNotNull(response);
        assertEquals(200, response.getStatusCode().value());
        assertEquals(similarProductDTO, response.getBody());

        verify(productUseCase, times(1)).provideSimilarProducts(productId);
        verify(similarProductsMapper, times(1)).areSimilarProductsDTO(similarProducts);
    }
}