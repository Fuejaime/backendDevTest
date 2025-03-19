package com.product.controller.mapper;

import com.product.domain.model.SimilarProduct;
import com.product.infrastructure.entity.SimilarProductEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SimilarProductMapper {

    SimilarProduct toDomain(SimilarProductEntity entity);
}
