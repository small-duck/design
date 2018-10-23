package com.zy.design.proxy.jdk;

import com.zy.design.proxy.staticProxy.Person;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ClassName Matchmaker
 * @Description 代理类
 * @Author Benny
 * @Date 2018/8/1 0001 9:55
 * @Version 1.0
 **/
public class Matchmaker implements InvocationHandler {

    private Person person;
    public Object getInstance(Person person) {
        this.person = person;
        Class<? extends Person> clazz = person.getClass();
        Class<?>[] interfaces = clazz.getInterfaces();
        ClassLoader classLoader = clazz.getClassLoader();
        return Proxy.newProxyInstance(classLoader, interfaces, this);
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(person,args);
    }
}
