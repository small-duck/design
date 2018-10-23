package com.zy.design.proxy.jdk;

import com.zy.design.proxy.staticProxy.Person;

/**
 * @ClassName MySelf
 * @Description 被代理对象
 * @Author Benny
 * @Date 2018/8/1 0001 9:53
 * @Version 1.0
 **/
public class MySelf implements Person {


    public void getBreakFaster() {
        System.out.println("吃过早餐");
    }

    public void findGirlFriend() {
        System.err.println("急需女票");
    }
}
