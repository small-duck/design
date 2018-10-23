package com.zy.design.proxy.custom;

import com.zy.design.factorDesign.base.Cat;

import java.lang.reflect.Method;

/**
 * @ClassName GpInvocationHandler
 * @Description
 * @Author Benny
 * @Date 2018/8/1 0001 12:49
 * @Version 1.0
 **/
public interface GpInvocationHandler {
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable;


}
