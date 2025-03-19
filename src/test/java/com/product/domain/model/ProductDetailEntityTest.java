package com.product.domain.model;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class ProductDetailEntityTest {

    @Test
    void testNoArgsConstructor() {
        ProductDetail product = new ProductDetail();
        assertThat(product).isNotNull();
    }

    @Test
    void testAllArgsConstructor() {
        ProductDetail product = new ProductDetail("1", "Product 1", 100, true);

        assertThat(product.getId()).isEqualTo("1");
        assertThat(product.getName()).isEqualTo("Product 1");
        assertThat(product.getPrice()).isEqualTo(100);
        assertThat(product.getAvailability()).isTrue();
    }

    @Test
    void testSettersAndGetters() {
        ProductDetail product = new ProductDetail();
        product.setId("2");
        product.setName("Product 2");
        product.setPrice(200);
        product.setAvailability(false);

        assertThat(product.getId()).isEqualTo("2");
        assertThat(product.getName()).isEqualTo("Product 2");
        assertThat(product.getPrice()).isEqualTo(200);
        assertThat(product.getAvailability()).isFalse();
    }

    @Test
    void testBuilder() {
        ProductDetail product = ProductDetail.builder()
                .id("3")
                .name("Product 3")
                .price(300)
                .availability(true)
                .build();

        assertThat(product.getId()).isEqualTo("3");
        assertThat(product.getName()).isEqualTo("Product 3");
        assertThat(product.getPrice()).isEqualTo(300);
        assertThat(product.getAvailability()).isTrue();
    }

    @Test
    void testEqualsAndHashCode() {
        ProductDetail product1 = new ProductDetail("4", "Product 4", 400, true);
        ProductDetail product2 = new ProductDetail("4", "Product 4", 400, true);

        assertThat(product1).isEqualTo(product2);
        assertThat(product1.hashCode()).isEqualTo(product2.hashCode());
    }
}