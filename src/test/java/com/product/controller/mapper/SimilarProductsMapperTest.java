package com.product.controller.mapper;

import com.product.domain.model.SimilarProductDTO;
import com.product.infrastructure.entity.ProductDetail;
import com.product.infrastructure.entity.SimilarProducts;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SimilarProductsMapperTest {
    private SimilarProductsMapper mapper;

    @BeforeEach
    public void setUp() {
        mapper = new SimilarProductsMapperImpl();
    }

    @Test
    public void testAreSimilarProductsDTO() {

        ProductDetail productDetail = new ProductDetail("123", "Product A", 100, true);
        SimilarProducts similarProducts = new SimilarProducts(List.of(productDetail));

        SimilarProductDTO similarProductDTO = mapper.areSimilarProductsDTO(similarProducts);

        assertNotNull(similarProductDTO, "El DTO no debe ser nulo");
        assertNotNull(similarProductDTO.getDetails(), "La lista de detalles no debe ser nula");
        assertEquals(1, similarProductDTO.getDetails().size(), "La lista de detalles debe contener un producto");

        assertEquals("123", similarProductDTO.getDetails().getFirst().getId(), "El ID del producto debe coincidir");
        assertEquals("Product A", similarProductDTO.getDetails().getFirst().getName(), "El nombre del producto debe coincidir");
        assertEquals(100, similarProductDTO.getDetails().getFirst().getPrice(), "El precio del producto debe coincidir");
        assertTrue(similarProductDTO.getDetails().getFirst().getAvailability(), "La disponibilidad del producto debe ser 'true'");
    }
}
