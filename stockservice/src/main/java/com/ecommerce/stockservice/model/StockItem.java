package com.ecommerce.stockservice.model;

import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.serde.annotation.Serdeable;
import org.bson.codecs.pojo.annotations.BsonProperty;
import java.math.BigDecimal;

@Serdeable
@MappedEntity
public class StockItem {

    @Id
    @BsonProperty("_id")
    private String id; // ✅ ObjectId yerine String olarak güncellendi

    private String productId;
    private int quantity;
    private BigDecimal price;

    public StockItem() {}

    public StockItem(String productId, int quantity, BigDecimal price) {
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
