package com.hakaneroztekin.designpatternsinjava.patterns.factory.service.interest_calculator;

import com.hakaneroztekin.designpatternsinjava.patterns.factory.enums.ExpenseType;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EducationInterestCalculatorService implements InterestCalculatorService {

    @Getter
    private final double interestRate = 0.1;

    @Override
    public ExpenseType getExpenseType() {
        return ExpenseType.EDUCATION;
    }
}
