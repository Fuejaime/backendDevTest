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

        SimilarProductEntity similarProducts = productsUseCase.getSimilarProducts(id);
        /*SimilarProduct result = SimilarProduct.builder()
                .details(similarProducts.getDetails().stream()
                        .map(productDetailEntity -> ProductDetail.builder()
                                .id(productDetailEntity.getId()) // Asume que ProductDetail tiene un builder
                                .name(productDetailEntity.getName()) // Asume que ProductDetail tiene estos campos
                                .price(productDetailEntity.getPrice())
                                .availability(productDetailEntity.getAvailability())
                                // Mapear más campos según sea necesario
                                .build())
                        .collect(Collectors.toList()))
                .build();*/
        final SimilarProduct result = (similarProductsMapper.toDomain(similarProducts));
        System.out.println("result: " + result);
        System.out.println("similarProducts: " + similarProducts);

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}