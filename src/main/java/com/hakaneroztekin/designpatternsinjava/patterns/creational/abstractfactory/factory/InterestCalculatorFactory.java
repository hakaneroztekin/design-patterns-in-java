package com.hakaneroztekin.designpatternsinjava.patterns.creational.abstractfactory.factory;

import com.hakaneroztekin.designpatternsinjava.patterns.creational.abstractfactory.enums.CustomerType;
import com.hakaneroztekin.designpatternsinjava.patterns.creational.abstractfactory.enums.ExpenseType;
import com.hakaneroztekin.designpatternsinjava.patterns.creational.abstractfactory.interestcalculator.InterestCalculatorService;

import java.util.List;

public interface InterestCalculatorFactory {

    CustomerType getCustomerType();

    List<InterestCalculatorService> getInterestCalculators();

    default InterestCalculatorService getService(ExpenseType expenseType) {
        return getInterestCalculators().stream()
                .filter(expenseCalculator -> expenseCalculator.getExpenseType().equals(expenseType))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No expense calculator found for the expense type: " + expenseType));
    }

}
