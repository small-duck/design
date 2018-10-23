package com.zy.impl;

import com.zy.api.IGDubbo;

/**
 * @ClassName IgDubboImpl
 * @Description
 * @Author Benny
 * @Date 2018/9/11 0011 0:03
 * @Version 1.0
 **/
public class IgDubboImpl implements IGDubbo {
    @Override
    public String sayHello(String mes) {
        return "hello ,this is dubbo test"+mes;
    }
}
