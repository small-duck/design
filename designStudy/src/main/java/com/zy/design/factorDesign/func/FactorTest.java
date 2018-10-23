package com.zy.design.factorDesign.func;

import com.zy.design.factorDesign.base.Animal;

public class FactorTest {
    public static void main(String[] args) {
        Factor factor = new DogAnimal();
        Animal animal = factor.getAnimal();
        System.err.println(animal.getName());
    }
}
