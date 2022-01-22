package com.hakaneroztekin.designpatternsinjava;

import com.hakaneroztekin.designpatternsinjava.enums.PatternName;
import com.hakaneroztekin.designpatternsinjava.enums.TextColor;
import com.hakaneroztekin.designpatternsinjava.patterns.DesignPattern;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import static com.hakaneroztekin.designpatternsinjava.enums.TextColor.changeTextColor;

@SpringBootApplication
@Slf4j
@RequiredArgsConstructor
public class DesignPatternsInJavaApplication implements CommandLineRunner {

    public final List<DesignPattern> designPatterns;

    // Declaring ANSI_RESET so that we can reset the color
    public static final String COLOR_RESET = "\u001B[0m";

    // Declaring the color
    // Custom declaration
    public static final String YELLOW_TEXT = "\u001B[33m";

    public static void main(String[] args) {
        SpringApplication.run(DesignPatternsInJavaApplication.class, args);
    }

    @Override
    public void run(String... args) {
        printDesignPatterns();

        String selectedPatternId = getUserInput();
        DesignPattern matchingPattern = getDesignPattern(selectedPatternId);

        matchingPattern.printScenario();
        matchingPattern.apply();

        log.info("Exiting successfully.");
    }

    private String getUserInput() {
        Scanner scan = new Scanner(System.in);
        String selectedPatternId = scan.next();
        return selectedPatternId;
    }

    private void printDesignPatterns() {
        log.info(changeTextColor("##############################################", TextColor.YELLOW));
        log.info(changeTextColor("Select a design pattern by number", TextColor.YELLOW));
        PatternName.getPatternByIdMap().forEach((id, pattern) ->
                log.info(changeTextColor(id + ": ", TextColor.YELLOW) + pattern.getName()));
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

        log.info(changeTextColor("Selected pattern is " + matchingPattern.getPatternName().getName(), TextColor.YELLOW));
        return matchingPattern;
    }
}
