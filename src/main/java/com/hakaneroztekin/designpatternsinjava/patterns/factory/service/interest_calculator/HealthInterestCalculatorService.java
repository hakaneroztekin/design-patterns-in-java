package com.hakaneroztekin.designpatternsinjava.patterns.factory.service.interest_calculator;

import com.hakaneroztekin.designpatternsinjava.patterns.factory.enums.ExpenseType;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HealthInterestCalculatorService implements InterestCalculatorService {

    @Getter
    private final double interestRate = 0.25;

    @Override
    public ExpenseType getExpenseType() {
        return ExpenseType.HEALTH;
    }
}
