package com.hakaneroztekin.designpatternsinjava.patterns.creational.builder.model;

import lombok.Builder;
import lombok.Singular;
import lombok.ToString;

import java.util.List;

@Builder
@ToString
public class Aquarium {
    private final String name;
    private final double price;
    private final double weight;
    private final int length;
    private final int depth;
    private final String coverMaterial;
    @Singular /*@Singular allows us to build equipment objects one by one*/
    private final List<AquariumEquipment> providedEquipments;
}
