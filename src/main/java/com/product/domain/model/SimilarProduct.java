package com.product.domain.model;

import com.product.infrastructure.entity.ProductDetailEntity;
import lombok.*;

import java.util.List;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class SimilarProduct {
    private  List<ProductDetail> details;
}