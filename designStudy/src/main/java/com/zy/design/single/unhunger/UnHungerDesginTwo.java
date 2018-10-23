package com.zy.design.single.unhunger;

public class UnHungerDesginTwo {
    private UnHungerDesginTwo() {

    }
    private static UnHungerDesginTwo unHungerDesgin = null;

    public static synchronized UnHungerDesginTwo getUnHungerDesgin() {
        if (unHungerDesgin == null) {

            unHungerDesgin =new UnHungerDesginTwo();
        }
        return unHungerDesgin;
    }



}
