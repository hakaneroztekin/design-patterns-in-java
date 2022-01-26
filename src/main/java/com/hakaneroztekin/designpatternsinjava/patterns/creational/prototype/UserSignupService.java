package com.hakaneroztekin.designpatternsinjava.patterns.creational.prototype;

import com.hakaneroztekin.designpatternsinjava.enums.PatternName;
import com.hakaneroztekin.designpatternsinjava.patterns.DesignPattern;
import com.hakaneroztekin.designpatternsinjava.patterns.creational.prototype.model.PaymentForm;
import com.hakaneroztekin.designpatternsinjava.patterns.creational.prototype.model.PaymentMethods;
import com.hakaneroztekin.designpatternsinjava.patterns.creational.prototype.model.TermsAndConditions;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserSignupService implements DesignPattern  {

    @Override
    public PatternName getPatternName() {
        return PatternName.PROTOTYPE;
    }

    @Override
    public String getScenario() {
        return "User signup service returns a fixed form to be shown on UI.";
    }

    @Override
    public void apply() {
        double firstPaymentPrice = 105.25;

        PaymentForm paymentForm = PaymentForm.builder()
                .paymentMethods(new PaymentMethods())
                .termsAndConditions(new TermsAndConditions())
                .totalPrice(firstPaymentPrice)
                .build();
        log.info("First payment form is ready: {}", paymentForm);


        double secondPaymentPrice = 130;
        // Cloning helps us to prevent making costly calls again, we only update what's changing with the form - the total price.
        PaymentForm paymentForm2 = paymentForm.clone();
        paymentForm2.setTotalPrice(secondPaymentPrice);
        log.info("Second payment form is ready: {}", paymentForm2);
    }
}
