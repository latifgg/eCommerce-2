package com.ecommerce.stockservice.controller;

import com.ecommerce.stockservice.model.StockItem;
import com.ecommerce.stockservice.repository.StockRepository;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.Optional;

@Controller("/stocks")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class StockController {

    private final StockRepository stockRepository;

    public StockController(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @Get
    public List<StockItem> getAllStocks() {
        return stockRepository.findAll();
    }

    @Get("/{id}")
    public Optional<StockItem> getStockById(@PathVariable String id) {
        return stockRepository.findById(id); // ✅ ObjectId yerine direkt String ID kullan
    }

    @Post
    public HttpResponse<StockItem> addStock(@Body StockItem stockItem) {
        stockRepository.save(stockItem);
        return HttpResponse.created(stockItem);
    }

    @Delete("/{id}")
    public HttpResponse<Void> deleteStock(@PathVariable String id) {
        stockRepository.deleteById(id); // ✅ ObjectId yerine direkt String ID kullan
        return HttpResponse.noContent();
    }
}
