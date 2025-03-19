package com.product.application.usecase;

import com.product.domain.ProductService;
import com.product.domain.ProductUseCase;
import com.product.infrastructure.entity.ProductDetailEntity;
import com.product.infrastructure.entity.SimilarProductEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ProductUseCaseImpl implements ProductUseCase {

    private final ProductService productService;

    @Override
    public SimilarProductEntity getSimilarProducts(String productId){

        final List<Integer> similarIds = productService.getSimilarIdListById(productId);

        final List<ProductDetailEntity> details = similarIds.stream()
                .map(productSimilarId -> productService.getDetailById(productSimilarId.toString()))
                .collect(Collectors.toList());

        return SimilarProductEntity.builder()
                .details(details)
                .build();
    }
}