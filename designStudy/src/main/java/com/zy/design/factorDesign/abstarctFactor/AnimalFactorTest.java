package com.zy.design.factorDesign.abstarctFactor;


import com.zy.design.factorDesign.base.Animal;

public class AnimalFactorTest {
    public static void main(String[] args) {
        AnimalFactor animalFactor = new AnimalFactor();
        Animal cat = animalFactor.getCat();
        System.err.println(cat.getName());

    }
}
