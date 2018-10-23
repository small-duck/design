package com.zy.multithreading.demo.CountDownLatchDemo;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName CountDown
 * @Description
 * @Author Benny
 * @Date 2018/10/4 0004 17:43
 * @Version 1.0
 **/
public class CountDown {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
//        executorService.execute();
        CountDownLatch countDownLatch = new CountDownLatch(4);
        new Thread(()->{
            System.err.println("t1");
            countDownLatch.countDown();

        },"t1").start();



        new Thread(()->{
            System.err.println("t2");

            countDownLatch.countDown();

        },"t2").start();

        new Thread(()->{
            System.err.println("t3");

            countDownLatch.countDown();

        },"t3").start();
        countDownLatch.await();
        System.err.println("所有线程执行完毕！");

    }
}
