package com.ecommerce.stockservice.kafka;

import io.micronaut.configuration.kafka.annotation.KafkaClient;
import io.micronaut.configuration.kafka.annotation.Topic;

@KafkaClient
public interface StockProducer {
    @Topic("stock-updates")
    void sendStockUpdate(String message);
}
