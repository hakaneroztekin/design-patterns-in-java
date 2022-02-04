package com.hakaneroztekin.designpatternsinjava.patterns.behavioral.adapter.service;

import com.hakaneroztekin.designpatternsinjava.patterns.behavioral.adapter.model.Stock;

import java.util.List;

public interface StockService {

    String getServiceName();

    List<Stock> getStocks();
}
