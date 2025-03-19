package com.product.infrastructure.mapper;

import com.product.infrastructure.entity.ProductDetail;
import com.product.infrastructure.entity.response.MockClientResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface ProductMapper {
    ProductDetail asProductDetail(MockClientResponse mockClientResponse);
}
