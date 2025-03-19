package com.product.infrastructure.entity;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder(toBuilder = true)
public class SimilarProducts {
    private final List<ProductDetail> details;
}
