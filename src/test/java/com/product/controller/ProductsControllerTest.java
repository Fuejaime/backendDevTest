package com.product.controller;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;


import com.product.domain.ProductUseCase;
import com.product.infrastructure.entity.ProductDetailEntity;
import com.product.infrastructure.entity.SimilarProductEntity;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ProductsControllerTest {
    @Mock
    private ProductUseCase productsUseCase;
    @Mock
    private com.product.controller.mapper.SimilarProductMapper similarProductsMapper;
    @InjectMocks
    private ProductController productsController;
    final private static String PRODUCT_ID = "1";
    @Nested
    class GetProductsById{
        @Test
        void when_getProductsByIdCallIsSuccessful_then_returnOKResponseEntity(){
            final SimilarProductEntity similarProducts = SimilarProductEntity.builder()
                    .details(List.of(ProductDetailEntity.builder()
                            .id(PRODUCT_ID)
                            .name("name")
                            .price(100)
                            .availability(true)
                            .build()))
                    .build();

            when(productsUseCase.getSimilarProducts(PRODUCT_ID)).thenReturn(similarProducts);
            productsController.getProductsById(PRODUCT_ID);
            verify(similarProductsMapper).toDomain(similarProducts);
        }
    }
}