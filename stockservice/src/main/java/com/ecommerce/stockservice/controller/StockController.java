package com.ecommerce.stockservice.controller;

import com.ecommerce.stockservice.model.StockItem;
import com.ecommerce.stockservice.repository.StockRepository;
import com.ecommerce.stockservice.kafka.StockProducer;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

@Controller("/stocks")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class StockController {

    private final StockRepository stockRepository;
    private final StockProducer stockProducer;

    private static final Logger LOG = LoggerFactory.getLogger(StockController.class);
    public StockController(StockRepository stockRepository, StockProducer stockProducer) {
        this.stockRepository = stockRepository;
        this.stockProducer = stockProducer;
    }
    @Get
    public List<StockItem> getAllStocks() {
        List<StockItem> stocks = stockRepository.findAll();

        LOG.info("Fetched stocks from DB: " + stocks); // ✅ MongoDB'den dönen verileri yazdır

        return stocks;
    }

    @Get("/{id}")
    public Optional<StockItem> getStockById(@PathVariable String id) {
        LOG.info("Received ID: " + id);

        return stockRepository.findById(id);  // ✅ Direkt String ID olarak arıyoruz
    }


    @Post
    public HttpResponse<StockItem> addStock(@Body StockItem stockItem) {
        stockRepository.save(stockItem);
        return HttpResponse.created(stockItem);
    }

    @Post("/update")
    public String updateStock(@Body String message) {
        LOG.info("---------------Received updateStock request------------------------------: " + message);
        stockProducer.sendStockUpdate(message);
        return "Stock update message sent to Kafka!";
    }

    @Delete("/{id}")
    public HttpResponse<Void> deleteStock(@PathVariable String id) {
        stockRepository.deleteById(id); // ✅ ObjectId yerine direkt String ID kullan
        return HttpResponse.noContent();
    }
}
