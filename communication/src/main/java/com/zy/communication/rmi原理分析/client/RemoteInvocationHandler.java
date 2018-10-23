package com.zy.communication.rmi原理分析.client;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @ClassName RemoteInvocationHandler
 * @Description
 * @Author Benny
 * @Date 2018/9/4 0004 23:57
 * @Version 1.0
 **/
public class RemoteInvocationHandler implements InvocationHandler {
    private String host;
    private int port;
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.setClassName(method.getDeclaringClass().getName());
        rpcRequest.setMethodName(method.getName());
        rpcRequest.setParameters(args);

        TCPTransport tcpTransport = new TCPTransport(host,port);
        return null;
    }

    public RemoteInvocationHandler(String host, int port) {
        this.port = port;
        this.host = host;
    }
}
