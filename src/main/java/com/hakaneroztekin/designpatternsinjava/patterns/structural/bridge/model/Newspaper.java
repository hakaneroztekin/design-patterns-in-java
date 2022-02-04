package com.hakaneroztekin.designpatternsinjava.patterns.structural.bridge.model;

import com.hakaneroztekin.designpatternsinjava.patterns.structural.bridge.service.NewspaperSenderService;
import lombok.Getter;

public abstract class Newspaper {

    @Getter
    private final NewspaperSenderService senderService;

    public Newspaper(NewspaperSenderService senderService) {
        this.senderService = senderService;
    }

    public abstract void sendNewspaper();
}
