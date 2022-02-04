package com.hakaneroztekin.designpatternsinjava.patterns.structural.adapter.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoogleApiStock {
    private String stockName;
    private String stockSymbol;
    private double price;
}
