package com.zy.design.single.unhunger;

import com.zy.design.single.register.BeanFactory;

import java.util.concurrent.CountDownLatch;

public class BeanFactoryTest {
    public static void main(String[] args) {
        int count = 2000;
        final CountDownLatch latch = new CountDownLatch(count);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            new Thread(){
                @Override
                public void run() {
                    try {
                        try {
                            latch.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        Object initialize = BeanFactory.getInitialize("com.zy.design.single.unhunger.pojo");
                        System.err.println(System.currentTimeMillis() + "-----" + initialize);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }.start();
            latch.countDown();
        }

        long end = System.currentTimeMillis();
        System.out.println("总耗时：" + (end - startTime));
    }
}
