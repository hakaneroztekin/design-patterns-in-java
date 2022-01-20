package com.hakaneroztekin.designpatternsinjava.patterns.factory.service.expense_calculators;

import com.hakaneroztekin.designpatternsinjava.patterns.factory.enums.ExpenseType;

public interface ExpenseCalculatorService {
    ExpenseType getExpenseType();

    int calculateInterestRate(int amount);
}