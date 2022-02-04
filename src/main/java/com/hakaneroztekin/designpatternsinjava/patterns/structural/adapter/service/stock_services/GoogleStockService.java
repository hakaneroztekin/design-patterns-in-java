package com.hakaneroztekin.designpatternsinjava.patterns.structural.adapter.service.stock_services;

import com.hakaneroztekin.designpatternsinjava.patterns.structural.adapter.model.GoogleApiStock;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoogleStockService  {

    // GoogleStockService is incompatible with the interface method of StockService
    // We can assume this is a 3rd party code that we can't change.
    public List<GoogleApiStock> getStocks() {
        return List.of(
                GoogleApiStock.builder().stockName("Johnson & Johnson.").price(172.76).stockSymbol("JNJ").build(),
                GoogleApiStock.builder().stockName("JP Morgan Chase & Co.").price(148.70).stockSymbol("JPM").build(),
                GoogleApiStock.builder().stockName("Royal Dutch Shell PLC").price(53.91).stockSymbol("SHEL").build()
        );
    }
}