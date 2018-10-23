package com.zy.design.single.hunger;

public class HungerDesign {
    private static final HungerDesign HUNGER_DESIGN = new HungerDesign();
    private HungerDesign() {

    }
    public static HungerDesign getInitialize() {

        return HUNGER_DESIGN;
    }
}
