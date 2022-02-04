package com.hakaneroztekin.designpatternsinjava.patterns.behavioral.adapter.service.stock_services;

import com.hakaneroztekin.designpatternsinjava.patterns.behavioral.adapter.model.Stock;
import com.hakaneroztekin.designpatternsinjava.patterns.behavioral.adapter.service.StockService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class YahooStockService implements StockService {
    @Override
    public String getServiceName() {
        return "Yahoo Stock Service";
    }

    // YahooStockService is compatible with the interface method
    @Override
    public List<Stock> getStocks() {
        return List.of(
                Stock.builder().name("Alphabet Inc.").price(2853.01).symbol("GOOG").build(),
                Stock.builder().name("Amazon.com, Inc.").price(2776.91).symbol("AMZN").build(),
                Stock.builder().name("Tesla, Inc.").price(891.14).symbol("TSLA").build()
        );
    }
}