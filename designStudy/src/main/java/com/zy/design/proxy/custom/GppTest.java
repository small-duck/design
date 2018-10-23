package com.zy.design.proxy.custom;

import com.zy.design.proxy.jdk.MySelf;
import com.zy.design.proxy.staticProxy.Person;

import javax.crypto.Cipher;

/**
 * @ClassName GppTest
 * @Description
 * @Author Benny
 * @Date 2018/8/1 0001 14:45
 * @Version 1.0
 **/
public class GppTest {
    public static void main(String[] args) {
        CustomMeipo customMeipo = new CustomMeipo();
        Person instance = (Person) customMeipo.getInstance(new MySelf());
        instance.findGirlFriend();

    }
}
