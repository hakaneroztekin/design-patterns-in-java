package com.hakaneroztekin.designpatternsinjava.patterns.structural.bridge.model;

import com.hakaneroztekin.designpatternsinjava.patterns.structural.bridge.service.NewspaperSenderService;

public class PrintedNewspaper extends Newspaper {

    public PrintedNewspaper(NewspaperSenderService senderService) {
        super(senderService);
    }

    @Override
    public void sendNewspaper() {
        getSenderService().sendNewspaper();
    }
}
