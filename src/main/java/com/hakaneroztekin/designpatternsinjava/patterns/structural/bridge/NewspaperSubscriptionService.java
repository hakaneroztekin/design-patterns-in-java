package com.hakaneroztekin.designpatternsinjava.patterns.structural.bridge;

import com.hakaneroztekin.designpatternsinjava.enums.PatternName;
import com.hakaneroztekin.designpatternsinjava.patterns.DesignPattern;
import com.hakaneroztekin.designpatternsinjava.patterns.structural.bridge.model.DigitalNewspaper;
import com.hakaneroztekin.designpatternsinjava.patterns.structural.bridge.model.PrintedNewspaper;
import com.hakaneroztekin.designpatternsinjava.patterns.structural.bridge.service.DigitalNewspaperSenderService;
import com.hakaneroztekin.designpatternsinjava.patterns.structural.bridge.service.PrintedNewspaperSenderService;
import org.springframework.stereotype.Service;

@Service
public class NewspaperSubscriptionService implements DesignPattern {
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
        DigitalNewspaper digitalNewspaper = new DigitalNewspaper(new DigitalNewspaperSenderService());
        digitalNewspaper.sendNewspaper();

        PrintedNewspaper printedNewspaper = new PrintedNewspaper(new PrintedNewspaperSenderService());
        printedNewspaper.sendNewspaper();
    }
}
