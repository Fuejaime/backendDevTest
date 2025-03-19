package com.product.controller.mapper;

import com.product.domain.model.ProductDetail;
import com.product.domain.model.SimilarProduct;
import com.product.infrastructure.entity.ProductDetailEntity;
import com.product.infrastructure.entity.SimilarProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface SimilarProductMapper {

    SimilarProduct toDomain(SimilarProductEntity entity);

    ProductDetail toDomain(ProductDetailEntity entity);
}
