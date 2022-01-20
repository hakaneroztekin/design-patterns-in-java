package com.hakaneroztekin.designpatternsinjava;

import com.hakaneroztekin.designpatternsinjava.patterns.DesignPattern;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@SpringBootApplication
@Slf4j
@RequiredArgsConstructor
public class DesignPatternsInJavaApplication implements CommandLineRunner {

    public final List<DesignPattern> designPatterns;

    public static void main(String[] args) {
        SpringApplication.run(DesignPatternsInJavaApplication.class, args);
    }

    @Override
    public void run(String... args) {
        log.info("##############################################");
        log.info("Select a design pattern");
        designPatterns.forEach(designPattern -> log.info(designPattern.getName().getName()));
        Scanner scan = new Scanner(System.in);
        String selectedPattern = scan.next();
        log.info("Selected:" + selectedPattern);
        Optional<DesignPattern> designPatternOptional = designPatterns.stream()
                .filter(pattern -> pattern.getName().getName().equals(selectedPattern))
                .findFirst();

        if(designPatternOptional.isEmpty()) {
            throw new RuntimeException("Design pattern is not found for " + selectedPattern);
        }

        DesignPattern matchingPattern = designPatternOptional.get();
        matchingPattern.printScenario();
        matchingPattern.apply();

        log.info("Exiting successfully.");
        log.info("##############################################");
    }
}
