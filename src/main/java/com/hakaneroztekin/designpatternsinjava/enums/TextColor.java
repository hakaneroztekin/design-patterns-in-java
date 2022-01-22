package com.hakaneroztekin.designpatternsinjava.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum TextColor {
    RESET("\u001B[0m"), // to reset color to default
    YELLOW("\u001B[33m"),
    RED("\u001B[31m"),
    BLUE("\u001B[34m");

    @Getter
    final String code;

    public static String changeTextColor(String text, TextColor textColor) {
        return textColor.getCode() + text + RESET.getCode();
    }
}

