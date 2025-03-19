package com.product.controller;

import com.product.controller.mapper.SimilarProductsMapper;
import com.product.domain.ProductUseCase;
import com.product.domain.model.SimilarProduct;
import com.product.infrastructure.entity.SimilarProducts;
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
    private final SimilarProductsMapper similarProductsMapper;

    @GetMapping(value="/product/{id}/similar")
    public ResponseEntity<SimilarProduct> getProductsById(final @PathVariable("id") String id) {

        SimilarProducts similarProducts = productsUseCase.getSimilarProducts(id);
        final SimilarProduct result = similarProductsMapper.areSimilarProductsDTO(similarProducts);

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}