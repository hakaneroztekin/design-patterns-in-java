package com.hakaneroztekin.designpatternsinjava.patterns.creational.prototype.model;

import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
@Builder
public class PaymentForm implements Cloneable {
    private double totalPrice;
    private TermsAndConditions termsAndConditions;
    private PaymentMethods paymentMethods;


    @Override
    public PaymentForm clone() {
        try {
            /* shallow copy */
            return (PaymentForm) super.clone();
        } catch(CloneNotSupportedException e) {
            log.error("Error cloning PaymentForm. Error detail: {}", e.getMessage());
            return PaymentForm.builder()
                    .termsAndConditions(new TermsAndConditions())
                    .paymentMethods(new PaymentMethods())
                    .build();
        }
    }
}
