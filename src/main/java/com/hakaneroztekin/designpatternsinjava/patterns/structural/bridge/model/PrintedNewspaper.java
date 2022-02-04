package com.hakaneroztekin.designpatternsinjava.patterns.structural.bridge.model;

import com.hakaneroztekin.designpatternsinjava.patterns.structural.bridge.service.NewspaperSenderService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class PrintedNewspaper extends Newspaper {

    public PrintedNewspaper(@Qualifier("printedNewspaperSenderService") NewspaperSenderService senderService) {
       super(senderService);
    }

    @Override
    public void sendNewspaper() {
        senderService.sendNewspaper();
    }
}
