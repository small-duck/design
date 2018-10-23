package com.zy.communication.rmi原理分析.server;

import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName RPCServer
 * @Description
 * @Author Benny
 * @Date 2018/9/4 0004 23:30
 * @Version 1.0
 **/
public class RPCServer
{
    private static final ExecutorService EXECUTOR_SERVIC = Executors.newCachedThreadPool();

    public void publisher(final Object service, int port) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);

            while (true) {
                Socket socket = serverSocket.accept();
                EXECUTOR_SERVIC.execute(new ProcessorHandler(socket, service));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
    }
}
