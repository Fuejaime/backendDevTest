package com.product.infrastructure.mapper;

import com.product.infrastructure.entity.ProductDetailEntity;
import com.product.infrastructure.adapter.response.MockClientResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface ProductMapper {

    ProductDetailEntity asProductDetail(MockClientResponse mockClientResponse);
}
