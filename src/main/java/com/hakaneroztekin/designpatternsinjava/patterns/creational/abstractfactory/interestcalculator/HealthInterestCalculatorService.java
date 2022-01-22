package com.hakaneroztekin.designpatternsinjava.patterns.creational.abstractfactory.interestcalculator;

import com.hakaneroztekin.designpatternsinjava.patterns.creational.abstractfactory.enums.ExpenseType;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class HealthInterestCalculatorService implements InterestCalculatorService {

    @Getter
    private final double interestRate = 0.0025;

    @Override
    public ExpenseType getExpenseType() {
        return ExpenseType.HEALTH;
    }
}
