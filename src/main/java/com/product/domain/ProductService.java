package com.product.domain;

import com.product.infrastructure.entity.ProductDetailEntity;

import java.util.List;

public interface ProductService {
    ProductDetailEntity getDetailById(String productId);

    List<Integer> getSimilarIdListById(String productId);

}
