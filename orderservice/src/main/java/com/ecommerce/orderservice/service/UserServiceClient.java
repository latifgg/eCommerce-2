package com.ecommerce.orderservice.service;

import com.ecommerce.orderservice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class UserServiceClient {

    @Autowired
    private WebClient.Builder webClientBuilder;

    public boolean isUserExists(Long userId) {
        String userServiceUrl = "http://localhost:8083/users/" + userId;

        User user = webClientBuilder.build()
                .get()
                .uri(userServiceUrl)
                .retrieve()
                .bodyToMono(User.class)
                .block(); // User objesi dönüyor

        return user != null;
    }
}
