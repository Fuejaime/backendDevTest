package com.product.domain;

import com.product.infrastructure.entity.ProductDetail;

import java.util.List;

public interface ProductService {
    ProductDetail provideDetailById(String productId);
    List<Integer> provideSimilarIdListById(String productId);

}
