package com.zy.multithreading.demo.lock;

/**
 * @ClassName LockThreadDemo
 * @Description
 * @Author Benny
 * @Date 2018/10/4 0004 11:29
 * @Version 1.0
 **/
public class LockThreadDemo implements Runnable {


    @Override
    public void run() {
        LockDemo.put("1", 1);
    }
}
