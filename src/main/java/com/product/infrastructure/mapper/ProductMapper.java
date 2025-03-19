package com.product.infrastructure.mapper;

import com.product.infrastructure.entity.ProductDetailEntity;
import com.product.infrastructure.adapter.response.MockClientResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductDetailEntity asProductDetail(MockClientResponse mockClientResponse);
}
