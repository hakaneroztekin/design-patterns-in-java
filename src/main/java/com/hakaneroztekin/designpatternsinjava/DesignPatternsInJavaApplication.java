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
import java.util.concurrent.atomic.AtomicBoolean;

import static com.hakaneroztekin.designpatternsinjava.enums.TextColor.changeTextColor;

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
        AtomicBoolean repeat = new AtomicBoolean(true);
        while(repeat.get()) {
        printDesignPatterns();

        String selectedPatternId = getUserInput();
        getDesignPattern(selectedPatternId).ifPresentOrElse((matchingPattern) -> {
            log.info( changeTextColor(matchingPattern.getScenario(), TextColor.BLUE));
            matchingPattern.apply();
            log.info("Design pattern is executed successfully.");
        }, () -> repeat.set(false));
        }

        log.info("Exiting successfully.");
    }

    private String getUserInput() {
        Scanner scan = new Scanner(System.in);
        return scan.next();
    }

    private void printDesignPatterns() {
        log.info(changeTextColor("##############################################", TextColor.YELLOW));
        log.info(changeTextColor("Select a design pattern by number", TextColor.YELLOW));
        PatternName.getPatternByIdMap().forEach((id, pattern) ->
                log.info(changeTextColor(id + ": ", TextColor.YELLOW) + pattern.getName()));
    }
    private Optional<DesignPattern> getDesignPattern(String selectedPatternId) {
        PatternName selectedPattern = PatternName.getPatternByIdMap().get(Integer.parseInt(selectedPatternId));
        Optional<DesignPattern> designPatternOptional = designPatterns.stream()
                .filter(pattern -> pattern.getPatternName().equals(selectedPattern))
                .findFirst();

        if(designPatternOptional.isEmpty()) {
            log.error("Design pattern is not found for {}", selectedPatternId);
            return Optional.empty();
        }

        DesignPattern matchingPattern = designPatternOptional.get();

        log.info("Selected pattern is " + changeTextColor(matchingPattern.getPatternName().getName(), TextColor.YELLOW));
        return Optional.of(matchingPattern);
    }
}
