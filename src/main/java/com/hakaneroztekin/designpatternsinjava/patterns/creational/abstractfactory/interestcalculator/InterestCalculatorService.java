package com.hakaneroztekin.designpatternsinjava.patterns.creational.abstractfactory.interestcalculator;

import com.hakaneroztekin.designpatternsinjava.patterns.creational.abstractfactory.enums.ExpenseType;
import org.slf4j.Logger;
import org.slf4j.impl.StaticLoggerBinder;

public interface InterestCalculatorService {

    default void printCalculatedInterest(double amount, double calculatedInterest) {
        getLogger().info("Interest is calculated as " + calculatedInterest + " for " + amount
                + ", using " + getExpenseType() + " expense type with "
                + getInterestRate() + " interest rate.");
    }

    default double calculateInterestRate(double amount) {
        double calculatedInterest = getInterestRate() * amount;
        printCalculatedInterest(amount, calculatedInterest);

        return calculatedInterest;
    }

    default Logger getLogger() {
        return StaticLoggerBinder.getSingleton().getLoggerFactory().getLogger(this.getClass().getName());
    }

    ExpenseType getExpenseType();

    double getInterestRate();

}