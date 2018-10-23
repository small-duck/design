package com.zy.multithreading.demo;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName InterruptDemo
 * @Description
 * @Author Benny
 * @Date 2018/10/2 0002 23:19
 * @Version 1.0
 **/
public class InterruptDemo {
    private static int anInt;

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                anInt++;
            }
            System.err.println(Thread.currentThread().isInterrupted());
            Thread.interrupted();
            System.err.println("num :" + anInt);
        }, "interruptDemo");
        thread.start();
        TimeUnit.SECONDS.sleep(1);
        thread.interrupt();

    }
}
