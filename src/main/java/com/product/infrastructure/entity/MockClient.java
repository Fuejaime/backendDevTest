package com.product.infrastructure.entity;

import com.product.infrastructure.entity.response.MockClientResponse;

import java.util.List;

public interface MockClient {
    MockClientResponse findProductDetail(String productId);

    List<Integer> findSimilarIds(String productId);
}
