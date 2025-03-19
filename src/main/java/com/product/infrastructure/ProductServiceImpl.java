package com.product.infrastructure;

import com.product.domain.ProductService;
import com.product.infrastructure.adapter.MockClient;
import com.product.infrastructure.adapter.response.MockClientResponse;
import com.product.infrastructure.entity.ProductDetailEntity;
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
    public ProductDetailEntity getDetailById(String productId) {
            log.info("Call mockClient.findSimilarIds");
            final MockClientResponse mockClientResponse = mockClient.findProductDetail(productId);
            log.info("Successful call mockClient.findSimilarIds");
        ProductDetailEntity productDetailEntity = ProductDetailEntity.builder()
                .id(mockClientResponse.getId())
                .name(mockClientResponse.getName())
                .price(mockClientResponse.getPrice())
                .availability(mockClientResponse.getAvailability())
                // Agregar más campos según la estructura de MockClientResponse
                .build();
            //ProductDetailEntity productDetailEntity = productMapper.asProductDetail(mockClientResponse);
            System.out.println("productDetailEntity: " + productDetailEntity);
            System.out.println("mockClientResponse: " + mockClientResponse);

            return productDetailEntity;

    }

    @Override
    public List<Integer> getSimilarIdListById(String productId) {
        List<Integer> similarIds = mockClient.findSimilarIds(productId);
        return similarIds;
    }
}
