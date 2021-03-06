package com.hakaneroztekin.designpatternsinjava.patterns.creational.abstractfactory.model;

import com.hakaneroztekin.designpatternsinjava.patterns.creational.abstractfactory.enums.ExpenseType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Expense {
    private ExpenseType expenseType;
    private int totalExpense;
}
