package com.product.domain;

import com.product.infrastructure.entity.SimilarProducts;

public interface ProductUseCase {
    SimilarProducts getSimilarProducts(String productId);
}
