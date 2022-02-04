package com.hakaneroztekin.designpatternsinjava.patterns.structural.adapter.service;

import com.hakaneroztekin.designpatternsinjava.patterns.structural.adapter.model.Stock;

import java.util.List;

public interface StockService {

    String getServiceName();

    List<Stock> getStocks();
}
