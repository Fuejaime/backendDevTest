package com.product.infrastructure.mapper;

import com.product.infrastructure.entity.ProductDetail;
import com.product.infrastructure.adapter.response.MockClientResponse;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductMapperTest {

    // Get the mapper instance
    private final ProductMapper productMapper = Mappers.getMapper(ProductMapper.class);

    @Test
    void testAsProductDetail() {
        // Arrange: Create a MockClientResponse object with sample data
        MockClientResponse mockClientResponse = new MockClientResponse();
        mockClientResponse.setId("1");
        mockClientResponse.setName("Product 1");
        mockClientResponse.setPrice(100);
        mockClientResponse.setAvailability(true);

        // Act: Map the MockClientResponse object to a ProductDetail object

        ProductDetail productDetail = productMapper.asProductDetail(mockClientResponse);

        // Assert: Verify the ProductDetail object has the expected values
        assertEquals("1", productDetail.getId());
        assertEquals("Product 1", productDetail.getName());
        assertEquals(100, productDetail.getPrice());
        assertEquals(true, productDetail.getAvailability());
    }
}
