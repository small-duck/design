package com.zy.design.prototype.deep;

import java.io.Serializable;

public class Jgubang implements Serializable {
    public float hegiht = 100;
    public float weight = 8;
    public void big(){
        this.weight *= 2;
        this.hegiht *= 2;
    }

    public void small(){
        this.weight /= 2;
        this.hegiht /= 2;
    }
}
