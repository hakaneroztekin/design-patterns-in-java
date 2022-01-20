package com.hakaneroztekin.designpatternsinjava.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum PatternName {
    FACTORY("Factory");

    @Getter
    final String name;
}