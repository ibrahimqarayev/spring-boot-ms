package com.mycompany.productservice.service;

import com.mycompany.productservice.converter.ProductConverter;
import com.mycompany.productservice.dto.request.ProductRequest;
import com.mycompany.productservice.dto.response.ProductResponse;
import com.mycompany.productservice.model.Product;
import com.mycompany.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductConverter productConverter;

    public void createProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();
        productRepository.save(product);
        log.info("Product is saved");
    }

    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(productConverter::mapToProductResponse).collect(Collectors.toList());
    }
}
