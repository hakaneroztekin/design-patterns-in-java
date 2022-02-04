package com.hakaneroztekin.designpatternsinjava.patterns.behavioral.adapter.model;

import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Stock {
    private String name;
    private String symbol;
    private double price;
}
