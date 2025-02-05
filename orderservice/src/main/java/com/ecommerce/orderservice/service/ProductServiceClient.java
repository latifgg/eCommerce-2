package com.ecommerce.orderservice.service;

import com.ecommerce.orderservice.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class ProductServiceClient {

    @Autowired
    private WebClient.Builder webClientBuilder;

    public boolean isProductExists(Long productId) {
        String productServiceUrl = "http://localhost:8081/products/" + productId;

        Product product = webClientBuilder.build()
                .get()
                .uri(productServiceUrl)
                .retrieve()
                .bodyToMono(Product.class)
                .block(); // Product objesi dönüyor

        return product != null;
    }
}
