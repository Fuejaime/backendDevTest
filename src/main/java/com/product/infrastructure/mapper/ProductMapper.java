package com.product.infrastructure.mapper;

import com.product.infrastructure.entity.ProductDetailEntity;
import com.product.infrastructure.adapter.response.MockClientResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public ProductDetailEntity asProductDetail(MockClientResponse mockClientResponse) {
        return ProductDetailEntity.builder()
                .id(mockClientResponse.getId())
                .name(mockClientResponse.getName())
                .price(mockClientResponse.getPrice())
                .availability(mockClientResponse.getAvailability())
                .build();
    }
}
