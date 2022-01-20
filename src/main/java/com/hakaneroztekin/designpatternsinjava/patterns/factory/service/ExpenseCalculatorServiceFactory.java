package com.hakaneroztekin.designpatternsinjava.patterns.factory.service;

import com.hakaneroztekin.designpatternsinjava.patterns.factory.enums.ExpenseType;
import com.hakaneroztekin.designpatternsinjava.patterns.factory.service.expense_calculators.ExpenseCalculatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExpenseCalculatorServiceFactory {

    private final List<ExpenseCalculatorService> expenseCalculators;

    public ExpenseCalculatorService getService(ExpenseType expenseType) {
        return expenseCalculators.stream()
                .filter(expenseCalculator -> expenseCalculator.getExpenseType().equals(expenseType))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No expense calculator found for the expense type: " + expenseType));
    }

}
