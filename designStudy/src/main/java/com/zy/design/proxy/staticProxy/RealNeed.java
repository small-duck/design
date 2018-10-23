package com.zy.design.proxy.staticProxy;

/**
 * 真实 的需求者
 */
public class RealNeed implements Person {

    public void getBreakFaster() {
        System.err.println("i need breakFast");

    }

    public void findGirlFriend() {
        System.err.println("i need girlFriend");
    }
}
