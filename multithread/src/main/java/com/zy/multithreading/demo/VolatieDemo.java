package com.zy.multithreading.demo;

/**
 * @ClassName VolatieDemo
 * @Description
 * @Author Benny
 * @Date 2018/10/2 0002 23:34
 * @Version 1.0
 **/
public class VolatieDemo {
    private volatile static boolean stop = false;

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            int i = 0;
            while (!stop) {
                i++;
            }
            System.err.println(i);
        });

        thread.start();
        System.err.println("begin start thread");
        Thread.sleep(10);
        stop = true;

    }
}
