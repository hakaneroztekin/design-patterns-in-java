package com.hakaneroztekin.designpatternsinjava.patterns.factory.service.interest_calculator;

import com.hakaneroztekin.designpatternsinjava.patterns.factory.enums.ExpenseType;
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