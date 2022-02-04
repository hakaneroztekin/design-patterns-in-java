package com.hakaneroztekin.designpatternsinjava.patterns.structural.adapter;

import com.hakaneroztekin.designpatternsinjava.enums.PatternName;
import com.hakaneroztekin.designpatternsinjava.patterns.DesignPattern;
import com.hakaneroztekin.designpatternsinjava.patterns.structural.adapter.service.StockService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class StockPriceService implements DesignPattern {

    private final List<StockService> stockFetcherServices;

    @Override
    public PatternName getPatternName() {
        return PatternName.ADAPTER;
    }

    @Override
    public String getScenario() {
        return "Returns stock prices fetched from different 3rd party apps.";
    }

    @Override
    public void apply() {
        stockFetcherServices.forEach(stockService -> {
            log.info(stockService.getServiceName());
            stockService.getStocks().forEach(stock -> log.info(stock.toString()));
        });
    }
}
