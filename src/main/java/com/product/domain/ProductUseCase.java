package com.product.domain;

import com.product.domain.model.SimilarProductDTO;
import com.product.infrastructure.entity.SimilarProducts;

public interface ProductUseCase {
    SimilarProducts provideSimilarProducts(String productId);
}
