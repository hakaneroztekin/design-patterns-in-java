package com.hakaneroztekin.designpatternsinjava.patterns.creational.factory.service;

import com.hakaneroztekin.designpatternsinjava.patterns.creational.factory.enums.ExpenseType;
import com.hakaneroztekin.designpatternsinjava.patterns.creational.factory.service.interestcalculator.InterestCalculatorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public record InterestCalculatorServiceFactory (List<InterestCalculatorService> interestCalculators) {

    public InterestCalculatorService getService(ExpenseType expenseType) {
        return interestCalculators.stream()
                .filter(expenseCalculator -> expenseCalculator.getExpenseType().equals(expenseType))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No expense calculator found for the expense type: " + expenseType));
    }

}
