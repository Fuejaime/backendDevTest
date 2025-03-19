package com.product.infrastructure.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class ProductDetailEntity {
    private final String id;
    private final String name;
    private final Integer price;
    private final Boolean availability;
}
