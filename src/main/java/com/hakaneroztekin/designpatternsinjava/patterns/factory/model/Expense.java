package com.hakaneroztekin.designpatternsinjava.patterns.factory.model;

import com.hakaneroztekin.designpatternsinjava.patterns.factory.enums.ExpenseType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Expense {
    private ExpenseType expenseType;
    private int totalExpense;
}
