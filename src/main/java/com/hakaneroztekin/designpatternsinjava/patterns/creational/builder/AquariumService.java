package com.hakaneroztekin.designpatternsinjava.patterns.creational.builder;

import com.hakaneroztekin.designpatternsinjava.enums.PatternName;
import com.hakaneroztekin.designpatternsinjava.patterns.DesignPattern;
import com.hakaneroztekin.designpatternsinjava.patterns.creational.builder.model.Aquarium;
import com.hakaneroztekin.designpatternsinjava.patterns.creational.builder.model.AquariumEquipment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AquariumService implements DesignPattern {
    @Override
    public PatternName getPatternName() {
        return PatternName.BUILDER;
    }

    @Override
    public String getScenario() {
        return "Aquarium service lists available aquariums.";
    }

    @Override
    public void apply() {
        Aquarium aquarium1 = Aquarium.builder()
                .name("Fishy Aquarium")
                .price(50.0)
                .weight(1500)
                .length(80)
                .depth(45)
                .coverMaterial("Plastic")
                .providedEquipment(null)
                .build();

        Aquarium aquarium2 = Aquarium.builder()
                .name("Lux Aquarium")
                .price(129.0)
                .weight(2000)
                .length(140)
                .depth(75)
                .coverMaterial("Acrylic")
                // thanks to the @Singular annotation at the model class, we can initialize the list one by one
                .providedEquipment(AquariumEquipment.builder().name("Decor rock").build())
                .providedEquipment(AquariumEquipment.builder().name("Heater").build())
                .providedEquipment(AquariumEquipment.builder().name("Filter").build())
                .build();


        List<Aquarium> aquariums = List.of(aquarium1, aquarium2);

        aquariums.forEach(aquarium -> log.info("Aquarium info: " + aquarium));
    }
}
