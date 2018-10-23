package com.zy.communication.rmi原理分析.client;

import java.lang.reflect.Proxy;

/**
 * @ClassName RpcClentProxy
 * @Description
 * @Author Benny
 * @Date 2018/9/4 0004 23:54
 * @Version 1.0
 **/
public class RpcClentProxy {

    public <T> T createProxy(final Class<T> interfaceCls, final String host, final int port) {
        return (T) Proxy.newProxyInstance(interfaceCls.getClassLoader(),
                new Class[]{interfaceCls}, new RemoteInvocationHandler(host, port));
    }
}
