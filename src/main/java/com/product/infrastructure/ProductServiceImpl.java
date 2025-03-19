package com.product.infrastructure;

import com.product.domain.ProductService;
import com.product.infrastructure.adapter.MockClient;
import com.product.infrastructure.adapter.response.MockClientResponse;
import com.product.infrastructure.entity.ProductDetailEntity;
import com.product.infrastructure.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final MockClient mockClient;
    private final ProductMapper productMapper;


    @Override
    public ProductDetailEntity getDetailById(String productId) {
        final MockClientResponse mockClientResponse = mockClient.findProductDetail(productId);

        return productMapper.asProductDetail(mockClientResponse);

    }

    @Override
    public List<Integer> getSimilarIdListById(String productId) {
        return mockClient.findSimilarIds(productId);
    }
}
