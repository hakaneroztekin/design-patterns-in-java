package com.hakaneroztekin.designpatternsinjava.patterns.structural.adapter.service.stock_services;

import com.hakaneroztekin.designpatternsinjava.patterns.structural.adapter.model.GoogleApiStock;
import com.hakaneroztekin.designpatternsinjava.patterns.structural.adapter.model.Stock;
import com.hakaneroztekin.designpatternsinjava.patterns.structural.adapter.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GoogleStockAdapterService implements StockService {

    private final GoogleStockService googleStockService;

    @Override
    public String getServiceName() {
        return "Google Stock Service";
    }

    // Adapter adapts GoogleServiceService response to the interface's response
    @Override
    public List<Stock> getStocks() {
        List<GoogleApiStock> googleApiStocks = googleStockService.getStocks();
        return googleApiStocks.stream()
                .map(googleStock -> Stock.builder()
                        .name(googleStock.getStockName())
                        .price(googleStock.getPrice())
                        .symbol(googleStock.getStockSymbol())
                        .build())
                .collect(Collectors.toList());
    }
}