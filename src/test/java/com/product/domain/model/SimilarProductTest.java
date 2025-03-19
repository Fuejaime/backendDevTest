package com.product.domain.model;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;

class SimilarProductTest {

    @Test
    void testNoArgsConstructor() {
        SimilarProduct similarProduct = new SimilarProduct();
        assertThat(similarProduct).isNotNull();
        assertThat(similarProduct.getDetails()).isNull();
    }

    @Test
    void testAllArgsConstructor() {
        List<ProductDetail> details = List.of(
                new ProductDetail("1", "Product 1", 100, true),
                new ProductDetail("2", "Product 2", 200, false)
        );

        SimilarProduct similarProduct = new SimilarProduct(details);

        assertThat(similarProduct.getDetails()).isNotNull().hasSize(2);
        assertThat(similarProduct.getDetails().get(0).getId()).isEqualTo("1");
        assertThat(similarProduct.getDetails().get(1).getPrice()).isEqualTo(200);
    }

    @Test
    void testSettersAndGetters() {
        SimilarProduct similarProduct = new SimilarProduct();
        List<ProductDetail> details = List.of(new ProductDetail("3", "Product 3", 300, true));

        similarProduct.setDetails(details);

        assertThat(similarProduct.getDetails()).isNotNull().hasSize(1);
        assertThat(similarProduct.getDetails().get(0).getName()).isEqualTo("Product 3");
    }

    @Test
    void testBuilder() {
        List<ProductDetail> details = List.of(
                ProductDetail.builder().id("4").name("Product 4").price(400).availability(true).build()
        );

        SimilarProduct similarProduct = SimilarProduct.builder()
                .details(details)
                .build();

        assertThat(similarProduct.getDetails()).isNotNull().hasSize(1);
        assertThat(similarProduct.getDetails().get(0).getPrice()).isEqualTo(400);
    }
}
