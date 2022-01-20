package com.hakaneroztekin.designpatternsinjava.patterns.factory.model;


import lombok.Builder;
import lombok.Getter;
import lombok.Singular;

import java.util.List;

@Builder
public class MonthlyExpense {
    @Singular
    @Getter
    private List<Expense> expenses;
}
