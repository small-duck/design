package com.zy.design.proxy.custom;

import com.zy.design.proxy.staticProxy.Person;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ClassName CustomMeipo
 * @Description
 * @Author Benny
 * @Date 2018/8/1 0001 14:40
 * @Version 1.0
 **/

public class CustomMeipo implements GpInvocationHandler {
    private Person target;
    public Object getInstance(Person target) {
        this.target = target;
        Class<? extends Person> clazz = target.getClass();
        return GPproxy.newProxyInstance(new GPClassLoad(), clazz.getInterfaces(), this);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(target, args);
    }
}
