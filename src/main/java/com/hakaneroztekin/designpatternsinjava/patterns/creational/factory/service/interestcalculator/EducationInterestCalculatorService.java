package com.hakaneroztekin.designpatternsinjava.patterns.creational.factory.service.interestcalculator;

import com.hakaneroztekin.designpatternsinjava.patterns.creational.factory.enums.ExpenseType;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EducationInterestCalculatorService implements InterestCalculatorService {

    @Getter
    private final double interestRate = 0.001;

    @Override
    public ExpenseType getExpenseType() {
        return ExpenseType.EDUCATION;
    }
}
