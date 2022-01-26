package com.hakaneroztekin.designpatternsinjava.patterns.creational.prototype.model;

import lombok.Getter;
import lombok.ToString;

import java.util.List;

@ToString
public class PaymentMethods {
    @Getter
    List<PaymentMethod> paymentMethods;

    public PaymentMethods() {
        // simplified - it can be a costly database or service call, where cloning an object a good option
        paymentMethods = List.of(
                PaymentMethod.builder().methodName("Cash").interestRate(0).build(),
                PaymentMethod.builder().methodName("Debit Card").interestRate(0.5).build(),
                PaymentMethod.builder().methodName("Credit Card").interestRate(1.25).build());
    }
}
