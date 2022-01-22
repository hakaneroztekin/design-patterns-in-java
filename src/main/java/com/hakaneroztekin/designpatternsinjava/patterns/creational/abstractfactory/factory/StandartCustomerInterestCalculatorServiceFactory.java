package com.hakaneroztekin.designpatternsinjava.patterns.creational.abstractfactory.factory;

import com.hakaneroztekin.designpatternsinjava.patterns.creational.abstractfactory.enums.CustomerType;
import com.hakaneroztekin.designpatternsinjava.patterns.creational.abstractfactory.interestcalculator.InterestCalculatorService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public record StandartCustomerInterestCalculatorServiceFactory(
        @Qualifier("standardInterestCalculator") List<InterestCalculatorService> interestCalculators) implements InterestCalculatorFactory {

    @Override
    public CustomerType getCustomerType() {
        return CustomerType.STANDARD;
    }

    @Override
    public List<InterestCalculatorService> getInterestCalculators() {
        return interestCalculators;
    }
}
