package com.zy.design.factorDesign.func;

import com.zy.design.factorDesign.base.Animal;
import com.zy.design.factorDesign.base.Dog;

public class DogAnimal implements Factor {

    public Animal getAnimal() {
        return new Dog();
    }
}
