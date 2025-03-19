package com.product.infrastructure.entity;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder(toBuilder = true)
public class SimilarProducts {
    public final List<ProductDetail> details;
}

