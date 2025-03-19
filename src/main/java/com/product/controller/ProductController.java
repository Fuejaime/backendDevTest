package com.product.controller;

import com.product.controller.mapper.SimilarProductMapper;
import com.product.domain.ProductUseCase;
import com.product.domain.model.SimilarProduct;
import com.product.infrastructure.entity.SimilarProductEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductUseCase productsUseCase;
    private final SimilarProductMapper similarProductsMapper;

    @GetMapping(value="/product/{id}/similar")
    public ResponseEntity<SimilarProduct> getProductsById(final @PathVariable("id") String id) {
        return ResponseEntity.status(HttpStatus.OK).body(similarProductsMapper.toDomain(productsUseCase.getSimilarProducts(id)));
    }
}