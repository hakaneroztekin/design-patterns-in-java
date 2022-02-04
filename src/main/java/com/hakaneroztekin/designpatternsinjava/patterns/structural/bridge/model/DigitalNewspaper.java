package com.hakaneroztekin.designpatternsinjava.patterns.structural.bridge.model;

import com.hakaneroztekin.designpatternsinjava.patterns.structural.bridge.service.NewspaperSenderService;

public class DigitalNewspaper extends Newspaper {


    public DigitalNewspaper(NewspaperSenderService senderService) {
        super(senderService);
    }

    public void sendNewspaper() {
        getSenderService().sendNewspaper();
    }
}
