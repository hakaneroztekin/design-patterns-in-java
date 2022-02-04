package com.hakaneroztekin.designpatternsinjava.patterns.structural.bridge.model;

import com.hakaneroztekin.designpatternsinjava.patterns.structural.bridge.service.NewspaperSenderService;

public abstract class Newspaper {
    protected final NewspaperSenderService senderService;

    public Newspaper(NewspaperSenderService senderService) {
        this.senderService = senderService;
    }

    public abstract void sendNewspaper();
}
