package com.hakaneroztekin.designpatternsinjava.patterns;

import com.hakaneroztekin.designpatternsinjava.enums.PatternName;

public interface DesignPattern {
    PatternName getPatternName();

    String getScenario();

    void apply();
}
