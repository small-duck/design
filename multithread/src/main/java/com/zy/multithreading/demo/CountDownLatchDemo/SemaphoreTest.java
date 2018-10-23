package com.zy.multithreading.demo.CountDownLatchDemo;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName SemaphoreTest
 * @Description
 * @Author Benny
 * @Date 2018/10/4 0004 18:56
 * @Version 1.0
 **/
public class SemaphoreTest {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(5);
        for (int i = 0; i < 5; i++) {
            new Car(i,semaphore).start();
        }
    }

    static class Car extends Thread{
        private int num;
        private Semaphore semaphore;

        public Car(int num, Semaphore semaphore) {
            this.num = num;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {

            try {
                semaphore.acquire();
                System.err.println("第"+num+"占用一个停车位");
                TimeUnit.SECONDS.sleep(2);
                System.err.println("第"+num+"走了");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
