package com.zy.design.factorDesign.func;

import com.zy.design.factorDesign.base.Animal;
import com.zy.design.factorDesign.base.Cat;

public class CatFactor implements Factor {
    public Animal getAnimal() {
        return new Cat();
    }
}
