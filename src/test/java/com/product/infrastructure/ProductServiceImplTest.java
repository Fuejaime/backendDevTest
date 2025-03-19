package com.product.infrastructure;

import com.product.infrastructure.adapter.MockClient;
import com.product.infrastructure.adapter.response.MockClientResponse;
import com.product.infrastructure.entity.ProductDetailEntity;
import com.product.infrastructure.mapper.ProductMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductServiceImplTest {

    @Mock
    private MockClient mockClient;

    @Mock
    private ProductMapper productMapper;

    @InjectMocks
    private ProductServiceImpl productServiceImpl;

    private MockClientResponse mockClientResponse;
    private ProductDetailEntity productDetailEntity;

    @BeforeEach
    void setUp() {
        mockClientResponse = new MockClientResponse();
        mockClientResponse.setId("1");
        mockClientResponse.setName("Product Name");
        mockClientResponse.setPrice(100);
        mockClientResponse.setAvailability(true);

        productDetailEntity = new ProductDetailEntity("1", "Product Name", 100, true);
    }

    @Test
    void getDetailById_shouldReturnProductDetail() {
        when(mockClient.findProductDetail("1")).thenReturn(mockClientResponse);
        when(productMapper.asProductDetail(mockClientResponse)).thenReturn(productDetailEntity);

        ProductDetailEntity result = productServiceImpl.getDetailById("1");

        assertEquals("1", result.getId());
        assertEquals("Product Name", result.getName());
        assertEquals(100, result.getPrice());
        assertEquals(true, result.getAvailability());
    }

    @Test
    void getSimilarIdListById_shouldReturnSimilarIds() {
        when(mockClient.findSimilarIds("1")).thenReturn(List.of(2, 3, 4));

        List<Integer> result = productServiceImpl.getSimilarIdListById("1");

        assertEquals(3, result.size());
        assertEquals(Integer.valueOf(2), result.get(0));
        assertEquals(Integer.valueOf(3), result.get(1));
        assertEquals(Integer.valueOf(4), result.get(2));
    }
}
