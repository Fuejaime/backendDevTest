package com.product.domain.model;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class ProductDetailDTOTest {

    @Test
    void testBuilderAndGetters() {
        // Arrange & Act
        ProductDetailDTO product = ProductDetailDTO.builder()
                .id("1")
                .name("Product 1")
                .price(100)
                .availability(true)
                .build();

        // Assert
        assertThat(product.getId()).isEqualTo("1");
        assertThat(product.getName()).isEqualTo("Product 1");
        assertThat(product.getPrice()).isEqualTo(100);
        assertThat(product.getAvailability()).isTrue();
    }

    @Test
    void testNoArgsConstructor() {
        // Act
        ProductDetailDTO product = new ProductDetailDTO();

        // Assert
        assertThat(product).isNotNull();
        assertThat(product.getId()).isNull();
        assertThat(product.getName()).isNull();
        assertThat(product.getPrice()).isNull();
        assertThat(product.getAvailability()).isNull();
    }

    @Test
    void testAllArgsConstructor() {
        // Arrange & Act
        ProductDetailDTO product = new ProductDetailDTO("2", "Product 2", 200, false);

        // Assert
        assertThat(product.getId()).isEqualTo("2");
        assertThat(product.getName()).isEqualTo("Product 2");
        assertThat(product.getPrice()).isEqualTo(200);
        assertThat(product.getAvailability()).isFalse();
    }

    @Test
    void testToBuilder() {
        // Arrange
        ProductDetailDTO original = ProductDetailDTO.builder()
                .id("3")
                .name("Original Product")
                .price(300)
                .availability(true)
                .build();

        // Act
        ProductDetailDTO modified = original.toBuilder()
                .name("Modified Product")
                .price(400)
                .build();

        // Assert
        assertThat(modified.getId()).isEqualTo("3");
        assertThat(modified.getName()).isEqualTo("Modified Product");
        assertThat(modified.getPrice()).isEqualTo(400);
        assertThat(modified.getAvailability()).isTrue();
    }
}