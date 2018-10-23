package com.zy.design.factorDesign.simple;

import com.zy.design.factorDesign.base.Cat;
import com.zy.design.factorDesign.base.Dog;

public class SimpleAnimalFactor {
    public String getAnimal(String name) {
        if ("dog".equals(name)) {
            return new Dog().getName();
        } else if ("cat".equals(name)) {
            Cat cat = new Cat();
            return new Cat().getName();
        }else {
            return "not have others animal";
        }
    }
}
