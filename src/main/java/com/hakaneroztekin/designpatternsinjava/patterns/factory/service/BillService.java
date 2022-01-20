package com.hakaneroztekin.designpatternsinjava.patterns.factory.service;

import com.hakaneroztekin.designpatternsinjava.enums.PatternName;
import com.hakaneroztekin.designpatternsinjava.patterns.DesignPattern;
import com.hakaneroztekin.designpatternsinjava.patterns.factory.enums.ExpenseType;
import com.hakaneroztekin.designpatternsinjava.patterns.factory.model.Expense;
import com.hakaneroztekin.designpatternsinjava.patterns.factory.model.MonthlyExpense;
import com.hakaneroztekin.designpatternsinjava.patterns.factory.service.expense_calculators.ExpenseCalculatorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class BillService implements DesignPattern {

    private final ExpenseCalculatorServiceFactory expenseCalculatorFactory;

    @Override
    public PatternName getName() {
        return PatternName.FACTORY;
    }

    @Override
    public void printScenario() {
        log.info("A receipt service is calculating total credit card interest rate for different expenses.");
    }

    @Override
    public void apply() {
        MonthlyExpense monthlyExpense = MonthlyExpense.builder()
                .expense(Expense.builder().expenseType(ExpenseType.FOOD).totalExpense(2500).build())
                .expense(Expense.builder().expenseType(ExpenseType.EDUCATION).totalExpense(500).build())
                .expense(Expense.builder().expenseType(ExpenseType.TRAVEL).totalExpense(1000).build())
                .expense(Expense.builder().expenseType(ExpenseType.HEALTH).totalExpense(250).build())
                .build();

        monthlyExpense.getExpenses().stream()
                .map(expense -> {
                    ExpenseCalculatorService calculatorService = expenseCalculatorFactory.getService(expense.getExpenseType());
                    return calculatorService.calculateInterestRate(expense.getTotalExpense());
                }).reduce(Integer::sum)
                .orElseThrow(() -> new RuntimeException("Error occurred during expense calculation."));

    }
}
