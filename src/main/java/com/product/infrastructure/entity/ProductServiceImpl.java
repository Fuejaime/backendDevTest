package com.product.infrastructure.entity;

import com.product.domain.ProductService;
import com.product.infrastructure.entity.response.MockClientResponse;
import com.product.infrastructure.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final MockClient mockClient;
    private final ProductMapper productMapper;


    @Override
    public ProductDetail provideDetailById(String productId) {
            log.info("Call mockClient.findSimilarIds");
            final MockClientResponse mockClientResponse = mockClient.findProductDetail(productId);
            log.info("Successful call mockClient.findSimilarIds");
            return productMapper.asProductDetail(mockClientResponse);

    }

    @Override
    public List<Integer> provideSimilarIdListById(String productId) {
        return mockClient.findSimilarIds(productId);
    }
}
