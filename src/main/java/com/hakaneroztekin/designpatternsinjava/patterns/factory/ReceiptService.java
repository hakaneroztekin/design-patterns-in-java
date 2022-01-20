package com.hakaneroztekin.designpatternsinjava.patterns.factory;

import com.hakaneroztekin.designpatternsinjava.enums.PatternName;
import com.hakaneroztekin.designpatternsinjava.patterns.DesignPattern;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ReceiptService implements DesignPattern {

    //private final CargoServiceFactory cargoServiceFactory;

    @Override
    public PatternName getName() {
        return PatternName.FACTORY;
    }

    @Override
    public void apply() {

    }
}
