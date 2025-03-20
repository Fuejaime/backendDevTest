package com.product.controller.mapper;

import com.product.domain.model.ProductDetail;
import com.product.domain.model.SimilarProduct;
import com.product.infrastructure.entity.ProductDetailEntity;
import com.product.infrastructure.entity.SimilarProductEntity;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class SimilarProductMapper {

    public ProductDetail toProductDetail(ProductDetailEntity entity) {
        return ProductDetail.builder()
                .id(entity.getId())
                .name(entity.getName())
                .price(entity.getPrice())
                .availability(entity.getAvailability())
                .build();
    }

    public SimilarProduct toDomain(SimilarProductEntity entity) {
        return SimilarProduct.builder()
                .details(entity.getDetails().stream()
                        .map(this::toProductDetail)
                        .collect(Collectors.toList()))
                .build();
    }
}
