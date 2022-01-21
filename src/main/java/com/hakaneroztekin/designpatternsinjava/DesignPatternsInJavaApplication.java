package com.hakaneroztekin.designpatternsinjava;

import com.hakaneroztekin.designpatternsinjava.enums.PatternName;
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
        printDesignPatterns();

        String selectedPatternId = getUserInput();
        DesignPattern matchingPattern = getDesignPattern(selectedPatternId);

        matchingPattern.printScenario();
        matchingPattern.apply();

        log.info("Exiting successfully.");
        log.info("##############################################");
    }

    private String getUserInput() {
        Scanner scan = new Scanner(System.in);
        String selectedPatternId = scan.next();
        return selectedPatternId;
    }

    private void printDesignPatterns() {
        log.info("Select a design pattern by number");
        PatternName.getPatternByIdMap().forEach((id, pattern) -> {log.info(id + ": " + pattern.getName());});
    }

    private DesignPattern getDesignPattern(String selectedPatternId) {
        PatternName selectedPattern = PatternName.getPatternByIdMap().get(Integer.parseInt(selectedPatternId));
        Optional<DesignPattern> designPatternOptional = designPatterns.stream()
                .filter(pattern -> pattern.getPatternName().equals(selectedPattern))
                .findFirst();

        if(designPatternOptional.isEmpty()) {
            throw new RuntimeException("Design pattern is not found for " + selectedPatternId);
        }

        DesignPattern matchingPattern = designPatternOptional.get();

        log.info("Selected pattern is " + matchingPattern.getPatternName().getName());
        return matchingPattern;
    }
}
