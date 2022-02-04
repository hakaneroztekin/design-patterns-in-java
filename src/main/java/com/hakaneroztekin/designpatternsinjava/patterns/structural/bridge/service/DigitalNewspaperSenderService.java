package com.hakaneroztekin.designpatternsinjava.patterns.structural.bridge.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service("digitalNewspaperSenderService")
@Slf4j
public class DigitalNewspaperSenderService implements NewspaperSenderService {

    public void sendNewspaper() {
        log.info("Sending digital newspaper.");
    }
}
