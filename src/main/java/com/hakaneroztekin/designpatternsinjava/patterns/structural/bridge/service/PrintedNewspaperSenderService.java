package com.hakaneroztekin.designpatternsinjava.patterns.structural.bridge.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service("printedNewspaperSenderService")
@Slf4j
public class PrintedNewspaperSenderService implements NewspaperSenderService {
    @Override
    public void sendNewspaper() {
      log.info("Sending printed newspaper.");
    }
}
