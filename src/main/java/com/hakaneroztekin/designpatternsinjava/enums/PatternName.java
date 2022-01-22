package com.hakaneroztekin.designpatternsinjava.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
public enum PatternName {
    FACTORY("Factory"),
    ABSTRACT_FACTORY("Abstract Factory"),
    BUILDER("Builder");

    @Getter
    final String name;

    @Getter
    static final Map<Integer, PatternName> patternByIdMap;

    static {
        patternByIdMap = new HashMap<>();
        PatternName[] patterns = PatternName.values();
        for(int i = 0; i < patterns.length; i++) {
            // start from 1
            patternByIdMap.put(i + 1, patterns[i]);
        }
    }
}