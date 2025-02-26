package com.ecommerce.orderservice.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class StockConsumer {
    @KafkaListener(topics = "stock-updates", groupId = "order-group")
    public void consumeStockUpdates(ConsumerRecord<String, String> record) {
        System.out.println("Stock Update Received: " + record.value());
        // Siparişleri güncellemek için gerekli işlemleri burada yapabilirsin
    }
}
