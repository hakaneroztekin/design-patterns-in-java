package com.hakaneroztekin.designpatternsinjava.patterns.creational.factory.service;

import com.hakaneroztekin.designpatternsinjava.enums.PatternName;
import com.hakaneroztekin.designpatternsinjava.patterns.DesignPattern;
import com.hakaneroztekin.designpatternsinjava.patterns.creational.factory.model.Expense;
import com.hakaneroztekin.designpatternsinjava.patterns.creational.factory.model.MonthlyExpense;
import com.hakaneroztekin.designpatternsinjava.patterns.creational.factory.enums.ExpenseType;
import com.hakaneroztekin.designpatternsinjava.patterns.creational.factory.service.interestcalculator.InterestCalculatorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class BillService implements DesignPattern {

    private final InterestCalculatorServiceFactory interestCalculatorServiceFactory;

    @Override
    public PatternName getPatternName() {
        return PatternName.FACTORY;
    }

    @Override
    public void printScenario() {
        log.info("Bill service is calculating total credit card interest rate for different expenses.");
    }

    @Override
    public void apply() {
        MonthlyExpense monthlyExpense = MonthlyExpense.builder()
                .expense(Expense.builder().expenseType(ExpenseType.FOOD).totalExpense(2500).build())
                .expense(Expense.builder().expenseType(ExpenseType.EDUCATION).totalExpense(500).build())
                .expense(Expense.builder().expenseType(ExpenseType.TRAVEL).totalExpense(1000).build())
                .expense(Expense.builder().expenseType(ExpenseType.HEALTH).totalExpense(250).build())
                .build();
        log.info("Monthly expense is " + monthlyExpense);

        Double totalInterest = monthlyExpense.getExpenses().stream()
                .map(expense -> {
                    InterestCalculatorService calculatorService = interestCalculatorServiceFactory.getService(expense.getExpenseType());
                    return calculatorService.calculateInterestRate(expense.getTotalExpense());
                }).reduce(Double::sum)
                .orElseThrow(() -> new RuntimeException("Error occurred during expense calculation."));

        log.info("Total interest rate is calculated: {}", totalInterest);
    }
}
