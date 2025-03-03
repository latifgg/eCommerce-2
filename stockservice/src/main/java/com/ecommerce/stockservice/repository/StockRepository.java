package com.ecommerce.stockservice.repository;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.mongodb.annotation.MongoRepository;
import io.micronaut.data.repository.CrudRepository;
import com.ecommerce.stockservice.model.StockItem;
import org.bson.types.ObjectId;
import java.util.Optional;

@Repository
@MongoRepository
public interface StockRepository extends CrudRepository<StockItem, String> {  // ✅ ID türü String olacak

    Optional<StockItem> findById(String id);  // ✅ Micronaut’un standart findById metodu

}
