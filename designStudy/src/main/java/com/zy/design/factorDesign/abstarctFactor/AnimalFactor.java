package com.zy.design.factorDesign.abstarctFactor;


import com.zy.design.factorDesign.base.Animal;
import com.zy.design.factorDesign.base.Cat;
import com.zy.design.factorDesign.base.Dog;

public class AnimalFactor extends AbstractFactor {

    public Animal getDog() {
        return new Dog();
    }

    public Animal getCat() {
        return new Cat();
    }
}
