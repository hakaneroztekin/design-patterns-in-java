package com.hakaneroztekin.designpatternsinjava.patterns.creational.abstractfactory.model;


import com.hakaneroztekin.designpatternsinjava.patterns.creational.abstractfactory.enums.CustomerType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
public class CustomerMonthlyExpense {
    private CustomerType customerType;
    private MonthlyExpense monthlyExpense;
}
