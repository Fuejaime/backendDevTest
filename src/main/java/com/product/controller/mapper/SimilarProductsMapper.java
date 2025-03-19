package com.product.controller.mapper;

import com.product.domain.model.SimilarProductDTO;
import com.product.infrastructure.entity.SimilarProducts;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SimilarProductsMapper {
    SimilarProductDTO areSimilarProductsDTO(SimilarProducts similarProducts);
}
