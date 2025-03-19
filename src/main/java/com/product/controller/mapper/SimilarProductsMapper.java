package com.product.controller.mapper;

import com.product.domain.model.SimilarProductDTO;
import com.product.infrastructure.entity.SimilarProducts;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)public interface SimilarProductsMapper {
    SimilarProductDTO asSimilarProductsDTO(SimilarProducts similarProducts);
}
