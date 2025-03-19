package com.product.controller.mapper;

import com.product.domain.model.SimilarProductDTO;
import com.product.infrastructure.entity.ProductDetail;
import com.product.infrastructure.entity.SimilarProducts;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class SimilarProductsMapperTest {

    private final SimilarProductsMapper mapper = Mappers.getMapper(SimilarProductsMapper.class);

    @Test
    void testAreSimilarProductsDTO() {
        // Given:
        SimilarProducts product = createSimilarProduct();

        // When:
        SimilarProductDTO dto = mapper.areSimilarProductsDTO(product);

        // Then:
        assertNotNull(dto, "The mapped object should not be null");
        assertEquals(product.getDetails().size(), dto.getDetails().size(), "The size of the details should be the same");
        assertEquals(product.getDetails().getFirst().getId(), dto.getDetails().getFirst().getId(), "The id of the details should be the same");
        assertEquals(product.getDetails().getFirst().getName(), dto.getDetails().getFirst().getName(), "The name of the details should be the same");
        assertEquals(product.getDetails().getFirst().getPrice(), dto.getDetails().getFirst().getPrice(), "The price of the details should be the same");
        assertEquals(product.getDetails().getFirst().getAvailability(), dto.getDetails().getFirst().getAvailability(), "The availability of the details should be the same");

    }

    public SimilarProducts createSimilarProduct() {
        return SimilarProducts.builder()
                .details(List.of(new ProductDetail("1", "Product A", 100, true)))
                .build();
    }
}