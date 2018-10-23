package com.zy.design.factorDesign.simple;

public class SimpleAnimalFactorTest {
    public static void main(String[] args) {
        SimpleAnimalFactor factor = new SimpleAnimalFactor();
        String dog = factor.getAnimal("dog");
        System.err.println(dog);
    }
}
