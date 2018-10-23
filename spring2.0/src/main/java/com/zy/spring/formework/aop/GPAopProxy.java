package com.zy.spring.formework.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ClassName GPAopProxy
 * @Description
 * @Author Benny
 * @Date 2018/8/26 0026 20:32
 * @Version 1.0
 **/
public class GPAopProxy implements InvocationHandler {

    private GPAopConfig config;
    private Object target;

    public Object getProxy(Object instance) {
        this.target = instance;
        Class<?> aClass = instance.getClass();
        return Proxy.newProxyInstance(aClass.getClassLoader(), aClass.getInterfaces(), this);

    }

    public void setConfig(GPAopConfig config) {
        this.config = config;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        return null;
    }
}
