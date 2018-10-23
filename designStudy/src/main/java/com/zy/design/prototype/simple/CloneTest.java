package com.zy.design.prototype.simple;

public class CloneTest {
    public static void main(String[] args) {
        Animal animal = new Animal();
        System.out.println(animal);
        System.err.println(animal.age);

        try {
            Animal clone = (Animal) animal.clone();
            System.out.println(clone);
            System.err.println(clone.age);
            System.err.println(animal == clone);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
