package com.product.application.usecase;

import com.product.domain.ProductService;
import com.product.domain.ProductUseCase;
import com.product.infrastructure.entity.ProductDetail;
import com.product.infrastructure.entity.SimilarProducts;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ProductUseCaseImpl implements ProductUseCase {

    private final ProductService productService;

    @Override
    public SimilarProducts provideSimilarProducts(String productId){

        final List<Integer> similarIds = productService.provideSimilarIdListById(productId);

        final List<ProductDetail> details = similarIds.stream()
                .map(productSimilarId -> productService.provideDetailById(productSimilarId.toString()))
                .collect(Collectors.toList());

        return SimilarProducts.builder()
                .details(details)
                .build();
    }
}