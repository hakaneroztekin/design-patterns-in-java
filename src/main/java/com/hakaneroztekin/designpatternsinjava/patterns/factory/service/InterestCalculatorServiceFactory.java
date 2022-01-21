package com.hakaneroztekin.designpatternsinjava.patterns.factory.service;

import com.hakaneroztekin.designpatternsinjava.patterns.factory.enums.ExpenseType;
import com.hakaneroztekin.designpatternsinjava.patterns.factory.service.interest_calculator.InterestCalculatorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public record InterestCalculatorServiceFactory (List<InterestCalculatorService> expenseCalculators) {

    public InterestCalculatorService getService(ExpenseType expenseType) {
        return expenseCalculators.stream()
                .filter(expenseCalculator -> expenseCalculator.getExpenseType().equals(expenseType))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No expense calculator found for the expense type: " + expenseType));
    }

}
