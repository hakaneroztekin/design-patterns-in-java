package com.hakaneroztekin.designpatternsinjava.patterns.creational.abstractfactory;

import com.hakaneroztekin.designpatternsinjava.enums.PatternName;
import com.hakaneroztekin.designpatternsinjava.patterns.DesignPattern;
import com.hakaneroztekin.designpatternsinjava.patterns.creational.abstractfactory.enums.CustomerType;
import com.hakaneroztekin.designpatternsinjava.patterns.creational.abstractfactory.enums.ExpenseType;
import com.hakaneroztekin.designpatternsinjava.patterns.creational.abstractfactory.factory.InterestCalculatorFactory;
import com.hakaneroztekin.designpatternsinjava.patterns.creational.abstractfactory.factory.InterestCalculatorServiceFactory;
import com.hakaneroztekin.designpatternsinjava.patterns.creational.abstractfactory.interestcalculator.InterestCalculatorService;
import com.hakaneroztekin.designpatternsinjava.patterns.creational.abstractfactory.model.CustomerMonthlyExpense;
import com.hakaneroztekin.designpatternsinjava.patterns.creational.abstractfactory.model.Expense;
import com.hakaneroztekin.designpatternsinjava.patterns.creational.abstractfactory.model.MonthlyExpense;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CustomBillService implements DesignPattern {

    @Qualifier("abstractFactory")
    private final InterestCalculatorServiceFactory calculatorServiceFactory;

    public CustomBillService(InterestCalculatorServiceFactory calculatorServiceFactory) {
        this.calculatorServiceFactory = calculatorServiceFactory;
    }

    @Override
    public PatternName getPatternName() {
        return PatternName.ABSTRACT_FACTORY;
    }

    @Override
    public void printScenario() {
        log.info("Bill service is calculating total credit card interest rate of different expenses for standard and premium customer types.");
    }

    @Override
    public void apply() {
        MonthlyExpense monthlyExpense = MonthlyExpense.builder()
                .expense(Expense.builder().expenseType(ExpenseType.FOOD).totalExpense(2500).build())
                .expense(Expense.builder().expenseType(ExpenseType.EDUCATION).totalExpense(500).build())
                .expense(Expense.builder().expenseType(ExpenseType.TRAVEL).totalExpense(1000).build())
                .expense(Expense.builder().expenseType(ExpenseType.HEALTH).totalExpense(250).build())
                .build();
        CustomerMonthlyExpense standartCustomerMonthlyExpense = CustomerMonthlyExpense.builder()
                .monthlyExpense(monthlyExpense)
                .customerType(CustomerType.STANDARD)
                .build();
        log.info("Standart customer monthly expense is " + standartCustomerMonthlyExpense);

        calculateTotalInterest(standartCustomerMonthlyExpense);


        CustomerMonthlyExpense premiumCustomerMonthlyExpense = CustomerMonthlyExpense.builder()
                .monthlyExpense(monthlyExpense)
                .customerType(CustomerType.PREMIUM)
                .build();
        log.info("Premium customer monthly expense is " + premiumCustomerMonthlyExpense);

        calculateTotalInterest(premiumCustomerMonthlyExpense);
    }

    private void calculateTotalInterest(CustomerMonthlyExpense customerMonthlyExpense) {
        Double totalInterest = customerMonthlyExpense.getMonthlyExpense().getExpenses().stream()
                .map(expense -> {
                    InterestCalculatorFactory factory = calculatorServiceFactory.getInterestCalculatorFactory(customerMonthlyExpense.getCustomerType());
                    InterestCalculatorService calculatorService = factory.getService(expense.getExpenseType());
                    return calculatorService.calculateInterestRate(expense.getTotalExpense());
                }).reduce(Double::sum)
                .orElseThrow(() -> new RuntimeException("Error occurred during expense calculation."));

        log.info("Total interest rate is calculated: {}", totalInterest);
    }
}
