package com.hakaneroztekin.designpatternsinjava.patterns.creational.prototype.model;

import lombok.Getter;
import lombok.ToString;

@ToString
public class TermsAndConditions {
    @Getter
    private String termsAndConditions;

    public TermsAndConditions() {
        // simplified - it can be a costly database or service call, where cloning an object a good option
        termsAndConditions = """
                By using this Website, you agreed to accept all terms and conditions written in here.
                You must not use this Website if you disagree with any of these Website Standard Terms and Conditions.""";
    }
}
