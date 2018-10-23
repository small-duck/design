package com.zy.multithreading.demo;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName ThreadStatus
 * @Description
 * @Author Benny
 * @Date 2018/10/2 0002 23:07
 * @Version 1.0
 **/
public class ThreadStatus {
    public static void main(String[] args) {
        new Thread(()->{

            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        },"timewaiting").start();

        new Thread(() -> {
            while (true) {
                synchronized (ThreadStatus.class) {
                    try {
                        ThreadStatus.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "waiting").start();

        new Thread(new BlockDemo(),"BlockDemo-01").start();
        new Thread(new BlockDemo(), "BlockDemo-02").start();

    }

    static class BlockDemo extends Thread{
        @Override
        public void run() {
            synchronized (BlockDemo.class) {
                while (true) {
                    try {
                        TimeUnit.SECONDS.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        }
    }
}
