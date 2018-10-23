package com.zy.design.proxy.staticProxy;

/**
 * @ClassName ProxyPerson
 * @Description TODO
 * @Author Administrator
 * @Date 2018/8/1 0001 9:44
 * @Version 1.0
 **/
public class ProxyPerson {
    private Person person;

    public ProxyPerson(Person person) {
        this.person = person;

    }

    public void getBreakFirst() {
        person.getBreakFaster();
    }
}
