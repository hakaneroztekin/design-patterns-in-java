package com.hakaneroztekin.designpatternsinjava.patterns.creational.singleton;

import com.hakaneroztekin.designpatternsinjava.enums.PatternName;
import com.hakaneroztekin.designpatternsinjava.patterns.DesignPattern;
import com.hakaneroztekin.designpatternsinjava.patterns.creational.singleton.util.StringCalculator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class WordCalculationService implements DesignPattern {
    @Override
    public PatternName getPatternName() {
        return PatternName.SINGLETON;
    }

    @Override
    public String getScenario() {
        return "Word calculation service returns total number of characters for a given sentence.";
    }

    @Override
    public void apply() {
        String sentence = "They ran around the corner to find that they had traveled back in time.";

        StringCalculator instance = StringCalculator.getInstance();
        int characterCount = instance.countCharacters(sentence);

        log.info("Total characters in the sentence is calculated as {}.", characterCount);
    }
}
