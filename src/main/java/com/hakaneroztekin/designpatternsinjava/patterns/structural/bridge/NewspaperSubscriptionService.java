package com.hakaneroztekin.designpatternsinjava.patterns.structural.bridge;

import com.hakaneroztekin.designpatternsinjava.enums.PatternName;
import com.hakaneroztekin.designpatternsinjava.patterns.DesignPattern;
import com.hakaneroztekin.designpatternsinjava.patterns.structural.bridge.model.Newspaper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NewspaperSubscriptionService implements DesignPattern {

    private final List<Newspaper> newspapers;

    @Override
    public PatternName getPatternName() {
        return PatternName.BRIDGE;
    }

    @Override
    public String getScenario() {
        return "Every day, newspaper subscription service sends PDF link to digital subscribers, printed newspaper to physical subscribers.";
    }

    @Override
    public void apply() {
        newspapers.forEach(Newspaper::sendNewspaper);
    }
}
