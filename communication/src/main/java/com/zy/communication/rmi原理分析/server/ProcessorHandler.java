package com.zy.communication.rmi原理分析.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;

/**
 * @ClassName ProcessorHandler
 * @Description
 * @Author Benny
 * @Date 2018/9/4 0004 23:33
 * @Version 1.0
 **/
public class ProcessorHandler implements Runnable {
    private Socket socket;
    private Object service;
    @Override
    public void run() {
        ObjectInputStream inputStream = null;
        try {
            inputStream = new ObjectInputStream(socket.getInputStream());
            RpcRequest object = (RpcRequest) inputStream.readObject();
            Object result = invoke(object);

            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            outputStream.writeObject(result);
            outputStream.flush();
            inputStream.close();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    private Object invoke(RpcRequest request) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Object[] parameters = request.getParameters();
        Class<?> [] types = new Class[parameters.length];
        for (int i = 0; i < parameters.length; i++) {
            types[i] = parameters[i].getClass();
        }

        Method method = service.getClass().getMethod(request.getMethodName(), types);
        return method.invoke(service, parameters);


    }

    public ProcessorHandler(Socket socket, Object service) {
        this.service = service;
        this.socket = socket;
    }
}
