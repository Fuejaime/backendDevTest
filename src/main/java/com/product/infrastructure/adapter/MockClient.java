package com.product.infrastructure.adapter;

import com.product.infrastructure.adapter.response.MockClientResponse;

import java.util.List;

public interface MockClient {
    MockClientResponse findProductDetail(String productId);

    List<Integer> findSimilarIds(String productId);
}
