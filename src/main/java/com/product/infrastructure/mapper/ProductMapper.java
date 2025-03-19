package com.product.infrastructure.mapper;

import com.product.infrastructure.entity.ProductDetailEntity;
import com.product.infrastructure.adapter.response.MockClientResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductDetailEntity asProductDetail(MockClientResponse mockClientResponse);
}
