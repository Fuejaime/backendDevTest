package com.product.domain;

import com.product.infrastructure.entity.SimilarProductEntity;

public interface ProductUseCase {
    SimilarProductEntity getSimilarProducts(String productId);
}
