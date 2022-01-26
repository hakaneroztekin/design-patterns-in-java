package com.hakaneroztekin.designpatternsinjava.patterns.creational.prototype.model;

import lombok.Builder;
import lombok.ToString;

@Builder
@ToString
public class PaymentMethod {
    private String methodName;
    private double interestRate;
}
