package com.hakaneroztekin.designpatternsinjava.patterns.creational.abstractfactory.factory;

import com.hakaneroztekin.designpatternsinjava.patterns.creational.abstractfactory.enums.CustomerType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public record InterestCalculatorServiceFactory (List<InterestCalculatorFactory> interestCalculatorFactories) {

    public InterestCalculatorFactory getInterestCalculatorFactory(CustomerType customerType) {
        return interestCalculatorFactories.stream()
                .filter(factory -> factory.getCustomerType().equals(customerType))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Interest calculator factory is not found for customer type " + customerType));
    }
}
