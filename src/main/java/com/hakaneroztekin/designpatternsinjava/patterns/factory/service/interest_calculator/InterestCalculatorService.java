package com.hakaneroztekin.designpatternsinjava.patterns.factory.service.interest_calculator;

import com.hakaneroztekin.designpatternsinjava.patterns.factory.enums.ExpenseType;

public interface InterestCalculatorService {

    default double calculateInterestRate(double amount) {
        return getInterestRate() * amount;
    }

    ExpenseType getExpenseType();

    double getInterestRate();

}