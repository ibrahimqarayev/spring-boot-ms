package com.mycompany.productservice.converter;

import com.mycompany.productservice.dto.response.ProductResponse;
import com.mycompany.productservice.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {

    public ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }

}
