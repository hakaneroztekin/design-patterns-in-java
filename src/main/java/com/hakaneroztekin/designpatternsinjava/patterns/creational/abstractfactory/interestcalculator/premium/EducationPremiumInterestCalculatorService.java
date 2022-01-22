package com.hakaneroztekin.designpatternsinjava.patterns.creational.abstractfactory.interestcalculator.premium;

import com.hakaneroztekin.designpatternsinjava.patterns.creational.abstractfactory.enums.ExpenseType;
import com.hakaneroztekin.designpatternsinjava.patterns.creational.abstractfactory.interestcalculator.InterestCalculatorService;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@Qualifier("premiumInterestCalculator")
public class EducationPremiumInterestCalculatorService implements InterestCalculatorService {

    @Getter
    private final double interestRate = 0.0005;

    @Override
    public ExpenseType getExpenseType() {
        return ExpenseType.EDUCATION;
    }
}
