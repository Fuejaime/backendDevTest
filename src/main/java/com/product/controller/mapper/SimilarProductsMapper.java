package com.product.controller.mapper;

import com.product.domain.model.SimilarProduct;
import com.product.infrastructure.entity.SimilarProducts;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SimilarProductsMapper {
    SimilarProduct areSimilarProductsDTO(SimilarProducts similarProducts);
}
