package com.product.infrastructure.mapper;

import com.product.infrastructure.entity.ProductDetailEntity;
import com.product.infrastructure.adapter.response.MockClientResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductDetailEntity asProductDetail(MockClientResponse mockClientResponse);
}
