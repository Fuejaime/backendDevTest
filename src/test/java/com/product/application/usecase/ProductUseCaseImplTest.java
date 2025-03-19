package com.product.application.usecase;

import com.product.domain.ProductService;
import com.product.infrastructure.entity.ProductDetailEntity;
import com.product.infrastructure.entity.SimilarProductEntity;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
class ProductUseCaseImplTest {

    @Mock
    private ProductService productService;

    @InjectMocks
    private ProductUseCaseImpl productsUseCase;
    final private static String PRODUCT_ID = "1";

    @Nested
    class ProvideSimilarProducts{
        @Test
        void when_provideSimilarProductsCallServices_then_returnCorrectResponses(){
            Result data = getResult();
            when(productService.getSimilarIdListById(PRODUCT_ID)).thenReturn(data.similarIds());
            when(productService.getDetailById(anyString())).thenReturn(data.detail());

            final SimilarProductEntity result = productsUseCase.getSimilarProducts(PRODUCT_ID);
            final SimilarProductEntity expectedResult = SimilarProductEntity.builder().details(List.of(data.detail(), data.detail(), data.detail(), data.detail())).build();

            assertThat(result).isEqualTo(expectedResult);
            verify(productService, times(4)).getDetailById(anyString());
        }

        private static Result getResult() {
            final List<Integer> similarIds = List.of(1,2,3,4);
            final ProductDetailEntity detail = ProductDetailEntity.builder()
                    .id("5")
                    .name("Product")
                    .price(10)
                    .availability(true)
                    .build();
            return new Result(similarIds, detail);
        }

        private record Result(List<Integer> similarIds, ProductDetailEntity detail) {
        }
    }
}

