package com.zy.design.single.unhunger;

public class UnHungerDesgin {
    private UnHungerDesgin() {

    }
    private static UnHungerDesgin unHungerDesgin = null;

    public static    UnHungerDesgin getUnHungerDesgin() {
        if (unHungerDesgin == null) {

            unHungerDesgin =new UnHungerDesgin();
        }
        return unHungerDesgin;
    }



}
