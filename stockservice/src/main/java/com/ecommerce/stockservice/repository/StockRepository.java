package com.ecommerce.stockservice.repository;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.mongodb.annotation.MongoRepository;
import io.micronaut.data.repository.CrudRepository;
import com.ecommerce.stockservice.model.StockItem;

@Repository
@MongoRepository
public interface StockRepository extends CrudRepository<StockItem, String> { // ✅ ObjectId yerine String kullanıldı
}
