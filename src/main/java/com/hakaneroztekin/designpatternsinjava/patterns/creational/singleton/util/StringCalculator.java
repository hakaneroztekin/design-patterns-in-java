package com.hakaneroztekin.designpatternsinjava.patterns.creational.singleton.util;

public class StringCalculator {

    private static StringCalculator stringCalculator;

    private StringCalculator() {
    }

    public static StringCalculator getInstance() {
        if (stringCalculator == null) {
            stringCalculator = new StringCalculator();
        }
        return stringCalculator;
    }

    public int countCharacters(String string) {
        return string.length();
    }
}
