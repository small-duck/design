package com.zy.multithreading.demo;

import java.util.concurrent.*;

/**
 * @ClassName CallableDemo
 * @Description
 * @Author Benny
 * @Date 2018/10/2 0002 21:29
 * @Version 1.0
 **/
public class CallableDemo implements Callable<String> {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors
                .newFixedThreadPool(1);
        CallableDemo callableDemo = new CallableDemo();
        Future<String> future = executorService.submit(callableDemo);
        System.err.println(future.get());
        executorService.shutdown();

    }


    @Override
    public String call() throws Exception {
        int a=1;
        int b = 2;
        System.out.println(a+b);
        return "执行结果："+(a+b);
    }
}
