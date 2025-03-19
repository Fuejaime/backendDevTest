package com.product.domain.model;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;

class SimilarProductDTOTest {

    @Test
    void testNoArgsConstructor() {
        SimilarProductDTO similarProductDTO = new SimilarProductDTO();
        assertThat(similarProductDTO).isNotNull();
        assertThat(similarProductDTO.getDetails()).isNull();
    }

    @Test
    void testAllArgsConstructor() {
        List<ProductDetailDTO> details = List.of(
                new ProductDetailDTO("1", "Product 1", 100, true),
                new ProductDetailDTO("2", "Product 2", 200, false)
        );

        SimilarProductDTO similarProductDTO = new SimilarProductDTO(details);

        assertThat(similarProductDTO.getDetails()).isNotNull().hasSize(2);
        assertThat(similarProductDTO.getDetails().get(0).getId()).isEqualTo("1");
        assertThat(similarProductDTO.getDetails().get(1).getPrice()).isEqualTo(200);
    }

    @Test
    void testSettersAndGetters() {
        SimilarProductDTO similarProductDTO = new SimilarProductDTO();
        List<ProductDetailDTO> details = List.of(new ProductDetailDTO("3", "Product 3", 300, true));

        similarProductDTO.setDetails(details);

        assertThat(similarProductDTO.getDetails()).isNotNull().hasSize(1);
        assertThat(similarProductDTO.getDetails().get(0).getName()).isEqualTo("Product 3");
    }

    @Test
    void testBuilder() {
        List<ProductDetailDTO> details = List.of(
                ProductDetailDTO.builder().id("4").name("Product 4").price(400).availability(true).build()
        );

        SimilarProductDTO similarProductDTO = SimilarProductDTO.builder()
                .details(details)
                .build();

        assertThat(similarProductDTO.getDetails()).isNotNull().hasSize(1);
        assertThat(similarProductDTO.getDetails().get(0).getPrice()).isEqualTo(400);
    }
}
