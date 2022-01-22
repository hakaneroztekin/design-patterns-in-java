package com.hakaneroztekin.designpatternsinjava.patterns.creational.factory.model;

import com.hakaneroztekin.designpatternsinjava.patterns.creational.factory.enums.ExpenseType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Expense {
    private ExpenseType expenseType;
    private int totalExpense;
}
