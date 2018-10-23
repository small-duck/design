package com.zy.multithreading.demo.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName AtomicDemo
 * @Description
 * @Author Benny
 * @Date 2018/10/4 0004 11:16
 * @Version 1.0
 **/
public class AtomicDemo {
    private static int count = 0;
    static Lock lock = new ReentrantLock();
    public static void inc(){
        lock.lock();
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count++;
        lock.unlock();
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            new Thread(()->{
                AtomicDemo.inc();
            }).start();
        }
        Thread.sleep(3000);
        System.err.println("result:"+count);


    }
}
