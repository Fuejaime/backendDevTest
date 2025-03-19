package com.product.domain.model;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

class SimilarProductDTOTest {

    @Test
    void testBuilderAndGetters() {
        // Arrange & Act
        SimilarProductDTO similarProductDTO = SimilarProductDTO.builder()
                .details(List.of(
                        new ProductDetailDTO("1", "Product 1", 100, true),
                        new ProductDetailDTO("2", "Product 2", 200, false)
                ))
                .build();

        // Assert
        assertThat(similarProductDTO.getDetails()).isNotNull();
        assertThat(similarProductDTO.getDetails()).hasSize(2);
        assertThat(similarProductDTO.getDetails().get(0).getId()).isEqualTo("1");
        assertThat(similarProductDTO.getDetails().get(1).getPrice()).isEqualTo(200);
    }

    @Test
    void testNoArgsConstructor() {
        // Act
        SimilarProductDTO similarProductDTO = new SimilarProductDTO();

        // Assert
        assertThat(similarProductDTO).isNotNull();
        assertThat(similarProductDTO.getDetails()).isNull();
    }

    @Test
    void testAllArgsConstructor() {
        // Arrange
        List<ProductDetailDTO> details = List.of(
                new ProductDetailDTO("1", "Product 1", 100, true)
        );

        // Act
        SimilarProductDTO similarProductDTO = new SimilarProductDTO(details);

        // Assert
        assertThat(similarProductDTO.getDetails()).isNotNull();
        assertThat(similarProductDTO.getDetails()).hasSize(1);
        assertThat(similarProductDTO.getDetails().getFirst().getName()).isEqualTo("Product 1");
    }

    @Test
    void testToBuilder() {
        // Arrange
        SimilarProductDTO original = SimilarProductDTO.builder()
                .details(List.of(
                        new ProductDetailDTO("1", "Product 1", 100, true)
                ))
                .build();

        // Act
        SimilarProductDTO modified = original.toBuilder()
                .details(List.of(
                        new ProductDetailDTO("2", "Product 2", 200, false)
                ))
                .build();

        // Assert
        assertThat(modified.getDetails()).isNotNull();
        assertThat(modified.getDetails()).hasSize(1);
        assertThat(modified.getDetails().getFirst().getId()).isEqualTo("2");
        assertThat(modified.getDetails().getFirst().getPrice()).isEqualTo(200);
    }
}