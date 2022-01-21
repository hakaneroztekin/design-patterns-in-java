package com.hakaneroztekin.designpatternsinjava.patterns.factory.model;


import lombok.Builder;
import lombok.Getter;
import lombok.Singular;
import lombok.ToString;

import java.util.List;

@Builder
@ToString
public class MonthlyExpense {
    @Singular
    @Getter
    private List<Expense> expenses;
}
