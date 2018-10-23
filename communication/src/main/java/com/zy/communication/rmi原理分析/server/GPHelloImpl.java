package com.zy.communication.rmi原理分析.server;

/**
 * @ClassName GPHelloImpl
 * @Description
 * @Author Benny
 * @Date 2018/9/4 0004 23:23
 * @Version 1.0
 **/
public class GPHelloImpl implements GPHello {
    @Override
    public String sayHello(String s) {
        return "hello" + s;
    }

}
