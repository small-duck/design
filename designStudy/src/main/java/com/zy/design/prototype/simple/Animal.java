package com.zy.design.prototype.simple;

import java.io.Serializable;

public class Animal implements  Cloneable , Serializable {
    public String name = "zy";
    public Integer age = 12;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
